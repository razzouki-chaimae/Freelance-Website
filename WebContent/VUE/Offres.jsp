<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
</head>
<body>
<!-- ======= Header ======= -->
  <%@ include file="Header.jsp" %>
  

<main id="main">

<!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container">

        <div class="section-title" data-aos="fade-up">
          <h2>Services</h2>
          <p>Voici les services les plus fréquemment demandés dans notre plateforme</p>
        </div>

        <div class="row">
        <c:forEach var="offre" items="${requestScope.offres}">
          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
              <div class="icon"><i class="bi bi-phone"></i></div>
              <h4 class="title"><a href=""><c:out value="${ offre.titre }" /></a></h4>
              <p class="description"><c:out value="${ offre.description }" /></p>
              <p class="description"><c:out value="${ offre.budget }" /> DH</p>
              <div class="social">
                  <a href="Publier.jsp"><i class="bi bi-messenger"></i></a>
                  <a href="hna.jsp"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
               </div>
            </div>
          </div>
		</c:forEach>
        </div>

      </div>
    </section><!-- End Services Section -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services" >
      <div class="container">

        <div class="section-title aos-init aos-animate" data-aos="fade-up">
          <h2>Services</h2>
          <p>Magnam dolores commodi suscipit eius consequatur ex aliquid fug</p>
        </div>
        
        <div class="row">
         <c:forEach var="offre" items="${requestScope.offres}">
          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
              <div class="icon"><i class="bi bi-phone"></i></div>
              <h4 class="title"><a href=""><c:out value="${ offre.titre }" /></a></h4>
              <p class="description"><c:out value="${ offre.description }" /></p>
              <div class="social">
                  <a href="Publier.jsp"><i class="bi bi-messenger"></i></a>
                  <a href="hna.jsp"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
               </div>
            </div>
          </div>
		</c:forEach>
        </div>

 <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box aos-init aos-animate" data-aos="fade-up" data-aos-delay="400">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4 class="title"><a href="">digital marketing</a></h4>
              <p class="description">By definition digital marketing (aka online marketing) promotes a client’s
               brand, products and services via the internet or other digital channels. A digital marketing campaign 
              is typically delivered via an electronic device, such as computer, tablet, phone or others</p>
              <div class="social">
                  <a href="https://mail.google.com/mail/u/0/#inbox?compose=new"><i class="bi bi-messenger"></i></a>
                  <a href="https://www.facebook.com/messages/t/100049960719067"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
                </div>
              
              
            </div>
          </div>
           <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box aos-init aos-animate" data-aos="fade-up" data-aos-delay="400">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4 class="title"><a href="">digital marketing</a></h4>
              <p class="description">By definition digital marketing (aka online marketing) promotes a client’s
               brand, products and services via the internet or other digital channels. A digital marketing campaign 
              is typically delivered via an electronic device, such as computer, tablet, phone or others</p>
              <div class="social">
                  <a href="https://mail.google.com/mail/u/0/#inbox?compose=new"><i class="bi bi-messenger"></i></a>
                  <a href="https://www.facebook.com/messages/t/100049960719067"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
                </div>
              
              
            </div>
          </div>
           <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box aos-init aos-animate" data-aos="fade-up" data-aos-delay="400">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4 class="title"><a href="">digital marketing</a></h4>
              <p class="description">By definition digital marketing (aka online marketing) promotes a client’s
               brand, products and services via the internet or other digital channels. A digital marketing campaign 
              is typically delivered via an electronic device, such as computer, tablet, phone or others</p>
              <div class="social">
                  <a href="https://mail.google.com/mail/u/0/#inbox?compose=new"><i class="bi bi-messenger"></i></a>
                  <a href="https://www.facebook.com/messages/t/100049960719067"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
                </div>
              
              
            </div>
          </div>
           <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box aos-init aos-animate" data-aos="fade-up" data-aos-delay="400">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4 class="title"><a href="">digital marketing</a></h4>
              <p class="description">By definition digital marketing (aka online marketing) promotes a client’s
               brand, products and services via the internet or other digital channels. A digital marketing campaign 
              is typically delivered via an electronic device, such as computer, tablet, phone or others</p>
              <div class="social">
                  <a href="https://mail.google.com/mail/u/0/#inbox?compose=new"><i class="bi bi-messenger"></i></a>
                  <a href="https://www.facebook.com/messages/t/100049960719067"><i class="bi bi-facebook"></i></a>
                  <a href=""><i class="bi bi-instagram"></i></a>
                  <a href=""><i class="bi bi-linkedin"></i></a>
                </div>
              
              
            </div>
          </div>
          
        </div>

      </div>
    </section><!-- End Services Section -->


  </main>

<a href="personnaliser.jsp" class="back-to-top d-flex align-items-center justify-content-center active"><i class="bi bi-arrow-up-short"></i></a>

<script src="<%=request.getContextPath() %>/template/js/main.js"></script>
  
  <!-- ======= Footer ======= -->
  <%@ include file="Footer.jsp" %>
</body>
</html>