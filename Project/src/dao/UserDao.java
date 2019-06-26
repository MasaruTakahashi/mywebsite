package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import beans.UserDataBeans;

public class UserDao {

	public static void userInsert(UserDataBeans udb) throws SQLException {

		Connection con = null;

		try {

			con = DBManager.getConnection();
			String sql = "insert into user(login_id, password, name, address,create_date)"
					+ "VALUES(?,?,?,?,now())";

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

	public static UserDataBeans checkLogin_id(String login_id) throws SQLException {

		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, login_id);

			ResultSet rs = ps.executeQuery();
			System.out.println("checkOK!");

			if (!rs.next()) {
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

	public static UserDataBeans login(String login_id, String password) throws SQLException {

		Connection con = null;

		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			String pass = md5(password);

			ps.setString(1, login_id);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			System.out.println("loginOK!");

			if (!rs.next()) {
				return null;
			}

			int iddata = rs.getInt("id");
			String loginiddata = rs.getString("login_id");
			String namedata = rs.getString("name");

			return new UserDataBeans(iddata, loginiddata, namedata);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public static UserDataBeans getuser(int id) throws SQLException {

		Connection con = null;
		UserDataBeans udb = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int Id = rs.getInt("id");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				String address = rs.getString("address");
				String detail = rs.getString("detail");

				udb = new UserDataBeans(Id, name, point, address, detail);

			}

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
		return udb;
	}

	public static void update(String pass, String name, String address, String detail, int id) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE user SET";

			String password = md5(pass);

			if (!pass.equals("")) {
				sql += " password = '" + password + "'";
			}
			if (!name.equals("")) {
				sql += " name = '" + name + "'";
			}
			if (!address.equals("")) {
				sql += " address = '" + address + "'";
			}
			if (!detail.equals("")) {
				sql += " detail = '" + detail + "'";
			}
			sql += " WHERE id = '" + id + "'";

			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("userupdateOK!");

		} catch (SQLException e) {
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

	public static void userbad(UserDataBeans udb) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();


			String sql1 = "SELECT bad FROM user WHERE id = ?";
			PreparedStatement ps1 = con.prepareStatement(sql1);

			ps1.setInt(1, udb.getId());

			ResultSet rs = ps1.executeQuery();
			if (!rs.next()) {
				udb.setBad(0);
			} else {
				udb.setBad(rs.getInt("bad"));
			}

			String sql = "UPDATE user SET bad = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			int bad = udb.getBad();
			ps.setInt(1, bad += 1);
			ps.setInt(2, udb.getId());

			ps.executeUpdate();
			System.out.println("badinsertOK!!");

		} catch (SQLException e) {
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

	public static void pointuse(UserDataBeans udb) throws SQLException {
		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "UPDATE user SET point = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, udb.getPoint() - udb.getUsepoint());
			ps.setInt(2, udb.getId());

			ps.executeUpdate();
			System.out.println("pointuseOK!!");

		} catch (SQLException e) {
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

	public static void pointadd(UserDataBeans udb, int price) throws SQLException {
		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, udb.getId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				udb.setPoint(rs.getInt("point"));
			}

			String sql1 = "UPDATE user SET point = ? WHERE id = ?";
			ps = con.prepareStatement(sql1);

			ps.setInt(1, udb.getPoint() + price);
			ps.setInt(2, udb.getId());

			ps.executeUpdate();
			System.out.println("pointaddOK!!");
		} catch (SQLException e) {
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

	public static List<UserDataBeans> userlist(String login_id, String name, String bad) throws SQLException {
		Connection con = null;
		List<UserDataBeans> udblist = new ArrayList<UserDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id <> 1";

			if (!login_id.equals("")) {
				sql += " AND login_id ='" + login_id + "'";
			}
			if (!name.equals("")) {
				sql += " AND name LIKE '%" + name + "%'";
			}
			if (!bad.equals("")) {
				int badP = Integer.parseInt(bad);
				sql += " AND bad = '" + badP + "'";
			}

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setBad(rs.getInt("bad"));

				udblist.add(udb);
			}

		} catch (SQLException e) {
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
		return udblist;
	}

	public static List<UserDataBeans> findall() throws SQLException {
		Connection con = null;
		List<UserDataBeans> udblist = new ArrayList<UserDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id <> 1";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setBad(rs.getInt("bad"));

				udblist.add(udb);
			}

		} catch (SQLException e) {
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
		return udblist;
	}

	public static void userdelete(UserDataBeans udb) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "DELETE FROM user WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, udb.getId());
			ps.executeUpdate();
			System.out.println("userdeleteOK!!");
		} catch (SQLException e) {
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

	public static String md5(String password) {
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
