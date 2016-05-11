package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;
import java.math.BigInteger;

public class utilityClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String var1;
	private float var2;
	private String var3;
	
public String getVar3() {
		return var3;
	}
	public void setVar3(String var3) {
		this.var3 = var3;
	}
	/*	public utilityClass(String var1, float var2)
	{
		this.var1=var1;
		this.var2=var2;
	}
	*/
	public String getVar1() {
		return var1;
	}
	public void setVar1(String string) {
		this.var1 = string;
	}
	public float getVar2() {
		return var2;
	}
	public void setVar2(float var2) {
		this.var2 = var2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
