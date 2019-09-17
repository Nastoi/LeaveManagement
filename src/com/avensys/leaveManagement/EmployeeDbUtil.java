package com.avensys.leaveManagement;

public class EmployeeDbUtil {

	public String ename, job, email, pass, role, req_Id, leaveType, endDate, startDate, reason;
	public int deptNo, empNo, mgr, totalDay, empNo1, mgrNo;
	
	

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

	@Override
	public String toString() {
		return "EmployeeDbUtil [ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", email=" + email + ", pass="
				+ pass + ", deptNo=" + deptNo + ", empNo=" + empNo + "]";
	}


	
	
}
