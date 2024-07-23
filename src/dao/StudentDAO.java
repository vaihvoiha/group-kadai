

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Class_List;
import bean.Search_Count;
import bean.Student;
import bean.Subject1;
import bean.Year_List;
import util.DbUtil;


public class StudentDAO extends DAO {


	//学生検索　クラス　入学年　在学中　学校コード
	public List<Student> search(String class_num, String ent_year ,boolean active, Object school_cd) throws Exception {




		// Studentを要素に持つList
		List<Student> list = new ArrayList<Student>();

		// データベースに接続
		Connection con = getConnection();


		PreparedStatement st = con.prepareStatement(
				"select * from student "
				+ "where CLASS_NUM like ?"
				+ "and  cast(ENT_YEAR as char) like ? "
				+ "and  ((IS_ATTEND  like upper( ? ))  or (IS_ATTEND  like 'TRUE' ))"
				+ "and SCHOOL_CD like ?"
				);

		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		// 第1引数＝プレースホルダ番号



		st.setString(1,"%" + class_num + "%" );
		st.setString(2,"%" + ent_year + "%" );
		st.setBoolean(3 ,   active);
		st.setObject(4, school_cd  );


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



//	検索データ数を取得
	public List<Search_Count> count(String class_num, String ent_year ,boolean active, Object school_cd) throws Exception {

		// Search_Countを要素に持つList
		List<Search_Count> list = new ArrayList<Search_Count>();

		// データベースに接続
		Connection con = getConnection();
		// データベースを使った処理を記述

		// 実行したいSQL文をプリペアードステートメントで準備


		PreparedStatement st = con.prepareStatement(
				"select count(*) AS search_count  from student "
				+ "where CLASS_NUM like ?"
				+ "and  cast(ENT_YEAR as char) like ? "
				+ "and  ((IS_ATTEND  like upper( ? ))  or (IS_ATTEND  like 'TRUE' ))"
				+ "and SCHOOL_CD like ?"
				);

		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		// 第1引数＝プレースホルダ番号



		st.setString(1,"%" + class_num + "%" );
		st.setString(2,"%" + ent_year + "%" );
		st.setBoolean(3 ,   active);
		st.setObject(4, school_cd  );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 取得した結果を表示
		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Search_Countクラスをインスタンス化
			Search_Count p = new Search_Count();
			// 値をセット
			p.setSearch_count(rs.getInt("search_count"));

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



	// すべての入学年度（userの学校コードと一致する）を参照するメソッド
	public List<Year_List> year_list(Object school_cd) throws Exception {
		// Year_Listを要素に持つList
		List<Year_List> list = new ArrayList<Year_List>();

		// データベースに接続
		Connection con = getConnection();

		// 実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"SELECT DISTINCT ENT_YEAR    FROM STUDENT "
				+ "WHERE SCHOOL_CD like ?"
				+ "ORDER BY ENT_YEAR"
				);


		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		st.setString(1,"%" + school_cd + "%" );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// Productクラスをインスタンス化
			Year_List p = new Year_List();
			// 値をセット
			p.setEnt_year(rs.getInt("ent_year"));

			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}


	// すべてのクラス（userの学校コードと一致する）を参照するメソッド
	public List<Class_List> class_list(Object school_cd) throws Exception {
		// Class_Listを要素に持つList
		List<Class_List> list = new ArrayList<Class_List>();

		// データベースに接続
		Connection con = getConnection();

		// 実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"SELECT DISTINCT CLASS_NUM    FROM STUDENT "
				+ "WHERE SCHOOL_CD like ?"
				);


		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		st.setObject(1, school_cd  );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// クラスをインスタンス化
			Class_List p = new Class_List();
			// 値をセット
			p.setClass_num(rs.getString("class_num"));

			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		// 商品リストを返却
		return list;
	}














    // 科目を取得するメソッド
    public Subject1 get(String cd, String school_cd) {
        Subject1 subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM subject WHERE cd = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, school_cd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject = new Subject1();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchoolCd(rs.getString("school_cd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subject;
    }

    // すべての科目を取得するメソッド
    public List<Subject1> selectAll() {
        List<Subject1> subjects = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM subject";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject1 subject = new Subject1();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchoolCd(rs.getString("school_cd"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subjects;
    }

    // 科目を追加するメソッド
    public boolean insert2(String cd, String name, String school_cd) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO subject (cd, name, school_cd) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, name);
            ps.setString(3, school_cd);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を追加するメソッド
    public boolean insert(Subject1 subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO subject (cd, name, school_cd) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getName());
            ps.setString(3, subject.getSchoolCd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を更新するメソッド
    public boolean update(Subject1 subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "UPDATE subject SET name = ? WHERE cd = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getCd());
            ps.setString(3, subject.getSchoolCd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を削除するメソッド
    public boolean delete(Subject1 subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM subject WHERE cd = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getSchoolCd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }


}



