package shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
	
	public static Map<Integer, String> itemIndex = new HashMap<Integer, String>();

	public ShoppingCart() {
		indexTheItems();
	}

	public void printListOfItemsAdded(ArrayList<CartItem> cartItems) {
		System.out.println("List of items added to the cart:\n");
		int index = 0;
		System.out.print("[");
		for (CartItem cartItem : cartItems) {
			++index;
			if (index == 1) {
				System.out.print(cartItem.getProduct());
			} else {
				System.out.print("," + cartItem.getProduct());
			}
		}
		System.out.println("]");
	}

	public BigDecimal calculateTotalCost(ArrayList<CartItem> cartItems) {
		BigDecimal bigDecimalActualTotal = new BigDecimal(0.00);
		for (CartItem cartItemAdded : cartItems) {
			BigDecimal bigDecimalCartItemRate = BigDecimal.valueOf(cartItemAdded.getPrice());
			bigDecimalActualTotal = bigDecimalActualTotal.add(bigDecimalCartItemRate);
		}
		return bigDecimalActualTotal;
	}

	public static void indexTheItems() {
		int index = 0;
		for (Items item : Items.values()) {
			itemIndex.put(++index, item.toString());
		}
	}

	public String getItemsListIndexedString() {
		String itemsListIndexed = "";
		int index = 0;
		for (Items item : Items.values()) {
			itemsListIndexed = itemsListIndexed + " " + ++index + "."
					+ item.toString() + " ";
		}
		return itemsListIndexed;
	}

	/**
	 * Offer a menu of options: 
	 * 1 add an item to the cart 
	 * 2 view the items in the cart 
	 * 3 end shopping and view the total amount 
	 * 4 exit the program Use the
	 * Scanner class to collect input
	 */
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		ItemRates itemRates = new ItemRates();
		Map<String, Double> itemRate = new HashMap<String, Double>();
		itemRate = itemRates.getRates();
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		int choice = 0;
		int input = 0;
		BigDecimal total = new BigDecimal(0.00);

		while (keepGoing) {
			System.out.println("\nSelect one of following operations");
			System.out.println("1 Add item");
			System.out.println("2 View the items in your cart");
			System.out.println("3 End shopping and view total ");
			System.out.println("4 Exit");
			System.out.println("Select a menu option");
			choice = scan.nextInt();
			if (choice < 1 || choice > 4) {
				System.out.println("Enter a value between 1 and 4:");
			} else {
				switch (choice) {
				case 1:
					// add items to the cart
					System.out.println("Select an item:");
					System.out.println(shoppingCart.getItemsListIndexedString());
					input = scan.nextInt();
					String itemName = itemIndex.get(input);
					CartItem cartItem = new CartItem(itemName,
							itemRate.get(itemName));
					cartItems.add(cartItem);
					total = shoppingCart.calculateTotalCost(cartItems);
					System.out.println("Total:" + total);
					break;
				case 2:
					// view the items in your cart
					shoppingCart.printListOfItemsAdded(cartItems);
					break;
				case 3:
					//end shopping and view total amount
					total = shoppingCart.calculateTotalCost(cartItems);
					System.out.println("Total is " + total);
					System.out.println("Exiting");
					keepGoing = false;
					break;
				case 4:
					// exit shopping
					keepGoing = false;
					System.out.println("Exiting");
					break;
				}
			}
		}
		scan.close();
	}


}
