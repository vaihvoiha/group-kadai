<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生情報登録</title>
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

        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
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

        .container .menu {
            width: 45%;
        }

        .main-contents {
            width: 70%;
            padding: 10px;
            background-color: #ccc;
        }

        .side-menu {
            width: 20%;
            padding: 10px;
            background-color: #faa;
        }

        .container .menu .manu ul {
            list-style-type: none;
            padding: 0;
        }

        .container .menu .manu ul li {
            margin: 7px 0;
        }

        .container.menu .manu ul li a {
            text-decoration: underline;
            color: #007bff;
        }

        .menu ul li li a {
            text-decoration: underline;
            color: #007bff;
            margin-left: 5px;
        }

        .main-contents {
            width: 70%;
            padding: 10px;
            background-color: #ccc;
        }

        .container .side-menu {
            width: 20%;
            padding: 10px;
            background-color: #faa;
        }
        
        .table{
        	margin-bottom: 15%
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="menu">
            <%@ include file="./../base.html" %>
        </div>
        <div class="table">
            <h2>学生情報登録</h2>
            <c:if test="${ not empty errorMessage }">
                <div style="color: #ffcc33;">
                    <c:out value="${ errorMessage }" escapeXml="false"/>
                </div>
            </c:if>
            <br>

            <form action="${pageContext.request.contextPath}/student/student_create" method="post">
                <div class="form-group">
                    <label for="ent_year">入学年度</label>
                    <select name="ent_year" id="ent_year" required>
                        <option value="-------" selected>-------</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                        <option value="2022">2022</option>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                        <option value="2029">2029</option>
                        <option value="2030">2030</option>
                        <option value="2031">2031</option>
                        <option value="2032">2032</option>
                        <option value="2033">2033</option>
                        <option value="2034">2034</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>学生番号</label>
                    <input type="text" name="no" id="no" placeholder="学生番号を入力してください" value="${ no != null ? no : '' }" required>
                </div>
                <div>
                    <label>氏名</label>
                    <input type="text" name="name" id="name" placeholder="氏名を入力してください" value="${ name != null ? name : '' }" required><br>
                </div>
                <div class="form-group">
                    <label for="class_num">クラス</label>
                    <select id="class_num" name="class_num">
                        <c:forEach var="class_num" items="${ class_list }">
                            <option value="${class_num}">${ class_num }</option>
                        </c:forEach>
                    </select>
                </div>
                <button name="end">登録して終了</button>
                <a href="student_list" class="back-link">戻る</a>
            </form>
        </div>
    </div>
    <br><br>
    <footer>
        <%@ include file="./../footer.html" %>
    </footer>
</body>
</html>
