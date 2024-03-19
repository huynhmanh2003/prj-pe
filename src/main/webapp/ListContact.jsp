<%-- 
    Document   : ListContact
    Created on : Mar 19, 2024, 5:11:15 AM
    Author     : Manh
--%>

<%@page import="Dao.ContactDao"%>
<%@page import="model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ContactDao cd = new ContactDao();
            ArrayList<Contact> allContacts = cd.getContact();
            int size = allContacts.size();
        %>
        <h1>List Of Contact</h1>
        <h2>There are <%=size %> contacts in the list</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Phone</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Group Name</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
            <th></th>
            <c:forEach var="contact" items="<%=allContacts%>">
                <c:url var="tempLink" value="ContactController">
                    <c:param name="command" value="LOAD"
                             ></c:param>
                    <c:param name="contactid" value="${contact.getId()}"
                             ></c:param>
                </c:url>

                <c:url var="deleteLink" value="ContactController">
                    <c:param name="command" value="DELETE"
                             ></c:param>
                    <c:param name="contactid2" value="${contact.getId()}"
                             ></c:param>
                </c:url>
                <tr>
                    <td>${contact.getId()}</td>
                    <td>${contact.getPhone()}</td>
                    <td>${contact.getFname()}</td>
                    <td>${contact.getLname()}</td>
                    <td>${contact.getGroupname()}</td>
                    <td><a href="${tempLink}">Update</a>
                        <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <a href="index.jsp">Add</a> <br>
            <a href="ListGroup.jsp">List Group</a>
        </tbody>
    </table>
</body>
</html>
