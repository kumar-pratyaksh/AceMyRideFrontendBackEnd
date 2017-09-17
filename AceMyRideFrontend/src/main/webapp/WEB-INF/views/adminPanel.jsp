<%@include file="header.jsp" %>


<style type="text/css">
.glyphicon{
	font-size: 14px;
	cursor: pointer;
}
.glyphicon-ok{
	color: #5cb85c;
	margin-top: 8px;
}
.glyphicon-trash, .glyphicon-remove{
	color: #d43f3a;
}
.glyphicon-pencil{
	color: #337ab7;
}
.edit, .submit{
	padding-right:10px;
}
.form{
	display:none;
}
.form-control{
	width: 200px;
}
.menu-item.active {
	background-color: #D6D0DB;
}
.border-right {
	border-right-style: solid;
	border-right-width: 1px;
	border-right-color: grey;
}
.fa-user-circle {
	color: #6F06B8;
}
.fa-unlock {
	color: #8EBD10;
}
.fa-history {
	color: #76766D;
}
.fa-map-marker {
	color: #B12515;
}
.fa-credit-card-alt {
	color: #EBA219;
}
.fa {
	size: 20px;
}
.general {
	font-size: 20px;
	border-bottom-style: solid;
	border-bottom-width: 1px;
	border-bottom-color: grey;
}
.general-without-border {
	font-size: 20px;
}
.contents {
	padding-right: 50px;
}
.content-head {
	font-size: 22px;
	color: black;
	background-color: #C2D8D6;
	border-bottom-style: solid;
	border-bottom-width: 0.75px;
	border-bottom-color: #5E6362;
}
.view {
	border-bottom-style: solid;
	border-bottom-width: 0.5px;
	border-bottom-color: #BBC2C1;
}
.update {
	display:none;
	background-color: white;
	border-bottom-style: solid;
	border-bottom-width: 0.5px;
	border-bottom-color: #BBC2C1;
}
.parameter {
	padding-top: 16px;
	width: 200px;
	font-size: 15px;
	color: #434645;
}
.paramvalue {
	padding-top: 15px;
	width: 200px;
	font-size: 15px;
	color: #6C6F6E;
}
.new-parameter {
	padding-top: 14px;
	padding-bottom: 15px;
	width: 200px;
	font-size: 15px;
	color: #434645;
}
.new-paramvalue {
	padding-top: 13px;
	width: 200px;
	font-size: 15px;
	color: #6C6F6E;
}
.new-edit-link {
	padding-top: 10px;
}
.fa-pencil {
	font-size: 15px;
	color: #094F8C;
}
.fa-times {
	font-size: 15px;
	color: #094F8C;
}
.passForm {
	padding-left: 30px;
	background-color: white;
	border-bottom-style: solid;
	border-bottom-width: 0.5px;
	border-bottom-color: #BBC2C1;
}

</style>

