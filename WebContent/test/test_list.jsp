<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
</head>
<body>
    <h2>成績参照</h2>

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
        	<th>学生番号</th>
            <input type="text" name="f4" value="${f4}" maxlength="10" placeholder="学生番号を入力してください">
            <button type="submit">検索</button>
        </form>
    </div>

    <p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>

    <input type="hidden" name="f" value="sj">
</body>
</html>
