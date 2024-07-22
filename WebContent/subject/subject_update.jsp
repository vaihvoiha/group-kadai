<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Subject" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./../header.html" %>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <style>
         .menu {
            border-right: 2px solid #eaeaea; /* 右側にボーダーを追加 */
            padding: 20px;
            height: ; /* サイドメニューの高さ、フッターの位置調整 */
            margin-left: 150px;
        }
        .container {
            display: flex;
        }
        .content {
            width: 100%;
            padding: 20px;
            margin-right: 150px;
        }
        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
        }
        body {
            font-family: Arial, sans-serif;
        }
        form {
            display: inline-block;
            text-align: left;
        }
        label {
            width: 100%;
            display: block;
            margin-top: 10px;
        }
        input[type="text"] {
            width: 370%;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons input {
            background-color: #f2f2f2;
            display: block;
            width: 30%;
            padding: 7px;
            background-color: #196dd5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 13px;
        }
        .buttons a {
            margin-right: 10px;
            color: #007BFF;
        }
        .error {
            color: red;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <%@ include file="./../base.html" %>
    <div class="content">
        <div class="content-header">

        <!-- 画面タイトル -->
        <h2>科目情報変更</h2>

        <!-- エラーメッセージ -->
        <div class="error">
            <%= (request.getAttribute("errorMessage") != null) ? request.getAttribute("errorMessage") : "" %>
        </div>

        <%
        Subject subject = (Subject) request.getAttribute("subject");
        %>

        <form action="${pageContext.request.contextPath}/subject/subject_update" method="post">
            <!-- 項目タイトル(科目コード) -->
            <label for="cd">科目コード</label>
            <!-- 科目コード -->
            <input type="text" id="cd" name="cd" value="<%= (request.getAttribute("cd") != null) ? request.getAttribute("cd") : ((subject != null) ? subject.getCd() : "") %>" readonly maxlength="3" placeholder="科目コードを入力してください" required>

            <!-- 項目タイトル(科目名) -->
            <label for="name">科目名</label>
            <!-- 科目名入力テキスト -->
            <input type="text" id="name" name="name" value="<%= (request.getAttribute("name") != null) ? request.getAttribute("name") : ((subject != null) ? subject.getName() : "") %>" placeholder="科目名を入力してください" required>

            <!-- 学校コード隠しフィールド -->
            <input type="hidden" id="school_cd" name="school_cd" value="<%= (request.getAttribute("school_cd") != null) ? request.getAttribute("school_cd") : ((subject != null) ? subject.getSchool_cd() : "") %>">

            <div class="buttons">
                <!-- 変更ボタン -->
                <input type="submit" value="変更">
                <!-- 戻るリンク -->
                <a href="subject_list.jsp">戻る</a>
            </div>
        </form>
    </div>
</div>
</div>
<footer><%@ include file="./../footer.html" %></footer>
</body>
</html>
