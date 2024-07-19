package tool;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;

@WebServlet(urlPatterns = { "/login" })  // URLパターンを"/login"に変更
public class LoginController extends CommonServlet {

    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("login.jsp").forward(req, resp);  // ログインページのファイル名を修正
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        TeacherDAO dao = new TeacherDAO();
        Teacher teacher = dao.authenticate(login, password);  // メソッド名を変更

        // 認証できた場合
        if (teacher != null) {
            // セッションにユーザー情報を保存
            session.setAttribute("session_teacher", teacher);
            // ログイン後のページにリダイレクト
            resp.sendRedirect("/base.jsp");  // ログイン後のページのURLを修正
            return;
        }

        // 認証できなかった場合はログインページを表示
        req.setAttribute("errorMessage", "ログイン名またはパスワードが違います。");
        req.getRequestDispatcher("login.jsp").forward(req, resp);  // ログインページのファイル名を修正
    }
}
