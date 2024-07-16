package subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDAO;

@WebServlet("/subject/submit")
public class SubmitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ここでは何もしません
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");
        String school_cd = request.getParameter("school_cd");
        String errorMessage = "";

        // デバッグ用の出力
        System.out.println("科目コード: " + cd);
        System.out.println("科目名: " + name);
        System.out.println("学校コード: " + school_cd);

        // 科目コードの文字数チェック
        if (cd == null || cd.length() != 3) {
            errorMessage += "科目コードは三文字で入力してください。<br>";
        }

        SubjectDAO dao = new SubjectDAO();

        // 科目コードの重複チェック
        if (dao.get(cd, school_cd) != null) {
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
            request.setAttribute("school_cd", school_cd);
            request.getRequestDispatcher("/subject/subject_create.jsp").forward(request, response); // パスを修正
        } else {
            // データベースに登録
            Subject subject = new Subject();
            subject.setCd(cd);
            subject.setName(name);
            subject.setSchool_cd(school_cd);
            if (dao.insert2(cd, name, school_cd)) { // 変更箇所
                session.setAttribute("subject_create_done", true);
                response.sendRedirect("subject_create_done.jsp");
            } else {
                request.setAttribute("errorMessage", "データベースへの登録に失敗しました。");
                request.getRequestDispatcher("/subject/subject_create.jsp").forward(request, response); // パスを修正
            }
        }
    }
}
