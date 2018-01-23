<%@page import="java.util.HashMap"%>
	<%@page import="java.util.Map"%>
		<%@include file="/WEB-INF/jsp/common/includeDirectives.jsp"%>
			<!--
Template Name: Brickary
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link href="styles/css/jquery-ui.css" rel="stylesheet">
	<link href="styles/css/layout.css" rel="stylesheet" type="text/css" media="all">
	<title>Street Product</title>
	<%@include file="/WEB-INF/jsp/common/scripts.jsp"%>
		<script src="js/jquery.leanModal.min.js"></script>
		<script src="js/util.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
					var optionsList = document
						.getElementById('localeLanguage').children;
					var i18File = document.getElementById('localeFileName').value;

					if (i18File == "com.properties.ApplicationMessages_guj_IN") {
						for (var i = 0; i < optionsList.length; i++) {
							if (optionsList[i].value == 'guj') {
								document.getElementById('localeLanguage').selectedIndex = i;
							}
						}
					}
					if (i18File == "com.properties.ApplicationMessages_hin_IN") {
						for (var i = 0; i < optionsList.length; i++) {
							if (optionsList[i].value == 'hin') {
								document.getElementById('localeLanguage').selectedIndex = i;
							}
						}
					}
					if (i18File == "com.properties.ApplicationMessages_en_IN") {
						for (var i = 0; i < optionsList.length; i++) {
							if (optionsList[i].value == 'eng') {
								document.getElementById('localeLanguage').selectedIndex = i;
							}
						}
					}

					$("#login_form").click(function () {
						$(".social_login").hide();
						$(".user_login").show();
						return false;
					});

					// Calling Register Form
					$("#register_form").click(function () {
						$(".social_login").hide();
						$(".user_register").show();
						$(".header_title").text('Register');
						return false;
					});

					// Going back to Social Forms
					$(".back_btn").click(function () {
						$(".user_login").hide();
						$(".user_register").hide();
						$(".social_login").show();
						$(".header_title").text('Login');
						return false;
					});

					$("#searchProducthBar").keypress(function () {
						var searchField = document.getElementById('searchProducthBar');
						var searchFieldVal = searchField.value.trim();
						if (searchFieldVal.length > 1 && searchField.value != '') {
								$.ajax({
									type: "GET",
									url: "searchProduct.do",
									contentType: 'application/json',
									data: $("#homePageForm").serialize(),
									dataType: 'json',
									//data: "productName="+prodName+"&productCode="+prodCode,
									success: function (response) {
										console.log("Success");
										var searchArray = searchProductsList(response);
										console.log(searchArray);
										var availableTags = searchArray;
										$("#searchProducthBar").autocomplete({
											source: availableTags
										});
									},
									error: function (response) {
										console.log(response);
										var availableTags = [
											"Java",
											"Python",
											"PHP",
											"Ruby"];
										$("#searchProducthBar").autocomplete({
											source: availableTags
										});
									},
								});
						}
					});
				});
			function manageLogin(id) {
				var idName = document.getElementById(id).id;
				if (idName == "shopOwner") {
					$("#shopOwnerDiv").show();
					$("#customerDiv").hide();
				}
				if (idName == "customer") {
					$("#shopOwnerDiv").hide();
					$("#customerDiv").show();
				}
			}
			function submitLoginForm(formName, actionName) {
				var oForm = document.forms[formName];
				var email = oForm.elements["emailId"];

				if (email.value == '') {
					$("#alertMessageDialog").show();
					$("#alertMessageDialog>#dialog_text").show();
					$("#alertMessageDialog>#dialog_text")
						.html(
						"<h1>Hkwejrwkejrwjerwjerjfksfjlkdsjflksjflksjdfl<br/>ksjflkjsldkfjsldkfjlskfjlskjjjjjjjjjj\ndopflskjkkkkkkkkkkkkf\ndlkjsdlkfjsdyyyyyyyyyyyyyyyyyf\nwerkjwrekjwhekjrhwejrhwkejhrkwjerkjewrkwjerkwjerhkwjrehkjwkkskkkd</h1>");
				}
				if (email.value != '') {
					alert("NotBlank");
				}
			}
		</script>
</head>

