<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/user" />

<c:url var="addSearch" value="/user/search" />


<c:url var="editUrl" value="/user?id=" />

<c:url var="approveUrl" value="/user/approveProfile?id=" />

<c:url var="apUrl" value="/user/update?id=" />

<c:url var="detailUrl" value="/user/search/detail?id=" />

<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>

			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">User List</i> 
			</li>

		</ol>
	</nav>

<hr class=" text-indigo-800">
<sf:form method="post"
	action="${pageContext.request.contextPath}/user/search"
	modelAttribute="form">
	<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
		<h5 class="card-header p-3 "
			style="background-color: #262673; color: white; font-style: oblique;">DOCTORS LIST</h5>
<div class="card-body bg-indigo-100">
			<div class="row g-3">

				<s:bind path="firstName">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm block px-2.5 pb-2.5 pt-2 w-full text-sm rounded-lg border-2 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
							placeholder="Search By First Name" />
					</div>
				</s:bind>

				<s:bind path="lastName">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm block px-2.5 pb-2.5 pt-2 w-full text-sm rounded-lg border-2 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
							placeholder="Search By Last Name" />
					</div>
				</s:bind>
				<div class="col flex flex-row">



						<button type="submit" value="Search" class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold"
							name="operation" >
							<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
								<path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
							  </svg>
							<span>&nbsp;SEARCH</span>

						</button> &nbsp; 
						
						
						  <button type="submit" value="Reset" class="flex items-center block bg-orange-500 hover:bg-orange-700 focus:bg-orange-700 text-white rounded-lg px-2 py-2 font-semibold"
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

			<table class="table p-5 border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden">
				<thead>
					<tr class="text-center border border-slate-300 p-3 bg-indigo-500 font-semibold text-white">
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
								<th scope="col"><input type="checkbox" id="selectall">Select
								All</th>
								</c:if> --%>
						<th scope="col">#</th>
						<th scope="col">Profile</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">PhoneNo</th>
						<th scope="col">Address</th>
						<th scope="col">Role</th>
						<th scope="col">Action</th>
						<%-- <c:if test="${sessionScope.user.roleId == 1}">
							<th scope="col">Action</th>
							</c:if> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="us" varStatus="user">
						<tr class="border border-slate-300 text-center">
							<%-- <c:if test="${sessionScope.user.roleId == 1}">
							<td><input type="checkbox" class="case"
									name="ids" value="${ht.id}"></td>
									</c:if> --%>
							<td scope="row">${user.index+1}</td>
							<td scope="row"><img alt="" width="150px" height="150px" class="shadow rounded-full max-w-full h-auto align-middle border-none first-letter:text-4xl h-32 w-32"
								src="<c:out value="${pageContext.request.contextPath}/user/getProfilePic/${us.id}" />"></td>
							<td scope="row">${us.firstName}${us.middleName}
								${us.lastName}</td>
							<td scope="row">${us.emailId}</td>
							<td scope="row">${us.phoneNo}</td>
							<td scope="row">${us.address.address}</td>
							<td scope="row">${us.role.name}</td>
							<c:if test="${us.role.id == 4}">
							<td scope="row">Approved</td>
							</c:if>
							
							<c:if test="${us.role.id != 4}">
							
								<c:if test="${us.approved == false}">
									<td scope="row"><a href="${approveUrl}${us.id}" class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold"><i class="fa fa-thumbs-up" aria-hidden="true"></i>&nbsp;Approve</a></td>
								</c:if>
								
								<c:if test="${us.approved == true}">
									<td scope="row">Approved</td>
								</c:if>
							
						
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
</div>
