<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dao.SubjectDAO, bean.Subject" %>
<%
    SubjectDAO dao = new SubjectDAO();
    List<Subject> subjectList = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./../header.html" %>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
        }
        .menu {
            border-right: 2px solid #eaeaea; /* 右側にボーダーを追加 */
            padding: 20px;
            height: 100vh; /* サイドメニューの高さを指定 */
            margin-left: 150px;
        }
        .content {
            width: 100%;
            padding: 20px;
            margin-right: 150px;
        }
        .content-header {
            display: flex;
            justify-content: space-between; /* 要素を左右に配置 */
            align-items: center;
            background-color: #f2f2f2;
            padding: 10px 20px;
            border-bottom: 1px solid #eaeaea; /* 黒枠をなくす */
            margin-bottom: 10px; /* 科目管理と新規登録リンクの間に空間を追加 */
        }
        .content-header h2 {
            margin: 0;
        }
        .table-container {
            padding: 20px;
            background-color: #fff;
        }
        .right-align {
            text-align: right;
            margin-bottom: 10px; /* テーブルとの間に余白を追加 */
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
        td:last-child {
            text-align: right; /* 右揃えに設定 */
            padding-right: 50px; /* 右側に余白を追加 */
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <%@ include file="./../base.html" %>
    <div class="content">
        <div class="content-header">
            <!-- 画面タイトル -->
            <h2>科目管理</h2>
        </div>
        <!-- 新規登録リンク -->
        <div class="right-align">
            <a href="subject_create.jsp">新規登録</a>
        </div>
        <div class="table-container">
            <!-- 科目一覧テーブル -->
            <table>
                <thead>
                    <tr>
                        <!-- ヘッダ（科目コード） -->
                        <th>科目コード</th>
                        <!-- ヘッダ（科目名） -->
                        <th>科目名</th>
                        <!-- 操作 -->
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <!-- データベースから取得した科目情報を表示 -->
                    <%
                        for (Subject subject : subjectList) {
                    %>
                    <tr>
                        <td><%= subject.getCd() %></td>
                        <td><%= subject.getName() %></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/subject/subject_update?cd=<%= subject.getCd() %>&school_cd=<%= subject.getSchool_cd() %>">変更</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="subject_delete.jsp?cd=<%= subject.getCd() %>&school_cd=<%= subject.getSchool_cd() %>">削除</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<footer><%@ include file="./../footer.html" %></footer>
</body>
</html>
