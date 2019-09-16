package com.avensys.leaveManagement;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

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
			default:
				loginUser(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	
		private void addLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			
			int employNo = Integer.parseInt(request.getParameter("empNo"));
			String leaveType = request.getParameter("leaveType");
			String fromDate = request.getParameter("fromDate");
			String tDate = request.getParameter("toDate");
			int totalDays = Integer.getInteger(request.getParameter("totalDays"));
			String reason = request.getParameter("reason");
			int mgrNo = Integer.parseInt(request.getParameter("mgr"));
			//Date frmDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(fromDate);
			//Date toDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(tDate);
			
			
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con=dataSource.getConnection();
				String qry = "insert into employee_leaves.request (leaves_type,start_Date, end_Date,total_day,reason,empNo, mgrNo) values (?, ?, ?, ?, ?, ?, ?)";
				pstmt= con.prepareStatement(qry);
				pstmt.setString(1, leaveType);
				pstmt.setString(2, fromDate);
				pstmt.setString(3, tDate);
				pstmt.setInt(4, totalDays);
				pstmt.setString(5, reason);
				pstmt.setInt(6, employNo);
				pstmt.setInt(7, mgrNo);
				
				pstmt.execute();
				System.out.println("inserted");
			
			}
			finally {
				close(con, pstmt, null);
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
			
			EmployeeDbUtil  employee = new EmployeeDbUtil(ename,empNo);
			
			
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
					//String role = rst.getString("Role");
					
					EmployeeDbUtil  employee = new EmployeeDbUtil(ename,empNo);
					
					
					request.setAttribute("User", employee );
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee_Welcome.jsp");
					
					dispatcher.forward(request, response);
				}
				else
				{
					System.out.println("EmpNo or Password is incorrect");
					
				}

	}
		
}
