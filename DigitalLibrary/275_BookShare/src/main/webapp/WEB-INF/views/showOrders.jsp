<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.bookAvail" %>
<jsp:include page="navbar.jsp"></jsp:include>

<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> 
  
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<style type="text/css">
	div#map_container{
		width:550px;
		height:350px;
	}
	</style> 
	
</head>

<body>


<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Orders</div>
				
				<table class="table">	
				 <tr class="active">
			                <td><label>Order #</label></td>
			                <td><label>Book Id</label></td>
			                <td><label>Confirmation #</label></td>
			                <td><label>Date ordered</label></td>
			                <td><label>Start Date</label></td>
			                <td><label>End Date</label></td>
			            </tr>
				            
			            
		            <c:forEach items="${userOrdersDetails}" var="result">
			            
			            <tr class="info">
			                
			                <td><label>${result.id}</label></td>
			                
			            
			               
			                <td><a  href="${pageContext.request.contextPath}/convertToParentBook/${result.bookId}" >${result.bookId}</a>
			                </td>
			           
			                <td><label>${result.confirmationNumber}</label></td>
			           
			                <td><label>${result.dateOfOrder}</label></td>
			            
			                <td><label>${result.startDate}</label></td>
				       
			                <td><label>${result.endDate}</label></td>
				        </tr>
		             	
<%-- 	             		<c:if test="${result.sellerFeedback == 0}"> --%>
<!-- 						   <td colspan="2" align="right"> -->
<%-- 			                	<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/seller/${result.transactionId}" role="button">Feedback</a> --%>
<!-- 			                </td> -->
<%-- 						</c:if>	 --%>
						            
					</c:forEach>					
				</table>
			</div>
		</div>



    				
</body>
</html>