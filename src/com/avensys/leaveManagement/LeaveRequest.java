package com.avensys.leaveManagement;

public class LeaveRequest {

	private String leaveType;
	private String fromDate;
	private String toDate;
	private int totalDays;
	private String reasons;
	private int employeeNo;
	private int mgrNo;
	
	public LeaveRequest(String leaveType, String fromDate, String toDate, int totalDays, String reasons, int employeeNo,
			int mgrNo) {
		super();
		this.leaveType = leaveType;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalDays = totalDays;
		this.reasons = reasons;
		this.employeeNo = employeeNo;
		this.mgrNo = mgrNo;
	}
	
	
	public int getMgrNo() {
		return mgrNo;
	}


	public void setMgrNo(int mgrNo) {
		this.mgrNo = mgrNo;
	}


	public LeaveRequest(String leaveType, String fromDate, String tDate, int totalD, String reason, int employeeNo) {
		this.leaveType = leaveType;
		this.fromDate = fromDate;
		this.toDate = tDate;
		this.totalDays = totalD;
		this.reasons = reason;
		this.employeeNo = employeeNo;
	}


	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	

	
}
