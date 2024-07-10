<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!DOCTYPE html>
	<html lang="ja">
<<<<<<< HEAD
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
				width: 70%;
				margin: auto;

			}

			h1 {
				text-align: center;
				color: #333;
			}
			
			h2{
				text-align: left; /* 左揃えに設定 */
		    	background-color: #dddddd; /* 背景色を設定 */
		    	padding: 5px 20px
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
			    width: 20%;
			    padding: 10px;
			    border: none;
			    border-radius: 5px;
			    background-color: #555555;
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
			}

			.back-link:hover {
			    text-decoration: underline;
			}
			
			
		</style>
	</head>

	<body>
		<div class="container">
			<h2>学生情報登録</h2>
			<form action="/create" method="post">
				<div class="form-group">
					<label for="ent_year">入学年度</label>
					<select name="ent_year" required>
						<option value="0" selected>-------</option>
						<option value="1">2014</option>
						<option value="2">2015</option>
						<option value="3">2016</option>
						<option value="4">2017</option>
						<option value="5">2018</option>
						<option value="6">2019</option>
						<option value="7">2020</option>
						<option value="8">2021</option>
						<option value="9">2022</option>
						<option value="10">2023</option>
						<option value="11">2024</option>
						<option value="12">2025</option>
						<option value="13">2026</option>
						<option value="14">2027</option>
						<option value="15">2028</option>
						<option value="16">2029</option>
						<option value="17">2030</option>
						<option value="18">2031</option>
						<option value="19">2032</option>
						<option value="20">2033</option>
						<option value="21">2034</option>
					</select>
					<p>${ errorMessage }</p>
				</div>
				<div class="form-group">
					<label>学生番号</label>
					<input type="text" name="no" placeholder="学生番号を入力してください" required>
					<p>${ errorMessage }</p>
				</div>
				<div>
					<label>氏名</label>
					<input type="text" name="name" placeholder="氏名を入力してください" required><br>
					<p>${ errorMessage }</p>
				</div>
				<div class="form-group">
					<label>クラス</label>
						<select id="class" name="class_num" required>
	                    <option value="1">101</option>
	                    <option value="2">102</option>
	                    <option value="3">201</option>
	                    <option value="4">202</option>
	                </select>
	                <p>${ errorMessage }</p>
				</div>
				<button name="end">登録して終了</button>
				<a href="student_list.jsp" class="back-link">戻る</a>

			</form>
		</div>
	</body>
=======




	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>学生情報登録</title>

				<%@ include file="./../header.html" %>

		<style>
			body {
				font-family: Arial, sans-serif;
				background-color: #f9f9f9;
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
			    margin: auto;
			    padding: 10px;
			    border: none;
			    border-radius: 5px;
			    background-color: #555555;
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
			    text-align: center;
			    color: #007BFF;
			    text-decoration: none;
			    font-size: 14px;
			}

			.back-link:hover {
			    text-decoration: underline;
			}

		    .container {
            display: flex; /* フレックスボックスの表示設定 */
            align-items: flex-start; /* 上端に揃える */


        }
               .container .menu {
            width: 45%; /* 幅を15%に設定 */

            /* 右側の境界線を設定 */
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
            list-style-type: none; /* リストマーカーを非表示 */
            padding: 0; /* 内側の余白を0に設定 */
        }

        .container .menu .manu ul li {
            margin: 7px 0; /* 上下のマージンを7pxに設定 */
        }

        .container.menu .manu ul li a {
            text-decoration: underline; /* テキストの下線を設定 */
            color: #007bff; /* テキストの色を設定 */
        }

        .menu ul li li a {
            text-decoration: underline; /* テキストの下線を設定 */
            color: #007bff; /* テキストの色を設定 */
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



		</style>
	</head>

	<body>


		<div class="container">
		<div class="menu">
		<%@ include file="./../base.html" %>
		</div>
		<div class="table">
			<h2>学生情報登録</h2>
			<form action="/student_create" method="post">
				<div class="form-group">
					<label for="ent_year">入学年度</label>
					<select name="ent_year" required>
						<option value="0" selected>-------</option>
						<option value="1">2014</option>
						<option value="2">2015</option>
						<option value="3">2016</option>
						<option value="4">2017</option>
						<option value="5">2018</option>
						<option value="6">2019</option>
						<option value="7">2020</option>
						<option value="8">2021</option>
						<option value="9">2022</option>
						<option value="10">2023</option>
						<option value="11">2024</option>
						<option value="12">2025</option>
						<option value="13">2026</option>
						<option value="14">2027</option>
						<option value="15">2028</option>
						<option value="16">2029</option>
						<option value="17">2030</option>
						<option value="18">2031</option>
						<option value="19">2032</option>
						<option value="20">2033</option>
						<option value="21">2034</option>
					</select>
					<p>${ errorMessage }</p>
				</div>
				<div class="form-group">
					<label>学生番号</label>
					<input type="text" name="no" placeholder="学生番号を入力してください" required>
					<p>${ errorMessage }</p>
				</div>
				<div>
					<label>氏名</label>
					<input type="text" name="name" placeholder="氏名を入力してください" required><br>
					<p>${ errorMessage }</p>
				</div>
				<div class="form-group">
					<label>クラス</label>
						<select id="class" name="class_num" required>
	                    <option value="1">101</option>
	                    <option value="2">102</option>
	                    <option value="3">201</option>
	                    <option value="4">202</option>
	                </select>
	                <p>${ errorMessage }</p>
				</div>
				<button name="end">登録して終了</button>
				<a href="student_list.jsp" class="back-link">戻る</a>

			</form>
		</div>

		</div>

					<br><br>

	</body>
	<footer><%@ include file="./../footer.html" %></footer>


>>>>>>> branch 'master' of https://github.com/vaihvoiha/group-kadai.git
	</html>
