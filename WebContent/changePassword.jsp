

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="js/bootstrap.js">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/style1.css">
<title> Reset Pass </title>
</head>
<body>  
<section id="cover">
<div class="container-fluid col-md-4">

		
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-5x"></i></h3>
                  <h2 class="text-center">Reset Password</h2>
                  <p>Reset your password here.</p>
                  <div class="panel-body">
    
                    <form id="register-form" role="form" autocomplete="off" class="form-align" action="LeaveController" method="post">
                        <input type="hidden" name="command" value="UPDATEPSWD" />
	                    <input type="hidden" name="empNo" value="${ Id }">
                      <div class="form-group">
                        <div class="input-group">
                           <label class="control-label col-sm-2" for="email">Email:</label>
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="password" name="password" placeholder="password" class="form-control"  type="password">
                        </div>
                      </div>
                          <div class="form-group">
                              <div class="input-group">
                        <label class="control-label col-sm-2" for="email">Confirm:</label>
                       <input id="cnfmpswd" name="password" placeholder="Password" class="form-control"  type="password">
                      </div>
                      <div class="form-group">
                          ${ error }
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Change Password" type="submit">
                          <script>
                          function confirmChange(){
                              Swal('Hello world!')
                          }
                          </script>
                          
                      </div>
                        </div>
                      <input type="hidden" class="hide" name="token" id="token" value=""> 
                    </form>
    
                  </div>
                </div>
              </div>
            </div>


</div>
    </section>
    <jsp:include page="footer.jsp"/>
    </body>