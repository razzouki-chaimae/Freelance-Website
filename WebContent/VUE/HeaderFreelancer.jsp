<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id="header" class="fixed-top ">
	<div
		class="container d-flex align-items-center justify-content-between">

		<!-- Uncomment below if you prefer to use an text logo -->
		<!-- <a href="#" class="logo"><img src="/freelanceProject/VUE/assetsProfileFreelancer/img/logo.png" alt="" class="img-fluid"></a> -->
		<h1 class="logo">
			<a href="/freelanceProject">Freelancing</a>
		</h1>

		<nav id="navbar" class="navbar">
			<ul>
				<li><a class="nav-link scrollto" href="<%=request.getContextPath() %>/OffresServlet">Offres</a></li>
				<!-- <li><a class="nav-link scrollto" href="#about">Dashboard</a></li>
				<li><a class="nav-link  scrollto" href="#portfolio">Messages</a></li>
				<li><a class="nav-link  scrollto" href="#journal">Blog</a></li> -->
				<li class="dropdown"><a
					href="<%= request.getContextPath() %>/ProfileFreelancer"><span>Profile</span>
						<i class="bi bi-chevron-down"></i></a>
					<ul>
						<li><a
							href="<%= request.getContextPath() %>/ProfileFreelancer">Consulter
								mon profil</a></li>
						<li><a
							href="<%= request.getContextPath() %>/ModificationFreelancerServlet">Modifier
								mon profil</a></li>
						<li><a href="#" id="deleteFreelancer">Supprimer mon
								profil</a></li>
					</ul></li>
				<li><a class="nav-link scrollto"
					href="<%= request.getContextPath() %>/LogoutFreelancerServlet">
						<img
						src="/freelanceProject/VUE/img/logout.png" alt="logout"/>
				</a></li>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->

	</div>
</header>