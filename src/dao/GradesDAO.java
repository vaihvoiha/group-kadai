package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Grades;

//成績管理一覧
//検索　入学　クラス　科目　回数
public class GradesDAO extends DAO {
	// 商品名で検索するメソッド
//	セッションでログイン中のアカウント情報を取得
	public List<Grades> search(int ent_year, String class_num, String sub_cd, int count_no) throws Exception {
		// Studentを要素に持つList
		List<Grades> list = new ArrayList<Grades>();

		// データベースに接続
		Connection con = getConnection();

		// データベースを使った処理を記述

		// 実行したいSQL文をプリペアードステートメントで準備
		// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"SELECT STUDENT .NO ,STUDENT.NAME ,STUDENT.ENT_YEAR ,STUDENT.CLASS_NUM ,TEST.POINT "
				+ "FROM STUDENT "
				+ "JOIN TEST "
				+ "ON STUDENT .NO  = STUDENT_NO  AND STUDENT .SCHOOL_CD  = TEST .SCHOOL_CD "
				+ "WHERE STUDENT .ENT_YEAR = ?"
				+ "AND STUDENT  . CLASS_NUM  = ?"
				+ "AND TEST .SUBJECT_CD  = ?"
				+ "AND TEST .POINT  = ?");

		st.setInt(1,ent_year );
		st.setString(2,class_num );
		st.setString(3,sub_cd );
		st.setInt(4,count_no );

		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Gradesクラスをインスタンス化
			Grades p = new Grades();
			// 値をセット
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setPoint(rs.getInt("point"));
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


//	学生別
//	SELECT
//    S.NO AS 学生番号,
//    S.NAME AS 学生名,
//    SU.CD AS 科目コード,
//    T.NO AS 回数,
//    T.POINT AS 得点
//FROM
//    STUDENT S
//JOIN
//    TEST T ON S.NO = T.STUDENT_NO
//JOIN
//    SUBJECT SU ON T.SUBJECT_CD = SU.CD

//ORDER BY SU.CD,T.NO



//	成績科目別
//
//	SELECT STUDENT .NO ,STUDENT.NAME ,STUDENT.ENT_YEAR ,STUDENT.CLASS_NUM ,TEST.POINT
//	FROM STUDENT
//	JOIN TEST
//	ON STUDENT .NO  = STUDENT_NO  AND STUDENT .SCHOOL_CD  = TEST .SCHOOL_CD
//	WHERE STUDENT .ENT_YEAR = 0000
//	AND STUDENT. CLASS_NUM  = 'p'
//	AND TEST .SUBJECT_CD  = 'l'
//
//order by no








//	成績管理SQL
//	SELECT *
//	FROM STUDENT
//	JOIN TEST
//	ON STUDENT .NO  = STUDENT_NO  AND STUDENT .SCHOOL_CD  = TEST .SCHOOL_CD
//	WHERE STUDENT .ENT_YEAR = 2001
//	AND STUDENT  . CLASS_NUM  = 'i'
//	AND TEST .SUBJECT_CD  = 'a'
//	AND TEST .POINT  = 0

//
//	SELECT STUDENT .NO ,STUDENT.NAME ,STUDENT.ENT_YEAR ,STUDENT.CLASS_NUM ,TEST.POINT
//	FROM STUDENT
//	JOIN TEST
//	ON STUDENT .NO  = STUDENT_NO  AND STUDENT .SCHOOL_CD  = TEST .SCHOOL_CD
//	WHERE STUDENT .ENT_YEAR = 0000
//	AND STUDENT. CLASS_NUM  = 'p'
//	AND TEST .SUBJECT_CD  = 'l'
//	AND TEST .POINT  = 9
