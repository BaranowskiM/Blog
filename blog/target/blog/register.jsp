<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>




<!DOCTYPE html>
<html lang="pl-PL">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blog rejestracja</title>
        <link rel="stylesheet" type="text/css" href="style/reset.css">
        

        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="style/style_register.css">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1>REJESTRACJA</h1>
        <div id = "topright">
            <div><span id = "login"><a href = "index.jsp">Strona główna  </a> |   <a href="login.jsp">  Logowanie</a></span></div>
        </div>


        <form action = "${pageContext.request.contextPath}/regservlet" method="get">
            <div id = "registerField">
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="username" placeholder="Wpisz nazwę użytkownika" name="username" required>
                    <label for="username" class="form-label">Nazwa użytkownika</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <input type="password" class="form-control" id="password" placeholder="Wpisz hasło" name="password" required>
                <label for="password" class="form-label">Hasło</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <input type="password" class="form-control" id="password2" placeholder="Wpisz hasło" name="password2" required>
                <label for="password2" class="form-label">Hasło</label>
            </div>
                <input type = "submit" class="btn btn-primary" name = "regbut" value = "Zarejestruj" /> 
            </form>
       
    </body> 
</html>


<!--
    <form action = "regServlet" method="post">
        <form action = "${pageContext.request.contextPath}/pw/atj/regServlet" method="post">
            <input type = "submit" class="btn btn-primary" name = "regbut" value = "Zarejestruj" /> 
        </form>


        <button type="submit" class="btn btn-primary">Zarejestruj</button>
-->

  <!--          
            <form action = "${pageContext.request.contextPath}/regservlet" method="get">     
-->

<!--
        <div id = "registerField">
            <div>Login</div>
            <input type = "text" name = "login" placeholder = "Wpisz login" size = "20">
            <div>Hasło</div>
            <input type = "text" name = "password" placeholder = "Wpisz hasło" size = "20">
            <div>Powtórz hasło</div>
            <input type = "text" name = "password2" placeholder = "Wpisz ponownie hasło" size = "20"><br><br>
            <button type = "button">Zarejestruj</button>
        </div>
-->