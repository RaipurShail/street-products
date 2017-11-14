<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item</title>

<script  type ="text/javascript">

function update()
{
	document.productForm.action="update.do";
	document.productForm.submit();
}

function getList()
{
	document.productForm.action="list.do";
	document.productForm.submit();
}

</script>
</head>

<body>

<form:form name="productForm" method="post" action="save.do" modelAttribute="item">
	<input name="item_code" type="hidden" value="${item.item_code}">
	<div align="center">
	<h1>Item Detail</h1>
		<table border="1">
			<tr>
				<th>Item Name</th>   
				<td> 
					<input name="item_name" value="${item.item_name}">
				</td>
			</tr>
			<tr>
				<th>Price</th>   
				<td> 
					<input name="price" value="${item.price}">
				</td>
			</tr>
			<tr>
				<th>Quantity</th>   
				<td> 
					<input name="qty" value="${item.qty}">
				</td>
			</tr>
			<tr>
				<th> 
					<input type="submit" value="Add New Item">   
				</th>   
				<th>   
					<input type="button" value="Update" onclick="update()"/>
					<input type="button" value="List" onclick="getList()"/>
				</th> 
			</tr>
		</table>
	</div>
</form:form>

<div align="center">
	<h1>Item List</h1>
	<table border="1">
		<tr>
			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Action</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${itemList}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${item.item_code}</td>
				<td>${item.item_name}</td>
				<td>${item.price}</td>
				<td>${item.qty}</td>
				<td><a href="edit.do?id=${item.item_code}">Edit</a></td>  
				<td><a href="delete.do?id=${item.item_code}">Delete</a></td>  
			</tr>
		</c:forEach>             
	</table>
</div>             

</body>
</html>