/*
 * WebApp_empManager
  * servlet.EmpInputServlet.java
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 「従業員情報登録画面」への遷移を制御する
 * @author emBex Education
 */
@WebServlet("/emp-input-servlet")
public class EmpInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInputServlet() {
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

		String url = null; // 画面遷移先

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションオブジェクトのチェック
		/* ToDo ログイン認証済みかどうかを確認しましょう */	
		if (session.getAttribute("userid") != null) {

			url = "emp-input.jsp";
		}
		

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
