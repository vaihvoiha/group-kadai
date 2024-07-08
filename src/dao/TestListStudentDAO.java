package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListStudent;


public class TestListStudentDAO extends DAO {
//	成績参照一覧（学生別）
		// 商品名で検索するメソッド
//		セッションでログイン中のアカウント情報を取得
	public List<TestListStudent> search_stu_no(String student_no) throws Exception {
			// TestListStudentを要素に持つList
		List<TestListStudent> list = new ArrayList<TestListStudent>();

			// データベースに接続
		Connection con = getConnection();

			// データベースを使った処理を記述

			// 実行したいSQL文をプリペアードステートメントで準備
			// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT"
				+ "S.NO AS 学生番号,"
				+ "S.NAME AS 学生名,"
				+ "SU.CD AS 科目コード,"
				+ "T.NO AS 回数,"
				+ "T.POINT AS 得点"
				+ "FROM"
				+ "STUDENT S"
				+ "JOIN"
				+ "TEST T ON S.NO = T.STUDENT_NO"
				+ "JOIN"
				+ "SUBJECT SU ON T.SUBJECT_CD = SU.CD"
				+ "WHERE "
				+ "S.NO = ?"
				+ "ORDER BY SU.CD,T.NO");

		st.setString(1,student_no );

		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// TestListStudentクラスをインスタンス化
			TestListStudent p = new TestListStudent();
			// 値をセット
			p.setStudentName(rs.getString("studentName"));
			p.setStudentNo(rs.getString("studentNo"));
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


}
