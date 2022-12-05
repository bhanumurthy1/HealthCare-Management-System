<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize text-indigo-800"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize text-indigo-800 active" aria-current="page"> <i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">Forget Password</i></li>
  </ol>
</nav>
</div>
<hr class="text-indigo-800">
<div class=" min-h-screen  flex items-center justify-center px-5 py-5 -mt-40">
	<div class="bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden" style="max-width: 1000px" >
	  <div class="md:flex w-full">
		<div class="hidden md:block w-1/3 bg-indigo-500 py-10 px-10">

			<img
			src="${pageContext.request.contextPath}/resources/images/forgot_pass.svg"
			class=" h-full w-full "
			alt="..."
		  />
		</div>
		<div class="bg-white  w-full md:w-2/3 py-10 px-5 md:px-10">
		  <div class="text-center mb-10">
			<h1 class="font-bold text-2xl text-gray-900">Forgot your password?</h1><br></br>
			<b><%@ include file="businessMessage.jsp"%></b>
				<sf:form role="form" action="${pageContext.request.contextPath}/forgetPassword" method="post" modelAttribute="form">
				
					<s:bind path="userName">
							<div class="mb-3">
								<div class="relative mb-6">
									<div class="relative">
								<label for="exampleInputEmail1" class="absolute text-sm text-black dark:text-black duration-300 transform -translate-y-4 scale-75 top-2 z-10 origin-[0] bg-gray-100 dark:bg-gray-300 px-2 peer-focus:px-2 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:-translate-y-1/2 peer-placeholder-shown:top-1/2 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-4 left-1">USER NAME<font color="red">*</font></label> 
								<sf:input path="${status.expression}" 
										class="block px-2.5 pb-2.5 pt-2 w-full text-sm text-gray-900 bg-transparent rounded-lg border-2 border-gray-300 dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" />
								<div class="form-text"><font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font></div>
							</div></div></div>
							</s:bind>
							
							<input type="submit" name="operation" class="block w-full max-w-xs mx-auto bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold"
								value="CONTINUE">
				</sf:form>
			</div>
		</div></div></div>
	</div>
	