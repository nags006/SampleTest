package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class ResponsePro{

	@SerializedName("invites")
	private Invites invites;

	@SerializedName("likes")
	private Likes likes;

	public Invites getInvites(){
		return invites;
	}

	public Likes getLikes(){
		return likes;
	}
}