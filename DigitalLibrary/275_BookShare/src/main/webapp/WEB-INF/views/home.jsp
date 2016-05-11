<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.MongoBook"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <jsp:include page="imports.jsp" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		MongoBook Book = (MongoBook) request.getAttribute("bookdetails");
	%>
	<div id="wrapper">
		<div id="page-content-wrapper" class="st-pusher">
			<div class="st-pusher-after"></div>

			<!-- ============================================== HEADER ============================================== -->

			<jsp:include page="header.jsp" />
			<div id="ajaxSpinnerContainer">
				<img src="<c:url value="/resources/images/Preloader_2.gif" />"
					id="ajaxSpinnerImage" title="working..." />
			</div>
			<!-- ============================================== HEADER : END ============================================== -->
			<div class="home-page">
				<div class="content">

					<div class="home-slider outer-bottom-vs">
						<!-- ========================================== SECTION – HERO : START ========================================= -->
						<div id="hero">
							<div id="owl-main" class="owl-carousel owl-theme">
								<div class="item">
									<div class="container">
										<div class="content">
											<div class="row">
												<div class="col-md-7 col-sm-12 col-xs-12">
													<div class="book-in-shelf">
														<div class="book-shelf">
															<div class="book-cover slider-book-cover bk-cover m-t-20" style="height: 273px;width: 478px">
																<img class="img-responsive" style="width: 100%" alt=""
																	src="resources/images/slider-images/6.png">
																<div class="fade"></div>
															</div>
															<!-- /.book-cover -->
														</div>
														<!-- /.book-shelf -->
													</div>
													<!-- /.book-in-shelf -->
												</div>
												<!-- /.col -->

												<div class="col-md-5 col-sm-12 col-xs-12">
													<div class="clearfix caption vertical-center text-left">
														<div class="slider-caption-heading">
															<h1 class="slider-title">
																<span class="fadeInDown-1 main">Search Books:</span> <span
																	class="fadeInDown-2 sub">Across the globe</span>
															</h1>
														</div>
														<!-- /.slider-caption-heading -->
													
														<!-- /.slider-price -->
													</div>
													<!-- /.slider-caption -->
												</div>
												<!-- /.col -->


											</div>
											<!-- /.row -->

										</div>
										<!-- /.content.caption -->
									</div>
									<!-- /.container -->
								</div>
								<!-- /.item -->

								<div class="item">
									<div class="container">
										<div class="content">
											<div class="row">
												<div class="col-md-7 col-sm-12 col-xs-12">
													<div class="book-in-shelf">
														<div class="book-shelf">
															<div class="book-cover slider-book-cover bk-cover m-t-20"  style="height: 273px;width: 478px">
																<img class="img-responsive" alt="" style="width: 100%" 
																	src="resources/images/slider-images/5.png">
																<div class="fade"></div>
															</div>
															<!-- /.book-cover -->
														</div>
														<!-- /.book-shelf -->
													</div>
													<!-- /.book-in-shelf -->
												</div>
												<!-- /.col -->

												<div class="col-md-5 col-sm-12 col-xs-12">
													<div class="clearfix caption vertical-center text-left">
														<div class="slider-caption-heading">
															<h1 class="slider-title">
																<span class="fadeInDown-1 main">Automatic:</span> <span
																	class="fadeInDown-2 sub">order handling</span>
															</h1>
														</div>
														<!-- /.slider-caption-heading -->
													
														<!-- /.slider-price -->
													</div>
													<!-- /.slider-caption -->
												</div>
												<!-- /.col -->


											</div>
											<!-- /.row -->

										</div>
										<!-- /.content.caption -->
									</div>
									<!-- /.container -->
								</div>
								<!-- /.item -->


								<div class="item">
									<div class="container">
										<div class="content">
											<div class="row">
												<div class="col-md-7 col-sm-12 col-xs-12">
													<div class="book-in-shelf">
														<div class="book-shelf">
															<div class="book-cover slider-book-cover bk-cover m-t-20" style="height: 273px;width: 478px">
																<img class="img-responsive" alt="" style="width: 100%" 
																	src="resources/images/slider-images/7.png">
																<div class="fade"></div>
															</div>
															<!-- /.book-cover -->
														</div>
														<!-- /.book-shelf -->
													</div>
													<!-- /.book-in-shelf -->
												</div>
												<!-- /.col -->

												<div class="col-md-5 col-sm-12 col-xs-12">
													<div class="clearfix caption vertical-center text-left">
														<div class="slider-caption-heading">
															<h1 class="slider-title">
																<span class="fadeInDown-1 main">Automatic:</span> <span
																	class="fadeInDown-2 sub">Inventory Management</span>
															</h1>
														</div>
														<!-- /.slider-caption-heading -->
														
														<!-- /.slider-price -->
													</div>
													<!-- /.slider-caption -->
												</div>
												<!-- /.col -->


											</div>
											<!-- /.row -->

										</div>
										<!-- /.content.caption -->
									</div>
									<!-- /.container -->
								</div>
								<!-- /.item -->

							</div>
							<!-- /# owl-main -->
						</div>
						<!-- /#hero -->
						<!-- ========================================== SECTION – HERO : END ========================================= -->
					</div>
					<!-- /.home-slider -->

					<div class="container">
						<!-- ============================================== BANNERS ============================================== -->
