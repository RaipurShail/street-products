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
<script type="text/javascript">

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

	<form:form name="productForm" action="addProduct.do" modelAttribute="product">
		<input name="productId" type="hidden" value="${product.productId}">
		<div align="center">
			<h1>Product Detail</h1>
			<table border="1">
				<tr>
					<th>Product Name</th>
					<td><input name="productName" value="${product.productName}">
					</td>
				</tr>
				<tr>
					<th>Product Code</th>
					<td><input name="productCode" value="${product.productCode}">
					</td>
				</tr>
				<tr>
					<th>Price</th>
					<td><input name="price" value="${product.price}"></td>
				</tr>
				<tr>
					<th>Manufacturer</th>
					<td><input name="manufacturer" value="${product.manufacturer}">
					</td>
				</tr>
				<tr>
					<th>Available Stock</th>
					<td><input name="availableStock"
						value="${product.availableStock}"></td>
				</tr>
				<tr>
					<th>Category</th>
					<td>
						<form:select name="categoryId" path="categoryId">
							<form:option value="SELECT" id="SELECT" label="SELECT"/>
							<form:options items="${categoryMap.categoryMaster}" />
						</form:select>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<input type="submit" name="submit" value="SubmitForm"/>
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