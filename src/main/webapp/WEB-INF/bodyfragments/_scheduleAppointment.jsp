<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="addUrl" value="/ctl/doctor" />

<c:url var="addSearch" value="/ctl/doctor/search" />

<c:url var="editUrl" value="/ctl/doctor?id=" />

<c:url var="slotUrl" value="/scheduleSlot/search?dId=" />
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize  text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">Schedule
				Appointment</i> 
			</li>
		</ol>
	</nav>
</div>
<hr class=" text-indigo-800">
<div class="container">
			<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
				<h5 class="card-header p-3 "
					style="background-color: #262673; color: white; font-style: oblique;">SELECT CATEGORY</h5>
		<div class="card-body bg-indigo-100">
		<b><%@ include file="businessMessage.jsp"%></b>
		<div class="card-body">
			<sf:form role="form"
				action="${pageContext.request.contextPath}/schedule-appointment"
				method="post" modelAttribute="form">

				<div class="mb-3">
					<div class=row>
						<div class="col-8">
							<s:bind path="specialization">
								<sf:select class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${docSpecial}" />
								</sf:select>
								<div class="form-text">
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</div>
							</s:bind>
						</div>

						<div class="col-4">

								<button type="submit" value="Search" class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold"
							name="operation" >
							<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
								<path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
							  </svg>
							<span>&nbsp;SEARCH</span>

						</button>
						</div>
					</div>
				</div>
			</sf:form>
		</div>
	

<c:if test="${list != null}">

<sf:form method="post"
	action="${pageContext.request.contextPath}/schedule-appointment"
	modelAttribute="form">
	<div class="card">
		<h5 class="card-header"
			style="background-color: #2626B7; color: rgb(255, 255, 255); font-style: oblique;">Doctor List</h5>
		<div class="card-body">
			<%-- <div class="row g-3">

				<s:bind path="firstName">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm"
							placeholder="Search By First Name" />
					</div>
				</s:bind>

				<s:bind path="emailId">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm"
							placeholder="Search By Email Id" />
					</div>
				</s:bind>


				<div class="col">
					<input type="submit" class="btn btn-sm btn-outline-primary"
						name="operation" value="Search"></input> or <input type="submit"
						class="btn btn-sm btn-outline-secondary" name="operation"
						value="Reset">
				</div>
			</div>  --%>
			<b><%@ include file="businessMessage.jsp"%></b>
			<br>
			<sf:input type="hidden" path="pageNo" />
			<sf:input type="hidden" path="pageSize" />

			<sf:input type="hidden" path="listsize" />
			<sf:input type="hidden" path="total" />
			<sf:input type="hidden" path="pagenosize" />

			<table class="table p-5 border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden">
				<thead>
					<tr class="text-center border border-slate-300 p-3 bg-indigo-400 font-semibold text-white">
						<%-- <c:if test="${sessionScope.user.role.id == 1}">
							<th scope="col"><input type="checkbox" id="selectall">Select
								All</th>
						</c:if> --%>
						<th scope="col">#</th>
						<th scope="col">Name</th>
						<th scope="col">Email Id</th>
						<th scope="col">Mobile No</th>
						<th scope="col">Specialization</th>
						<th scope="col">Experience</th>
						<th scope="col">View Slot</th>
						<%-- <c:if test="${sessionScope.user.role.id == 1}">
							<th scope="col">Action</th>
						</c:if> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="doc" varStatus="doctor">
						<tr class="border border-slate-300 text-center">
							<%-- <c:if test="${sessionScope.user.role.id == 1}">
								<td><input type="checkbox" class="case" name="ids"
									value="${em.id}"></td>
							</c:if> --%>
							<td scope="row">${doctor.index+1}</td>
							<td scope="row">${doc.firstName} ${doc.lastName}</td>
							<td scope="row">${doc.emailId}</td>
							<td scope="row">${doc.phoneNo}</td>
							<td scope="row">${doc.doctor.specialization}</td>
							<td scope="row">${doc.doctor.pastExprience}</td>
							<td scope="row"><a class="btn btn-outline-info" href="${slotUrl} ${doc.id}" ><i class="fas fa-eye"></i></a></td>
						<%-- 	<c:if test="${sessionScope.user.role.id == 1}">
								
								<td>
									<a href="${editUrl} ${em.id}" ><i class="fas fa-edit"></i></a>
								
										
										</td>
							</c:if> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="clearfix">
				<%-- <c:if test="${sessionScope.user.role.id == 1}">
					<input type="submit" name="operation"
						class="btn btn-sm btn-danger float-start"
						<c:if test="${listsize == 0}">disabled="disabled"</c:if>
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
</c:if>
</div>
</div><br>
</div>

