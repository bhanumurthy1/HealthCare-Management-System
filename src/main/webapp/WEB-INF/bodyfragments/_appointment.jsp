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
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Make Appointment
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/appointment"
		modelAttribute="form" enctype="multipart/form-data">
		<div class="card" style="width: 900px">
			<h5 class="card-header"
				style="background-color: rgb(13 110 253/ 25%); color: black;">Make Appointment</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>

				<sf:hidden path="id"/>
				<sf:hidden path="slotId"/>
				<sf:hidden path="doctorId"/>
				<sf:hidden path="patientId"/>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="doctorName">
								<label for="inputEmail4" class="form-label">DoctorName</label>
								<sf:input  path="${status.expression}"
									placeholder="Enter Doctor Name here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="slot">
								<label for="inputEmail4" class="form-label">Slot</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Slot here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
						<div class="col-md-4">
							<s:bind path="appointmentDate">
								<label for="inputEmail4" class="form-label">Appointment Date</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Appointment Date here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
					</div>
				</div>
				
				<div class="mb-3">
					<div class="row">
					
						<div class="col-md-6">
							<s:bind path="patientName">
								<label for="inputEmail4" class="form-label">Patient Name</label>
								<sf:input path="${status.expression}"
									placeholder="Enter PatientName here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
						<div class="col-md-6">
							<s:bind path="contactNo">
								<label for="inputEmail4" class="form-label">ContactNo</label>
								<sf:input path="${status.expression}"
									placeholder="Enter ContactNo Date here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
					</div>
				</div>
				
				<div class="mb-3">
					<div class="row">
					
						<div class="col-md-6">
							<s:bind path="allergy">
								<label for="inputEmail4" class="form-label">Allergy</label>
								<sf:textarea path="${status.expression}" rows="4" cols="4"
									placeholder="Enter Allergy here..." class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
						<div class="col-md-6">
							<s:bind path="description">
								<label for="inputEmail4" class="form-label">Description</label>
								<sf:textarea path="${status.expression}" rows="4" cols="4"
									placeholder="Enter Description  here..." class="form-control" />
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
								<sf:textarea path="${status.expression}" rows="4" cols="4"
									placeholder="Enter Address here..." class="form-control" />
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