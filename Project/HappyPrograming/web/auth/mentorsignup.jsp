<%-- 
    Document   : mentorsignin
    Created on : May 16, 2024, 11:07:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <style>
        a {
                margin: 10px;
                color: blue;
            }
    </style>
    <body>
        <form action="/HappyPrograming/signup" method="POST">
            <input type="hidden" name="page" value="2">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <input type="hidden" name="role" value="mentor"/>
            <button type="submit">Sign Up</button>
        </form>
    </body>
</html>
