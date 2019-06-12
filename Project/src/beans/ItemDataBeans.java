package beans;

import java.sql.Date;

public class ItemDataBeans {

	private int id;
	private String photo;
	private String name;
	private int price;
	private int item_state;
	private int delivery;
	private String detail;
	private int user_id;
	private int item_num;
	private Date create_date;

	private String userName;
	private String userAddress;

	private String item_stateDetail;

	private String deliveryDetail;

	public String getItem_stateDetail() {
		return item_stateDetail;
	}

	public void setItem_stateDetail(String item_stateDetail) {
		this.item_stateDetail = item_stateDetail;
	}

	public String getDeliveryDetail() {
		return deliveryDetail;
	}

	public void setDeliveryDetail(String deliveryDetail) {
		this.deliveryDetail = deliveryDetail;
	}

	public ItemDataBeans() {

	}

	public ItemDataBeans(int id, String photo, String name, int price) {
		this.id = id;
		this.photo = photo;
		this.name = name;
		this.price = price;
	}

	public ItemDataBeans(String photo, String name, int price, String item_stateDetail, String deliveryDetail, String detail,
			String userName, String userAddress, int user_id) {
		this.photo = photo;
		this.name = name;
		this.price = price;
		this.item_stateDetail = item_stateDetail;
		this.deliveryDetail = deliveryDetail;
		this.detail = detail;
		this.userName = userName;
		this.userAddress = userAddress;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
