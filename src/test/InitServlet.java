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
//import dao.TestListSubjectDAO;
//
//@WebServlet(value = "/InitServlet", loadOnStartup = 1)
//public class InitServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    public void init() throws ServletException {
//        try {
//            // DAOを使用して初期データを取得
//            TestListSubjectDAO dao = new TestListSubjectDAO();
//            List<Integer> enrollmentYears = dao.getEnrollmentYears();
//            List<String> classNumbers = dao.getClassNumbers();
//            List<String> subjectCodes = dao.getSubjectCodes();
//
//            // 取得したデータをServletContextに設定
//            getServletContext().setAttribute("enrollmentYears", enrollmentYears);
//            getServletContext().setAttribute("classNumbers", classNumbers);
//            getServletContext().setAttribute("subjectCodes", subjectCodes);
//        } catch (Exception e) {
//            // エラーログの出力
//            e.printStackTrace();
//            // 初期データのロードに失敗した場合、ServletExceptionをスロー
//            throw new ServletException("Failed to load initial data", e);
//        }
//    }
//
//    // GETリクエストを処理するメソッド
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // JSPページにフォワード
//        request.getRequestDispatcher("/test/test_list.jsp").forward(request, response);
//    }
//}
