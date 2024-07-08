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
    public Subject get(String id, String school_cd) {
        Subject subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM subjects WHERE id = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, school_cd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchool_cd(rs.getString("school_cd"));
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
            String sql = "SELECT * FROM subjects";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchool_cd(rs.getString("school_cd"));
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
            String sql = "INSERT INTO subjects (cd, name, school_cd) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getName());
            ps.setString(3, subject.getSchool_cd());
            result = ps.executeUpdate() > 0;
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
            String sql = "UPDATE subjects SET name = ?, school_cd = ? WHERE cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getSchool_cd());
            ps.setString(3, subject.getCd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を削除
    public boolean delete(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM subjects WHERE cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }
}
