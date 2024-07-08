package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListSubject;

public class TestListSubjectDAO  extends DAO {

//	成績参照一覧（科目別）
		// 商品名で検索するメソッド
//		セッションでログイン中のアカウント情報を取得
	public List<TestListSubject> search_kamoku(int ent_year, String class_num, String sub_cd) throws Exception {
			// Studentを要素に持つList
		List<TestListSubject> list = new ArrayList<TestListSubject>();

			// データベースに接続
		Connection con = getConnection();

			// データベースを使った処理を記述

			// 実行したいSQL文をプリペアードステートメントで準備
			// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT "
				+ "S.NO AS 学生番号,"
				+ "S.NAME AS 学生名,"
				+ "S.ENT_YEAR AS 入学年度,"
				+ "S.CLASS_NUM  AS クラス,"
				+ "MAX(CASE WHEN T.NO = 1 THEN T.POINT END) AS 得点_回数1,"
				+ "MAX(CASE WHEN T.NO = 2 THEN T.POINT END) AS 得点_回数2"
				+ "FROM "
				+ "STUDENT S"
				+ "LEFT JOIN "
				+ "TEST T ON S.NO = T.STUDENT_NO"
				+ "WHERE"
				+ "S.ENT_YEAR= ? "
				+ "AND S.CLASS_NUM = ?"
				+ "AND T.SUBJECT_CD = ?"
				+ "GROUP BY "
				+ "S.NO, S.NAME, S.ENT_YEAR"
				+ "ORDER BY "
				+ "S.NO");



		st.setInt(1,ent_year );
		st.setString(2,class_num );
		st.setString(3,sub_cd );


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
			p.setPoint1(rs.getInt("point1"));

			p.setPoint2(rs.getInt("point2"));
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
