package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student_Name;
import bean.TestListStudent;


public class TestListStudentDAO extends DAO {


//	成績参照一覧（学生別）
		// 商品名で検索するメソッド
//		セッションでログイン中のアカウント情報を取得
	public List<TestListStudent> search_stu_no(String student_no, Object school_cd ) throws Exception {
			// TestListStudentを要素に持つList
		List<TestListStudent> list = new ArrayList<TestListStudent>();

			// データベースに接続
		Connection con = getConnection();

			// データベースを使った処理を記述

			// 実行したいSQL文をプリペアードステートメントで準備
			// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT "
				+ "T.SUBJECT_CD  AS subjectCd,	"
				+ " SU.NAME AS subjectName, "
				+ "T.NO AS test_no, "
				+ "T.POINT AS test_point "
				+ "FROM "
				+ "TEST T  "
				+ "LEFT OUTER JOIN   "
				+ "SUBJECT SU "
				+ "ON T.SUBJECT_CD = SU.CD "
				+ "WHERE "
				+ "T.STUDENT_NO  like ? "
				+ "AND "
				+ "SU.SCHOOL_CD like ? "
				+ "ORDER BY SU.CD,T.NO "
				);

		st.setString(1,  student_no  );
		st.setObject(2,school_cd );

		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// TestListStudentクラスをインスタンス化
			TestListStudent p = new TestListStudent();
			// 値をセット
			p.setSubjectName(rs.getString("subjectName"));
			p.setSubjectCd(rs.getString("subjectCd"));
			p.setTest_no(rs.getInt("test_no"));
			p.setTest_point(rs.getInt("test_point"));
			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}


//	学生番号で選択した学生の名前
		// 商品名で検索するメソッド
//		セッションでログイン中のアカウント情報を取得
	public List<Student_Name> name_select(String student_no, Object school_cd ) throws Exception {
			// TestListStudentを要素に持つList
		List<Student_Name> list = new ArrayList<Student_Name>();

			// データベースに接続
		Connection con = getConnection();

			// データベースを使った処理を記述

			// 実行したいSQL文をプリペアードステートメントで準備
			// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT NAME  FROM STUDENT "
				+ "WHERE NO like ? "
				+ "AND SCHOOL_CD like ? "
				);

		st.setString(1,  student_no  );
		st.setObject(2,school_cd );

		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Student_Nameクラスをインスタンス化
			Student_Name p = new Student_Name();
			// 値をセット
			p.setName(rs.getString("name"));

			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}




}
