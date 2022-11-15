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
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Medicine
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/medicine"
		modelAttribute="form" enctype="multipart/form-data">
		<div class="card" style="width: 900px">
			<h5 class="card-header"
				style="background-color: #803c37; color: white; font-style: oblique;">Medicine</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="name">
								<label for="inputEmail4" class="form-label">Name<font color="red">*</font></label>
								<sf:input type="passsword" path="${status.expression}"
									placeholder="Enter Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="companyName">
								<label for="inputEmail4" class="form-label">CompanyName<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter CompanyName here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
					
					<div class="col-md-4">
							<s:bind path="price">
								<label for="inputEmail4" class="form-label">Price<font color="red">*</font></label>
								<sf:input  path="${status.expression}"
									placeholder="Enter Price here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						<div class="col-md-4">
							<s:bind path="quantity">
								<label for="inputEmail4" class="form-label">Quantity<font color="red">*</font></label>
								<sf:input  path="${status.expression}"
									placeholder="Enter Quantity here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
						<div class="col-md-4">
							<s:bind path="rating">
								<label for="inputEmail4" class="form-label">Rating<font color="red">*</font></label>
								<sf:input  path="${status.expression}"
									placeholder="Enter Rating here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="manufactureDate">
								<label for="inputEmail4" class="form-label">ManufactureDate<font color="red">*</font></label>
								<sf:input  path="${status.expression}"
									placeholder="Enter ManufactureDate here..." id="datepicker1" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="expiryDate">
								<label for="inputEmail4" class="form-label">ExpiryDate<font color="red">*</font></label>
								<sf:input  id="datepicker2" path="${status.expression}"
									placeholder="Enter ExpiryDate here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="description">
								<label for="inputEmail4" class="form-label">Description<font color="red">*</font></label>
								<sf:textarea rows="4" cols="5" type="passsword" path="${status.expression}"
									placeholder="Enter companyName here..." class="form-control" />
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