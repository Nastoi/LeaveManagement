package com.avensys.leaveManagement;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class LeaveController
 */
@WebServlet("/LeaveController")
public class LeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/employeeLeaves")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String theCommand = request.getParameter("command");
			if(theCommand == null) {
				theCommand = "LEAVE";
			}
			switch(theCommand) {
			case "LEAVE": 
				leavePage(request,response);
				break;
			case "ADD":
				addLeave(request,response);
				break;
			case "MANAGE":
				managerPage(request,response);
				break;
			case "APPROVE":
				approveLeave(request,response);
				break;
			default:
				leavePage(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			/**
			 * 1. get command value from form
			 * 2. run switch based off command value
			 * 3. run the method for the given command
			 */
			String theCommand = request.getParameter("command");
			if(theCommand == null) {
				theCommand = "LOGIN";
			}
			switch(theCommand) {
			case "LOGIN":
				loginUser(request,response);
				break;
			case "VALIDATE":
				validEmployee(request,response);
				break;
			case "UPDATEPSWD":
				updatePassword(request,response);
				break;
			default:
				loginUser(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	
		private void approveLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			System.out.println(request.getParameter("empNo"));
			System.out.println(request.getParameter("leaveType"));
			System.out.println(request.getParameter("startDate"));
			System.out.println(request.getParameter("endDate"));
			System.out.println(request.getParameter("totalDay"));
			System.out.println(request.getParameter("reason"));
			System.out.println(request.getParameter("mgr"));
			System.out.println(request.getParameter("reqId"));
			
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String leaveType = request.getParameter("leaveType");
			String fromDate = request.getParameter("startDate");
			String tDate = request.getParameter("endDate");
			int totalDay = Integer.parseInt(request.getParameter("totalDay"));
			String reason = request.getParameter("reason");
			int mgrNo = Integer.parseInt(request.getParameter("mgr"));
			int req_Id = Integer.parseInt(request.getParameter("reqId"));
			
			Connection con = null;
	        PreparedStatement pstmt = null;
	        try {
	            con = dataSource.getConnection();
	            String query = "INSERT INTO history(empNo,leaveType,fromDate,toDate,totalDay,reason,mgr,status) VALUES (empNo=?,leaveType=?,fromDate=?,toDate=?,totalDay=?,reason=?,mgr=?,status='approved') ";
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, empNo);
	            pstmt.setString(2, leaveType);
	            pstmt.setString(3, fromDate);
	            pstmt.setString(4, tDate);
	            pstmt.setInt(5, totalDay);
	            pstmt.setString(6, reason);
	            pstmt.setInt(7, mgrNo);
	            
	            pstmt.executeUpdate();
	            
	            String query1 = "DELETE FROM request WHERE req_id=?";
	            pstmt = con.prepareStatement(query1);
	            pstmt.setInt(1, req_Id);
	            
	            pstmt.executeUpdate();
	            
	        	managerPage(request,response);
				
	        }finally {
	            close(con, pstmt, null);
	        }
			
		}
	

		private void managerPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<EmployeeDbUtil> listEmployee = new ArrayList<>();
			EmployeeDbUtil employee = null;
			
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String ename = request.getParameter("ename");
			
			Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            con = dataSource.getConnection();
	            String query = "SELECT * FROM request WHERE mgrNo=?";
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, empNo);
	            rs = pstmt.executeQuery();
	            
	            while(rs.next())
	           	{
	            	String req_Id = rs.getString("req_Id");
	            	String leaveType = rs.getString("leaves_type");
	            	String startDate = rs.getString("start_Date");
	            	String endDate = rs.getString("end_Date");
	            	int totalDay = Integer.parseInt(rs.getString("total_day"));
	            	String reason = rs.getString("reason");
	            	int empNo1 = rs.getInt("empNo");
	            	int mgrNo = rs.getInt("mgrNo");
	            	
	            	employee = new EmployeeDbUtil(req_Id, leaveType, startDate, endDate, totalDay, reason, empNo1, mgrNo);
	            	listEmployee.add(employee);
	          	}
	            
	            request.setAttribute("TEAM_LIST", listEmployee);
	            request.setAttribute("Id",empNo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/manager_leave.jsp");
				dispatcher.forward(request, response);
				
	        }finally {
	            close(con, pstmt, rs);
	        }
	        
		}


		private void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			String password = request.getParameter("password");
			String cnfmpswd = request.getParameter("cnfmpswd");
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			
			if(password.equals(cnfmpswd))
			{
				Connection con = null;
		        PreparedStatement pstmt = null;
		        try {
		            con = dataSource.getConnection();
		            String query = "UPDATE employee SET password=? WHERE empno=?";
		            pstmt = con.prepareStatement(query);
		            pstmt.setString(1, password);
		            pstmt.setInt(2, empNo);
		            pstmt.execute();
		            
					RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmChange.jsp");
					dispatcher.forward(request, response);
					
		        }finally {
		            close(con, pstmt, null);
		        }
		    }
			else {
		
			request.setAttribute("errro", "password is not matching");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
			dispatcher.forward(request, response);
			}
			
			
	}

		private void validEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
				int emp_no = Integer.parseInt(request.getParameter("empno"));
			
				Connection con = null;
		        PreparedStatement pstmt = null;
		        try {
		            con = dataSource.getConnection();
		            String query = "SELECT empNo FROM employee WHERE empNo=?";
		            pstmt = con.prepareStatement(query);
		            pstmt.setInt(1, emp_no);
		            boolean rs = pstmt.execute();
		            
		            if(rs==false)
		            {
		            	RequestDispatcher dispatcher = request.getRequestDispatcher("/forgetpwd.jsp");
						request.setAttribute("error", "this is not a valid id.");
						dispatcher.forward(request, response);
		            }
		            else if(rs==true)
		            {
		            	RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
						request.setAttribute("Id", emp_no);
						dispatcher.forward(request, response);
		            }
		            
		        }finally {
		            close(con, pstmt, null);
		        }
				
				
			
				
		
	}

		private void addLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			int employNo = Integer.parseInt(request.getParameter("empNo"));
			String leaveType = request.getParameter("leaveType");
			String fromDate = request.getParameter("fromDate");
			String tDate = request.getParameter("toDate");
			int totalDay = Integer.parseInt(request.getParameter("totalDay"));
			String reason = request.getParameter("reason");
			int mgrNo = Integer.parseInt(request.getParameter("mgr"));
			//Date frmDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(fromDate);
			//Date toDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(tDate);
			String ename = request.getParameter("ename");
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con=dataSource.getConnection();
				String qry = "insert into employeeleaves.request (leaves_type,start_Date, end_Date,total_day,reason,empNo, mgrNo) values (?, ?, ?, ?, ?, ?, ?)";
				pstmt= con.prepareStatement(qry);
				pstmt.setString(1, leaveType);
				pstmt.setString(2, fromDate);
				pstmt.setString(3, tDate);
				pstmt.setInt(4, totalDay);
				pstmt.setString(5, reason);
				pstmt.setInt(6, employNo);
				pstmt.setInt(7, mgrNo);
				
				pstmt.execute();
				System.out.println("Inserted");
				
				getUser(request,response);
			}
			finally {
				close(con, pstmt, null);
			}
			
				
		
	}

		private void getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String qry="select * from employee where empno=?";
			
				// Create the connection
				con = dataSource.getConnection();
				//System.out.println("Connection established successfully");
				pstmt = con.prepareStatement(qry);
				pstmt.setInt(1, empNo);
				rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					
					String ename = rst.getString("ename");
					int empNo1 = empNo;
					int mgr = rst.getInt("mgr");
					
					EmployeeDbUtil  employee = new EmployeeDbUtil(ename,empNo1,mgr);
					
					
					request.setAttribute("User", employee );
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee_Welcome.jsp");
					
					dispatcher.forward(request, response);
			
				}
			
		}

		private void close(Connection con, Statement stmt, ResultSet rs) throws SQLException {
				if(rs!=null)
				{
					rs.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(con!=null)
				{
					con.close();
				}
		}

		
		private void leavePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String ename = request.getParameter("ename");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			
			EmployeeDbUtil  employee = new EmployeeDbUtil(ename,empNo, mgr);
			
			
			request.setAttribute("User", employee );
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee_leave.jsp");
			
			dispatcher.forward(request, response);
		
	}

		private void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
			// Check whether this servlet is getting called or not
			//System.out.println("***************");
			
			// Fetch the values from the form data
			int empNo = Integer.parseInt(request.getParameter("empno"));
			String pass = request.getParameter("pass");
			
			//System.out.println(empNo+"**************"+pass);
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String qry="select * from employee where empno = ? and password= ?";
			
				// Create the connection
				con = dataSource.getConnection();
				//System.out.println("Connection established successfully");
				pstmt = con.prepareStatement(qry);
				pstmt.setInt(1, empNo);
				pstmt.setString(2, pass);
				rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					System.out.println("Congratulations......");
					
					String ename = rst.getString("ename");
					int empno = empNo;
					int mgr = rst.getInt("mgr");
					
					EmployeeDbUtil  employee = new EmployeeDbUtil(ename,empNo,mgr);
					
					
					request.setAttribute("User", employee );
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee_Welcome.jsp");
					
					dispatcher.forward(request, response);
				}
				else
				{
					System.out.println("EmpNo or Password is incorrect");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
					
					dispatcher.forward(request, response);
					
				}

	}
		
}
