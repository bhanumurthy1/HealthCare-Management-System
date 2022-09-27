<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			defaultDate : '01/01/1995'
		});
	});

	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	
	$(function() {
		$("#datepicker2").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script language="javascript">
	$(function() {
		$("#selectall").click(function() {
			$('.case').attr('checked', this.checked);
		});
		$(".case").click(function() {

			if ($(".case").length == $(".case:checked").length) {
				$("#selectall").attr("checked", "checked");
			} else {
				$("#selectall").removeAttr("checked");
			}

		});
	});
</script>
<style type="text/css">
.blockquote {
	padding: 20px;
	box-shadow: inset 0 -3em 3em rgba(0, 0, 0, 0.1), 0 0 0 2px
		rgb(255, 255, 255), 0.3em 0.3em 1em rgba(0, 0, 0, 0.3);
}

.imageHeight {
	height: 320px;
}

.linkSize {
	font-size: 14px;
}

.row.heading h2 {
	color: #000;
	font-size: 52.52px;
	line-height: 95px;
	font-weight: 400;
	text-align: center;
	margin: 0 0 40px;
	padding-bottom: 20px;
	text-transform: uppercase;
}

ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

.heading.heading-icon {
	display: block;
}

.padding-lg {
	display: block;
	padding-top: 60px;
	padding-bottom: 60px;
}

.practice-area.padding-lg {
	padding-bottom: 55px;
	padding-top: 55px;
}

.practice-area .inner {
	border: 1px solid #999999;
	text-align: center;
	margin-bottom: 28px;
	padding: 40px 25px;
}

.our-webcoderskull .cnt-block:hover {
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
	border: 0;
}

.practice-area .inner h3 {
	color: #3c3c3c;
	font-size: 24px;
	font-weight: 500;
	font-family: 'Poppins', sans-serif;
	padding: 10px 0;
}

.practice-area .inner p {
	font-size: 14px;
	line-height: 22px;
	font-weight: 400;
}

.practice-area .inner img {
	display: inline-block;
}

.our-webcoderskull .cnt-block {
	float: left;
	width: 100%;
	background: #fff;
	padding: 30px 20px;
	text-align: center;
	border: 2px solid #d5d5d5;
	margin: 0 0 28px;
}

.our-webcoderskull .cnt-block figure {
	width: 148px;
	height: 148px;
	border-radius: 100%;
	display: inline-block;
	margin-bottom: 15px;
}

.our-webcoderskull .cnt-block img {
	width: 148px;
	height: 148px;
	border-radius: 100%;
}

.our-webcoderskull .cnt-block h3 {
	color: #2a2a2a;
	font-size: 20px;
	font-weight: 500;
	padding: 6px 0;
	text-transform: uppercase;
}

.our-webcoderskull .cnt-block h3 a {
	text-decoration: none;
	color: #2a2a2a;
}

.our-webcoderskull .cnt-block h3 a:hover {
	color: #337ab7;
}

.our-webcoderskull .cnt-block p {
	color: #2a2a2a;
	font-size: 13px;
	line-height: 20px;
	font-weight: 400;
}

.our-webcoderskull .cnt-block .follow-us {
	margin: 20px 0 0;
}

.our-webcoderskull .cnt-block .follow-us li {
	display: inline-block;
	width: auto;
	margin: 0 5px;
}

.our-webcoderskull .cnt-block .follow-us li .fa {
	font-size: 24px;
	color: #767676;
}

.our-webcoderskull .cnt-block .follow-us li .fa:hover {
	color: #025a8e;
}
</style>
</head>
<body style="background-color: #e2f2f2bd">
	<div>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>