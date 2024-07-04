<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            margin: 50px;
            text-align: center;
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
        .buttons input, .buttons a {
            margin-right: 10px;
        }
        .error {
            color: red;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- 画面タイトル -->
        <h2>科目情報変更</h2>

        <!-- エラーメッセージ -->
        <div class="error">
            ${errorMessage}
        </div>

        <form action="subject_update" method="post">
            <!-- 項目タイトル(科目コード) -->
            <label for="code">科目コード</label>
            <!-- 科目コード -->
            <input type="text" id="code" name="code" value="${code}"readonly >

            <!-- 項目タイトル(科目名) -->
            <label for="name">科目名</label>
            <!-- 科目名入力テキスト -->
            <input type="text" id="name" name="name" value="${name}" maxlength="20" required>

            <div class="buttons">
                <!-- 変更ボタン -->
                <input type="submit" value="変更">
                <!-- 戻るリンク -->
                <a href="subject_list.jsp">戻る</a>
            </div>
        </form>
    </div>
</body>
</html>
