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

//		jspに入力された値を取得（変数名：keyword）
//		getメソッドで送られた入力値を取得する
		String class_num=req.getParameter("class_num");

//		int ent_year=Integer.parseInt(req.getParameter("ent_year"));

		String ent_year=req.getParameter("ent_year");


		Boolean active = Boolean.parseBoolean(req.getParameter("active"));

//		String school_cd=req.getParameter("school_cd");



		if (class_num==null ) {
			class_num="" ;
		}

		if (ent_year==null ) {
			ent_year="" ;
		}

//		if (school_cd==null ) {
//			school_cd="" ;
//		}




//		入力した値がnullだった場合 keyword を定義
//		if (keyword==null) keyword="";
//
		StudentDAO dao=new StudentDAO();



		if (session.getAttribute("session_customer") == null) {
//		セッションからログイン中ユーザーの学校コードを取り出す
			System.out.print( session.getAttribute("session_user_school_cd"));

		}

		Object school_cd = session.getAttribute("session_user_school_cd");




//
		if (school_cd==null ) {
		school_cd="" ;
	}



//		List型
//		ProductDAO のseachメソッドを実行引数は keyword
		List<Student> list=dao.search( class_num, ent_year, active,school_cd);

		List<Year_List> y_list = dao.year_list(school_cd);

		List<Class_List> c_list = dao.class_list(school_cd);

		List<Search_Count> search_count=dao.count( class_num, ent_year, active,school_cd);



		System.out.print(y_list);
//	セッション属性に検索結果を格納する
		session.setAttribute("students", list);
		session.setAttribute("years", y_list);
		session.setAttribute("classes", c_list);
		session.setAttribute("counts", search_count);




		req.getRequestDispatcher("student_list.jsp").forward(req, resp);


		}



	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
