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
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Patient
				Registration
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/user-signUp"
		modelAttribute="form">
		<div class="card" style="width: 800px">
			<h5 class="card-header"
				style="background-color: rgb(13 110 253/ 25%); color: black;">Patient
				Registration</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="insurance">
								<label for="inputEmail4" class="form-label">Insurance</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Insurance here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-6">
							<s:bind path="insuranceCarrierName">
								<label for="inputEmail4" class="form-label">InsuranceCarrierName</label>
								<sf:input path="${status.expression}"
									placeholder="Enter InsuranceCarrierName here..."
									class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>


				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="insuranceDetail">
								<label for="inputEmail4" class="form-label">InsuranceDetail</label>
								<sf:textarea rows="4" cols="6" path="${status.expression}"
									placeholder="Enter InsuranceDetail here..."
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