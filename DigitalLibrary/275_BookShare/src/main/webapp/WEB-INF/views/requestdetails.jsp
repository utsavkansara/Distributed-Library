<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script>
	
	
function chooseBook(){
	var subBookId= document.getElementById('subbookId').value;
	window.location = "./paymentDetails/" + subBookId;
}
	
		function changeMap(subId, latitude, longitude){
			document.getElementById('divChoose').style.visibility='visible';
			 document.getElementById('subbookId').value = subId;
	    	   var geocoder = new google.maps.Geocoder();
				var address = "101 E San Fernando, San Jose, CA, 95112";
	    		geocoder.geocode( { 'address': address}, function(results, status) {
	      		if (status == google.maps.GeocoderStatus.OK) {
	    	  		//var res = String(results[0].geometry.location).split(",");
		    	    //res[0] = res[0].replace("(","").trim();
		    	    //res[1] = res[1].replace(")","").trim();
		    	   
		    	    var latlng = new google.maps.LatLng(latitude, longitude);
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
			  	      title:'Book'
			  	    }); 
	    	  	}
	      
	        	}); 
	    		
	    		
		}
		
		
		$(function() {
		    $( "#datepicker" ).datepicker({ minDate: -20, maxDate: "+1M +10D" });
		  });
      		
	</script>
</head>

<body>

<div class="container-fluid" style="margin-top:15px">  Book Available in following regions: <br/>
		<div class="row-fluid">
			<div class="container-fluid"> 
				<c:forEach items="${bookAvailDetails}" var="bookAvail" varStatus="i"> 
          			<div class="col-md-2">
          			              <a class="btn btn-primary"  href="#" onClick="changeMap(${bookAvail.subId}, ${bookAvail.region_long}, ${bookAvail.region_lat});" role="button" > ${bookAvail.getRegion_name()} </a>
          				
					</div>
				</c:forEach>
			</div>
		</div>
</div>
<br />
<div id="map_container" align="center">	
<br/>
<br/>
</div>
<div id="divChoose" style="visibility: hidden">
<input type="hidden" id="subbookId" value=""></input>
<p>Date: <input type="text" id="datepicker"></p>
<p><a class="btn btn-primary"  href="#" onClick="chooseBook();" role="button" > Choose </a></p>


</div>
    				
</body>
</html>