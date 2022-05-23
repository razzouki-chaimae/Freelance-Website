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
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="Header.jsp" %>

  <!-- ======= Registration Form ======= -->
  <div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
		        <form class="form-register" action="../RegisterEntrepriseServlet" method="post">
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
											<legend>Nom de l'entreprise</legend>
											<input type="text" class="form-control" id="company-name" name="company-name" placeholder="Company name..." required>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>Numéro de téléphone</legend>
											<input type="text" class="form-control" id="phone-number" name="phone-number" placeholder="+2126 77 88 99 00" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Domaine de l'entreprise</legend>
											<input type="text" name="company_domain" id="company_domain" class="form-control"  placeholder="Marketing digital, IT,..." required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Adresse Physique de l'entreprise</legend>
											<input type="text" name="company_physical_address" id="company_email" class="form-control"  placeholder="NR 00, RUE XXXX Quartier YYYY , Ville, Pays" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Email de l'entreprise</legend>
											<input type="text" name="company_email" id="company_email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Mot de passe</legend>
											<input type="password" name="company_password" id="company_email" class="form-control"  placeholder="........" required>
										</fieldset>
									</div>
								</div>
							</div>
			            </section>
			            <!-- SECTION 3 -->
			            <h2>
			            	<p class="step-icon"><span>02</span></p>
			            	<span class="step-text">Informations Financières</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Informations Financières</h3>
								</div>
								 <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Le propriétaire de la carte de crédit</legend>
											<input type="text" name="credit_card_owner" id="credit_card_owner" class="form-control" placeholder="Nom Prenom" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Le numéro de la carte de crédit</legend>
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
			            </section>
		        	</div>
		        	<input type="submit" name="submit" id="submit" class="form-control" required>
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