<%-- 
    Document   : show
    Created on : Dec 3, 2021, 10:30:14 AM
    Author     : Linh
--%>

<%@page import="model.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Article> listAr = (ArrayList<Article>) request.getAttribute("listAr");
        %>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Published Date</th>
                    <th>is open Acess</th>
                    <th>Author</th>
                    <th>Institution</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Article a : listAr) {
                %>
                <tr>
                    <td><%=a.getArid() %></td>
                    <td><%=a.getTitle() %></td>
                    <td><%=a.getPublishedDate()%></td>
                    <td><%=a.isIsOpenAccess() == true ? "Yes": "No"%></td>
                    <td><%=a.getAid().getAname() %></td>
                    <td><%=a.getIid().getIname() %></td>
                </tr>

                <%
                    }
                %>

            </tbody>
        </table>

    </body>
</html>
