package com.spidy.sampletest.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.spidy.sampletest.R;
import com.spidy.sampletest.databinding.FragmentVerifyBinding;
import com.spidy.sampletest.databinding.MvvmOtpBinding;
import com.spidy.sampletest.network.model.ValidKey;
import com.spidy.sampletest.viewmodel.OtpModel;
import com.spidy.sampletest.viewmodel.VerifyModel;

public class OtpVerify extends AppCompatActivity
{
    public VerifyModel verifyModel;
    public FragmentVerifyBinding fragmentVerifyBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String phone = getIntent().getStringExtra("phone");
        verifyModel = ViewModelProviders.of(this).get(VerifyModel.class);
        fragmentVerifyBinding = DataBindingUtil.setContentView(OtpVerify.this, R.layout.fragment_verify);
        fragmentVerifyBinding.setLifecycleOwner(this);
        fragmentVerifyBinding.setVerifyModel(verifyModel);
        verifyModel.setPhone(phone);
        verifyModel.getToken().observe(this, new Observer<ValidKey>() {
            @Override
            public void onChanged(@Nullable ValidKey validKey)
            {
                Intent intent=new Intent(OtpVerify.this, Home.class);
                intent.putExtra("token",validKey.getMessage());
                startActivity(intent);
                finish();
            }
        });
    }
}
