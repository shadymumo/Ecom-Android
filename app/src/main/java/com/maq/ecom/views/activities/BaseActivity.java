package com.maq.ecom.views.activities;

import android.annotation.SuppressLint;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.maq.ecom.R;


/**
 * developed by irfan A.
 */

public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView toolbarTitle;

    @Override
    public void setContentView(int view) {
        super.setContentView(view);
        init(view);
        setupToolbar();
    }


    @SuppressLint("InflateParams")
    private void init(int view) {
        LinearLayout fullLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout frameLayout = fullLayout.findViewById(R.id.baseActToolbar_frame);
        getLayoutInflater().inflate(view, frameLayout, true);
        super.setContentView(fullLayout);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.base_toolbar);
        toolbarTitle = toolbar.findViewById(R.id.base_toolbar_title);
        setSupportActionBar(toolbar);
        //set back button on toolbar
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back)); //default
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    /**
     * set toolbar title
     *
     * @param title
     */
    protected void setupToolbar(int title) {
        toolbarTitle.setText(title);
    }

    /**
     * set toolbar title
     *
     * @param title
     */
    protected void setupToolbar(String title) {
        toolbarTitle.setText(title);
    }

    /**
     * set toolbar title & navigation icon
     *
     * @param title
     * @param drawable
     */
    protected void setupToolbar(int title, int drawable) {
        toolbarTitle.setText(title);
        if (drawable != -1) toolbar.setNavigationIcon(getResources().getDrawable(drawable));
    }

    /**
     * set toolbar title & navigation icon
     *
     * @param title
     * @param drawable
     */
    protected void setupToolbar(String title, int drawable) {
        toolbarTitle.setText(title);
        if (drawable != -1) toolbar.setNavigationIcon(getResources().getDrawable(drawable));
    }

}