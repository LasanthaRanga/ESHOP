<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="subcat2" />
<c:set var="collaps" value="category" />

<%@ include file="../template/adminHead.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Sub Category Two</h1>


<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Add New Catagory</h6>
	</div>
	<div class="card-body">

		<form method="post" , action="saveSubcatTwo">
			<div class="col-sm-6">
				<label for="Main Catagory">Sub Category One</label> <select
					class="form-control show-tick" name="Subcat1">
					<option value="0">-- Please select Main Cat--</option>
					<c:forEach items="${allscat1}" var="Subcat1">
						<option value="${Subcat1.idSubcat1}">${Subcat1.subcat1name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-6">
				<label for="Sub Category">Sub Category Two</label>
				<div class="form-group">
					<div class="form-line">
						<input type="text" name="subcat2name" id="" class="form-control"
							placeholder="">
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary m-t-15 waves-effect">Save</button>
		</form>
	</div>
</div>

<!-- DataTales Example -->
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
						<th>Sub Category One Name</th>
						<th>Sub Category Two Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allscat2}" var="Subcat2">
						<tr>
							<td>${Subcat2.getSubcat1().subcat1name}</td>
							<td>${Subcat2.subcat2name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<%@ include file="../template/adminFoot.jsp"%>