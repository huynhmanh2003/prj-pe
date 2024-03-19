<%-- 
    Document   : update-student-form.jsp
    Created on : Mar 19, 2024, 6:45:19 AM
    Author     : Manh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>FPT University</h2>
            </div>
        </div>
        <div id="container">
            <h1>update-student-form</h1>
            <hr>
            <form action="ContactController" method="GET">
                <input type="hidden" name="command" value="UPDATE">
                <input type="hidden" name="Contactid"
                       value="${Contact.getId()}">
                <table border="0">

                    <tbody>
                        <tr>
                            <td>ID:</td>
                            <td><input type="text" placeholder="${Contact.getId()}" readonly></td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="firstNameud"
                                       value="${Contact.getFname()}"></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="lastNameud"
                                       value="${Contact.getLname()}"></td>

                        </tr>
                        <tr>
                            <td>Phone: </td>
                            <td><input type="text" name="phoneud"
                                       value="${Contact.getPhone()}"></td>
                        </tr>
                        <tr>
                            <td>Group:  </td>
                            <td>
                                <select name="group">
                                    <option value="family">family</option>
                                    <option value="second">colleague</option>
                                    <option value="third">friend</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="UPDATE" class="save" /></td>
                            <td><a href="ListContact.jsp">Return To Contact List</a></td>
                        </tr>
                    </tbody>
                </table>
            </form>

        </div>
    </body>
</html>
