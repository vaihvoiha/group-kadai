package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bean.Teacher;

public class TeacherDAO extends DAO {

    /**
     * 教員をIDで検索するメソッド
     *
     * @param id
     * @return 一致するデータが存在する：Teacher、存在しない：null
     * @throws Exception
     */
    public Teacher searchByID(String id) throws Exception {
        Teacher teacher = null;

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getString("ID"));
            teacher.setPassword(rs.getString("PASSWORD"));
        }

        st.close();
        con.close();

        return teacher;
    }

    /**
     * 教員をログインIDとパスワードで認証するメソッド
     *
     * @param id
     * @param password
     * @return 認証成功：Teacher、認証失敗：null
     * @throws Exception
     */
    public Teacher authenticate(String id, String password) throws Exception {
        Teacher teacher = null;

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
            if (bcpe.matches(password, rs.getString("PASSWORD"))) {
                teacher = new Teacher();
                teacher.setId(rs.getString("ID"));
                teacher.setPassword(rs.getString("PASSWORD"));
            }
        }

        st.close();
        con.close();

        return teacher;
    }
}
