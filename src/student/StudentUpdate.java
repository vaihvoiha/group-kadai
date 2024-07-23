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

@WebServlet(urlPatterns={"/student/student_update"})
public class StudentUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String studentNo = req.getParameter("no");
        if (studentNo == null || studentNo.isEmpty()) {
            resp.sendRedirect("student_list");
            return;
        }

        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentByNo(studentNo);
        if (student == null) {
            resp.sendRedirect("student_list");
            return;
        }

        List<String> classList = dao.getClassList();
        List<String> classNumList = dao.getClassNumList();

        session.setAttribute("student", student);
        req.setAttribute("student", student);
        req.setAttribute("class_list", classList);
        req.setAttribute("class_list", classNumList);
        req.getRequestDispatcher("/student/student_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Student student = (Student) session.getAttribute("student");

        int ent_year = student.getEnt_year();
        String no = student.getNo();
        String name = req.getParameter("name");
        String class_num = req.getParameter("class_num");
        Boolean is_attend = req.getParameter("is_attend") != null;
        String school_cd = req.getParameter("school_cd");
        String errorMessage = "";

     // デバッグ用の出力
        System.out.println("入学年度:" + ent_year);
        System.out.println("学生番号: " + no);
        System.out.println("学生名: " + name);
        System.out.println("学校コード: " + class_num);
        System.out.println("在学中:" + is_attend);
        System.out.println("学校コード:" + school_cd);


        if (!errorMessage.isEmpty()) {
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("student", student);
            req.setAttribute("class_list", new StudentDAO().getClassList());
            req.getRequestDispatcher("/student/student_update.jsp").forward(req, resp);
        } else {
            student.setEnt_year(ent_year);
            student.setNo(no);
            student.setName(name);
            student.setClass_num(class_num);
            student.setIs_attend(is_attend);
            student.setSchool_cd(school_cd);

            // 成功した場合の処理（データベースに登録）
            StudentDAO dao = new StudentDAO();
            if (dao.update(student)) {
                session.setAttribute("student_update_done", true);
                resp.sendRedirect("student_update_done.jsp");
            } else {
                req.setAttribute("errorMessage", "データベースに登録できませんでした");
                req.setAttribute("student", student);
                req.setAttribute("class_list", dao.getClassList());
                req.getRequestDispatcher("/student/student_update.jsp").forward(req, resp);
            }
        }
    }
}
