<%@include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="${style}/category.css">
<div class="container-fluid main-content">
	<div class="row">
		<nav class="product-filter">
			<h1>Cateory Name</h1>
			<div class="sort">
			    <div class="collection-sort">
			      <label>Filter by:</label>
			      <select>
			        <option value="/">All Jackets</option>
			      </select>
			    </div>

			    <div class="collection-sort">
			      <label>Sort by:</label>
			      <select>
			        <option value="/">Featured</option>
			      </select>
			    </div>
			  </div>
		</nav>
		<section class="products">

		  <!-- It's likely you'll need to link the card somewhere. You could add a button in the info, link the titles, or even wrap the entire card in an <a href="..."> -->

		  <div class="product-card-small">
		    <div class="product-image">
		      <img src="${image}/Raju.jpg">
		    </div>
		    <div class="product-info">
		      <p>Spare Part</p>
		      <p>Minda</p>
		      <p>250.0 Rs.</p>

		    </div>
		    <div class="buttons">
		    	<span class="add-to-cart">Add to Cart</span>
		    </div>
		  </div>

		  <!-- more products -->

		</section>
	</div>
	
</div>
