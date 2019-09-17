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
  </head>
  <body>
        <jsp:include page="header.jsp"/>
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