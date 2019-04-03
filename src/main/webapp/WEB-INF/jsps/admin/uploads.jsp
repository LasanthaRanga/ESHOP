<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="uploads" />
<c:set var="collaps" value="items" />



<%@ include file="../template/adminHead.jsp"%>

<div class="col-md4">
	<div class="card m-0 font-weight-bold text-primary">
		<div class="card-header">Upload Product Image</div>
		<div class="card-body">
			<h5 class="card-title">${item.productName}</h5>

	<form action="/upload" method="post" enctype="multipart/form-data">

<div class="form-row">
<div class="form-group col-sm-4">
		<input type="file" name="file" class="btn btn-light btn-icon-split"><br> <br>
		<input type="hidden"
			name="pid" value="${item.idProduct}">
		<input type="submit" value="Submit" class="btn btn-primary">
</div>
</div>
	</form>
	
	</div>
	</div>

</div>


<c:forEach items="${item.getImages()}" var="Image">



						<img alt="ASDF" src="${Image.getImagePath()}">
</c:forEach>

<a href="/onepro/${item.idProduct}">Upload Complete</a>

<img alt="ssssss" src="uploads\image_3cfb7f9673.jpg">

<%@ include file="../template/adminFoot.jsp"%>