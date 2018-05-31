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
                <p>Vista de los restaurantes utilizando FTL</p>
            </div>
        </div>

        <table width="100%"class="table table-striped">
            <tr>
                <th>Tipo</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Telefono</th>
            </tr>
        </table>

    </main>>
<script
        src="http://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous">

</script>
<tr>
    <script>
        $(document).ready(function () {
            console.log($("#myTitle").html());
            $.get("/rest/api/restaurantes", function (data) {
                console.log(data);
                var contentHtml = "<h2>Nombre</h2>";
                $.each(data, function( index, value ) {
                    contentHtml ="";
                    var nombre= "<td>"+value.nombre+"</td>";
                    var direccion= "<td>"+value.direccion+"</td>";
                    var telefono= "<td>"+value.telefono+"</td>";
                    var tipo= "<td>"+value.tipo+"</td>";
                    contentHtml += "<tr>"+ tipo + nombre + direccion + telefono + "</tr>";
                    $(".table").append(contentHtml);
                });

                console.log("Load was performed.");
            });
        });
    </script>
</body>
</html>