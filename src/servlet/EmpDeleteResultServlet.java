/*
 * WebApp_empManager
 * servlet.EmpUpdateResultServlet.java
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

import model.entity.EmpBean;

/**
 * 従業員情報を削除する
 * @author emBex Education
 */
@WebServlet("/emp-delete-result-servlet")
public class EmpDeleteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDeleteResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = null; //画面遷移先
		int modeForward = 0; // 0:正常 1:入力値エラー 2:認証エラー
		EmpBean emp=null;
		int count = 0;	// 処理件数

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションオブジェクトのチェック
		/* ToDo 入力項目の規約違反などをチェックしましょう */
		/* ToDo ログイン認証済みかどうかを確認しましょう */

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		/* ToDo 削除結果を生成してJSPにforwardします */
		emp = new EmpBean();

		// リクエストスコープへの属性の設定
		request.setAttribute("count", count);
		request.setAttribute("emp", emp);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

