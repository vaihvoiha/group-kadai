package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // H2データベースの接続設定（サーバーモード）
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/javasd"; // データベースURL
    private static final String DB_USER = "sa"; // ユーザー名
    private static final String DB_PASSWORD = ""; // パスワード

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストからパラメータを取得
        String gradeStr = request.getParameter("grade");
        String studentNo = request.getParameter("student_no");
        String subjectCd = request.getParameter("subject_cd");
        String schoolCd = request.getParameter("school_cd");
        String classNum = request.getParameter("class_num");
        String noStr = request.getParameter("no");

        System.out.println("Received parameters: grade=" + gradeStr + ", studentNo=" + studentNo +
                           ", subjectCd=" + subjectCd + ", schoolCd=" + schoolCd + ", classNum=" + classNum + ", no=" + noStr);

        int grade = 0; // デフォルト値を設定
        int no = 0;

        // gradeStr と noStr が null でも空文字でもないことを確認
        if (gradeStr != null && !gradeStr.isEmpty() && noStr != null && !noStr.isEmpty()) {
            try {
                // gradeStr と noStr を int に変換
                grade = Integer.parseInt(gradeStr);
                no = Integer.parseInt(noStr);
            } catch (NumberFormatException e) {
                // 数値に変換できない場合のエラーハンドリング
                e.printStackTrace();
                // エラーメッセージを設定してリクエストに追加
                request.setAttribute("error", "Invalid input.");
                response.getWriter().println("Invalid input.");
                return;
            }
        } else {
            // gradeStr または noStr が null または空の場合のエラーハンドリング
            request.setAttribute("error", "All inputs are required.");
            response.getWriter().println("All inputs are required.");
            return;
        }

        // H2データベースに接続して成績を保存する
        try {
            // データベース接続
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection established");

            // 重複確認クエリ
            String checkSql = "SELECT COUNT(*) FROM TEST WHERE STUDENT_NO = ? AND SUBJECT_CD = ? AND SCHOOL_CD = ? AND NO = ?";
            PreparedStatement checkSt = con.prepareStatement(checkSql);
            checkSt.setString(1, studentNo);
            checkSt.setString(2, subjectCd);
            checkSt.setString(3, schoolCd);
            checkSt.setInt(4, no);

            ResultSet rs = checkSt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            checkSt.close();

            if (count > 0) {
                // 重複がある場合はエラーメッセージを設定してリクエストに追加
                request.setAttribute("error", "Duplicate entry detected.");
                response.getWriter().println("Duplicate entry detected.");
                return;
            }

            // SQL文の準備
            String sql = "INSERT INTO TEST (STUDENT_NO, SUBJECT_CD, SCHOOL_CD, NO, POINT, CLASS_NUM) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            // パラメータの設定
            st.setString(1, studentNo); // STUDENT_NO
            st.setString(2, subjectCd); // SUBJECT_CD
            st.setString(3, schoolCd); // SCHOOL_CD
            st.setInt(4, no); // NO
            st.setInt(5, grade); // POINT
            st.setString(6, classNum); // CLASS_NUM

            // SQL実行
            int result = st.executeUpdate();
            System.out.println("Rows affected: " + result);

            // リソースのクローズ
            st.close();
            con.close();
        } catch (SQLException e) {
            // SQLエラーのハンドリング
            e.printStackTrace();
            request.setAttribute("error", "データベースエラーが発生しました。");
            response.getWriter().println("データベースエラーが発生しました: " + e.getMessage());
            return;
        }

        // 成功メッセージを設定してリクエストに追加
        request.setAttribute("message", "Grade registered successfully.");
        response.getWriter().println("Grade registered successfully.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GETリクエストを処理する場合のコードをここに記述
        // 必要に応じてフォームページにリダイレクト
        request.getRequestDispatcher("/test/test_regist_done.jsp").forward(request, response);
    }
}
