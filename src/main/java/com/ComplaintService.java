package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;


//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 




import model.Complaint;


@Path("/complaint")
public class ComplaintService {
	Complaint ComplaintOb = new Complaint();
	
	@GET
	 @Path("/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readComplaint() 
	  { 
		  return  ComplaintOb.readComplaint(); 
	  }
	 
	
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String InsertComplaint(@FormParam("complaintCategory") String complaintCategory,
			 				@FormParam("complaintType") String complaintType,
			 				@FormParam("accountNo") String accountNo,
			 				@FormParam("name") String name,
			 				@FormParam("mobileno") String mobileno,
			 				@FormParam("address") String address,
	 						@FormParam("complaintDesc") String complaintDesc)
			 				
	 {
		 String output = ComplaintOb.InsertComplaint(complaintCategory,complaintType,accountNo,name,mobileno,address,complaintDesc);
		 return output; 
	 }

}
