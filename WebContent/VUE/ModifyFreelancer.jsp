<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/VUE/HeadFreelancer.jsp" %>
    
    <link rel="stylesheet" href="/freelanceProject/VUE/CSS/styleModifyFreelancer.css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Modifier mon profile</title>
</head>
<body background="${sessionScope.ImageUser}">
  <!-- ======= Header ======= -->
  <%@ include file="/VUE/HeaderFreelancer.jsp" %>
  <!-- End Header -->
  
  <!-- ======= Registration Form ======= -->
	<div class="container contact-form">
		<form method="post" action="<%= request.getContextPath() %>/ModificationFreelancerServlet">
			<h3>Modification du profile</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Nom</label>
						<input type="text" name="nom" class="form-control" value="${requestScope.nom}" />
					</div>
					<div class="form-group">
						<label>Adresse physique</label>
						<input type="text" name="adressePhysique" class="form-control" value="${requestScope.adressePhysique}" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<input type="text" name="email" class="form-control" value="${requestScope.email}" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" />
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
						<label>Prénom</label>
						<input type="text" name="prenom" class="form-control" value="${requestScope.prenom}" />
					</div>
					<div class="form-group">
						<label>Profession</label>
						<input type="text" name="profession" class="form-control" value="${requestScope.profession}" />
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