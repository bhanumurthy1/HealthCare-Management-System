<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/appointment" />

<c:url var="addSearch" value="/appointment/search" />

<c:url var="editUrl" value="/appointment?id=" />

<c:url var="detailUrl" value="/appointment/search/detail?id=" />

<c:url var="updateUrl" value="/appointment/updatePrescription?aId=" />

<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item linkSize active" aria-current="page">
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Appointment
				List
			</li>
		</ol>
	</nav>
</div>
<hr>
<sf:form method="post"
	action="${pageContext.request.contextPath}/appointment/search"
	modelAttribute="form">
	<div class="card">
		<h5 class="card-header"
			style="background-color: #00061df7; color: white;">Appointment
			List</h5>
		<div class="card-body">
			<div class="row g-3">

				<c:if test="${sessionScope.user.role.id == 2}">
					<s:bind path="patientName">
						<div class="col">
							<sf:input path="${status.expression}"
								class="form-control form-control-sm"
								placeholder="Search By Patient" />
						</div>
					</s:bind>
				</c:if>

				<c:if test="${sessionScope.user.role.id == 4}">
					<s:bind path="doctorName">
						<div class="col">
							<sf:input path="${status.expression}"
								class="form-control form-control-sm"
								placeholder="Search By Patient" />
						</div>
					</s:bind>
				</c:if>

				<div class="col">
					<input type="submit" class="btn btn-sm btn-outline-primary"
						name="operation" value="Search"></input> or <input type="submit"
						class="btn btn-sm btn-outline-secondary" name="operation"
						value="Reset">
				</div>
			</div>
			<b><%@ include file="businessMessage.jsp"%></b>
			<br>
			<sf:input type="hidden" path="pageNo" />
			<sf:input type="hidden" path="pageSize" />

			<sf:input type="hidden" path="listsize" />
			<sf:input type="hidden" path="total" />
			<sf:input type="hidden" path="pagenosize" />

			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
								<th scope="col"><input type="checkbox" id="selectall">Select
								All</th>
								</c:if> --%>
						<th scope="col">#</th>
						<c:if test="${sessionScope.user.role.id == 2}">
							<th scope="col">Patient Name</th>
						</c:if>
						<c:if test="${sessionScope.user.role.id == 4}">
							<th scope="col">Doctor Name</th>
						</c:if>

						<th scope="col">Slot</th>
						<th scope="col">Date</th>
						<th scope="col">Contact No</th>
						<th scope="col">Allergy</th>
						<th scope="col">Description</th>
						<th scope="col">Prescription</th>
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
							<th scope="col">Action</th>
							</c:if> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="md" varStatus="appointment">
						<tr>
							<%-- <c:if test="${sessionScope.user.roleId == 1}">
							<td><input type="checkbox" class="case"
									name="ids" value="${ht.id}"></td>
									</c:if> --%>
							<td scope="row">${appointment.index+1}</td>
							<c:if test="${sessionScope.user.role.id == 2}">
								<td scope="row">${md.patientName}</td>
							</c:if>
							<c:if test="${sessionScope.user.role.id == 4}">
								<td scope="row">${md.doctorName}</td>
							</c:if>
							<td scope="row">${md.slot}</td>
							<td scope="row"><fmt:formatDate
									value="${md.appointmentDate}" 
									pattern="yyyy-MM-dd" /></td>
							<td scope="row">${md.contactNo}</td>
							<td scope="row">${md.allergy}</td>
							<td scope="row">${md.description}</td>
							<c:if test="${md.prescription == null}">
								<c:if test="${sessionScope.user.role.id == 2}">
									<td scope="row"><a class="btn btn-primary btn-sm"
										href="${updateUrl} ${md.id}">Add Prescription</a></td>
								</c:if>

								<c:if test="${sessionScope.user.role.id == 4}">
									<td scope="row">Wait for until Prescription come.</td>
								</c:if>

							</c:if>

							<c:if test="${md.prescription != null}">

								<td scope="row">${md.prescription}</td>

							</c:if>

							<%-- <c:if test="${sessionScope.user.roleId == 1}">
								<td><a href="${editUrl} ${pl.id}"
									><i class="fas fa-edit"></i></a></td>
								</c:if> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="clearfix">
				<%-- <c:if test="${sessionScope.user.roleId == 1}">
				<input type="submit" name="operation"
								class="btn btn-sm btn-danger float-start" 	<c:if test="${listsize == 0}">disabled="disabled"</c:if>
								value="Delete">
				</c:if> --%>



				<nav aria-label="Page navigation example float-end">
					<ul class="pagination justify-content-end" style="font-size: 13px">
						<li class="page-item"><input type="submit" name="operation"
							class="page-link"
							<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
							value="Previous"></li>
						<c:forEach var="i" begin="1" end="${(listsize/10)+1}">
							<c:if test="${i== pageNo}">
								<li class="page-item active"><a class="page-link activate"
									href="${addSearch}?pageNo=${i}">${i}</a></li>
							</c:if>
							<c:if test="${i != pageNo}">
								<li class="page-item"><a class="page-link"
									href="${addSearch}?pageNo=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<li class="page-item"><input type="submit" name="operation"
							class="page-link"
							<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
							value="Next"></li>
					</ul>
				</nav>
			</div>


		</div>

	</div>
</sf:form>
