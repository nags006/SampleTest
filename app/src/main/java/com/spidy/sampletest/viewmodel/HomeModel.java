package com.spidy.sampletest.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.spidy.sampletest.network.OtpRepository;
import com.spidy.sampletest.network.model.ValidKey;


public class HomeModel extends ViewModel
{

    public MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    public OtpRepository otpRepository = new OtpRepository();

    String token;
    public void setToken(String token)
    {
        this.token = token;
    }
    public String getToken()
    {
        return token;
    }

    public void init()
    {
        if(getToken() != null && !getToken().isEmpty())
        {
            otpRepository.getUserMutableLiveData(getToken());
        }
    }

}
