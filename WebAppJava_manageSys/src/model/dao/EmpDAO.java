/*
 * WebApp_ex0501
 * model.dao.EmployeeDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.EmpBean;
import model.entity.ListEmp;

/**
 * m_employeeテーブルのDAOです。
 * @author emBex Education
 */
public class EmpDAO {

	/**
	 * 指定された内容の従業員情報を登録します。
	 * @param emp 従業員オブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insert(EmpBean emp) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数

		String sql = "INSERT INTO m_employee(employee_code,last_name,first_name,last_kana_name,first_kana_name,gender,birth_day,section_code,hire_date)VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			/* ToDo empから要素を抽出してください */
			pstmt.setString(1, emp.getEmployeeCode());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getFirstName());
			pstmt.setString(4, emp.getLastKanaName());
			pstmt.setString(5, emp.getFirstKanaName());
			pstmt.setInt(6, emp.getGender());
			pstmt.setDate(7, (Date) emp.getBirthDay());
			pstmt.setString(8, emp.getSectionCode());
			pstmt.setDate(9, (Date) emp.getHireDate());

			// プレースホルダへの値の設定
			/* ToDo pstmtプレースホルダへ要素を設定してください */

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
			//			String debugSQL = pstmt.toString();//debug
		}

		return count;
	}

	public ListEmp selectAll() throws SQLException, ClassNotFoundException {
		//int count = 0; //処理件数

		ResultSet rs;
		ListEmp leb;

		String sql = "SELECT * FROM m_employee";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLステートメントの実行
			rs = pstmt.executeQuery();

			leb = new ListEmp();

			// リストを生成する
			EmpBean eb;
			while (rs.next()) {
				eb = new EmpBean();
				/* ToDo ebにデータを設定してください */
				eb.setEmployeeCode(rs.getString("employee_code"));
				eb.setLastName(rs.getString("last_name"));
				eb.setFirstName(rs.getString("first_name"));
				eb.setLastKanaName(rs.getString("last_kana_name"));
				eb.setFirstKanaName(rs.getString("first_kana_name"));
				eb.setGender(rs.getShort("gender"));
				eb.setBirthDay(rs.getDate("birth_day"));
				eb.setSectionCode(rs.getString("section_code"));
				eb.setHireDate(rs.getDate("hire_date"));

				leb.add(eb);
			}

		}

		return leb;
	}

	/**
	 * 従業員IDの最大値を取得します
	 * @return 従業員IDの最大値（0件の場合は0001）
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String getMaxEmployeeCode() throws SQLException, ClassNotFoundException {
		String sql;
		String result = "SELECT max()";

		// データベースへの接続の取得、PreparedStatementの取得
		sql = "ToDo SQLを書いてください";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLステートメントの実行
			ResultSet res1 = pstmt.executeQuery();

			// 結果の操作
			res1.next();
			int count = res1.getInt(1);
			if (count == 0) { // 件数0
				result = "00001";
			} else {
				sql = "ToDo SQLを書いてください";
				// SQLステートメントの実行
				ResultSet res2 = pstmt.executeQuery();
				res2.next();
				/* ToDo データベース従業員コードの最大値+1の値をresultに設定してください */
			}
			return result;
		}
	}

	public boolean selectEmpCode(String empcode) throws ClassNotFoundException, SQLException {

		String sql = "SELECT last_name FROM m_employee WHERE employee_code = ?";
		String val = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			pa.setString(1, empcode);
			ResultSet rs = pa.executeQuery();
			while (rs.next()) {

				val = rs.getString("last_name");
			}
		}
		if (val != null) {
			return true;
		} else {
			return false;
		}

	}

	public ListEmp selectPagination(int currentPage, int pageSize) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_employee LIMIT ?,?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			pa.setInt(1, (currentPage - 1) * pageSize);
			pa.setInt(2, pageSize);

			ResultSet rs = pa.executeQuery();
			ListEmp leb = new ListEmp();
			while (rs.next()) {

				EmpBean eb = new EmpBean();
				eb.setEmployeeCode(rs.getString("employee_code"));
				eb.setLastName(rs.getString("last_name"));
				eb.setFirstName(rs.getString("first_name"));
				eb.setLastKanaName(rs.getString("last_kana_name"));
				eb.setFirstKanaName(rs.getString("first_kana_name"));
				eb.setGender(rs.getShort("gender"));
				eb.setBirthDay(rs.getDate("birth_day"));
				eb.setSectionCode(rs.getString("section_code"));
				eb.setHireDate(rs.getDate("hire_date"));

				leb.add(eb);
			}

			return leb;
		}

	}

	public int paginationCount() throws ClassNotFoundException, SQLException {

		String sql = "SELECT count(*) FROM m_employee";
		int count = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			ResultSet rs = pa.executeQuery();

			while (rs.next()) {

				count = rs.getInt(1);
			}
			return count;
		}
	}

	public void delete(String[] id) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM m_employee WHERE employee_code = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			for (String i : id) {

				pa.setString(1, i);
				pa.executeUpdate();
			}
		}

	}

	public EmpBean selectOnefield(String empcode) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_employee WHERE employee_code = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			EmpBean eb = new EmpBean();

			pa.setString(1, empcode);
			ResultSet rs = pa.executeQuery();

			while (rs.next()) {

				eb.setEmployeeCode(rs.getString("employee_code"));
				eb.setLastName(rs.getString("last_name"));
				eb.setFirstName(rs.getString("first_name"));
				eb.setLastKanaName(rs.getString("last_kana_name"));
				eb.setFirstKanaName(rs.getString("first_kana_name"));
				eb.setGender(rs.getShort("gender"));
				eb.setBirthDay(rs.getDate("birth_day"));
				eb.setSectionCode(rs.getString("section_code"));
				eb.setHireDate(rs.getDate("hire_date"));
			}
			return eb;
		}
	}
	
	public int updateOneField(EmpBean empbean) throws ClassNotFoundException, SQLException {
		
		String sql = "UPDATE m_employee SET last_name = ?, first_name = ?, last_kana_name = ?,"
				+ "first_kana_name = ?,  gender = ?, birth_day = ?, section_code = ?, "
				+ "hire_date = ? WHERE employee_code = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {
			
			pa.setString(1,empbean.getLastName());
			pa.setString(2, empbean.getFirstName());
			pa.setString(3, empbean.getLastKanaName());
			pa.setString(4, empbean.getFirstKanaName());
			pa.setInt(5, empbean.getGender());
			pa.setDate(6, (Date) empbean.getBirthDay());
			pa.setString(7, empbean.getSectionCode());
			pa.setDate(8, (Date) empbean.getHireDate());
			pa.setString(9, empbean.getEmployeeCode());
			
			return pa.executeUpdate();
		}
	}

}