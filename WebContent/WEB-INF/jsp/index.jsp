<%@include file="/WEB-INF/jsp/common/includeDirectives.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page2</title>
<%@include file="/WEB-INF/jsp/common/scripts.jsp"%>
<script src="js/util.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$(window).load(function() {
			$("#spinner").fadeOut("slow");
		});

		$("#areaSearch").click(function() {
			if (validateEmail('abc.com')) {
				alert("Hi");
			} else {
				alert("Flase");
			}
		});
	});
</script>
<style type="text/css">
#loading {
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
<body>
	<div id="loading"></div>
	<form:form name="homePageForm" id="homePageForm"
		action="homePageFormDetails.do" modelAttribute="homePageDetails">
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<fmt:setLocale value="en" />
		<h3>
			<fmt:message key="homePage.title" bundle="${selectLanguage}"></fmt:message>
		</h3>
		<h1>
			<a href="#" onclick="submitForm_Action('homePageForm', 'productDescription.do')"> <fmt:message
					key="homePage.product" bundle="${selectLanguage}"></fmt:message>
			</a>
		</h1>
		<br />
		<h2>
			<a href="shopDescription.do"> <fmt:message key="homePage.shop"
					bundle="${selectLanguage}"></fmt:message>
			</a>
		</h2>
	</form:form>
</body>
</html>