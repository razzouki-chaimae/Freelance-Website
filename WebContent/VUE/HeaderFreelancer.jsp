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
				<li><a class="nav-link scrollto active" href="<%=request.getContextPath() %>/OffresServlet">Offres</a></li>
				<li><a class="nav-link scrollto" href="#about">Dashboard</a></li>
				<li><a class="nav-link  scrollto" href="#portfolio">Messages</a></li>
				<!-- <li><a class="nav-link  scrollto" href="#journal">Blog</a></li> -->
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
						<li class="dropdown"><a href="#"><span>Modifier
									mon profil</span> <i class="bi bi-chevron-right"></i></a>
							<ul>
								<li><a href="#">Deep Drop Down 1</a></li>
								<li><a href="#">Deep Drop Down 2</a></li>
								<li><a href="#">Deep Drop Down 3</a></li>
								<li><a href="#">Deep Drop Down 4</a></li>
								<li><a href="#">Deep Drop Down 5</a></li>
							</ul></li>
						<li><a href="#">Drop Down 2</a></li>
						<li><a href="#">Drop Down 3</a></li>
						<li><a href="#">Drop Down 4</a></li>
					</ul></li>
				<li><a class="nav-link scrollto" href="#contact">Contact</a></li>
				<li><a class="nav-link scrollto"
					href="<%= request.getContextPath() %>/LogoutFreelancerServlet">
						<img
						src="data:image/png;base64,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" />
				</a></li>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->

	</div>
</header>