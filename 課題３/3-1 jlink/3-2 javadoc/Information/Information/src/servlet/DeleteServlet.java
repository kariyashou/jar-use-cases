package servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SelectDAO;
import model.InfoBeans;

@WebServlet("/DeleteServlet")
//セッションからIDを取り出しDB内の該当データを削除する
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SelectDAO select = new SelectDAO();
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(session.getAttribute("id").toString());
			select.delete(id);
			List<InfoBeans> list = select.sort();
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp");
			dispatcher.forward(request, response);

		} catch (NumberFormatException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
