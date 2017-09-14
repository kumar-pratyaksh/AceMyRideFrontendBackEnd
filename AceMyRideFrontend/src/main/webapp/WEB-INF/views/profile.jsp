<%@include file="header.jsp" %>

<div class="container text-center">
	<h3>Deactivate Your Account</h3>
	<button onclick="myFunction()">Deactivate Account</button>
	
	</div> 
	<%@include file="footer.jsp" %>
	<script>
	function myFunction() {
	    var flag = window.confirm("Do you really want to deactivate?");
	    if (flag) 
	    {
	       document.location.href = "deactivate";
	    }
	}
	
</script>
</body>
</html>
