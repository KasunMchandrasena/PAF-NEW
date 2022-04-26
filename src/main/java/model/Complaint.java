package model;

import java.sql.*; 

public class Complaint {

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
	public String InsertComplaint(String complaintCategory, String complaintType, String accountNo, String name, String mobileno,String address,String complaintDesc) {
	 
		String output = "";
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = "insert into complaint(`complaintCategory`,`complaintType`,`accountNo`,`name`,`mobileno`,`address`,`complaintDesc`)" + " values (?, ?, ?, ?, ?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setString(1,complaintCategory);
			 preparedStmt.setString(2,complaintType);
			 preparedStmt.setString(3, accountNo); 
			 preparedStmt.setString(4, name); 
			 preparedStmt.setString(5, mobileno);
			 preparedStmt.setString(6, address);
			 preparedStmt.setString(7, complaintDesc);
		
			 
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
	
	public String readComplaint() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			 // Prepare the html table to be displayed
			 output = "<table border='1'>"
			 		+ "<tr>"
			 		+ "<th>Complaint Category</th>"
			 		+ "<th>Complaint Type</th>" +
			 		  "<th>Account Number</th>" + 
			 		  "<th>Name</th>" +
			 		 "<th>Mobile Number</th>" +
			 		"<th>Address</th>" +
			 		 "<th>Complaint Description</th></tr>";
			 		
			 
			 String query = "select * from complaint"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 
			 while(rs.next()) {
				 
				 String complaintCategory = rs.getString("complaintCategory");
				 String complaintType = rs.getString("complaintType"); 
				 String accountNo = rs.getString("accountNo"); 
				 String name = rs.getString("name"); 
				 String mobileno= rs.getString("mobileno"); 
				 String address= rs.getString("address"); 
				 String complaintDesc= rs.getString("complaintDesc"); 
					
				 
				 // Add into the HTML table
				 output += "<tr><td>" + complaintCategory + "</td>"; 
				 output += "<td>" + complaintType + "</td>";
				 output += "<td>" + accountNo + "</td>"; 
				 output += "<td>" + name + "</td>"; 
				 output += "<td>" + mobileno + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + complaintDesc + "</td>";
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
	
	public String updateComplaint(String complaintCategory, String complaintType, String accountNo, String name, String mobileno,String address,String complaintDesc) 
	{
		String output = "";
		
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for updating.";}
			
			// create a prepared statement
			String query = "  UPDATE complaint SET complaintCategory=?,complaintType=?,name=?,mobileno=?,address=?,complaintDesc=? where accountNo=?"  ;
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setString(1, complaintCategory); 
			 preparedStmt.setString(2, complaintType); 
			 preparedStmt.setString(3, name);
			 preparedStmt.setString(4, mobileno);
			 preparedStmt.setString(5, address);
			 preparedStmt.setString(6, complaintDesc);
			 preparedStmt.setString(7, accountNo);
			 
			// execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Updated successful"; 
		}
		catch (Exception e) {
			 output = "Error while Update the complaint."; 
			 System.err.println(e.getMessage()); 
		}
		return output;
	}
		
	//Delete
	public String deleteComplaint(String accountNo) {
	String output = "";
			
		try {
			Connection con = connect();
				
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
				
			//create a prepared statement
			String query = "delete from complaint where accountNo=?";
				
			PreparedStatement preparedStmt = con.prepareStatement(query);
				
			//binding values
			preparedStmt.setString(1,accountNo);
				
			//execute the statement
			preparedStmt.execute();
			con.close();
				
			output = "Deleted successfully";
			}
			
			catch (Exception e)
			{
				output = "Error while deleting the Power cut schedule.";
				System.err.println(e.getMessage());
			}
			
			return output;
			}

}
