package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;


//学生検索　クラス　入学年　在学中　学校コード
public class StudentDAO extends DAO {

//	セッションでログイン中のアカウント情報を取得
	public List<Student> search(String key_class, int key_year, boolean key_attend, String school_cd) throws Exception {
		// Studentを要素に持つList
		List<Student> list = new ArrayList<Student>();

		// データベースに接続
		Connection con = getConnection();

		// データベースを使った処理を記述

		// 実行したいSQL文をプリペアードステートメントで準備
		// "?" -> プレースホルダ
		PreparedStatement st = con.prepareStatement(
				"select * from product where ENT_YEAR= ?"
				+ "and CLASS_NUM = ? "
				+ "and IS_ATTEND = ?"
				+ "and SCHOOL_CD = ?");

		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		// 第1引数＝プレースホルダ番号
		st.setString(1,key_class );
		st.setInt(2,key_year );
		st.setBoolean(3,key_attend );
		st.setString(4,school_cd );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Productクラスをインスタンス化
			Student p = new Student();
			// 値をセット
			p.setEnt_year(rs.getInt("ent_year"));
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}



	// すべての学生を参照するメソッド
	public List<Student> all() throws Exception {
		// Productを要素に持つList
		List<Student> list = new ArrayList<Student>();

		// データベースに接続
		Connection con = getConnection();

		// 実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"select * from student");
		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Productクラスをインスタンス化
			Student p = new Student();
			// 値をセット
			p.setEnt_year(rs.getInt("ent_year"));
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
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