<%@include file="header.jsp" %>
<script src="${script}/scripts.js"></script>
<link rel="stylesheet" type="text/css" href="${style}/contact.css">

<div class="container-fluid details" >
	
		<div class="row text-center">
			<h1 >GET IN TOUCH</h1>
		</div>


		<div class="row">
			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-map-marker"></i>
				
			<br><br>
			<h2 >ADDRESS</h2><br><br>
			
			<p1>Northern Division Office</p1><br><br>

			<p2 >16,DLF Cybercity</p2><br>
			<p2 >Sector 24,Gurugram</p2><br>
			<p2 >Haryana-122002</p2><br><br><br>

			<p1 >Eastern Division Office</p1><br><br>

			<p2 >14,G-Block,Sector 1</p2><br>
			<p2 >Salt Lake City,Kolkata</p2><br>
			<p2 >West Bengal-700073</p2><br><br>
			</div>
			</div>

			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-earphone"></i>
			<br><br>
			<h2 >PHONE</h2>	<br><br>
			<p1 >Northern Division Office</p1><br><br>
			<p2 >+91 124 4831550</p2><br><br><br>

			<p1 >Eastern Division Office</p1><br><br>
			<p2 >+91 033 2657543</p2><br><br><br>

			<p1 >AceMyRide Service Department</p1><br><br>
			<p2 >+91 124 4852206</p2><br><br><br>

			
			</div>
			</div>	

			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-envelope"></i>
				<br><br>
			
			<h2 >EMAIL</h2>	<br><br>
			<p1>Product Enquiry</p1><br><br>
			<p2 >contact.acemyride@gmail.com</p2><br><br><br>

			<p1 >Service Call</p1><br><br>
			<p2 >service@acemyride.com</p2><br><br><br>

			<p1>Employment Opportunities</p1><br><br>
			<p2 >careers@acemyride.com</p2><br><br><br>

			
			</div>
			</div>	
		</div>
	</div>


	<br>
	<br>
	<br>

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

	<br>

	<div id="map"></div>
	<br>

<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA-AdqGOm--9sc1F4vWc1DKbngkiaod9Sc&callback=initMap">
    </script>
<%@include file="footer.jsp" %>


</body>
</html>