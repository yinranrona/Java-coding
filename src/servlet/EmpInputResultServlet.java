/*
 * WebApp_empManager
 * servlet.EmpInputFixServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 従業員情報を登録する
 * @author emBex Education
 */
@WebServlet("/emp-input-result-servlet")
public class EmpInputResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInputResultServlet() {
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

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// ログイン認証済みかどうかを確認
		if (session.getAttribute("userid") != null) {
			// 認証済み
			url = "emp-input-result.jsp";
		} else {
			// 未認証
			url = "login.html";
		}

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		EmpBean emp = new EmpBean();
		EmpDAO dao = new EmpDAO();
		try {
			// DAOの生成
			dao = new EmpDAO();

			// リクエストパラメータの取得
			String employeeCode = dao.getMaxEmployeeCode();
			String lastName = request.getParameter("last-name");
			String firstName = request.getParameter("first-name");
			String lastKanaName = request.getParameter("last-kana-name");
			String firstKanaName = request.getParameter("first-kana-name");
			int gender = Integer.parseInt(request.getParameter("gender"));
			Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth-day"));
			String sectionCode = request.getParameter("section-code");
			Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hire-date"));
			/* ToDo 更新日時も正確に登録しましょう */

			emp.setEmployeeCode(employeeCode) ;
			emp.setLastName(lastName) ;
			emp.setFirstName(firstName) ;
			emp.setLastKanaName(lastKanaName) ;
			emp.setFirstKanaName(firstKanaName) ;
			emp.setGender(gender) ;
			emp.setBirthDay(birthDay) ;
			emp.setSectionCode(sectionCode) ;
			emp.setHireDate(hireDate) ;
			/* ToDo 更新日時も正確に登録しましょう */
		} catch(ParseException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		int count = 0;	// 処理件数

		try {
			// DAOの利用
			count = dao.insert(emp);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("count", count);
		request.setAttribute("emp", emp);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
