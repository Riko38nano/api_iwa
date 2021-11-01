<!-- saved from url=(0086)https://moodle.umontpellier.fr/pluginfile.php/1222969/mod_resource/content/1/login.jsp -->
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Login Page">
    <title>Sign In</title>
    <meta name="theme-color" content="#563d7c">
    <style>
        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<body>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <h1>Log in</h1>
    <% if (request.getParameter("error") != null) { %>
    <div class="errorblock">Invalid Username and Password</div>
    <% } %>

    <% if (request.getParameter("logout") != null) { %>
    <div class="alert alert-success" role="alert">Logout was successful</div>
    <% } %>

    <% if (request.getParameter("confirm") != null) { %>
    <div class="alert alert-success" role="alert">User creation is confirmed. Please log in</div>
    <% } %>

    <form:form action="/doLogin" method="POST">
        <label for="username">User name: </label>
        <input type="text" id="username" name="username" autocomplete="off"/>
        <br>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password" autocomplete="off"/>
        <br>
        <label>Remember me: <input type="checkbox" name="remember-me"></label>
        <br>
        <input type="submit" value="Login" role="button" class="btn btn-lg btn-primary"/>
    </form:form>
    If you don't have an account yet, sign up <a href="http://localhost:9090/register">here</a>
</div>

</body>
</html>