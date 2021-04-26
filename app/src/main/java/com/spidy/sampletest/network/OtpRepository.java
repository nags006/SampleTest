package com.spidy.sampletest.network;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.spidy.sampletest.network.model.OtpVerification;
import com.spidy.sampletest.network.model.PhoneLog;
import com.spidy.sampletest.network.model.ResponsePro;
import com.spidy.sampletest.network.model.ValidKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OtpRepository
{
    PhoneLog phoneLog;
    private MutableLiveData<String> otpPhone;
    public void setPhone(PhoneLog phoneLog)
    {
        this.phoneLog = phoneLog;
    }

    public void getOtpMutableLiveData(String phone,MutableLiveData<ValidKey> otpPhone)
    {
        Api api = RetrofitInstance.getApiService();
        Call<PhoneLog> call = api.phoneLogin(phone);
        call.enqueue(new Callback<PhoneLog>() {
            @Override
            public void onResponse(Call<PhoneLog> call, Response<PhoneLog> response)
            {
                Log.e("exe",response.body().getStatus());
                if(response.body().getStatus() != null && !response.body().getStatus().equals("null") && !response.body().getStatus().isEmpty())
                {
                    otpPhone.setValue(new ValidKey(phone,response.body().getStatus()));
                }
            }

            @Override
            public void onFailure(Call<PhoneLog> call, Throwable t)
            {
               Log.e("exe","Failed..!");
            }
        });
    }

    public void getVerifyMutableLiveData(String phone,String otp,MutableLiveData<ValidKey> token)
    {
        Api api = RetrofitInstance.getApiService();
        Call<OtpVerification> call = api.verifyOtp(phone,otp);
        call.enqueue(new Callback<OtpVerification>() {
            @Override
            public void onResponse(Call<OtpVerification> call, Response<OtpVerification> response)
            {
                if(response.isSuccessful())
                {
                    if(response.body().getToken() != null && !response.body().getToken().equals("null") && !response.body().getToken().isEmpty())
                    {
                        token.setValue(new ValidKey(phone,response.body().getToken()));
                    }
                }

            }

            @Override
            public void onFailure(Call<OtpVerification> call, Throwable t)
            {

            }
        });
    }


    public void getUserMutableLiveData(String token)
    {
        Api api = RetrofitInstance.getApiService();
        Call<ResponsePro> call = api.fetchUser(token);
        call.enqueue(new Callback<ResponsePro>() {
            @Override
            public void onResponse(Call<ResponsePro> call, Response<ResponsePro> response)
            {
                if(response.isSuccessful())
                {
                    Log.e("exe","" + response.body().getLikes().getLikesReceivedCount());
                }
            }

            @Override
            public void onFailure(Call<ResponsePro> call, Throwable t)
            {

            }
        });
    }

}
