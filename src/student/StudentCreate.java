package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/student/student_create"})
public class StudentCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("student_create.jsp").forward(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ent_year = request.getParameter("ent_year");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String class_num = request.getParameter("class_num");
        String errorMessage = null;

        // 入学年度の入力チェック
        if (ent_year == null || ent_year.isEmpty()) {
            errorMessage += "入学年度を選択してください<br>";
        }

        // 学生番号の入力チェック
        if (no == null || no.isEmpty()) {
            errorMessage += "学生番号が重複しています<br>";
        }

        // 必須項目のチェック
        if (name == null || name.isEmpty()) {
            errorMessage += "氏名を入力してください<br>";
        }

        // 必須項目のチェック
        if (class_num == null || class_num.isEmpty()) {
            errorMessage += "クラスを入力してください<br>";
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("ent_year", ent_year);
            request.setAttribute("no", no);
            request.setAttribute("class_num", class_num);
            request.getRequestDispatcher("/student_list.jsp").forward(request, response);
        } else {
            // 成功した場合の処理（例：データベースに登録）
            response.sendRedirect("student_create_done.jsp");
        }
    }
}
