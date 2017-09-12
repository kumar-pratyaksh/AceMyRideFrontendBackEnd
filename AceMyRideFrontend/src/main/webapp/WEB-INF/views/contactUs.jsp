<%@include file="header.jsp" %>

<div class="container-fluid details" >
	
		<div class="row text-center">
			<h11 >GET IN TOUCH</h11>
		</div>


		<div class="row">
			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-map-marker"></i>
				<br><br>
			
			<h12 >ADDRESS</h12>	<br><br>
			<p11>Northern Division Office</p11><br><br>

			<p12 >16,DLF Cybercity</p12><br>
			<p12 >Sector 24,Gurugram</p12><br>
			<p12 >Haryana-122002</p12><br><br><br>

			<p11 >Eastern Division Office</p11><br><br>

			<p12 >14,G-Block,Sector 1</p12><br>
			<p12 >Salt Lake City,Kolkata</p12><br>
			<p12 >West Bengal-700073</p12><br><br>
			</div>
			</div>

			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-earphone"></i>
			<br><br>
			<h12 >PHONE</h12>	<br><br>
			<p11 >Northern Division Office</p11><br><br>
			<p12 >+91 124 4831550</p12><br><br><br>

			<p11 >Eastern Division Office</p11><br><br>
			<p12 >+91 033 2657543</p12><br><br><br>

			<p11 >AceMyRide Service Department</p11><br><br>
			<p12 >+91 124 4852206</p12><br><br><br>

			
			</div>
			</div>	

			<div class="col-md-4">
			<br>
			
			<div class="text-center">
				<i class="glyphicon glyphicon-envelope"></i>
				<br><br>
			
			<h12 >EMAIL</h12>	<br><br>
			<p11>Product Enquiry</p11><br><br>
			<p12 >contact.acemyride@gmail.com</p12><br><br><br>

			<p11 >Service Call</p11><br><br>
			<p12 >service@acemyride.com</p12><br><br><br>

			<p11>Employment Opportunities</p11><br><br>
			<p12 >careers@acemyride.com</p12><br><br><br>

			
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

				
					<h13>Message Us</h13>
					<br>
					<p13 >Your questions and comments are important to us. Enter your details and message alongside
																and the our team will get back to you shortly. </p13>
				
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