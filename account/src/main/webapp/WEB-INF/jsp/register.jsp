<!-- saved from url=(0089)https://moodle.umontpellier.fr/pluginfile.php/1222911/mod_resource/content/1/register.jsp -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<title>Sign up</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Login Page">
<title>Page d'authentification</title>
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


<div class="container">
    <h2>Create a new user</h2>
    <% if (request.getParameter("user") != null) { %>
    <div class="errorblock">A user with the same username already exists</div>
    <% } %>
    <% if (request.getParameter("confirm") != null) { %>
    <div class="errorblock">No confirmation is possible</div>
    <% } %>
    <% if (request.getParameter("expired") != null) { %>
    <div class="errorblock">The registration has expired. Please re-sign-up</div>
    <%} %>
    <form:form modelattribute="user" method="POST" action="/doRegister">
        <div><label for="username"></label>Username: <input class="form-control" type="text" name="username"
                                                            id="username" placeholder="Enter username"
                                                            autocomplete="off"/>
        </div>

        <div><label for="first_name">First name: </label>
            <input class="form-control" type="text" name="first_name" id="first_name" placeholder="Enter First Name"/>
        </div>

        <div><label for="last_name">Last name: </label>
            <input class="form-control" type="text" name="last_name"
                   id="last_name" placeholder="Enter Last Name">
        </div>

        <div><label for="email">Email: </label>
            <input class="form-control" type="email" name="email" id="email"
                   placeholder="Enter Email Address">
        </div>

        <div><label for="phone_number">Phone Number: </label>
            <input class="form-control" type="text" name="phone_number" id="phone_number"
                   placeholder="Enter Phone Number">
        </div>

        <div><label for="password">Password: </label>
            <input class="form-control" type="password" name="password"
                   id="password" placeholder="Enter Password"/>
        </div>

        <div><label for="matchingPassword">Confirm Password: </label>
            <input class="form-control" type="password"
                   name="matchingPassword"
                   id="matchingPassword"
                   placeholder="Confirm Entered Password above"/>

            <input type="hidden" id="enabled" name="enabled" value="true">
        </div>
        <div><input type="submit" class="btn btn-lg btn-primary" style="margin-top: 20px;" role="button"
                    value="Signup"></div>
    </form:form>
</div>


</body>
</html>