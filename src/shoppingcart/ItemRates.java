package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ItemRates {

	public Map<String, Double> itemValue = new HashMap<String, Double>();

	public ItemRates() {
		itemValue.put(Items.Apple.toString(), 0.60);
		itemValue.put(Items.Orange.toString(), 0.25);
	}

	public Map<String, Double> getRates() {
		return itemValue;
	}

}
