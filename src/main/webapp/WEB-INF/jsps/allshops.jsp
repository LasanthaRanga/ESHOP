<%@page import="com.eshop.entitiy.Product"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="com.eshop.entitiy.Shophasproduct"%>
<%@page import="com.eshop.entitiy.User"%>
<%@page import="com.eshop.entitiy.Shop"%>
<%@page import="java.util.Set"%>
<%@page import="com.eshop.entitiy.Shop"%>
<%@page import="java.util.List"%>
<%@ include file="template/head.jsp"%>





<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div
			class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
			<div class="col-first">
				<h1>All Shops</h1>
				<nav class="d-flex align-items-center">
					<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
					<a href="category.html">Shops</a>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- End Banner Area -->

<!--================Blog Categorie Area =================-->
<section class="blog_categorie_area">
	<div class="container">
		<div class="row">

			<c:forEach items="${shops}" var="Shop">
			
			<div class="col-lg-4">
				<div class="categories_post">
					<img src="${Shop.getUser().userPic}" alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="/itemsinshop/${Shop.idShop}">
								<h5>${Shop.shopName}</h5>
							</a>
							<div class="border_line"></div>
							<p>${Shop.getUser().userName}</p>
						</div>
					</div>
				</div>
			</div>			
			</c:forEach>




			<div class="col-lg-4">
				<div class="categories_post">
					<img src="shop/img/blog/cat-post/cat-post-3.jpg" alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="blog-details.html">
								<h5>Social Life</h5>
							</a>
							<div class="border_line"></div>
							<p>Enjoy your social life together</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="categories_post">
					<img src="shop/img/blog/cat-post/cat-post-2.jpg" alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="blog-details.html">
								<h5>Politics</h5>
							</a>
							<div class="border_line"></div>
							<p>Be a part of politics</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="categories_post">
					<img src="shop/img/blog/cat-post/cat-post-1.jpg" alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="blog-details.html">
								<h5>Food</h5>
							</a>
							<div class="border_line"></div>
							<p>Let the food be finished</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Blog Categorie Area =================-->




<%@ include file="template/homefooter.jsp"%>
<%@ include file="template/homejs.jsp"%>


</body>

</html>