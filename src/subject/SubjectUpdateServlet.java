package subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;

@WebServlet("/subject/subject_update")
public class SubjectUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");
        String errorMessage = "";

        // 科目コードの文字数チェック
        if (cd == null || cd.length() != 3) {
            errorMessage += "科目コードは三文字で入力してください。<br>";
        }

        SubjectDAO dao = new SubjectDAO();

        // 科目コードの重複チェック
        if (dao.get(cd, "") != null) {
            errorMessage += "科目コードが重複しています。<br>";
        }

        // 必須項目のチェック
        if (name == null || name.isEmpty()) {
            errorMessage += "科目名は必須項目です。<br>";
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("cd", cd);
            request.setAttribute("name", name);
            request.getRequestDispatcher("/subject/subject_update.jsp").forward(request, response); // パスを修正
        } else {
            // 成功した場合の処理
            Subject subject = new Subject();
            subject.setCd(cd);
            subject.setName(name);
            subject.setSchool_cd(""); // 必要に応じて修正
            if (dao.update(subject)) {
                response.sendRedirect("subject_update_done.jsp");
            } else {
                request.setAttribute("errorMessage", "データベースの更新に失敗しました。");
                request.getRequestDispatcher("/subject/subject_update.jsp").forward(request, response); // パスを修正
            }
        }
    }
}
