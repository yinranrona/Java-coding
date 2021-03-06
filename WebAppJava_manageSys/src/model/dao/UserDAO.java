/*
 * WebApp_t-ex01
 * model.dao.UserDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

/**
 * m_userテーブルのDAOです
 * @author emBex Education
 */
public class UserDAO {

	/**
	 * ユーザID・パスワードをもとにログイン認証を行う。
	 *
	 * m_userに該当するレコードが存在するかどうかを検索する。
	 *
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return 認証成功の場合 true、そうでない場合 false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean loginCheck(String userId, String password) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			if(res.next()) {
				return true;
			}
		}
		return false;
	}


	/**
	 * すべてのユーザのリストを返します。
	 * @return ユーザのリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<UserBean> selectAll() throws ClassNotFoundException, SQLException {
		List<UserBean> list = new ArrayList<UserBean>();

		String sql = "SELECT * FROM m_user";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt =  con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			// 結果の操作
			while(res.next()) {
				UserBean user = new UserBean();
				user.setUserId(res.getString("user_id"));
				user.setName(res.getString("name"));
				user.setTimestamp(res.getTimestamp("timestamp"));
				list.add(user);
			}
		}

		return list;
	}
}
