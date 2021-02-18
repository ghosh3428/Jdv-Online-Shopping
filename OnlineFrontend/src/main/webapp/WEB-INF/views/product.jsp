<div class="container">

	<div class="row">

		<%@include file="./shared/sidemenu.jsp"%>




		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userclickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userclickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>


			<div class="col-sm-12">


				<table id="productTable"
					class="table table-condensed table-striped table-hover">

					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>Product Name</th>
							<th>Brand Name</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th></th>
						</tr>
					</thead>
					

				</table>
			</div>



		</div>



	</div>