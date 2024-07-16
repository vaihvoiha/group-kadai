<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean.TestListStudent" %>
<%@ page import="bean.TestListSubject" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
</head>
<body>
    <h2>成績一覧（科目）</h2>

    <div>
        <h3>科目情報</h3>
        <form action="<%= request.getContextPath() %>/YourSubjectSearchServlet" method="post">
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
            </table>
            <button type="submit">検索</button>
        </form>
    </div>

    <div>
        <h3>学生情報</h3>
        <form action="<%= request.getContextPath() %>/YourStudentSearchServlet" method="post">
            <p>学生番号を入力してください:</p>
            <input type="text" name="f4" value="${f4}" maxlength="10" placeholder="学生番号を入力してください">
            <button type="submit">検索</button>
        </form>
    </div>

    <input type="hidden" name="f" value="sj">

    <%-- 科目別成績一覧表示 --%>
    <%
        List<TestListSubject> subjectScores = (List<TestListSubject>) request.getAttribute("subjectScores");
        if (subjectScores != null && !subjectScores.isEmpty()) {
            String subjectName = (String) request.getAttribute("subjectName"); // 追加
    %>
    <div>
        <div>
            <strong>科目：</strong>
            <%= subjectName %>
        </div>
        <table border="1">
            <thead>
                <tr>
                    <th>入学年度</th>
                    <th>クラス</th>
                    <th>学生番号</th>
                    <th>氏名</th>
                    <th>1回の点数</th>
                    <th>2回の点数</th>
                </tr>
            </thead>
            <tbody>
                <% for (TestListSubject score : subjectScores) { %>
                <tr>
                    <td><%= score.getEntYear() %></td>
                    <td><%= score.getClassNum() %></td>
                    <td><%= score.getStudentNo() %></td>
                    <td><%= score.getStudentName() %></td>
                    <td><%= score.getPoint1() %></td>
                    <td><%= score.getPoint2() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>

    <%-- 科目別成績一覧エラーメッセージ --%>
    <%
        String subjectError = (String) request.getAttribute("subjectError");
        if (subjectError != null) {
    %>
    <div>
        <p style="color:red;"><%= subjectError %></p>
    </div>
    <% } %>

    <%-- 学生別成績一覧表示 --%>
    <%
        List<TestListStudent> studentScores = (List<TestListStudent>) request.getAttribute("studentScores");
        if (studentScores != null && !studentScores.isEmpty()) {
    %>
    <div>
        <h3>学生別成績一覧</h3>
        <div>
            <strong>氏名：</strong>
            <%= request.getAttribute("studentName") %> (<%= request.getAttribute("studentNumber") %>)
        </div>
        <table border="1">
            <thead>
                <tr>
                    <th>科目名</th>
                    <th>科目コード</th>
                    <th>回数</th>
                    <th>点数</th>
                </tr>
            </thead>
            <tbody>
                <% for (TestListStudent score : studentScores) { %>
                <tr>
                    <td><%= score.getSubjectName() %></td>
                    <td><%= score.getSubjectCd() %></td>
                    <td><%= score.getTest_no() %></td>
                    <td><%= score.getTest_point() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>

    <%-- 学生別成績一覧エラーメッセージ --%>
    <%
        String studentError = (String) request.getAttribute("studentError");
        if (studentError != null) {
    %>
    <div>
        <p style="color:red;"><%= studentError %></p>
    </div>
    <% } %>
</body>
</html>
