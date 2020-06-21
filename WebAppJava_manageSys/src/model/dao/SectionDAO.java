package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionDAO {

	
	public boolean selectSectionCode(String sectioncode) throws ClassNotFoundException, SQLException {

		String sql = "SELECT section_name FROM m_section WHERE section_code = ?";
		String val = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pa = con.prepareStatement(sql)) {

			pa.setString(1, sectioncode);
			ResultSet rs = pa.executeQuery();
			while (rs.next()) {

				val = rs.getString("section_name");
			}
		}
		if (val != null) {
			return true;
		}else {
			return false;
		}

	}
}
