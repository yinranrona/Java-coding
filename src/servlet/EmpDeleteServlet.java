/*
 * WebApp_empManager
  * servlet.EmpUpdateServlet.java
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

import model.dao.EmpDAO;

/**
 * 「従業員削除画面」への遷移を制御する
 * @author emBex Education
 */
@WebServlet("/emp-delete-servlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String path = null; // 画面遷移先

		EmpDAO edao = new EmpDAO();

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		String submit = request.getParameter("submit");

		// セッションオブジェクトのチェック
		/* ToDo ログイン認証済みかどうかを確認しましょう */
		if (session.getAttribute("userid") != null) {

			if (submit.equals("削除")) {

				String[] checkAry = request.getParameterValues("check");

				try {

					edao.delete(checkAry);

				} catch (NumberFormatException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				path = "emp-list-servlet";
			}

			if (submit.equals("編集")) {

				String employeeCode = request.getParameter("check");

				try {

					request.setAttribute("empBean", edao.selectOnefield(employeeCode));

				} catch (NumberFormatException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				path = "emp-update.jsp";
			}
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
