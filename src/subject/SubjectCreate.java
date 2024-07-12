package subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;

@WebServlet("/subject_create")
public class SubjectCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/subject_create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String schoolCd = request.getParameter("schoolCd");

        Subject subject = new Subject();
        subject.setCd(code);
        subject.setName(name);
        subject.setSchoolCd(schoolCd);

        SubjectDAO subjectDAO = new SubjectDAO();
        boolean success = subjectDAO.insert(subject);

        if (success) {
            response.sendRedirect("/subject_create_done.jsp");
        } else {
            request.setAttribute("errorMessage", "登録に失敗しました。");
            request.getRequestDispatcher("/subject_create.jsp").forward(request, response);
        }
    }
}
