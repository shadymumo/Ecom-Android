package com.maq.ecom.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.maq.ecom.R;

import butterknife.ButterKnife;

public class CategoriesFragment extends Fragment /*implements RetrofitRespondListener, OrderStatusChange*/ {

//    SessionManager sessionManager;
//    LoadingDialog loadingDialog;
//    List<Order> arrayList = new ArrayList<>();
//    List<Customer> listCustomer = new ArrayList<>();
//    List<Customer> listRoute = new ArrayList<>();
//    boolean isSendEnabled = false;
//    CountDownTimer timer;
//    String selectedCustomerCode = "All";
//    String fromDate, toDate, currentDate;
//    String filterBy = "CustomerCode";
//    String selectedStatus = "All";
//    int pendingCount, successCount, failedCount;
//    double pendingAmt, successAmt, failedAmt;
//
//    /**
//     * RadioGroup
//     */
//    @BindView(R.id.radioGroup_filterBy)
//    RadioGroup radioGroup_filter;
//
//    /**
//     * ImageView
//     */
//    @BindView(R.id.orderFrag_iv_userImg)
//    CircleImageView iv_userImg;
//
//    @BindView(R.id.orderFrag_layout_all)
//    LinearLayout layoutCustomers;
//
//    /**
//     * Spinner
//     */
//    @BindView(R.id.orderFrag_spinner)
//    SearchableSpinner spinner;
//
//
//    @OnClick(R.id.orderFrag_iv_run)
//    void reloadRecord() {
//        fromDate = tv_fromDate.getText().toString();
//        toDate = tv_toDate.getText().toString();
//        fetchOrdersOffline();
//        Utils.showSnackBar(getActivity(), "Record fetched successfully!");
//    }
//
//    @OnClick(R.id.orderFrag_iv_exportPdf)
//    void exportPdf() {
//        generatePDF();
//    }
//
//    /**
//     * RecyclerView
//     */
//    @BindView(R.id.orderFrag_rv)
//    RecyclerView recyclerView;
//
//    /**
//     * TextView
//     */
//    @BindView(R.id.orderFrag_tv_noOrder)
//    TextView tv_noOrder;
//    @BindView(R.id.orderFrag_tv_currentDate)
//    TextView tv_currentDate;
//    @BindView(R.id.orderFrag_iv_userName)
//    TextView tv_userName;
//    @BindView(R.id.orderFrag_iv_userMob)
//    TextView tv_userMob;
//    @BindView(R.id.orderFrag_tv_fromDate)
//    TextView tv_fromDate;
//    @BindView(R.id.orderFrag_tv_toDate)
//    TextView tv_toDate;
//    @BindView(R.id.orderFrag_tv_pendingAmt)
//    TextView tv_pendingAmt;
//    @BindView(R.id.orderFrag_tv_pendingCount)
//    TextView tv_pendingCount;
//    @BindView(R.id.orderFrag_tv_successAmt)
//    TextView tv_successAmt;
//    @BindView(R.id.orderFrag_tv_successCount)
//    TextView tv_successCount;
//    @BindView(R.id.orderFrag_tv_failedAmt)
//    TextView tv_failedAmt;
//    @BindView(R.id.orderFrag_tv_failedCount)
//    TextView tv_failedCount;
//    @BindView(R.id.orderFrag_tv_totalAmt)
//    TextView tv_totalAmt;
//    @BindView(R.id.orderFrag_tv_totalCount)
//    TextView tv_totalCount;
//
//    @BindView(R.id.orderFrag_layout_fromDate)
//    CardView layoutFromDate;
//    @BindView(R.id.orderFrag_layout_toDate)
//    CardView layoutToDate;
//
//    @BindView(R.id.filterPending)
//    LinearLayout filterPending;
//    @BindView(R.id.filterSuccess)
//    LinearLayout filterSuccess;
//    @BindView(R.id.filterFailed)
//    LinearLayout filterFailed;
//    @BindView(R.id.filterTotal)
//    LinearLayout filterTotal;

