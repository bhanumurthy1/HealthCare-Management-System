<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/notification" />

<c:url var="addSearch" value="/notification/search" />

<c:url var="editUrl" value="/notification?id=" />
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true"> Notifications</i>
			</li>
		</ol>
	</nav>
	<br>
	<form action="${addSearch}" method="post">
		<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
			<h5 class="card-header p-3 "
				style="background-color: #262673; color: white; font-style: oblique;">Notifications</h5>
	<div class="card-body bg-indigo-100">
				<b><%@ include file="businessMessage.jsp"%></b>
				<br>
				<table class="table p-5 border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden">
					<thead>
						<tr class="text-center border border-slate-300 p-3 bg-indigo-500 font-semibold text-white">

							<th scope="col">#</th>
							<!-- <th scope="col">Image</th> -->
							<th scope="col">Notification</th>
							<th scope="col">Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="ct" varStatus="notification">
							<tr class="border border-slate-300 text-center">
								<td scope="row">${notification.index+1}</td>
								<%-- <td scope="row"><img
									src="<c:url value="/ctl/product/getImage/${ct.product.id}" />"
									width="100px" height="100px"></td> --%>
								<td scope="row">${ct.notification}</td>
								<td scope="row"><fmt:formatDate value="${ct.date}"
										pattern="yyyy-MM-dd" /></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
		</div>
	</form>
</div>

