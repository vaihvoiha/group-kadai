package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDAO extends DAO {
    public void registerTest(String studentId, String subjectId) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO tests (student_id, subject_id) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, studentId);
                stmt.setString(2, subjectId);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
