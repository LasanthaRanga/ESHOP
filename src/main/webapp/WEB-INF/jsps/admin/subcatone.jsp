<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="subcat1" />
<c:set var="collaps" value="category" />



<%@ include file="../template/adminHead.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Sub Category One</h1>


<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Add New Catagory</h6>
	</div>
	<div class="card-body">
		<form method="post" , action="saveSubcatOne">
			<div class="col-sm-6">
				<label for="Main Catagory">Sub Category One</label> <select
					class="form-control show-tick" name="Maincat">
					<option value="0">-- Please select Subcat Two--</option>
					<c:forEach items="${allmcat}" var="Maincat">
						<option value="${Maincat.idMaincat}">${Maincat.maincatName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-6">
				<label for="Sub Category">Sub Category Two</label>
				<div class="form-group">
					<div class="form-line">
						<input type="text" name="subcat1name" id="" class="form-control"
							placeholder="">
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary m-t-15 waves-effect">Save</button>
		</form>
	</div>
</div>


<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
	</div>
	<div class="card-body">


		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Category Name</th>
						<th>Sub Catebory One Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allscat1}" var="Subcat1">
						<tr>
							<td>${Subcat1.getMaincat().maincatName}</td>
							<td>${Subcat1.subcat1name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>




<%@ include file="../template/adminFoot.jsp"%>