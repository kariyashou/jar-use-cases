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
import model.InfoLogic;
import model.InputLimitation;

@WebServlet("/ChangeServlet")
/*
 * JSPからの入力情報の中身を判定し中身がすべてnullまたは０以外の場合は変数に代入していく
 * その後それらの変数を用いて該当メソッドの引数とし、DBに追加操作をする。
 */
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InputLimitation limit = new InputLimitation();
		SelectDAO select = new SelectDAO();
		HttpSession session = request.getSession();
		try {
			if (limit.isKana(request.getParameter("kana")) == true
					&& limit.isMail(request.getParameter("email")) == true
					&& limit.isTell(request.getParameter("tell")) == true
					&& limit.isPhone(request.getParameter("phone")) == true && request.getParameter("name") != null
					&& request.getParameter("kana") != null && request.getParameter("email") != null
					&& (!(request.getParameter("sex").equals("0"))) && request.getParameter("birthday") != null
					&& (!(request.getParameter("marriage").equals("0")) && (!(request.getParameter("blood").equals("0"))
							&& (!(request.getParameter("pref").equals("0")) && request.getParameter("tell") != null)
							&& request.getParameter("phone") != null))
					&& (!(request.getParameter("career").equals("0")))) {

				InfoLogic logic = new InfoLogic();
				int id = Integer.parseInt(session.getAttribute("id").toString());
				String name = request.getParameter("name");
				String kana = request.getParameter("kana");
				String email = request.getParameter("email");
				int sexId = Integer.parseInt(request.getParameter("sex"));
				String birth = request.getParameter("birthday");
				java.sql.Date birthday = logic.dateConversion(birth);
				int marriageId = Integer.parseInt(request.getParameter("marriage"));
				int bloodtypeId = Integer.parseInt(request.getParameter("blood"));
				int prefId = Integer.parseInt(request.getParameter("pref"));
				String tell = request.getParameter("tell");
				String phone = request.getParameter("phone");
				int careerId = Integer.parseInt(request.getParameter("career"));
				String curry = request.getParameter("curry");
				select.change(new InfoBeans(id, name, kana, email, sexId, birthday, marriageId, bloodtypeId, prefId, tell, phone,
						careerId, curry));
				List<InfoBeans> list = select.sort();
				request.setAttribute("list", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Change2.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ChangeError.jsp");
				dispatcher.forward(request, response);
			}
		} catch (NumberFormatException| ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
