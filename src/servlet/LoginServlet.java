package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.TeacherDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("login");
        String password = request.getParameter("password");

        TeacherDAO teacherDao = new TeacherDAO();
        Teacher teacher = null;
        try {
            teacher = teacherDao.authenticate(loginId, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (teacher != null) {
            request.getSession().setAttribute("teacher", teacher);
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("errorMessage", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
