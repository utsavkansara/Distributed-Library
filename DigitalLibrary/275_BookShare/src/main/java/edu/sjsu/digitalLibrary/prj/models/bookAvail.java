package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;
import java.sql.Date;

public class bookAvail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int subId;
	private Date start_date;
	private Date end_date;
	private int regionId;
	private double region_long;
	private double region_lat;
	private String region_name;
	
	
	
	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public bookAvail(int subId, Date start_date, Date end_date, int regionId, double region_long, double region_lat, String region_name)
	{
		this.subId=subId;
		this.start_date=start_date;
		this.end_date=end_date;
		this.regionId=regionId;
		this.region_lat=region_lat;
		this.region_long=region_long;
		this.region_name=region_name;
	}
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public double getRegion_long() {
		return region_long;
	}
	public void setRegion_long(long region_long) {
		this.region_long = region_long;
	}
	public double getRegion_lat() {
		return region_lat;
	}
	public void setRegion_lat(long region_lat) {
		this.region_lat = region_lat;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
