package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Grades;
import dao.GradesDAO2;

@WebServlet("/YourJavaServlet")
public class YourJavaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // リクエストパラメータの取得
            int entYear = Integer.parseInt(request.getParameter("f1"));
            String classNum = request.getParameter("f2");
            String subCd = request.getParameter("f3");
            int countNo = Integer.parseInt(request.getParameter("f4"));

            // デバッグ用のログ出力
            System.out.println("Received parameters: entYear=" + entYear + ", classNum=" + classNum + ", subCd=" + subCd + ", countNo=" + countNo);

            // DAOを使用してデータベースから成績を検索
            GradesDAO2 dao = new GradesDAO2();
            List<Grades> scores = dao.search(entYear, classNum, subCd, countNo);

            // 検索結果をリクエスト属性にセット
            request.setAttribute("scores", scores);
            if (!scores.isEmpty()) {
                request.setAttribute("subject", subCd);
                request.setAttribute("count", countNo);
            }
            // JSPにフォワード
            request.getRequestDispatcher("/test/test_regist.jsp").forward(request, response);
        } catch (Exception e) {
            // エラーログの出力
            e.printStackTrace();
            // エラーメッセージをリクエスト属性にセット
            request.setAttribute("error", "検索中にエラーが発生しました。");
            // JSPにフォワード
            request.getRequestDispatcher("/test/test_regist.jsp").forward(request, response);
        }
    }
}
