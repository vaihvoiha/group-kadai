package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;

public class MenuAction extends Action {
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // セッションからユーザー情報を取得
        Teacher teacher = (Teacher) req.getSession().getAttribute("teacher");

        if (teacher == null) {
            // ユーザーが認証されていない場合、ログイン画面にリダイレクト
            res.sendRedirect("login.jsp");
        } else {
            // メニュー画面にフォワード
            req.getRequestDispatcher("menu.jsp").forward(req, res);
        }
    }
}
