<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item linkSize active" aria-current="page">
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Shopkeeper
				Registration
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/shopkeeper-signUp"
		modelAttribute="form">
		<div class="card">
			<h5 class="card-header"
				style="background-color: rgb(13 110 253/ 25%); color: black;">Shopkeeper
				Registration</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="shopName">
								<label for="inputEmail4" class="form-label">Shop Name</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop Name" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="shopNo">
								<label for="inputEmail4" class="form-label">Shop No</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop No " class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="licenceNo">
								<label for="inputEmail4" class="form-label">License No</label>
								<sf:input path="${status.expression}"
									placeholder="Enter License No " class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

					</div>
				</div>



				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="contactNo">
								<label for="inputEmail4" class="form-label">Shop Contact
									No</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop Contact No" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="education">
								<label for="inputEmail4" class="form-label">Education</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Education " class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="shopStreet">
								<label for="inputEmail4" class="form-label">Shop Street</label>
								<sf:input path="${status.expression}"
									placeholder="Enter ShopStreet here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopcity">
								<label for="inputEmail4" class="form-label">Shop city</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop city here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopCountry">
								<label for="inputEmail4" class="form-label">Shop Country</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop Country here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>



					</div>
				</div>





				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="shopAddress">
								<label for="inputEmail4" class="form-label">Shop Address</label>
								<sf:textarea path="${status.expression}"
									placeholder="Enter Shop Address here..." rows="4" cols="4"
									class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<br>
				<div class="col-12">
					<input type="submit" name="operation" class="btn btn-outline-info"
						value="Save"> or <input type="submit" name="operation"
						class="btn btn-outline-info" value="Reset">
				</div>
			</div>
		</div>
	</sf:form>
</div>