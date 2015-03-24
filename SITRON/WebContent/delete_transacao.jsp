<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gft.sitron.*"%>
<%@page import="com.gft.Stax.SelectXMLTransacao"%>
<%@page import="com.gft.Stax.DeleteXMLTransacao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		 <%
				           String inputdel = request.getParameter("id");
				           
				           if(inputdel != null){ 
		
				           System.out.println("Inputdel 2:"+inputdel);
						   DeleteXMLTransacao d = new DeleteXMLTransacao();
						   d.deleteTransacao(inputdel);
						   d.deleteXMLRequestResponse(inputdel);
			
						}
		%> 
				           
	</body>
</html>