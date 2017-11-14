<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page2</title>
<%@include file="/WEB-INF/jsp/common/scripts.jsp" %>
<script src="js/util.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$("#areaSearch").click(function(){
		if(validateEmail('abc.com')){
			alert("Hi");
		} else{
		alert("Flase"); }	
	});
});
</script>
</head>
<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<body>
	<form action="">
		<h1><a href="registerBusiness.do">Business</a></h1>
		<br/>
		<h2><a href="userCRUD.do">Customer</a></h2>
	</form>
</body>
</html>