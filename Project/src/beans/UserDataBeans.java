package beans;

import java.io.Serializable;
import java.sql.Date;

public class UserDataBeans implements Serializable {
	private int id;
	private String login_id;
	private String password;
	private String name;
	private String address;
	private Date create_date;
	private int point;
	private int bad;
	private String detail;

	public UserDataBeans() {

	}

	public UserDataBeans(String login_id) {
		this.login_id = login_id;
	}

	public UserDataBeans(int id, String login_id, String name) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
	}

	public UserDataBeans(int id, String name, int point, String address, String detail) {
		this.id = id;
		this.name = name;
		this.point = point;
		this.address = address;
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
