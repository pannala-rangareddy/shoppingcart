package shoppingcart;

public class CartItem {
	
	private String item;
	private double price;

	public CartItem() {
		item = "";
		price = 0.0;
	}

	public String getProduct() {
		return item;
	}

	public double getPrice() {
		return price;
	}

	public CartItem(String inProduct, double inPrice) {
		item = new String(inProduct);
		price = inPrice;
	}

}
