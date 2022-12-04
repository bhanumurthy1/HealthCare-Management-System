
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize  text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true"> Login</i>
			</li>
		</ol>
	</nav>
</div>
<hr class=" text-indigo-800">
<br>
<div class="container">

	<div class="accordion accordion-flush" id="accordionFlushExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingOne">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
					aria-expanded="false" aria-controls="flush-collapseOne">
					<b>By Card</b>
				</button>
			</h2>
			<div id="flush-collapseOne" class="accordion-collapse collapse visible"
				aria-labelledby="flush-headingOne"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body">
					<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
						<h5 class="card-header p-3 "
							style="background-color: #262673; color: white; font-style: oblique;">PAYMENT</h5>
				<div class="card-body bg-indigo-100">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/userOrder"
								modelAttribute="form">
								<div class="row">
								<div class="col-md-6">

									<label for="inputEmail4" class="form-label">Card No<font color="red">*</font></label> <input
										type="text" name="cardNo" placeholder="Enter Card No"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>

								<div class="col-md-6">
									<label for="inputEmail4" class="form-label">Name<font color="red">*</font></label> <input
										type="text" name="name" placeholder="Enter Card Holder Name"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>
								</div>
								<div class="row">
								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Month<font color="red">*</font></label> <input
										type="text" name="month" placeholder="Enter Month"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>

								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Year<font color="red">*</font></label> <input
										type="text" name="year" placeholder="Enter Year"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>

								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">CVV<font color="red">*</font></label> <input
										type="text" name="cvv" placeholder="Enter CVV"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>
							</div>
								<br>

								<div class="col-12">
									<input type="submit" name="operation" value="PlaceOrder"
										class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold" />
								</div>
							</sf:form>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>



	<div class="accordion accordion-flush" id="accordionFlushExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingTwo">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
					aria-expanded="false" aria-controls="flush-collapseTwo">
					<b>By Check</b>
				</button>
			</h2>
			<div id="flush-collapseTwo" class="accordion-collapse collapse visible"
				aria-labelledby="flush-headingTwo"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body">
					
					<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
						<h5 class="card-header p-3 "
							style="background-color: #262673; color: white; font-style: oblique;">PAYMENT</h5>
				<div class="card-body bg-indigo-100">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/userOrder"
								modelAttribute="form">



								<div class="row">
								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Check No<font color="red">*</font></label> <input
										type="text" name="checkNo" placeholder="Enter Check No"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>

								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Name<font color="red">*</font></label> <input
										type="text" name="name1" placeholder="Enter Name"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>

								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Signature<font color="red">*</font></label> <input
										type="text" name="signature" placeholder="Enter Signature"
										class="form-control" id="inputEmail4" value=""
										required="required">
								</div>
								</div>
								<br>
								<div class="col-12">
									<input type="submit" name="operation" value="PlaceOrder"
										class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold" />
								</div>
							</sf:form>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>

	<div class="accordion accordion-flush" id="accordionFlushExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingThree">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
					aria-expanded="false" aria-controls="flush-collapseThree">
					<b>Cash On Delivery</b>
				</button>
			</h2>
			<div id="flush-collapseThree" class="accordion-collapse collapse visible"
				aria-labelledby="flush-headingThree"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body">
					
					
					<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
						<h5 class="card-header p-3 "
							style="background-color: #262673; color: white; font-style: oblique;">PAYMENT</h5>
				<div class="card-body bg-indigo-100">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/userOrder"
								modelAttribute="form">


								<div class="col-12">
									<input type="submit" name="operation" value="PlaceOrder"
										class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold" />
								</div>
							</sf:form>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>

</div>
<br>
<%-- <script type="text/javascript">
$(".accordion-header").click(function(){
	$(this).next(".accordion-collapse").slideToggle();
	
});
</script> --%>

</body>
</html>