package com.business.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CommonOperation {

	public CommonOperation() {
		// TODO Auto-generated constructor stub
	}
	
	public String getHostName(){
		String hostName="";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hostName;
	}

}
