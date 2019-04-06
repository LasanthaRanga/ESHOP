<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="profile" />
<c:set var="collaps" value="users" />

<%@ include file="../template/adminHead.jsp"%>

<!-- Page Heading -->



<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">User Profile</h6>
	</div>
	<div class="card-body">


		<h1>${user.idUser}</h1>

		<h1>${user.getUsertype().getUserTypeName()}</h1>


		<h1>${user.userName}</h1>

		<h1>${user.userEmail}</h1>

		<h1>${user.gender}</h1>






	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Update Profile Data</h6>
	</div>
	<div class="card-body">
		<form method="post" action="update">
			<div class="form-row">

				<div class="col-sm-4">
					<label for="userName">Full Name</label> <input type="text"
						name="userName" value="${user.userName}"
						class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="userNic">NIC</label> <input type="text" name="userNic"
						value="${user.userName}" class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="userContact1">Mobile Number 1</label> <input
						type="text" name="userContact1" value="${user.userContact1}"
						class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="userContact2">Phone Number</label> <input type="text"
						name="userContact2" value="${user.userContact2}"
						class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="userAddress1">Address Line 1</label> <input type="text"
						name="userAddress1" value="${user.userAddress1}"
						class="form-control show-tick">
				</div>
				<div class="col-sm-4">
					<label for="userAddress2">Address Line 2</label> <input type="text"
						name="userAddress2" value="${user.userAddress2}"
						class="form-control show-tick">
				</div>
				<div class="col-sm-4">
					<label for="userAddress3">Address Line 3</label> <input type="text"
						name="userAddress3" value="${user.userAddress3}"
						class="form-control show-tick">
				</div>
				<div class="col-sm-4">
					<label for="userPostalCode">Postal Code</label> <input type="text"
						name="userPostalCode" value="${user.userPostalCode}"
						class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="gender">Male</label> <input type="radio"
						<c:if test="${user.gender.equals('Male')}">checked="checked"</c:if>
						name="gender" value="Male"> <label for="gender">Female</label>
					<input type="radio"
						<c:if test="${user.gender.equals('Female')}">checked="checked"</c:if>
						name="gender" value="Female">
				</div>
				<div class="col-sm-4">
					<label for="userDiscription">Postal Code</label>
					<textarea rows="4" name="userDiscription"
						value="${user.userDiscription}" class="form-control show-tick"></textarea>
				</div>

				<div class="col-sm-4">
					<input type="submit" name="Update">

				</div>
		</form>

		<hr>
		
		<div>
			<img alt="" src="${user.userPic}">
		</div>
		
		<div>
			<p>Upload Profile Picture</p>
			<form action="/uploadProPic" method="post"
				enctype="multipart/form-data">
				<div class="form-row">
					<div class="form-group col-sm-4">
						<input type="file" name="file"
							class="btn btn-light btn-icon-split"><br> <br>
						<input type="hidden" name="uid"
							value="${sessionScope.user.idUser}"> <input type="submit"
							value="Submit" class="btn btn-primary">
					</div>
				</div>
			</form>
		</div>


	</div>
</div>


<%@ include file="../template/adminFoot.jsp"%>