package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_EmployeeDAO;
import model.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッションスコープの破棄
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

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
