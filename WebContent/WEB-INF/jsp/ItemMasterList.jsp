<%@include file="/WEB-INF/jsp/common/includeDirectives.jsp"%>
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ItemDescription</title>
	</head>
	<%@include file="/WEB-INF/jsp/common/scripts.jsp"%>
		<style type="text/css">
			.imgItem {
				position: absolute;
				padding-top: 85px;
				/* top: 0;
	left: 0;
	right: 0;
	bottom: 0;  */
			}

			.imgItemPreview {
				display: inline-block;
				border: 0;
				width: 50px;
				height: 50px;
				position: relative;
				-webkit-transition: all 200ms ease-in;
				-webkit-transform: scale(1);
				-ms-transition: all 200ms ease-in;
				-ms-transform: scale(1);
				-moz-transition: all 200ms ease-in;
				-moz-transform: scale(1);
				transition: all 200ms ease-in;
				transform: scale(1);
			}

			.imgItemPreview:hover {
				border: 10px;
				border-color: black;
				box-shadow: 0px 0px 5px #000000;
				z-index: 2;
				border-radius: 15px;
				-webkit-transition: all 200ms ease-in;
				-webkit-transform: scale(1.5);
				-ms-transition: all 200ms ease-in;
				-ms-transform: scale(1.5);
				-moz-transition: all 200ms ease-in;
				-moz-transform: scale(1.5);
				transition: all 200ms ease-in;
				transform: scale(1.5);
			}
		</style>

		<body>
			<form:form>
				<div align="center" class="imgItem">
					<div style="width: 100px;">
						<div>
							<img class="imgItemPreview" src="images/a.jpg">
							<img class="imgItemPreview" src="images/b.jpg">
							<img class="imgItemPreview" src="images/c.jpg">
						</div>
					</div>
				</div>
			</form:form>
		</body>

	</html>