package com.maq.ecom.interfaces;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * This interface contains all API End Points used in Retrofit.
 */

public interface ApiConfig {

    @POST("user.php?action=login")
    Call<JsonObject> API_requestLogin(@Query("Mobile") String mobile,
                                      @Query("Password") String password,
                                      @Query("isAdmin") String isAdmin);

    @POST("user.php?action=forgetpwd")
    Call<JsonObject> API_forgotPassword(@Query("Mobile") String mobile);

    @POST("user.php?action=changepwd")
    Call<JsonObject> API_changePassword(@Query("Mobile") String mobile,
                                        @Query("Password") String password);

    @Multipart
    @POST("uploadprofileimage.php")
    Call<JsonObject> API_uploadProfileImage(@Part MultipartBody.Part profileImg);

    @Multipart
    @POST("upload_image.php")
    Call<JsonObject> API_uploadImg(@Part MultipartBody.Part img);

    @POST("user.php?action=changeimg")
    Call<JsonObject> API_changeProfileImg(@Query("Mobile") String mobile,
                                          @Query("Image") String imgName);


    @POST("user.php?action=newcategory")
    Call<JsonObject> API_addNewCategory(@Query("FirmId") String firmId,
                                        @Query("CategoryName") String categoryName,
                                        @Query("CategoryBanner") String categoryBanner,
                                        @Query("CategoryImage") String categoryImage,
                                        @Query("Status") String status);


    @POST("user.php?action=categorylist")
    Call<JsonObject> API_getCategoryList(@Query("FirmId") String firmId);


    @POST("user.php?action=editcategory")
    Call<JsonObject> API_editCategory(@Query("CategoryId") String categoryId,
                                      @Query("FirmId") String firmId,
                                      @Query("CategoryName") String categoryName,
                                      @Query("CategoryBanner") String categoryBanner,
                                      @Query("CategoryImage") String categoryImage,
                                      @Query("Status") String status);


    @POST("user.php?action=orderdetail")
    Call<JsonObject> API_myOrderItems(@Query("OrderId") String OrderId,
                                      @Query("CustomerCode") String CustomerCode);

    @POST("user.php?action=orderdetail")
    Call<JsonObject> API_adminOrderItems(@Query("OrderId") String OrderId,
                                         @Query("FirmId") String FirmId,
                                         @Query("CustomerCode") String CustomerCode
    );


    @POST("user.php?action=updateorderstatus")
    Call<JsonObject> API_updateOrderStatus(@Query("OrderId") String OrderId,
                                           @Query("CustomerCode") String CustomerCode,
                                           @Query("Status") String status);


    @POST("user.php?action=neworder")
    Call<JsonObject> API_placeOrder(@Body JsonObject jsonObject);


    @POST("user.php?action=allbank")
    Call<JsonObject> API_fetchBanks(@Query("FirmId") String firmId
    );



    @POST("user.php?action=newreceipt")
    Call<JsonObject> API_requestNewReceipt(@Query("FirmId") String firmId,
                                           @Query("RecvDate") String receiveDate,
                                           @Query("CustomerCode") String customerCode,
                                           @Query("RecvAmount") String receiveAmt,
                                           @Query("Remarks") String remarks,
                                           @Query("RecvImage") String receiveImgName,
                                           @Query("BankId") String bankId,
                                           @Query("Status") String status
    );

    @POST("user.php?action=newcrate")
    Call<JsonObject> API_requestNewCrate(@Query("FirmId") String firmId,
                                         @Query("RecvDate") String receiveDate,
                                         @Query("CustomerCode") String customerCode,
                                         @Query("Crate") String receiveAmt,
                                         @Query("Remarks") String remarks,
                                         @Query("RecvImage") String receiveImgName,
                                         @Query("Status") String status
    );

    @POST("user.php?action=updatecratestatus")
    Call<JsonObject> API_updateCrateStatus(@Query("RecvNo") String RecvNo,
                                           @Query("CustomerCode") String customerCode,
                                           @Query("Status") String status
    );

    @POST("user.php?action=allpayments")
    Call<JsonObject> API_myTransactions(@Query("FirmId") String firmId,
                                        @Query("CustomerCode") String customerCode,
                                        @Query("FromDate") String fromDate,
                                        @Query("ToDate") String toDate,
                                        @Query("Status") String status
    );

    @POST("user.php?action=allpartypayments")
    Call<JsonObject> API_myTransactionsAdmin(@Query("FirmId") String firmId,
                                             @Query("CustomerCode") String customerCode,
                                             @Query("FromDate") String fromDate,
                                             @Query("ToDate") String toDate,
                                             @Query("Status") String status
    );

    @POST("user.php?action=updatepayment")
    Call<JsonObject> API_updateTransaction(@Query("RecvNo") String firmId,
                                           @Query("CustomerCode") String customerCode,
                                           @Query("Status") String status
    );

    @POST("user.php?action=mystatement")
    Call<JsonObject> API_myStatements(@Query("FirmId") String firmId,
                                      @Query("CustomerCode") String customerCode,
                                      @Query("FromDate") String fromDate,
                                      @Query("ToDate") String toDate
    );


    @POST("user.php?action=mycratestatement")
    Call<JsonObject> API_myCrateStatements(@Query("FirmId") String firmId,
                                           @Query("CustomerCode") String customerCode,
                                           @Query("FromDate") String fromDate,
                                           @Query("ToDate") String toDate);

    @POST("user.php?action=allcratereport")
    Call<JsonObject> API_allCrateReport(@Query("FirmId") String firmId,
                                        @Query("CustomerCode") String customerCode,
                                        @Query("FromDate") String fromDate,
                                        @Query("ToDate") String toDate,
                                        @Query("Status") String status
    );



    @POST("user.php?action=allcustomers")
    Call<JsonObject> API_customers(@Query("FirmId") String firmId);

    @POST("user.php?action=allroute")
    Call<JsonObject> API_allRoute(@Query("FirmId") String firmId);

    @POST("user.php?action=orderexist")
    Call<JsonObject> API_checkOrderExists(@Query("CustomerCode") String customerCode,
                                          @Query("FirmId") String firmId,
                                          @Query("OrderDate") String fromDate
    );

    @POST("user.php?action=receiptdetail")
    Call<JsonObject> API_myReceiptItems(@Query("RecvId") String RecvId,
                                        @Query("CustomerCode") String CustomerCode);

    @POST("user.php?action=crtreceiptdetail")
    Call<JsonObject> API_myReceiptCrtItems(@Query("RecvId") String RecvId,
                                           @Query("CustomerCode") String CustomerCode);

    @POST("user.php?action=ledger")
    Call<JsonObject> API_ledger(@Query("FirmId") String FirmId,
                                @Query("CustomerCode") String CustomerCode);

    @POST("user.php?action=dashboard")
    Call<JsonObject> API_summary(@Query("FirmId") String FirmId,
                                 @Query("CustomerCode") String CustomerCode,
                                 @Query("Date") String Date,
                                 @Query("Route") String Route);


}
