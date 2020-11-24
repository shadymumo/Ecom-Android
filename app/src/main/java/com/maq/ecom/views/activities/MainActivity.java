package com.maq.ecom.views.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.maq.ecom.R;
import com.maq.ecom.database.SessionManager;
import com.maq.ecom.helper.Utils;
import com.theartofdev.edmodo.cropper.CropImage;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Context context = this;
    AppBarConfiguration mAppBarConfiguration;
    public MenuItem menuItemSync;
    SessionManager sessionManager = new SessionManager(this);
    NavigationView navigationView;
    public static String visibleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupDrawer();
        setupBottomNavView();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }


    private void setupDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_categories, R.id.nav_items, R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();

        //inflating nav header layout
        View headerView = navigationView.getHeaderView(0);
        CircleImageView iv_photo = headerView.findViewById(R.id.nav_header_civ_photo);
        TextView tv_userName = headerView.findViewById(R.id.nav_header_name);
        TextView tv_userMobile = headerView.findViewById(R.id.nav_header_mob);
        Utils.loadProfileImage(context, sessionManager.getProfileImg(), iv_photo);
        tv_userName.setText(sessionManager.getUserName());
        tv_userMobile.setText(sessionManager.getUserMobile());

    }

    private void setupBottomNavView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_nav_view);
        BottomNavigationView bottomNavigationViewAdmin = findViewById(R.id.btm_nav_view_admin);

        if (sessionManager.isAdmin()) {
            bottomNavigationView.setVisibility(View.INVISIBLE);
            bottomNavigationViewAdmin.setVisibility(View.VISIBLE);
        } else {
            bottomNavigationView.setVisibility(View.VISIBLE);
            bottomNavigationViewAdmin.setVisibility(View.INVISIBLE);
        }

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        if (sessionManager.isAdmin()) {
            NavigationUI.setupWithNavController(bottomNavigationViewAdmin, navController);
        } else NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null); //to get original colors of nav icons

        //drawer menu items
//        Menu menu =navigationView.getMenu();
//        MenuItem navCrateStatement = menu.findItem(R.id.nav_crate_statement);
//        if (!sessionManager.isAdmin()){
//            navCrateStatement.setVisible(false);
//        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case R.id.nav_place_order:
//                Utils.navigateTo(context, PlaceOrderActivity.class);
//                break;
//            case R.id.nav_send_receipt:
//                Utils.navigateTo(context, SendReceiptPage.class);
//                break;
//            case R.id.nav_send_crate:
//                Utils.navigateTo(context, SendCratePage.class);
//                break;
//            case R.id.nav_order_history:
//                Utils.navigateTo(context, OrderHistoryPage.class);
//                break;
//            case R.id.nav_receipt_history:
//                if (!sessionManager.isAdmin())
//                    Utils.navigateTo(context, MyTransactionsActivity.class);
//                else Utils.navigateTo(context, MyTransactionsAdmin.class);
//                break;
//            case R.id.nav_crate_history:
//                Utils.navigateTo(context, CratesActivity.class);
//                break;
//            case R.id.nav_account_statement:
//                Utils.navigateTo(context, StatementsPage.class);
//                break;
//            case R.id.nav_crate_statement:
//                if (!sessionManager.isAdmin())
//                    Utils.navigateTo(context, CrateStActivity.class);
//                else Utils.navigateTo(context, CrateStAdminActivity.class);
//                break;
            case R.id.nav_logout:
                new AlertDialog.Builder(context)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Logout", ((dialogInterface, i) -> {
                            sessionManager.clearSharedPref(); //del pref data
                            Utils.navigateClearTo(context, LoginActivity.class);
                        }))
                        .setNegativeButton("No", null)
                        .show();
                break;
        }


        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //ImagePicker result
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                assert result != null;
                Uri resultUri = result.getUri();
                Intent intent = new Intent();
                intent.setAction("getCroppedImgURI");
                intent.putExtra("URI", String.valueOf(resultUri));
                sendBroadcast(intent);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Utils.showSnackBar(this, String.valueOf(result.getError()));
            }
        }
    }
}