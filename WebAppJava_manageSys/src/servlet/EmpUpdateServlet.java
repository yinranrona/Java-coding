/*
 * WebApp_empManager
  * servlet.EmpUpdateServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmpDAO;
import model.entity.EmpBean;

/**
 * 「従業員編集画面」への遷移を制御する
 * @author emBex Education
 */
@WebServlet("/emp-update-servlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateServlet() {
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

		// リクエストオブジェクトのエンコーディング方式の指定
				request.setCharacterEncoding("UTF-8");

				String url = null; //画面遷移先
				
				EmpBean emp = null;
				int count = 0; // 処理件数

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションオブジェクトのチェック
				/* ToDo 入力項目の規約違反などをチェックしましょう */
				String empcode = request.getParameter("hidden");
				String lastname = request.getParameter("lastname");
				String firstname = request.getParameter("firstname");
				String lastkananame = request.getParameter("lastkananame");
				String firstkananame = request.getParameter("firstkananame");
				String gender = request.getParameter("gender");
				String birthday = request.getParameter("birthday");
				String sectioncode = request.getParameter("sectioncode");
				String hiredate = request.getParameter("hiredate");

				// DAOの生成
				EmpDAO dao = new EmpDAO();
				
				/* ToDo ログイン認証済みかどうかを確認しましょう */
				if (session.getAttribute("userid") != null) {

						emp = new EmpBean();

						try {
							// リクエストパラメータの取得
							//	String employeeCode = dao.getMaxEmployeeCode();
							/* ToDo requestから要素を抽出してください */
							/* ToDo empに要素を設定してください */
							emp.setEmployeeCode(empcode);
							emp.setLastName(lastname);
							emp.setFirstName(firstname);
							emp.setLastKanaName(lastkananame);
							emp.setFirstKanaName(firstkananame);
							emp.setGender(Integer.parseInt(gender));
							//String to Date
							emp.setBirthDay(Date.valueOf(birthday));
							emp.setSectionCode(sectioncode);
							emp.setHireDate(Date.valueOf(hiredate));

							// DAOの利用
							count = dao.updateOneField(emp);

							url = "emp-update-result.jsp";

						} catch (ClassNotFoundException | SQLException e) {
							/* ToDo Exception発生時エラー画面に遷移するようにしましょう */
							e.printStackTrace();
						}
					
				}

				// リクエストスコープへの属性の設定
				request.setAttribute("count", count);
				request.setAttribute("emp", emp);

				// リクエストの転送
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}

	

}
