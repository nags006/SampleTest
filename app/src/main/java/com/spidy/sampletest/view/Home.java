package com.spidy.sampletest.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import com.spidy.sampletest.R;
import com.spidy.sampletest.databinding.FragmentDiscoverBinding;
import com.spidy.sampletest.viewmodel.HomeModel;


public class Home extends AppCompatActivity
{
    HomeModel homeModel;
    FragmentDiscoverBinding fragmentDiscoverBinding;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = getIntent().getStringExtra("token");
        homeModel = ViewModelProviders.of(this).get(HomeModel.class);
        fragmentDiscoverBinding = DataBindingUtil.setContentView(Home.this, R.layout.fragment_discover);
        fragmentDiscoverBinding.setLifecycleOwner(this);
        fragmentDiscoverBinding.setHomeviewmodel(homeModel);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnav);
        homeModel.setToken(token);
        homeModel.init();
    }
}
