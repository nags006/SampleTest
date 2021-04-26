package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("summary")
	private String summary;

	@SerializedName("full")
	private String full;

	public String getSummary(){
		return summary;
	}

	public String getFull(){
		return full;
	}
}