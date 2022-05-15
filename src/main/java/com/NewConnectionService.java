package com;

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import model.NewConnection;




@Path("/connection")
public class NewConnectionService {
	NewConnection NewConnectionOb = new NewConnection();
	
	 @GET
	 @Path("/view") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readNewConnection() 
	  { 
		  return NewConnectionOb.readNewConnection(); 
	  }
	 
	 
	 @POST
	 @Path("/insert")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertNewConnection(
			 				@FormParam("nic") String nic,
			 				@FormParam("name") String name,
			 				@FormParam("number") String number,
	 						@FormParam("address") String address)
			 				
	 {
		 String output =NewConnectionOb.insertNewConnection(nic,name,number,address);
		 return output; 
	 }
	 
	 @PUT
	 @Path("/update")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateNewConnection(String updateNewConnection)
	 {
		 
		 JsonObject updateCons = new JsonParser().parse(updateNewConnection).getAsJsonObject();
		 
		 String id = updateCons.get("id").getAsString();
		 String nic = updateCons.get("nic").getAsString();
		 String name = updateCons.get("name").getAsString();
		 String number = updateCons.get("number").getAsString();
		 String address = updateCons.get("address").getAsString();

		 
		 String output = NewConnectionOb.updateNewConnection(id, nic, name, number,address);
		 return output;
	 }
	 
	 @DELETE
	 @Path("/delete")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String deleteNewConnection(String NewConnection)
	
	 {
		 JsonObject deleteCons = new JsonParser().parse(NewConnection).getAsJsonObject();
	
		 String id = deleteCons.get("id").getAsString();
	
		 String output = NewConnectionOb.deleteNewConnection(id);
		 return output;

	 }
}
