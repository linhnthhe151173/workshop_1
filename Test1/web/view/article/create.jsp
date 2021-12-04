<%-- 
    Document   : create
    Created on : Dec 3, 2021, 9:31:52 AM
    Author     : Linh
--%>

<%@page import="model.Institution"%>
<%@page import="model.Author"%>
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
            ArrayList<Author> listAu = (ArrayList<Author>) request.getAttribute("listAu");
            ArrayList<Institution> listIns = (ArrayList<Institution>) request.getAttribute("listIns");
        %>
    </head>
    <body>
        <form action="create" method="POST">
            id: <input type="text" name="id" value="" /><br>
            title: <input type="text" name="title" value="" /><br>
            published Date: <input type="date" name="date" value="" /><br>
            isOpenAcess: <select name="open">
                <option value="0">Not</option>
                <option value="1">Yes</option>
            </select><br>
            Author: <select name="author">
                <%
                    for (Author a : listAu) {
                %>
                <option value="<%=a.getAid()%>"><%=a.getAname()%></option>
                <%
                    }
                %>
            </select><br>
            Insitution: <select name="ins">
                <%
                    for (Institution i : listIns) {
                %>
                <option value="<%=i.getIid() %>"><%=i.getIname() %></option>
                <%
                    }
                %>

            </select><br>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
