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
	
	$(window).load(function() { 
        $("#spinner").fadeOut("slow"); 
    });

	$("#areaSearch").click(function(){
		if(validateEmail('abc.com')){
			alert("Hi");
		} else{
		alert("Flase"); }	
	});
});
</script>
<style type="text/css">

#loading
{
	position: fixed;
	top: 50%;
	left: 50%;
	width: 3em;
	height: 3em;
	transform: translate(-50%, -50%);
	/*margin-top: -50px;
	margin-left: -100px;*/
	background: url(images/loadingIcon1.gif) no-repeat;
	background-size: 100%;
}
</style>
</head>
<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<body>
	<div id="loading">
	</div>
	<form action="">
		<h1><a href="productDescription.do">Products</a></h1>
		<br/>
		<h2><a href="shopDescription.do">Shop Registration</a></h2>
	</form>
</body>
</html>