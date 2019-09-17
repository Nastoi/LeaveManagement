<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Manager Leave Approval Page</title>
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
       
</head>
<body>
<jsp:include page="header.jsp"/>
<!--<c:url var="tempLink" value="EmployeeController">
			<c:param name="command" value="DISPLAYTEAM"/>
			<c:param name="studentId" value="${ temp.id }"/></c:url> -->
			
	<!-- <form name="manager" Method="GET">
	<input type="button" value="DISPLAYTEAM" name="command" > -->
	
	
	<div class="container" style="margin-top: 150px; margin-left: 40px;">
        <table class="table table-hover">
          <thead >
              
            <tr>
            <th scope="col" class="text-center">S.No</th>
              <th scope="col" class="text-center">Leave Type</th>
              <th scope="col" class="text-center">From</th>
              <th scope="col" class="text-center">Till</th>
              <th scope="col" class="text-center">Number Of Days</th>
              <th scope="col" class="text-center">Reason</th>
              <th scope="col" class="text-center">Employee Number</th>
              <th scope="col" class="text-center">Actions</th>
            </tr>
          </thead>
            
                
          <tbody>
            <c:forEach var="temp" items="${ TEAM_LIST }">
                <tr>
                  <th scope="row" class="text-center">${ temp.req_Id }</th>
                  <td class="text-center">${ temp.leaveType }</td> 
                  <td class="text-center">${ temp.startDate }</td>
                  <td class="text-center">${ temp.endDate }</td>
                  <td class="text-center">${ temp.totalDay }</td>
                  <td class="text-center">${ temp.reason }</td>
                  <td class="text-center">${ temp.empNo }</td>
                 
                 
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
			
					<c:url var="Reject" value="LeaveController">
						<c:param name="command" value="REJECT" />
						<c:param name="empNo" value="${ Id }" />
						<c:param name="reqId" value="${ temp.req_Id }" />
					</c:url>
					
                  <td class="text-center"><button type="button" class="btn btn-primary" value="${ Approve }">Approve</button>&nbsp;
                  <button type="button" class="btn btn-danger" value="${ Reject }">Decline</button></td>
                </tr> 
             </c:forEach>
          </tbody>
        </table>
</div>
		
		
<input type="hidden" name="mgr" value="${ temp.mgrNo }">
</body>
</html>