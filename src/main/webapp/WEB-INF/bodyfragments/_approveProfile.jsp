<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="apUrl" value="/user/update?id=" />
<br>
<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item linkSize text-indigo-800"><i
				class="fas fa-tachometer-alt"></i> <a class="link-dark"
				href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item text-indigo-800 linkSize active" aria-current="page">
				<i class="fa fa-arrow-right text-indigo-800" aria-hidden="true">Approve Profile</i> 
			</li>
		</ol>
	</nav>
</div>
<hr class=" text-indigo-800">
<div class="container">
	<div class=" min-h-screen  flex items-center justify-center px-5 py-5 -mt-20">
		<div class="bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden" style="max-width: 1000px" >
		  <div class="md:flex w-full">
			<div class="hidden md:block w-1/3 bg-indigo-500 py-10 px-10">
	
				<img
				src="${pageContext.request.contextPath}/resources/images/approve-profile.svg"
				class=" h-full w-full "
				alt="..."
			  />
			</div>
			<div class="bg-white  w-full md:w-2/3 py-10 px-5 md:px-10">
			  <div class="text-center mb-10">
				<h1 class="font-bold text-2xl text-gray-900">Approve Profile</h1><br></br>
		<b><%@ include file="businessMessage.jsp"%></b>
			<div class=row>
				<div class="col">
					<label for="exampleInputEmail1" class="form-label"> <b>FirstName
							:</b></label> <font>${userEntity.firstName}</font>
				</div>
				<div class="col">
					<label for="exampleInputPassword1" class="form-label"><b>LastName
							:</b></label> <font>${userEntity.lastName}</font>
				</div>

			</div>

			<div class=row>
				<div class="col">
					<label for="exampleInputEmail1" class="form-label"> <b>Email
							:</b></label> <font>${userEntity.emailId}</font>
				</div>
				<div class="col">
					<label for="exampleInputPassword1" class="form-label"><b>ContactNo
							:</b></label> <font>${userEntity.phoneNo}</font>
				</div>

			</div>
			<br>
			<h5>Other Specification</h5>
			<hr>
			<c:if test="${userEntity.role.id == 2}">
				<div class=row>
					<div class="col">
						<label for="exampleInputEmail1" class="form-label"> <b>LicenseNo
								:</b></label> <font>${userEntity.doctor.licenseNo}</font>
					</div>
					<div class="col">
						<label for="exampleInputPassword1" class="form-label"><b>PastExprience
								:</b></label> <font>${userEntity.doctor.pastExprience}</font>
					</div>

				</div>

				<div class=row>
					<div class="col">
						<label for="exampleInputEmail1" class="form-label"> <b>TotalExprience
								:</b></label> <font>${userEntity.doctor.totalExprience}</font>
					</div>
					<div class="col">
						<label for="exampleInputPassword1" class="form-label"><b>Specialization
								:</b></label> <font>${userEntity.doctor.specialization}</font>
					</div>
				</div>

			</c:if>

			<c:if test="${userEntity.role.id == 3}">
				<div class=row>
					<div class="col">
						<label for="exampleInputEmail1" class="form-label"> <b>LicenseNo
								:</b></label> <font>${userEntity.shopkeeper.licenceNo}</font>
					</div>
					<div class="col">
						<label for="exampleInputPassword1" class="form-label"><b>ShopName
								:</b></label> <font>${userEntity.shopkeeper.shopName}</font>
					</div>

				</div>

				<div class=row>
					<div class="col">
						<label for="exampleInputEmail1" class="form-label"> <b>Education
								:</b></label> <font>${userEntity.shopkeeper.education}</font>
					</div>
					<div class="col">
						<label for="exampleInputPassword1" class="form-label"><b>ContactNo
								:</b></label> <font>${userEntity.shopkeeper.contactNo}</font>
					</div>
				</div>

				<div class="col">
					<label for="exampleInputPassword1" class="form-label"><b>ShopNo
							:</b></label> <font>${userEntity.shopkeeper.shopNo}</font>
				</div>
				<div class=row>
					<div class="col">
						<label for="exampleInputEmail1" class="form-label"> <b>ShopAddress
								:</b></label> <font>${userEntity.shopkeeper.shopAddress}</font>
					</div>

				</div>

			</c:if>
			<br> <a href="${apUrl}${userEntity.id}"
				class="block w-full max-w-xs mx-auto bg-indigo-500 hover:bg-indigo-700 focus:bg-indigo-700 text-white rounded-lg px-3 py-3 font-semibold">Approve</a>
			</div>
		</div>
	</div>
		</div>
	</div>
</div>
