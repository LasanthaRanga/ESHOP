<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="saveitem" />
<c:set var="collaps" value="items" />



<%@ include file="../template/adminHead.jsp"%>


<%-- <c:if test="${sessionScope.user!=null}"> --%>
<%-- 	<c:redirect url = "/"/> --%>
<%-- </c:if> --%>




<div class="card m-0 font-weight-bold text-primary">
	<div class="card-header">Add New Item</div>
	<div class="card-body">
		<h5 class="card-title">Fill This Form</h5>
		<form action="additem" method="post">
			<div class="form-row">
				<div class="form-group col-sm-4">
					<label for="exampleFormControlSelect1">Example select</label> <select
						class="form-control selectpicker" data-style="btn btn-link"
						name="maincat" id="maincat">
						<option value="0">Please select Main Cat</option>
					</select>
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Sub Category One</label> <select
						class="form-control show-tick" name="subcat1" id="subcat1">
						<option value="0">Please select Sub Cat</option>
					</select>
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Sub Category Two</label> <select
						class="form-control show-tick" name="subcat2" id="subcat2">
						<option value="0">Please select Sub Cat two</option>
					</select>
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Product Name</label> <input type="text"
						name="productName" class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Product Code</label> <input type="text"
						name="productCode" class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Product Volume</label> <input
						type="text" name="productVolume" class="form-control show-tick">
				</div>

				<div class="col-sm-4">
					<label for="Main Catagory">Other 1</label> <input type="text"
						name="productcol1" class="form-control show-tick">
				</div>
				<div class="col-sm-4">
					<label for="Main Catagory">Other 2</label> <input type="text"
						name="productcol2" class="form-control show-tick">
				</div>
				<div class="col-sm-4">
					<label for="Main Catagory">Other 3</label> <input type="text"
						name="productcol3" class="form-control show-tick">
				</div>
				<div class="col-sm-6">
					<label for="Main Catagory">Product Description</label>
					<textarea type="text" name="productDescription"
						class="form-control show-tick"></textarea>
				</div>


			</div>
			<br />
			<div class="col-sm-6">
				<label class="radio"> <input type="radio"
					name="productGender" value="1" /> Male
				</label> <br /> <label class="radio"> <input type="radio"
					name="productGender" value="0" /> Female
				</label> <br /> <label class="radio"> <input type="radio"
					name="productGender" value="2" /> Any
				</label>
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Buying Price :</label> <input type="number"
					id="bprice" name="buying" class="form-control show-tick">
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Profit :</label> <input type="number"
					id="profit" name="profit" class="form-control show-tick">
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Other Price</label> <input type="number"
					id="other" name="others" class="form-control show-tick">
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Selling Price</label> <input type="number"
					id="selling" name="selling" class="form-control show-tick">
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Coin Value</label> <input type="number"
					id="coinval" name="coinval" class="form-control show-tick">
			</div>
			<div class="col-sm-4">
				<h4 id="ccont">0</h4>
			</div>
			
			<div class="col-sm-4">
				<label for="Main Catagory">Before Discount</label> <input
					type="text" id="bd" name="biforDiscount" class="form-control show-tick">
			</div>
			

			<div class="col-sm-4">
				<label for="Main Catagory">Discount Rate</label> <input type="text"
					id="dr" name="discountRate" class="form-control show-tick">
			</div>

			<div class="col-sm-4">
				<label for="Main Catagory">Discount Price</label> <input type="text"
					id="dv" name="discountPrice" class="form-control show-tick">
			</div>

			
			<div class="col-sm-6">
				<button type="submit" class="btn btn-primary">Register
					Product</button>
			</div>
		</form>
	</div>
</div>


<%@ include file="../template/adminFoot.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {

		$('#maincat').empty();
		const Url = 'http://localhost:80/maincat';

		$.ajax({
			url : Url,
			type : "GET",

			success : function(result) {

				$('#maincat').append($('<option>', {
					value : 0,
					text : 'Please select Main Cat'
				}));
				$.each(result, function(i, item) {
					$('#maincat').append($('<option>', {
						value : item.idMaincat,
						text : item.maincatName
					}));
				});

			},
			error : function(error) {
				console.log(`Error ${error}`)
			}
		})

	});

	$('#maincat').on("change", function() {
		var id = this.value;
		$('#subcat1').empty();

		$.ajax({
			url : 'http://localhost:80/subcat/' + id,
			type : "GET",
			success : function(result) {

				$('#subcat1').append($('<option>', {
					value : 0,
					text : 'Please select Sub Cat'
				}));

				console.log(result);
				$.each(result, function(i, item) {
					$('#subcat1').append($('<option>', {
						value : item.idSubcat1,
						text : item.subcat1name,
					}));
				});
			},
			error : function(error) {
				console.log(`Error ${error}`)
			}
		});
	});

	$('#subcat1').on("change", function() {
		var id = this.value;
		$('#subcat2').empty();

		$.ajax({
			url : 'http://localhost:80/subcat2/' + id,
			type : "GET",
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
	});





var bp=0;
var pro=0;
var oth=0;
var sel=0;
var cov=0;
var bifo = 0;
var disr = 0;
var disval = 0;
	
	$('#bprice').keyup(function() {
		cov=0;
		bp = parseFloat($("#bprice").val());
		cal();
		$('#coinval').val(cov);

	});
	$('#profit').keyup(function() {
		cov=0;
		pro = parseFloat($("#profit").val());
		cal();
		$('#coinval').val(cov);

	});
	$('#other').keyup(function() {
		cov=0;
		oth = parseFloat($("#other").val());
		cal();
		$('#coinval').val(cov);

	});
	$('#selling').keyup(function() {
		cov=0;
		sel = parseFloat($("#selling").val());
		cal();
		$('#coinval').val(cov);
	});

	$('#bd').keyup(function() {
		
		bifo = parseFloat($("#bd").val());		
		discal();
		$('#dr').val(disr);
		$('#dv').val(disval);
		
	});

	function discal(){
		disval = bifo -sel;
		disr = disval/bifo *100;
		disr = disr.toFixed(2);	
	}

	function cal(){
		cov = sel-(bp+pro+oth)
	}
</script>
