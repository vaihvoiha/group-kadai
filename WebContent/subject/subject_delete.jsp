<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>削除確認</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            margin: 50px;
            text-align: center;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons input, .buttons a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- 画面タイトル -->
        <h2>削除確認</h2>
        <!-- 確認メッセージ -->
        <p>本当に科目「${name}」(科目コード: ${code})を削除しますか？</p>
        <div class="buttons">
            <!-- 削除ボタン -->
            <form action="delete" method="post" style="display:inline;">
                <input type="hidden" name="code" value="${code}">
                <input type="submit" value="削除">
            </form>
            <!-- 戻るリンク -->
            <a href="subject_list.jsp">戻る</a>
        </div>
    </div>
</body>
</html>
