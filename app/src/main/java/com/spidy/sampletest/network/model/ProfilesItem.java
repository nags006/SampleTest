package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class ProfilesItem{

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("first_name")
	private String firstName;

	public String getAvatar(){
		return avatar;
	}

	public String getFirstName(){
		return firstName;
	}
}