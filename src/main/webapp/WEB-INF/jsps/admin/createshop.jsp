<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="createshop" />
<c:set var="collaps" value="shop" />

<%@ include file="../template/adminHead.jsp"%>
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">My Shop Name : ${shop.shopName}</h6>
	</div>
	<div class="card-body">

		<c:if test="${shop==null}">
			<form method="post" action="createshop">
				<label for="">Shop Name</label> <input name="shopName" type="text" />
				<label for="">Description</label>
				<textarea rows="4" cols="" name="shopDiscription"></textarea>
				<input type="submit" name="Create Shop">
			</form>
		</c:if>


				
	
		<h4>Shop Details</h4>
		<p>Start Date : ${shop.shopStartDate}</p>
		<p>Start Description : ${shop.shopDiscription}</p>



	</div>
</div>
<%@ include file="../template/adminFoot.jsp"%>