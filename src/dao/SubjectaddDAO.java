package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Subject;

public class SubjectaddDAO extends DAO {

    // 科目情報を登録するメソッド
    public int insert(Subject subject) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("INSERT INTO subject (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)");
        st.setString(1, subject.getSchool_cd());
        st.setString(2, subject.getCd());
        st.setString(3, subject.getName());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }
}
