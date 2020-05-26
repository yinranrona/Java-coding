/*
 * WebApp_ex0501
 * model.dao.EmployeeDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.entity.EmpBean;
import model.entity.ListEmpBean;

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

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String employeeCode = emp.getEmployeeCode(); //1
			String lastName = emp.getLastName(); //1
			String firstName = emp.getFirstName(); //2
			String lastKanaName = emp.getLastKanaName(); //3
			String firstKanaName = emp.getFirstKanaName(); //4
			int gender = emp.getGender(); //5
			Date birthDay = emp.getBirthDay(); //6
			String sectionCode = emp.getSectionCode(); //7
			Date hireDate = emp.getHireDate(); //8
//			Date updateDatetime = emp.getUpdateDatetime(); //9

			// プレースホルダへの値の設定
			pstmt.setString(1, employeeCode);
			pstmt.setString(2, lastName);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastKanaName);
			pstmt.setString(5, firstKanaName);
			pstmt.setInt(6, gender);
			pstmt.setDate(7, new java.sql.Date(birthDay.getTime()));
			pstmt.setString(8, sectionCode);
			pstmt.setDate(9, new java.sql.Date(hireDate.getTime()));
//			pstmt.setDate(10, new java.sql.Date(updateDatetime.getTime()));
			pstmt.setTimestamp(10, new java.sql.Timestamp(System.currentTimeMillis()));

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
//			String debugSQL = pstmt.toString();//debug
		}

		return count;
	}

	public ListEmpBean selectAll() throws SQLException, ClassNotFoundException {
		//int count = 0; //処理件数

		ResultSet rs;
		ListEmpBean leb;
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT employee_code, last_name, first_name, last_kana_name, first_kana_name, gender, birth_day, section_code, hire_date, update_datetime FROM m_employee")) {

			// SQLステートメントの実行
			rs = pstmt.executeQuery();

			leb = new ListEmpBean();

			// リストを生成する
			EmpBean eb;
			while (rs.next()) {
				eb = new EmpBean();
				eb.setEmployeeCode(rs.getString(1));
				eb.setLastName(rs.getString(2));
				eb.setFirstName(rs.getString(3));
				eb.setLastKanaName(rs.getString(4));
				eb.setFirstKanaName(rs.getString(5));
				eb.setGender(rs.getInt(6));
				eb.setBirthDay(rs.getDate(7));
				eb.setSectionCode(rs.getString(8));
				eb.setHireDate(rs.getDate(9));
				eb.setUpdateDatetime(rs.getTimestamp(10));

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
		String result = "";

		// データベースへの接続の取得、PreparedStatementの取得
		sql = "SELECT count(*) FROM m_employee";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// SQLステートメントの実行
			ResultSet res1 = pstmt.executeQuery();

			// 結果の操作
			res1.next();
			int count = res1.getInt(1);
			if(count==0) { // 件数0
				result = "00001";
			} else {
				sql = "SELECT max(id) FROM m_employee";
				// SQLステートメントの実行
				ResultSet res2 = pstmt.executeQuery();
				res2.next();
				result = String.format("%05d", res2.getInt(1)+1);
			}
			return result;

		}

	}
}