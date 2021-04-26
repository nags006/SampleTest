package com.spidy.sampletest.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.spidy.sampletest.network.Api;
import com.spidy.sampletest.network.OtpRepository;
import com.spidy.sampletest.network.model.OtpVerification;
import com.spidy.sampletest.network.model.ValidKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerifyModel extends ViewModel
{
    public MutableLiveData<String> otp = new MutableLiveData<>();
    public OtpRepository otpRepository = new OtpRepository();
    String phone;

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    public MutableLiveData<ValidKey> otpverifyMutableLiveData;

    public MutableLiveData<ValidKey> getToken() {

        if (otpverifyMutableLiveData == null) {
            otpverifyMutableLiveData = new MutableLiveData<>();
        }
        return otpverifyMutableLiveData;
    }

    public void onClick(View view)
    {
        Log.e("exe",otp.getValue() + " :" + getPhone());
        if(otp.getValue() != null && !otp.getValue().isEmpty() && otp.getValue().length() == 4)
        {
            otpRepository.getVerifyMutableLiveData(getPhone(),otp.getValue(),otpverifyMutableLiveData);
        }
    }
}
