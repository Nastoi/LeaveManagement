$(document).ready(function() {

	var startDate = null;
	var endDate = null;
	
	$('#leaveStartDate').change(function(){
		startDate = moment(new Date($(this).val()));
		if(startDate != null && endDate != null && endDate.diff(startDate, 'days') >= 0) {
			$('#totalLeaveDays').val(endDate.diff(startDate, 'days'));
		}
		else {
			$('#totalLeaveDays').val('1');
		}
	});
	$('#leaveEndDate').change(function(){
		endDate = moment(new Date($(this).val()));
		if(startDate != null && endDate != null && endDate.diff(startDate, 'days') >= 0) {
			$('#totalLeaveDays').val(endDate.diff(startDate, 'days'));
		}
		else {
			$('#totalLeaveDays').val('1');
		}
		});
	
	$('#back').click(function(){
		window.history.back();
	});
	
	$('#cancel').click(function(){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "Cancel leave submission",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Confirm'
			}).then((result) => {
			  if (result.value) {
				  window.history.back();
			  }
			})
	});
	
	$('#logout').click(function(e){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "Logout from Leave Management System",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Logout'
			}).then((result) => {
			  if (result.value) {
				  $.ajax({
					  type: "GET",
					  url: "LeaveController",
					  data: {
						  command: "logout"
					  }
					});
			  }
			})
	});
	
	$('#form').submit(function(){
		var command = $("input#command").val();
		var empNo = $("input#empNo").val();
		var leaveType = $("#leaveType").val();
		var leaveStartDate = $("input#leaveStartDate").val();
		var leaveEndDate = $("input#leaveEndDate").val();
		var totalLeaveDays = $("input#totalLeaveDays").val();
		var leaveReason = $("#leaveReason").val();
		var ename = $("#ename").val();
		var mgr = $("#mgr").val();
		var dataString = 'command=' + command + '&empNo=' + empNo + '&leaveType=' 
		+ leaveType + '&leaveStartDate=' + leaveStartDate 
		+ '&leaveEndDate=' + leaveEndDate + '&totalLeaveDays=' 
		+ totalLeaveDays + '&leaveReason=' + leaveReason
		+ '&ename=' + ename + '&mgr=' + mgr;
		event.preventDefault();
		Swal.fire({
			  title: 'Are you sure?',
			  text: "Submit leave",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Confirm'
			}).then((result) => {
			  if (result.value) {
				  Swal.fire({
					  type: 'success',
					  title: 'Leave Submitted',
					  showConfirmButton: false,
					  timer: 4500
					})
					$( "#form input, textarea, select, #submit, #cancel" ).prop( "disabled", true );
				  	$('#afterSubmit').append("<span class='alert alert-info' role='alert'>Leave request submitted to manager, please wait for approval from manager.</span>");
				  $.ajax({
					  type: "GET",
					  url: "LeaveController",
					  data: dataString
					});
			  }
			})
	});
});