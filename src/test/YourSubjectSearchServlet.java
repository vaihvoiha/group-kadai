//package test;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import bean.TestListSubject;
//import dao.TestListSubjectDAO;
//
//@WebServlet("/YourSubjectSearchServlet")
//public class YourSubjectSearchServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    // GETリクエストを処理するメソッド
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // JSPページにフォワード
//        request.getRequestDispatcher("/test/test_list.jsp").forward(request, response);
//    }
//
//    // POSTリクエストを処理するメソッド
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            // リクエストパラメータの取得
//            String entYearStr = request.getParameter("f1");
//            String classNum = request.getParameter("f2");
//            String subCd = request.getParameter("f3");
//
//            // 選択された値をリクエスト属性にセット
//            request.setAttribute("selectedEntYear", entYearStr);
//            request.setAttribute("selectedClassNum", classNum);
//            request.setAttribute("selectedSubCd", subCd);
//
//            // フィールドの未選択チェック
//            if ("--------".equals(entYearStr) || "--------".equals(classNum) || "--------".equals(subCd)) {
//                request.setAttribute("subjectError", "全てのフィールドを正しく選択してください。");
//                request.getRequestDispatcher("/test/test_list.jsp").forward(request, response);
//                return;
//            }
//
//            // 入学年度を整数に変換
//            int entYear = Integer.parseInt(entYearStr);
//
//            // DAOを使用して科目の成績を検索
//            TestListSubjectDAO dao = new TestListSubjectDAO();
//            List<TestListSubject> subjectScores = dao.search_kamoku(entYear, classNum, subCd);
//
//            // 検索結果をリクエスト属性にセット
//            request.setAttribute("subjectScores", subjectScores);
//            request.setAttribute("subjectName", subCd); // 追加：科目名を設定
//
//            // 成績表示ページにフォワード
//            request.getRequestDispatcher("/test/test_list_student.jsp").forward(request, response);
//        } catch (NumberFormatException e) {
//            // 数字変換エラーの処理
//            e.printStackTrace();
//            request.setAttribute("subjectError", "入学年度は数字で入力してください。");
//            request.getRequestDispatcher("/test/test_list.jsp").forward(request, response);
//        } catch (Exception e) {
//            // その他のエラー処理
//            e.printStackTrace();
//            request.setAttribute("subjectError", "成績の検索中にエラーが発生しました。");
//            request.getRequestDispatcher("/test/test_list.jsp").forward(request, response);
//        }
//    }
//}
