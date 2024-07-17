<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生管理</title>
    <style>
        /* 基本のスタイル設定 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }


        .oll {
            display: flex;
        }

		.waku{
			border: 1px solid #ccc;
		    border-radius: 10px;
		    padding: 10px;
		    margin-bottom: 20px;
		}

        /* コンテナのスタイル設定 */
        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* 見出しのスタイル設定 */
        h1 {
            text-align: center;
            color: #333;
        }

        /* フォームのスタイル設定 */
        form {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-right: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        select, input[type="checkbox"] {
            margin-bottom: 10px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* プルダウンリストの横幅を長くする */
        select {
            width: 300px; /* 必要に応じて横幅を調整 */
        }

        /* ボタンのスタイル設定 */
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #555555;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #888888;
        }

        /* 新規登録リンクのスタイル設定 */
        .register-link {
            margin-left: auto;
            text-decoration: none;
            color: #007BFF;
            text-decoration: underline;
        }

        .text-right{
	        text-align: right;
        }

        /* テーブルのスタイル設定 */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;

        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        h1{
        	text-align: left; /* 左揃えに設定 */
		    background-color: #dddddd; /* 背景色を設定 */
		    padding: 0 30px
        }

        .error_message {
        color:#ffa500
        }

    </style>
</head>
<body>
<div class="oll">
    <div class="container">
        <h1>学生管理</h1>
        <!-- 新規登録リンク -->
        <div class="text-right">
	        <a href="student_create.jsp" class="register-link">新規登録</a>
        </div>
        <div class="form-group">
            <!-- 検索フォーム -->
            <div class="waku">



	            <form action="/group_kadai/student/student_list" method="get" onsubmit="stu_form()" >
	                <!-- 入学年度の選択 -->


	                <div id="opop"></div>


	                <div class="form-group">
	                    <label for="ent_year">入学年度</label>
	                    <select id="ent_year" name="ent_year">
	                        <option value="" >-------</option>
	                        <!-- 動的に年を追加 -->
	                        <c:forEach  var="year" items="${years}">
	                            <option value="${year.ent_year}">${year.ent_year}</option>
	                        </c:forEach>
	                    </select>

	                </div>

	                <!-- クラスの選択 -->
	                <div class="form-group">
	                    <label for="class_num">クラス</label>
	                    <select id="class_num" name="class_num">
	                        <option value="">-------</option>
	                        <!-- 動的にクラスを追加 -->
	                        <c:forEach  var="classes" items="${classes}">
	                            <option  value="${classes.class_num}">${classes.class_num}</option>
	                        </c:forEach>
	                    </select>
	                </div>

	                <!-- 在学中チェックボックス -->
	                <div class="form-group">
	                    <input type="checkbox" id="active" name="active" value="True">在学中
	                </div>

	                <!-- 絞り込みボタン -->
	                <button type="submit">絞込み</button>


	            </form>

	             <div class="error_message">${error_message }</div>
	        </div>

            <!-- 検索結果の表示 -->
            <c:forEach var="counts" items="${counts}">
            <p>検索結果：${counts.search_count}件</p>
            </c:forEach>






            <!-- 学生情報のテーブル -->
            <table>
                <thead>
                    <tr>
                        <th>入学年度</th>
                        <th>学生番号</th>
                        <th>氏名</th>
                        <th>クラス</th>
                        <th>在学中</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.ent_year}</td>
                            <td>${student.no}</td>
                            <td>${student.name}</td>
                            <td>${student.class_num}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${student.is_attend}">○</c:when>
                                    <c:otherwise>×</c:otherwise>
                                </c:choose>
                            </td>
                            <!-- 変更リンク -->
                            <td><a href="/StudentUpdate.edit?no=${student.no}">変更</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>







        </div>
    </div>
</div>

<script src="./../form_error.js"></script>
</body>
