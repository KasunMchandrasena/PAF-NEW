<%@page import="model.NewConnection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% 
    
//Insert Payment----------------------------------
if (request.getParameter("nic") != null)
 {
 NewConnection NewConnectionOb = new NewConnection();
 String stsMsg = NewConnectionOb.insertNewConnection(request.getParameter("nic"), 

 

 
 request.getParameter("name"),
 request.getParameter("number"), 
 request.getParameter("address"));
 session.setAttribute("statusMsg", stsMsg);
 }
 
 

//Delete Payment----------------------------------
if (request.getParameter("id") != null)
{
NewConnection NewConnectionOb = new NewConnection();
String stsMsg = NewConnectionOb.deleteNewConnection(request.getParameter("id"));
session.setAttribute("statusMsg", stsMsg);
}   

%>

   
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}


div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

<head>
<meta charset="ISO-8859-1">
<title>New Connection</title>
</head>

<body>

<h1>New Connection</h1>
<h3><u>Insert Connection</u></h3>

<div>
<form method="post" action="InsertNewConnection.jsp">
 
 

 nic:   <input name="nic" type="text"><br><br> 
 name:   <input name="name" type="text"><br><br> 
 number:   <input name="number" type="text"><br><br>  
 address:     <input name="address" type="text"><br><br> 
 
 
 <input name="btnSubmit" type="submit" value="Insert"><br><br>
</form>
<a href="viewNewConection.jsp" class="button">View Details</a>
</div>

<%
 out.print(session.getAttribute("statusMsg"));
%>

<br>


</body>
</html>