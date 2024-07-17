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
        .container {
            display: flex;
        }
        .menu {
            border-right: 2px solid #eaeaea;
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
            border-bottom: 1px solid #eaeaea;
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
                    <%@ page import="java.util.List" %>
                    <%@ page import="bean.Subject" %>
                    <%@ page import="dao.SubjectDAO" %>

                    <%
                    SubjectDAO subjectDAO = new SubjectDAO();
                    List<Subject> subjects = subjectDAO.selectAll();
                    for (Subject subject : subjects) {
                    %>
                    <tr>
                        <td><%= subject.getCd() %></td>
                        <td><%= subject.getName() %></td>
                        <td class="actions">
                            <a href="subject_update.jsp?id=<%= subject.getCd() %>">変更</a>
                            <a href="subject_delete.jsp?id=<%= subject.getCd() %>">削除</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<footer><%@ include file="./../footer.html" %></footer>
</body>
</html>
