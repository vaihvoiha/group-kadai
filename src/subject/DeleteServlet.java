//package subject;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.Subject;
//import dao.SubjectDAO;
//
//@WebServlet("/subject/delete")
//public class DeleteServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String cd = request.getParameter("cd");
//        HttpSession session = request.getSession();
//        String school_cd = (String) session.getAttribute("school_cd"); // セッションからschool_cdを取得
//
//        // デバッグメッセージ
//        System.out.println("cd: " + cd);
//        System.out.println("school_cd: " + school_cd);
//
//        SubjectDAO dao = new SubjectDAO();
//        Subject subject = dao.get(cd, school_cd);
//
//        if (subject != null) {
//            dao.delete(subject);
//            // 削除完了画面にリダイレクト
//            response.sendRedirect("subject_delete_done.jsp");
//        } else {
//            // エラーメッセージを設定して戻る
//            request.setAttribute("errorMessage", "指定された科目が見つかりません。");
//            request.getRequestDispatcher("subject_list.jsp").forward(request, response);
//        }
//    }
//}
