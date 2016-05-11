<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.MongoBook" %>
<jsp:include page="header.jsp" />

<body>
<% MongoBook Book = (MongoBook)request.getAttribute("bookdetails"); 
%>
<div class="content wow fadeInUp">
	<div class="container">
		<div class="row">
			<ul class="breadcrumb text-center">
				<li><a href="home.html">Home</a></li>
				<li><a href="books.html">Books</a></li>
				<li class="active">${bookdetails.singleCategory}</li>				
			</ul>

			<div class="divider">
<%-- 			      <img class="img-responsive" src="<c:url value="assets/images/shadow.png" />" alt=""> --%>
			</div><!-- /.divider -->
		</div>
		<div class="row inner-top-xs single-book-block">
			<div class="col-md-9 col-md-push-3">
				<!-- .primary block -->
				<div class="single-book primary-block">
	<div class="row">
		<div class="col-md-5 col-sm-5">
			<div class="book-cover">
				<img width="268" height="408" alt="" src="${bookdetails.getImage()}">
			</div><!-- /.book-cover -->
			<div class="share-button">
				
				<!-- Go to www.addthis.com/dashboard to customize your tools -->
                <div class="addthis_native_toolbox inner-top-vs"></div>
			</div>
			<div class="list-unstyled link-block inner-top-50">
<!-- 				<a href="#customer-reviews" class='customer-review'><i class="icon fa fa-comment"></i><span class="customer-review">Customer Reviews(7) &darr; </span></a> -->
			</div>
		</div>
		<div class="col-md-7 col-sm-7">
			<div class="featured-book-heading">
				<h1 class="title">${bookdetails.title}</h1>
				<input type="hidden" id="bookId" value="${bookdetails.bookId}"></input>
				<input type="hidden" id="redirectTo" value="${redirectTo}"></input>
				<input type="hidden" id="redirectToBuy" value="${redirectToBuy}"></input>
				<input type="hidden" id="owner" value="${owner}"></input>
				<p class="singl-book-author">
					by<br>
					<c:forEach var="authorValue" items="${bookdetails.getAuthors()}">
							<a href="#">${authorValue}</a><br>
					</c:forEach>
					<%-- <ul>
						<c:forEach var="authorValue" items="${bookdetails.getAuthors()}">
								<a href="#">${authorValue}</a>
						</c:forEach>
					</ul> --%>
				</p>
			</div>

			<div class="row">
				<div class="col-md-3">
<!-- 					<p class="single-book-price">$15.99</p> -->
				</div>
				<div class="col-md-9">
					<div class="add-cart-button btn-group">
						<!-- <button class="btn btn-single btn-sm" type="button" data-toggle="dropdown">
							<img src="assets/images/add-to-cart.png" alt="">
						</button>
						<button class="btn btn-single btn-uppercase" type="button">Add to cart</button> -->
						
						<% if(null != session.getAttribute("USERNAME")) {%> 
							<a class="btn btn-single btn-uppercase" onclick="return makeRequest()" role="button">Make a Request</a>
					    	<%-- <td colspan="2" align="right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/requestbook/${bookdetails.bookId}" role="button">Make a request</a> --%>
					    <% } else {%>					   
							<a class="btn btn-single" href="#" data-toggle="modal" data-target="#modal-login-big" role="button">Login to make a request</a>
					    <% }%>
						
						
					</div>
				</div>
			</div>


			<div class="description"><p>${bookdetails.description}</p></div>
				</div>
			</div>
		</div>			    <!-- /.primary block -->

			

				 
				

			

			</div><!-- /.col -->
			<div class="col-md-3 col-md-pull-9">
				<aside class="sidebar">
					<div class="sidebar-module">
						<div class="sidebar-module-heading">
							<h4 class="sidebar-module-title">You are looking at</h4>
						</div>
						<div class="sidebar-module-body clearfix">
							<ul class="list-unstyled filter-list">						
								<li>
									<a class="pull-right remove-filter" title="Cancel" href="#">
									<i class="fa fa-times"></i>
									</a>
									${bookdetails.singleCategory}
								</li>
							</ul>
						</div>
					</div>
					
					<!-- ============================================== BOOKS BY SUBJECT ============================================== -->
