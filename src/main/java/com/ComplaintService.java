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
	 
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateComplaint(String updateComplaintData)
	 {
		 
		 JsonObject updateCons = new JsonParser().parse(updateComplaintData).getAsJsonObject();
		 
		 String complaintCategory = updateCons.get("complaintCategory").getAsString();
		 String complaintType = updateCons.get("complaintType").getAsString();
		 String accountNo = updateCons.get("accountNo").getAsString();
		 String name = updateCons.get("name").getAsString();
		 String mobileno = updateCons.get("mobileno").getAsString();
		 String address = updateCons.get("address").getAsString();
		 String complaintDesc = updateCons.get("complaintDesc").getAsString();
		 
		 String output = ComplaintOb.updateComplaint(complaintCategory,complaintType,accountNo,name,mobileno,address,complaintDesc);
		 return output;
	 }

}
