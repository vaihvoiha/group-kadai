package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Student;
import bean.Subject;

public class SubjectaddDAO extends DAO {

    // 科目情報を登録するメソッド
    public int insert(Subject subject) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("INSERT INTO subject (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)");
        st.setString(1, subject.getSchoolCd());
        st.setString(2, subject.getCd());
        st.setString(3, subject.getName());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }


    // 学生情報を登録するメソッド
    public int insert(Student student) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("INSERT INTO student (NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)");
        st.setString(1, student.getNo());
        st.setString(2, student.getName());
        st.setInt(3, student.getEnt_year());
        st.setString(4, student.getClass_num());
        st.setBoolean(5, student.getIs_attend());
        st.setString(6, student.getSchool_cd());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }

}
