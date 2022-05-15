package model;

import java.sql.*;  

public class NewConnection {
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
public String insertNewConnection(String nic, String name, String number, String address) {
 
	String output = "";
	try {
		Connection con = connect();
		
		if (con == null)
		{return  "Error while connecting to the database for inserting.";}
		
		// create a prepared statement
		//column name
		
		String query = "  insert into newconnection(`id`,`nic`,`name`,`number`,`address`)" + " values (?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		 // binding values
		
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, nic);
		 preparedStmt.setString(3, name); 
		 preparedStmt.setString(4, number); 
		 preparedStmt.setString(5, address);

	
		 
		// execute the statement
		 
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Inserted successfully"; 
	}
	
	catch (Exception e) {
		
		 output = "Error while inserting ."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
	}

public String readNewConnection() {
	
	String output = "";
	
	try {
		
		Connection con = connect();
		
		if(con == null) {
			return "Error while connecting to the database for reading.";
		}
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
		 		+ "<th>id</th>"
		 		+ "<th>nic</th>" 
		 		+  "<th>name</th>" 
		 		+  "<th>number</th>" 
		 		+ "<th>address</th>"
		 		+ "<th>Update</th><th>Remove</th></tr>";
				
		 
		 String query = "select * from newconnection"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 
		 while(rs.next()) {
			 
			 String id = Integer.toString(rs.getInt("id"));
			 String nic = rs.getString("nic"); 
			 String name = rs.getString("name"); 
			 String number = rs.getString("number"); 
			 String address = rs.getString("address"); 
	
			 
			 // Add into the HTML table
			 output += "<tr><td>" + id + "</td>"; 
			 output += "<td>" + nic + "</td>";
			 output += "<td>" + name + "</td>"; 
			 output += "<td>" + number + "</td>"; 
			 output += "<td>" + address + "</td>";
			 
			 
			 // buttons
			 output += "<td><form method='post' action='updateNewConnection.jsp'>"
				 		+ "<input name='btnUpdate' type='submit' value='Update'class='btn btn-secondary'>"
				 		+ "<input name='Id' type='hidden' value='" + id + "'>" + "</form></td>"
						 + "<td><form method='post' action='viewNewConnection.jsp'>"
						 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
						 + "<input name='id' type='hidden' value='" + id + "'>" + "</form></td></tr>";
			
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


public String updateNewConnection(String id,String nic, String name, String number, String address) {
	
	String output = "";
	
	try {
		Connection con = connect();
		
		if (con == null)
		{return  "Error while connecting to the database for updating.";}
		
		// create a prepared statement
		String query = "  update newconnection SET address=?,number=?,name=?,nic=? where id=?"  ;
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		 // binding values
		  
		  
		 preparedStmt.setString(1, nic); 
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, number);
		 preparedStmt.setString(4, address);
		 preparedStmt.setInt(5, Integer.parseInt(id));
		 
		 
		// execute the statement
		 
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Update successfully"; 
	}
	
	catch (Exception e) {
		 output = "Error while Update connection Details."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
}


//Delete
public String deleteNewConnection(String id) {
	String output = "";
	
	try {
		Connection con = connect();
		
		if (con == null)
		{return "Error while connecting to the database for deleting."; }
		
		//create a prepared statement
		String query = "delete from newconnection where id=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		//binding values
		preparedStmt.setString(1,id);
		
		//execute the statement
		preparedStmt.execute();
		con.close();
		
		output = "Deleted successfully";
		}
	
	catch (Exception e)
		{
		
		output = "Error while deleting the connection .";
		System.err.println(e.getMessage());
		
		}
	
	return output;
	}

}
