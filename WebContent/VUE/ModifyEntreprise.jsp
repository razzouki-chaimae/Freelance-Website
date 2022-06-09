<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/VUE/Head.jsp"%>
    
    <link rel="stylesheet" href="/freelanceProject/VUE/CSS/styleModifyFreelancer.css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Modifier mon profile</title>
</head>
<body>
  <!-- ======= Header ======= -->
  <%@ include file="/VUE/HeaderEntreprise.jsp" %>
  <!-- End Header -->
  
  <!-- ======= Registration Form ======= -->
	<div class="container contact-form">
		<form method="post" action="<%= request.getContextPath() %>/ModificationEntrepriseServlet">
			<h3>Modification du profile</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Nom d'entreprise</label>
						<input type="text" name="nomEntreprise" class="form-control" value="${requestScope.nomEntreprise}" />
					</div>
					<div class="form-group">
						<label>Adresse physique</label>
						<input type="text" name="adressePhysique" class="form-control" value="${requestScope.adressePhysique}" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<input type="text" name="emailEntreprise" class="form-control" value="${requestScope.emailEntreprise}" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" />
					</div>
					<div class="form-group">
						<label>Ancien mot de passe</label>
						<input type="text" name="old_password" class="form-control" value="${requestScope.old_password}" disabled/>
					</div>
					<div class="form-group">
						<label>Nouveau mot de passe</label>
						<input type="text" name="new_password" class="form-control" value="${requestScope.old_password}" />
					</div>
					<div class="form-group">
						<input type="submit" name="btnSubmit" class="btnContact"
							value="Modifier" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Numéro de Téléphone</label>
						<input type="text" name="numeroTelephone" class="form-control" value="${requestScope.numeroTelephone}" />
					</div>
					<div class="form-group">
						<label>Domaine</label>
						<input type="text" name="domaine" class="form-control" value="${requestScope.domaine}" />
					</div>
					<div class="form-group">
						<label>Description</label>
						<textarea name="description" class="form-control" style="width: 100%; height: 265px;" >${requestScope.description}
						</textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="/freelanceProject/VUE/js/jquery-3.3.1.min.js"></script>
	<script src="/freelanceProject/VUE/js/jquery.steps.js"></script>
	<script src="/freelanceProject/VUE/js/mainFreelancerRegistration.js"></script><!-- End Registration Form -->
  
  <!-- ======= Footer ======= -->
  <%@ include file="/VUE/Footer.jsp" %>
  <!-- End Footer -->
</body>
</html>