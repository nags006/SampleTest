package com.spidy.sampletest.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.spidy.sampletest.R;
import com.spidy.sampletest.databinding.MvvmOtpBinding;
import com.spidy.sampletest.network.model.ValidKey;
import com.spidy.sampletest.viewmodel.OtpModel;

public class OtpActivty extends AppCompatActivity
{
    public OtpModel otpModel;
    public MvvmOtpBinding otpBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        otpModel = ViewModelProviders.of(this).get(OtpModel.class);
        otpBinding = DataBindingUtil.setContentView(OtpActivty.this, R.layout.mvvm_otp);
        otpBinding.setLifecycleOwner(this);
        otpBinding.setViewmodel(otpModel);
        otpModel.getUser().observe(this, new Observer<ValidKey>() {
            @Override
            public void onChanged(@Nullable ValidKey s)
            {
               if(s.getMessage().equals("true"))
               {
                   Intent intent=new Intent(OtpActivty.this, OtpVerify.class);
                   intent.putExtra("phone",s.getKey());
                   startActivity(intent);
                   finish();
               }
            }
        });
    }

}
