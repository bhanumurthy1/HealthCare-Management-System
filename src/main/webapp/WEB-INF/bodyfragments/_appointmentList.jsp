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
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true"> Appointment
				List</i>
			</li>
		</ol>
	</nav>

<hr class="text-indigo-800">
<sf:form method="post"
	action="${pageContext.request.contextPath}/appointment/search"
	modelAttribute="form" >
	<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
		<h5 class="card-header p-3 "
			style="background-color: #262673; color: white; font-style: oblique;">Appointment
			List</h5>
		<div class="card-body bg-indigo-100">
			<div class="row g-3">

				<c:if test="${sessionScope.user.role.id == 2}">
					<s:bind path="patientName">
						<div class="col">
							<sf:input path="${status.expression}"
								class="block px-2.5 pb-2.5 pt-2 w-full text-sm rounded-lg border-2 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
								placeholder="Search By Patient Name" />
						</div>
					</s:bind>
				</c:if>

				<c:if test="${sessionScope.user.role.id == 4}">
					<s:bind path="doctorName">
						<div class="col">
							<sf:input path="${status.expression}"
								class="block px-2.5 pb-2.5 pt-2 w-full text-sm rounded-lg border-2 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
								placeholder="Search By Doctor Name" />
						</div>
					</s:bind>
				</c:if>

				<div class="col flex flex-row">

					<button type="submit" value="Search" class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold"
					name="operation" >
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
						<path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
					  </svg>
					<span>&nbsp;SEARCH</span>

				</button> &nbsp; 
				
				
				  <button type="submit" value="reset" class="flex items-center block bg-orange-500 hover:bg-orange-700 focus:bg-orange-700 text-white rounded-lg px-2 py-2 font-semibold"
				  name="operation" > 
				  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
					<path stroke-linecap="round" stroke-linejoin="round" d="M12 9.75L14.25 12m0 0l2.25 2.25M14.25 12l2.25-2.25M14.25 12L12 14.25m-2.58 4.92l-6.375-6.375a1.125 1.125 0 010-1.59L9.42 4.83c.211-.211.498-.33.796-.33H19.5a2.25 2.25 0 012.25 2.25v10.5a2.25 2.25 0 01-2.25 2.25h-9.284c-.298 0-.585-.119-.796-.33z" />
				  </svg>
				  <span>&nbsp;RESET</span>

				</button>
				</div>
			</div>
			<b><%@ include file="businessMessage.jsp"%></b>
			<br>
			<sf:input type="hidden" path="pageNo" />
			<sf:input type="hidden" path="pageSize" />

			<sf:input type="hidden" path="listsize" />
			<sf:input type="hidden" path="total" />
			<sf:input type="hidden" path="pagenosize" />

			<table class="table p-3  border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden" >
				<thead>
					<tr class="text-center border border-slate-300 p-3 bg-indigo-500 font-semibold text-white">
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
								<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col"><input type="checkbox" id="selectall">Select
								All</th>
								</c:if> --%>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">#</th>
						<c:if test="${sessionScope.user.role.id == 2}">
							<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Patient Name</th>
						</c:if>
						<c:if test="${sessionScope.user.role.id == 4}">
							<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Doctor Name</th>
						</c:if>

						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Slot</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Date</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Contact No</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Allergy</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Description</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Prescription</th>
						<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Chat With Doctor</th>
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
							<th class="border border-slate-300 p-3 bg-indigo-500 font-semibold text-white" scope="col">Action</th>
							</c:if> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="md" varStatus="appointment">
						<tr class="text-center border border-slate-300 " >
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
									value="${md.appointmentDate}" pattern="yyyy-MM-dd" /></td>
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
							<td class="text-center" scope="row"><a class="nav-link link-dark"
								href="<c:url value="/pChat?dId=${md.doctorId}&pId=${md.patientId}&docName=${md.doctorName}&pName=${md.patientName}"/>"><i class="fa fa-comments"
									aria-hidden="true"  style="color:orange"></i></a></td>
									
									<%-- <td scope="row"><a class="nav-link link-dark"
								href="<c:url value="/chat"/>"><i class="fa fa-comments" style="color:orange"
									aria-hidden="true"></i></a></td> --%>

						




							<%-- <c:if test="${sessionScope.user.roleId == 1}">
								<td class="text-center" ><a href="${editUrl} ${pl.id}"
									><i class="fas fa-edit"  style="color:#262673"></i></a></td>
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

</div>



