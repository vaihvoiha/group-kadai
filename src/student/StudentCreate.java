package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/student/student_create"})
public class StudentCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	StudentDAO dao = new StudentDAO();

    	List<String> classList = dao.getClassList();
    	List<String> schoolList = dao.getSchoolList();

    	req.setAttribute("class_list", classList);
    	req.setAttribute("school_list", schoolList);
    	req.getRequestDispatcher("student_create.jsp").forward(req, resp);

	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        StudentDAO dao = new StudentDAO();
        Student student = (Student) session.getAttribute("student");

    	String entYearStr = request.getParameter("ent_year");
    	int ent_year = 0;
    	try{
        	ent_year = Integer.parseInt(entYearStr);
    	}catch(NumberFormatException e){
    		ent_year = 0;
    	}
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String class_num = request.getParameter("class_num");
        Boolean is_attend = request.getParameter("is_attend") != null;
        String errorMessage = "";

        // デバッグ用の出力
        System.out.println("入学年度:" + ent_year);
        System.out.println("学生番号: " + no);
        System.out.println("学生名: " + name);
        System.out.println("クラス: " + class_num);
        System.out.println("在学中:" + is_attend);

        // 入学年度の入力チェック
//        if (ent_year == 0 || ent_year.isEmpty() || ent_year.equals("-------")) {
        if (ent_year == 0) {
            errorMessage += "入学年度を選択してください<br>";
        }

        // 学生番号の入力チェック
        if (no == null || no.isEmpty()) {
            errorMessage += "学生番号を入力してください<br>";
        }else if(dao.isStudentNoExists(no)){
        	errorMessage += "学生番号が重複しています<br>";
        }

        // 必須項目のチェック
        if (name == null || name.isEmpty()) {
            errorMessage += "氏名を入力してください<br>";
        }

        // 必須項目のチェック
        if (class_num == null || class_num.isEmpty()) {
            errorMessage += "クラスを入力してください<br>";
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("ent_year", ent_year);
            request.setAttribute("no", no);
            request.setAttribute("name", name);
            request.setAttribute("class_num", class_num);

            request.getRequestDispatcher("/student/student_create.jsp").forward(request, response);
        } else {
        	try {

	        	String school_cd = dao.getSchoolCode(class_num);

	        	System.out.println("学校コード:" + school_cd);

	        	if (school_cd == null) {
	        		errorMessage += "学校コードを取得できませんでした<br>";
	        		request.setAttribute("errorMessage", errorMessage);
	        		request.getRequestDispatcher("/student/student_create.jsp").forward(request, response);

	        	}else{
		        	student.setEnt_year(ent_year);
		        	student.setNo(no);
		        	student.setName(name);
		        	student.setClass_num(class_num);
		        	student.setIs_attend(is_attend);
		        	student.setSchool_cd(school_cd);
	        	}

	        	// 成功した場合の処理（データベースに登録）

	    		if (dao.insert3(student)) {
	    			session.setAttribute("student_create_done", true);
	    			response.sendRedirect("student_create_done.jsp");

	    		}else{
	    			request.setAttribute("errorMessage", "データベースに登録できませんでした");
	    			request.getRequestDispatcher("/student/student_create.jsp").forward(request, response);
	    		}

	        } catch (Exception e) {
	        	e.printStackTrace();
	        	request.setAttribute("errorMessage", "エラーが発生しました:" + e.getMessage());
	        	request.getRequestDispatcher("/student/student_create.jsp").forward(request, response);
	        }

        }
    }
}
