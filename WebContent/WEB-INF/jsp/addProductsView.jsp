<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Description</title>
</head>
<%@include file="/WEB-INF/jsp/common/scripts.jsp" %>
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
	display: none;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#addProductBtn").click(function(){
		$("#loading").show();
		var tableStart = "<table class='viewTable' border='1'><tr>";
		var tableEnd = "</table>";
		var result="";
		var errorMsg="";
		var flag=false;
		
		$.ajax({
			type: "GET",
			url: "addProduct.do",
			contentType: 'application/json',
			data: $("#productForm").serialize(),
			dataType: 'json',
			//data: "productName="+prodName+"&productCode="+prodCode,
			success: function(response){
				$("#loading").hide();
				$("#resultDiv").html("");
				
				tableStart = tableStart + "<td>Product ID</td>";
				tableStart = tableStart + "<td>Product Name</td>";
				tableStart = tableStart + "<td>Product Code</td>";
				tableStart = tableStart + "<td>Price</td>";
				tableStart = tableStart + "<td>Manufacturer</td>";
				tableStart = tableStart + "<td>Available Stock</td>";
				tableStart = tableStart + "<td>shop Id</td>";
				tableStart = tableStart + "<td>User Name</td>";
				tableStart = tableStart + "<td>Category Id</td>";
				tableStart = tableStart + "<td>Created Date</td>";
				tableStart = tableStart + "<td>CreatedBy</td>";
				tableStart = tableStart + "<td>Modified Date</td>";
				tableStart = tableStart + "<td>Modified By</td></tr>";
				
				for (i = 0; i < response.length; i++) {
					jsonString = response[i];
					result=result+'<tr>';
					for(key in jsonString) {
						if(key=="erroMessage"){
							flag=true;
							errorMsg=jsonString[key];
						} else {
							result=result+'<td>'+jsonString[key]+'</td>';
						}
					}
					result=result+"</tr>";
				}
				
				if(flag){
					tableStart = "<table class='viewTable' border='1'><tr><td>Error</td></tr>";
					result='<tr><td>'+errorMsg+'</td></tr>';
				}
				
				$('#productForm')[0].reset();
				$(tableStart+result+tableEnd).appendTo('#resultDiv');
			},
			error: function(response){
				$("#loading").hide();
				$("#resultDiv").html("");
				 $.each(response, function(key, value) {
					result=result+'<tr><td>'+response[key].erroMessage+'</td></tr>';
				});
				$('#productForm')[0].reset();
				$(tableStart+result+tableEnd).appendTo('#resultDiv');
			},
		});
	});
});

function updateProducts()
{
	document.productForm.action="updateProduct.do";
	document.productForm.submit();
}

function addProducts()
{
	document.productForm.action="loadAddProductForm.do";
	document.productForm.submit();
}

function showProducts()
{
	document.productForm.action="showAllProducts.do";
	document.productForm.submit();
}

</script>
</head>

<body>
	<div id="loading"></div>
	<form:form name="productForm" id="productForm" modelAttribute="product">
		<input name="productId" id="productId" type="hidden" value="${product.productId}">
		<input name="erroMessage" id="erroMessage" type="hidden" value="${product.erroMessage}">
		<div align="center">
			<h1>Product Detail</h1>
			<table border="1">
				<tr>
					<th>Product Name</th>
					<td><input name="productName" id="productName" value="${product.productName}">
					</td>
				</tr>
				<tr>
					<th>Product Code</th>
					<td><input name="productCode" id="productCode" value="${product.productCode}">
					</td>
				</tr>
				<tr>
					<th>Price</th>
					<td><input name="price" id="price" value="${product.price}"></td>
				</tr>
				<tr>
					<th>Manufacturer</th>
					<td><input name="manufacturer" id="manufacturer" value="${product.manufacturer}">
					</td>
				</tr>
				<tr>
					<th>Available Stock</th>
					<td><input name="availableStock" id="availableStock"
						value="${product.availableStock}"></td>
				</tr>
				<tr>
					<th>Category</th>
					<td>
						<form:select name="categoryId" id="categoryId" path="categoryId">
							<form:option value="SELECT" id="SELECT" label="SELECT"/>
							<form:options items="${categoryMap.categoryMaster}" />
						</form:select>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<input type="button" id="addProductBtn" name="addProductBtn" value="SubmitForm"/>
					</td>
				</tr>
				<!-- <tr>
					<th><input type="button" value="Add Products"
						onclick="addProducts()" /></th>
					<th><input type="button" value="Update"
						onclick="updateProducts()" /></th>
					<th><input type="button" value="Show All Products"
						onclick="showProducts()" /></th>
				</tr> -->
			</table>
		</div>
		<div id="resultDiv"></div>
	</form:form>
<%-- 
	<div align="center">
		<h1>Product List</h1>
		<table border="1">
			<tr>
				<th>S.No.</th>
				<th>Product Name</th>
				<th>Product Code</th>
				<th>Price</th>
				<th>Manufacturer</th>
				<th>Available Stock</th>
				<th>Category</th>
				<th>Action</th>
				<th>Action</th>
			</tr>

			<c:forEach var="product" items="${productList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${product.productName}</td>
					<td>${product.productCode}</td>
					<td>${product.price}</td>
					<td>${product.manufacturer}</td>
					<td>${product.availableStock}</td>
					<td>${product.categoryId}</td>
					<td><a href="editProducts.do?productId=${product.productId}">Edit</a></td>
					<td><a href="deleteProducts.do?productId=${product.productId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> --%>

</body>
</html>