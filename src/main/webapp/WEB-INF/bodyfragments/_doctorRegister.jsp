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
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Doctor
				Registration
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doctor-signUp"
		modelAttribute="form" enctype="multipart/form-data">
		<div class="card">
			<h5 class="card-header"
				style="background-color: rgb(13 110 253/ 25%); color: black;">Doctor
				Registration</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="licenseNo">
								<label for="inputEmail4" class="form-label">LicenseNo</label>
								<sf:input type="passsword" path="${status.expression}"
									placeholder="Enter LicenseNo here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="certificates">
								<label for="inputEmail4" class="form-label">Certificates</label>
								<sf:input type="file" path="${status.expression}"
									placeholder="Upload Certificates" class="form-control"
									required="required" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="pastExprience">
								<label for="inputEmail4" class="form-label">PastExprience</label>
								<sf:input type="passsword" path="${status.expression}"
									placeholder="Enter PastExprience here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="totalExprience">
								<label for="inputEmail4" class="form-label">TotalExprience</label>
								<sf:input type="passsword" path="${status.expression}"
									placeholder="Enter TotalExprience here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="specialization">
								<label for="inputEmail4" class="form-label">Specialization</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${docSpecial}" />
								</sf:select>
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