<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false"%>  
<!DOCTYPE html>
<html lang="pl-PL">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blog logowanie</title>
        <link rel="stylesheet" type="text/css" href="style/reset.css">
        

        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="style/style_blog.css">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1>STRONA GŁÓWNA BLOGA</h1>

        <form action="${pageContext.request.contextPath}/postservlet" method="get">
            <table items="${postList}" var="postList" style="width:100%">

                <c:forEach items="${postList}" var="postList">
                    <tr id = "firstrow">
                        <td id = "username">${postList.userName}</td>
                        <td rowspan="2" id = "writtenmessage">${postList.writtenMesage}</td>
                        <td rowspan="2" id = "deletebutton"> <input type = "submit" class="btn btn-primary" name="deletebutton" value = "${postList.ID}"></td>
                    </tr>
                    <tr>
                        <td id = "date">${postList.actualDate}</td>
                       
                    </tr>
                 </c:forEach>
            </table>

            <div id = "comments">
                <div class="mb-3 mt-3">
                    <textarea class="form-control" rows="2" id="comment" name="text" placeholder="Wpisz komentarz"></textarea>
                </div>
                <input type = "submit" class="btn btn-primary" name="sendbut" value = "Wyślij" /> 
        </div>
        </form>
  


       
    </body> 
</html>


<!--
JSON pierwszy post
    [{"userName":"Administrator","actualDate":"03-05-2022","writtenMesage":"Witaj na forum drogi użytkowniku!"}]


     <form action="${pageContext.request.contextPath}/buttonservlet" method="get">
  </form>


   <td rowspan="2" id = "deletebutton"> <input type = "submit" class="btn btn-primary" name="deletebutton" value = "Usuń" var1 = ${postList.ID}></td>
-->