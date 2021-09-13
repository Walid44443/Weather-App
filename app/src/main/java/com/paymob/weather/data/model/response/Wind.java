package com.paymob.weather.data.model.response;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("deg")
	private int deg;

	@SerializedName("speed")
	private int speed;

	@SerializedName("gust")
	private double gust;

	public void setDeg(int deg){
		this.deg = deg;
	}

	public int getDeg(){
		return deg;
	}

	public void setSpeed(int speed){
		this.speed = speed;
	}

	public int getSpeed(){
		return speed;
	}

	public void setGust(double gust){
		this.gust = gust;
	}

	public double getGust(){
		return gust;
	}
}