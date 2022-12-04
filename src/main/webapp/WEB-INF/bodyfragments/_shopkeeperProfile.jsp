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
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true"> My Profile
				</i></li>
		</ol>
	</nav>
</div>
<hr class=" text-indigo-800">
<div class="container">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/shopkeeper-profile"
		modelAttribute="form" enctype="multipart/form-data">
		<div class=" min-h-screen  flex items-center justify-center px-5 py-5">
			<div class="bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden" >
			  <div class="md:flex w-full">
				<div class="bg-white  w-full  py-10 px-5 md:px-10">
					<div class="text-center mb-10">
					  <h1 class="font-bold text-2xl text-gray-900">MY PROFILE</h1><br></br>
				<b><%@ include file="businessMessage.jsp"%></b>
				<sf:hidden path="id" />
				<sf:hidden path="sId" />


				<div class="mb-3 border-none">
					<div class="flex flex-wrap justify-center border-none">
						<div class="w-6/12 sm:w-2/12 px-8 border-none">
							<img 
							class="shadow rounded-full max-w-full h-auto align-middle border-none first-letter:text-4xl h-32 w-32"
							src="<c:out value="${pageContext.request.contextPath}/user/getProfilePic/${sessionScope.user.id}" />">
						</div>
					</div>
				</div>
				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="firstName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">First Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="middleName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Middle Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="lastName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Last Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
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
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Email<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="phoneNo">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Phone No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>
						<div class="col-md-4">
							<s:bind path="profilePic">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Profile
									Picture<font color="red">*</font></label>
								<sf:input type="file" path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
									required="required" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>
					</div>
				</div>


				<div class="bg-indigo-50 text-gray-500 rounded-3xl shadow-xl overflow-hidden px-5 py-5 "  >
					<div class="w-full">
				<div class="mb-3">
					<div class="row">
						<div class="col-md-6">
							<s:bind path="userName">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">User Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div>
							</s:bind>
						</div>

						<div class="col-md-6">
							<s:bind path="password">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Password<font color="red">*</font></label>
								<sf:input type="password" path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div>
							</s:bind>
						</div>
					</div>
				</div>
			</div></div><br>

				
			<div class="bg-indigo-50 text-gray-500 rounded-3xl shadow-xl overflow-hidden px-5 py-5 "  >
				<div class="w-full">
				<div class="mb-3">
					<div class="row">

						<div class="col-md-4">
							<s:bind path="shopName">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop Name<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>


						<div class="col-md-4">
							<s:bind path="shopNo">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="licenceNo">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">License No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

					</div>
				</div>



				<div class="mb-3">
					<div class="row">

						<div class="col-md-6">
							<s:bind path="contactNo">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop Contact
									No<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>


						<div class="col-md-6">
							<s:bind path="education">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Education<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

					</div>
				</div>

				<div class="mb-3">
					<div class="row">
						<div class="col-md-4">
							<s:bind path="shopStreet">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop Street<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopcity">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop city<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>

						<div class="col-md-4">
							<s:bind path="shopCountry">
								<div class="relative mb-6">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop Country<font color="red">*</font></label>
								<sf:input path="${status.expression}"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font></div></div>
							</s:bind>
						</div>



					</div>
				</div>





				<div class="mb-3">
					<div class="row">
						<div class="col-md-12">
							<s:bind path="shopAddress">
									<div class="relative">
								<label for="inputEmail4" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">Shop Address<font color="red">*</font></label>
								<sf:textarea path="${status.expression}"
									rows="4" cols="4"
									class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
									</div>
							</s:bind>
						</div>
					</div>
				</div>
						
					</div>
				</div>

				<br>
				<div class="col-12">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<button type="submit" value="Save" class="flex content-center block w-full max-w-xs mx-auto bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold"
								name="operation" >
								<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
									<path stroke-linecap="round" stroke-linejoin="round" d="M9 12.75L11.25 15 15 9.75M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
								  </svg>
								  
									<span>&nbsp;SAVE</span>
								
								</button> 
							</div>
							<div class="col-md-3">
							<button type="submit" value="Reset" class="flex content-center block w-full max-w-xs mx-auto bg-orange-500 hover:bg-orange-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold"
								name="operation" >
								<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
									<path stroke-linecap="round" stroke-linejoin="round" d="M12 9.75L14.25 12m0 0l2.25 2.25M14.25 12l2.25-2.25M14.25 12L12 14.25m-2.58 4.92l-6.375-6.375a1.125 1.125 0 010-1.59L9.42 4.83c.211-.211.498-.33.796-.33H19.5a2.25 2.25 0 012.25 2.25v10.5a2.25 2.25 0 01-2.25 2.25h-9.284c-.298 0-.585-.119-.796-.33z" />
								  </svg>
									<span>&nbsp;RESET</span>
	
								</button> 
							</div>
							<div class="col-md-3"></div>
						</div>




				</div>
			</div>
		</div></div>
	</div>
</div>
	</sf:form>
</div>