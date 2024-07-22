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
            width: 35%;
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
            border-left: 2px solid #eaeaea; /* 左側の境界線を設定 */
            margin-bottom: 20%; /* 下に余白を追加 */
        }

        h2 {
            background-color: #f2f2f2;
            text-align: left;
            padding: 5px 20px;
        }

        .ma {
            width: 150px;
            margin: 5px 0px;
            background: #DDBBBB;
        }

        .menu {
            border: #F0F1F2;
            height: 30px;
            margin: 5px 0px;
            vertical-align: middle;
        }

        .menu_left {
            display: flex;
            border-right: 5px solid #F0F1F2;
            padding: 2px 8px;
        }

        .menu_left .in {
            width: 30%;
        }

        .flex_menu .flex_right {
            display: flex;
            flex-direction: column;
        }

        .flex_menu {
            display: flex;
            flex-direction: row; /* 横並びに変更 */
        }

        .flex_menu .kanri {
            background: #DDBBBB;
            border: #DDBBBB solid 2px;
            font-size: 100%;
            padding: 20px;
            height: 60px;
            width: 150px;
            border-radius: 5px;
            box-shadow: 1px 5px 10px gray;
            text-align: center;
            line-height: 60px;
            margin: 0px 5px;
        }

        .ma {
            width: 150px;
            margin: 5px 0px;
        }

        .flex_menu .tou {
            background: #BBDDBB;
            border: #BBDDBB solid 2px;
            font-size: 100%;
            padding: 20px;
            height: 60px;
            width: 150px;
            border-radius: 5px;
            box-shadow: 1px 5px 10px gray;
            text-align: center;
            margin: 0px 5px;
        }

        .flex_menu .kamoku {
            background: #BBBBDD;
            border: #BBBBDD solid 2px;
            font-size: 100%;
            padding: 20px;
            height: 60px;
            width: 150px;
            border-radius: 5px;
            box-shadow: 1px 5px 10px gray;
            text-align: center;
            line-height: 60px;
            margin: 0px 5px;
        }

        /* 新しいスタイルを追加 */
        .flex_menu .kanri a,
        .flex_menu .tou a,
        .flex_menu .kamoku a {
            color: blue;
        }
</style>
</head>

<body>
<div class="container">
<div class="menu">
<%@ include file="./../base.html" %>
</div>
<div class="main-contents2">
<h2>メニュー</h2>
<div class="flex_menu">
<div class="kanri">
<a href="http://localhost:8080/group_kadai/student/student_list.jsp">学生管理</a>
</div>
<div class="tou">
                    成績管理<br>
<a href="#">成績登録</a><br>
<a href="#">成績参照</a>
</div>
<div class="kamoku">
<a href="http://localhost:8080/group_kadai/subject/subject_list.jsp">科目管理</a>
</div>
</div>
</div>
</div>
<footer>
<%@ include file="./../footer.html" %>
</footer>
</body>
</html>