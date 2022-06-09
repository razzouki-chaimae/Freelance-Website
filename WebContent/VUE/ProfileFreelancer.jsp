<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<%@ include file="/VUE/HeadFreelancer.jsp"%>
<title>Mon profile</title>
</head>

<body>

	<!-- ======= Header ======= -->
	<%@ include file="/VUE/HeaderFreelancer.jsp"%>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<div id="hero" class="home"
		style='background-image: url("${sessionScope.ImageUser.urlImange}");'>

		<div class="container">
			<div class="hero-content">
				<h1>
					Je suis <span class="typed"
						data-typed-items="${sessionScope.user.nom} ${sessionScope.user.prenom}, ${sessionScope.user.profession}, Freelancer"></span>
				</h1>
				<p>${sessionScope.user.nom}${sessionScope.user.prenom},
					${sessionScope.user.profession}, Freelancer</p>
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
								<img src="${sessionScope.ImageUser.urlImange}"
									class="img-responsive" alt="me">
							</div>
						</div>
					</div>

					<div class="col-lg-7">
						<div class="about-descr">

							<p class="p-heading">${sessionScope.user.nom}
								${sessionScope.user.prenom}</p>
							<p class="separator">${sessionScope.user.description}</p>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- End About Section -->

		<!-- ======= Services Section ======= -->
		<c:if test="${ empty requestScope.myProjects }">
			<section id="services" class="services">
				<div class="container">

					<div class="section-title d-flex justify-content-center"
						data-aos="fade-up">
						<h2 id="titre-myProjects">Mes projets</h2>
					</div>


					<div id="noProject" class="d-flex justify-content-center">
						<img alt="No Project Yet"
							src="/freelanceProject/VUE/img/noProject.jpg">
					</div>

				</div>
			</section>
		</c:if>
		<!-- 
				<c:if test="${ !empty requestScope.myProjects }">
					<div class="row  d-flex justify-content-center">
						<c:forEach var="project" items="${requestScope.myProjects}">
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

-->
		<!-- End Services Section -->

		<!-- ======= Portfolio Section ======= -->
		<c:if test="${ !empty requestScope.myProjects }">
			<section id="portfolio" class="portfolio">
				<div class="container">

					<div class="d-flex justify-content-center" data-aos="fade-up">
						<h2 id="titre-myProjects">Dashboard</h2>
					</div>

					<div class="row" data-aos="fade-up" data-aos-delay="200">
						<div class="col-lg-12 d-flex justify-content-center">
							<ul id="portfolio-flters">
								<li data-filter="*" class="filter-active">Tous</li>
								<li data-filter=".false">En phase de demande</li>
								<li data-filter=".true">En phase de développement</li>
							</ul>
						</div>
					</div>

					<div class="row portfolio-container" data-aos="fade-up"
						data-aos-delay="400">

						<c:forEach var="project" items="${requestScope.myProjects}">
							<div
								class="col-lg-4 col-md-6 portfolio-item ${ project.done } shadow p-3 mb-5 bg-white rounded">
								<div class="portfolio-wrap">
									<h1>${ project.titre }</h1>
									<p>${ project.description }</p>
								</div>
							</div>
						</c:forEach>
					</div>

				</div>
			</section>
		</c:if>
		<!-- End Portfolio Section -->

		<!-- ======= Contact Section ======= -->
		<div id="contact" class="paddsection">
			<div class="container">
				<div class="contact-block1">
					<div class="row">

						<div class="col-lg-6">
							<div class="contact-contact">

								<h2 class="mb-30">CONTACTEZ-MOI</h2>

								<ul class="contact-details">
									<li><i class="bi bi-geo-alt"></i> <span>${sessionScope.user.adressePhysique}</span></li>
									<li><i class="bi bi-envelope"></i> <span>${sessionScope.user.email}</span></li>
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

</body>

</html>