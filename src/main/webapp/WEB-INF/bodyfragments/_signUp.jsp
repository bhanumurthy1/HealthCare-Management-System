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
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">User
				Registration</i> 
			</li>
		</ol>
	</nav>
<hr class=" text-indigo-800">
<div class=" min-h-screen  flex justify-center px-5 py-5 ">
	<div class="bg-white text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden"  >
	  <div class="md:flex w-full">
	  <div class="hidden md:block w-1/4 bg-indigo-500 py-10 px-10">
		<img
		  src="${pageContext.request.contextPath}/resources/images/signup.svg"
		  class=" h-full w-full "
		  alt="..."
		/>

	  </div>
	  <div class="w-full md:w-3/4 py-10 px-5 md:px-10">
		<div class="text-center mb-10">
		  <h1 class="font-bold text-3xl text-gray-900">Register your account</h1>
		  <br></br>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/signUp"
		modelAttribute="form">
		

				<b><%@ include file="businessMessage.jsp"%></b>


				

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="firstName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">FIRST NAME<font color="red">*</font></label>
								<sf:input path="${status.expression}" id="inputEmail4"
									 class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="middleName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">MIDDLE NAME<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="lastName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">LAST NAME<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									 class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="email">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">EMAIL<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="roleId">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">SELECT ROLE<font color="red">*</font></label>
								<sf:select class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id" items="${roleList}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						
						<div class="col-md-4">
							<s:bind path="gender">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">GENDER<font color="red">*</font></label>
								<sf:select class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${gender}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

					</div>
				</div>



				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="phoneNo">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">PHONE NO<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="age">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">AGE<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="dob">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">DOB<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									id="datepicker" class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>




					</div>
				</div>


				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="houseNo">
								
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">HOUSE NO<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="city">
								
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">CITY<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									 class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>
						<div class="col-md-4">
							<s:bind path="street">
								
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">STREET<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
					<div class="col-md-4">
							<s:bind path="state">
								
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">STATE<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="country">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">COUNTRY<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="ZipCode">
								
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">ZIP CODE<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>
					
					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="address">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">ADDRESS<font color="red">*</font></label>
								<sf:textarea path="${status.expression}" rows="4" cols="4"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div></div>
							</s:bind>
						</div>
					</div>
				</div>

				<br>
				<div class="mb-3">
					<div class="row">
				<div class="col-md-6">
					<input type="submit" name="operation" class="block w-full max-w-xs mx-auto bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold"
						value="Save"> </div> 
						<div class="col-md-6">
					<input type="submit" name="operation"
						class="block w-full max-w-xs mx-auto bg-orange-500 hover:bg-orange-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold" value="Reset">
				</div>
			</div></div>
	</sf:form>
</div>
</div> </div> </div> 
</div></div>