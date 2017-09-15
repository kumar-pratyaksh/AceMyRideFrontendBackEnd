<%@include file="header.jsp" %>

<style type="text/css">
	.home-wrapper{
		background-image: url('${image}/oops.jpg');
  		background-attachment: fixed;
  		background-size: cover;
  		height: 100vh;
  		top: 30px;
	}
</style>

	<div class="home-wrapper">
		
	</div>
	<div class="container-fluid">
	<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-4">

				
					<h3>Message Us</h3>
					<br>
					<p3 >Your questions and comments are important to us. Enter your details and message alongside
																and the our team will get back to you shortly. </p3>
				
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-5">

					<form class="form-horizontal" action="saveFeedback" method="post">
    						<div><label>Name</label>
   									 <input type="text" name="name" class="form-control" placeholder="Name" required="true"></div>
    						<div><label><br><br>Email</label>
    								<input type="email" name="email" class="form-control" placeholder="Enter your email" required="true"></div>

    						<div><label><br><br>Comments</label>
   									 <textarea class="form-control" placeholder="Leave your comments here......." rows="3" name="comment"></textarea></div><br>
        
    
    							<button type="submit" class="btn btn-primary btn-lg saving" >Submit</button><br>
    
    
    				</form>
				</div>

		</div>
	</div>

<%@include file="footer.jsp" %>
</body>
</html>