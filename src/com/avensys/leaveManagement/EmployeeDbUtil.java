package com.avensys.leaveManagement;

public class EmployeeDbUtil {

	public String ename, job, email, pass, role, req_Id, leaveType, endDate, startDate, reason, status, mgr1;
	public int deptNo, empNo, mgr, totalDay, empNo1, mgrNo,casual_leave, sick_leave, paternity_leave,maternity_leave,compensate_leave;

	

	public EmployeeDbUtil(String req_Id, String leaveType, String startDate, String endDate, int totalDay,
			String reason, int empNo, int mgrNo,String status) {
		this.req_Id = req_Id;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalDay = totalDay;
		this.reason = reason;
		this.empNo = empNo;
		this.mgrNo = mgrNo;
		this.status = status;
	}
	public EmployeeDbUtil(String req_Id, String leaveType, String startDate, String endDate, int totalDay,
			String reason, int empNo, int mgrNo) {
		this.req_Id = req_Id;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalDay = totalDay;
		this.reason = reason;
		this.empNo = empNo;
		this.mgrNo = mgrNo;
	}
	
	public EmployeeDbUtil(String ename, String job, int mgr, String email, String pass, int deptNo, int empNo, String role) {
		super();
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.email = email;
		this.pass = pass;
		this.deptNo = deptNo;
		this.empNo = empNo;
		this.role = role;
	}
	
	public EmployeeDbUtil(String ename, int empNo, String role) {
		this.ename = ename;
		this.empNo = empNo;
		this.role = role;
	}
	
	public EmployeeDbUtil(String ename, int empNo) {
		this.ename = ename;
		this.empNo = empNo;
	}


	public EmployeeDbUtil() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDbUtil(String ename, int empNo, int mgr) {
		this.ename = ename;
		this.empNo = empNo;
		this.mgr =mgr;
	}

	public EmployeeDbUtil(String ename, int empNo, int mgr, String role) {
		this.ename = ename;
		this.empNo = empNo;
		this.mgr = mgr;
		this.role = role;
	}
	
	public EmployeeDbUtil(String ename, int empNo, String mgr, String role) {
		this.ename = ename;
		this.empNo = empNo;
		this.mgr1 = mgr;
		this.role = role;
	}

	public EmployeeDbUtil(String ename, int empNo, int mgr, String role, int casual_leave, int sick_leave, int paternity_leave, int maternity_leave, int compensate_leave) {
		this.ename = ename;
		this.empNo = empNo;
		this.mgr = mgr;
		this.role = role;
		this.casual_leave = casual_leave;
		this.sick_leave = sick_leave;
		this.maternity_leave = maternity_leave;
		this.paternity_leave = paternity_leave;
		this.compensate_leave = compensate_leave;
		
	}
	
	public EmployeeDbUtil(int empNo, String ename) {
		this.empNo = empNo;
		this.ename = ename;
	}
	public EmployeeDbUtil(int empNo, int mgr) {
		this.empNo = empNo;
		this.mgr = mgr;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getReq_Id() {
		return req_Id;
	}

	public void setReq_Id(String req_Id) {
		this.req_Id = req_Id;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	public int getEmpNo1() {
		return empNo1;
	}

	public void setEmpNo1(int empNo1) {
		this.empNo1 = empNo1;
	}

	public int getMgrNo() {
		return mgrNo;
	}

	public void setMgrNo(int mgrNo) {
		this.mgrNo = mgrNo;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMgr1() {
		return mgr1;
	}
	public void setMgr1(String mgr1) {
		this.mgr1 = mgr1;
	}
	public int getCasual_leave() {
		return casual_leave;
	}
	public void setCasual_leave(int casual_leave) {
		this.casual_leave = casual_leave;
	}
	public int getSick_leave() {
		return sick_leave;
	}
	public void setSick_leave(int sick_leave) {
		this.sick_leave = sick_leave;
	}
	public int getPaternity_leave() {
		return paternity_leave;
	}
	public void setPaternity_leave(int paternity_leave) {
		this.paternity_leave = paternity_leave;
	}
	public int getMaternity_leave() {
		return maternity_leave;
	}
	public void setMaternity_leave(int maternity_leave) {
		this.maternity_leave = maternity_leave;
	}
	public int getCompensate_leave() {
		return compensate_leave;
	}
	public void setCompensate_leave(int compensate_leave) {
		this.compensate_leave = compensate_leave;
	}
	@Override
	public String toString() {
		return "EmployeeDbUtil [ename=" + ename + ", job=" + job + ", email=" + email + ", pass=" + pass + ", role="
				+ role + ", req_Id=" + req_Id + ", leaveType=" + leaveType + ", endDate=" + endDate + ", startDate="
				+ startDate + ", reason=" + reason + ", status=" + status + ", deptNo=" + deptNo + ", empNo=" + empNo
				+ ", mgr=" + mgr + ", totalDay=" + totalDay + ", empNo1=" + empNo1 + ", mgrNo=" + mgrNo + "]";
	}


	
	
}
