package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmpLicenBean;

public class EmpLicenDAO {

	public List<EmpLicenBean> selectEmpLicen() throws ClassNotFoundException, SQLException {

		String sql = "SELECT t1.employee_code, t2.license_name, t1.get_license_date "
				+ "FROM t_get_license as t1, m_license as t2 WHERE t1.license_code = t2.license_code;";
		
		List<EmpLicenBean> ls = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			ResultSet rs = pa.executeQuery();
			while(rs.next()) {
				
				EmpLicenBean eb = new EmpLicenBean();
				eb.setEmployeeCode(rs.getString("employee_code"));
			    eb.setLicenseName(rs.getString("license_name"));
			    eb.setLicenseDate(rs.getDate("get_license_date"));
				
				ls.add(eb);
			}
		}
		return ls;
	}
}
