package com.model;

public class Match {
	public Match(String title, String place, String dt) {
		super();
		this.title = title;
		this.place = place;
		this.dt = dt;
	}
	String title;
	String place;
	String dt;
	public String getTitle() {
		return title;
	}

	public String getPlace() {
		return place;
	}

	public String getDt() {
		return dt;
	}


}