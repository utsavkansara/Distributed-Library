<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="module inner-top-50 wow fadeInUp" id="best-seller">
				    <div class="module-heading  home-page-module-heading">
				        <h2 class="module-title home-page-module-title"><span>Found ${fn:length(pagedetails)} results</span></h2>
				    </div><!-- /.module-heading -->
				    <div class="module-body">
			            <div class="books full-width">
			            	<div class="clearfix text-center">
					             <!-- .best month -->



<c:forEach items="${pagedetails}" var="result">
<div class="col-md-3 col-sm-4">
	<div class="book">
		<a href="${pageContext.request.contextPath}/showbook/${result.getBookId()}"><div class="book-cover">
			<img width="140" height="212" alt="" src="${result.getImage()}">
		</div></a>
		<div class="book-details clearfix">
			<div class="book-description">
				<h3 class="book-title"><a href="single-book.html">${result.title} </a></h3>
				<p class="book-subtitle">by 
				<c:forEach var="authorValue" items="${result.getAuthors()}">
							<a href="#">${authorValue}</a><br>
					</c:forEach>
<!-- 					<a href="single-book.html">Gregory Berns </a> -->
							</p>
			</div>
			
		</div>
	</div>
</div>
</c:forEach>
							    <!-- /.best month -->
					        </div><!-- /.text-center -->
			            </div><!-- /.row -->
			        </div><!-- /.module-body -->
			    </div><!-- /.module -->
</body>

<%-- <body>
	<div class="container-fluid" style="margin-top:40px">  
		<div class="row-fluid">
			<div class="container-fluid">
				<c:forEach items="${pagedetails}" var="result"> 
          			<div class="col-md-2">
          				<a href="${pageContext.request.contextPath}/showbook/${result.getBookId()}">
							<img class="img-thumbnail" src="${result.getImage()}" width="300" height="200">
						</a>
						<h4><a href="#">${result.title}</a></h4>
						<p>Price: $${result.getPrice()}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html> --%>