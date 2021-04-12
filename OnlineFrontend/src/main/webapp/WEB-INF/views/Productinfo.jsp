<div class="container">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>

			</ol>


		</div>


	</div>

	<div class="row">

		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>

			<c:if test="${product.quantity == 0}">
				<h6>
					Qty. Available: <span style="color: red">Out of Stock!</span>
				</h6>
			</c:if>

			<c:if test="${product.quantity != 0}">
				<h6>Qty. Available: ${product.quantity}</h6>
			</c:if>


			<hr />

			<c:if test="${product.quantity == 0}">
				<a href="#" class="btn btn-success disabled"> <strike>Add
						to Cart</strike></a>
				</a>
			</c:if>

			<c:if test="${product.quantity != 0}">
				<a href="${contextRoot}/cart" class="btn btn-success ">Add to
					Cart</a>
				</a>
			</c:if>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

		</div>

	</div>


</div>



</div>