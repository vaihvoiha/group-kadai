<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <div class="login-container">
        <h1>ログイン</h1>
        <form action="login" method="post">
            <label for="login">ID</label>
            <input type="text" id="login" name="login" value="${login}">

            <label for="password">パスワード</label>
            <input type="password" id="password" name="password">

            <label><input type="checkbox" onclick="togglePassword()"> パスワードを表示</label>

            <input type="submit" value="ログイン">

            <p>${errorMessage}</p>
        </form>
    </div>
    <script>
        function togglePassword() {
            var x = document.getElementById("password");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>
    <%@ include file="footer.html" %>
</body>
</html>
