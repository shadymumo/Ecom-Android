package com.maq.ecom.views.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.maq.ecom.R;
import com.maq.ecom.database.SessionManager;
import com.maq.ecom.helper.LoadingDialog;
import com.maq.ecom.helper.Utils;
import com.maq.ecom.interfaces.ApiConfig;
import com.maq.ecom.interfaces.RetrofitRespondListener;
import com.maq.ecom.model.Customer;
import com.maq.ecom.networking.RetrofitClient;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends Fragment {


//    SessionManager sessionManager;
//    LoadingDialog loadingDialog;
//    List<Customer> listRoute = new ArrayList<>();
//    String date, customerCode, route;
//
//    /**
//     * Spinner
//     */
//    @BindView(R.id.dashboardFragP_spinner)
//    SearchableSpinner spinner;
//
//    @BindView(R.id.dashboardFragP_spinnerLayout)
//    CardView routeLayout;
//
//
//    /**
//     * ImageView
//     */
//    @BindView(R.id.dashboardFragP_iv_userImg)
//    CircleImageView iv_userImg;
//    @BindView(R.id.ic_calendar)
//    AppCompatImageView tv_calendar;
//
//    /**
//     * TextView
//     */
//    @BindView(R.id.dashboardFragP_tv_uerName)
//    TextView tv_userName;
//    @BindView(R.id.dashboardFragP_tv_uerMob)
//    TextView tv_userMob;
//    @BindView(R.id.dashboardFragP_tv_uerCity)
//    TextView tv_userCity;
//    @BindView(R.id.dashboardFragP_tv_currentDate)
//    TextView tv_currentDate;
//    @BindView(R.id.dashboardFragP_tv_accOpening)
//    TextView tv_accOpening;
//    @BindView(R.id.dashboardFragP_tv_accBill)
//    TextView tv_accBill;
//    @BindView(R.id.dashboardFragP_tv_accRecv)
//    TextView tv_accRecv;
//    @BindView(R.id.dashboardFragP_tv_accBal)
//    TextView tv_accBal;
//    @BindView(R.id.dashboardFragP_tv_crtOpening)
//    TextView tv_crtOpening;
//    @BindView(R.id.dashboardFragP_tv_crtBill)
//    TextView tv_crtBill;
//    @BindView(R.id.dashboardFragP_tv_crtRecv)
//    TextView tv_crtRecv;
//    @BindView(R.id.dashboardFragP_tv_crtBal)
//    TextView tv_crtBal;
//
//    @BindView(R.id.orderAdminItem_tv_odrAmt)
//    TextView tv_odrAmt;
//    @BindView(R.id.orderAdminItem_tv_odrMilk)
//    TextView tv_odrMilk;
//    @BindView(R.id.orderAdminItem_tv_odrDahi)
//    TextView tv_odrDahi;
//    @BindView(R.id.orderAdminItem_tv_odrOther)
//    TextView tv_odrOther;
//    @BindView(R.id.orderAdminItem_odrNag)
//    TextView tv_odrNag;
//    @BindView(R.id.orderAdminItem_odrCrate)
//    TextView tv_odrCrate;
//    @BindView(R.id.orderAdminItem_odrWeight)
//    TextView tv_odrWeight;
//    @BindView(R.id.dashboardFragP_tv_lastFetchedDate)
//    TextView tv_lastFetchedDate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        setHasOptionsMenu(true); //toolbar item click
        ButterKnife.bind(this, root);
//        init();
//        fetchSummary();
//
//        if (sessionManager.isAdmin())
//            fetchRoutes();

        return root;
    }

