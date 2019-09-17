<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Avensys</title>
		
		<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css" />
	</head>
	
	<body>
		 <div class="header">
                <div class="container">
                    <div class="row d-flex justify-content-between">
                          <img src="images/human.png" height="50px;" width="50px"><h1 style="margin-left:-600px;">Welcome,  ${ User.ename }</h1>
                          <div class="emp-details">
                                <div style="margin-left:-600px;">name: ${ User.ename }</div>
                                <div style="margin-left:-600px;">id: ${ User.empNo }</div>
                                <!--  <div style="margin-left:-600px;">Role: ${ User.role }</div>  -->
                                <small class="text">Log Out?</small>
                          </div>
                    </div>
                </div>
            </div>
	</body>
</html>