    @Override
    public void onResume() {
        super.onResume();
//        fetchOrders();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        setHasOptionsMenu(true); //toolbar item click
        ButterKnife.bind(this, root);
//        init();
//        listener();
//        fetchCustomers();
//        fetchRoutes();

        return root;
    }

//
//    @SuppressLint("SetTextI18n")
//    private void init() {
//        loadingDialog = new LoadingDialog(getActivity());
//        sessionManager = new SessionManager(getActivity());
//
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
////        linearLayoutManager.setReverseLayout(true);
////        recyclerView.setLayoutManager(linearLayoutManager);
//
//        currentDate = toDate = fromDate = Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy-MM-dd");
//
//        Utils.loadProfileImage(getActivity(), "image/" + sessionManager.getProfileImg(), iv_userImg);
//        tv_currentDate.setText(currentDate);
//        tv_fromDate.setText(currentDate);
//        tv_toDate.setText(currentDate);
//        tv_userName.setText(sessionManager.getUserName());
//        tv_userMob.setText("Mob: " + sessionManager.getUserMobile());
//
//
//    }
//
//
//    private void listener() {
//        layoutFromDate.setOnClickListener(v -> new CustomDatePicker(getActivity(), tv_fromDate));
//        layoutToDate.setOnClickListener(v -> new CustomDatePicker(getActivity(), tv_toDate));
//
//        radioGroup_filter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                int radioBtnId = radioGroup.getCheckedRadioButtonId();
//                if (radioBtnId == R.id.radio_partyWise) {
//                    filterBy = "CustomerCode";
//                    setupCustomerSpinner(listCustomer);
//                } else {
//                    filterBy = "CityName";
//                    Log.e("===>", "route: " + listRoute.size());
//                    setupCustomerSpinner(listRoute);
//                }
//            }
//        });
//
//        filterPending.setOnClickListener(view -> updateAdapter(multipleFilter("Pending")));
//        filterSuccess.setOnClickListener(view -> updateAdapter(multipleFilter("Success")));
//        filterFailed.setOnClickListener(view -> updateAdapter(multipleFilter("Failed")));
//        filterTotal.setOnClickListener(view -> updateAdapter(arrayList));
//
//    }
//
//    public void fetchOrders() {
//        if (!Utils.isTodaysDate(sessionManager.getOrderHistAdminLastFetched())) {
//            fetchOrdersOnline();
//        } else fetchOrdersOffline();
//    }
//
//    private void fetchOrdersOnline() {
//        loadingDialog.show();
//        Call<JsonObject> apiCall = RetrofitClient.getRetrofitInstance(getActivity()).create(ApiConfig.class)
//                .API_myOrdersAdmin(sessionManager.getFirmId(), "All", "2020-01-01", toDate, "All", "All");
//        RetrofitClient.callRetrofit(apiCall, "ORDERS", this);
//    }
//
//    private void fetchCustomers() {
//        if (!Utils.isTodaysDate(sessionManager.getCustomerLastFetched())) {
//            fetchCustomersOnline();
//        } else fetchCustomersOffline();
//    }
//
//    private void fetchCustomersOnline() {
//        loadingDialog.show();
//        Call<JsonObject> apiCall = RetrofitClient.getRetrofitInstance(getActivity()).create(ApiConfig.class)
//                .API_customers(sessionManager.getFirmId());
//        RetrofitClient.callRetrofit(apiCall, "CUSTOMERS", this);
//    }
//
//
//    private void fetchRoutes() {
//        if (!Utils.isTodaysDate(sessionManager.getRouteLastFetched())) {
//            fetchRoutesOnline();
//        } else fetchRoutesOffline();
//    }
//
//
//    private void fetchRoutesOnline() {
//        loadingDialog.show();
//        Call<JsonObject> apiCall = RetrofitClient.getRetrofitInstance(getActivity()).create(ApiConfig.class)
//                .API_allRoute(sessionManager.getFirmId());
//        RetrofitClient.callRetrofit(apiCall, "ROUTES", this);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_sync: {
//                fetchOrdersOnline();
//                fetchCustomersOnline();
//                fetchRoutesOnline();
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
//            case "ORDERS":
//                try {
//                    callback(response);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case "CUSTOMERS":
//                try {
//                    callbackCustomer(response);
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
//        }
//
//        loadingDialog.dismiss();
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
//            JSONObject jsonObject = new JSONObject(response.body().toString());
//            if (jsonObject.getString("error").equals("false")) {
//                if (jsonObject.has("allpayments")) {
//                    JSONArray jsonArray = jsonObject.getJSONArray("allpayments");
//                    if (jsonArray.length() > 0) {
//                        tv_noOrder.setVisibility(View.INVISIBLE);
//                        SQLiteManager dbManager = new SQLiteManager(getActivity());
//                        dbManager.open();
//                        dbManager.deleteTableRecord(SQLiteHelper.TABLE_ORDER_HISTORY_ADMIN);
//
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject object = jsonArray.getJSONObject(i);
//                            String orderId = object.getString("OrderId");
//                            String orderDate = object.getString("OrderDate");
//                            String orderAmount = object.getString("OrderAmount");
//                            String nag = object.getString("Nag");
//                            String crate = object.getString("Crate");
//                            String weight = object.getString("Weight");
//                            String status = object.getString("Status");
//                            String milk = object.getString("Milk");
//                            String dahi = object.getString("Dahi");
//                            String customerCode = object.getString("CustomerCode");
//                            String customerName = object.getString("CustomerName");
//                            String route = object.getString("Route");
//
////                            arrayList.add(new Order(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route));
//                            //insert to SQLite
//                            dbManager.insertOrderHistoryAdmin(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route, fromDate, toDate);
//                        }
//                        dbManager.close();
//                        sessionManager.setOrderHistAdminLastFetched(Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy/MM/dd"));
//
//                    } else tv_noOrder.setVisibility(View.VISIBLE);
//                    fetchOrdersOffline();
//
////                    updateAdapter(arrayList);
//
//                }
//
////                if (jsonObject.has("allpayments2")) {
////                    JSONArray jsonArray = jsonObject.getJSONArray("allpayments2");
////                    resetSummary();
////                    if (jsonArray.length() > 0) {
////                        String pendingCount = "0", pendingAmt = "0.0", successCount = "0", successAmt = "0.0", failedCount = "0", failedAmt = "0.0";
////                        for (int i = 0; i < jsonArray.length(); i++) {
////                            JSONObject object = jsonArray.getJSONObject(i);
////                            switch (object.getString("Status")) {
////                                case "Pending": {
////                                    pendingCount = object.getString("Count");
////                                    pendingAmt = object.getString("Amount");
////                                    tv_pendingCount.setText("(" + pendingCount + ")");
////                                    tv_pendingAmt.setText(getActivity().getResources().getString(R.string.IND_symbol) + pendingAmt);
////                                }
////                                break;
////
////                                case "Success": {
////                                    successCount = object.getString("Count");
////                                    successAmt = object.getString("Amount");
////                                    tv_successCount.setText("(" + successCount + ")");
////                                    tv_successAmt.setText(getActivity().getResources().getString(R.string.IND_symbol) + successAmt);
////                                }
////                                break;
////
////                                case "Failed": {
////                                    failedCount = object.getString("Count");
////                                    failedAmt = object.getString("Amount");
////                                    tv_failedCount.setText("(" + failedCount + ")");
////                                    tv_failedAmt.setText(getActivity().getResources().getString(R.string.IND_symbol) + failedAmt);
////                                }
////                                break;
////                            }
////                        }
////
////                        tv_totalCount.setText("(" + (Integer.parseInt(failedCount) + Integer.parseInt(pendingCount) + Integer.parseInt(successCount)) + ")");
////                        tv_totalAmt.setText(getActivity().getResources().getString(R.string.IND_symbol) + ((Double.parseDouble(failedAmt) + Double.parseDouble(pendingAmt) + Double.parseDouble(successAmt))));
////
////                    } else resetSummary();
////
////
////                }
//
//            }
//        } else Utils.showToast(getActivity(), String.valueOf(responseCode));
//    }
//
//
//    private void fetchOrdersOffline() {
//        arrayList = new ArrayList<>();
//        arrayList.clear();
//
//        pendingCount = 0;
//        successCount = 0;
//        failedCount = 0;
//        pendingAmt = 0.0;
//        successAmt = 0.0;
//        failedAmt = 0.0;
//
//        SQLiteManager sqLiteManager = new SQLiteManager(getActivity());
//        sqLiteManager.open();
//        Cursor cursor = sqLiteManager.fetchOrderHistoryAdmin();
//
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            String orderId = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_ID_ADMIN));
//            String orderDate = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_DATE_ADMIN));
//            String orderAmount = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_AMT_ADMIN));
//            String nag = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_NAG_ADMIN));
//            String crate = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_CRATE_ADMIN));
//            String weight = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_WEIGHT_ADMIN));
//            String status = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_STATUS_ADMIN));
//            String milk = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_MILK_ADMIN));
//            String dahi = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_DAHI_ADMIN));
//            String customerCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_CUST_CODE_ADMIN));
//            String customerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_CUST_NAME_ADMIN));
//            String route = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ORDER_ROUTE_ADMIN));
////             fromDate = cursor.getString(cursor.getColumnIndex(SQLiteHelper.FROM_DATE));
////             toDate = cursor.getString(cursor.getColumnIndex(SQLiteHelper.TO_DATE));
////            tv_fromDate.setText(fromDate);
////            tv_toDate.setText(toDate);
//
//
//            if (Utils.isDateAfter(this.fromDate, orderDate) && Utils.isDateBefore(this.toDate, orderDate)) {
//                if (filterBy.equals("CustomerCode")) {
//                    if (selectedCustomerCode.equals("All")) {
//                        arrayList.add(new Order(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route));
//                        updateSummary(status, orderAmount);
//                    } else if (selectedCustomerCode.equals(customerCode)) {
//                        arrayList.add(new Order(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route));
//                        updateSummary(status, orderAmount);
//                    }
//                } else if (filterBy.equals("CityName")) {
//                    if (selectedCustomerCode.equals("All")) {
//                        arrayList.add(new Order(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route));
//                        updateSummary(status, orderAmount);
//                    } else if (selectedCustomerCode.equals(route)) {
//                        arrayList.add(new Order(orderId, orderDate, orderAmount, nag, crate, weight, status, milk, dahi, customerCode, customerName, route));
//                        updateSummary(status, orderAmount);
//                    }
//                }
//            }
//
//            cursor.moveToNext();
//        }
//
//        if (arrayList.size() > 0) {
//            tv_noOrder.setVisibility(View.GONE);
//        } else tv_noOrder.setVisibility(View.VISIBLE);
//
//        updateAdapter(arrayList);
//        resetSummary();
//    }
//
//    private void updateSummary(String status, String orderAmount) {
//        //summary
//        if (status.equalsIgnoreCase("pending")) {
//            pendingCount++;
//            pendingAmt = pendingAmt + Double.parseDouble(orderAmount);
//        } else if (status.equalsIgnoreCase("success")) {
//            successCount++;
//            successAmt = successAmt + Double.parseDouble(orderAmount);
//        } else if (status.equalsIgnoreCase("failed")) {
//            failedCount++;
//            failedAmt = failedAmt + Double.parseDouble(orderAmount);
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private void resetSummary() {
//        tv_failedCount.setText("(" + failedCount + ")");
//        tv_failedAmt.setText(String.valueOf(failedAmt));
//        tv_pendingCount.setText("(" + pendingCount + ")");
//        tv_pendingAmt.setText(String.valueOf(pendingAmt));
//        tv_successCount.setText("(" + successCount + ")");
//        tv_successAmt.setText(String.valueOf(successAmt));
//        tv_totalCount.setText("(" + (pendingCount + successCount + failedCount) + ")");
//        tv_totalAmt.setText(String.valueOf(failedAmt + pendingAmt + successAmt));
//    }
//
//    private void callbackCustomer(Response<?> response) throws JSONException {
//        JSONObject jsonObject = new JSONObject(response.body().toString());
//        if (jsonObject.getString("error").equals("false")) {
//            if (jsonObject.has("allcustomers")) {
//                listCustomer.clear();
//                JSONArray jsonArray = jsonObject.getJSONArray("allcustomers");
//                if (jsonArray.length() > 0) {
//                    //sqlite
//                    SQLiteManager dbManager = new SQLiteManager(getActivity());
//                    dbManager.open();
//                    dbManager.deleteTableRecord(SQLiteHelper.TABLE_CUSTOMER);
//
//                    listCustomer.add(new Customer("All", "All", "0", "0", "","CustomerCode"));
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject object = jsonArray.getJSONObject(i);
//                        String customerCode = object.getString("CustomerCode");
//                        String customerName = object.getString("CustomerName");
//                        String openingBalance = object.getString("OpeningBalance");
//                        String openingCrt = object.getString("OpeningCrt");
//                        String address = object.getString("Address");
//
//                        listCustomer.add(new Customer(customerCode, customerName, openingBalance, openingCrt, address,"CustomerCode"));
//                        //insert to SQLite
//                        dbManager.insertCustomer(customerCode, customerName, openingBalance, openingCrt,address);
//                    }
//                    dbManager.close();
//                    sessionManager.setCustomerLastFetched(Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy/MM/dd"));
//
//                    setupCustomerSpinner(listCustomer);
//                }
//            }
//
//
//        }
//
//    }
//
//    private void fetchCustomersOffline() {
//        SQLiteManager sqLiteManager = new SQLiteManager(getActivity());
//        sqLiteManager.open();
//        Cursor cursor = sqLiteManager.fetchCustomers();
//
//        listCustomer.clear(); //clear array
//        listCustomer.add(new Customer("All", "All", "0", "0", "","CustomerCode"));
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            String id = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ID));
//            String customerCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper.CUSTOMER_CODE));
//            String customerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper.CUSTOMER_NAME));
//            String openingBalance = cursor.getString(cursor.getColumnIndex(SQLiteHelper.CUSTOMER_OPENING_BALANCE));
//            String openingCrt = cursor.getString(cursor.getColumnIndex(SQLiteHelper.CUSTOMER_OPENING_CRT));
//            String address = cursor.getString(cursor.getColumnIndex(SQLiteHelper.CUSTOMER_ADDRESS));
//
//            listCustomer.add(new Customer(customerCode, customerName, openingBalance, openingCrt, address,null));
//            cursor.moveToNext();
//        }
//
//        setupCustomerSpinner(listCustomer);
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
//                    //sqlite
//                    SQLiteManager dbManager = new SQLiteManager(getActivity());
//                    dbManager.open();
//                    dbManager.deleteTableRecord(SQLiteHelper.TABLE_ROUTE);
//
//                    listRoute.add(new Customer("All", "CityName"));
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject object = jsonArray.getJSONObject(i);
//                        String route = object.getString("CityName");
//
//                        listRoute.add(new Customer(route, "CityName"));
//                        //insert to SQLite
//                        dbManager.insertRoute(route);
//
//                    }
//                    dbManager.close();
//                    sessionManager.setRouteLastFetched(Utils.formatDateTimeFromTS(Utils.getSysTimeStamp(), "yyyy/MM/dd"));
//
//                }
//            }
//
//
//        }
//
//    }
//
//    private void fetchRoutesOffline() {
//        SQLiteManager sqLiteManager = new SQLiteManager(getActivity());
//        sqLiteManager.open();
//        Cursor cursor = sqLiteManager.fetchRoutes();
//
//        listRoute.clear(); //clear array
//        listRoute.add(new Customer("All", "CityName"));
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            String route = cursor.getString(cursor.getColumnIndex(SQLiteHelper.ROUTE));
//
//            listRoute.add(new Customer(route, "CityName"));
//            cursor.moveToNext();
//        }
//    }
//
//
//    private void setupCustomerSpinner(List<Customer> listCustomer) {
//        layoutCustomers.setVisibility(View.VISIBLE);
//
//        spinner.setTitle("Select One");
//        spinner.setPositiveButton("Close");
//        spinner.setAdapter(new CustomerSpinnerAdapter(getActivity(), R.layout.item_spinner, listCustomer, filterBy));
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Customer model = (Customer) adapterView.getSelectedItem();
//                if (filterBy.equals("CustomerCode"))
//                    selectedCustomerCode = model.getCustomerCode();
//                else selectedCustomerCode = model.getRoute();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
//
//    private void updateAdapter(List<Order> list) {
//        recyclerView.setAdapter(new OrdersAdminAdapter(getActivity(), list, this));
//    }
//
//    public List<Order> multipleFilter(String filterStatus) {
//        List<Order> listAfterFiltering = new ArrayList<>();
//        for (Order resultObj : arrayList) {
//            String status = resultObj.getStatus();
//
//            if (filterStatus.equals(status) || filterStatus.isEmpty()) {
//                listAfterFiltering.add(resultObj);
//            }
//        }
//
//        return listAfterFiltering;
//    }
//
//    @Override
//    public void onOrderStatusChange() {
//        fetchOrdersOnline();
//    }
//

}