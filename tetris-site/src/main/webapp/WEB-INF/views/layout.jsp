<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/tetris-site/css/bootstrap.min.css" />
<link rel="stylesheet" href="/tetris-site/css/tetrim.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="${ pageContext.request.contextPath }">
</head>
<title><tiles:insertAttribute name="title" /></title>
<body>
	<div class="container">
		<div class="alert alert-light" role="alert">
			<h1>
				<tiles:insertAttribute name="h1" />
			</h1>
		</div>

		<nav> <tiles:insertAttribute name="navigation" /> </nav>

		<br>
		<section> <tiles:insertAttribute name="content" /> </section>
		</br>
	</div>
</body>
<script src="js/bootstrap.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
</html>