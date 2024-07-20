<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex: 1;
        }
        .login-box {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        .login-box input[type="text"],
        .login-box input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login-box input[type="submit"] {
            background-color: #196dd5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            padding: 10px;
            width: 100%;
        }
        .login-box input[type="checkbox"] {
            margin-top: 10px;
        }
        .login-box label {
            margin-top: 10px;
        }
        footer {
            text-align: center;
            background-color: #dddddd;
            padding: 10px;
            width: 100%;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <%@ include file="./../header.html" %>
    <div class="container">
        <div class="login-box">
            <h2>ログイン</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label for="id">ログインID:</label>
                <input type="text" id="id" name="id" required><br><br>
                <label for="password">パスワード:</label>
                <input type="password" id="password" name="password" required><br><br>
                <input type="checkbox" id="chk_d_ps" onclick="togglePasswordVisibility()">
                <label for="chk_d_ps">パスワードを表示</label><br><br>
                <input type="submit" name="login" value="ログイン">
            </form>
            <ul id="errorMessages">
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) {
                %>
                    <li style="color:red;"><%= errorMessage %></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
    <%@ include file="./../footer.html" %>
    <script>
        function togglePasswordVisibility() {
            var passwordField = document.getElementById("password");
            if (passwordField.type === "password") {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
    </script>
</body>
</html>
