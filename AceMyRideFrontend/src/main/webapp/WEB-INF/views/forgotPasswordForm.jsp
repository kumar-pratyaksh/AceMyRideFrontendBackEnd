<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<style>



.panel {
  border-radius: 5px;
}

.panel-login {
   border: none;
  -webkit-box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
  -moz-box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
  box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);
  }



.panel-login h2{
  font-size: 20px;
  font-weight: 300;
  margin: 30px;
}

.panel-login .form-group {
  padding: 0 30px;
}


.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
  height: 45px;
  border: 0;
  font-size: 16px;
  -webkit-transition: all 0.1s linear;
  -moz-transition: all 0.1s linear;
  transition: all 0.1s linear;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-bottom: 1px solid #e7e7e7;
  border-radius: 0px;
  padding: 6px 0px;
}
.panel-login input:hover,
.panel-login input:focus {
  outline:none;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  border-color: #ccc;
}
.btn-login {
  background-color: #dad2bc;
  outline: none;
  color: #252323;
  font-size: 14px;
  height: auto;
  font-weight: normal;
  padding: 14px 0;
  text-transform: uppercase;
  border: none;
  border-radius: 0px;
  box-shadow: none;
}
.btn-login:hover,
.btn-login:focus {
  color: #fff;
  background-color: #252323;
}



.login-background{
background-color: #f5f1ed;
}
</style>




  
<div class="main-content login-background">

<div class="container-fluid">
 <div class="row"><label></label></div>
   <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
       
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              <form id="login-form" action="updatePasswordForgot" onsubmit="return checkPassword()" method="post" role="form" style="display: block;">
                 <h2>Reset password</h2>
                  <div class="row">
                  <div class="col-md-6">
                  <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="New Password">
                  </div>
                  </div>
                  <div class="col-md-6">
                  <div class="form-group">
                    <input type="password" name="confirm-password" id="confirmPassword" class="form-control" placeholder="Confirm Password">
                  </div>
                  </div>
                  </div>
                  <label></label>
                  <div class="form-group">
                    <select style="width:100%; height: 35px" name="securityQuestionId">
                        <option value="" disabled selected>Select a security question</option>
                      <c:forEach items="${securityQuestions}" var="question" varStatus="loop">
                        <option  value="${loop.index }">${question}</option>
                      </c:forEach>
      
                    </select>
                  </div>
                  <div class="form-group">
                    <input type="text" name="securityAnswer" id="securityAnswer" class="form-control" placeholder="Answer" value="">
                  </div>
                  
                  <div class="col-sm-6 col-sm-offset-3">     
                        <input type="submit" name="login-submit" id="login-submit" class="form-control btn btn-login" value="Submit">
                  </div>
                  
              </form>
              
            </div>
          </div>
        </div>
        
      </div>
    </div>
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