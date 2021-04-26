package com.spidy.sampletest.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.spidy.sampletest.network.OtpRepository;
import com.spidy.sampletest.network.model.ValidKey;


public class OtpModel extends ViewModel
{

    public MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    public OtpRepository otpRepository = new OtpRepository();
    String phones = "";

    public MutableLiveData<ValidKey> otpMutableLiveData;

    public MutableLiveData<ValidKey> getUser() {

        if (otpMutableLiveData == null) {
            otpMutableLiveData = new MutableLiveData<>();
        }
        return otpMutableLiveData;
    }

    public void onClick(View view)
    {
        if(phoneNumber.getValue() != null && !phoneNumber.getValue().isEmpty() && phoneNumber.getValue().length() == 10)
        {
            otpRepository.getOtpMutableLiveData("+91" + phoneNumber.getValue(),otpMutableLiveData);
        }
    }

}
