<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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

<link href="/freelanceProject/VUE/assetsModifyOffre/Style.css"
	rel="stylesheet">
<title>Postulants</title>
</head>
<body id="top">

	<!-- ======= Header ======= -->
	<%@ include file="/VUE/HeaderEntreprise.jsp"%>
	<!-- End Header -->
	<div class="row">
		<div class="col-sm-4">
			<div class="card">
				<h5 class="text-center mb-4">Modifier Annonce</h5>
				<form class="form-card" method="post"
					action="<%= request.getContextPath() %>/ModificationOffreServlet?id=${ requestScope.idOffre }">
					<div class="row justify-content-between text-left">
						<div class="form-group col-12 flex-column d-flex">
							<label class="form-control-label px-3">Titre</label> <input
								type="text" id="ans" name="titre" onblur="validate(6)"
								value="${ requestScope.titre }">
						</div>
					</div>
					<div class="row justify-content-between text-left">
						<div class="form-group col-12 flex-column d-flex">
							<label class="form-control-label px-3">Description</label>
							<textarea class="span6" rows="3" name="description">${ requestScope.description }</textarea>
						</div>
					</div>
					<div class="row justify-content-between text-left">
						<div class="form-group col-sm-6 flex-column d-flex">
							<label class="form-control-label px-3">Deadline (en
								jours)</label> <input type="text" id="ans" name="deadline"
								onblur="validate(1)" value="${ requestScope.deadline }">
						</div>
						<div class="form-group col-sm-6 flex-column d-flex">
							<label class="form-control-label px-3">Budget (en DH)</label> <input
								type="text" id="ans" name="budget" onblur="validate(2)"
								value="${ requestScope.budget }">
						</div>
					</div>
					<div class="row justify-content-between text-left">
						<div class="form-group col-12 flex-column d-flex">
							<label class="form-control-label px-3">Skills (minimun
								un)</label> <input type="text" id="ans" name="skills"
								onblur="validate(6)" value="${ requestScope.skills }">
						</div>
					</div>
					<div class="row justify-content-center">
						<div class="form-group col-sm-6">
							<button type="submit" class="btn-block btn-submit-modification">Modifier</button>
						</div>
					</div>
				</form>
				<div class="row justify-content-center">
					<div class="form-group col-sm-6">
						<button class="btn-block btn-delete-offre">
							<a id="delete-offre"
								href="<%= request.getContextPath() %>/DeleteOffre?id=${ requestScope.idOffre }">Supprimer</a>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-8">

			<c:if test="${ empty requestScope.postulants }">
				<div class="page-content" id="page-content">
					<div>
						<div class="aa-testimonials-section section">
							<div class="container" id="nos-offres">
								<div class="text-center">
									<h2 class="title" id="titre-old-offres">L'ensemble des
										postulants</h2>
								</div>
								<div id="noProject" class="d-flex justify-content-center">
									<img alt="No Project Yet"
										src="/freelanceProject/VUE/img/noProject.jpg">
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${ !empty requestScope.postulants }">
				<!-- ======= Team Section ======= -->
				<section id="team" class="team section-bg">
					<div class="container" id="section-postulants">

						<div class="section-title" data-aos="fade-up">
							<h2>L'ensemble des demandeurs</h2>
						</div>

						<div class="row">
							<c:forEach var="freelancer" items="${requestScope.freelancers}">
								<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
									<div class="member" data-aos="fade-up" data-aos-delay="100">
										<div class="member-img">
											<img
												src="/freelanceProject/VUE/assetsProfileFreelancer/img/${ freelancer.rib }.jpg"
												class="img-fluid" alt="">
											<div class="social">
												<a href=""><i class="bi bi-twitter"></i></a> <a href=""><i
													class="bi bi-facebook"></i></a> <a href=""><i
													class="bi bi-instagram"></i></a> <a href=""><i
													class="bi bi-linkedin"></i></a>
											</div>
										</div>
										<div class="member-info">
											<h4>
												<a
													href="<%= request.getContextPath() %>/GetProfileFreelancer?id=${ freelancer.rib }&offre=${ requestScope.idOffre }"><c:out
														value="${ freelancer.nom } ${ freelancer.prenom }" /></a>
											</h4>
											<span><c:out value="${ freelancer.profession }" /></span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</section>
				<!-- End Team Section -->
			</c:if>
		</div>
	</div>
	<!-- ======= Footer ======= -->
	<%@ include file="/VUE/Footer.jsp"%>
	<!-- End Footer -->

	<script type="text/javascript"
		src="/freelanceProject/VUE/assetsModifyOffre/script.js"></script>

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