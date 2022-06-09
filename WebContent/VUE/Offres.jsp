<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="HeadFreelancer.jsp"%>

<!-- Vendor CSS Files -->
<link href="/freelanceProject/VUE/assets/vendor/aos/aos.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="/freelanceProject/VUE/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="/freelanceProject/VUE/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/freelanceProject/VUE/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: Vesperr - v4.7.0
  * Template URL: https://bootstrapmade.com/vesperr-free-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	crossorigin="anonymous"></script>
<title>Offres disponibles</title>
</head>
<body>
	<!-- ======= Header ======= -->
	<%@ include file="HeaderFreelancer.jsp"%>


	<main id="main">
		<!-- ======= Services Section ======= -->
		<section id="services" class="services">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Offres Disponibles</h2>
					<!-- <p>Voici les services les plus fréquemment demandés dans notre
						plateforme</p> -->
				</div>

				<div class="row">
					<c:forEach var="offre" items="${requestScope.offres}">
						<div
							class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
							<div class="icon-box" data-aos="fade-up" data-aos-delay="100" id="btn-postuler-container">
								<div class="icon">
									<i class="bi bi-puzzle"></i>
								</div>
								<h4 class="title">
									<a href=""><c:out value="${ offre.titre }" /></a>
								</h4>
								<p class="description">
									<c:out value="${ offre.description }" />
								</p>
								<div class="social description">
									<p class="description">
										<i class="bi bi-check2-circle"></i>
										<c:out value="${ offre.skills }" />
									</p>
									<p class="description">
										<i class="bi bi-coin"></i>
										<c:out value="${ offre.budget }" />
										DH
									</p>
									<p class="description">
										<i class="bi bi-stopwatch"></i>
										<c:out value="${ offre.deadline }" />
										jours
									</p>
									<p class="description ">
										<a
											href="<%= request.getContextPath() %>/GetProfileEntreprise?id=${ offre.entreprise }"
											id="goToCompany"> <i class="bi bi-building"></i>
											Consulter l'entreprise
										</a>
									</p>
								</div>
								<div id="btn-postuler" class="d-flex justify-content-center fixed-bottom">
									<p class="description">
										<a class="btn-get-started getstarted description"
											href="<%= request.getContextPath() %>/AddPostulant?id=${ offre.projectId }">
											Postuler </a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</section>
		<!-- End Services Section -->

		<!-- .modal -->
		<div class="modal fade" id="Mymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header d-flex justify-content-center">
						<h4 class="modal-title">Notification</h4>
					</div>
					<div class="modal-body">Votre demande a été envoyée.</div>
					<div class="modal-footer">
						<!-- <button type="button" class="btn btn-default" data-dismiss="modal">
							Ok</button> -->
						<div id="btn-postuler" class="d-flex justify-content-center">
							<p class="description">
								<a class="btn-get-started getstarted description"
									data-dismiss="modal"
									href="<%= request.getContextPath() %>/AddPostulant"> Ok </a>
							</p>
						</div>
						<!-- <button type="button" class="btn btn-primary">Ok</button> -->
					</div>
				</div>
			</div>
		</div>

	</main>

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center active"><i
		class="bi bi-arrow-up-short"></i></a>

	<!--	<script src="<%=request.getContextPath()%>/template/js/main.js"></script>

	 ======= Footer ======= -->
	<%@ include file="Footer.jsp"%>
</body>
</html>