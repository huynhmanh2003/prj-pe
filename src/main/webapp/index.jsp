<%-- 
    Document   : index
    Created on : Mar 18, 2024, 10:31:50 PM
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
        <h1>Add a Contact</h1>
        <form action="ContactController" method="post">
            <span>First Name : </span> <input type="text" name="fname" > <br>
            <span>Last Name : </span><input type="text" name="lname" > <br>
           <span>Group Name : <select name="group">
                <option value="family">family</option>
                <option value="second">colleague</option>
                <option value="third">Friend</option>
            </select><br>
            <span>Phone Number : </span><input type="text" name="phone" > <br>
            <input type="submit" name="submit" value="Add">
            <input type="submit" name="submit" value="Return to Contact List"><br>
        </form>
    </body>
</html>
