package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListSubject;

public class TestListSubjectDAO  extends DAO {

//	成績参照一覧（科目別）
//		セッションでログイン中のアカウント情報を取得
	public List<TestListSubject> search_kamoku(String ent_year, String class_num, String sub_cd,Object school_cd) throws Exception {
			// Studentを要素に持つList
		List<TestListSubject> list = new ArrayList<TestListSubject>();

			// データベースに接続
		Connection con = getConnection();

			// データベースを使った処理を記述

			// 実行したいSQL文をプリペアードステートメントで準備
			// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT "
				+ "S.NO AS studentNo,"
				+ "S.NAME AS studentName,"
				+ "S.ENT_YEAR AS entYear,"
				+ "S.CLASS_NUM  AS classNum,"
				+ "COALESCE("
				+ "cast(MAX(CASE WHEN T.NO = 1 THEN T.POINT END) AS CHAR),'-') AS Point1,"
				+ "COALESCE (cast(MAX(CASE WHEN T.NO = 2 THEN T.POINT END) AS char),'-') AS Point2 "
				+ "FROM "
				+ "STUDENT S"
				+ " LEFT JOIN "
				+ "TEST T ON S.NO = T.STUDENT_NO "
				+ "JOIN SUBJECT  SUB ON T.SUBJECT_CD = SUB.CD "
				+ "WHERE "
				+ "S.cast(ENT_YEAR as char) like ? "
				+ "AND S.CLASS_NUM like ? "
				+ "AND SUB.NAME like ? "
				+ "AND S.SCHOOL_CD like ? "
				+ "GROUP BY "
				+ "S.NO, S.NAME, S.ENT_YEAR "
				+ "ORDER BY "
				+ "S.NO");



		st.setString(1,"%" + ent_year + "%" );
		st.setString(2,"%"+class_num+"%" );
		st.setString(3,"%"+sub_cd + "%");
		st.setString(4,"%"+school_cd +"%");


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// TestListSubjectクラスをインスタンス化
			TestListSubject p = new TestListSubject();
			// 値をセット
			p.setEntYear(rs.getInt("entYear"));
			p.setClassNum(rs.getString("classNum"));
			p.setStudentNo(rs.getString("studentNo"));
			p.setStudentName(rs.getString("studentName"));
			p.setPoint1(rs.getString("point1"));

			p.setPoint2(rs.getString("point2"));
			// リストに追加
			list.add(p);
		}
		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}








	public List<Integer> getEnrollmentYears() throws Exception {
        List<Integer> years = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT ORDER BY ENT_YEAR")) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    years.add(rs.getInt("ENT_YEAR"));
                }
            }
        }

        return years;
    }

    public List<String> getClassNumbers() throws Exception {
        List<String> classNumbers = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT DISTINCT CLASS_NUM FROM STUDENT ORDER BY CLASS_NUM")) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    classNumbers.add(rs.getString("CLASS_NUM"));
                }
            }
        }

        return classNumbers;
    }

    public List<String> getSubjectCodes() throws Exception {
        List<String> subjectCodes = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT CD FROM SUBJECT ORDER BY CD")) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    subjectCodes.add(rs.getString("CD"));
                }
            }
        }

        return subjectCodes;
    }

}
