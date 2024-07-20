<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="./../header.html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <link rel="stylesheet" type="text/css" href="login.css">
    <style>
        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #fff;
        }
        .login-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
        }
        .login-container label {
            display: block;
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
    </style>
</head>
<body>
    <div class="login-container">
        <h1>ログイン</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="login">ID</label>
            <input type="text" id="login" name="login" size="20" maxlength="20" required value="<%= request.getParameter("login") != null ? request.getParameter("login") : "" %>">

            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" size="20" maxlength="20" required>

            <label><input type="checkbox" id="chk_d_ps" onclick="togglePasswordVisibility()"> パスワードを表示</label>

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
    <%@ include file="./../footer.html" %>
</body>
</html>
