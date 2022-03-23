package pizzaMenu;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This is the node class for the pizza menu
 */
public class PizzaNode {
	
	 PizzaNode next;
	 
	 int OrderNo;
	 String firstName; // User's first name
	 int inches; // Size of the pizza
	 String crust; // Name of crust
	 double cost; // Cost of the pizza
	 final double TAX_RATE ; // Sales tax rate
	 double tax; // Amount of tax
	 String userInput; // User input
	 String toppings = "Cheese "; // List of toppings
	 int numTopps; // Number of toppings
	 int qty; //Number of Pizzas
	 
	 public PizzaNode( int OrderNo, String firstName, int inches, String crust, 
			 String toppings, double cost, double TAX_RATE, String userInput, double tax, int numTopps, int qty) {
		 
		 this.OrderNo = OrderNo;
		 this.firstName = firstName; 
		 this.inches = inches;
		 this.crust = crust;
		 this.cost = cost;
		 this.TAX_RATE = TAX_RATE= .08;
		 this.tax = tax; 
		 this.userInput = userInput;
		 this.toppings = toppings; 
		 this.numTopps = numTopps; 
		 this.qty = qty;

	 }

}
