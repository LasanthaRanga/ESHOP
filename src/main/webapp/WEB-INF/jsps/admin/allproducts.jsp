<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>

<body>
	<h1>All Products</h1>
	<input type="hidden" id="iduser" value="${sessionScope.user.idUser}">
	<table>
		<thead>
			<td>Image</td>
			<td>Product Name</td>
			<td>Price</td>
			<td>Code</td>
			<td>Add To Shop</td>
		</thead>
		<tbody>

			<c:forEach items="${items}" var="item">
				<tr>

					<td><c:forEach items="${item.value.images}" var="image">
							<c:if test="${image.imageStatus!=null}">
								<img width="200px" height="200px" src="${image.getImagePath()}" />
							</c:if>
						</c:forEach></td>

					<td>${item.key}</td>
					<td>${item.value.productName}</td>
					<td>${item.value.productCode}</td>


					<td><c:if test="${item.value.productStatus2==0}">
							<button class="btn-dif" value="${item.value.idProduct}" onclick="myFunction(this.value)"
								>Add To Shop</button>
						</c:if> <c:if test="${item.value.productStatus2==1}">
						AllRady Added To Shop
					</c:if></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>





</body>


<script src="vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">

function myFunction(x) {
	var user = $('#iduser').val();
	alert(x);
	var formData = {
 			key : user,
 			val : x
 	}
 	alert(formData.key +" " +formData.val);

	$.ajax({
	      type : "POST",
	      contentType : "application/json",
	      url : "http://localhost/addtoshopAjax",
	      data : JSON.stringify(formData),
	      dataType : 'json',
	      success : function(result) {
	        if(result.status == "Done"){
				alert("done");
	        }else{
	        	alert("NO");
	        }
	        console.log(result);
	      },
	      error : function(e) {
	        alert("Error!")
	        console.log("ERROR: ", e);
	      }
	    });


 	
}

</script>





</html>