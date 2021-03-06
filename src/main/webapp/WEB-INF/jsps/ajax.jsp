<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot - AJAX POST GET Example</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/postrequest.js"></script>
<script src="/js/getrequest.js"></script>

</head>
<body>





<div class="container">
 
  <h3 style="color:blue">POST-GET AJAX Example</h3>
  
  <div>
    <form class="form-inline" style="margin:20px 20px 20px 20px" id="customerForm">
      <div class="form-group">
        <label for="firstname" style="margin-right:5px">FirstName:</label>
        <input type="text" class="form-control" id="firstname" placeholder="Enter FirstName"/>
      </div>
      <div class="form-group">
        <label for="lastname" style="margin-left:20px; margin-right:5px">LastName:</label>
        <input type="text" class="form-control" id="lastname" placeholder="Enter LastName"/>
      </div>
      <button type="submit" class="btn btn-default" style="margin-left:20px; margin-right:5px">Submit</button>
    </form>
  </div>
  
  <div class="col-sm-7" id="postResultDiv">
  </div>
  
  <div class="col-sm-7" style="margin:20px 0px 20px 0px">
    <button id="getAllCustomerId" type="button" class="btn btn-primary">Get All Customers</button>
    <div id="getResultDiv" style="padding:20px 10px 20px 50px">
          <ul class="list-group">
        </ul>
      </div>
  </div>
  
</div>




</body>

<script type="text/javascript">

$( document ).ready(function() {
	  
	  // SUBMIT FORM
	    $("#customerForm").submit(function(event) {
	    // Prevent the form from submitting via the browser.
	    event.preventDefault();
	    ajaxPost();
	  });
	    
	    
	    function ajaxPost(){
	      
	      // PREPARE FORM DATA
	      var formData = {
	        firstname : $("#firstname").val(),
	        lastname :  $("#lastname").val()
	      }
	      
	      // DO POST
	      $.ajax({
	      type : "POST",
	      contentType : "application/json",
	      url : "http://localhost/api/customer/save",
	      data : JSON.stringify(formData),
	      dataType : 'json',
	      success : function(result) {
	        if(result.status == "Done"){
	          $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
	                        "Post Successfully! <br>" +
	                        "---> Customer's Info: FirstName = " + 
	                        result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
	        }else{
	          $("#postResultDiv").html("<strong>Error</strong>");
	        }
	        console.log(result);
	      },
	      error : function(e) {
	        alert("Error!")
	        console.log("ERROR: ", e);
	      }
	    });
	      
	      // Reset FormData after Posting
	      resetData();
	 
	    }
	    
	    function resetData(){
	      $("#firstname").val("");
	      $("#lastname").val("");
	    }



//=============================
	    $("#getAllCustomerId").click(function(event){
	        event.preventDefault();
	        ajaxGet();
	      });
	      
	      // DO GET
	      function ajaxGet(){
	        $.ajax({
	          type : "GET",
	          url : "http://localhost/api/customer/all",
	          success: function(result){
	            if(result.status == "Done"){
	              $('#getResultDiv ul').empty();
	              var custList = "";
	              $.each(result.data, function(i, customer){
	                var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + ", lastName = " + customer.lastname + "<br>";
	                $('#getResultDiv .list-group').append(customer)
	                  });
	              console.log("Success: ", result);
	            }else{
	              $("#getResultDiv").html("<strong>Error</strong>");
	              console.log("Fail: ", result);
	            }
	          },
	          error : function(e) {
	            $("#getResultDiv").html("<strong>Error</strong>");
	            console.log("ERROR: ", e);
	          }
	        });  
	      }

	    
	})
	
	
	
	

</script>


</html>