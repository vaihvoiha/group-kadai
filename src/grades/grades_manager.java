package grades;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_List;
import bean.Student_Name;
import bean.Subject_List;
import bean.TestListStudent;
import bean.TestListSubject;
import bean.Year_List;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestListStudentDAO;
import dao.TestListSubjectDAO;
import tool.CommonServlet1;



//アノテーションurl　リクエストされたら実行
@WebServlet(urlPatterns={"/grades/grades_list"})
public class grades_manager extends CommonServlet1  {

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

//		セッションの準備
		HttpSession session=req.getSession();



//		jspでの入力 <<<<

//		入学年度
		String ent_year=req.getParameter("ent_year");

//		jspに入力された値を取得
//		getメソッドで送られた入力値を取得する
//		クラス
		String class_num=req.getParameter("class_num");

//		科目
		String sub_cd=req.getParameter("sub_cd");

//		学生番号
		String stu_no=req.getParameter("stu_no");

//		jspでの入力 >>>>



		System.out.println("学生番号入力");
		System.out.println(stu_no);



//		セッションからログイン中ユーザーの学校コードを取り出す
		Object school_cd = session.getAttribute("session_user_school_cd");




//		検索エラーメッセージ用（入力が足らない等）
		String error_message = "" ;





//		入力が無ければ''を入れる <<<<

//		クラスがNULL
		if (class_num==null ) {
			class_num="" ;

		}


//		入学年度がNULL
		if (ent_year==null ) {
			ent_year="" ;
		}

//		科目がNULL
		if (sub_cd==null ) {
			sub_cd="" ;
		}

//		学生番号がNULL
		if (stu_no==null ) {
			stu_no="" ;
		}


//		後で別処理まだーーーーーーーーーーーーーーーーーーー
//		学校コードがNULL
		if(school_cd==null) {
			school_cd=100;
		}

//		入力が無ければ''を入れる >>>>




//		daoの呼び出し<<<<

//		検索結果用（科目）のdao
		TestListSubjectDAO dao_t = new TestListSubjectDAO();

//		入学年度一覧用のdao
		StudentDAO dao_s=new StudentDAO();

//		科目一覧用のdao
		SubjectDAO dao_sub = new SubjectDAO();

//		検索結果用（学生番号）のdao
		TestListStudentDAO dao_t_stu = new TestListStudentDAO();

//		選択した学生の名前
		TestListStudentDAO dao_stu_name = new TestListStudentDAO();

//		daoの呼び出し >>>>




//		List型へ変換 <<<<

		//		検索結果（科目）
		List<TestListSubject> list_tls=dao_t.search_kamoku(  ent_year,class_num,sub_cd,school_cd);

//		入学年度選択一覧用
		List<Year_List> y_list = dao_s.year_list(school_cd);

//		クラス選択一覧用
		List<Class_List> c_list = dao_s.class_list(school_cd);

//		科目選択一覧
		List<Subject_List> sub_list = dao_sub.subject_list(school_cd);

//		検索結果（学生番号
		List<TestListStudent> list_t_stu_s = dao_t_stu.search_stu_no(stu_no,school_cd);

//		検索した学生の名前
		List<Student_Name> select_stu_name = dao_stu_name.name_select(stu_no,school_cd);

//		List型へ変換 >>>>


		System.out.println(list_tls.size());


//		検索結果（科目）の数を求める
		Integer list_tls_count = list_tls.size();

//		検索結果（学生番号）の数を求める
		Integer list_t_stu_s_count = list_t_stu_s.size();



//		セッション属性に検索結果を格納する <<<<

//		検索結果一覧（科目）
		session.setAttribute("list_tls", list_tls);

//		検索結果一覧（学生番号）
		session.setAttribute("list_t_stu", list_t_stu_s);

//		入学年度一覧（選択用）
		session.setAttribute("years", y_list);

//		クラス一覧（選択用）
		session.setAttribute("classes", c_list);

//		科目一覧（選択用）
		session.setAttribute("subject", sub_list);

//		選択された科目（テーブル上の表示用）
		session.setAttribute("sub_select", sub_cd);

//		選択された学生番号（テーブル上の表示用）
		session.setAttribute("stu_no_select", stu_no);

//		選択された学生の名前（テーブル上の表示用）
		session.setAttribute("stu_name_select", select_stu_name);


//		セッション属性に検索結果を格納する >>>>



//		初期ページand検索未入力 <<<<
		if(ent_year.isEmpty() && class_num.isEmpty() && sub_cd.isEmpty() && stu_no.isEmpty() ){


			System.out.println("初期画面だお");


//			セッション属性に検索結果を格納する
			session.setAttribute("error_message", error_message);
				req.getRequestDispatcher("test_list.jsp").forward(req, resp);
		}

//		初期ページand検索未入力 >>>>






//		検索後のページ分け <<<<

//		入学年度　クラス　科目の検索(科目情報の入力)
		if(!ent_year.isEmpty() && !class_num.isEmpty()  && !sub_cd.isEmpty() && stu_no.isEmpty() ){


//			検索結果の件数が「0」の場合はNULLページ
			if(list_tls_count == 0){
//				確認用メッセージ表示（後で削除）ーーーーーーーーーーーーーーーーーーーーーーーーーー
				System.out.println("科目NULLだお");

//				セッション属性に検索結果を格納する
				session.setAttribute("error_message", error_message);

//				成績検索結果ページへ（科目）
				req.getRequestDispatcher("test_subject_null.jsp").forward(req, resp);

			}else{


//				確認用メッセージ表示（後で削除）ーーーーーーーーーーーーーーーーーーーーーーーーーー
				System.out.println("科目だお");

//				セッション属性に検索結果を格納する
				session.setAttribute("error_message", error_message);

//				成績検索結果ページへ（科目）
				req.getRequestDispatcher("test_subject.jsp").forward(req, resp);



			}


//			学生番号の検索
//			学生番号以外は空白
		} else if(ent_year.isEmpty() && class_num.isEmpty() && sub_cd.isEmpty() && !stu_no.isEmpty()){



//			検索結果のデータ数が0 => null用ページへ
			if(list_t_stu_s_count == 0){
//				セッション属性に検索結果を格納する
				session.setAttribute("error_message", error_message);

//				成績検索結果ページへ（科目）
				req.getRequestDispatcher("test_student_null.jsp").forward(req, resp);

			} else{


//				確認用メッセージ表示（後で削除）ーーーーーーーーーーーーーーーーーーーーーーーーーー
				System.out.println("学生nullだお");

//				セッション属性に検索結果を格納する
				session.setAttribute("error_message", error_message);

//				成績検索結果ページへ（科目）
				req.getRequestDispatcher("test_student.jsp").forward(req, resp);



			}




//
//
////			上記以外
////			検索に不正があった場合
////			エラーメッセージを表示して初期ページへ
		}else{
			System.out.println("エラーだお");

//			エラーメッセージに記述
			error_message = "入学年度とクラスと科目を選択してください";

			//	セッション属性に検索結果を格納する
			session.setAttribute("error_message", error_message);
//			初期ページへ
			req.getRequestDispatcher("test_list.jsp").forward(req, resp);

		}


//		検索後のページ分け >>>>






	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}
}
