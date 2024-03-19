<%-- 
    Document   : ListGroup
    Created on : Mar 19, 2024, 5:30:27 AM
    Author     : Manh
--%>

<%@page import="model.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.GroupDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Group List!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Group Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    GroupDao cd = new GroupDao();
                    ArrayList<Group> arrGroup = cd.getGroup();
                %>
            <c:forEach var="group" items="<%=arrGroup%>">
                <tr>
                    <td>${group.getGroupname()}</td>
                    <td>${group.getDes()}</td>
                </tr>
            </c:forEach>
            <form action="GroupController"method="get">
                <input type="submit" name="name" value="Add Group">
                <input type="submit" name="name" value="Description">
            </form>
        </tbody>
    </table>
</body>
</html>
