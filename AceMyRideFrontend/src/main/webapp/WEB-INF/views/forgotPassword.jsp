<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
	<div class="container-fluid">
	
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<form action="forgotPasswordUser" method="post">
					<div><label>Email</label>
    <input id="email" type="email" name="email" placeholder="Enter email" class="form-control"></div>
    				<div class="text-center">
    					<input type="submit" class="btn btn-success">
    				</div>
				</form>
			</div>
		</div>
	
	</div>

<%@include file="footer.jsp" %>
</body>
</html>