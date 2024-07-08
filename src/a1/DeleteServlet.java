package a1;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");

        // ここに科目削除のロジックを追加
        // 例: Databaseから該当の科目コードを持つレコードを削除

        // 削除完了画面にリダイレクト
        response.sendRedirect("subject_delete_done.jsp");
    }
}
