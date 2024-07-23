
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ja">

<head>

    <%@ include file="./../header.html" %>

    <meta charset="UTF-8">

    <title>得点管理システム</title>

    <style>

        .menu {

            border-right: 2px solid #eaeaea; /* 右側にボーダーを追加 */

            padding: 20px;

            margin-left: 150px;

        }

        .container {

            display: flex;

        }

        .content {

            width: 100%;

            padding: 20px;

            margin-right: 150px;

        }

        h2 {

            background-color: #f2f2f2;

            text-align: left;

            padding: 5px 20px;

        }

        .form-row {

            display: flex;

            align-items: center;

            margin-bottom: 10px; /* 各行の間隔を調整 */

        }

        .form-row select,

        .form-row input,

        .form-row button {

            margin-right: 10px;

        }

        .form-row label {

            margin-right: 5px;

        }

        .form-row .search-btn {

            margin-left: 10px;

        }

        p {

            color: #66ccff;

        }

        .waku {

            border: 1px solid #ccc;

            border-radius: 10px;

            padding: 10px;

            margin-bottom: 20px;

        }

    </style>

</head>

<body>

    <div class="container">

        <%@ include file="./../base.html" %>

        <div class="content">

            <div class="content-header">

                <h2>成績参照</h2>

                <div class="waku">

                    <div>

                        <h3>科目情報</h3>

                        <form action="/group_kadai/grades/grades_list" method="get" onsubmit="stu_form()">


                            <div class="form-row">

                                <label for="ent_year">入学年度</label>

                                <select id="ent_year" name="ent_year">

                                    <option value="">-------</option>

                                    <!-- 動的に年を追加 -->

                                    <c:forEach var="year" items="${years}">

                                        <option value="${year.ent_year}">${year.ent_year}</option>

                                    </c:forEach>

                                </select>

                                <label for="class_num">クラス</label>

                                <select id="class_num" name="class_num">

                                    <option value="">-------</option>

                                    <!-- 動的にクラスを追加 -->

                                    <c:forEach var="classes" items="${classes}">

                                        <option value="${classes.class_num}">${classes.class_num}</option>

                                    </c:forEach>

                                </select>

                                <label for="sub_cd">科目</label>

                                <select id="sub_cd" name="sub_cd">

                                    <option value="">-------</option>

                                    <!-- 動的に科目を追加 -->

                                    <c:forEach var="subject" items="${subject}">

                                        <option value="${subject.subject_name}">${subject.subject_name}</option>

                                    </c:forEach>

                                </select>

                                <button type="submit" class="search-btn">検索</button>

                            </div>

                            <!-- エラーメッセージ -->

                            <div class="error_message">${error_message}</div>

                        </form>

                    </div>

                    <div>

                        <h3>学生情報</h3>

                        <form action="/group_kadai/grades/grades_list" method="get" onsubmit="stu_form()">

                            <!-- 学生番号、検索ボタンを横並びに -->

                            <div class="form-row">

                                <label for="stu_no">学生番号</label>

                                <input type="text" name="stu_no" value="${sub_cd}" maxlength="10" placeholder="学生番号を入力してください" required>

                                <button type="submit" class="search-btn">検索</button>

                            </div>

                        </form>

                    </div>

                </div>

                <p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>

            </div>

        </div>

    </div>

</body>

</html>

