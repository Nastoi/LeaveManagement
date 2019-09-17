<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Manager Leave Approval Page</title>
</head>
<body>

<!--<c:url var="tempLink" value="EmployeeController">
			<c:param name="command" value="DISPLAYTEAM"/>
			<c:param name="studentId" value="${ temp.id }"/></c:url> -->
			
	<!-- <form name="manager" Method="GET">
	<input type="button" value="DISPLAYTEAM" name="command" > -->
	
	
	
<table border="1">	
	
		<tr>
			<th>Leave Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>No of days</th>
			<th>Reason</th>
			<th>Employee no</th>
		<tr>
		<c:forEach var="temp" items="${ TEAM_LIST }">
		<tr>
			<td>${ temp.leaveType }</td>
			<td>${ temp.startDate }</td>
			<td>${ temp.endDate }</td>
			<td>${ temp.totalDay }</td>
			<td>${ temp.reason }</td>
			<td>${ temp.empNo }</td>
			
			<c:url var="Approve" value="LeaveController">
				<c:param name="command" value="APPROVE" />
				<c:param name="leaveType" value="${ temp.leaveType }"/>
				<c:param name="startDate" value="${ temp.startDate }"/>
				<c:param name="endDate" value="${ temp.endDate }"/>
				<c:param name="totalDay" value="${ temp.totalDay }"/>
				<c:param name="reason" value="${ temp.reason }"/>
				<c:param name="empNo" value="${ temp.empNo }"/>
				<c:param name="reqId" value="${ temp.req_Id }" />
				<c:param name="mgr" value="${ Id }"/>
				<c:param name="empNo" value="${ Id }" />
				<c:param name="status" value="approve" />
			</c:url>
			
			<td><a href="${ Approve }">Approve</a></td>
			<td><a href="#">Reject</a></td>
		</tr>
		</c:forEach>
		
</table>
<input type="hidden" name="mgr" value="${ temp.mgrNo }">
</body>
</html>