<!-- 						<div class="wide-banners wow fadeInUp"> -->
<!-- 							<div class="row"> -->

<!-- 								<div class="col-md-4 col-sm-6"> -->
<!-- 									<div class="wide-banner cnt-strip"> -->
<!-- 										<div class="strip strip-text"> -->
<!-- 											<div class="strip-inner text-center"> -->
<!-- 												<h2 class="title">Shop Sale</h2> -->
<!-- 												<p class='subtitle'>The sale don't stop up to 75% off!</p> -->
<!-- 											</div> -->
<!-- 											/.strip-inner -->
<!-- 										</div> -->
<!-- 										/.strip -->
<!-- 									</div> -->
<!-- 									/.wide-banner -->
<!-- 								</div> -->
<!-- 								/.col -->

<!-- 								<div class="col-md-4 hidden-sm"> -->

<!-- 									<div class="wide-banner cnt-strip"> -->
<!-- 										<div class="image"> -->
<!-- 											<img class="img-responsive" -->
<%-- 												src="<c:url value="/resources/images/wide-banners/banner1.png" />" --%>
<!-- 												alt=""> -->
<!-- 										</div> -->
<!-- 										<div class="strip on-strip strip-text"> -->
<!-- 											<div class="strip-inner text-center"> -->
<!-- 												<h2 class="title">Latest Products</h2> -->
<!-- 												<p class='subtitle'>New Arrivals</p> -->
<!-- 											</div> -->
<!-- 											/.strip-inner -->
<!-- 										</div> -->
<!-- 										/.strip -->

<!-- 									</div> -->
<!-- 									/.wide-banner -->

<!-- 								</div> -->
<!-- 								/.col -->

<!-- 								<div class="col-md-4 col-sm-6"> -->
<!-- 									<div class="wide-banner cnt-strip"> -->
<!-- 										<div class="strip strip-text"> -->
<!-- 											<div class="strip-inner text-center"> -->
<!-- 												<h2 class="title">Read the blog</h2> -->
<!-- 												<p class='subtitle'>Latest hot news</p> -->
<!-- 											</div> -->
<!-- 											/.strip-inner -->
<!-- 										</div> -->
<!-- 										/.strip -->

<!-- 									</div> -->
<!-- 									/.wide-banner -->
<!-- 								</div> -->
<!-- 								/.col -->



