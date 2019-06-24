package beans;

public class GoodDataBeans {

	private int item_id;
	private int user_id;

	private String itemPhoto;
	private String itemName;
	private int itemPrice;

	private int count;


	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public GoodDataBeans(int item_id, int user_id) {
		this.item_id = item_id;
		this.user_id = user_id;
	}
	public GoodDataBeans() {
	}

	public String getItemPhoto() {
		return itemPhoto;
	}
	public void setItemPhoto(String itemPhoto) {
		this.itemPhoto = itemPhoto;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
