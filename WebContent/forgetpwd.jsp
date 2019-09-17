<!-- removecomment after adding your java and jstl tag -->
<!doctype html>
<html lang="en">

<head>
    <title>Avensys Leave management zz</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css" />
    <!-- css folder may not work in project, change if need be -->
    


</head>

<body>
    <div class="header">
        <div class="container">
            <div class="header-fade-in row">
                    <div class="logo">
                            <img src="css/avensyslogo.png ">
                        </div>
                <div>
                    <h1>Avensys</h1>
                </div>
            </div>

        </div>
    </div>
    <div class="container body-container">
        <div class="row form-card d-flex justify-content-center">
            <div class="col-lg-4 col-sm-8 card">
                <div class="text-center">
                        <h3>Forget Password? :(</h3>
                </div>
               
                <!-- FORM ACTION HERE -->
                <form action="MainControllerServlet" method="POST">
                        <input type="hidden" name="command" value="retrievePwd" />
                    <div class="form-group card-body">
                        <label for="empno">Employee Number: </label>
                        <input type="text" name="empno" class="form-control" id="numbersonly" value="" placeholder="Numbers Only" />
                        

                        <div class="submit-row d-flex justify-content-end mt-3">
                            <button type="submit" class="btn btn-success">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Optional JavaScript -->
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
     <script>
          $("#numbersonly").on("keypress keyup blur",function (event) {    
           $(this).val($(this).val().replace(/[^\d].+/, ""));
            if ((event.which < 48 || event.which > 57)) {
                event.preventDefault();
            }
        });
     </script>
     <jsp:include page="footer.jsp"/>
</body>

</html>