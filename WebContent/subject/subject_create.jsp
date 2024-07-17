<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            margin-left: 150px;
        }
        .container {
            display: flex;
            margin-bottom: 0px;
        }
        .content {
            width: 100%;
            padding: 20px;
            margin-right: 150px;
        }
        body {
            font-family: Arial, sans-serif;
            margin: 0; /* デフォルトのマージンをリセット */
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .main-content {
            flex: 1;
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
        .aa {
            width: 370%;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons input {
            background-color: #f2f2f2;
            display: block;
            width: 50px;
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
        }
        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
        }
        footer {
            text-align: center;
            background-color: #dddddd;
            padding: 10px;
            width: 100%;
            box-sizing: border-box;
            margin-top: auto; /* ページの最後に配置 */
        }
    </style>
</head>
<body>
    <div class="container main-content">
        <%@ include file="./../base.html" %>
        <div class="content">
            <div class="content-header">
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
                    <input class="aa" type="text" id="code" name="code" value="${code}" maxlength="3" placeholder="科目コードを入力してください" required>
                    <!-- 項目タイトル(科目名) -->
                    <label for="name">科目名</label>
                    <!-- 科目名入力テキスト -->
                    <input class="aa" type="text" id="name" name="name" value="${name}" maxlength="20" placeholder="科目名を入力してください" required>
                    <div class="buttons">
                        <!-- 登録ボタン -->
                        <input type="submit" value="登録"><br>
                        <!-- 戻るリンク -->
                        <a href="subject_list.jsp">戻る</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="./../footer.html" %>
</body>
</html>
