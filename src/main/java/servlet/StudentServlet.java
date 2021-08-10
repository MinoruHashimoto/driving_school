package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_EmployeeDAO;
import model.Employee;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String student_name_phonetic = request.getParameter("student_name_phonetic");
		String birth_year = request.getParameter("birth_year");
		String birth_manth = request.getParameter("birth_manth");
		String birth_day = request.getParameter("birth_day");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String request_course = request.getParameter("request_course");
		int glasses = Integer.parseInt( request.getParameter("glasses"));
		Date starting_date = (Date) request.getParameter("starting_date");
		Date reception_date = (Date) request.getParameter("reception_date");
		String reception_employee =  request.getParameter("reception_employee");
		String reception_name = request.getAttribute("reception_name");
		String note = request.getAttribute("note");

		//
		M_EmployeeDAO dao = new M_EmployeeDAO();
		Boolean bo = dao.findby(id, password);

		if (bo) {
			Employee login = new Employee(id, password);
			//セッションスコープへの保存
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
			dispatch.forward(request, response);
		} else {
			request.setAttribute("loginNG", "ログインに失敗しました");
			RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
		}

	}

}
