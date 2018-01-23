<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register Your Business</title>
		<script src="js/jquery-3.2.1.js"></script>
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/jquery.steps.js"></script>
		<script src="js/jquery.steps.min.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/util.js"></script>
		<link href="styles/css/signup.css" rel="stylesheet">

		<script type="text/javascript">

			$(document).ready(function () {
				var prevflag = "false";
				var left, opacity, scale;
				var cuurent_fs, next_fs, previous_fs;

				$(".next").click(function () {
					cuurent_fs = $(this).parent();
					next_fs = $(this).parent().next();

					$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
					next_fs.show();
					cuurent_fs.animate({
						opacity: 0
					},
						{
							step: function (now, mx) {
								scale = 1 - (1 - now) * 0.2;
								left = (now * 50) + "%";
								opacity = 1 - now;
								cuurent_fs.css({
									'transform': 'scale(' + scale + ')'
								});
								if (prevflag == "true") {
									next_fs.removeAttr("style");
									next_fs.css({
										'left': 'left',
										'display': 'block'
									});
								} else {
									next_fs.css({
										'left': 'left',
										'opacity': 'opacity'
									});
								}
							},
							duration: 800,
							complete: function () {
								cuurent_fs.hide();
							},
							easing: 'easeInOutBack'
						});
				});

				$(".previous").click(function () {
					prevflag = "true";
					cuurent_fs = $(this).parent();
					previous_fs = $(this).parent().prev();

					$("#progressbar li").eq($("fieldset").index(cuurent_fs)).removeClass("active");
					previous_fs.show();
					cuurent_fs.animate({
						opacity: 0
					},
						{
							step: function (now, mx) {
								scale = 1 - (1 - now) * 0.2;
								left = (now * 50) + "%";
								opacity = 1 - now;
								cuurent_fs.css({
									'left': 'left',
									'display': 'block'
								});
								previous_fs.removeAttr("style");
								previous_fs.css({
									'display': 'block'
								});
							},
							duration: 800,
							complete: function () {
								cuurent_fs.hide();
							},
							easing: 'easeInOutBack'
						});
				});

				$("#email").blur(function () {
					var emailaddress = $(this).val();
					if (validateEmail(emailaddress)) {
						alert("valid");
					} else {
						alert("Invalid");
					}

				});
			});
		</script>
	</head>

	<body>
		<form id="msform">
			<ul id="progressbar">
				<li class="active">Account</li>
				<li>Social Profile</li>
				<li>Personnel Details</li>
			</ul>
			<fieldset>
				<h2 class="fs-title">Create Your Account</h2>
				<h3 class="fs-subtitle">This is Step 1</h3>
				<input type="text" name="email" id="email" placeholder="Email">
				<input type="password" name="pass" placeholder="Password">
				<input type="password" name="cpass" placeholder="Confirm Password">
				<input type="button" name="next" class="next action-button" value="Next">
			</fieldset>
			<fieldset>
				<h2 class="fs-title">Social Profile</h2>
				<h3 class="fs-subtitle">This is Step 2</h3>
				<input type="text" name="twitter" placeholder="Twitter">
				<input type="text" name="facebook" placeholder="Facebook">
				<input type="text" name="gmail" placeholder="Gmail">
				<input type="button" name="previous" class="previous action-button" value="Previous">
				<input type="button" name="next" class="next action-button" value="Next">
			</fieldset>
			<fieldset>
				<h2 class="fs-title">Personnel Details</h2>
				<h3 class="fs-subtitle">This is Step 3</h3>
				<input type="text" name="fname" placeholder="Firstname">
				<input type="text" name="lname" placeholder="Lastname">
				<input type="text" name="sname" placeholder="Surname">
				<input type="button" name="previous" class="previous action-button" value="Previous">
				<input type="submit" name="submit" class="submit action-button" value="Submit">
			</fieldset>
		</form>
	</body>

	</html>