<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script>
        function showHidden(){
            document.getElementById("hidden").style.cssText='display:block'
        };
        function approve(){
            document.getElementById("hidden").style.cssText='display:none';
            swal("Approve");
        };
        function reject(){
            document.getElementById("hidden").style.cssText='display:none';
            swal("Reject");
        };
        function logout(){
           swal("Logout");
        };
        
    </script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

    
    <style>
        #hidden{
            width: 100%;
            height: 100%;
            max-width: 1200px;
            min-height: 500px;
            display: none;
            text-align: center;
        }
    
    </style>
  </head>
  <body>
      
      <input type="hidden" name="empNo" value="${ User.empNo }"/>
        <table class="table" >
                <thead>
                    <tr>
                        <th></th>
                        <th>Employee Name : ${ User.ename }</th>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
      
                <c:forEach var="employeeLeaveReq" items="${ employeeLeaveReq }">
                    <tr>
                        <td scope="row"><div class="btn-group" data-toggle="buttons">
                            <label class="btn">
                                <input type="radio" name="" id="" autocomplete="off" checked>
                            </label>
      
                        </div></td>
                        <td>${ employeeLeaveReq.getName() } </td>
                        <td><button type="button" class="btn btn-outline-success" onclick="showHidden()">View</button></td>
                    </tr>
                    <tr>
                        <td scope="row"></td>
                        <td></td>
                        <td></td>
                    </tr>
                   </c:forEach> 
      
                </tbody>
            </table>

    <div id="hidden" class="mx-auto">
      <table class="table table-striped table-inverse table-responsive">
          <thead class="thead-inverse">
              <tr>
                  <th>Name</th>
                  <td>${ employeeLeaveReq.getName() }</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
              </tr>
              </thead>
              <tbody>
                  <tr>
                      <th scope="row">Emp ID</th>
                      <td>${employeeLeaveReq.getId()}</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      
                  </tr>
                  <tr>
                      <th scope="row">From Date</th>
                      <td>${employeeLeaveReq.getStartDate()}</td>
                      <th> To Date</th>
                      <td>${employeeLeaveReq.getName()}</td>
                      <th>Days:</th>
                      <td>${ employeeLeaveReq.getDays() }
                            </td>
                    
                  </tr>
                  <tr>
                    <th scope="row">Reason</th>
                    <td>Some reason is here</td>
                    <td>${ employeeLeaveReq.getReason() }<td>
                      <td></td>
                      <td></td>
                      <td></td>
                </tr>
                <tr>
                    <th scope="row">Comment</th>
                    <td><div class="form-group">
                      <input type="text" class="form-control" name="comment" id="comment" placeholder="Your Comments" aria-describedby="helpId" placeholder="">
                    </div></td>
                    <td></td>
                    <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                </tr>
                <tr>
                    
                    <td></td>
                      <td></td>
                      <td></td>
                      <td><input name="" id="" class="btn btn-success" type="button" value="Approve" onclick="approve()"></td>

                      <td></td>
                      <td><input name="" id="" class="btn btn-danger" type="button" value="Reject" onclick="reject()"></td>

                </tr>
              </tbody>
              
      </table>
    </div>
      <input name="" id="" class="btn btn-danger" type="button" value="Back" style="float:left;margin-left: 10px">
      <input name="" id="" class="btn btn-warning" type="button" value="Logout" style="float: right;margin-right: 10px;" onclick="logout()">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>