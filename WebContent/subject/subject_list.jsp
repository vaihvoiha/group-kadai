<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="./../header.html" %>
    <meta charset="UTF-8">
    <title>科目管理システム</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .contain
        er {
            display: flex;
        }
        .menu {
            border-right: 2px solid #eaeaea; /* 右側にボーダーを追加 */
            padding: 20px;
            height: ; /* サイドメニューの高さ、フッターの位置調整 */
            margin-left: 150px;
        }
        .content {
            width: 100%;
            padding: 20px;
            margin-right: 150px;
        }
        .content-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #f2f2f2;
            padding: 10px 20px;
            border-bottom: 1px solid #eaeaea; /* 黒枠をなくす */
        }
        .content-header h2 {
            margin: 0;
        }
        .table-container {
            padding: 20px;
            background-color: #fff;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border-bottom: 1px solid #DDDDDD;
            padding: 8px;
            text-align: left;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        .actions {
            display: flex;
            gap: 10px;
        }
    </style>
</head>

<body>
<div class="container">
    <%@ include file="./../base.html" %>
    <div class="content">
        <div class="content-header">
            <h2>科目管理</h2>
            <a href="subject_create.jsp">新規登録</a>
        </div>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>科目コード</th>
                        <th>科目名</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td class="actions">
                            <a href="subject_update.jsp?id=001">変更</a>
                            <a href="subject_delete.jsp?id=001">削除</a>
                        </td>
                    </tr>
                    <!-- 他の科目情報も同様に記述 -->
                    <tr>
                <td></td>
                <td></td>
                <td>
                    <a href="subject_update.jsp?id=002" class="spaced-link">変更</a>
                    <a href="subject_delete.jsp?id=002">削除</a>
                </td>

            </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<footer><%@ include file="./../footer.html" %></footer>
</body>
</html>