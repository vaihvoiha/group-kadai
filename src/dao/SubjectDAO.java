package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;
import bean.Subject_List;
import util.DbUtil;

public class SubjectDAO extends DAO {

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
		st.setString(1,"%" + school_cd + "%" );


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




















    // 科目をIDと学校コードで取得
    public Subject get(String cd, String schoolCd) {
        Subject subject = null;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, schoolCd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject = new Subject();
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

    // すべての科目を取得
    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM SUBJECT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("CD"));
                subject.setName(rs.getString("NAME"));
                subject.setSchoolCd(rs.getString("SCHOOL_CD"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return subjects;
    }

    // 科目を追加
    public boolean insert(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO SUBJECT (CD, NAME, SCHOOL_CD) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getCd());
            ps.setString(2, subject.getName());
            ps.setString(3, subject.getSchoolCd());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を更新
    public boolean update(Subject subject) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "UPDATE SUBJECT SET NAME = ? WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getCd());
            ps.setString(3, subject.getSchoolCd());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }

    // 科目を削除
    public boolean delete(String cd, String schoolCd) {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd);
            ps.setString(2, schoolCd);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection(connection);
        }
        return result;
    }
}
