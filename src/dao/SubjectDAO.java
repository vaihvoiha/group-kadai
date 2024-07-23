package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;
import bean.Subject1;
import bean.Subject_List;
import bean.Subject_List_Gra;
import util.DbUtil;

public class SubjectDAO extends DAO {




	// すべての科目（名前）（userの学校コードと一致する）を参照するメソッド
	public List<Subject_List_Gra> subject_list_grades(Object school_cd) throws Exception {
		// Subject_List_Graを要素に持つList
		List<Subject_List_Gra> list = new ArrayList<Subject_List_Gra>();

		// データベースに接続
		Connection con = getConnection();

		// 実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"SELECT  DISTINCT  NAME  AS subject_name ,CD as subject_cd "
				+ "FROM SUBJECT  "
				+ "WHERE SCHOOL_CD like ?"
				);


		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		st.setObject(1, school_cd );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// クラスをインスタンス化
			Subject_List_Gra p = new Subject_List_Gra();
			// 値をセット
			p.setSubject_cd(rs.getString("subject_cd"));
			p.setSubject_name(rs.getString("subject_name"));

			// リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();




		// 商品リストを返却
		return list;
	}







	// すべての科目（userの学校コードと一致する）を参照するメソッド
	public List<Subject_List> subject_list(Object school_cd) throws Exception {
		// Subject_Listを要素に持つList
		List<Subject_List> list = new ArrayList<Subject_List>();

		// データベースに接続
		Connection con = getConnection();

		// 実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"SELECT  DISTINCT  NAME  AS subject_name "
				+ "FROM SUBJECT  "
				+ "WHERE SCHOOL_CD like ?"
				);


		// st.setStringメソッド...プリペアードステートメント
		// のプレースホルダに値を埋め込む（バインド）する
		st.setObject(1, school_cd );


		// SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			// クラスをインスタンス化
			Subject_List p = new Subject_List();
			// 値をセット
			p.setSubject_name(rs.getString("subject_name"));

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
    public Subject get(String cd, String school_cd) {
        Subject subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM subject WHERE cd = ?";
            if (school_cd != null) {
                sql += " AND school_cd = ?";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            if (school_cd != null) {
                ps.setString(2, school_cd);
            }
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

    // すべての科目を取得するメソッド
    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM subject";
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

    // 科目を追加するメソッド
    public boolean insert(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO subject (cd, name, school_cd) VALUES (?, ?, ?)";
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

    // 科目を更新するメソッド
    public boolean update(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "UPDATE subject SET name = ? WHERE cd = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getCd());
            ps.setString(3, subject.getSchool_cd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を削除するメソッド
    public boolean delete(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM subject WHERE cd = ? AND school_cd = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getSchool_cd());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }


    // 科目コードをIDと学校コードで取得
    public Subject1 get1(String cd, String schoolCd) {
        Subject1 subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, schoolCd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject = new Subject1();
                subject.setCd(rs.getString("CD"));
                subject.setName(rs.getString("NAME"));
                subject.setSchoolCd(rs.getString("SCHOOL_CD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subject;
    }

}
