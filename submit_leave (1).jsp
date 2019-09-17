<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<!-- Optional: include a polyfill for ES6 Promises for IE11 and Android browser -->
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="script.js"></script>

<title>HR Login</title>
<style>
body {
	height: 100vh;
	padding-top: 75px;
}
</style>
</head>

<body>

	<!-- URL Parameters for Cancel, Back and Logout -->
	<c:url var="back" value="LeaveController">
		<c:param name="command" value="back" />
		<c:param name="id" value="${ employee.getId() }" />
	</c:url>

	<div class="container h-100">
		<div class="row h-100">
			<div class="col-md-12 mx-auto">
				<div class="row">
					<div class="col-md-12 mb-2">
						<img class="float-right" src="" width="" height=""
							alt="Logo Placeholder">
						<div class="float-left">
							<h4>Name: "${ empNo }"</h4>
							<h4>Employee ID: "${ empNo }"</h4>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mt-2 mb-3" id="afterSubmit"></div>
				</div>
				<form id="form" action="LeaveController" method="GET"
					style="background-color: #EDF5E1; padding: 40px">
					<input type="hidden" id="command" name="command" value="ADD"> 
					<input type="hidden" id="empNo" name="empNo" value="${ empNo }">
					<input type="hidden" id="mgr" name="mgr" value="${ mgr }">
					<input type="hidden" id="ename" name="ename" value="${ ename }">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="leaveType">Leave Type</label> <select
								name="leaveType" class="form-control" id="leaveType" required>
								<option>Casual Leave</option>
								<option>Sick Leave</option>
								<option>Paternity Leave</option>
								<option>Maternity Leave</option>
								<option>Compensate Leave</option>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="leaveStartDate">From Date</label> <input type="date"
								name="leaveStartDate" class="form-control" id="leaveStartDate"
								aria-describedby="leaveStartDate"
								placeholder="Enter leave start date" required> <small
								id="leaveStartDate" class="form-text text-muted">Please
								enter leave starting date.</small>
						</div>
						<div class="form-group col-md-4">
							<label for="leaveEndDate">To Date</label> <input type="date"
								name="leaveEndDate" class="form-control" id="leaveEndDate"
								aria-describedby="leaveEndDate" placeholder="Enter leave end date"
								required> <small id="leaveEndDate"
								class="form-text text-muted">Please enter leave ending
								date.</small>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group offset-md-4 col-md-6">
							<label for="totalLeaveDays">Total leave days</label> <input
								name="totalLeaveDays" type="text" class="form-control" id="totalLeaveDays"
								aria-describedby="totalLeaveDays"
								placeholder="Enter no. of days" readonly required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group offset-md-4 col-md-8">
							<label for="leaveReason">Reason:</label>
							<textarea name="leaveReason" class="form-control" id="leaveReason" rows="3" required></textarea>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<button id="submit" type="submit"
								class="btn btn-dark mb-2 float-right">Submit</button>
							<button id="cancel" type="button"
								class="btn btn-dark mb-2 mr-2 float-right">Cancel</button>
						</div>
					</div>
				</form>
				<div class="row">
					<div class="col-md-12 pb-3">
						<button id="back" type="button"
							class="btn btn-light mt-3 float-left">
							Back
						</button>
						<button id="logout" type="button"
							class="btn btn-light mt-3 float-right">
							Logout
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
