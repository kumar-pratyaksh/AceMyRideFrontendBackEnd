<%@include file="header.jsp"%>

<link rel="stylesheet" href="${style}/adminPanel.css"></link>

<div class="container-fluid main-content">

	<div class="row">
		<div class="vertical-menu col-sm-2 ">
			<div class="v-menu-header">Admin Panel</div>
			<ul>
			</ul>
		</div>
		<div class="col-sm-10 content">
			<div data-target="categories">
				<div class="content-heading">Manage Categories</div>
				<div>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#addCategory">Add Category</button>
				</div>
				<!--Add category modal-->
				<div class="modal fade" id="addCategory">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Category</h4>
							</div>
							<div class="modal-body">
								<form action="addCategory" method="POST" id="addCategoryForm">
									<div class="form-group">
										<label class="control-label">Category ID</label> <input
											type="text" name="categoryId"
											class="form-control text-capitalize">
									</div>
									<div class="form-group">
										<label class="control-label">Category Name</label> <input
											type="text" name="name" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">Category Description</label>
										<textarea rows="3" class="form-control" name="description"></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--Update category modal-->
				<div class="modal fade" id="updateCategory">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Update Category</h4>
							</div>
							<div class="modal-body">
								<form action="updateCategory" method="POST">
									<input type="hidden" name="id">
									<div class="form-group">
										<label class="control-label">Category ID</label> <input
											type="text" name="categoryId" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Category Name</label> <input
											type="text" name="name" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">Category Description</label>
										<textarea rows="3" class="form-control" name="description"></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success" value="Update">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--Delete Category modal-->
				<div class="modal fade" id="deleteCategory">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Delete Category</h4>
							</div>
							<div class="modal-body">
								<form action="deleteCategory" method="POST">
									<input type="hidden" name="id">
									<div class="form-group">
										<label class="control-label">Category ID</label> <input
											type="text" name="categoryId"
											class="form-control text-capitalize" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Category Name</label> <input
											type="text" name="name" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Category Description</label>
										<textarea rows="3" class="form-control" name="description"
											readonly></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success"
											value="Confirm Delete">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-responsive table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Category Id</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th class="text-center">Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCategories}" var="category" varStatus="i">
							<tr>
								<td data-id="${category.id}"><c:out value="${i.index+1}"></c:out>
								</td>
								<td data-categoryId="${category.categoryId}">${category.categoryId}</td>
								<td data-name="${category.name}">${category.name}</td>
								<td data-description="${category.description}">${category.description}</td>
								<td class="text-center"><span
									class="glyphicon glyphicon-pencil" data-toggle="modal"
									data-target="#updateCategory"></span><span
									class="glyphicon glyphicon-trash" data-toggle="modal"
									data-target="#deleteCategory"></span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div data-target="suppliers">
				<div class="content-heading">Manage Suppliers</div>
				<div>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#addSupplier">Add Supplier</button>
				</div>
				<!--Add supplier modal-->
				<div class="modal fade" id="addSupplier">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Supplier</h4>
							</div>
							<div class="modal-body">
								<form action="addSupplier" method="POST" id="addSupplierForm">
									<div class="form-group">
										<label class="control-label">Supplier ID</label> <input
											type="text" name="supplierId"
											class="form-control text-capitalize">
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Name</label> <input
											type="text" name="name" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Description</label>
										<textarea rows="3" class="form-control" name="description"></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--Update supplier modal-->
				<div class="modal fade" id="updateSupplier">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Update Supplier</h4>
							</div>
							<div class="modal-body">
								<form action="updateSupplier" method="POST">
									<input type="hidden" name="id">
									<div class="form-group">
										<label class="control-label">Supplier ID</label> <input
											type="text" name="supplierId" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Name</label> <input
											type="text" name="name" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Description</label>
										<textarea rows="3" class="form-control" name="description"></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success" value="Update">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--Delete supplier modal-->
				<div class="modal fade" id="deleteSupplier">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Delete Supplier</h4>
							</div>
							<div class="modal-body">
								<form action="deleteSupplier" method="POST">
									<input type="hidden" name="id">
									<div class="form-group">
										<label class="control-label">Supplier ID</label> <input
											type="text" name="supplierId"
											class="form-control text-capitalize" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Name</label> <input
											type="text" name="name" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label class="control-label">Supplier Description</label>
										<textarea rows="3" class="form-control" name="description"
											readonly></textarea>
									</div>
									<div class="form-group text-center">
										<input type="submit" class="btn btn-success"
											value="Confirm Delete">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-responsive table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Supplier Id</th>
							<th>Supplier Name</th>
							<th>Supplier Description</th>
							<th class="text-center">Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listSuppliers}" var="supplier" varStatus="i">
							<tr>
								<td data-id="${supplier.id}"><c:out value="${i.index+1}"></c:out>
								</td>
								<td data-categoryId="${supplier.supplierId}">${supplier.supplierId}</td>
								<td data-name="${supplier.name}">${supplier.name}</td>
								<td data-description="${supplier.description}">${supplier.description}</td>
								<td class="text-center"><span
									class="glyphicon glyphicon-pencil" data-toggle="modal"
									data-target="#updateSupplier"></span><span
									class="glyphicon glyphicon-trash" data-toggle="modal"
									data-target="#deleteSupplier"></span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div data-target="products">
				<div class="content-heading">Manage Products</div>
				
					<div>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#addProduct">Add Product</button>
				</div>
				<!--Add Product modal-->
				<div class="modal fade" id="addProduct">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Product</h4>
							</div>
							<div class="modal-body">
								<form action="addProduct" method="POST" id="addProductForm">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label text-left">Product ID</label> <input
													type="text" name="productId" class="form-control">
											</div>
											<div class="form-group">
												<label class="control-label">Product Brand</label> <input
													type="text" name="brand" class="form-control">
											</div>

											<div class="form-group">
												<label></label> <select style="width: 100%; height: 35px"
													name="belongsToCategoryName">
													<option value="" disabled selected>Select
														Categories</option>
													<c:forEach items="${listCategories }" var="category">
														<option value="${category.name }">${category.name }</option>
													</c:forEach>
												</select>

											</div>
											<div class="form-group">
												<label class="control-label">Product price</label> <input
													type="text" name="price" class="form-control">
											</div>
											<div></div>

										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Product Name</label> <input
													type="text" name="name" class="form-control" />
											</div>
											<div class="form-group">
												<label class="control-label">Product Quantity</label> <input
													type="text" name="inStock" class="form-control" />
											</div>

											<div class="form-group">
												<label></label> <select style="width: 100%; height: 35px"
													name="suppliedBYSupplierName">
													<option value="" disabled selected>Select
														Suppliers</option>
													<c:forEach items="${listSupplier }" var="supplier">
														<option value="${supplier.name }">${supplier.name }</option>
													</c:forEach>

												</select>
											</div>
											<div class="form-group">
												<label for="imagePath">Upload Product Image</label> <input
													type="file" class="form-control-file" id="imagePath"
													aria-describedby="fileHelp"> <small id="fileHelp"
													class="form-text text-muted"></small>
											</div>
										</div>

									</div>
									<div class="row">
										<div class="form-group"
											style="padding-left: 15px; padding-right: 15px">
											<label class="control-label" style="text-align: left;">Product
												Description</label>
											<textarea rows="3" class="form-control"
												name="description"></textarea>
										</div>
										<div class="form-group text-center">
											<input type="submit" class="btn btn-success" value="Add Product" />
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>


				<div class="modal fade" id="updateProduct">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Update Product</h4>
							</div>
							<div class="modal-body">
								<form action="#updateProduct" method="POST"
									id="updateProductForm">
									<div class="row">
										<input type="hidden" name="id">	
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label text-left">Product ID</label> <input
													type="text" name="productId" class="form-control"
													readonly="readonly">
											</div>
											<div class="form-group">
												<label class="control-label">Product Brand</label> <input
													type="text" name="brand" class="form-control">
											</div>

											<div class="form-group">
												<label></label> <select style="width: 100%; height: 35px"
													name="belongsToCategoryName">
													<option value="" disabled selected>Select
														Categories</option>
													<c:forEach items="${listCategories }" var="category">
														<option value="${category.name }">${category.name }</option>
													</c:forEach>
												</select>

											</div>
											<div class="form-group">
												<label class="control-label">Product price</label> <input
													type="text" name="price" class="form-control">
											</div>
											<div></div>

										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Product Name</label> <input
													type="text" name="name" class="form-control" />
											</div>
											<div class="form-group">
												<label class="control-label">Product Quantity</label> <input
													type="text" name="inStock" class="form-control" />
											</div>

											<div class="form-group">
												<label></label> <select style="width: 100%; height: 35px"
													name="suppliedBYSupplierName">
													<option value="" disabled selected>Select
														Suppliers</option>
													<c:forEach items="${listSuppliers }" var="suppliers">
														<option value="${suppliers.name }">${suppliers.name }</option>
													</c:forEach>

												</select>
											</div>											
											<div class="form-group">
												<label for="imagePath">Upload Product Image</label> <input
													type="file" class="form-control-file" id="imagePath"
													aria-describedby="fileHelp"> <small id="fileHelp"
													class="form-text text-muted"></small>
											</div>
										</div>

									</div>
									<div class="row">
										<div class="form-group"
											style="padding-left: 15px; padding-right: 15px">
											<label class="control-label" style="text-align: left;">Product
												Description</label>
											<textarea rows="3" class="form-control"
												name="description"></textarea>
										</div>
										<div class="form-group text-center">
											<input type="submit" class="btn btn-success" value="Update" />&nbsp;
											<input type="submit" class="btn btn-danger" value="Delete" />
										</div>

									</div>
								</form>
							</div>
						</div>
					</div>

				</div>
					<c:forEach items="${listProducts}" var="product">
					<div class="product-card col-sm-8 col-sm-offset-2" data-id="${product.id}">
					  <div class="card-block row">
					  	<div class="col-sm-3">
					  	<img src="${product.imagePath}" class="product-image">
					  	</div>
					  	<div class="col-sm-9">
					    <h4 class="card-title" data-name="${product.name }">${product.name }</h4>
					    <h6 class="card-subtitle mb-2 text-muted" data-productId="${product.productId }">${product.productId }</h6>
					    <p>Brand: <span class="font-weight-bold" data-price="${product.brand }">${product.brand }</span><br>
					    <p>Price: <span class="font-weight-bold" data-price="${product.price }">${product.price }</span> &nbsp; Quantity: <span class="font-weight-bold" data-quantity="${product.inStock }">${product.inStock }</span></p>
					    <p>Category: <span class="font-weight-bold" data-category="${product.belongsToCategoryName}">${product.belongsToCategoryName}</span> &nbsp; Supplier: <span class="font-weight-bold" data-supplier="${product.suppliedBySupplierName }">${product.suppliedBySupplierName }</span></p>
					    <p>Description: <span class="text-muted" data-description="${product.description }">${product.description }</span></p>
					    <span class="edit-product btn btn-success" data-target="#updateProduct" data-toggle="modal">Edit</span>
					    </div>
					  </div>
					
					</div>
					</c:forEach>
					
			</div>
			
		</div>
	</div>
