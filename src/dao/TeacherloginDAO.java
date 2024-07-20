package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

// TeacherloginDAOクラスは、データベース操作を行うためのDAOクラス
public class TeacherloginDAO {
    // データベース接続情報を定数として定義
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/javasd";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    // データベース接続を取得するメソッド
    public Connection getConnection() throws Exception {
        // H2データベースのJDBCドライバをロード
        Class.forName("org.h2.Driver");
        // データベース接続を確立し、接続オブジェクトを返す
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 指定されたIDに基づいて教師情報を検索するメソッド
    public Teacher searchByID(String id) throws Exception {
        Teacher teacher = null;
        // データベース接続を取得
        Connection con = getConnection();
        // 指定されたIDに基づいて教師情報を検索するSQL文を準備
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER WHERE ID=?");
        st.setString(1, id);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = st.executeQuery();
        // 結果セットから教師情報を抽出し、Teacherオブジェクトを作成
        if (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getString("ID"));
            teacher.setPassword(rs.getString("PASSWORD"));
            teacher.setName(rs.getString("NAME"));
            teacher.setSchoolCd(rs.getString("SCHOOL_CD"));
        }
        // リソースをクローズ
        rs.close();
        st.close();
        con.close();
        return teacher;
    }

    // 指定されたIDとパスワードに基づいて認証を行うメソッド
    public Teacher authenticate(String id, String password) throws Exception {
        Teacher teacher = null;
        // データベース接続を取得
        Connection con = getConnection();
        // 指定されたIDとパスワードに基づいて教師情報を検索するSQL文を準備
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER WHERE ID=? AND PASSWORD=?");
        st.setString(1, id);
        st.setString(2, password);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = st.executeQuery();
        // 結果セットから教師情報を抽出し、Teacherオブジェクトを作成
        if (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getString("ID"));
            teacher.setPassword(rs.getString("PASSWORD"));
            teacher.setName(rs.getString("NAME"));
            teacher.setSchoolCd(rs.getString("SCHOOL_CD"));
        }
        // リソースをクローズ
        rs.close();
        st.close();
        con.close();
        return teacher;
    }
}
