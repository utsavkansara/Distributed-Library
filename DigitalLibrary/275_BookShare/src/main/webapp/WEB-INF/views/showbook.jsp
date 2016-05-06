<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.MongoBook" %>
<jsp:include page="navbar.jsp" />
<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
  
	<style type="text/css">
	div#map_container{
		width:550px;
		height:350px;
	}
	</style> 
	<script>
		$(document).ready(function(){
	 		var geocoder = new google.maps.Geocoder();
			var address = document.getElementById('address').value;
    		geocoder.geocode( { 'address': address}, function(results, status) {
      		if (status == google.maps.GeocoderStatus.OK) {
    	  		var res = String(results[0].geometry.location).split(",");
	    	    res[0] = res[0].replace("(","").trim();
	    	    res[1] = res[1].replace(")","").trim();
	    	   
	    	    var latlng = new google.maps.LatLng(res[0], res[1]);
	    	    var myOptions = {
	    	      zoom: 15,
	    	      center: latlng,
	    	      mapTypeId: google.maps.MapTypeId.ROADMAP
	    	    };
	    	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
    	 
	    	    var marker = new google.maps.Marker({
	    	      position: latlng, 
	    	      map: map, 
	    	      title:address
	    	    }); 
      		
      		} else {
    	  
		    	var latlng = new google.maps.LatLng(37.3357192, -121.8867076);
		  	    var myOptions = {
		  	      zoom: 15,
		  	      center: latlng,
		  	      mapTypeId: google.maps.MapTypeId.ROADMAP
		  	    };
		  	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
		  	 
		  	    var marker = new google.maps.Marker({
		  	      position: latlng, 
		  	      map: map, 
		  	      title:address
		  	    }); 
    	  	}
      
        	});    
		});


		
	
	</script>
</head>

<body>
<% MongoBook Book = (MongoBook)request.getAttribute("bookdetails"); 
%>
	<div class="container-fluid">
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Book Details</div>
				<table class="table">					
					<tr class="active">
					    <td colspan="3">
					  		<img src="${bookdetails.getImage()}" height="100" width="100">
					    </td>
					</tr>
					
					<tr class="info">
					    <td><label>Title</label></td>
					    <td><label>${bookdetails.title}</label>
						<input type="hidden" id="bookId" value="${bookdetails.bookId}"></input>
						<input type="hidden" id="redirectTo" value="${redirectTo}"></input>
						<input type="hidden" id="redirectToBuy" value="${redirectToBuy}"></input>
						<input type="hidden" id="owner" value="${owner}"></input></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Author</label></td>
					    <td>
					    <ul>
					    	<c:forEach var="authorValue" items="${bookdetails.getAuthors()}">
							<li>${authorValue}</li>
							</c:forEach>
						</ul>
						</td>
					    <td></td>
					</tr>
					
					
					
					<tr class="info">
					    <td><label>Description</label></td>
					    <td>${bookdetails.description}</td>
					    <td></td>
					</tr>
					 
					
					
					<tr class="info">
					    <td><label>Rating</label></td>
					    <td>${bookdetails.rating}</td>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Language</label></td>
					    <td>${bookdetails.language}></td>
					    <td></td>
					    
					</tr>
					
					
					<tr class="info">
					    <td><label>Publisher</label></td>
					    <td>${bookdetails.publisher}</td>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Page Count</label></td>
					    <% if(0 != Book.getPageCount()){ %>
					    	<td>${bookdetails.pageCount}</td>
					    <% } else {%>
							<td>No Info available</td>
						<% } %>
					    <td></td>
					    
					</tr>
					
					
					<tr class="info">
					    <td><label>ISBN#</label></td>
					    <% if(!Book.getIsbn().equals("")){ %>
					    	<td>${bookdetails.isbn}</td>
					    <% } else {%>
							<td>No Info available</td>
						<% } %>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Categories</label></td>
					    <td>
					    <ul>
					    	<c:forEach var="catValue" items="${bookdetails.getCategories()}">
							<li>${catValue}</li>
							</c:forEach>
						</ul>
						</td>
					    <td></td>
					</tr>
					
					
					
					<tr class="info">
					    
					    <% if(null != session.getAttribute("USERNAME")) {%> 
					    	<td colspan="2" align="right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/requestbook" role="button">Make a request</a>
					    <% } %>
							
					   
					    
					</tr>
					
					
					
					
					
					<tr>
					    <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
					</tr>
				</table>
			</div>
		</div>
	    	<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Pickup Address</div>
				<table class="table table-striped">
					
		    		<tr>
					    <td><label>${addressdetails}</label>
					    <input type="hidden" id="address" value="${addressdetails}"></input></td>
						
					</tr>

		    		<tr>
						<td><div id="map_container" align="center"></div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>		
</body>
</html>