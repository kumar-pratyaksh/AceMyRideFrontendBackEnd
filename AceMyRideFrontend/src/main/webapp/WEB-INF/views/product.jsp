<%@include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="${style}/product.css">
<div class="container main-content">
	<div class="row product">
		<div class="col-sm-6">
			<img src="download?fileName=${product.imagePath}" class="img-responsive img-rounded">
		</div>
		<div class="col-sm-6">
			<div class="row">
				<div class="col-sm-12">
					<h1>${product.brand} ${product.name}</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<span class="label label-primary">${product.belongsToCategoryName}</span>
					<span class="text-muted">${product.productId}</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<h2>&#8377; ${product.price}</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 description">
					<p>${product.description}</p>
				</div>
			</div>
			<div class="row cart-row">
				<div class="col-sm-12 text-center">
					<form action="addToCart" class="form-inline" method="POST">
						<input type="hidden" name="productId" value="${product.id}">
						<div class="form-group">
							<label class="control-label">Quantity:</label>
							<input type="number" name="quantity" class="form-control form-control-lg" max="${product.inStock}" min="1" value="1">
						</div>
						<div class="form-group">
							<input type="submit" value="Add to cart" class="btn btn-success btn-lg">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>