<div class="container-fluid">

	<div class="row">

		<div class="col-md-3">
			<div class="border-right">

				<div class="general menu-item active" data-target="categories">
					<i class="fa fa-user-circle" aria-hidden="true"></i>Manage Categories
				</div>
				<div class="general menu-item" data-target="suppliers">
					<i class="fa fa-unlock" aria-hidden="true"></i>Manage Suppliers
				</div>
				<div class="general menu-item" data-target="orders">
					<i class="fa fa-history" aria-hidden="true"></i>Manage Products
				</div>

			</div>
		</div>


		<div class="col-md-9 contents">



			<div class="content-item active" data-target="categories">
				<div class="row content-head">Manage Categories</div>
				<button class="btn btn-success" id="add-category-btn">Add new category</button><br>
				<div class="table-responsive">
					<table class="table table-hover table-striped">
						<thead class="thead-inverse">
							<tr>
								<th>#</th>
								<th>Category Id</th>
								<th>Category Name</th>
								<th>Category Description</th>
								<th class="text-center">Operation</th>
							</tr>
						</thead>
						<tbody>
							<tr class="category-form">
								<form method="post" action="addCategory" data-form="category">
									<td></td>
									<td>
										<input type="text" name="categoryId" id="categoryId" class="form-control" placeholder="Enter descriptive ID" required>
									</td>
									<td>
										<input type="text" name="name" id="categoryName" class="form-control" placeholder="Enter category name" required>
									</td>
									<td>
										<textarea name="description" id="categoryDescription" class="form-control" placeholder="Enter description" required></textarea>
									</td>
									<td class="text-center">
										<span class="glyphicon glyphicon-ok submit"></span><span class="glyphicon glyphicon-remove cancel-form"></span>
									</td>
								</form>
							</tr>
							<c:forEach items="${listCategories}" var="category" varStatus="i">
							<tr>
								<form method="post" action="updateCategory" data-form="category">
									<td>${i}<input type="hidden" name="id"></td>
									<td>PART1<input type="hidden" name="categoryId" class="form-control" value="$category.categoryId}"></td>
									<td><span class="text">PART1</span><span class="form"><input type="text" name="name" class="form-control" value="${category.name}" required></span></td>
									<td><span class="text">PART1</span><span class="form"><textarea name="description" class="form-control" value="${category.discription }" required></textarea></span></td>
								
								<td class="text-center operation">
									<div class="text">
										<span class="glyphicon glyphicon-pencil edit"></span></span><span class="glyphicon glyphicon-trash delete"></span>
									</div>
									<div class="form">
										<span style="padding-right: 10px" class="glyphicon glyphicon-ok submit"></span><span class="glyphicon glyphicon-remove cancel"></span>
									</div>
								</td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


			<div class="content-item" data-target="suppliers">
				<div class="row content-head">Manage Suppliers</div>
				<button class="btn btn-success" id="add-supplier-btn">Add new supplier</button><br>
				<div class="table-responsive">
					<table class="table table-hover table-striped">
						<thead class="thead-inverse">
							<tr>
								<th>#</th>
								<th>Category Id</th>
								<th>Category Name</th>
								<th>Category Description</th>
								<th class="text-center">Operation</th>
							</tr>
						</thead>
						<tbody>
							<tr class="supplier-form">
								<form method="post" action="addSupplier" data-form="supplier">
									<td></td>
									<td>
										<input type="text" name="supplierId" id="supplierId" class="form-control" placeholder="Enter descriptive ID" required>
									</td>
									<td>
										<input type="text" name="name" id="supplierName" class="form-control" placeholder="Enter supplier name" required>
									</td>
									<td>
										<textarea name="description" id="supplierDescription" class="form-control" placeholder="Enter description" required></textarea>
									</td>
									<td class="text-center">
										<span class="glyphicon glyphicon-ok submit"></span><span class="glyphicon glyphicon-remove cancel-form"></span>
									</td>
								</form>
							</tr>
							<c:forEach items="${listSupplier}" var="supplier" varStatus="i">
							<tr>
								<form method="post" action="updateSupplier" data-form="supplier">
									<td>${i}<input type="hidden" name="id" value="${supplier.id}"></td>
									<td>PART1<input type="hidden" name="supplierId" class="form-control" value="${supplier.categoryId}"></td>
									<td><span class="text">PART1</span><span class="form"><input type="text" name="name" class="form-control" value="${supplier.name}" required></span></td>
									<td><span class="text">PART1</span><span class="form"><textarea name="description" class="form-control" value="${supplier.discription }" required></textarea></span></td>
								
								<td class="text-center operation">
									<div class="text">
										<span class="glyphicon glyphicon-pencil edit"></span></span><span class="glyphicon glyphicon-trash delete"></span>
									</div>
									<div class="form">
										<span style="padding-right: 10px" class="glyphicon glyphicon-ok submit"></span><span class="glyphicon glyphicon-remove cancel"></span>
									</div>
								</td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>



	</div>
</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('.category-form').hide();
	});
$('#add-category-btn').click(function(){
	$('.category-form').show('fast');
});
$('.edit').click(function(event) {
	var target=event.target;
	var row=$(target).parents('tr')[0];
	$(row).find('.text').hide();
	$(row).find('.form').show();
});
$('.submit').click(function(event) {
	var target=event.target;
	var form=$(target).parents('form')[0];
	$(form).submit();

});
$('.delete').click(function(event) {
	var target=event.target;
	var form=$(target).parents('form')[0];
	var formTarget=$(form).attr('data-form');
	$(form).attr('action', 'delete'+formTarget);
	$(form).submit();
});
$('.cancel').click(function(event) {
	var target=event.target;
	var row=$(target).parents('tr')[0];
	$(row).find('.text').show();
	$(row).find('.form').hide();
});
$('.cancel-form').click(function(event) {
	$('.category-form').hide('fast');
});
$('[data-toggle="tooltip"]').tooltip();

$('.content-item').hide();
$('.content-item.active').show();

$('.menu-item').click(
	function(event) {
	var target = $(event.target)[0];
	var openMenu = $('.menu-item.active');
	var menuToOpen = $(target);
	$(openMenu).removeClass('active');
	$(menuToOpen).addClass('active');
	var divToOpenName = $(target).attr(
		'data-target');
	var openDiv = $('.content-item.active').toggle(
		'fast');
	$(openDiv).removeClass('active');
	var divToOpen = $(
	'.content-item[data-target='
	+ divToOpenName + ']').toggle(
		'fast');
	divToOpen.addClass('active');
});
</script>

<%@include file="footer.jsp" %>
</body>
</html>