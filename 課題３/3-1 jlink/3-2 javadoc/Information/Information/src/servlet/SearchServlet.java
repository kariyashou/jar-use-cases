package servlet;

import java.io.IOException;



import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SelectDAO;
import model.InfoBeans;
import model.InfoLogic;
import model.InputLimitation;

@WebServlet("/SearchServlet")
//JSPからの各入力情報を条件によって分岐させるサーブレット
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InfoLogic logic = new InfoLogic();
		SelectDAO select = new SelectDAO();
		// DBの各テーブルを入れるための変数
		// 初期値として、textはnull プルダウンには0が入っている
		int id = 0;
		String name = null;
		String kana = null;
		String email = null;
		int sexId = 0;
		String birth = null;
		java.sql.Date birthday = null;
		int marriageId = 0;
		int bloodtypeId = 0;
		int prefId = 0;
		String tell = null;
		String phone = null;
		int careerId = 0;
		String curry = null;

		InputLimitation limit = new InputLimitation();
		try {
			// 入力項目のどれか１つにでも入力があればtrueを返す
			if (select.idCheck(request.getParameter("id")) == true
					|| request.getParameter("name") != null && (!(request.getParameter("name").equals("")))
					|| limit.isKana(request.getParameter("kana")) == true && request.getParameter("kana") != null
							&& (!(request.getParameter("kana").equals("")))
					|| limit.isMail(request.getParameter("email")) == true && request.getParameter("email") != null
							&& (!(request.getParameter("email").equals("")))
					|| limit.isTell(request.getParameter("tell")) == true && request.getParameter("tell") != null
							&& (!(request.getParameter("tell").equals("")))
					|| limit.isPhone(request.getParameter("phone")) == true && request.getParameter("phone") != null
							&& (!(request.getParameter("phone").equals("")))
					|| (!(request.getParameter("sex").equals("0")))
					|| request.getParameter("birthday") != null && (!(request.getParameter("birthday").equals("")))
					|| (!(request.getParameter("marriage").equals("0")))
					|| (!(request.getParameter("blood").equals("0"))) || (!(request.getParameter("pref").equals("0")))
					|| (!(request.getParameter("career").equals("0")))
					|| request.getParameter("curry") != null && (!(request.getParameter("curry").equals("")))) {
				/*
				 * 上記のifのみだと複数入力があった場合に不具合になるので それぞれの項目にもう一度判定をすることで中身を確認する
				 */
				if (select.idCheck(request.getParameter("id")) == true) {
					id = Integer.parseInt(request.getParameter("id"));
				}
				if (request.getParameter("name") != null && (!(request.getParameter("name").equals("")))) {
					name = request.getParameter("name");
				}
				if (limit.isKana(request.getParameter("kana")) == true && request.getParameter("kana") != null
						&& (!(request.getParameter("kana").equals("")))) {
					kana = request.getParameter("kana");
				}
				if (limit.isMail(request.getParameter("email")) == true && request.getParameter("email") != null
						&& (!(request.getParameter("email").equals("")))) {
					email = request.getParameter("email");
				}
				if (!(request.getParameter("sex").equals("0"))) {
					sexId = Integer.parseInt(request.getParameter("sex"));
				}
				if (request.getParameter("birthday") != null && (!(request.getParameter("birthday").equals("")))) {
					birth = request.getParameter("birthday");
					birthday = logic.dateConversion(birth);
				}
				if (!(request.getParameter("marriage").equals("0"))) {
					marriageId = Integer.parseInt(request.getParameter("marriage"));
				}
				if (!(request.getParameter("blood").equals("0"))) {
					bloodtypeId = Integer.parseInt(request.getParameter("blood"));
				}
				if (!(request.getParameter("pref").equals("0"))) {
					prefId = Integer.parseInt(request.getParameter("pref"));
				}
				if (limit.isTell(request.getParameter("tell")) == true && request.getParameter("tell") != null
						&& (!(request.getParameter("tell").equals("")))) {
					tell = request.getParameter("tell");
				}
				if (limit.isPhone(request.getParameter("phone")) == true && request.getParameter("phone") != null
						&& (!(request.getParameter("phone").equals("")))) {
					phone = request.getParameter("phone");
				}
				if (!(request.getParameter("career").equals("0"))) {
					careerId = Integer.parseInt(request.getParameter("career"));
				}
				if (request.getParameter("curry") != null && (!(request.getParameter("curry").equals("")))) {
					curry = request.getParameter("curry");
				}

				// listに対してsearchメソッドでの戻り値Listを代入し、スコープに保存
				List<InfoBeans> list = null;
				list = select.search(new InfoBeans(id, name, kana, email, sexId, birthday, marriageId, bloodtypeId, prefId, tell,
						phone, careerId, curry));
				request.setAttribute("Info", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Search2.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchError.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