<body id="top">
	<form:form name="homePageForm" id="homePageForm" modelAttribute="homePageDetails">
		<div>
			<input name="localeFileName" id="localeFileName" type="hidden" value="${homePageFormBean.localeFileName}">

			<c:choose>
				<c:when test="${not empty homePageFormBean.localeFileName}">
					<fmt:setBundle basename="${homePageFormBean.localeFileName}" var="selectLanguage"></fmt:setBundle>
				</c:when>
				<c:otherwise>
					<fmt:setBundle basename="com.properties.ApplicationMessages_en_IN" var="selectLanguage"></fmt:setBundle>
				</c:otherwise>
			</c:choose>
			<fmt:setLocale value="en" />
		</div>
		<div class="wrapper row0">
			<div id="topbar" class="hoc clear">
				<!-- ################################################################################################ -->
				<div class="fl_left">
					<ul>
						<li>
							<i class="fa fa-phone"></i> +00 (123) 456 7890</li>
						<li>
							<i class="fa fa-envelope-o"></i> info@domain.com</li>
					</ul>
				</div>
				<div class="fl_right">
					<ul>
						<li>
							<a href="index.jsp">
								<i class="fa fa-lg fa-home"></i>
							</a>
						</li>
						<li>
							<a style="cursor: pointer" onclick="document.getElementById('loginPopup').style.display='block'">Login
								<i class="fa fa-user"></i>
							</a>
						</li>
						<li>
							<a href="shopDescription.do" id="register">
								<fmt:message key="homePage.shop" bundle="${selectLanguage}"></fmt:message>
								<i class="fa fa-building"></i>
							</a>
						</li>
						<!-- <li><i class="fa fa-language"></i> <select
				id="localeLanguage" name="localeLanguage"
				onchange="submitForm_Action('homePageForm', 'homePageFormDetails.do')">
					name="localeLanguage" onchange="submitForm('homePageForm')">
					<option id="sel">Select Language</option>
					<option id="eng">English</option>
					<option id="guj">Gujarati</option>
					<option id="hin">Hindi</option>
			</select></li> -->
						<li>
							<i class="fa fa-language"></i>
							<form:select path="localeLanguage" onchange="submitForm_Action('homePageForm', 'homePageFormDetails.do')">
								<%-- <form:option value="--" label="SELECT"></form:option> --%>
									<form:options items="${langMap}" />
							</form:select>
					</ul>
				</div>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- Top Background Image Wrapper -->
		<div class="bgded overlay">
			<!-- ################################################################################################ -->
			<div class="wrapper row1">
				<header id="header" class="hoc clear">
					<!-- ################################################################################################ -->
					<div id="logo" class="fl_left">
						<h1>
							<a href="index.jsp">
								<fmt:message key="homePage.title" bundle="${selectLanguage}"></fmt:message>
							</a>
						</h1>
					</div>
					<nav id="mainav" class="fl_right">
						<ul class="clear">
							<li class="active">
								<a href="/">Home</a>
							</li>
							<li>
								<a class="drop" href="#">Pages</a>
								<ul>
									<li>
										<a href="productDescription.do">
											<fmt:message key="homePage.product" bundle="${selectLanguage}"></fmt:message>
										</a>
									</li>
									<li>
										<a href="pages/sidebar-left.html">Sidebar Left</a>
									</li>
									<li>
										<a href="pages/sidebar-right.html">Sidebar Right</a>
									</li>
									<li>
										<a href="pages/basic-grid.html">Basic Grid</a>
									</li>
								</ul>
							</li>
							<li>
								<a class="drop" href="#">Dropdown</a>
								<ul>
									<li>
										<a href="#">Level 2</a>
									</li>
									<li>
										<a class="drop" href="#">Level 2 + Drop</a>
										<ul>
											<li>
												<a href="#">Level 3</a>
											</li>
											<li>
												<a href="#">Level 3</a>
											</li>
											<li>
												<a href="#">Level 3</a>
											</li>
										</ul>
									</li>
									<li>
										<a href="#">Level 2</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">Link Text</a>
							</li>
							<li>
								<a href="#">Link Text</a>
							</li>
						</ul>
					</nav>
					<!-- ################################################################################################ -->
				</header>
			</div>
			<div id="pageintro" class="hoc clear">
				<footer>
					<div class="group" id="searchBar" method="post" action="#">
						<fieldset>
							<input type="text" name="searchProducthBar" id="searchProducthBar" placeholder="Search Products Here&hellip;" required>
							<button class="fa fa-sign-in" type="submit" title="Submit">
								<em>Submit</em>
							</button>
						</fieldset>
					</div>
				</footer>
			</div>
			<!-- ################################################################################################ -->
			<!-- ################################################################################################ -->
			<!-- ################################################################################################ -->
			<div id="pageintro" class="hoc clear">
				<!-- ################################################################################################ -->
				<div class="flexslider basicslider">
					<ul class="slides">
						<li>
							<article>
								<p>Egestas</p>
								<h3 class="heading">Elementum dictum</h3>
								<p>Cursus mauris vitae ligula accumsan sed</p>
								<footer>
									<form class="group" method="post" action="#">
										<fieldset>
											<legend>Sign-Up:</legend>
											<input type="email" value="" placeholder="Email Here&hellip;">
											<button class="fa fa-sign-in" type="submit" title="Submit">
												<em>Submit</em>
											</button>
										</fieldset>
									</form>
								</footer>
							</article>
						</li>
						<li>
							<article>
								<p>Pulvinar</p>
								<h3 class="heading">Viverra iaculis</h3>
								<p>Orci nam nec dolor dapibus dignissim tortor</p>
								<footer>
									<a class="btn inverse" href="#">Facilisis etiam </a>
								</footer>
							</article>
						</li>
						<li>
							<article>
								<p>Maximus</p>
								<h3 class="heading">Tincidunt viverra</h3>
								<p>Sed feugiat tellus quisque vehicula convallis</p>
								<footer>
									<a class="btn" href="#">Efficitur convallis</a>
								</footer>
							</article>
						</li>
					</ul>
				</div>
				<!-- ################################################################################################ -->
			</div>
			<!-- ################################################################################################ -->
		</div>
		<!-- End Top Background Image Wrapper -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper row3 coloured">
			<main class="hoc container clear">
				<!-- main body -->
				<!-- ################################################################################################ -->
				<div id="introblocks">
					<ul class="nospace group">
						<li class="one_third first">
							<article>
								<div>
									<h6 class="heading">Lacinia vivamus lorem</h6>
									<p>Ex mauris faucibus libero sed maximus lobortis nunc luctus nisi luctus varius convallis [&hellip;]</p>
								</div>
								<img src="images/homepage/320x180.png" alt="">
								<footer>
									<a href="#">More Details</a>
								</footer>
							</article>
						</li>
						<li class="one_third">
							<article>
								<div>
									<h6 class="heading">Aliquam dolor blandit</h6>
									<p>Posuere lectus leo facilisis nisi nunc nibh nibh consectetur vel consectetur consequat eget neque [&hellip;]</p>
								</div>
								<img src="images/homepage/320x180.png" alt="">
								<footer>
									<a href="#">More Details</a>
								</footer>
							</article>
						</li>
						<li class="one_third">
							<article>
								<div>
									<h6 class="heading">Nibh aliquam imperdiet</h6>
									<p>Dolor in turpis ultricies faucibus nunc eu turpis lobortis iaculis suspendisse vel tincidunt lectus [&hellip;]</p>
								</div>
								<img src="images/homepage/320x180.png" alt="">
								<footer>
									<a href="#">More Details</a>
								</footer>
							</article>
						</li>
					</ul>
				</div>
				<p class="center">
					<a class="btn inverse" href="#">Consequat commodo</a>
				</p>
				<!-- ################################################################################################ -->
				<!-- / main body -->
				<div class="clear"></div>
			</main>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper bgded overlay" style="background-image: url('images/homepage/02.png');">
			<section class="hoc container clear">
				<!-- ################################################################################################ -->
				<div class="sectiontitle center">
					<h3 class="heading">Augue eget iaculis mauris</h3>
					<p>Morbi sed molestie metus nunc malesuada lorem ut consectetur.</p>
				</div>
				<ul class="nospace group center">
					<li class="one_third first">
						<article>
							<a href="#">
								<i class="btmspace-30 icon fa fa-500px"></i>
							</a>
							<h6 class="heading font-x1">Sodales sollicitudin</h6>
							<p>Cursus elit tristique et sed id convallis arcu sed ac facilisis ligula nec maximus felis imperdiet condimentum
								[&hellip;]
							</p>
							<footer>
								<a href="#">Read More &raquo;</a>
							</footer>
						</article>
					</li>
					<li class="one_third">
						<article>
							<a href="#">
								<i class="btmspace-30 icon fa fa-envira"></i>
							</a>
							<h6 class="heading font-x1">Maecenas et bibendum</h6>
							<p>Dolor et vestibulum phasellus scelerisque magna sapien non maximus sem faucibus id vestibulum neque eros [&hellip;]</p>
							<footer>
								<a href="#">Read More &raquo;</a>
							</footer>
						</article>
					</li>
					<li class="one_third">
						<article>
							<a href="#">
								<i class="btmspace-30 icon fa fa-empire"></i>
							</a>
							<h6 class="heading font-x1">Placerat ullamcorper</h6>
							<p>Ac iaculis eleifend nibh nulla aliquet orci quis urna tristique egestas sed scelerisque dolor ipsum placerat [&hellip;]</p>
							<footer>
								<a href="#">Read More &raquo;</a>
							</footer>
						</article>
					</li>
				</ul>
				<!-- ################################################################################################ -->
			</section>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper row3">
			<div class="hoc container clear">
				<!-- ################################################################################################ -->
				<div class="group">
					<section class="one_half first">
						<h6 class="heading btmspace-50">From The Blog</h6>
						<ul class="nospace">
							<li class="btmspace-30">
								<article>
									<h4 class="nospace">
										<a href="#">Facilisis mauris tellus gravida elit ac eleifend nunc lorem</a>
									</h4>
									<time class="font-xs" datetime="2045-04-06">Friday, 6
										<sup>th</sup>
										April 2045</time>
								</article>
							</li>
							<li class="btmspace-30">
								<article>
									<h4 class="nospace">
										<a href="#">Felis turpis semper at velit non porttitor semper libero</a>
									</h4>
									<time class="font-xs" datetime="2045-04-05">Thursday, 5
										<sup>th</sup>
										April 2045</time>
								</article>
							</li>
							<li>
								<article>
									<h4 class="nospace">
										<a href="#">Dignissim arcu nec vulputate purus semper aliquam rhoncus</a>
									</h4>
									<time class="font-xs" datetime="2045-04-04">Wednesday, 4
										<sup>th</sup>
										April 2045</time>
								</article>
							</li>
						</ul>
					</section>
					<section class="one_half">
						<h6 class="heading btmspace-50">Newsletter</h6>
						<p>Sed a eros ornare pulvinar lorem eget volutpat ex fusce sollicitudin porta erat ac dictum sed nec augue augue praesent
							congue.
						</p>
						<p class="btmspace-30">Ullamcorper neque a bibendum dolor placerat non nulla facilisi nullam ac velit.</p>
						<form id="newsletter" method="post" action="#">
							<fieldset>
								<legend>Newsletter:</legend>
								<input class="btmspace-15" type="text" value="" placeholder="Name">
								<input class="btmspace-15" type="text" value="" placeholder="Email">
								<button type="submit" value="submit">Submit</button>
							</fieldset>
						</form>
					</section>
				</div>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper row4 bgded overlay" style="background-image: url('images/homepage/03.png');">
			<footer id="footer" class="hoc clear">
				<!-- ################################################################################################ -->
				<h3 class="heading">Brickary</h3>
				<nav>
					<ul class="nospace inline pushright uppercase">
						<li>
							<a href="index.jsp">
								<i class="fa fa-lg fa-home"></i>
							</a>
						</li>
						<li>
							<a href="#">About</a>
						</li>
						<li>
							<a href="#">Contact</a>
						</li>
						<li>
							<a href="#">Terms</a>
						</li>
						<li>
							<a href="#">Privacy</a>
						</li>
						<li>
							<a href="#">Cookies</a>
						</li>
						<li>
							<a href="#">Disclaimer</a>
						</li>
					</ul>
				</nav>
				<ul class="faico clear">
					<li>
						<a class="faicon-facebook" href="#">
							<i class="fa fa-facebook"></i>
						</a>
					</li>
					<li>
						<a class="faicon-twitter" href="#">
							<i class="fa fa-twitter"></i>
						</a>
					</li>
					<li>
						<a class="faicon-dribble" href="#">
							<i class="fa fa-dribbble"></i>
						</a>
					</li>
					<li>
						<a class="faicon-linkedin" href="#">
							<i class="fa fa-linkedin"></i>
						</a>
					</li>
					<li>
						<a class="faicon-google-plus" href="#">
							<i class="fa fa-google-plus"></i>
						</a>
					</li>
					<li>
						<a class="faicon-vk" href="#">
							<i class="fa fa-vk"></i>
						</a>
					</li>
				</ul>
				<!-- ################################################################################################ -->
			</footer>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper row5">
			<div id="copyright" class="hoc clear">
				<!-- ################################################################################################ -->
				<p class="fl_left">
					Copyright &copy; 2016 - All Rights Reserved -
					<a href="#">Domain Name </a>
				</p>
				<p class="fl_right">
					Template by
					<a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a>
				</p>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<a id="backtotop" href="#top">
			<i class="fa fa-chevron-up"></i>
		</a>
	</form:form>
	<div id="loginPopup" class="modal">
		<header class="popupHeader">
			<span class="header_title">Login</span>
			<span class="modal_close" id="close" onclick="document.getElementById('loginPopup').style.display='none'">
				<i class="fa fa-times"></i>
			</span>
		</header>

		<section class="popupBody">
			<!-- Social Login -->
			<div class="social_login">
				<div class="">
					<a href="#" class="social_box fb">
						<span class="icon">
							<i class="fa fa-facebook"></i>
						</span>
						<span class="icon_title">Connect with Facebook</span>

					</a>
					<a href="#" class="social_box google">
						<span class="icon">
							<i class="fa fa-google-plus"></i>
						</span>
						<span class="icon_title">Connect with Google</span>
					</a>
				</div>

				<div class="centeredText">
					<span>Or use your Email address</span>
				</div>

				<div class="action_btns">
					<div class="one_half">
						<a href="#" id="login_form" class="btn">Login</a>
					</div>
					<br />
					<div class="one_half last">
						<a href="#" id="register_form" class="btn">Sign up</a>
					</div>
				</div>
			</div>

			<!-- Username & Password Login form -->
			<div class="user_login">
				<form:form name="userLogin" id="userLogin" modelAttribute="homePageDetails">
					<div>
						<table class="loginRadio">
							<tr>
								<td class="loginRadio" colspan="4" style="text-align: center;">Login As
								</td>
							</tr>
							<tr>
								<td class="loginRadio">
									<input type="radio" name="loginAs" id="customer" value="C" checked="checked" onchange="manageLogin(this.id);">
								</td>
								<td class="loginRadio">Customer</td>
								<td class="loginRadio">
									<input type="radio" name="loginAs" id="shopOwner" value="S" onchange="manageLogin(this.id);">
								</td>
								<td class="loginRadio">Shop Owner</td>
							</tr>
						</table>
					</div>
					<div id="customerDiv">
						<label>EmailId</label>
						<input type="text" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required />
						<br />
						<label>Password</label>
						<input type="password" name="customerPassword" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
						 required />
						<br />
					</div>
					<div id="shopOwnerDiv" style="display: none">
						<label>Shop Registration Number</label>
						<input type="text" name="shopRegistrationNumber" />
						<br />
						<label>Password</label>
						<input type="password" name="shopOwnerPassword" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
						 required />
						<br />
					</div>


					<div class="checkbox">
						<input id="remember" type="checkbox" />
						<label for="remember">Remember me on this computer</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn">
								<i class="fa fa-angle-double-left"></i> Back
							</a>
						</div>
						<div class="one_half last">
							<a onclick="submitLoginForm('userLogin', 'userLogin.do')" class="btn btn_red" name="LoginButton">Login</a>
						</div>
					</div>
				</form:form>

				<a href="#" class="forgot_password">Forgot password?</a>
			</div>

			<!-- Register Form -->
			<div class="user_register">
				<form:form name="userRegistration" id="userRegistration" modelAttribute="homePageDetails">
					<label>Full Name</label>
					<input type="text" name="personName" />
					<br />
					<label>Email Address </label>
					<input type="email" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required />
					<br />
					<label>Mobile Number </label>
					<input type="text" name="mobileNumber" />
					<br />
					<label>Password</label>
					<input type="password" name="password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required
					/>

					<div class="checkbox">
						<input id="send_updates" type="checkbox" name="notification" />
						<label for="send_updates">Send me occasional email updates</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn">
								<i class="fa fa-angle-double-left"></i> Back
							</a>
						</div>
						<div class="one_half last">
							<a onclick="submitForm_Action('userRegistration', 'userRegistration.do')" class="btn btn_red" name="LoginButton">Register</a>
						</div>
					</div>
				</form:form>
			</div>
		</section>
	</div>
	<%@include file="/WEB-INF/jsp/common/dialogBox.jsp"%>
		<!-- JAVASCRIPTS -->
		<script src="js/jquery.backtotop.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.flexslider-min.js"></script>
</body>

</html>