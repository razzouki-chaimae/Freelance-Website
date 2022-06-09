<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<%@ include file="/VUE/Head.jsp"%>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="https://fonts.googleapis.com/css?family=Dosis:600|Roboto:400,700"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assetsProfileEntreprise/css/bootstrap.min.css?ver=1.1.0"
	rel="stylesheet">

<link
	href="/freelanceProject/VUE/assetsProfileEntreprise/css/main.css?ver=1.1.0"
	rel="stylesheet">
<title>Mon profile</title>
</head>

<body id="top">

	<!-- ======= Header ======= -->
	<%@ include file="/VUE/HeaderEntreprise.jsp"%>
	<!-- End Header -->
	<!-- ======= Hero Section ======= -->
	<section id="hero" class="d-flex align-items-center">
		<div class="container aa-header-content text-left"
			id="info-entreprise">
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<h1 class="mb-4">${sessionScope.user.nomEntreprise}</h1>
					<ul class="py-1 list-unstyled">
						<li class="py-2"><i class="bi bi-building" aria-hidden="true"></i>
							Domaine : ${sessionScope.user.domaine}</li>
					</ul>
					<p>${sessionScope.user.description}</p>
					<ul class="py-1 list-unstyled">
						<li class="py-2"><i class="bi bi-at" aria-hidden="true"></i>
							${sessionScope.user.emailEntreprise}</li>
						<li class="py-2"><i class="bi bi-telephone"
							aria-hidden="true"></i> ${sessionScope.user.numeroTelephone}</li>
						<li class="py-2"><i class="bi bi-geo-alt" aria-hidden="true"></i>
							${sessionScope.user.adressePhysique}</li>
					</ul>
				</div>
				<div class="col-md-6 col-sm-12 text-right">
					<img class="img-fluid"
						src="/freelanceProject/VUE/assetsProfileEntreprise/images/${sessionScope.user.rib}.jpg"
						alt="Image">
				</div>
			</div>
		</div>
	</section>
	<!-- End Hero -->

	<div class="page-content" id="page-content">
		<div>
			<div class="aa-testimonials-section section">
				<div class="container" id="nos-offres">
					<div class="text-center">
						<h2 class="title" id="titre-old-offres">Nos offres annoncés</h2>
					</div>
					<c:if test="${ empty requestScope.myOffres }">
						<div id="noProject" class="d-flex justify-content-center">
							<img alt="No Project Yet"
								src="/freelanceProject/VUE/img/noProject.jpg">
						</div>
					</c:if>
					<c:if test="${ !empty requestScope.myOffres }">
						<div class="aa-testimonials">
							<div class="row">
								<c:forEach var="offre" items="${requestScope.myOffres}">
									<div class="col-md-4 mb-3">
										<div class="aa-testimonials-body">
											<h3><a href="<%= request.getContextPath() %>/ViewPostulants?id=${ offre.projectId }">${ offre.titre }</a></h3>
											<p>${ offre.description }</p>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<%@ include file="/VUE/Footer.jsp"%>
	<!-- End Footer -->

	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/jquery.min.js?ver=1.1.0"></script>
	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/jquery-ui-1.12.1.custom.min.js?ver=1.1.0"></script>
	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/popper.min.js?ver=1.1.0"></script>
	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/bootstrap.min.js?ver=1.1.0"></script>
	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/paper-kit.js?ver=1.1.0"></script>
	<script
		src="/freelanceProject/VUE/assetsProfileEntreprise/scripts/main.js?ver=1.1.0"></script>

</body>
</html>