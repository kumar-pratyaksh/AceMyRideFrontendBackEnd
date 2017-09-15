<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

	<div class="container-fluid">
	
		<c:if test="${not empty result }">
		<c:if test="${result == 'failure'}">
			<div class="alert alert-danger" role="alert">
				${message}
			</div>
		</c:if>
	</c:if>
	
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<form action="updatePasswordForgot" method="post" onsubmit="return checkPassword()">
					<div><label>Password</label>
    <input id="password" type="password" name="password" class="form-control" placeholder="Enter password" required></div><br>
    <div><label>Confirm Password</label>
    <input id="confirmPassword" type="password" class="form-control" placeholder="Re-enter password" required></div><br>
    				<div><label>Select your security question</label>
    
    <select style="width:100%; height: 32px" name="securityQuestionId" required>
		<c:forEach items="${securityQuestions}" var="question" varStatus="loop">
			<option  value="${loop.index }">${question}</option>
		</c:forEach>
			
	</select>
    </div><br>
    <div><label>Provide Answer</label>
    <input id="securityAnswer" type="text" name="securityAnswer" class="form-control" placeholder="Enter your answer" required></div><br>
    
    <br>
    <button type="submit" class="btn btn-primary" style="width: 100%">Update Password</button>
				</form>
			</div>
		</div>
	
	</div>
	<script>
		function checkPassword(){
			var password = document.getElementById("password").value;
			var confirmPassword = document.getElementById("confirmPassword").value;
			var flag=true;
			var passReg=/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
			
			if(!(password.match(passReg))){
				alert("Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters");
				flag=false;
			}

			if(password!=confirmPassword){
				alert("Re-entered password should be same as password");
				flag=false;
			}
			return flag;
		}
	</script>

<%@include file="footer.jsp" %>
</body>
</html>