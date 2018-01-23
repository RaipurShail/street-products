<%@include file="/WEB-INF/jsp/common/includeDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<%@include file="/WEB-INF/jsp/common/scripts.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	var msg = $("#errorMessgae").val();
	$("h1").text(msg);
});
</script>
</head>
<body>

<form:form id="errorPage" name="errorPage" action="errorPage.do" modelAttribute="errorAttribute">
<input name="errorMessgae" id="errorMessgae" type="hidden" value="${errorMsg}">
<h1></h1>
<button type="submit" onclick="submitForm('errorPage')">Home Page</button>
</form:form>

</body>
</html>