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
				<script src="js/jquery.dataTables.min.js"></script>
				<link href="styles/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
				<link href="styles/css/layout.css" rel="stylesheet" type="text/css" media="all">
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
						display: none;
					}
				</style>
				<script type="text/javascript">
					$(document).ready(function () {
						$("#addProductBtn").click(function () {
							$("#loading").show();
							var tableStart = "<table class='viewTable' border='1'><tr>";
							var tableEnd = "</table>";
							var result = "";
							var errorMsg = "";
							var flag = false;

							$.ajax({
								type: "GET",
								url: "addProduct.do",
								contentType: 'application/json',
								data: $("#productForm").serialize(),
								dataType: 'json',
								//data: "productName="+prodName+"&productCode="+prodCode,
								success: function (response) {
									$("#loading").hide();

									/* tableStart = tableStart + "<td>Product ID</td>";
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
									$(tableStart+result+tableEnd).appendTo('#resultDiv'); */
									showDataTable(response);
								},
								error: function (response) {
									$("#loading").hide();
									/*  $.each(response, function(key, value) {
										result=result+'<tr><td>'+response[key].erroMessage+'</td></tr>';
									});
									$('#productForm')[0].reset();
									$(tableStart+result+tableEnd).appendTo('#resultDiv'); */
								},
							});
						});

						$("#showProductsBtn").click(function () {
							$("#loading").show();
							var serializeData = $("#productForm").serialize();
							console.log(serializeData);
							$.ajax({
								type: "GET",
								url: "showAllProducts.do",
								contentType: 'application/json',
								data: serializeData,
								dataType: 'json',
								//data: "productName="+prodName+"&productCode="+prodCode,
								success: function (response) {
									$("#loading").hide();
									showDataTable(response);
								},
								error: function () {
									$("#loading").hide();
								}
							});
						});
					});

					function showDataTable(response) {
						$("#resultDataTableDiv").show();
						$('#resultDataTable').dataTable({
							paging: true,
							destroy: true,
							searching: true,
							data: response,
							columns: [{ data: "productId" }, { data: "productName" }, { data: "productCode" }, { data: "price" }, { data: "manufacturer" },
							{ data: "availableStock" }, { data: "shopId" }, { data: "userName" }, { data: "categoryId" },
							{ data: "createdDate" }, { data: "createdBy" }, { data: "modifiedDate" }, { data: "modifiedBy" },
							{ data: "action" }]

						});
					}

					function updateProducts() {
						document.productForm.action = "updateProduct.do";
						document.productForm.submit();
					}

					function addProducts() {
						document.productForm.action = "loadAddProductForm.do";
						document.productForm.submit();
					}

					function showProducts() {
						document.productForm.action = "showAllProducts.do";
						document.productForm.submit();
					}

				</script>
				</head>

				<body>
					<div id="loading"></div>
					<form:form name="productForm" id="productForm" modelAttribute="product">
						<input name="productId" id="productId" type="hidden" value="${product.productId}">
						<input name="erroMessage" id="erroMessage" type="hidden" value="${product.erroMessage}">
						<%-- <input name="homePageFormBean" id="homePageFormBean" type="text" value="${product.homePageFormBean}"> --%>

							<%-- <form:select cssStyle="" name="homePageFormBeanStr" multiple="true" id="homePageFormBeanStr" path="homePageFormBeanStr">
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.userName}">
					<form:option id="userName" selected="selected" value="${product.homePageFormBean.userName}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.password}">
					<form:option id="password" selected="selected" value="${product.homePageFormBean.password}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.mobileNumber}">
					<form:option id="mobileNumber" selected="selected" value="${product.homePageFormBean.mobileNumber}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.emailId}">
					<form:option id="emailId" selected="selected" value="${product.homePageFormBean.emailId}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.localeLanguage}">
					<form:option id="localeLanguage" selected="selected" value="${product.homePageFormBean.localeLanguage}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.localeFileName}">
					<form:option id="localeFileName" selected="selected" value="${product.homePageFormBean.localeFileName}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.searchBox}">
					<form:option id="searchBox" selected="selected" value="${product.homePageFormBean.searchBox}" />
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty product.homePageFormBean.currentLocation}">
					<form:option id="currentLocation" selected="selected" value="${product.homePageFormBean.currentLocation}" />
				</c:when>
			</c:choose>
		</form:select> --%>

								<div align="center">
									<h1>Product Detail</h1>
									<table border="1">
										<tr>
											<th>Product Name</th>
											<td>
												<input name="productName" id="productName" value="${product.productName}">
											</td>
										</tr>
										<tr>
											<th>Product Code</th>
											<td>
												<input name="productCode" id="productCode" value="${product.productCode}">
											</td>
										</tr>
										<tr>
											<th>Price</th>
											<td>
												<input name="price" id="price" value="${product.price}">
											</td>
										</tr>
										<tr>
											<th>Manufacturer</th>
											<td>
												<input name="manufacturer" id="manufacturer" value="${product.manufacturer}">
											</td>
										</tr>
										<tr>
											<th>Available Stock</th>
											<td>
												<input name="availableStock" id="availableStock" value="${product.availableStock}">
											</td>
										</tr>
										<tr>
											<th>Category</th>
											<td>
												<form:select name="categoryId" id="categoryId" path="categoryId">
													<form:option value="SELECT" id="SELECT" label="SELECT" />
													<form:options items="${categoryMap.categoryMaster}" />
												</form:select>
											</td>
										</tr>
									</table>
									<table>
										<tr>
											<td>
												<input type="button" id="addProductBtn" name="addProductBtn" value="SubmitForm" />
											</td>
											<td>
												<input type="button" id="showProductsBtn" name="showProductsBtn" value="Show All Products" />
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
								<!-- <div id="resultDiv"></div> -->
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
						<div id="resultDataTableDiv" class="scrollable" style="display: none;">
							<!-- <table id="resultDataTable" class="display" cellspacing="0" width="100%"> -->
							<table id="resultDataTable">
								<thead>
									<tr>
										<th>Product Id</th>
										<th>Product Name</th>
										<th>Product Code</th>
										<th>Price</th>
										<th>Manufacturer</th>
										<th>Available Stock</th>
										<th>Shop Id</th>
										<th>User Name</th>
										<th>Category Id</th>
										<th>Created Date</th>
										<th>Created By</th>
										<th>Modified Date</th>
										<th>Modified By</th>
										<th>Delete/Update</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Product Id</th>
										<th>Product Name</th>
										<th>Product Code</th>
										<th>Price</th>
										<th>Manufacturer</th>
										<th>Available Stock</th>
										<th>Shop Id</th>
										<th>User Name</th>
										<th>Category Id</th>
										<th>Created Date</th>
										<th>Created By</th>
										<th>Modified Date</th>
										<th>Modified By</th>
										<th>Delete/Update</th>
									</tr>
								</tfoot>
							</table>
						</div>

				</body>

			</html>