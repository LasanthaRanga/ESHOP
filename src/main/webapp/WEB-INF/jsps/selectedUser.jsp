<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="allusers" />
<c:set var="collaps" value="users" />
<%@ include file="/WEB-INF/jsps/template/adminHead.jsp"%>


<c:if test="${sessionScope.user==null}">
	
</c:if>

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
<!-- 			<h2>All Users</h2> -->
		</div>
	</div>

<div class="card m-0 font-weight-bold text-primary">
		<div class="card-header">Selected User ${user.userName}</div>
		<div class="card-body">

			<h3>${user.userName}</h3>
			<h3>${user.userNic}</h3>
			<h3>${user.userEmail}</h3>
			<h3>${user.getUsertype().getUserTypeName()}</h3>
			<h3>${user.userEmail}</h3>

			<hr>
			<h3>Change User Type</h3>
			<form action="" method="post">
				<div class="col-sm-4">
					<label for="Main Catagory">User Type</label> 
					<select class="form-control show-tick" name="usertype" id="">
						<option value="0">User Type</option>
						<option value="2">RESELLER</option>
						<option value="3">SUPPLIER</option>
						<option value="4">CUSTOMER</option>
					</select>
				</div>
				<br>
				<div class="col-sm-4">
				<button type="submit" class="btn btn-primary"> Change User Type </button>
			</div>
			</form>	

	</div>
</div>

</section>
<%@ include file="/WEB-INF/jsps/template/adminFoot.jsp"%>

