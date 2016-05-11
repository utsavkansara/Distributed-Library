<%@    taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<jsp:include page="header.jsp" />
<html>

<body>

	<div class="footer-content">
		<div class="contact-form-container">
			<div id="map">
				<iframe
					src="http://images.freecreatives.com/wp-content/uploads/2015/03/Huge-Backgrounds-26.jpg"></iframe>
			</div>
			<div class="container">
				<ul class="breadcrumb text-center">
					<li><a href="/Distributed-Library">Home</a></li>
					<li class="active">Edit</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="row inner-top-md">
					<div class='col-md-10 center-block'>
						<div class="contact-block">
							<div class="contact-form-envelope">
								<div class="contact-box">
									<div class="row">
										<div class="col-md-8 col-sm-8">
											<div class="contact-form">
												<form
													class="form-horizontal contact-form"
													id="userhome" action="${path}" method="post"
													commandName="userdetails">
													
														<input type="hidden" id="id" value="${userdetails.id}"></input>
														<input type="hidden" id="emailId"
															value="${userdetails.emailId}"></input>
														<!-- Text input-->
														<div class="form-group" style="margin-top: 15px">
															<label class="control-label col-sm-3 info-title" for="textinput">Name</label>
															<div class="col-md-7">
																<input id="name" name="name" type="text"
																	placeholder="Enter your name"
																	class="form-control bookshop-form-control"
																	value="${userdetails.name}"> <font color="red"><form:errors
																		path="name" required="true"></form:errors></font> <font
																	color="red"><form:errors path="name"></form:errors></font>
															</div>
														</div>

														<!-- Text input-->
														<div class="form-group">
															<label class="col-md-4 control-label" for="textinput">Date
																Of Birth</label>
															<div class="col-md-7">
																<input id="dobStr" name="dobStr" type="text"
																	placeholder="Enter your Date of birth"
																	class="form-control bookshop-form-control"
																	value="${userdetails.dob}"> <font color="red"><form:errors
																		path="dobStr"></form:errors></font>
															</div>
														</div>



														<!-- Text input-->
														<div class="form-group control-label">
															<label class="col-md-4 control-label" for="textinput">Phone</label>
															<div class="col-md-7">
																<input id="phone" name="phone" type="number"
																	placeholder="Enter your phone"
																	class="form-control bookshop-form-control"
																	value="${userdetails.phone}"> <font color="red"><form:errors
																		path="phone"></form:errors></font>
															</div>
														</div>

														<!-- Text input-->
														<div class="form-group control-label">
															<label class="col-md-4 control-label" for="textinput">Category
																of Books You like</label>
															<div class="col-md-7">
																<input id="category" name="category" type="text"
																	placeholder="Enter your category"
																	class="form-control bookshop-form-control"
																	value="${userdetails.category}"> <font
																	color="red"><form:errors path="category"></form:errors></font>
															</div>
														</div>


														<!-- Text input-->
														<div class="form-group">
															<label class="col-md-4 control-label" for="textinput">Password</label>
															<div class="col-md-7">
																<input id="password" name="password" type="password"
																	placeholder="Enter your password"
																	class="form-control bookshop-form-control"
																	value="${userdetails.password}"> <font
																	color="red"><form:errors path="password"></form:errors></font>
															</div>
														</div>

														<!-- Text input-->
														<div class="form-group">
															<label class="col-md-4 control-label" for="textinput">Confirm
																password</label>
															<div class="col-md-7">
																<input id="confirmpassword" name="confirmpassword"
																	type="password" placeholder="Enter your password again"
																	class="form-control bookshop-form-control"
																	value="${userdetails.password}"> <font
																	color="red"><form:errors path="confirmpassword"></form:errors></font>
															</div>
														</div>

														<div class="form-group">
															<label class="col-md-4 control-label" for="singlebutton"></label>
															<div class="col-md-7">
																<button id="singlebutton" name="singlebutton"
																	class="btn btn-primary" type="submit">Update</button>
																<div>
																	<font color="red"><form:errors /></font>
																</div>
															</div>
														</div>

												</form>
											</div>
											<!-- /.contact-form -->
										</div>
										<!-- /.col -->
										<div class="col-md-4 col-sm-4">
											<section class="contact-detail">
												<div class="head-office-address">
													<h4 class="title">Head Office</h4>
													<address>
														Lorem Ipsum Dolor Sit Moon Avenue <br>No:11/21 Planet
														City,Earth
													</address>
													<p class="info">
														<span>Fax:</span>+1 212 691 1303
													</p>
													<p class="info">
														<span>Tel:</span>+1 212 691 6862
													</p>
													<p class="info">
														<span>E-mail:</span><a href="#">hello@hezy,org</a>
													</p>
												</div>
												<hr>
												<div class="branch-office-address">
													<h4 class="title">Branch Office</h4>
													<address>
														Lorem Ipsum Dolor Sit Moon Avenue <br>No:11/21 Planet
														City,Earth
													</address>
												</div>
												<hr>
												<div class="social-connection">
													<h4 class="title">Connect with Hezy Theme</h4>
													<ul class="social-connection-list list-inline">
														<li><a href="#"><i class="fa fa-facebook"></i></a></li>
														<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
														<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
														<li><a href="#"><i class="fa fa-twitter"></i></a></li>
														<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
														<li><a href="#"><i class="fa fa-rss"></i></a></li>
														<li><a href="#"><i class="fa fa-instagram"></i></a></li>
													</ul>
												</div>
											</section>
										</div>
										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<!-- /.contact-box -->
							</div>
							<!-- /.contact-form-envelope -->
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container -->
		</div>
		<!-- /.contact-form-container -->
	</div>
	<!-- /.content -->

	<div class="container-fluid"></div>
</body>
</html>
