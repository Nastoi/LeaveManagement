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
			case "BACK":
				getUser(request,response);
			case "REJECT":
				rejectLeave(request,response);
			case "DISPLAYAPPROVED":
				displayApprovedLeaves(request,response);
				break;
			case "DISPLAYREJECTED":
				displayRejectedLeaves(request,response);
				break;
			default:
				leavePage(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}



	private void displayRejectedLeaves(HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception, IOException {
		// TODO Auto-generated method stub
		List<EmployeeDbUtil> listEmployee = new ArrayList<>();
		EmployeeDbUtil employee = null;
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            String query = "SELECT * FROM history WHERE status='reject'";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next())
           	{
            	String req_Id = rs.getString("hist_id");
            	String leaveType = rs.getString("leaveType");
            	String startDate = rs.getString("fromDate");
            	String endDate = rs.getString("toDate");
            	int totalDay = Integer.parseInt(rs.getString("totalDay"));
            	String reason = rs.getString("reason");
            	int empNo1 = rs.getInt("empNo");
            	int mgrNo = rs.getInt("mgr");
            	String status = rs.getString("status");
            	
            	employee = new EmployeeDbUtil(req_Id, leaveType, startDate, endDate, totalDay, reason, empNo1, mgrNo,status);
            	listEmployee.add(employee);
          	}
            
            request.setAttribute("TEAM_APPROVED_DECLINED_LIST", listEmployee);
  
			RequestDispatcher dispatcher = request.getRequestDispatcher("/manager_approved_declined_list.jsp");
			dispatcher.forward(request, response);
			
        }finally {
            close(con, pstmt, rs);
        }
	}

	private void displayApprovedLeaves(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<EmployeeDbUtil> listEmployee = new ArrayList<>();
		EmployeeDbUtil employee = null;
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            String query = "SELECT * FROM history WHERE status='approved'";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next())
           	{
            	String req_Id = rs.getString("hist_id");
            	String leaveType = rs.getString("leaveType");
            	String startDate = rs.getString("fromDate");
            	String endDate = rs.getString("toDate");
            	int totalDay = Integer.parseInt(rs.getString("totalDay"));
            	String reason = rs.getString("reason");
            	int empNo1 = rs.getInt("empNo");
            	int mgrNo = rs.getInt("mgr");
            	String status = rs.getString("status");
            	
            	employee = new EmployeeDbUtil(req_Id, leaveType, startDate, endDate, totalDay, reason, empNo1, mgrNo,status);
            	listEmployee.add(employee);
          	}
            
            request.setAttribute("TEAM_APPROVED_DECLINED_LIST", listEmployee);
  
			RequestDispatcher dispatcher = request.getRequestDispatcher("/manager_approved_declined_list.jsp");
			dispatcher.forward(request, response);
			
        }finally {
            close(con, pstmt, rs);
        }
	}

	private void rejectLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int req_Id = Integer.parseInt(request.getParameter("reqId"));
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		String leaveType = request.getParameter("leaveType");
		String fromDate = request.getParameter("startDate");
		String tDate = request.getParameter("endDate");
		int totalDay = Integer.parseInt(request.getParameter("totalDay"));
		String reason = request.getParameter("reason");
		int mgrNo = Integer.parseInt(request.getParameter("mgr"));
        String mgrEmail = null;
        String empEmail = null;
		String text= "Dear employee " 
	            + "\n\n Your leave has been reject!"
	    		+ "\n Please continue to work hard!"
	            + "\n We will not let you go until you finish your spring project"
	    		+ "\n See what level, you jump"
	    		+ "\n\n Regards"
	            + "\n Mr Deepanshu Rastogi";
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rst =null;
        
        try {
        	
        	 con = dataSource.getConnection();
	            String query = "INSERT INTO history(empNo,leaveType,fromDate,toDate,totalDay,reason,mgr,status) VALUES(?,?,?,?,?,?,?,'reject') ";
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, empNo);
	            pstmt.setString(2, leaveType);
	            pstmt.setString(3, fromDate);
	            pstmt.setString(4, tDate);
	            pstmt.setInt(5, totalDay);
	            pstmt.setString(6, reason);
	            pstmt.setInt(7, mgrNo);
	            
	            pstmt.executeUpdate();
	            
	            String query1 = "DELETE FROM request WHERE req_Id=? ";
	            pstmt = con.prepareStatement(query1);
	            pstmt.setInt(1, req_Id);
	            
	            pstmt.executeUpdate();
            
	            String query2 = "SELECT email FROM employee WHERE empNo=?";
	            pstmt = con.prepareStatement(query2);
                pstmt.setInt(1, mgrNo);
                rst = pstmt.executeQuery();
                if(rst.next())
                {
                mgrEmail = rst.getString("email");
                }
                
                String query3 = "SELECT email FROM employee WHERE empNo=?";
                pstmt = con.prepareStatement(query3);
                pstmt.setInt(1, empNo);
                rst = pstmt.executeQuery();
                if(rst.next())
                {
                	empEmail = rst.getString("email");
                }
                
                SendEmail sm = new SendEmail();
                sm.sendMail(mgrEmail, empEmail, text);

                
				
	        }finally {
	        	managerPage(request,response);
	            close(con, pstmt, rst);
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
			
			
			int empNo = Integer.parseInt(request.getParameter("empNo1"));
			String leaveType = request.getParameter("leaveType");
			String fromDate = request.getParameter("startDate");
			String tDate = request.getParameter("endDate");
			int totalDay = Integer.parseInt(request.getParameter("totalDay"));
			String reason = request.getParameter("reason");
			int mgrNo = Integer.parseInt(request.getParameter("mgr"));
			int req_Id = Integer.parseInt(request.getParameter("reqId"));
			
			Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rst = null;
	        String mgrEmail = null;
	        String empEmail = null;
	        String text= "Dear employee " 
            + "\n\n Your leave has been approved!"
    		+ "\n Please enjoy your leave while you can!"
            + "\n We will be waiting for you eagerly to come home"
    		+ "\n You wait, meet me downstairs"
            + "\n\n These are your leave information"
    		+ "\n leave type: " + leaveType
    		+ "\n start date: " + fromDate
    		+ "\n end date: " + tDate
    		+ "\n reason : " + reason
    		+ "\n\n Regards"
            + "\n Mr Deepanshu Rastogi";
	        
	        try {
	            con = dataSource.getConnection();
	            String query = "INSERT INTO history(empNo,leaveType,fromDate,toDate,totalDay,reason,mgr,status) VALUES(?,?,?,?,?,?,?,'approved') ";
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
	         
	            
	            String query2 = "SELECT email FROM employee WHERE empNo=?";
	            pstmt = con.prepareStatement(query2);
                pstmt.setInt(1, mgrNo);
                rst = pstmt.executeQuery();
                if(rst.next())
                {
                mgrEmail = rst.getString("email");
                }
                
                String query3 = "SELECT email FROM employee WHERE empNo=?";
                pstmt = con.prepareStatement(query3);
                pstmt.setInt(1, empNo);
                rst = pstmt.executeQuery();
                if(rst.next())
                {
                	empEmail = rst.getString("email");
                }
                
                
               switch(leaveType)
                {
                case "casual_leave" :
                	String casual_leave = "UPDATE employee SET casual_leave = casual_leave-? WHERE empNo=?";
                	pstmt = con.prepareStatement(casual_leave);
                    pstmt.setInt(1, totalDay);
                    pstmt.setInt(2, empNo);
                    pstmt.executeUpdate();
                	break;
                case "sick_leave" :
                	String sick_leave = "UPDATE employee SET sick_leave = sick_leave-? WHERE empNo=?";
                	pstmt = con.prepareStatement(sick_leave);
                    pstmt.setInt(1, totalDay);
                    pstmt.setInt(2, empNo);
                    pstmt.executeUpdate();
                	break;
                case "paternity_leave" :
                	String paternity_leave = "UPDATE employee SET paternity_leave = paternity_leave-? WHERE empNo=?";
                	pstmt = con.prepareStatement(paternity_leave);
                    pstmt.setInt(1, totalDay);
                    pstmt.setInt(2, empNo);
                    pstmt.executeUpdate();
                	break;
                case "maternity_leave" :
                	String maternity_leave = "UPDATE employee SET maternity_leave = maternity_leave-? WHERE empNo=?";
                	pstmt = con.prepareStatement(maternity_leave);
                    pstmt.setInt(1, totalDay);
                    pstmt.setInt(2, empNo);
                    pstmt.executeUpdate();
                	break;
                case "compensate_leave" :
                	String compensate_leave = "UPDATE employee SET compensate_leave = compensate_leave-? WHERE empNo=?";
                	pstmt = con.prepareStatement(compensate_leave);
                    pstmt.setInt(1, totalDay);
                    pstmt.setInt(2, empNo);
                    pstmt.executeUpdate();
                	break;
                default:
                	
                }
                
               SendEmail sm = new SendEmail();
               sm.sendMail(mgrEmail, empEmail, text);
               
	        }finally {
	        	
                managerPage(request,response);
	            close(con, pstmt, rst);
	        }
	        
			
		}
	

		private void managerPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<EmployeeDbUtil> listEmployee = new ArrayList<>();
			EmployeeDbUtil employee = null;
			
			System.out.println(Integer.parseInt(request.getParameter("mgr")));
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String ename = request.getParameter("ename");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			
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
	            
	            employee = new EmployeeDbUtil(empNo,mgr);
	            	
	            request.setAttribute("TEAM_LIST", listEmployee);
	            request.setAttribute("User",employee);
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
		
			request.setAttribute("error", "password is not matching");
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
			
	            String ename = request.getParameter("ename");
	            int employNo = Integer.parseInt(request.getParameter("empNo"));
	            String leaveType = request.getParameter("leaveType");
	            String fromDate = request.getParameter("leaveStartDate");
	            String tDate = request.getParameter("leaveEndDate");
	            int totalDay = Integer.parseInt(request.getParameter("totalLeaveDays"));
	            String reason = request.getParameter("leaveReason");
	            int mgrNo = Integer.parseInt(request.getParameter("mgr"));
	            //Date frmDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(fromDate);
	            //Date toDate = (Date) new SimpleDateFormat("YYYY/MM/DD").parse(tDate);

	            Connection con = null;
		        PreparedStatement pstmt = null;
		        ResultSet rst = null;
		        String mgrEmail = null;
		        String empEmail = null;
		        String text= "Dear Manager In-Charge " 
	            + "\n\n Your employee has sent a leave request!"
	    		+ "\n Please try not to approve but you can approve if you want!"
	            + "\n We will be watching you"
	    		+ "\n Who will kill??? Me"
	    		+ "\n\n Regards"
	            + "\n Mr Deepanshu Rastogi";

	            try {
	                con=dataSource.getConnection();
	                String qry = "insert into employeeleaves.request (leaves_type,start_Date, end_Date,total_day,reason,empNo, mgrNo,status) values (?, ?, ?, ?, ?, ?, ?,'pending')";
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


		         
		            
		            String query2 = "SELECT email FROM employee WHERE empNo=?";
		            pstmt = con.prepareStatement(query2);
	                pstmt.setInt(1, mgrNo);
	                rst = pstmt.executeQuery();
	                if(rst.next())
	                {
	                mgrEmail = rst.getString("email");
	                }
	                
	                String query3 = "SELECT email FROM employee WHERE empNo=?";
	                pstmt = con.prepareStatement(query3);
	                pstmt.setInt(1, employNo);
	                rst = pstmt.executeQuery();
	                if(rst.next())
	                {
	                	empEmail = rst.getString("email");
	                }
	                
	                System.out.println(leaveType);
	                
	                SendEmail sm = new SendEmail();
	                sm.sendMail(mgrEmail, empEmail, text);

	                managerPage(request,response);

	    }
			
				
	

		private void getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			int mgr1 = Integer.parseInt(request.getParameter("mgr"));
			
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
				EmployeeDbUtil employee= null;
				
				if(rst.next())
				{
					
					String ename = rst.getString("ename");
					int empno = empNo;
					int mgr = rst.getInt("mgr");
					String role = rst.getString("role");
					int casual_leave = rst.getInt("casual_leave");
					int sick_leave = rst.getInt("sick_leave");
					int paternity_leave = rst.getInt("paternity_leave");
					int maternity_leave = rst.getInt("maternity_leave");
					int compensate_leave = rst.getInt("compensate_leave");
					
					employee = new EmployeeDbUtil(ename,empNo,mgr,role,casual_leave, sick_leave, paternity_leave, maternity_leave, compensate_leave);
					
					
					request.setAttribute("User", employee );
					
					String qry1="select ename from employee where empno = ?";
					pstmt = con.prepareStatement(qry1);
					pstmt.setInt(1, mgr1);
					rst=pstmt.executeQuery();
					if(rst.next())
					{
						String mgrName = rst.getString("ename");
						request.setAttribute("mgrName", mgrName);
					}
					
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
			EmployeeDbUtil employee= null;
				// Create the connection
				con = dataSource.getConnection();
				//System.out.println("Connection established successfully");
				pstmt = con.prepareStatement(qry);
				pstmt.setInt(1, empNo);
				pstmt.setString(2, pass);
				rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					employee = new EmployeeDbUtil();
					String ename = rst.getString("ename");
					int mgr = rst.getInt("mgr");
					String role = rst.getString("role");
					int casual_leave = rst.getInt("casual_leave");
					int sick_leave = rst.getInt("sick_leave");
					int paternity_leave = rst.getInt("paternity_leave");
					int maternity_leave = rst.getInt("maternity_leave");
					int compensate_leave = rst.getInt("compensate_leave");
					
							//employee = new EmployeeDbUtil(ename,empNo,mgr,role);
					employee = new EmployeeDbUtil(ename,empNo,mgr,role,casual_leave, sick_leave, paternity_leave, maternity_leave, compensate_leave);
					
					request.setAttribute("User", employee );
					
					String qry1="select ename from employee where empno = ?";
					pstmt = con.prepareStatement(qry1);
					pstmt.setInt(1, mgr);
					rst=pstmt.executeQuery();
					if(rst.next())
					{
						String mgrName = rst.getString("ename");
						request.setAttribute("mgrName", mgrName);
					}
					
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
