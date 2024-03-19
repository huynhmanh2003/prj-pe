<%-- 
    Document   : add_group
    Created on : Mar 19, 2024, 7:53:09 AM
    Author     : Manh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a Group!</h1>
        <form action="GroupController" method="Post">
            <span>Name: </span><input type="tex" name="grname" ><br>
            <span>Description: </span><input type="tex" name="grdes" ><br>
            <input type="submit" name="name1" value="Add"><br>
            <input type="submit" name="name1" value="Return to Group List">
        </form>
    </body>
</html>
