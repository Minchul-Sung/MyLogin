<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" value=${username}>
            <br>       
            <label for="password">Password:</label>
            <input type="text" name="password" value=${password}>
            <br>      
            <input type="submit" value="login">
        </form>
        <div>${message}</div>    
    </body>
</html>
