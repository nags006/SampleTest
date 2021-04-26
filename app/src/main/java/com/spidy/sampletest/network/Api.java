package com.spidy.sampletest.network;

import android.util.Log;

import com.spidy.sampletest.network.model.OtpVerification;
import com.spidy.sampletest.network.model.PhoneLog;
import com.spidy.sampletest.network.model.ResponsePro;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api
{
    @FormUrlEncoded
    @POST("phone_number_login")
    Call<PhoneLog> phoneLogin(
            @Field("number") String number);

    @FormUrlEncoded
    @POST("verify_otp")
    Call<OtpVerification> verifyOtp(
            @Field("number") String number,
            @Field("otp") String otp)
            ;


    @GET("test_profile_list")
    Call<ResponsePro> fetchUser(@Header("Authorization") String token);

}
