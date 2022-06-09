<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  $(document).ready(function () {
	    $("#deleteEntreprise").click(function () {

	        //confirm("Press a button!");
	        if (confirm('Vous voulez vraiment supprimer votre compte?')) {
	            // Save it!
	            console.log('Switch to the servlet in : ${pageContext.request.contextPath}/DeleteFreelancer');
	            $.get('${pageContext.request.contextPath}/DeleteEntreprise', function(data) {
	            	if(data=="ok")	location.href = "VUE/index.jsp";
	            });
	        } else {
	        	//location.href = "VUE/index.jsp";
	        }

	    });
	});
  </script>