package test.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import shoppingcart.CartItem;
import shoppingcart.ItemRates;
import shoppingcart.Items;
import shoppingcart.ShoppingCart;

public class ShoppingCartTest {

	@Test
	public void checkIfCalculatedTotalCostIsCorrect1(){
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		Map<String, Double> itemValue = new HashMap<String, Double>();
		ShoppingCart shoppingCartCheckout = new ShoppingCart();
		ItemRates itemRates = new ItemRates();
		itemValue=itemRates.getRates();
		CartItem cartItem1 = new CartItem(Items.Apple.toString(),itemValue.get(Items.Apple.toString()));
		CartItem cartItem2 = new CartItem(Items.Apple.toString(),itemValue.get(Items.Apple.toString()));
		CartItem cartItem3 = new CartItem(Items.Orange.toString(),itemValue.get(Items.Orange.toString()));
		CartItem cartItem4 = new CartItem(Items.Apple.toString(),itemValue.get(Items.Apple.toString()));
		cartItems.add(cartItem1);
		cartItems.add(cartItem2);
		cartItems.add(cartItem3);
		cartItems.add(cartItem4);
		BigDecimal total = shoppingCartCheckout.calculateTotalCost(cartItems);
		if(total.doubleValue() == new BigDecimal(2.05).doubleValue()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkIfCalculatedTotalCostIsCorrect2(){
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		Map<String, Double> itemValue = new HashMap<String, Double>();
		ShoppingCart shoppingCartCheckout = new ShoppingCart();
		ItemRates itemRates = new ItemRates();
		itemValue=itemRates.getRates();
		CartItem cartItem1 = new CartItem(Items.Apple.toString(),itemValue.get(Items.Apple.toString()));
		cartItems.add(cartItem1);
		BigDecimal total = shoppingCartCheckout.calculateTotalCost(cartItems);
		if(total.doubleValue() == new BigDecimal(0.60).doubleValue()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkIfCalculatedTotalCostIsCorrect3(){
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		Map<String, Double> itemValue = new HashMap<String, Double>();
		ShoppingCart shoppingCartCheckout = new ShoppingCart();
		ItemRates itemRates = new ItemRates();
		itemValue=itemRates.getRates();
		CartItem cartItem1 = new CartItem(Items.Orange.toString(),itemValue.get(Items.Orange.toString()));
		cartItems.add(cartItem1);
		BigDecimal total = shoppingCartCheckout.calculateTotalCost(cartItems);
		if(total.doubleValue() == new BigDecimal(0.25).doubleValue()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}


}