//
//    @SuppressLint("SetTextI18n")
//    private void init() {
//        sessionManager = new SessionManager(getActivity());
//        loadingDialog = new LoadingDialog(getActivity());
//
//        //set user profile info
//        tv_userName.setText(sessionManager.getUserName());
//        tv_userMob.setText("Mobile: " + sessionManager.getUserMobile());
//        tv_userCity.setText("City: " + sessionManager.getUserCity());
//        tv_currentDate.setText(Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "dd-MMM-yyyy"));
//        Utils.loadProfileImage(getActivity(), "image/" + sessionManager.getProfileImg(), iv_userImg);
//
//        //set default data
//        date = Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy-MM-dd");
//        tv_lastFetchedDate.setText(date);
//
//        if (sessionManager.isAdmin()) {
//            customerCode = "All";
//            route = "All";
//        } else {
//            customerCode = sessionManager.getUserMobile();
//            route = "";
//        }
//
//        //choose date here
//        tv_calendar.setOnClickListener(v -> {
//            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//            DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                    date = year + "-" + (month + 1) + "-" + dayOfMonth; //format: "yyyy-MM-dd"
//                    tv_lastFetchedDate.setText(date);
//                    loadingDialog.show();
//                    fetchSummary();
//                }
//            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
////        dialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
//            dialog.show();
//        });
//    }
//
//    private void fetchSummary() {
//        Call<JsonObject> apiCall = RetrofitClient.getRetrofitInstance(getActivity()).create(ApiConfig.class)
//                .API_summary(sessionManager.getFirmId(), customerCode, date, route);
//        RetrofitClient.callRetrofit(apiCall, "SUMMARY", this);
//
//    }
//
//    private void fetchRoutes() {
//        if (!Utils.isTodaysDate(sessionManager.getRouteLastFetched())) {
//            fetchRoutesOnline();
//        }
//    }
//
//    private void fetchRoutesOnline() {
//        loadingDialog.show();
//        Call<JsonObject> apiCall = RetrofitClient.getRetrofitInstance(getActivity()).create(ApiConfig.class)
//                .API_allRoute(sessionManager.getFirmId());
//        RetrofitClient.callRetrofit(apiCall, "ROUTES", this);
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_sync: {
//                if (sessionManager.isAdmin())
//                    fetchRoutesOnline();
//
//                //fetch for both user types
//                fetchSummary();
//                return true;
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    @Override
//    public void onRetrofitSuccess(Response<?> response, String requestName) {
//        switch (requestName) {
//            case "SUMMARY":
//                try {
//                    callback(response);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case "ROUTES":
//                try {
//                    callbackRoutes(response);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                break;
//
//        }
//
//        if (loadingDialog.isShowing())
//            loadingDialog.dismiss();
//
//
//    }
//
//    @Override
//    public void onRetrofitFailure(String responseError, String requestName) {
//        loadingDialog.dismiss();
//        if (responseError.contains(getString(R.string.str_unable_to_resolve_host)))
//            responseError = getString(R.string.str_no_internet);
//
//        Utils.showSnackBar(getActivity(), responseError);
//    }
//
//    @SuppressLint("SetTextI18n")
//    private void callback(Response<?> response) throws JSONException {
//        int responseCode = response.code();
//        if (responseCode == Utils.HTTP_OK) {
//            JSONObject object = new JSONObject(response.body().toString());
//            if (object.getString("error").equals("false")) {
//                if (object.has("allsummary")) {
//                    JSONObject jsonObject = object.getJSONObject("allsummary");
//                    //acc summary
//                    String accOpening = jsonObject.getJSONArray("allopeningaccbalance").getJSONObject(0).getString("OpeningBalance");
//                    if (accOpening.equals("null")) accOpening = "0";
//                    tv_accOpening.setText(getActivity().getResources().getString(R.string.INR_symbol) + accOpening);
//
//                    String accBill = jsonObject.getJSONArray("allbillrecv").getJSONObject(0).getString("Bill");
//                    if (accBill.equals("null")) accBill = "0";
//                    tv_accBill.setText(getActivity().getResources().getString(R.string.INR_symbol) + accBill);
//
//                    String accRecv = jsonObject.getJSONArray("allbillrecv").getJSONObject(0).getString("Receive");
//                    if (accRecv.equals("null")) accRecv = "0";
//                    tv_accRecv.setText(getActivity().getResources().getString(R.string.INR_symbol) + accRecv);
//
//                    String accBal = String.valueOf(Double.parseDouble(accOpening) + Double.parseDouble(accBill) - Double.parseDouble(accRecv));
//                    if (accBal.equals("null")) accBal = "0";
//                    tv_accBal.setText(getActivity().getResources().getString(R.string.INR_symbol) + accBal);
//
//                    //crate summary
//                    String crtOpening = jsonObject.getJSONArray("allopeningcrtbalance").getJSONObject(0).getString("OpeningCrate");
//                    if (crtOpening.equals("null")) crtOpening = "0";
//                    tv_crtOpening.setText(crtOpening);
//
//                    String crtBill = jsonObject.getJSONArray("allcrtbillrecv").getJSONObject(0).getString("Bill");
//                    if (crtBill.equals("null")) crtBill = "0";
//                    tv_crtBill.setText(crtBill);
//
//                    String crtRecv = jsonObject.getJSONArray("allcrtbillrecv").getJSONObject(0).getString("Receive");
//                    if (crtRecv.equals("null")) crtRecv = "0";
//                    tv_crtRecv.setText(crtRecv);
//
//                    String crtBal = String.valueOf(Double.parseDouble(crtOpening) + Double.parseDouble(crtBill) - Double.parseDouble(crtRecv));
//                    if (crtBal.equals("null")) crtBal = "0";
//                    tv_crtBal.setText(crtBal);
//
//                    //order summary
//                    String odrAmt = jsonObject.getJSONArray("allordersummary").getJSONObject(0).getString("OrderAmount");
//                    if (odrAmt.equals("null")) odrAmt = "0";
//                    tv_odrAmt.setText(getActivity().getResources().getString(R.string.INR_symbol) + odrAmt);
//
//                    String odrNag = jsonObject.getJSONArray("allordersummary").getJSONObject(0).getString("Nag");
//                    if (odrNag.equals("null")) odrNag = "0";
//                    tv_odrNag.setText(odrNag);
//
//                    String odrCrate = jsonObject.getJSONArray("allordersummary").getJSONObject(0).getString("Crate");
//                    if (odrCrate.equals("null")) odrCrate = "0";
//                    tv_odrCrate.setText(odrCrate);
//
//                    String odrWeight = jsonObject.getJSONArray("allordersummary").getJSONObject(0).getString("Weight");
//                    if (odrWeight.equals("null")) odrWeight = "0";
//                    tv_odrWeight.setText(odrWeight);
//
//                    String odrMilk = jsonObject.getJSONArray("allordersummary1").getJSONObject(0).getString("Milk");
//                    if (odrMilk.equals("null")) odrMilk = "0";
//                    tv_odrMilk.setText(odrMilk);
//
//                    String odrDahi = jsonObject.getJSONArray("allordersummary1").getJSONObject(0).getString("Dahi");
//                    if (odrDahi.equals("null")) odrDahi = "0";
//                    tv_odrDahi.setText(odrDahi);
//
//                    String odrOther = Utils.RoundTwoDecimals((Double.parseDouble(odrWeight) - Double.parseDouble(odrMilk) - Double.parseDouble(odrDahi)));
//                    if (odrOther.equals("null")) odrOther = "0";
//                    tv_odrOther.setText(odrOther);
//
//                }
//            } else Utils.showToast(getActivity(), String.valueOf(responseCode));
//        }
//
//    }
//
//    private void callbackRoutes(Response<?> response) throws JSONException {
//        JSONObject jsonObject = new JSONObject(response.body().toString());
//        Log.e("===>", "jsonObject: " + jsonObject);
//        if (jsonObject.getString("error").equals("false")) {
//            if (jsonObject.has("allroute")) {
//                listRoute.clear();
//                JSONArray jsonArray = jsonObject.getJSONObject("allroute").getJSONArray("allroute");
//                if (jsonArray.length() > 0) {
//
//                    listRoute.add(new Customer("All", "CityName"));
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject object = jsonArray.getJSONObject(i);
//                        String route = object.getString("CityName");
//
//                        listRoute.add(new Customer(route, "CityName"));
//
//                    }
//                    sessionManager.setRouteLastFetched(Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy/MM/dd"));
//
//                }
//            }
//
//
//        }
//
//    }



}