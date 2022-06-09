<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/VUE/HeadFreelancer.jsp"%>

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
<title>Profile freelancer</title>
</head>

<body id="top">

	<!-- ======= Header ======= -->
	<%@ include file="/VUE/HeaderEntreprise.jsp"%>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<div id="hero" class="home"
		style='background-image: url("/freelanceProject/VUE/assetsProfileFreelancer/img/${requestScope.freelancer.rib}.jpg");'>

		<div class="container">
			<div class="hero-content">
				<h1>
					Je suis <span class="typed"
						data-typed-items="${requestScope.freelancer.nom} ${requestScope.freelancer.prenom}, ${requestScope.freelancer.profession}, Freelancer"></span>
				</h1>
				<p>${requestScope.freelancer.nom}${requestScope.freelancer.prenom},
					${requestScope.freelancer.profession}, Freelancer</p>
				<a
					class="btn btn-outline-primary btn-get-started getstarted scrollto"
					href="<%=request.getContextPath()%>/ChooseFreelancer?id=${requestScope.freelancer.rib}&offre=${ requestScope.idOffre }">Choisissez-Moi</a>
			</div>
		</div>
	</div>
	<!-- End Hero -->

	<main id="main">

		<!-- ======= About Section ======= -->
		<div id="about" class="paddsection">
			<div class="container">
				<div class="row justify-content-between">

					<div class="col-lg-4 ">
						<div class="div-img-bg">
							<div class="about-img">
								<img
									src="/freelanceProject/VUE/assetsProfileFreelancer/img/${requestScope.freelancer.rib}.jpg"
									class="img-responsive" alt="me">
							</div>
						</div>
					</div>

					<div class="col-lg-7">
						<div class="about-descr">

							<p class="p-heading">${requestScope.freelancer.nom}
								${requestScope.freelancer.prenom}</p>
							<p class="separator">${requestScope.freelancer.description}</p>

							<a
								class="btn btn-outline-primary btn-lg btn-get-started getstarted scrollto"
								href="<%=request.getContextPath()%>/ChooseFreelancer?id=${requestScope.freelancer.rib}&offre=${ requestScope.idOffre }">Choisissez-Moi</a>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- End About Section -->

		<!-- ======= Services Section ======= -->
		<section id="services" class="services">
			<div class="container">

				<div class="section-title d-flex justify-content-center"
					data-aos="fade-up">
					<h2 id="titre-myProjects">Mes projets</h2>
				</div>

				<c:if test="${ empty requestScope.offres }">
					<div id="noProject" class="d-flex justify-content-center">
						<img alt="No Project Yet"
							src="/freelanceProject/VUE/img/noProject.jpg">
					</div>
				</c:if>

				<c:if test="${ !empty requestScope.offres }">
					<div class="row  d-flex justify-content-center">
						<c:forEach var="project" items="${requestScope.offres}">
							<div
								class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
								<div class="icon-box" data-aos="fade-up" data-aos-delay="100">
									<div class="icon">
										<i class="bi bi-puzzle"></i>
									</div>
									<h4 class="title">
										<a href=""><c:out value="${ project.titre }" /></a>
									</h4>
									<p class="description">
										<c:out value="${ project.description }" />
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>

			</div>
		</section>
		<!-- End Services Section -->


		<!-- ======= Contact Section ======= -->
		<div id="contact" class="paddsection">
			<div class="container">
				<div class="contact-block1">
					<div class="row">

						<div class="col-lg-6">
							<div class="contact-contact">

								<h2 class="mb-30">CONTACTEZ-MOI</h2>

								<ul class="contact-details">
									<li><i class="bi bi-geo-alt"></i> <span>${requestScope.freelancer.adressePhysique}</span></li>
									<li><i class="bi bi-envelope"></i> <span>${requestScope.freelancer.email}</span></li>
									<li><a
										class="btn btn-outline-primary btn-lg btn-get-started getstarted scrollto"
										href="<%=request.getContextPath()%>/ChooseFreelancer?id=${requestScope.freelancer.rib}&offre=${ requestScope.idOffre }">Choisissez-Moi</a></li>
								</ul>

							</div>
						</div>

						<div class="col-lg-6">
							<form action="/freelanceProject/VUE/forms/contact.php"
								method="post" role="form" class="php-email-form">
								<div class="row gy-3">

									<div class="col-lg-6">
										<div class="form-group contact-block1">
											<input type="text" name="name" class="form-control" id="name"
												placeholder="Your Name" required>
										</div>
									</div>

									<div class="col-lg-6">
										<div class="form-group">
											<input type="email" class="form-control" name="email"
												id="email" placeholder="Your Email" required>
										</div>
									</div>

									<div class="col-lg-12">
										<div class="form-group">
											<input type="text" class="form-control" name="subject"
												id="subject" placeholder="Subject" required>
										</div>
									</div>

									<div class="col-lg-12">
										<div class="form-group">
											<textarea class="form-control" name="message"
												placeholder="Message" required></textarea>
										</div>
									</div>

									<div class="col-lg-12">
										<div class="loading">Loading</div>
										<div class="error-message"></div>
										<div class="sent-message">Your message has been sent.
											Thank you!</div>
									</div>

									<div class="mt-0">
										<input type="submit" class="btn btn-defeault btn-send"
											value="Send message">
									</div>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Contact Section -->

	</main>
	<!-- End #main -->

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