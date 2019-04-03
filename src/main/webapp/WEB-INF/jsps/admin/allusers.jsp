<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="allusers" />
<c:set var="collaps" value="users" />
<%@ include file="/WEB-INF/jsps/template/adminHead.jsp"%>

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
<!-- 			<h2>All Users</h2> -->
		</div>
	</div>


	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			

				
			<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary"> All Users </h6>
            </div>
            <div class="card-body">

					<div class="table-responsive">
						<!--<table class="table table-bordered table-striped table-hover js-basic-example dataTable"> -->
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>UserName</th>
									<th>Email</th>
									<th>Gender</th>
									<th>Type</th>
									<th>Details</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="User">
									<tr>
										<td>${User.userName} </td>
										<td>${User.userEmail}</td>
										<td>${User.gender}</td>
										<td>${User.getUsertype().getUserTypeName()}</td>
										<td><a href="selectUser?uid=${User.idUser}">Find More</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			</div>
		</div>
	
</section>


<%@ include file="/WEB-INF/jsps/template/adminFoot.jsp"%>
