<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg"
	style="height: 59px; background-color: #055160;">
	<div class="container-fluid">
		<a class="navbar-brand " href="#"
			style="font-size: 26px; font-family: serif; color: white;"> <span
			style="font-variant: petite-caps;">Health Care</span> <span
			style="font-variant: petite-caps; color: #ff9900">Management</span>
		</a>


		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			</ul>
			<c:if test="${sessionScope.user != null}">
				<span class="navbar-text"
					style="color: white; font-size: 14px; font-variant-caps: petite-caps;">
					Hii,${sessionScope.user.firstName} ${sessionScope.user.lastName}
					(${sessionScope.user.role.name})</span>
			</c:if>
			<c:if test="${sessionScope.user == null}">
				<span class="navbar-text"
					style="color: white; font-size: 14px; font-variant-caps: petite-caps;">
					Hii,Guest </span>
			</c:if>
		</div>
	</div>
</nav>
<div class="shadow bg-body rounded">
	<nav class="navbar navbar-expand-lg "
		style="height: 39px; background-color: rgb(13 110 253/ 25%)">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item linkSize"><a
						class="nav-link active link-dark" aria-current="page"
						href="<c:url value="/welcome"/>">Home</a></li>
						
						<c:if test="${sessionScope.user == null}">
						<li class="nav-item linkSize"><a
						class="nav-link active link-dark" aria-current="page"
						href="<c:url value="/quickAccess/search"/>">Quick Access</a></li>
						
						</c:if>
						
					<c:if test="${sessionScope.user != null}">
						<c:if test="${sessionScope.user.role.id == 1}">
						<li class="nav-item linkSize"><a
						class="nav-link active link-dark" aria-current="page"
						href="<c:url value="/quickAccess/search"/>">Quick Access</a></li>
							<li class="nav-item dropdown linkSize"><a
								class="nav-link dropdown-toggle link-dark" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Reports </a>
								<ul class="dropdown-menu">
									<li><a class="nav-link link-dark"
										href="<c:url value="/user/search"/>">User Report</a></li>
									<li><a class="nav-link link-dark"
										href="<c:url value="/medicine/search"/>">Medicine report</a></li>

								</ul></li>

						</c:if>

						<c:if test="${sessionScope.user.role.id == 2}">
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/scheduleSlot"/>">Add Slot</a></li>
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/scheduleSlot/search"/>">Slot List</a></li>
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/appointment/search"/>">Appointment
									Report</a></li>

						</c:if>

						<c:if test="${sessionScope.user.role.id == 3}">
							<%-- <li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/medicine"/>">Add Medicine</a></li>
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/medicine/search"/>">Medicine List</a></li> --%>

							<li class="nav-item dropdown linkSize"><a
								class="nav-link dropdown-toggle link-dark" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Medicine </a>
								<ul class="dropdown-menu">
									<li><a class="nav-link link-dark"
										href="<c:url value="/medicine"/>">Add Medicine</a></li>
									<li><a class="nav-link link-dark"
										href="<c:url value="/medicine/search"/>">Medicine List</a></li>
									

								</ul></li>

						</c:if>


						<c:if test="${sessionScope.user.role.id == 4}">
						<li class="nav-item linkSize"><a
						class="nav-link active link-dark" aria-current="page"
						href="<c:url value="/quickAccess/search"/>">Quick Access</a></li>
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/schedule-appointment"/>">Schedule an
									Appointment</a></li>
							<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/medicine/search"/>">Get Medicine</a></li>
								<li class="nav-item linkSize"><a class="nav-link link-dark"
								href="<c:url value="/appointment/search"/>">Appointment
									Report</a></li>
						</c:if>

					</c:if>
					<c:if test="${sessionScope.user == null}">
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							href="<c:url value="/aboutUs"/>">AboutUs</a></li>
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							href="<c:url value="/contactUs"/>">ContactUs</a></li>
					</c:if>
				</ul>
			</div>
			<ul class="nav justify-content-end">
				<c:if test="${sessionScope.user != null}">
					<c:if test="${sessionScope.user.role.id == 4}">
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							style="padding: 6px;" href="<c:url value="/patient-profile"/>">My
								Profile</a></li>
					</c:if>

					<c:if test="${sessionScope.user.role.id == 3}">
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							style="padding: 6px;" href="<c:url value="/shopkeeper-profile"/>">My
								Profile</a></li>
					</c:if>

					<c:if test="${sessionScope.user.role.id == 2}">
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							style="padding: 6px;" href="<c:url value="/doctor-profile"/>">My
								Profile</a></li>
					</c:if>

					<c:if test="${sessionScope.user.role.id == 1}">
						<li class="nav-item linkSize"><a class="nav-link link-dark"
							style="padding: 6px;" href="<c:url value="/admin-profile"/>">My
								Profile</a></li>
					</c:if>

					<li class="nav-item linkSize"><a class="nav-link link-dark"
						style="padding: 6px;" href="<c:url value="/changepassword"/>">Change
							Password</a></li>

					<li class="nav-item linkSize"><a class="nav-link link-dark"
						style="padding: 6px;" href="<c:url value="/login"/>">Logout</a></li>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<li class="nav-item linkSize"><a class="nav-link link-dark"
						style="padding: 6px;" href="<c:url value="/login"/>">SignIn</a></li>

					<li class="nav-item linkSize"><a class="nav-link link-dark"
						style="padding: 6px;" href="<c:url value="/signUp"/>">SignUp</a></li>

					<!-- <li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li> -->



				</c:if>

			</ul>
		</div>
	</nav>
</div>
