package model;

import com.google.gson.annotations.SerializedName;

public class OneTimePasswordModel{

	@SerializedName("expires")
	private String expires;

	@SerializedName("id")
	private int id;

	@SerializedName("oneTimePasswordCode")
	private int oneTimePasswordCode;

	public String getExpires(){
		return expires;
	}

	public int getId(){
		return id;
	}

	public int getOneTimePasswordCode(){
		return oneTimePasswordCode;
	}
}