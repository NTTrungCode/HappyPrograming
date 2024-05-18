<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        a {
            color: blue;
        }

    </style>
    <body>
        <div class="content">
            <form action="/HappyPrograming/login" method="POST">
                <div style="margin-bottom : 5px">
                    <label for="user">Username</label> 
                    <input type="text" id="userID" name="username" placeholder="Enter Username"><br>
                </div>
                <label for="pass">Password</label>
                <input style="margin-left: 3px" type="password" id="pass" name="password" placeholder="Enter Password"><br><br>
                <label><input type="checkbox" name="remember" value="Y"/> Remember me</label>
                <a href="resetpassword.jsp">Forgot password</a><br>
                <input type="submit" value="Login" name="submit"><br>
            </form>
            <small>Do not have an account?</small><br>
                <form action="signup.jsp" method="post">
                    <button type="submit">Create an account</button>
                </form>
        </div>
    </body>
</html>
