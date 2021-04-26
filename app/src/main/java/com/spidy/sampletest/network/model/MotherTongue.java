package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class MotherTongue{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}