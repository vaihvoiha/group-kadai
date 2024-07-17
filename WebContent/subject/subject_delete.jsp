<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./../header.html" %>
    <meta charset="UTF-8">
    <title>科目情報削除</title>
    <style>
        .menu {
            border-right: 2px solid #eaeaea; /* 右側にボーダーを追加 */
            padding: 20px;
            margin-left: 150px;
        }
        .container {
            display: flex;
            padding-bottom: px
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
        .buttons {
            margin-top: 20px;
        }
        .buttons input, .buttons a {
            margin-right: 10px;
        }
        button {
            background-color: #e10707;
            width: 5em;
            height: 2em;
            border: none; /* ボタンの枠線をなくす */
            outline: none; /* フォーカス時の枠線をなくす */
            border-radius: 5px; /* 角を丸くする */
            color: white; /* 文字の色を白くする */
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
        }
    </style>
</head>
<body>
    <div class="container main-content">
        <%@ include file="./../base.html" %>
        <div class="content">
            <div class="content-header">
                <!-- 画面タイトル -->
                <h2>科目情報削除</h2>
                <!-- 確認メッセージ -->
                <p>「${name}」(科目コード: ${code})を削除してもよろしいですか</p>
                <div class="buttons">
                    <!-- 削除ボタン -->
                    <form action="delete" method="post" style="display:inline;">
                        <input type="hidden" name="code" value="${code}">
                        <button type="submit" value="削除">削除</button>
                    </form><br>
                    <!-- 戻るリンク -->
                    <a href="subject_list.jsp">戻る</a>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="./../footer.html" %>
</body>
</html>