</div>
	<script type="text/javascript">
		var verticalMenuItems = [ {
			'target' : 'categories',
			'value' : 'Manage Categories'
		}, {
			'target' : 'suppliers',
			'value' : 'Manage Suppliers'
		}, {
			'target' : 'products',
			'value' : 'Manage Products'
		} ];
		var defaultVerticalMenuItem = 'categories';
		$('#updateCategory').on(
				'show.bs.modal',
				function(event) {
					var sibs = $(event.relatedTarget).parent().siblings('td');
					$(this).find('input[name=id]').val(
							$(sibs[0]).attr('data-id'));
					$(this).find('input[name=categoryId]').val(
							$(sibs[1]).attr('data-categoryId'));
					$(this).find('input[name=name]').val(
							$(sibs[2]).attr('data-name'));
					$(this).find('textarea[name=description]').val(
							$(sibs[3]).attr('data-description'));
				});

		$('#deleteCategory').on(
				'show.bs.modal',
				function(event) {
					var sibs = $(event.relatedTarget).parent().siblings('td');
					$(this).find('input[name=id]').val(
							$(sibs[0]).attr('data-id'));
					$(this).find('input[name=categoryId]').val(
							$(sibs[1]).attr('data-categoryId'));
					$(this).find('input[name=name]').val(
							$(sibs[2]).attr('data-name'));
					$(this).find('textarea[name=description]').val(
							$(sibs[3]).attr('data-description'));
				});

		$('#updateSupplier').on(
				'show.bs.modal',
				function(event) {
					var sibs = $(event.relatedTarget).parent().siblings('td');
					$(this).find('input[name=id]').val(
							$(sibs[0]).attr('data-id'));
					$(this).find('input[name=supplierId]').val(
							$(sibs[1]).attr('data-supplierId'));
					$(this).find('input[name=name]').val(
							$(sibs[2]).attr('data-name'));
					$(this).find('textarea[name=description]').val(
							$(sibs[3]).attr('data-description'));
				});

		$('#deleteSupplier').on(
				'show.bs.modal',
				function(event) {
					var sibs = $(event.relatedTarget).parent().siblings('td');
					$(this).find('input[name=id]').val(
							$(sibs[0]).attr('data-id'));
					$(this).find('input[name=supplierId]').val(
							$(sibs[1]).attr('data-supplierId'));
					$(this).find('input[name=name]').val(
							$(sibs[2]).attr('data-name'));
					$(this).find('textarea[name=description]').val(
							$(sibs[3]).attr('data-description'));
				});
		$('#updateProduct').on('show.bs.modal',function(event){
			
		})
		var categoryIdList = new Array();
		var supplierIdList = new Array();
		var productIdList = new Array();

		<c:forEach items="${listSuppliers}" var="supplier">
		supplierIdList.push("${supplier.supplierId}")
		</c:forEach>
		<c:forEach items="${listCategories}" var="category">
		categoryIdList.push("${category.categoryId}")
		</c:forEach>
		<c:forEach items="${listProducts}" var="category">
		categoryIdList.push("${products.productId}")
		</c:forEach>

		$('#addCategoryForm').submit(function(event) {
			var catId = $(this).find('[name=categoryId]').val();
			if ($.inArray(catId, categoryIdList) > 0) {
				event.preventDefault();
				alert('Category id already saved');
			}
		});
		$('#addSupplierForm').submit(function(event) {
			var supId = $(this).find('[name=supplierId]').val();
			if ($.inArray(supId, supplierIdList) > 0) {
				event.preventDefault();
				alert('Supplier id already saved');
			}
		});
	</script>
	<script type="text/javascript" src="${script}/scripts.js"></script>

	<%@include file="footer.jsp"%>
	</body>
	</html>