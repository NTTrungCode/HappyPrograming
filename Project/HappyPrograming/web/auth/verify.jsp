<%-- 
    Document   : verify
    Created on : May 18, 2024, 1:48:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Verify Email</title>
</head>
<style>
        a {
                margin: 10px;
                color: blue;
            }
    </style>
<body>
    <form action="/HappyPrograming/verify" method="post">
        <input type="hidden" name="email" value="${email}">
        <label for="code">Verify Code:</label>
        <input type="text" id="code" name="code" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>

