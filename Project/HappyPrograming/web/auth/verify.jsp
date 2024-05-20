<!DOCTYPE html>
<html>
<head>
    <title>Verify Account</title>
</head>
<body>
    <h1>Verify Your Account</h1>
    <form action="verify" method="post">
        <input type="hidden" name="email" value="${email}">
        <input type="hidden" name="username" value="${username}">
        <input type="hidden" name="password" value="${password}">
        <input type="hidden" name="role" value="${role}">
        <label for="code">Verification Code:</label>
        <input type="text" id="code" name="code" required><br><br>
        <button type="submit">Verify</button>
    </form>
</body>
</html>
