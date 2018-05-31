<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="index.ftl">Restaurantes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </nav>
    <main role="main">
<#--<nav role="navigation">-->
    <#--<ul>-->
        <#--<li><a href="/">Home</a></li>-->
    <#--</ul>-->
<#--</nav>-->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">LOG IN</h1>
            <p>Haz log para acceder a la vista deseada</p>
        </div>
    </div>

    <div class="container">

            <form role="form" action="/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div>
                    <label for="username">Name</label>
                    <input class="form-control mr-sm-2" name="username" id="username" required autofocus/>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input class="form-control mr-sm-2" type="password" name="password" id="password" required/>
                </div>
                <div>
                    <label for="remember-me">Remember me</label>
                    <input type="checkbox" name="remember-me" id="remember-me"/>
                </div>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign in</button>
            </form>
    </div>

<#if error.isPresent()>
<p>The username or password you have entered is invalid, try again.</p>
</#if>
    </main>
</body>
</html>