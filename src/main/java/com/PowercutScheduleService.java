package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.PowercutSchedule;

@Path("/consume")

public class PowercutScheduleService {
	PowercutSchedule PowercutScheduleOb = new PowercutSchedule();
	
	 @GET
	 @Path("/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readItems() 
	  { 
		  return PowercutScheduleOb.readPowercutSchedule(); 
	  }
	 
	 
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String InsertPowercutSchedule(@FormParam("mcode") String mcode,
			 				@FormParam("description") String description,
			 				@FormParam("area") String area,
			 				@FormParam("date") String date,
	 						@FormParam("time") String time)
			 				
	 {
		 String output = PowercutScheduleOb.InsertPowercutSchedule(mcode,description,area,date,time);
		 return output; 
	 }
	 
}
