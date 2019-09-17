<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css" />
    
        <style>
        
    body{
                background-image: url(bkg-blu.png);
                background-size: cover;
                
        }
    
    #tab1{
              
            max-width: 500px;
            max-height: 500px;
            margin-left:30px;; 
            margin-top:150px;
            text-align: center;
        
    }
       
        #tab2{
              
            max-width: 500px;
            max-height: 500px;
            margin-left:30px;; 
            margin-top:20px;
            text-align: center;
    }
         header {
              width: 100%;
              height: 130px;
              overflow: hidden;
              position: fixed;
              top: 0;
              left: 0;
              z-index: 999;
              background-color: #0683c9;
              -webkit-transition: height 0.3s;
              -moz-transition: height 0.3s;
              -ms-transition: height 0.3s;
              -o-transition: height 0.3s;
              transition: height 0.3s; 
            }
              header h1#logo {
                display: inline-block;
                height: 150px;
                line-height: 150px;
                float: left;
                  
                font-family: "Oswald", sans-serif;
                font-size: 50px;
                color: white;
                font-weight: 400;
                -webkit-transition: all 0.3s;
                -moz-transition: all 0.3s;
                -ms-transition: all 0.3s;
                -o-transition: all 0.3s;
                transition: all 0.3s; 
            }
              

    </style>
    
  </head>
  <body>
  
        <jsp:include page="header.jsp"/>
        
        
        
        
        
        <table class="table table-bordered table-hover" id="tab1">
                <thead>
                  <tr>
                    <th style="color: brown">S.No</th>
                    <th style="color: brown">Leave Type</th>
                    <th style="color: brown">Remaining(<b>In Days</b>)</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <th>Casual Leaves</th>
                    <td>6</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <th>Sick Leaves</th>
                    <td>6</td>
                  </tr>
                <tr>
                    <th scope="row">3</th>
                    <th>Maternity Leaves</th>
                    <td>60</td>
                  </tr>
                <tr>
                    <th scope="row">4</th>
                    <th>Paternity Leaves</th>
                    <td>10</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <th>Compensate Leaves</th>
                    <td>10</td>
                </tr>
                </tbody>
              </table>
              
              <h3 style="margin-left: 30px; color: brown">Personal Information</h3>
      <table class="table table-bordered table-hover" id="tab2">

                <tbody>


                  <tr>
                        <th scope="row">1 </th>
                    <th scope="row">Emp Name</th>

                    <td>${ User.ename }</td>
                  </tr>
                  <tr>
                        <th scope="row">2 </th>
                    <th scope="row">Emp No</th>
                    <td>${ User.empNo }</td>
                  </tr>
                  <tr>
                        <th scope="row">3 </th>
                        <th scope="row">Reporting Manager</th>
                        <td></td>
                      </tr>
                      <tr>
                            <th scope="row">4 </th>
                            <th scope="row">Manager No</th>
                            <td>${ User.mgr }</td>
                          </tr>
                          <tr>
                                <th scope="row">5 </th>
                                <th scope="row">Designation</th>
                                <td>${ User.role }</td>
                              </tr>
                </tbody>
              </table>
              
              
              
              
              
              
      <div class="body-wrapper" style="margin-top: 150px;">
          <div class="container">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-2">
                    
            <c:url var="Leave" value="LeaveController">
				<c:param name="command" value="LEAVE" />
				<c:param name="empNo" value="${ User.empNo }"/>
				<c:param name="ename" value="${ User.ename }"/>
				<c:param name="mgr" value="${ User.mgr }"/>
			</c:url>
			 <a href="${ Leave }" class="btn btn-info">Leave application</a>
                     </div>
                     <div class="col-2">
           <c:url var="Manage" value="LeaveController">
				<c:param name="command" value="MANAGE" />
				<c:param name="empNo" value="${ User.empNo }"/>
				<c:param name="ename" value="${ User.ename }"/>
				<c:param name="mgr" value="${ User.mgr }"/>
			</c:url>
			 <a href="${ Manage }" class="btn btn-info">Manager application</a>
                    </div>
                    <div class="col-2">
           <c:url var="DISPLAYAPPROVEDONLY" value="LeaveController">
				<c:param name="command" value="DISPLAYAPPROVED" />
				<c:param name="empNo" value="${ User.empNo }"/>
				<c:param name="ename" value="${ User.ename }"/>
				<c:param name="mgr" value="${ User.mgr }"/>
			</c:url>
			 <a href="${ DISPLAYAPPROVEDONLY }" class="btn btn-success">Approved Requests</a>
                    </div>
                    <div class="col-2">
           <c:url var="DISPLAYREJECTEDONLY" value="LeaveController">
				<c:param name="command" value="DISPLAYREJECTED" />
				<c:param name="empNo" value="${ User.empNo }"/>
				<c:param name="ename" value="${ User.ename }"/>
				<c:param name="mgr" value="${ User.mgr }"/>
			</c:url>
			 <a href="${ DISPLAYREJECTEDONLY }" class="btn btn-success">Rejected Requests</a>
                    </div>
                  </div>
            </div>
              
          </div>
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <jsp:include page="footer.jsp"/>
  </body>
</html>