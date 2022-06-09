<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/freelanceProject/VUE/img/Freelancing-removebg-preview.png"
	rel="icon">
<link href="/freelanceProject/VUE/img/Freelancing-removebg-preview.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,500i,600,600i,700,700i|Playfair+Display:400,400i,500,500i,600,600i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="/freelanceProject/VUE/assetsProfileFreelancer/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assetsProfileFreelancer/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assetsProfileFreelancer/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assetsProfileFreelancer/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assetsProfileFreelancer/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/freelanceProject/VUE/assetsProfileFreelancer/css/style.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Folio - v4.7.0
  * Template URL: https://bootstrapmade.com/folio-bootstrap-portfolio-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  $(document).ready(function () {
	    $("#deleteFreelancer").click(function () {

	        //confirm("Press a button!");
	        if (confirm('Vous voulez vraiment supprimer votre compte?')) {
	            // Save it!
	            console.log('Switch to the servlet in : ${pageContext.request.contextPath}/DeleteFreelancer');
	            $.get('${pageContext.request.contextPath}/DeleteFreelancer', function(data) {
	            	if(data=="ok")	location.href = "VUE/index.jsp";
	            });
	        } else {
	        	//location.href = "VUE/index.jsp";
	        }

	    });
	});
  </script>