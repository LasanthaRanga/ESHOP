<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="maincat" />
<c:set var="collaps" value="category" />

<%@ include file="../template/adminHead.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Main Category</h1>


<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Add New Catagory</h6>
	</div>
	<div class="card-body">

		<form method="post" , action="saveMaincat">
			<label for="Main Catagory"></label>
			<div class="form-group">
				<div class="form-line">
					<input type="text" name="maincatName" id="" class="form-control"
						placeholder="Enter your email address">
				</div>
			</div>
			<button type="submit" class="btn btn-primary m-t-15 waves-effect">Add</button>
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
						<th>Category Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allmcat}" var="Maincat">
						<tr>
							<td>${Maincat.maincatName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../template/adminFoot.jsp"%>
