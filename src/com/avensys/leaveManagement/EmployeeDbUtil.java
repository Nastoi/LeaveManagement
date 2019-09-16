package com.avensys.leaveManagement;

public class EmployeeDbUtil {

	public String ename, job, email, pass, role;
	public int deptNo, empNo, mgr;
	
	
	
	
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

	@Override
	public String toString() {
		return "EmployeeDbUtil [ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", email=" + email + ", pass="
				+ pass + ", deptNo=" + deptNo + ", empNo=" + empNo + "]";
	}


	
	
}
