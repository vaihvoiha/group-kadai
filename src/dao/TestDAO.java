package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDAO extends DAO {
    public void registerTest(String studentId, String subjectId) throws Exception {
        Connection con = getConnection();
        try {
            String sql = "INSERT INTO TESTS (student_id, subject_id) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, studentId);
            st.setString(2, subjectId);
            st.executeUpdate();
            st.close();
        } finally {
            con.close();
        }
    }
}
