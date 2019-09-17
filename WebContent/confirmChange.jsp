
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="js/bootstrap.js">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/style1.css">

    <style>
        body{
     background: url(back1.jpg);
        }
    </style>
    
    <title> Reset Pass </title>
</head>
<body>  
    
    <div class="container">
   <!-- <h1>Sweet Alert</h1>
     <button class="btn btn-lg btn-primary" onclick="myFunction()">SweetAlert</button>-->
    </div> 
<script>
    swal({
    title: "Status",
    text: "Your password has been succesfully change!",
    type: "success",
}).then(function() {
    window.location = "index.html";
});
    function myFunction() {

}
    
   </script>    
</body>