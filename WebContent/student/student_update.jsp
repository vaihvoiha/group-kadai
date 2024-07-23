<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生情報変更</title>
    <%@ include file="./../header.html" %>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .container {
            width: 70%;
            margin: auto;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            display: block;
            width: 30%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #0033FF;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-bottom: 10px;
        }

        button:hover {
            background-color: #888888;
        }

        .back-link {
            display: block;
            color: #007BFF;
            text-decoration: none;
            font-size: 14px;
            text-decoration: underline;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        .container {
            display: flex;
            align-items: flex-start;
        }

        .menu {
            width: 45%;
        }

        .menu ul {
            list-style-type: none;
            padding: 0;
        }

        .menu ul li {
            margin: 7px 0;
        }

        .menu ul li a {
            text-decoration: underline;
            color: #007bff;
        }

        .menu ul li li a {
            text-decoration: underline;
            color: #007bff;
            margin-left: 5px;
        }

        .main-contents2 {
            width: 70%;
            padding: 10px;
            border-left: 2px solid #eaeaea;
            margin-bottom: 10%;
        }

        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="menu">
            <%@ include file="./../base.html" %>
        </div>
        <div class="main-contents2">
            <h2>学生情報変更</h2>
            <c:if test="${ not empty errorMessage }">
                <div style="color:red;">
                    <c:out value="${errorMessage}"/>
                </div>
            </c:if>
            <br>
            <form action="${pageContext.request.contextPath}/student/student_update" method="post">
                <div class="form-group">
                    <label for="ent_year">入学年度</label>
                    <input type="text" id="ent_year" name="ent_year" value="${student.ent_year}" readonly>
                </div>
                <div class="form-group">
                    <label for="no">学生番号</label>
                    <input type="text" id="no" name="no" value="${student.no}" readonly>
                </div>
                <div class="form-group">
                    <label for="name">氏名</label>
                    <input type="text" id="name" name="name" placeholder="${student.name}" required>
                </div>
                <div class="form-group">
                    <label for="class_num">クラス</label>
                    <select id="class_num" name="class_num">
                        <c:forEach var="class_num" items="${ class_list }">
                            <option value="${class_num}" ${class_num == student.class_num ? 'selected' : ''}>${ class_num }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="active">在学中</label>
                    <input type="checkbox" id="is_attend" name="is_attend" value="1" ${ student.is_attend ? 'checked' : '' }>
                </div>
                <br>
                <div class="center">
                    <button type="submit">変更</button>
                    <a href="student_list" class="back-link">戻る</a>
                </div>
            </form>
        </div>
    </div>
    <footer>
        <%@ include file="./../footer.html" %>
    </footer>
</body>
</html>
