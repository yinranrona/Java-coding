/*
 * WebApp_empManager
 * servlet.EmpInputFixServlet.java
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
import model.dao.SectionDAO;
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
		// 0:正常 1:未入力エラー 2:従業員コードの形式エラー 3:部署コードの形式エラー
		//4:全角かなエラー 5:入社日の形式エラー 6:認証エラー
		int modeForward = 0;
		EmpBean emp = null;
		int count = 0; // 処理件数

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションオブジェクトのチェック
		/* ToDo 入力項目の規約違反などをチェックしましょう */
		String empcode = request.getParameter("empcode");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String lastkananame = request.getParameter("lastkananame");
		String firstkananame = request.getParameter("firstkananame");
		String gender = request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String sectioncode = request.getParameter("sectioncode");
		String hiredate = request.getParameter("hiredate");

		String birthday = year + "-" + month + "-" + day;

		// DAOの生成
		EmpDAO dao = new EmpDAO();
		SectionDAO sdao = new SectionDAO();

		//1:未入力チェック 
		if (empcode == null || (empcode.trim().equals(""))) {
			request.setAttribute("empcodenull", "empcodenull");
			modeForward = 1;
		} else {
			request.setAttribute("empcode", empcode);
			//2:従業員コードの形式のチェック
			if ((empcode.trim().length() != 5)) {
				modeForward = 2;
			} else {
				for (int i = 1; i < 5; i++) {

					if (!empcode.substring(0, 1).matches("E") || !empcode.substring(i, i + 1).matches("[0-9]")) {

						modeForward = 2;
					}
				}
			}
			//6:認証チェック
			try {
				if (dao.selectEmpCode(empcode)) {

					modeForward = 6;
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (lastname == null || (lastname.trim().equals(""))) {
			request.setAttribute("lastnamenull", "lastnamenull");
			modeForward = 1;
		} else {
			request.setAttribute("lastname", lastname);
		}
		if (firstname == null || (firstname.trim().equals(""))) {
			request.setAttribute("firstnamenull", "firstnamenull");
			modeForward = 1;
		} else {
			request.setAttribute("firstname", firstname);
		}
		if (lastkananame == null || (lastkananame.trim().equals(""))) {
			request.setAttribute("lastkananamenull", "lastkananamenull");
			modeForward = 1;
		} else {
			request.setAttribute("lastkananame", lastkananame);
			//4:全角かなのチャック
			if (!lastkananame.matches("^[^ -~｡-ﾟ]+$")) {
				modeForward = 401;
			}
		}
		if (firstkananame == null || (firstkananame.trim().equals(""))) {
			request.setAttribute("firstkananamenull", "firstkananamenull");
			modeForward = 1;
		} else {
			request.setAttribute("firstkananame", firstkananame);
			//4:全角かなのチャック
			if (!firstkananame.matches("^[^ -~｡-ﾟ]+$")) {
				modeForward = 402;
			}
		}
		if (gender == null || (gender.trim().equals(""))) {
			request.setAttribute("gendernull", "gendernull");
			modeForward = 1;
		} else {
			request.setAttribute("gender", gender);
		}
		if (year == null || (year.trim().equals(""))) {
			request.setAttribute("yearnull", "yearnull");
			modeForward = 1;
		} else {
			request.setAttribute("year", year);
		}
		if (month == null || (month.trim().equals(""))) {
			request.setAttribute("monthnull", "monthnull");
			modeForward = 1;
		} else {
			request.setAttribute("month", month);
		}
		if (day == null || (day.trim().equals(""))) {
			request.setAttribute("daynull", "daynull");
			modeForward = 1;
		} else {
			request.setAttribute("day", day);
		}
		if (sectioncode == null || (sectioncode.trim().equals(""))) {
			request.setAttribute("sectioncodenull", "sectioncodenull");
			modeForward = 1;
		} else {
			request.setAttribute("sectioncode", sectioncode);
//			//3:部署コードの形式のチェック
//			if ((sectioncode.trim().length() != 4)) {
//				modeForward = 3;
//			} else {
//				for (int i = 1; i < 4; i++) {
//					if (!sectioncode.substring(0, 1).matches("S")
//							|| !sectioncode.substring(i, i + 1).matches("[0-9]")) {
//						modeForward = 3;
//					}
//				}
//			}
			//7:部署コード認証チェック
			try {
				if (!sdao.selectSectionCode(sectioncode)) {

					modeForward = 7;
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (hiredate == null || (hiredate.trim().equals(""))) {
			request.setAttribute("hiredatenull", "hiredatenull");
			modeForward = 1;
		} else {
			request.setAttribute("hiredate", hiredate);
			//5:入社日の形式のチェック
			if (hiredate.length() != 10 || !hiredate.substring(0, 4).matches("^[0-9]+$") ||
					!hiredate.substring(4, 5).matches("-") ||
					!hiredate.substring(5, 7).matches("^[0-9]+$") ||
					!hiredate.substring(7, 8).matches("-") ||
					!hiredate.substring(8, 10).matches("^[0-9]+$")) {

				modeForward = 5;
			}
		}

		/* ToDo ログイン認証済みかどうかを確認しましょう */
		if (session.getAttribute("userid") != null) {

			if (modeForward == 0) {
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
					System.out.println(Date.valueOf(birthday));
					emp.setBirthDay(Date.valueOf(birthday));
					emp.setSectionCode(sectioncode);
					emp.setHireDate(Date.valueOf(hiredate));

					// DAOの利用
					count = dao.insert(emp);

					url = "emp-input-result.jsp";

				} catch (ClassNotFoundException | SQLException e) {
					/* ToDo Exception発生時エラー画面に遷移するようにしましょう */
					e.printStackTrace();
				}
			} else {
				url = "emp-input.jsp";
				request.setAttribute("modeForward", modeForward);
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