<!-- 							</div> -->
<!-- 							/.row -->
<!-- 						</div> -->
						<!-- /.wide-banners -->
						<!-- ============================================== BANNERS : END ============================================== -->
						<div class="divider inner-vs">
							<img class="img-responsive"
								src="<c:url value="/resources/images/shadow.png" />" alt="">
						</div>
						<!-- /.divider -->

						<!-- ============================================== Recommendation for user ============================================== -->

						<c:if test="${fn:length(recommendedForYou) gt 0}">
							<section class="best-seller wow fadeInUp">
							<div id="best-seller" class="module">
								<div class="module-heading home-page-module-heading">
									<h2 class="module-title home-page-module-title">
										<span>Trending Books</span>
									</h2>
								</div>
								<!-- /.module-heading -->
								<div class="module-body">
									<div class="row books full-width">
										<div class="clearfix text-center">


											<c:forEach items="${recommendedForYou}" var="recommendedBook">
												<div class="col-md-3 col-sm-6">
													<div class="book">
														<a
															href="${pageContext.request.contextPath}/showbook/${recommendedBook.getBookId()}">
															<div class="book-cover">
																<img width="140" height="212" alt=""
																	src="${recommendedBook.getImage()}">
																<!-- 														<div class="tag"> -->
																<!-- 															<span>sale</span> -->
																<!-- 														</div> -->
															</div>
														</a>
														<div class="book-details clearfix">
															<div class="book-description">
																<h3 class="book-title">
																	<a
																		href="${pageContext.request.contextPath}/showbook/${recommendedBook.getBookId()}">${recommendedBook.title}</a>
																</h3>
																<p class="book-subtitle">
																	by
																	<c:forEach var="authorValue"
																		items="${recommendedBook.getAuthors()}">
																		<a href="#">${authorValue}</a>
																		<br>
																	</c:forEach>
																</p>
															</div>

														</div>
													</div>
												</div>
											</c:forEach>

										</div>
									</div>
								</div>
							</section>
						</c:if>
						<!-- ============================================== BEST SELLER : END ============================================== -->


						<!-- ============================================== BEST SELLER (Trending books)============================================== -->

						<c:if test="${fn:length(recommCatBooks) gt 0}">
							<section class="best-seller wow fadeInUp">
							<div id="best-seller" class="module">
								<div class="module-heading home-page-module-heading">
									<h2 class="module-title home-page-module-title">
										<span>Inspired By ${sessionScope.USERNAME}'s shopping
											trends</span>
									</h2>
								</div>
								<!-- /.module-heading -->
								<div class="module-body">
									<div class="row books full-width">
										<div class="clearfix text-center">


											<c:forEach items="${recommCatBooks}" var="recommCatBooks">
												<div class="col-md-3 col-sm-6">
													<div class="book">
														<a
															href="${pageContext.request.contextPath}/showbook/${recommCatBooks.getBookId()}">
															<div class="book-cover">
																<img width="140" height="212" alt=""
																	src="${recommCatBooks.getImage()}">

															</div>
														</a>
														<div class="book-details clearfix">
															<div class="book-description">
																<h3 class="book-title">
																	<a
																		href="${pageContext.request.contextPath}/showbook/${recommCatBooks.getBookId()}">${recommCatBooks.title}</a>
																</h3>
																<p class="book-subtitle">
																	by
																	<c:forEach var="authorValue"
																		items="${recommCatBooks.getAuthors()}">
																		<a href="#">${authorValue}</a>
																		<br>
																	</c:forEach>
																</p>
															</div>

														</div>
													</div>
												</div>
											</c:forEach>

										</div>
									</div>
								</div>
							</section>
						</c:if>
						<!-- ============================================== BEST SELLER : END ============================================== -->
					</div>
					<!-- /.container -->

					<!-- ============================================== TESTIMONIAL ============================================== -->
					
					<!-- ============================================== TESTIMONIAL : END ============================================== -->

					<section class="latest-product wow fadeInUp">
					<div id="latest-product" class="module container inner-top-xs">
						<div
							class="module-heading home-page-module-heading inner-bottom-vs">
							<h2 class="module-title home-page-module-title">
								<span></span>
							</h2>
						</div>
						
					</div>
					</section>
					<div id="map"></div>
					<!-- ============================================== FROM BLOG ============================================== -->
					<section class="blog wow fadeInUp">
					
					<!-- /.module --> </section>
					<!-- ============================================== FROM BLOG : END ============================================== -->
				</div>
				<!-- /.content -->
			</div>
			<!-- /.home-page -->


			<!-- ============================================== FOOTER ============================================== -->

			<jsp:include page="footer.jsp" />

			<!-- ============================================== FOOTER : END ============================================== -->

		</div>
		<!-- /.st-pusher -->
		<!-- ============================================== TOGGLE RIGHT CONTENT ============================================== -->

		<jsp:include page="toggleCart.jsp" />

		<!-- ============================================== TOGGLE RIGHT CONTENT : END ============================================== -->



	</div>
	<!-- /#wrapper -->



	<%-- <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
	      <!-- Indicators -->
	      <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	      </ol>
	      
	      <!-- Wrapper for slides -->
	      <div class="carousel-inner" role="listbox">
	        <div class="item active">
	          <img src="${pagedetails.books[1].pictureId}" alt="First slide" width="460" height="345">
	          <div class="container">
	            <div class="carousel-caption">
	              <p><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/showbook/${pagedetails.books[1].bookId}" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	        
	        <div class="item">
	          <img class="second-slide" src="${pagedetails.books[2].pictureId}" alt="Second slide">
	          <div class="container">
	            <div class="carousel-caption">
	              <p><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/showbook/${pagedetails.books[2].bookId}" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	
	        <div class="item">
	          <img class="third-slide" src="${pagedetails.books[3].pictureId}" alt="Third slide">
	          <div class="container">
	            <div class="carousel-caption">
					<p><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/showbook/${pagedetails.books[3].bookId}" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	      </div>
	
	      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	        <span class="sr-only">Previous</span>
	      </a>
	
	      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <span class="sr-only">Next</span>
	      </a>
	    </div><!-- /.carousel -->

	<div class="container-fluid" style="margin-top:15px">  
		<div class="row-fluid">
			<div class="container-fluid">
			<c:forEach items="${pagedetails.books}" var="result">
				<c:if test="${result.getStatus() != 'Sold'}">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath}/showbook/${result.bookId}">
							<img class="img-thumbnail" src="${result.pictureId}" width="300" height="200">
						</a>
						<h4>
					    	<a href="#">${result.title}</a>
						</h4>
						<p>Price: $${result.getPrice()}</p>
					</div>
				</c:if>
			</c:forEach>
			</div>
		</div>
	</div> --%>
</body>


</html>


