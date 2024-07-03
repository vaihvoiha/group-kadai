package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Grades;

public class GradesDAO2 extends DAO {

    // 成績を検索するメソッド
    public List<Grades> search(int ent_year, String class_num, String sub_cd, int count_no) throws Exception {
        List<Grades> list = new ArrayList<Grades>();

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "SELECT STUDENT.NO, STUDENT.NAME, STUDENT.ENT_YEAR, STUDENT.CLASS_NUM, TEST.POINT " +
                "FROM STUDENT " +
                "JOIN TEST " +
                "ON STUDENT.NO = TEST.STUDENT_NO AND STUDENT.SCHOOL_CD = TEST.SCHOOL_CD " +
                "WHERE STUDENT.ENT_YEAR = ? " +
                "AND STUDENT.CLASS_NUM = ? " +
                "AND TEST.SUBJECT_CD = ? " +
                "AND TEST.NO = ?");

        st.setInt(1, ent_year);
        st.setString(2, class_num);
        st.setString(3, sub_cd);
        st.setInt(4, count_no);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Grades p = new Grades();
            p.setEnt_year(rs.getInt("ENT_YEAR"));
            p.setClass_num(rs.getString("CLASS_NUM"));
            p.setNo(rs.getString("NO"));
            p.setName(rs.getString("NAME"));
            p.setPoint(rs.getInt("POINT"));
            list.add(p);
        }

        st.close();
        con.close();

        return list;
    }

    // 点数を登録するメソッド
    public void saveGrade(Grades grade, String subjectCd, String schoolCd, int countNo) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "INSERT INTO TEST (STUDENT_NO, SUBJECT_CD, SCHOOL_CD, NO, POINT, CLASS_NUM) " +
                "VALUES (?, ?, ?, ?, ?, ?)");

        st.setString(1, grade.getNo());
        st.setString(2, subjectCd);
        st.setString(3, schoolCd);
        st.setInt(4, countNo);
        st.setInt(5, grade.getPoint());
        st.setString(6, grade.getClass_num());

        st.executeUpdate();

        st.close();
        con.close();
    }

    // 点数を更新するメソッド
    public void updateGrade(Grades grade, String subjectCd, String schoolCd, int countNo) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "UPDATE TEST SET POINT = ? " +
                "WHERE STUDENT_NO = ? " +
                "AND SUBJECT_CD = ? " +
                "AND SCHOOL_CD = ? " +
                "AND NO = ? " +
                "AND CLASS_NUM = ?");

        st.setInt(1, grade.getPoint());
        st.setString(2, grade.getNo());
        st.setString(3, subjectCd);
        st.setString(4, schoolCd);
        st.setInt(5, countNo);
        st.setString(6, grade.getClass_num());

        st.executeUpdate();

        st.close();
        con.close();
    }
}
