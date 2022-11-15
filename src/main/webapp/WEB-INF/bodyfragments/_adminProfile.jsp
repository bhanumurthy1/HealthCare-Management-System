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
<hr>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/signUp"
		modelAttribute="form">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #803c37; color: white; font-style: oblique;">My
				Profile</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>

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
							<s:bind path="email">
								<label for="inputEmail4" class="form-label">Email<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Email here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

					</div>
				</div>



				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="phoneNo">
								<label for="inputEmail4" class="form-label">Phone No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Phone No" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="age">
								<label for="inputEmail4" class="form-label">Age<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Age herer.." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="dob">
								<label for="inputEmail4" class="form-label">Dob<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Date Of Birth" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="gender">
								<label for="inputEmail4" class="form-label">Gender<font color="red">*</font></label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${gender}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>



					</div>
				</div>


				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="houseNo">
								<label for="inputEmail4" class="form-label">HouseNo<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter HouseNo here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="city">
								<label for="inputEmail4" class="form-label">City<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter City here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						<div class="col-md-4">
							<s:bind path="street">
								<label for="inputEmail4" class="form-label">Street<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Street here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="state">
								<label for="inputEmail4" class="form-label">State<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter State here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="country">
								<label for="inputEmail4" class="form-label">Country<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter Country here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="ZipCode">
								<label for="inputEmail4" class="form-label">ZipCode<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									placeholder="Enter ZipCode here..." class="form-control" />
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
									Picture</label>
								<sf:input type="file" path="${status.expression}"
									placeholder="Upload Profile Picture" class="form-control"
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
							<s:bind path="address">
								<label for="inputEmail4" class="form-label">Address</label>
								<sf:textarea path="${status.expression}"
									placeholder="Enter Address here..." rows="4" cols="4"
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