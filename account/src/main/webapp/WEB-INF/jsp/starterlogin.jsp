<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1>Login</h1>
    <% if(request.getParameter("error") != null) { %>
        <div class="errblock">Invalid Username and Password</div>
    <% } %>

    <form:form>
        <label for="name">
            User name:
        </label>
        <input type="text" id="name" name="name"/>
        <br/>

        <label for="pass">
            Password :
        </label>
        <input type="password" id="pass" name="pass"/>
        <br/>

        <input type="submit" value="Login" role="button" class="btn btn-lg btn-primary"/>
    </form:form>
</div>