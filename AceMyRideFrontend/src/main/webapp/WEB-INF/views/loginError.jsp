

<%@include file="header.jsp" %>

<style>

.already{
	background: linear-gradient(to right,#fff,rgba(255,255,255,0),#fff);
    background-image: linear-gradient(to right, rgb(255, 255, 255), rgba(255, 255, 255, 0), rgb(255, 255, 255));
    background-position-x: initial;
    background-position-y: initial;
    background-size: initial;
    background-repeat-x: initial;
    background-repeat-y: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: transparent;
}


	.border{
border-style:solid;
border-radius:10px;
border-width:1.5px;
padding: 15px;
}
</style>

<div class="text-center">
   <a href="#"><img src="${image}/logo.png"  style="height: 70px;width:10%;"></a>
   </div>
   <br>





<div class="container">
<div class="row">
   <div class="col-sm-4 col-md-offset-1" >

   
   		<div class="border">

    <h2>Create Account</h2><br>
    
    <form class="form-horizontal" action="" onsubmit="return ValidationSignup()">
    <div><label>Username</label>
    <input id="username" type="text" name="username" class="form-control" placeholder="Enter username"></div><br>
    <div><label>Password</label>
    <input id="password" type="text" name="password" class="form-control" placeholder="Enter password"></div><br>
    <div><label>Confirm Password</label>
    <input id="confirmPassword" type="password" name="confirmPassword" class="form-control" placeholder="Re-enter password"></div><br>
    <div><label>Email</label>
    <input id="email" type="email" name="email" placeholder="Enter email" class="form-control"></div><br>
    <div><label>Contact</label>
    <input id="contact" type="text" name="contact" placeholder="Enter contact number" class="form-control"></div><br>

    <div><label class="control-label" for="date">Date Of Birth</label>
        <input class="form-control" id="date" name="dob" placeholder="DD/MM/YYYY" type="text"/></div><br>
    
    <div><label>Select your security question</label>
    
    <select style="width:100%; height: 32px">
			<option name="securityQuestion" value="motherName">What is your mother's name?</option>
			<option name="securityQuestion" value="timepass">What do you do when idle?</option>
			<option name="securityQuestion" value="friend">What was the name of your first friend?</option>
			<option name="securityQuestion" value="birthplace">What was the name of your birthplace?</option>
			
	</select>
    </div><br>
    <div><label>Provide Answer</label>
    <input id="securityAnswer" type="text" name="securityAnswer" class="form-control" placeholder="Enter your answer"></div><br>
    
    <br>
    <button type="submit" class="btn btn-primary" style="width: 100%">Sign Up</button>
    
    
    </form>
    <br>
    

    <div class="already">
    Already have an account?<a href="#">Sign In</a>
    </div>
    
    </div></div>



     <div class="col-sm-4 col-md-offset-2" >

   
   		<div class="border">

    <h2>Login</h2><br>
    
    <h style="color:red">Invalid Credentials</h>
    <form class="form-horizontal" action="loginSubmit" onsubmit="return ValidationLogin()" method="post">
    <div><label>Email</label>
    <input id="email1" type="email" name="email" class="form-control" placeholder="Enter email"></div><br>
    <div><label>Password</label>
    <input id="password1" type="text" name="password" class="form-control" placeholder="Enter password"></div><br>
    
    <button type="submit" class="btn btn-primary" style="width: 100%">Login</button>
    
    
    </form>
    <br>
    <br>

    <div class="already">Forgot Password?
    <a href="#">Click here</a>
    </div>
    
    </div></div>






</div></div>

<br>

<script>


	$(document).ready(function(){
      var date_input=$('input[name="dob"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })


	function ValidationSignup()
	{
		var name = document.getElementById("username").value;
		var email = document.getElementById("email").value;
		var contact = document.getElementById("contact").value;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		var sec = document.getElementById("securityAnswer").value;

		var flag=true;
		var passReg=/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
		var emailReg=/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
		var conReg=/^[0-9]*$/;

		

		if(name.length<5)
		{
			alert("Name must contain atleast 5 characters");
			flag=false;
		}

		if(!(password.match(passReg))){
			alert("Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters");
			flag=false;
		}

		if(password!=confirmPassword){
			alert("Re-entered password should be same as password");
			flag=false;
		}

		if(!(email.match(emailReg))){
			alert("Please enter email in proper format. For example: username@gmail.com");
			flag=false;
		}

		if(!(contact.match(conReg))){
			alert("Contact must contain digits only");
			flag=false;
		}

		if(contact.length==0){
			alert("Contact can't be empty");
			flag=false;
		}
		
		if(sec.length==0){
			alert("Please provide answer to your security question");
			flag=false;
		}

		

		return flag;



	}




	function ValidationLogin()
	{
		var email = document.getElementById("email1").value;
		var password = document.getElementById("password1").value;
		var flag=true;

		if(email.length==0){
			alert("Email can't be empty");
			flag=false;
		}

		if(password.length==0){
			alert("Password can't be empty");
			flag=false;
		}

		return flag;
	}

</script>


<%@include file="footer.jsp" %>


</body>
</html>