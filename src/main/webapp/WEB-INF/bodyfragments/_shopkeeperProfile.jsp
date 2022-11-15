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
				<i class="fa fa-arrow-right" aria-hidden="true"></i> My Profile
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/shopkeeper-profile"
		modelAttribute="form" enctype="multipart/form-data">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #803c37; color: white; font-style: oblique;">My
				Profile</h5> 
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>
				<sf:hidden path="id" />
				<sf:hidden path="sId" />
				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="firstName">
								<label for="inputEmail4" class="form-label">First Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter First Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="middleName">
								<label for="inputEmail4" class="form-label">Middle Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Middle Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="lastName">
								<label for="inputEmail4" class="form-label">Last Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Last Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="userName">
								<label for="inputEmail4" class="form-label">User Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter User Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="password">
								<label for="inputEmail4" class="form-label">Password<font color="red">*</font></label>
								<sf:input type="password" path="${status.expression}"
									placeholder="Enter Password here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>


				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="email">
								<label for="inputEmail4" class="form-label">Email<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Email here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="phoneNo">
								<label for="inputEmail4" class="form-label">Phone No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Phone No" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="shopName">
								<label for="inputEmail4" class="form-label">Shop Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop Name" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="shopNo">
								<label for="inputEmail4" class="form-label">Shop No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop No " class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="licenceNo">
								<label for="inputEmail4" class="form-label">License No<font color="red">*</font></label>
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
									No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop Contact No" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="education">
								<label for="inputEmail4" class="form-label">Education<font color="red">*</font></label>
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
								<label for="inputEmail4" class="form-label">Shop Street<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter ShopStreet here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopcity">
								<label for="inputEmail4" class="form-label">Shop city<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Shop city here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopCountry">
								<label for="inputEmail4" class="form-label">Shop Country<font color="red">*</font></label>
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
								<label for="inputEmail4" class="form-label">Shop Address<font color="red">*</font></label>
								<sf:textarea path="${status.expression}"
									placeholder="Enter Shop Address here..." rows="4" cols="4"
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
							<img alt="" width="150px" height="150px"
								src="<c:out value="${pageContext.request.contextPath}/user/getProfilePic/${sessionScope.user.id}" />">
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="profilePic">
								<label for="inputEmail4" class="form-label">Profile
									Picture<font color="red">*</font></label>
								<sf:input type="file" path="${status.expression}"
									placeholder="Upload Profile Picture" class="form-control"
									required="required" />
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