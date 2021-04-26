package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class OtpVerification{

	@SerializedName("token")
	private String token;

	public String getToken(){
		return token;
	}
}