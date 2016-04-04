package edu.sjsu.digitalLibrary.prj.dao;

import edu.sjsu.digitalLibrary.prj.dataoperations.*;

public class CassandraConnectionDAO{
	
	public static void testCassandra(){
final CassandraConnector client = new CassandraConnector();  
final String ipAddress = "54.67.80.61";  
final int port = 9042;  
System.out.println("Connecting to IP address " + ipAddress + ":" + port + "...");  
client.connect(ipAddress, port);  

client.close();  
	}
}