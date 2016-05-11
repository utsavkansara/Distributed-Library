<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />
<%@ page import="edu.sjsu.digitalLibrary.prj.models.user"%>
<html>
<head>

<script>
	function RedirectToEdit() {
		var x = document.getElementById('userId').value;
		if ($('#redirectTo').val() == ""){
			window.location.href= "../signup/" + x;
			}
		else{
			alert("else");
			window.location = document.getElementById('redirectTo').value + "/"
					+ x;}
		event.preventDefault();
	}

	function RedirectToTransactions() {
		if (document.getElementById('redirectToTransac').value == ''){
			window.location = "../transactions";}
		else{
			window.location = document.getElementById('redirectToTransac').value;}

	}
</script>

</head>
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
					<li class="active">Profile</li>
				</ul>
				<!-- /.breadcrumb -->
			<div class="container">
				<div class="row inner-top-md">
					<div class='col-md-12 center-block'>
						<div class="contact-block">
							<div class="contact-form-envelope">
								<div class="contact-box">
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="contact-form">
												<form id="contact-form" class='form-horizontal contact-form'>
													<div class="form-group">
														<label class="control-label col-sm-3 info-title"
															for="name">Name</label>
														<div class="col-sm-9">
															<label class="control-label info-title">${userdetails.name}</label>
															<input type="hidden" id="userId"
																value="${userdetails.id}"></input> <input type="hidden"
																id="redirectTo" value="${redirectTo}"></input> <input
																type="hidden" id="redirectToTransac"
																value="${redirectToTransac}"></input>
														</div>
														<!-- /.col -->
													</div>
													<!-- /.form-group -->
													<div class="form-group">
														<label class="control-label col-sm-3 info-title"
															for="email">Email</label>
														<div class="col-sm-9">
															<label class="control-label info-title">${userdetails.emailId}</label>
														</div>
														<!-- /.col -->
													</div>
													<!-- /.form-group -->

													<div class="form-group">
														<label class="control-label col-sm-3 info-title"
															for="subject">Phone</label>
														<div class="col-sm-9">
															<label class="control-label info-title">${userdetails.phone}</label>
														</div>
														<!-- /.col -->
													</div>
													<!-- /.form-group -->

													<div class="form-group">
														<label class="control-label col-sm-3 info-title"
															for="message">Date of birth</label>
														<div class="col-sm-9">
															<label class="control-label info-title">${userdetails.dob}</label>
														</div>
														<!-- /.col -->
													</div>

												

													<div class="form-group">
														<label class="control-label col-sm-3 info-title"
															for="message">Category</label>
														<div class="col-sm-9">
															<label class="control-label info-title">${userdetails.category}</label>
														</div>
														<!-- /.col -->
													</div>
													<!-- /.form-group -->

													<div class="form-group">
														<%
															user User = (user) request.getAttribute("userdetails");
															int ownerId = User.getId();
														%>


														<%
															if (ownerId == Integer.parseInt(session.getAttribute("USERID").toString())) {
														%>
															<!-- 			                <input type="submit" class="btn btn-md btn-primary" value="View transactions" onClick="javascript: RedirectToTransactions();"></input> -->
															<input type="submit" class="btn btn-md btn-primary"
															value="Edit Profile"
															onClick="javascript: RedirectToEdit();"></input> <%-- 							<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedbackasbuyer/${userdetails.getId()}" role="button">Feedback as a Buyer</a> --%>
															<%-- 							<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedbackasseller/${userdetails.getId()}" role="button">Feedback as a Seller</a> --%>
													
														<%
															} else {
														%>
														<!-- 		        		<td colspan="2" align="center"> -->
														<%-- 			                <a class="btn btn-primary" href="${pageContext.request.contextPath}/feedbackasbuyer/${userdetails.getId()}" role="button">Feedback as a Buyer</a> --%>
														<%-- 			                <a class="btn btn-primary" href="${pageContext.request.contextPath}/feedbackasseller/${userdetails.getId()}" role="button">Feedback as a Seller</a> --%>
														<!-- 						</td> -->
														<%
															}
														%>

														<!-- /.col -->
													</div>
													<!-- /.form-group -->

												</form>
											</div>
											<!-- /.contact-form -->
										</div>
										<!-- /.col -->
										
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
		</div>
	</div>
	
</body>
</html>