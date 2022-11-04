<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
	
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>

	<div id="username-page">
		<div class="username-page-container">
			<form id="usernameForm" name="usernameForm">
				
				<input type="hidden" id="name" value="${sessionScope.user.firstName}">
				
				<input type="hidden" id="reciverId" value="${sessionScope.reciverId}">
				<input type="hidden" id="senderId" value="${sessionScope.senderId}">
				
					<button type="submit" class="accent username-submit">Start
						Chatting</button>
				
			</form>
		</div>
	</div>

	<div id="chat-page" class="hidden">
		<div class="chat-container">
			
			<div class="chat-header" style="background-color: blue;">
			<c:if test="${sessionScope.user.role.id == 2}">
				<h5 style="color: white;">${sessionScope.pName}</h5>
				</c:if>
				<c:if test="${sessionScope.user.role.id == 4}">
				<h5 style="color: white;">${sessionScope.docName}</h5>
				</c:if>
				
					<form id="disconnectForm" name="messageForm" nameForm="messageForm">
					<button type="submit" class="primary">Close</button>
					</form>
				
			</div>
			<div class="connecting">Connecting...</div>
			<ul id="messageArea">

			</ul>
			<form id="messageForm" name="messageForm" nameForm="messageForm">
				<div class="form-group">
					<div class="input-group clearfix">
						<input type="text" id="message" placeholder="Type a message..."
							autocomplete="off" class="form-control" />
						<button type="submit" class="primary">Send</button>
					</div>
				</div>
			</form>
		</div>
		
		<br>
	</div>
	

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
