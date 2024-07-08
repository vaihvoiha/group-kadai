<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログアウト</title>
    <link rel="stylesheet" type="text/css" href="logout.css">
</head>
<body>
    <%@ include file="header.html" %>
    <div class="logout-container">
        <h1>ログアウト</h1>
        <div class="logout-message">ログアウトしました</div>
    </div>
    <a href="login.jsp" class="login-link">ログイン</a>
    <%@ include file="footer.html" %>
</body>
</html>
