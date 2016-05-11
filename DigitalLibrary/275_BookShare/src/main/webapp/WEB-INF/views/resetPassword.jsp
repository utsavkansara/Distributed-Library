<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<li class="active">Reset Password</li>
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
												<form id="resetnewPassword" class='form-horizontal contact-form'
													action="resetnewPassword" method="post"
													commandName="resetnewPassword">
													<input name="message" id="message" value="${message}"
														type="hidden"> <input name="id" id="id"
														value="${id}" type="hidden"> <input name="flag"
														id="flag" value="${Flag}" type="hidden">
													<hr>
													<!-- Text input-->
													<div class="form-group">
														<label class="col-md-3 control-label" for="textinput">New
															Password</label>
														<div class="col-md-8">
															<input id="newPassword" name="newPassword"
																type="password" placeholder="Enter new newPassword"
																class="form-control bookshop-form-control"
																required="true">

														</div>
													</div>

													<!-- Text input-->
													<div class="form-group">
														<label class="col-md-3 control-label" for="textinput">Confirm
															Password</label>
														<div class="col-md-8">
															<input id="confirmnewPassword" name="confirmnewPassword"
																type="password" placeholder="Confirm newPassword"
																class="form-control bookshop-form-control"
																required="true">

														</div>
													</div>

													<div class="form-group">
														<label class="col-md-3 control-label" for="singlebutton"></label>
														<div class="col-md-8">
															<button id="resetnewPassword" name="singlebutton"
																class="btn btn-primary" onclick="return passwordMatch()"
																type="button">Reset newPassword</button>
														</div>

													</div>

												</form>
											</div>
											<!-- /.contact-form -->
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


</body>

<script>
	$(document).ready(function() {

		var flag = document.getElementById('flag').value;
		var msg = document.getElementById('message').value;
		var z = document.getElementById('id').value;
		console.log("id "+z);
		console.log("msg"+msg);
		console.log("flag"+flag);

		if (msg != null && msg != "" && flag == "S") {
			alert(msg);
			document.location.href = "/Distributed-Library";
		} else if (msg != null && msg != "" && flag == "E") {
			alert(msg);
			document.location.href = "/Distributed-Library";
		} else if (msg != null && msg != "" && (flag == "" || flag == null)) {
			alert(msg);
			document.location.href = "/Distributed-Library";
		}

		event.preventDefault();
	});

	function passwordMatch() {

		var enterednewPassword = $('#newPassword').val();
		var confirmnewPassword = $("#confirmnewPassword").val();

		if (enterednewPassword == "" || confirmnewPassword == "") {
			alert("Please enter password");
		} else {

			if (enterednewPassword != confirmnewPassword) {
				alert("Your entered newPassword and confirmed newPassword should be same !\n");
				return false;
			} else {
				
				document.getElementById("resetnewPassword").submit();
				//$("#contact-form").submit();
			}

		}

	}
</script>
</html>