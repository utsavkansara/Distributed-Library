<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.bookAvail"%>
<jsp:include page="header.jsp"></jsp:include>

<html>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/start/jquery-ui.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/dataTables.jqueryui.min.css" />
<head>
<style type="text/css">
.star-rating {
	font-size: 0;
	white-space: nowrap;
	display: inline-block;
	width: 150px;
	height: 30px;
	overflow: hidden;
	position: relative;
	background:
		url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjREREREREIiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
	background-size: contain;
}

.star-rating i {
	opacity: 0;
	position: absolute;
	left: 0;
	top: 0;
	height: 100%;
	width: 20%;
	z-index: 1;
	background:
		url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjRkZERjg4IiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
	background-size: contain;
}

.star-rating input {
	-moz-appearance: none;
	-webkit-appearance: none;
	opacity: 0;
	display: inline-block;
	width: 20%;
	height: 100%;
	margin: 0;
	padding: 0;
	z-index: 2;
	position: relative;
}

.star-rating input:hover+i, .star-rating input:checked+i {
	opacity: 1;
}

.star-rating i ~ i {
	width: 40%;
}

.star-rating i ~ i ~ i {
	width: 60%;
}

.star-rating i ~ i ~ i ~ i {
	width: 80%;
}

.star-rating i ~ i ~ i ~ i ~ i {
	width: 100%;
}

.choice {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	text-align: center;
	padding: 20px;
	display: block;
}
</style>
</head>

<body>
	<div>&nbsp;</div>

	<div align="center">
		<div style="width: 80%" align="center">


			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th><label>Order #</label></th>
						<th><label>Book Id</label></th>
						<th><label>Confirmation #</label></th>
						<th><label>Date ordered</label></th>
						<th><label>Start Date</label></th>
						<th><label>End Date</label></th>
						<th><label>Choose a rating</label></th>
						<th><label>Code</label></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${userOrdersDetails}" var="result">

						<tr>

							<td><label>${result.id}</label></td>



							<td><a
								href="${pageContext.request.contextPath}/convertToParentBook/${result.bookId}">${result.bookId}</a>
							</td>

							<td><label>${result.confirmationNumber}</label></td>

							<td><label>${result.dateOfOrder}</label></td>

							<td><label>${result.startDate}</label></td>

							<td><label>${result.endDate}</label></td>

							<td><span id="${result.id}span" class="star-rating">
									<input type="radio" name="${result.id}1" id="${result.id}1"
									value="1" onClick="noteRating(${result.id}, 1);"><i></i>
									<input type="radio" name="${result.id}2" id="${result.id}2"
									value="2" onClick="noteRating(${result.id}, 2);"><i></i>
									<input type="radio" name="${result.id}3" id="${result.id}3"
									value="3" onClick="noteRating(${result.id}, 3);"><i></i>
									<input type="radio" name="${result.id}4" id="${result.id}4"
									value="4" onClick="noteRating(${result.id}, 4);"><i></i>
									<input type="radio" name="${result.id}5" id="${result.id}5"
									value="5" onClick="noteRating(${result.id}, 5);"><i></i>
							</span></td>

							<td align="center"><span id="${result.id}spanCode"
								class="codeConfirmation"> <input
									id="${result.id}codeInput" name="${result.id}codeInput"
									type="text" placeholder="Confirmation Code"
									class="form-control input-md" value="" style="width: 90%" /> <br>
									<a class="btn btn-primary" href="#"
									onClick="confirmCode(${result.id});" role="button">Confirm</a>
									<br /> <label id="${result.id}label" style="font-color: red"></label>
							</span> <span id="${result.id}spanCodeComplete" class="codeConfirmation"
								style="visibility: hidden"> <label
									style="font-color: green">Order complete</label>
							</span></td>

						</tr>



					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>




</body>
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>

<script>
function noteRating(id,value){
	
	//alert('' + id + ' - ' + value);
	
	$.ajax({ 
		   type: "POST",
		   url: "../feedback/" + id + "/" + value,
		   success: function(res){  
			   
			   $("#" + id +"span").attr('title', 'Feedback already submitted!');
				for (var a =1;a <= 5; a++)
					$( "#" + id +'' +  a ).prop( 'disabled', true );
		      	alert('feedback submitted');
		   	}
		});
	
	
}

function confirmCode(orderId){
	
	var code = document.getElementById(orderId+'codeInput').value;
	$.ajax({ 
		   type: "POST",
		   url: "../codeConfirm/" + orderId + "/" + code,
		   success: function(res){  
			   console.log(res);
			
			   if(res == 'N')
				   $("#"+orderId+"label").val('try again later');
			   else if(res == 'Y'){
			   		document.getElementById(orderId +"spanCode").style.visibility='hidden';
			   		document.getElementById(orderId +"spanCodeComplete").style.visibility='visible';
			   }else if(res == "Inactive order"){
				   	
			   			$("#"+orderId +"label").html(res);

			   }
			   		else{
			   			$("#"+orderId +"label").html("invalid session");
			   			//document.getElementById(orderId +"label").text='invalid session';
			   			}				   
		   	}
		});
	
	
}
jQuery( document ).ready(function( ) {

	
	function setPreviousRating(){
		
		<c:forEach items='${userOrdersDetails}' var='ord' varStatus='i'>
		
		var orderid = ${ord.id};
		var feedback = ${ord.feedback} ;
		var active = ${ord.active};
			if(feedback != '0')	{
				var id = orderid +'' +  feedback;
				document.getElementById(id).checked=true;
				$("#" + orderid +"span").attr('title', 'Feedback already submitted!');
				for (var a =1;a <= 5; a++)
					$( "#" + orderid +'' +  a ).prop( 'disabled', true );
			}
		
			if(active == 0){
				
				document.getElementById(orderid +"spanCode").style.visibility='hidden';
		   		document.getElementById(orderid +"spanCodeComplete").style.visibility='visible';
			}
	
	</c:forEach>
		
}
	
	setPreviousRating();
  // Code that uses jQuery's $ can follow here.
	  jQuery('#example').DataTable();
});

</script>
</html>