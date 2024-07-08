<%@page contentType="text/html; charset=UTF-8" language="java"%>

	<!DOCTYPE html>
	<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>学生情報登録</title>
		<style>
			body {
			    font-family: Arial, sans-serif;
			    background-color: #f9f9f9;
			    margin: 0;
			    padding: 20px;
			}

			.container {
			    max-width: 600px;
			    margin: 0 auto;

			}

			h2 {
			    text-align: center;
			    color: #333;
			}

			label {
			    display: block;
			    margin-top: 10px;
			    font-weight: bold;
			}

			input[type="text"],
			select {
			    width: 100%;
			    padding: 10px;
			    margin-top: 5px;
			    margin-bottom: 10px;
			    border: 1px solid #ccc;
			    border-radius: 5px;
			    box-sizing: border-box;
			}

			input[type="checkbox"] {
			    margin-top: 10px;
			}

			button {
			    width: 20%;
			    margin: auto;
			    padding: 10px;
			    background-color: #555555;
			    color: white;
			    border: none;
			    border-radius: 5px;
			    cursor: pointer;
			}

			button:hover {
			    background-color: #888888;
			}

			.center {
				margin: auto;
				text-align: center;
			}

			a {
			    display: block;
			    margin-top: 10px;
			    color: #007BFF;
			    text-decoration: none;
			}

			a:hover {
			    text-decoration: underline;
			}

		</style>
	</head>
	<body>
		<div class="container">
			<h2>学生情報登録</h2>
			<form action="/create" method="post">
				<div>
					<label for="ent_year">入学年度</label>
					<input type="text" id="ent_year" name="ent_year" value="${student.ent_year}" readonly>
					<p>${ errorMessage }</p>
				</div>
				<div>
					<label for="no">学生番号</label>
					<input type="text" id="no" name="no" value="${student.no}" readonly>
					<p>${ errorMessage }</p>
				</div>
				<div>
					<label for="name">氏名</label>
					<input type="text" id="name" placeholder="${student.name}" required>
					<p>${ errorMessage }</p>
				</div>
				<div>
					<label for="class_num">クラス</label>
					<select id="class_num" name="class_">
                		<c:forEach var="class_num" items="${class_num}">
                    		<option value="${class_num}" ${class_num == student.class_num ? 'selected' : ''}>${class_num}</option>
                		</c:forEach>
            		</select>
            		<p>${ errorMessage }</p>
				</div>
				<div>
					<label for="active">在学中</label>
					<input type="checkbox" id="active" name="active" value="1">
				</div>
				<br>
				<div class="center">
					<button type="submit">変更</button>
					<a href="student_list.jsp" class="back-link">戻る</a>
				</div>
			</form>
		</div>
	</body>
	</html>