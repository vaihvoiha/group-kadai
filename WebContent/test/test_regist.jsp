<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean.Grades" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
</head>
<body>
    <%-- 検索画面 --%>
    <h2>成績管理</h2>
    <form action="<%= request.getContextPath() %>/YourJavaServlet" method="post">
        <table>
            <tr>
                <th>入学年度</th>
                <td>
                    <select name="f1">
                        <option value="--------">--------</option>
                        <%
                            List<Integer> enrollmentYears = (List<Integer>) application.getAttribute("enrollmentYears");
                            String selectedEntYear = (String) request.getAttribute("selectedEntYear");
                            if (enrollmentYears != null) {
                                for (Integer year : enrollmentYears) {
                                    String selected = (year.toString().equals(selectedEntYear)) ? "selected" : "";
                                    out.println("<option value=\"" + year + "\" " + selected + ">" + year + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <th>クラス</th>
                <td>
                    <select name="f2">
                        <option value="--------">--------</option>
                        <%
                            List<String> classNumbers = (List<String>) application.getAttribute("classNumbers");
                            String selectedClassNum = (String) request.getAttribute("selectedClassNum");
                            if (classNumbers != null) {
                                for (String classNum : classNumbers) {
                                    String selected = (classNum.equals(selectedClassNum)) ? "selected" : "";
                                    out.println("<option value=\"" + classNum + "\" " + selected + ">" + classNum + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <th>科目</th>
                <td>
                    <select name="f3">
                        <option value="--------">--------</option>
                        <%
                            List<String> subjectCodes = (List<String>) application.getAttribute("subjectCodes");
                            String selectedSubCd = (String) request.getAttribute("selectedSubCd");
                            if (subjectCodes != null) {
                                for (String subCd : subjectCodes) {
                                    String selected = (subCd.equals(selectedSubCd)) ? "selected" : "";
                                    out.println("<option value=\"" + subCd + "\" " + selected + ">" + subCd + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <th>回数</th>
                <td>
                    <select name="f4">
                        <option value="--------">--------</option>
                        <%
                            List<Integer> countNumbers = (List<Integer>) application.getAttribute("countNumbers");
                            String selectedCountNo = (String) request.getAttribute("selectedCountNo");
                            if (countNumbers != null) {
                                for (Integer count : countNumbers) {
                                    String selected = (count.toString().equals(selectedCountNo)) ? "selected" : "";
                                    out.println("<option value=\"" + count + "\" " + selected + ">" + count + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit">検索</button>
    </form>

    <%-- 検索結果画面 --%>
    <%
        List<Grades> scores = (List<Grades>) request.getAttribute("scores");
        if (scores != null) {
            String subject = (String) request.getAttribute("subject");
            int count = (int) request.getAttribute("count");
    %>
    <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
        <table border="1">
            <thead>
            <div>
                <strong>科目：</strong>
                <%= subject %> (<%= count %>回目)
            </div>
                <tr>
                    <th>入学年度</th>
                    <th>クラス</th>
                    <th>学生番号</th>
                    <th>氏名</th>
                    <th>点数</th>
                </tr>
            </thead>
            <tbody>
                <% for (Grades score : scores) { %>
                <tr>
                    <td><%= score.getEnt_year() %></td>
                    <td><%= score.getClass_num() %></td>
                    <td><%= score.getNo() %></td>
                    <td><%= score.getName() %></td>
                    <td>
                        <input type="hidden" name="student_no" value="<%= score.getNo() %>">
                        <input type="hidden" name="subject_cd" value="MATH">
                        <input type="hidden" name="school_cd" value="SCH001">
                        <input type="hidden" name="no" value="1">
                        <input type="hidden" name="class_num" value="<%= score.getClass_num() %>">
                        <input type="text" name="grade" value="<%= score.getPoint() %>">
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <button type="submit">登録して終了</button>
    </form>
    <% } %>

    <%-- 登録エラー画面 --%>
    <%
        String errorMessage = (String) request.getAttribute("error");
        if (errorMessage != null) {
    %>
    <div><%= errorMessage %></div>
    <% } %>
</body>
</html>
