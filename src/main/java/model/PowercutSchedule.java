package model;

import java.sql.*;  

public class PowercutSchedule {
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elecrogrid", "root", "root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}	

	//column name
public String InsertPowercutSchedule(String mcode, String description, String area, String date, String time) {
 
	String output = "";
	try {
		Connection con = connect();
		
		if (con == null)
		{return  "Error while connecting to the database for inserting.";}
		
		// create a prepared statement
		//column name
		String query = "  insert into powercutschedule (`mcode`,`description`,`area`,`date`,`time`)" + " values (?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		 // binding values
//		 preparedStmt.setInt(1, 0); 
		 preparedStmt.setString(1, mcode);
		 preparedStmt.setString(2, description);
		 preparedStmt.setString(3, area); 
		 preparedStmt.setString(4, date); 
		 preparedStmt.setString(5, time);

	
		 
		// execute the statement
		 
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Inserted successfully"; 
	}
	catch (Exception e) {
		 output = "Error while inserting the Power Consumption."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
	}

public String readPowercutSchedule() {
	
	String output = "";
	
	try {
		
		Connection con = connect();
		
		if(con == null) {
			return "Error while connecting to the database for reading.";
		}
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
		 		+ "<th>MCode</th>"
		 		+ "<th>Description</th>" +
		 		  "<th>Area</th>" + 
		 		  "<th>Date</th>" +
		 		 "<th>Time</th></tr>";
		 		
		 
		 String query = "select * from powercutschedule"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 
		 while(rs.next()) {
			 
			 String mcode = rs.getString("mcode");
			 String description = rs.getString("description"); 
			 String area = rs.getString("area"); 
			 String date = rs.getString("date"); 
			 String time = rs.getString("time"); 
	
			 
			 // Add into the HTML table
			 output += "<tr><td>" + mcode + "</td>"; 
			 output += "<td>" + description + "</td>";
			 output += "<td>" + area + "</td>"; 
			 output += "<td>" + date + "</td>"; 
			 output += "<td>" + time + "</td>";
			 
			 
			 // buttons
			
		 }
		 con.close(); 
		 // Complete the html table
		 output += "</table>";
	}
	catch(Exception e)
	{
		 output = "Error while reading the customer."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
	}

}
