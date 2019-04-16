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
	<h1>Add To Shop</h1>


	<h2></h2>



	<c:forEach items="${items}" var="Product">

		<!-- 	
		<c:forEach items="${Product.getImages()}" var="Image">
			<c:choose>
				<c:when test="${Image.imageStatus!=null}">
					<img class="img-fluid" src="${Image.imagePath}"
						alt="${Image.imagePath}">
				</c:when>
			</c:choose>
		</c:forEach>
		 -->
		<h6>${Product.productName}</h6>
		
		<input type="hidden" id="pid" name="pid" value=""/>	
		<button class="test" value="${Product.idProduct}" onclick="test()">TEST</button>	
		
		<!-- 	<c:forEach items="${Product.getPrices()}" var="Price">
			<c:choose>
				<c:when test="${Price.priceStatus==1}">
					<div class="price">
						<h6>LKR. ${Price.selling}0</h6>
						<h6 class="l-through">LKR. ${Price.biforDiscount}0</h6>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>
		-->

	</c:forEach>



	


</body>

<script src="vendor/jquery/jquery.min.js"></script>

<script type="text/javascript">


function test(){
// 	var pid = #("pid").val();
//	console.log(this.val());
}


	function addItem() {

		$.ajax({
			url : 'http://localhost:80/subcat2/' + id,
			type : "POST",
			success : function(result) {

				 $('#subcat2').append($('<option>', {
					value : 0,
					text : 'Please select Sub Cat2'
				}));

				console.log(result);
				$.each(result, function(i, item) {
					$('#subcat2').append($('<option>', {
						value : item.idSubcat2,
						text : item.subcat2name,
					}));
				});
			},
			error : function(error) {
				console.log(`Error ${error}`)
			}
		});

	}
</script>




</html>