package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SelectServlet")
//JSP/submitの値からそれぞれ該当する機能に遷移するためのサーブレット
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストIDがnull出なかった場合にsessionにIDをセットする
		if (request.getParameter("id") != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", request.getParameter("id"));
		}

		if (request.getParameter("button").equals("検索する")) {
			System.out.println("検索");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Search.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("button").equals("追加する")) {
			System.out.println("追加");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Addition.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("button").equals("削除する")) {
			System.out.println("削除");
			getServletContext().getRequestDispatcher("/DeleteServlet").forward(request, response);
		} else if (request.getParameter("button").equals("変更する")) {
			System.out.println("変更");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Change.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("button").equals("ホーム")) {
			System.out.println("ホーム");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
