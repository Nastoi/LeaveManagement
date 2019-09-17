<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Form</title>
</head>
<body>

	<form action="LeaveController" >
		<input type="hidden" name="command" value="ADD">
		<input type="hidden" name="ename" value="${ User.ename }">
		<input type="hidden" name="empNo" value="${ User.empNo }">
		<input type="hidden" name="mgr" value="${ User.mgr }"/>
		<select name="leaveType">
			<option value="maternity">Maternity Leave</option>
			<option value="sick">Sick Leave</option>
			<option value="hospitalized">Hospitalized leave</option>
		</select><br>
		<br> From date: <input type="text" name="fromDate"><br>
		<br> To date: <input type="text" name="toDate"><br>
		<br> Total days: <input type="number" name="totalDay"><br>
		<br> Reason: <textarea rows="4" cols="50" name="reason"> 

</textarea>
		<br>
		<br>
		<input type="submit" value="SAVE">
	</form>

</body>
</html>