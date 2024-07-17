package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.TeacherDAO;

public class LoginExecuteAction extends Action {
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        // 入力バリデーション
        if (id == null || id.isEmpty() || password == null || password.isEmpty()) {
            res.sendRedirect("login.jsp?error=empty");
            return;
        }

        TeacherDAO teacherDao = new TeacherDAO();
        Teacher teacher = null;
        try {
            teacher = teacherDao.authenticate(id, password);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("login.jsp?error=system");
            return;
        }

        if (teacher != null) {
            // 認証成功
            req.getSession().setAttribute("teacher", teacher);
            res.sendRedirect("menu.jsp");
        } else {
            // 認証失敗
            res.sendRedirect("login.jsp?error=invalid");
        }
    }
}
