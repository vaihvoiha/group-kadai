<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目情報登録</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            margin: 50px;
            text-align: center;
        }
        .error {
            color: red;
            margin-top: 20px;
        }
        form {
            display: inline-block;
            text-align: left;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"] {
            width: 200px;
        }
        .buttons {
            margin-top: 20px;
        }
        h2 {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>科目情報登録</h2>
        <div class="error">
            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
        </div>
        <form action="subject_create" method="post">
            <label for="code">科目コード</label>
            <input type="text" id="code" name="code" maxlength="3" placeholder="科目コードを入力してください" required>

            <label for="name">科目名</label>
            <input type="text" id="name" name="name" maxlength="20" placeholder="科目名を入力してください" required>

            <label for="schoolCd">学校コード</label>
            <input type="text" id="schoolCd" name="schoolCd" maxlength="3" placeholder="学校コードを入力してください" required>

            <div class="buttons">
                <input type="submit" value="登録">
                <a href="subject_list.jsp">戻る</a>
            </div>
        </form>
    </div>
</body>
</html>
