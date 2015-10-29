<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>BookShare.com - Distributed Book Sharing Service</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<!-- begin template -->
	<div class="navbar navbar-custom navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">BookShare.com</a> <a class="navbar-toggle"
				data-toggle="collapse" data-target=".navbar-collapse"> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Order</a></li>
				<li><a href="#">Share</a></li>
				<li>&nbsp;</li>
			</ul>
			<form class="navbar-form"  action="#">
				<div class="form-group" style="display: inline;">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Title</a></li>
								<li><a href="#">Author</a></li>
								<li><a href="#">Name</a></li>
								<li><a href="#">Publisher</a></li>
							</ul>
						</div>
						<input type="text" class="form-control" id="searchPara"
							placeholder="Which book are searching for?"> <span
							class="input-group-addon"><span onclick="search();"
							class="glyphicon glyphicon-search"></span> </span>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="map-canvas"></div>
	<div class="container-fluid" id="main">
		<div class="row">
			<div class="col-xs-8" id="left">

		

			</div>
			<div class="col-xs-4">
				<!--map-canvas will be postioned here-->
			</div>

		</div>
	</div>
	<!-- end template -->

	<!-- script references -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
	<script src="js/scripts.js"></script>
	<script src="https://www.google.com/jsapi" type="text/javascript"></script>
	

	<script type="text/javascript">
	var jq = $.noConflict();
		function search() {
			var googleAPI = "https://www.googleapis.com/books/v1/volumes?q="
					+ jq('#searchPara').val();
			jq('#left').html('');
			// Make a ajax call to get the json data as response.
			jq.getJSON(
							googleAPI,
							function(response) {
								// In console, you can see the response objects
								console.log("JSON Data: " + response.items);	
								// Loop through all the items one-by-one
								var data = "<h2>Search results for: "+jq('#searchPara').val()+"</h2>"
								for (var i = 0; i < response.items.length; i++) {
									console.log(response.items[i]);
									// set the item from the response object
									var item = response.items[i];
									var desc = "";
									try{
									desc = item.searchInfo.textSnippet;
									}
									catch(e){
										
									}
									data += "<div class='panel panel-default'>"
											+ "<div class='panel-heading'>"
											+"<img src='"+item.volumeInfo.imageLinks.smallThumbnail+"'></img>"
											+ "<a href=''>"
											+ item.volumeInfo.title
											+ "</a>"
											+ "</div>"
											+ "</div>"
											+ "<p>"
											+ desc
											+"</p>" +
											"<hr>";
									// Set the book title in the div
							
								}
								jq("#left").html(data);
							});
		}
	</script>
</body>
</html>