<%@page import="model.NewConnection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>NewConnection DETAILS</h1>
<%

 NewConnection NewConnectionOb = new NewConnection();
 out.print(NewConnectionOb.readNewConnection());
%>

</body>
</html>