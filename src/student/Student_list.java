package student;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_List;
import bean.Search_Count;
import bean.Student;
import bean.Year_List;
import dao.StudentDAO;
import tool.CommonServlet1;

//アノテーションurlで/chapter25/product　リクエストされたら実行
@WebServlet(urlPatterns={"/student/student_list"})
public class Student_list extends CommonServlet1  {

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

//		セッションの準備
		HttpSession session=req.getSession();

//		jspに入力された値を取得
//		getメソッドで送られた入力値を取得する
//		クラス
		String class_num=req.getParameter("class_num");


//		入学年度
		String ent_year=req.getParameter("ent_year");


//		在学中か
		Boolean active = Boolean.parseBoolean(req.getParameter("active"));




//		検索エラーメッセージ用
		String error_message = "" ;




		System.out.println(error_message);

		if (class_num==null ) {
			class_num="" ;
		}

		if (ent_year==null ) {
			ent_year="" ;
		}



//		クラスには入力されて、入学年度には未入力
		if (class_num != "" && ent_year.isEmpty() ){
			error_message = "クラスを指定する場合は入学年度も指定してください";
			class_num = "";
			active = false;


		}
		StudentDAO dao=new StudentDAO();



//		セッションからログイン中ユーザーの学校コードを取り出す
		Object school_cd = session.getAttribute("session_user_school_cd");


//		ログイン中ユーザーのセッションがnull（ログインしてない）
		if (school_cd == null)
		{


//			まだやでーーーーーーーーーーーーーーーーーーーー
//			ログイン画面へ
			System.out.print( session.getAttribute("session_user_school_cd"));

		}




//	未ログイン用（学校コード入力）
		if (school_cd==null ) {
		school_cd="" ;
	}




//		List型
//		StudentDAO のseachメソッド
//		検索結果
		List<Student> list=dao.search( class_num, ent_year, active,school_cd);

//		入学年度選択一覧用
		List<Year_List> y_list = dao.year_list(school_cd);

//		クラス選択一覧用
		List<Class_List> c_list = dao.class_list(school_cd);

//		検索件数
		List<Search_Count> search_count=dao.count( class_num, ent_year, active,school_cd);




//		listの中身がNULLかどうか
//		NULLの場合は0件専用ページへ
		if (list == null || list.size() == 0) {
			req.getRequestDispatcher("student_list_null_table.jsp").forward(req, resp);

		}


//	セッション属性に検索結果を格納する
		session.setAttribute("students", list);
		session.setAttribute("years", y_list);
		session.setAttribute("classes", c_list);
		session.setAttribute("counts", search_count);
		session.setAttribute("error_message", error_message);


		req.getRequestDispatcher("student_list.jsp").forward(req, resp);


		}



	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
