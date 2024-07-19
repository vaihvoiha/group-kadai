<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>得点管理システム</title>

    <style type="text/css"></style>

</head>
<body>


	<div class="oll">
    	<div class="container">
        	<h1>成績参照(学生)</h1>
        	<!-- 新規登録リンク -->
        	<div class="text-right">



	        	<a href="student_create.jsp" class="register-link">新規登録</a>



        	</div>
        	<div class="form-group">
            	<!-- 検索フォーム -->
            	<div class="waku">



	            <form action="/group_kadai/grades/grades_list" method="get" onsubmit="stu_form()" >
	                <!-- 入学年度の選択 -->


	                <div id="opop"></div>


	                <div class="form-group">
	                	<p>科目情報</p>
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


	                	                <!-- 科目の選択 -->
	                <div class="form-group">
	                    <label for="sub_cd">科目</label>
	                    <select id="sub_cd" name="sub_cd">
	                        <option value="">-------</option>
	                        <!-- 動的に科目を追加 -->
	                        <c:forEach  var="subject" items="${subject}">
	                            <option  value="${subject.subject_name}">${subject.subject_name}</option>
	                        </c:forEach>
	                    </select>
	                </div>





	                <!-- 検索ボタン -->
	                <button type="submit">検索</button>




	            </form>
				<!-- エラーメッセージ -->
	             <div class="error_message">${error_message }</div>



		</div>

		</div>





  	            <form action="/group_kadai/grades/grades_list" method="get" onsubmit="stu_form()" >

	                <!-- 入学年度の選択 -->


	                <div id="opop"></div>


	                <div class="form-group">

	                <p>学生情報</p>



	                    <label for="stu_no">学生番号</label>

            			<input type="text" name="stu_no" value="${sub_cd}" maxlength="10" placeholder="学生番号を入力してください" required>

	                <!-- 検索ボタン -->
	                <button type="submit">検索</button>



	                </div>

	             </form>

	    </div>
    </div>




			<p>成績情報が存在しませんでした</p>

















</body>
</html>
