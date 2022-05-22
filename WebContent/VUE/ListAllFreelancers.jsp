<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--fmt == formatting tag -->
<!--functions -->
<!--sql  -->
<!--xml -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>All freelancers : </p>
	<ul>
		<c:forEach var="freelancer" items="${ freelancers }">
            <li><c:out value="${ freelancer.prenom }" /> <c:out value="${ freelancer.nom }" /></li>
        </c:forEach>
	</ul>
</body>
</html>