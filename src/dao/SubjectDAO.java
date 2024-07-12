package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;
import util.DbUtil;

public class SubjectDAO {

    // 科目をIDと学校コードで取得
    public Subject get(String cd, String schoolCd) {
        Subject subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, schoolCd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject = new Subject();
                subject.setCd(rs.getString("CD"));
                subject.setName(rs.getString("NAME"));
                subject.setSchoolCd(rs.getString("SCHOOL_CD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subject;
    }

    // すべての科目を取得
    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM SUBJECT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("CD"));
                subject.setName(rs.getString("NAME"));
                subject.setSchoolCd(rs.getString("SCHOOL_CD"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subjects;
    }

    // 科目を追加
    public boolean insert(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO SUBJECT (CD, NAME, SCHOOL_CD) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getName());
            ps.setString(3, subject.getSchoolCd());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を更新
    public boolean update(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "UPDATE SUBJECT SET NAME = ? WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getCd());
            ps.setString(3, subject.getSchoolCd());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を削除
    public boolean delete(String cd, String schoolCd) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, schoolCd);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }
}
