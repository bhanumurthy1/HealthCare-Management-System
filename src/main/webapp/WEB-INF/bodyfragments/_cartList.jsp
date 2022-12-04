<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/cart" />

<c:url var="addSearch" value="/cart/search" />

<c:url var="editUrl" value="/cart?id=" />
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">Cart List</i> 
			</li>
		</ol>
	</nav>
	<hr class="text-indigo-800">
<form action="${addSearch}" method="post">
	<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
		<h5 class="card-header p-3 "
			style="background-color: #262673; color: white; font-style: oblique;">CART</h5>
<div class="card-body bg-indigo-100">
			<b><%@ include file="businessMessage.jsp"%></b>
			<br>
			<table class="table p-5 border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden">
				<thead>
					<tr class="text-center border border-slate-300 p-3 bg-indigo-500 font-semibold text-white">

						<th scope="col">#</th>
						<!-- <th scope="col">Image</th> -->
						<th scope="col">Medicine Name</th>
						<th scope="col">Price</th>
						<th scope="col">Quantity</th>
						<th scope="col">Total Price</th>
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="totalp" value="${0}" />
					<c:forEach items="${list}" var="ct" varStatus="cart">
						<tr class="border border-slate-300 text-center">
							<td scope="row">${cart.index+1}</td>
							<%-- <td scope="row"><img
									src="<c:url value="/ctl/product/getImage/${ct.product.id}" />"
									width="100px" height="100px"></td> --%>
							<td scope="row">${ct.medicine.name}</td>
							<td scope="row">${ct.medicine.price}</td>
							<td scope="row"><input type="text"
								name="qunatity${cart.index+1}" class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
								value="${ct.quantity}"></td>
							<td scope="row">${ct.totalAmount}</td>
							<td><input type="submit" value="Update" name="operation"
								class="btn btn-sm btn-outline-info fa fa-times text-center w-3/4 block bg-orange-500 hover:bg-orange-700 focus:bg-orange-700 text-white rounded-lg px-2 py-2 font-semibold"></td>
							<td><a
								href="<c:url value="/cart/search?cid=${ct.id}&operation=Delete"/>"
								class="btn btn-sm btn-outline-info fa fa-times text-center w-3/4 block bg-orange-500 hover:bg-orange-700 focus:bg-orange-700 text-white rounded-lg px-2 py-2 font-semibold">&nbsp;Remove</a></td>
						</tr>
						<c:set var="totalp" value="${totalp + ct.totalAmount}" />
					</c:forEach>
					<tr>
						<td colspan="5">Total</td>
						<td colspan="3">${totalp}</td>
					</tr>

				</tbody>
			</table>
			<br></br>
			<div class="row">
				<div class="col-10"></div>
				<div class="col-2">

					<button type="submit" value="Checkout" class="-m-5 flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold"
							name="operation" >
							<i class="fa fa-shopping-cart"></i>
							<span>&nbsp;CHECKOUT</span>

						</button> &nbsp; 

					</div>
			</div>
			<br>
			<div class="clearfix"></div>
			<%-- <ul class="pagination pull-right">
					<li><input type="submit" name="operation"
						class="btn  btn-primary btn-sm"
						<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
						value="Previous"></li>
					<li></li>

					<li><input type="submit" name="operation"
						class="btn  btn-primary btn-sm"
						<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
						value="Next"></li>
				</ul> --%>
		</div>
	</div>
</form>
</div>

