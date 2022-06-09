<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!-- Template Main CSS File -->
<link href="/freelanceProject/VUE/assetsAddOffre/css/style.css"
	rel="stylesheet">
	
<script src="/freelanceProject/VUE/assetsAddOffre/js/javascript.js" defer></script>
<title>Ajouter un offre</title>
</head>
<body>
	<!-- ======= Header ======= -->
	<%@ include file="/VUE/HeaderEntreprise.jsp"%>
	<!-- End Header -->

	<form class="form"  action="/freelanceProject/AddOffreServlet" method="post"  id="add-offre-form">
		<h1 class="text-center">Ajouter Un Offre</h1>
		<!-- Progress bar -->
		<div class="progressbar">
			<div class="progress" id="progress"></div>

			<div class="progress-step progress-step-active" data-title="Introduction"></div>
			<div class="progress-step" data-title="budget & deadline"></div>
			<div class="progress-step" data-title="skills"></div>
			<div class="progress-step" data-title="confirmer"></div>
		</div>

		<!-- Steps -->
		<div class="form-step form-step-active">
			<div class="input-group">
				<label for="username">Title</label> <input type="text"
					name="Offre_Title" id="username" required="required"/>
			</div>
			<div class="input-group">
				<label for="position">Description</label> <input type="text"
					name="description" id="position" required="required"/>
			</div>
			<div class="">
				<a href="#" class="btn btn-next width-50 ml-auto">Suivant</a>
			</div>
		</div>
		<div class="form-step">
			<div class="input-group">
				<label for="phone">Budget (en DH)</label> <input type="text" name="Budget"
					id="phone" required="required"/>
			</div>
			<div class="input-group">
				<label for="email">Deadline (en jours)</label> <input type="text"
					name="deadline" id="email" required="required"/>
			</div>
			<div class="btns-group">
				<a href="#" class="btn btn-prev">Précédent</a> <a href="#"
					class="btn btn-next">Suivant</a>
			</div>
		</div>
		<div class="form-step">
			<div class="input-group">
				<label for="dob">Skills (au moins un)</label> <input type="text" name="Skills"
					id="dob" required="required"/>
			</div>
			<div class="btns-group">
				<a href="#" class="btn btn-prev">Précédent</a> <a href="#"
					class="btn btn-next">Suivant</a>
			</div>
		</div>
		<div class="form-step">

			<div class="btns-group">
				<a href="#" class="btn btn-prev">Précédent</a> <input type="submit"
					value="Submit" class="btn" />
			</div>
		</div>
	</form>


	<!-- ======= Footer ======= -->
	<%@ include file="Footer.jsp"%>
</body>
</html>