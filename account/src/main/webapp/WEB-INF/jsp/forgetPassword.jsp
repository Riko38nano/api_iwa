<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div>Forgot pass please enter info : </div>

<% if (request.getParameter("error") != null) { %>
<div class="errorblock">Invalid Username and Password</div>
<% } %>

<% if (request.getParameter("confirm") != null && (request.getParameter("username") != null)) { %>
<div class="alert alert-success" role="alert">User is confirmed. Please enter new pass</div>


<form:form action="/confirmNewPass" method="POST">
    <label for="password">Pass 1</label>
    <input type="password" id="password" name="password">

    <label for="pass2">Pass 2</label>
    <input type="password" id="pass2">

    <input type="hidden" value=<%=request.getParameter("username").split("\\.")[0]%> name="username" id="username">

    <input type="submit" value="Send">

</form:form>

<% } else { %>

<form:form action="/didForgetPass" method="GET">
    <label for="email">email : </label>
    <input id="email" name="email">

    <label for="username">username : </label>
    <input id="username" name="username">

    <input type="submit" value="Send">
</form:form>
<% } %>