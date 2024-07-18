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
//import bean.TestListStudent;
//import dao.TestListStudentDAO;
//
//@WebServlet("/YourStudentSearchServlet")
//public class YourStudentSearchServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    // POSTリクエストを処理するメソッド
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // デバッグログ追加
//        System.out.println("YourStudentSearchServlet: doPost called");
//        try {
//            // リクエストパラメータから学生番号を取得
//            String studentNo = request.getParameter("f4");
//            // 取得した学生番号をデバッグログに出力
//            System.out.println("Received studentNo: " + studentNo);
//
//            // 学生番号が未入力または空白の場合の処理
//            if (studentNo == null || studentNo.trim().isEmpty()) {
//                System.out.println("No student number provided"); // デバッグログ追加
//                request.setAttribute("studentError", "学生番号を入力してください。");
//                request.getRequestDispatcher("/test/test_list_student2.jsp").forward(request, response);
//                return;
//            }
//
//            // DAOを使用して学生番号で成績を検索
//            TestListStudentDAO dao = new TestListStudentDAO();
//            List<TestListStudent> studentScores = dao.search_stu_no(studentNo);
//
//            // 検索結果の件数をデバッグログに出力
//            System.out.println("Found " + studentScores.size() + " student scores");
//
//            // 検索結果をリクエスト属性にセット
//            request.setAttribute("studentScores", studentScores);
//            if (!studentScores.isEmpty()) {
//                // 検索結果が存在する場合、学生名と学生番号をリクエスト属性にセット
//                request.setAttribute("studentName", studentScores.get(0).getStudentName());
//                request.setAttribute("studentNumber", studentScores.get(0).getStudentNo());
//            }
//            // 検索結果表示ページにフォワード
//            request.getRequestDispatcher("/test/test_list_student2.jsp").forward(request, response);
//        } catch (Exception e) {
//            // エラーが発生した場合の処理
//            e.printStackTrace();
//            request.setAttribute("studentError", "成績の検索中にエラーが発生しました。");
//            request.getRequestDispatcher("/test/test_list_student2.jsp").forward(request, response);
//        }
//    }
//}
