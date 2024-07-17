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
        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
        }
        h3 {
            background-color: #8FBC8F;
            text-align: center;
            padding: 10px;
            margin: 0 0 15% 0;
        }
        .links {
            display: flex;
            margin-top: 20px;
        }
        .links a {
            margin: 10px;
            color: #007BFF;
            text-decoration: none;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .content {
            margin: 0 0 100px 0;
            padding: 20px;
            background-color: #fff;
            width: 100%;
            box-sizing: border-box;
            border-left: 2px solid #eaeaea;
        }
        .highlight {
            display: inline-block;
            width: 100%;
            text-align: center;
            padding: 10px;
            background-color: #eaf6fd;
        }
        .container {
            display: flex;
            align-items: flex-start;
            width: 70%;
            margin: auto;
        }
    </style>
</head>
<body>
    <%@ include file="./../header.html" %>
    <div class="container">
        <%@include file="./../base.html" %>
        <div class="content">
            <!-- 画面タイトル -->
            <h2>科目情報登録</h2>
            <!-- 完了メッセージ -->
            <h3>登録が完了しました</h3>
            <!-- 科目一覧リンク -->
            <div class="links">
                <a href="subject_list.jsp">戻る</a>
                <a href="subject_list.jsp">科目一覧</a>

            </div>
        </div>
    </div>
    <%@include file="./../footer.html" %>
</body>
</html>
