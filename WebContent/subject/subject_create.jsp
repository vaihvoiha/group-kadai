<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="./../header.html" %>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .login-container h2 {
            margin-bottom: 20px;
        }
        .login-container label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .login-container input[type="checkbox"] {
            margin-right: 5px;
        }
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .login-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .login-container .errorMessage {
            color: red;
            margin-bottom: 10px;
        }
        .login-container .checkbox-container {
            display: flex;
            align-items: center;
        }
        .login-container .checkbox-container label {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>ログイン</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="id">ログインID</label>
            <input type="text" id="id" name="id" size="20" maxlength="20" required value="<%= request.getParameter("id") != null ? request.getParameter("id") : "" %>">

            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" size="20" maxlength="20" required>

            <div class="checkbox-container">
                <input type="checkbox" id="chk_d_ps" onclick="togglePasswordVisibility()">
                <label for="chk_d_ps">パスワードを表示</label>
            </div>

            <input type="submit" name="login" value="ログイン">
        </form>

        <ul id="errorMessages">
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
                <li class="errorMessage"><%= errorMessage %></li>
            <%
                }
            %>
        </ul>
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
