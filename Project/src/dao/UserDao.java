package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.DatatypeConverter;

import beans.UserDataBeans;

public class UserDao {

	public static void userInsert(UserDataBeans udb) throws SQLException {

		Connection con = null;

		try {

			con = DBManager.getConnection();
			String sql = "insert into user(login_id, password, name, addres,create_date)"
					+ "VALUES(?.?,?.?,CURRENT_TIMESTAMP)";

			PreparedStatement ps = con.prepareStatement(sql);

			String password = md5(udb.getPassword());

			ps.setString(1, udb.getLogin_id());
			ps.setString(2, password);
			ps.setString(3, udb.getName());
			ps.setString(4, udb.getAddress());

			ps.executeUpdate();
			System.out.println("userInsertOK!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}

	public static UserDataBeans checkLogin_id(String login_id)throws SQLException{

		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, login_id);

			ResultSet rs = ps.executeQuery();

			if(!rs.next()) {
				return null;
			}

			return new UserDataBeans(rs.getString("login_id"));

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}



	 public static String md5(String password){
			//ハッシュを生成したい元の文字列
			 String source = password;
			 //ハッシュ生成前にバイト配列に置き換える際のCharset
			 Charset charset = StandardCharsets.UTF_8;
			 //ハッシュアルゴリズム
			 String algorithm = "MD5";

			 //ハッシュ生成処理
			 byte[] bytes = null;
			try {
				bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			 String result = DatatypeConverter.printHexBinary(bytes);
			 //標準出力
			 System.out.println(result);
			return result;
			 }

}