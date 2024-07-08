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
        .buttons input, .buttons a {
            margin-right: 10px;
        }
         h2 {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- 画面タイトル -->
        <h2>科目情報登録</h2>

        <!-- エラーメッセージ -->
        <div class="error">
            ${errorMessage}
        </div>

        <form action="submit" method="post">
            <!-- 項目タイトル(科目コード) -->
            <label for="code">科目コード</label>
            <!-- 科目コード入力テキスト -->
            <input type="text" id="code" name="code" value="${code}" maxlength="3" placeholder="科目コードを入力してください" required>

            <!-- 項目タイトル(科目名) -->
            <label for="name">科目名</label>
            <!-- 科目名入力テキスト -->
            <input type="text" id="name" name="name" value="${name}" maxlength="20" placeholder="科目名を入力してください" required>

            <div class="buttons">
                <!-- 登録ボタン -->
                <input type="submit" value="登録">
                <!-- 戻るリンク -->
                <a href="subject_list.jsp">戻る</a>
            </div>
        </form>
    </div>
</body>
</html>