<div class="sidebar-module">
	<div class="sidebar-module-heading">
		<h4 class="sidebar-module-title">Books by Subject</h4>
	</div>
	<div class="sidebar-module-body clearfix">
		<ul class="list-unstyled">
			<li><a href="#">Art, Architecture &amp; Photography</a></li>
			<li><a href="#">Bibles &amp; Bible Studies</a></li>
			<li><a href="#">Biographies</a></li>
			<li><a href="#">Business &amp; Money</a></li>
			<li><a href="#">Children's Books</a></li>
			<li><a href="#">Computing &amp; Internet</a></li>
			<li><a href="#">Cookbooks, Food &amp; Wine</a></li>
			<li><a href="#">Crafts &amp; Hobbies</a></li>
			<li><a href="#">Diet &amp; Health</a></li>
			<li><a href="#">Education &amp; Teaching</a></li>
			<li><a href="#">Fiction &amp; Literature</a></li>
			<li><a href="#">Graphic Novels</a></li>
			<li><a href="#">History</a></li>
			<li><a href="#">Home &amp; Garden</a></li>
			<li><a href="#">Humor</a></li>
			<li><a href="#">Libros en espa?ol</a></li>
			<li><a href="#">Medicine</a></li>
			<li><a href="#">Mystery &amp; Crime</a></li>
			<li><a href="#">Nonfiction</a></li>
			<li><a href="#">Politics &amp; Current Events</a></li>
			<li><a href="#">Psychology</a></li>
			<li><a href="#">Religion</a></li>
			<li><a href="#">Reference</a></li>
			<li><a href="#">Romance</a></li>
			<li><a href="#">Science &amp; Nature</a></li>
			<li><a href="#">Science Fiction &amp; Fantasy</a></li>
			<li><a href="#">Self-Improvement</a></li>
			<li><a href="#">Sports &amp; Adventure</a></li>

		</ul>
	</div>
</div>
<!-- ============================================== BOOKS BY SUBJECT : END ============================================== -->					
				   <!-- ============================================== BEST BOOKS ============================================== -->
<div class="sidebar-module">
	<div class="sidebar-module-heading">
		<h4 class="sidebar-module-title">Best Books</h4>
	</div>
	<div class="sidebar-module-body clearfix">
		<ul class="list-unstyled">
			<li><a href="#">Art, Architecture &amp; Photography</a></li>
			<li><a href="#">Bibles &amp; Bible Studies</a></li>
			<li><a href="#">Biographies</a></li>
			<li><a href="#">Business &amp; Money</a></li>
			<li><a href="#">Children's Books</a></li>
			<li><a href="#">Computing &amp; Internet</a></li>
			<li><a href="#">Cookbooks, Food &amp; Wine</a></li>
			<li><a href="#">Crafts &amp; Hobbies</a></li>
			<li><a href="#">Diet &amp; Health</a></li>
			<li><a href="#">Education &amp; Teaching</a></li>
			<li><a href="#">Fiction &amp; Literature</a></li>
			<li><a href="#">Graphic Novels</a></li>
			<li><a href="#">History</a></li>
			<li><a href="#">Home &amp; Garden</a></li>
			<li><a href="#">Humor</a></li>

		</ul>
	</div>
</div>
<!-- ============================================== BEST BOOKS : END ============================================== -->				</aside>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container -->
</div><!-- /.content -->
</body>

<script>

	function makeRequest(){
		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/Distributed-Library/checkOrders",
			dataType : 'json',
			complete : function(data) {
				
				if (data.responseJSON.successFlag == "Y") {
					var ctx = "${pageContext.request.contextPath}";
					document.location.href=ctx+"/requestbook/${bookdetails.bookId}";
				
				} else if (data.responseJSON.successFlag == "N" || data.responseJSON.successFlag == "L") {
						
					alert(data.responseJSON.errorMessage);
					
				}
			}
		});
		
	}

</script>