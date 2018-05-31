<!DOCTYPE html>
<html lang="en">
<head>
    <title>Restaurantes</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="index.ftl">Restaurants</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>

    <main role="main">

        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">RESTAURANTES</h1>
                <p>Elija el tipo de vista preferido para ver sus restaurantes</p>
            </div>
        </div>

        <div class="container">
            <div>
                <form action="/restaurantes">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Vista con FTL</button>
                </form>
            </div>

            <div>
                <form action="/rest/api/restaurantes">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Vista con JSON</button>
                </form>
            </div>
        </div>

    </main>

</body>
</html>