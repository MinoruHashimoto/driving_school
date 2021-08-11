package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.T_StudentDAO;
import model.Employee;
import model.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();
		request.setAttribute("student", student);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String student_name_phonetic = request.getParameter("student_name_phonetic");
		String birthday = request.getParameter("birth_year");
		birthday += request.getParameter("birth_manth");
		birthday += request.getParameter("birth_day");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String request_course = request.getParameter("request_course");
		int glasses = Integer.parseInt(request.getParameter("glasses"));

		String starting_date = (String) request.getParameter("starting_date");
		starting_date = starting_date.replace("-", "");
		String reception_date = (String) request.getParameter("reception_date");
		reception_date = reception_date.replace("-", "");

		String reception_employee = request.getParameter("reception_employee");
		String reception_name = request.getParameter("reception_name");
		String note = request.getParameter("note");

		String submit = request.getParameter("submit");

		Student student = new Student(student_name, student_name_phonetic, birthday,
				address, gender, phone_number1, phone_number2, request_course, glasses,
				starting_date, reception_date, reception_employee, reception_name, note);
		
		Student studentToMod = new Student(student_id, student_name, student_name_phonetic, birthday,
				address, gender, phone_number1, phone_number2, request_course, glasses,
				starting_date, reception_date, reception_employee, reception_name, note);
		
		//セッションスコープの取得
		HttpSession session = request.getSession();
		Employee login = (Employee)session.getAttribute("login");
		String login_id=login.getEmployee_code();

		//
		T_StudentDAO dao = new T_StudentDAO();

		switch (submit) {
		case ("search"):
			Student student_return = dao.search(student_id);

			if (student_return != null) {
				//リクエストスコープへの保存
				request.setAttribute("student", student_return);
			} else {
				request.setAttribute("noStudent", "入力された生徒IDを持つ生徒は登録されていません");
			}
			break;
		case ("del"):
			boolean delResult = dao.del(student_id, login_id);
			if (delResult) {
				//リクエストスコープへの保存
				request.setAttribute("delStudent", student);
			} else {
				request.setAttribute("noStudent", "入力された生徒IDを持つ生徒は登録されていません");
			}
			break;

		case ("add"):
			boolean addResult = dao.add(student, login_id);
			if (addResult) {
				//リクエストスコープへの保存
				request.setAttribute("addStudent", student);
			} else {
				request.setAttribute("noStudent", "入力された～～の組み合わせのは既に登録されています");
			}
			break;

		case ("mod"):
			boolean modResult = dao.mod(student, login_id);
			if (modResult) {
				//リクエストスコープへの保存
				request.setAttribute("modStudent", student);
			} else {
				request.setAttribute("noStudent", "入力された生徒IDを持つ生徒は登録されていません");
			}
			break;
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/student.jsp");
			dispatch.forward(request, response);
		}

	}

}
