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
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">Quick Access</i> 
			</li>
		</ol>
	</nav>
<hr class=" text-indigo-800">
<div class=" min-h-screen  flex items-center justify-center px-5 py-5  -mt-20">
	<div class="bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden" style="max-width: 1000px" >
	  <div class="md:flex w-full">
		<div class="hidden md:block w-1/3 bg-indigo-500 py-10 px-10">

			<img
			src="${pageContext.request.contextPath}/resources/images/quick_access.svg"
			class=" h-full w-full "
			alt="..."
		  />
		</div>
		<div class="bg-white  w-full md:w-2/3 py-10 px-5 md:px-10 overflow-x-auto max-h-[32rem] ">
		  <div class="text-center mb-10">
			<h1 class="font-bold text-2xl text-gray-900">SELECT DETAILS</h1><br></br>
		<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form role="form"
				action="${pageContext.request.contextPath}/quickAccess/search"
				method="post" modelAttribute="form">

				<ul class="list-group" style="width: auto">
					<li class="list-group-item active" aria-current="true" style="background-color: #262673; color: white;">Who is the checkup for?</li>
					<li class="list-group-item"><div class="form-check">
							<input class="form-check-input" type="radio"
								name="flexRadioDefault" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1">
								Myself option</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								name="flexRadioDefault" id="flexRadioDefault2" checked>
							<label class="form-check-label" for="flexRadioDefault2">
								 Someone else</label>
						</div></li>
				</ul>
				<br>
				<ul class="list-group" style="width: auto"> 
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">What is your gender ?</li>
					<li class="list-group-item"><div class="form-check">
							<input class="form-check-input" type="radio"
								name="gender" id="female"> <label
								class="form-check-label" for="flexRadioDefault1">
								Female </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								name="gender" id="Male" checked>
							<label class="form-check-label" for="flexRadioDefault2">
								Male</label>
						</div></li>
				</ul>
				
				<br>
				<ul class="list-group" style="width: auto">
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">How old are you?</li>
					<li class="list-group-item">
								 <input class="form-control" type="text" placeholder="Enter your Age"
								name="age" id="age"> 
					
				</ul>
				
				
				<br>
				<ul class="list-group" style="width: auto">
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">Please add your symptoms below</li>
					<li class="list-group-item">
								<s:bind path="key">
								<sf:input  path="${status.expression}"
									placeholder="Enter Symptoms here..." class="form-control" />
								<div class="form-text">
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</div>
							</s:bind>
						
					
				</ul>
				
				<br>
				<ul class="list-group" style="width: auto">
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">How severity is your symptom on scale of 1 to 10?</li>
					<li class="list-group-item">
								<s:bind path="scale">
								<sf:input  path="${status.expression}"
									placeholder="Enter scale here..." class="form-control" />
								<div class="form-text">
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</div>
							</s:bind>
					
				</ul>
				
				<br>
				<ul  class="list-group" style="width: auto">
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">Number of days you are suffering with</li>
					<li class="list-group-item">
								<s:bind path="days">
								<sf:input  path="${status.expression}"
									placeholder="Enter Days here..." class="form-control" />
								<div class="form-text">
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</div>
							</s:bind>
					
				</ul>
				
				<br>
				<ul  class="list-group" style="width: auto"> 
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">Do you have diabetes</li>
					<li class="list-group-item"><div class="form-check">
							<input class="form-check-input" type="radio"
								name="dia" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1">
								Yes </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								name="dia" id="flexRadioDefault2" checked>
							<label class="form-check-label" for="flexRadioDefault2">
								No</label>
						</div></li>
				</ul>
				
				<br>
				<ul class="list-group" style="width: auto"> 
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">Do you have hypertension. </li>
					<li class="list-group-item"><div class="form-check">
							<input class="form-check-input" type="radio"
								name="hypertension" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1">
								Yes </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								name="hypertension" id="flexRadioDefault2" checked>
							<label class="form-check-label" for="flexRadioDefault2">
								No</label>
						</div></li>
				</ul>
				
				<br>
				<ul  class="list-group" style="width: auto"> 
					<li style="background-color: #262673; color: white;" class="list-group-item active" aria-current="true">Any recent medical issues.</li>
					<li class="list-group-item"><div class="form-check">
							<input class="form-check-input" type="radio"
								name="issues" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1">
								Yes </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								name="issues" id="flexRadioDefault2" checked>
							<label class="form-check-label" for="flexRadioDefault2">
								No</label>
						</div></li>
				</ul>
<br>

				<div class="col-12">
					<input type="submit" name="operation" class="block w-full max-w-xs mx-auto bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold"
						value="Submit">
				</div>

			</sf:form>
		</div>
	</div>
</div>
</div></div></div>
