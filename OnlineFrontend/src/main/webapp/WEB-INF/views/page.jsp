<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/rs/images" />
<spring:url var="customcs" value="/rs/css" />
<spring:url var="custumjs" value="/rs/js" />
<spring:url var="jquery" value="/rs/vendor/jquery" />
<spring:url var="bootcs" value="/rs/vendor/bootstrap/css" />
<spring:url var="bootjs" value="/rs/vendor/bootstrap/js" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">


<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>

<!-- Bootstrap core CSS -->
<link href="${bootcs}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap theme -->
<link href="${bootcs}/bootstrap.min.theme.css" rel="stylesheet">

<!-- Bootstrap DataTable -->
<link href="${customcs}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${customcs}/shop-homepage.css" rel="stylesheet">

<script>
	window.contextRoot = '${contextRoot}';
</script>
</head>

<body>


	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="shared/nav.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userclickhome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userclickabout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userclickcontact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${userclickservices == true}">
				<%@include file="services.jsp"%>
			</c:if>
			
			<c:if test="${userclickAllProducts == true  || userclickCategoryProducts == true}">
				<%@include file="product.jsp"%>
			</c:if>
			
			<c:if test="${userclickSingleProduct == true}">
				<%@include file="Productinfo.jsp"%>
			</c:if>
			
			<c:if test="${userclickManageProduct == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="shared/footer.jsp"%>
	</div>
	<!-- JQuery core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${bootjs}/bootstrap.min.js"></script>
	
	<!-- Datatable core -->
	<script src="${custumjs}/jquery.dataTables.js"></script>
	
	<!-- Datatable BootStrap -->
	<!--  
	<script src="${custumjs}/dataTables.bootstrap.js"></script>
	-->
	
	<script src="${custumjs}/bootbox.min.js"></script>
	
	<!-- Custom Script -->
	<script src="${custumjs}/myscript.js"></script>

</body>

</html>
