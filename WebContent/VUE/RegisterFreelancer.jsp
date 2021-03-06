<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="Head.jsp" %>
  <link href="assets/css/RegisterFreelancerStyle.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Vesperr - v4.7.0
  * Template URL: https://bootstrapmade.com/vesperr-free-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <!-- head of register form template -->
  <!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="CSS/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="CSS/styleFreelancerRegistration.css"/>
<title>S'inscrire</title>
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="Header.jsp" %>

  <!-- ======= Registration Form ======= -->
  <div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
		        <form class="form-register" action="/freelanceProject/RegisterFreelancerServlet" method="post">
		        	<div id="form-total">
		        		<!-- SECTION 1 -->
			            <h2>
			            	<p class="step-icon"><span>01</span></p>
			            	<span class="step-text">Infomations Personnelles</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Infomations Personnelles</h3>
								</div>
								<div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Nom</legend>
											<input type="text" class="form-control" id="last-name" name="first-name" placeholder="Nom..." required>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>Pr??nom</legend>
											<input type="text" class="form-control" id="first-name" name="last-name" placeholder="Pr??nom..." required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Adresse Physique</legend>
											<input type="text" name="your_physical_address" id="your_email" class="form-control"  placeholder="NR 00, RUE XXXX Quartier YYYY , Ville, Pays" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Email</legend>
											<input type="text" name="your_email" id="your_email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Mot de passe</legend>
											<input type="password" name="your_password" id="your_email" class="form-control"  placeholder="........" required>
										</fieldset>
									</div>
								</div>
							</div>
			            </section>
						<!-- SECTION 2 -->
			            <h2>
			            	<p class="step-icon"><span>02</span></p>
			            	<span class="step-text">Infomations Professionelles</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Infomations Professionelles</h3>
								</div>
								 <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Profession</legend>
											<input type="text" name="your_profession" id="your_profession" class="form-control" placeholder="UX Designer, Web Devekopper,..." required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Description</legend>
											<textarea rows="10" cols="30" name="your_description" id="your_description" class="form-control" placeholder="Decrivez vous, les projets que vous aves r??alis??..." required></textarea>
										</fieldset>
									</div>
								</div>
							</div>
			            </section>
			            <!-- SECTION 3 -->
			            <h2>
			            	<p class="step-icon"><span>03</span></p>
			            	<span class="step-text">Informations Financi??res</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Informations Financi??res</h3>
								</div>
								 <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Le propri??taire de la carte de cr??dit</legend>
											<input type="text" name="credit_card_owner" id="credit_card_owner" class="form-control" placeholder="Nom Prenom" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Le num??ro de la carte de cr??dit</legend>
											<input type="text" name="credit_card_number" id="credit_card_number" class="form-control" pattern="[0-9]{16}" placeholder="1234 5678 9876 5432" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Date d'expiration</legend>
											<input type="text" class="form-control" id="expiry_date" name="expiry_date" pattern="[0-1][0-9]/[2-3][0-9]" placeholder="MM/AA" required>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>CVC / CVV</legend>
											<input type="text" class="form-control" id="cvc_cvv" name="cvc_cvv" pattern="[0-9]{3}" placeholder="123" required>
										</fieldset>
									</div>
								</div>
							</div>
							<div class="form-row">
							<div class="form-holder container-login100-form-btn d-flex justify-content-center">
								<fieldset>
									<input  type="submit" name="submit" id="submit" class="form-control login100-form-btn" required>
								</fieldset>
							</div>
						</div>
			            </section>
		        	</div>
		        </form>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery.steps.js"></script>
	<script src="js/mainFreelancerRegistration.js"></script><!-- End Registration Form -->

  <!-- ======= Footer ======= -->
  <%@ include file="Footer.jsp" %>
</body>
</html>