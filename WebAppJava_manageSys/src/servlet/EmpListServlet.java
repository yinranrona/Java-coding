/*
 * WebApp_empManager
 * servlet.EmpListServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PageDAO;
import model.entity.PageBean;

/**
 * 「従業員情報一覧表示画面」への遷移を制御する
 * @author emBex Education
 */
@WebServlet("/emp-list-servlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null; //画面遷移先

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションオブジェクトのチェック
		/* ToDo ログイン認証済みかどうかを確認しましょう */
		if (session.getAttribute("userid") != null) {

			// リクエストオブジェクトのエンコーディング方式の指定
			request.setCharacterEncoding("UTF-8");

			//pagination
			int currentPage = 1;
			int pageSize = 10;

			String currePage = request.getParameter("currentPage");
			if (currePage != null) {
				currentPage = Integer.parseInt(currePage);
			}
			//情報更新
			int infoModify = 0;
			String infoM = request.getParameter("infoModify");
			if (infoM != null) {

				infoModify = Integer.parseInt(infoM);
				if (infoModify == 1) {
					request.setAttribute("infoModify", 1);

					if (session.getAttribute("userid").equals("S110")) {
						request.setAttribute("authority1", "authority1");
					} else {
						request.setAttribute("authority2", "authority2");
					}
				}
			}

		//	EmpBean emp = new EmpBean();
		PageDAO dao = new PageDAO();
		PageBean leb = null;

		try {
			//leb = dao.selectAll();
			leb = dao.pageInfo(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			e.printStackTrace();
		}
		url = "emp-list.jsp";

		// リクエストスコープへの属性の設定
		//request.setAttribute("count", count);
		request.setAttribute("listEmp", leb.getEmpBean().getListEmpBean());
		request.setAttribute("pageInfo", leb);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
