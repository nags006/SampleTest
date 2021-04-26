package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class PreferenceQuestion{

	@SerializedName("second_choice")
	private String secondChoice;

	@SerializedName("first_choice")
	private String firstChoice;

	public String getSecondChoice(){
		return secondChoice;
	}

	public String getFirstChoice(){
		return firstChoice;
	}
}