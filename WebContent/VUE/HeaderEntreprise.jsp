<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center">
	<div
		class="container d-flex align-items-center justify-content-between">

		<div class="logo">
			<h1>
				<a href="/freelanceProject" id="cible">Freelancing</a>
			</h1>
		</div>

		<nav id="navbar" class="navbar">
			<ul id="navbar-entreprise">
				<li class="dropdown"><a
					href="<%=request.getContextPath()%>/ProfileEntrepriseServlet"><span>Profile</span>
						<i class="bi bi-chevron-down"></i></a>
					<ul>
						<li><a href="<%=request.getContextPath()%>/ProfileEntrepriseServlet">Consulter
								mon profil</a></li>
						<li><a
							href="<%=request.getContextPath()%>/ModificationEntrepriseServlet">Modifier
								mon profil</a></li>
						<li><a href="#" id="deleteEntreprise">Supprimer mon
								profil</a></li>
					</ul></li>
				<li><a class="getstarted scrollto"
					href="<%=request.getContextPath()%>/AddOffreServlet">Annoncer un offre</a></li>
				<li><a class="nav-link scrollto"
					href="<%=request.getContextPath()%>/LogoutFreelancerServlet"> <img
						src="/freelanceProject/VUE/img/logout.png" alt="logout"/>
				</a></li>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->

	</div>
</header>
<!-- End Header -->