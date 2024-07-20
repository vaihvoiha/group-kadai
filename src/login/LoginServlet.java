package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.TeacherloginDAO;

// @WebServletアノテーションで、URLパターン"/login"にマッピングされたサーブレットクラス
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPostメソッドはHTTP POSTリクエストを処理する
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストの文字エンコーディングをUTF-8に設定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータからIDとパスワードを取得
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        try {
            // TeacherloginDAOのインスタンスを作成
            TeacherloginDAO dao = new TeacherloginDAO();
            // DAOのauthenticateメソッドを使用して、IDとパスワードで認証を行う
            Teacher teacher = dao.authenticate(id, password);

            // 認証に成功した場合
            if (teacher != null) {
                // mainページにリダイレクト
                response.sendRedirect("./main.jsp");
            } else {
                // 認証に失敗した場合
                // エラーメッセージをリクエストに設定し、ログインページにフォワード
                request.setAttribute("errorMessage", "認証エラー: ログインIDまたはパスワードが間違っています。");
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 例外が発生した場合、ServletExceptionをスロー
            throw new ServletException(e);
        }
    }
}
