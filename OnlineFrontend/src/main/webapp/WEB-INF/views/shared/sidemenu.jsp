
<div class="col-lg-3">

	<h1 class="my-4">Shop Name</h1>
	<div class="list-group">

		<c:forEach items="${categorylist}" var="category">

			<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name} </a>
		</c:forEach>

	</div>

</div>
