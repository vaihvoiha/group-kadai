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
        .links a {
            margin: 10px;
            display: inline-block;
        }
        h2 {
            background-color: #f2f2f2;
        }
        P {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- 画面タイトル -->
        <h2>科目情報登録</h2>
        <!-- 完了メッセージ -->
        <p>登録が完了しました</p>
        <!-- 戻るリンク -->
        <div class="links">
            <a href="subject_create.jsp">戻る</a>
            <!-- 科目一覧リンク -->
            <a href="subject_list.jsp">科目一覧</a>
        </div>
    </div>
</body>
</html>
