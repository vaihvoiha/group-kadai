package a1;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject/submit")
public class SubmitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String errorMessage = "";

        // 科目コードの文字数チェック
        if (code == null || code.length() != 3) {
            errorMessage += "科目コードは三文字で入力してください。<br>";
        }

        // 科目コードの重複チェック（仮のチェック例、実際にはデータベースなどで確認）
        if ("ABC".equals(code)) { // 例として "ABC" が重複していると仮定
            errorMessage += "科目コードが重複しています。<br>";
        }

        // 必須項目のチェック
        if (name == null || name.isEmpty()) {
            errorMessage += "科目名は必須項目です。<br>";
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("code", code);
            request.setAttribute("name", name);
            request.getRequestDispatcher("/subject_create.jsp").forward(request, response);
        } else {
            // 成功した場合の処理（例：データベースに登録）
            response.sendRedirect("subject_create_done.jsp");
        }
    }
}
