package student;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDAO;
import tool.CommonServlet1;

//アノテーションurlで/chapter25/product　リクエストされたら実行
@WebServlet(urlPatterns={"/student/1"})
public class Abcd extends CommonServlet1  {

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

//		セッションの準備
		HttpSession session=req.getSession();

//		jspに入力された値を取得（変数名：keyword）
//		getメソッドで送られた入力値を取得する
		String class_num=req.getParameter("class_num");

//		int ent_year=Integer.parseInt(req.getParameter("ent_year"));

//		Boolean active = Boolean.parseBoolean(req.getParameter("active"));

//		String school_cd=req.getParameter("school_cd");

		if (class_num==null ) {
			class_num="1" ;
//			ent_year=0000;
		}




//		入力した値がnullだった場合 keyword を定義
//		if (keyword==null) keyword="";
//
		StudentDAO dao=new StudentDAO();

//		List型
//		ProductDAO のseachメソッドを実行引数は keyword
		List<Student> list=dao.search( class_num);
//		List<Student> list=dao.all();

		System.out.println("list1");
		System.out.println(list);

//	セッション属性に検索結果を格納する
		session.setAttribute("students", list);

		req.getRequestDispatcher("student_list.jsp").forward(req, resp);

		System.out.println("list2");
		System.out.println(list);

	}



	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
