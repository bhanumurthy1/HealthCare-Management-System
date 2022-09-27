<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="addUrl" value="/ctl/quickAccess" />

<c:url var="addSearch" value="/ctl/quickAccess/search" />

<c:url var="editUrl" value="/ctl/quickAccess?id=" />

<c:url var="slotUrl" value="/scheduleSlot/search?dId=" />
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item linkSize active" aria-current="page">
				<i class="fa fa-arrow-right" aria-hidden="true"></i> Quick Access
			</li>
		</ol>
	</nav>
</div>
<hr>
<div class="container">
	<div class="card shadow  mb-5 bg-body rounded" >
		<h5 class="card-header"
			style="background-color: rgb(13 110 253/ 25%); color: black;">Search Here</h5>
		<b><%@ include file="businessMessage.jsp"%></b>
		<div class="card-body">
			<sf:form role="form"
				action="${pageContext.request.contextPath}/quickAccess/search"
				method="post" modelAttribute="form">

				<div class="mb-3">
					<div class=row>
						<div class="col-8">
							<s:bind path="key">
								<sf:input  path="${status.expression}"
									placeholder="Enter Search here..." class="form-control" />
								<div class="form-text">
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</div>
							</s:bind>
						</div>

						<div class="col-4">
							<input type="submit" name="operation"
								class="btn btn-outline-info" value="Search">
						</div>
					</div>
				</div>
			</sf:form>
		</div>
	</div>
</div>

<c:if test="${list != null}">

<sf:form method="post"
	action="${pageContext.request.contextPath}/quickAccess/search"
	modelAttribute="form">
	<div class="card">
		<h5 class="card-header"
			style="background-color: #00061df7; color: white;">Suggestions</h5>
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

			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<%-- <c:if test="${sessionScope.user.role.id == 1}">
							<th scope="col"><input type="checkbox" id="selectall">Select
								All</th>
						</c:if> --%>
						<th scope="col">Suggestion</th>
						<%-- <c:if test="${sessionScope.user.role.id == 1}">
							<th scope="col">Action</th>
						</c:if> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="ac" varStatus="quickAccess">
						<tr>
							<%-- <c:if test="${sessionScope.user.role.id == 1}">
								<td><input type="checkbox" class="case" name="ids"
									value="${em.id}"></td>
							</c:if> --%>
							<td scope="row">${ac.description}</td>
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

