<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true"> Login</i>
			</li>
		</ol>
	</nav>
</div>
<hr class=" text-indigo-800">
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/userOrder"
		modelAttribute="form">

		<div class="card rounded-3xl shadow-xl w-full overflow-hidden mt-10">
			<h5 class="card-header p-3 "
				style="background-color: #262673; color: white; font-style: oblique;">CHECKOUT</h5>
	
				<div class="card-body">
				<div class="row g-3">
					<div class="col-md-5 col-lg-4 order-md-last">
						<h4 class="d-flex justify-content-between align-items-center mb-3">
							<span class="text-muted font-semibold">Item Detail</span>
						</h4>

						<table class="table p-5 border-collapse border border-slate-400 bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden">
							<thead>
								<tr class="text-center border border-slate-300 p-3 bg-indigo-500 font-semibold text-white">
									<th scope="col">Name</th>
									<th scope="col">Price</th>
									<th scope="col">Quantity</th>
									<th scope="col">Total</th>
								</tr>
							</thead>
							<tbody class="border border-slate-300 text-center">
								<c:set var="totalp" value="${0}" />
								<c:forEach items="${cList}" var="ct" varStatus="cart">
									<tr class="border border-slate-300 text-center">
										<%-- <td scope="row"><img
											src="<c:url value="/ctl/product/getImage/${ct.product.id}" />"
											width="100px" height="100px"></td> --%>
										<td scope="row">${ct.medicineName}</td>
										<td scope="row">${ct.amount}</td>
										<td scope="row">${ct.quantity}</td>
										<td scope="row">${ct.totalAmount}</td>
									</tr>
									<c:set var="totalp" value="${totalp + ct.totalAmount}" />
								</c:forEach>
								<tr class="border border-slate-300 text-center font-semibold"> 
									<td colspan="3">Total</td>
									<td colspan="3">${totalp}</td>
								</tr>

							</tbody>
						</table>

					</div>
					<sf:hidden path="amount" value="${totalp}" />
					<div class="col-md-7 col-lg-8">
						<h4 class="mb-3 font-semibold">Billing address</h4>
						<div class="row g-3">
							<div class="col-sm-6">
								<s:bind path="firstName">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">FirstName<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" path="${status.expression}"
										required="required" />
										</div>
										</div>
								</s:bind>
							</div>

							<div class="col-sm-6">
								<s:bind path="lastName">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">LastName<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" path="${status.expression}"
										placeholder="Enter Last Name" required="required" />
									</div></div>
								</s:bind>
							</div>

							<div class="col-sm-6">
								<s:bind path="contactNo">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Contact No<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter Contact No"
										required="required" />
									</div></div>
								</s:bind>

							</div>
							<div class="col-sm-6">
								<s:bind path="email">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Email<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter Email"
										required="required" />
									</div></div>
								</s:bind>

							</div>

							

							<div class="col-md-6">
								<s:bind path="state">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">State<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter State"
										required="required" />
									</div></div>
								</s:bind>
							</div>

							<div class="col-md-6">
								<s:bind path="city">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">City<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter City"
										required="required" />
									</div></div>
								</s:bind>
							</div>

							<div class="col-md-4">
								<s:bind path="country">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Country<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter Country"
										required="required" />
									</div></div>
								</s:bind>
							</div>

							<div class="col-md-4">
								<s:bind path="zipCode">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">ZipCode<font color="red">*</font></label>
									<sf:input class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter ZipCode"
										required="required" />
									</div></div>
								</s:bind>
							</div>

							<div class="col-md-4">
								<s:bind path="deliveryType">
									<div class="relative mb-6">
										<div class="relative">
									<label for="firstName" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Delivery Type<font color="red">*</font></label>
									
									<div class="flex flex-row">
									<div class="form-check mt-3">
										<sf:radiobutton class="form-check-input"
											path="${status.expression}" value="Home" id="flexRadioDefault1"/> <label
											class="form-check-label" for="flexRadioDefault1">
											Home Delivery</label>
									</div>
									<div class="form-check mt-3">
										<sf:radiobutton class="form-check-input"
											path="${status.expression}" value="Store" id="flexRadioDefault2"/>
										<label class="form-check-label" for="flexRadioDefault2">
											Store Pickup </label>
									</div>
									</div>
								</div></div>
								</s:bind>
							</div>


							<div class="col-12">
								<s:bind path="address">
									<div class="relative mb-6">
										<div class="relative">
									<label for="address" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Address<font color="red">*</font></label>
									<sf:textarea class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" id="firstName"
										path="${status.expression}" placeholder="Enter Address"
										rows="4" cols="4" required="required" />
									</div></div>
								</s:bind>
							</div>




						</div>

						<hr class="my-4">

						<button type="submit" name="operation" value="Payment"
							class="flex items-center block bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-2 py-2 font-semibold" 
							><i class="fa fa-check" aria-hidden="true"></i>&nbsp;Payment</button>


					</div>


				</div>

			</div>

		</div>
	</sf:form>
</div>

