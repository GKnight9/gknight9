package pizzaMenu;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This class is intended to record pizza orders
 */
public class PizzaMenu {
	
	PizzaNode head;
	
	public void append (int OrderNo, String firstName, int inches, String crust, 
			 double cost, double TAX_RATE, String userInput, double tax, String toppings, int numTopps, int qty) {
		
		if (head == null) {
			head = new PizzaNode (OrderNo, firstName, inches, crust, toppings, cost, TAX_RATE, userInput, tax 
				 ,numTopps,	qty);
			return;
		}
		PizzaNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new PizzaNode (OrderNo, firstName, inches, crust, toppings, cost, TAX_RATE, userInput,  
				tax, numTopps, qty);
	}
	
	public void delete(int OrderNo, String firstName, int inches, String crust, 
			 double cost, double TAX_RATE, String userInput, double tax, String toppings, int numTopps, int qty) {
		
		PizzaNode current = head;
		PizzaNode previous = null;
		if (head != null && current.firstName == firstName) {
			head = current.next;
			return;
		}
		while (current != null && current.firstName != firstName) {
			previous = current;
			current = current.next;
		}
		if (current == null) {
			return;
		}
		previous.next = current.next;
	}
	
	public int length() {
		
		int len = 0;
		PizzaNode current = head;
		while (current != null) {
			
			len++;
			current = current.next;
		}
		return len;

	}
	public void prepend(int OrderNo, String firstName, int inches, String crust, 
			 double cost, double TAX_RATE, String userInput, double tax, String toppings, int numTopps, int qty) {
		
		PizzaNode newHead = new PizzaNode(OrderNo, firstName, inches, crust, toppings, cost, TAX_RATE, userInput,  
				tax, numTopps, qty);
		newHead.next = head;
		head = newHead;
	}
	public void printOrderManager() {
		System.out.print("PIZZA ORDER MANAGER\n");
		printLine(85);
		System.out.println("Order No.\tCustomer\tQty.\tStatus\t\tTax\tAmount Due");
		printLine(85);
	}
	public void printOrderList() {
		PizzaNode current = head;
	//	System.out.println();
		//printLine(100);
		
		while (current != null) {
			System.out.printf("%05d\t\t%s%s%s$%.4s\t$%.2f\n", current.OrderNo , 
			current.firstName + (current.firstName.length() > 7 ? "\t" : "\t\t"), 
			current.qty + ("\t"),
			current.userInput + (current.userInput.length() > 7 ? "\t" : "\t\t"),
			current.cost + ("\t"),
			(current.cost + current.tax), current.cost + current.tax);
			current = current.next;
		}
	}
	public String searchCustomerOrder(String firstName) {
	    
		String result = "ID number not found";
		if (head == null) return "List Empty";
		PizzaNode current = head;
		if (head.firstName == firstName) {
				result = head.firstName
			            + "\t" + head.inches 
			            + head.crust 
			            + head.cost;
		}
		else {
			while (current.next != null) {
				if (current.next.firstName == firstName) {
					result = current.next.firstName
		               + "\t" + current.next.inches 
		                    + current.next.crust
		                    + current.next.cost;
					break;
				}
				current = current.next;
			}
		}
		return result;
	}
	public void printLine(int n) {
		
		for (int i = 1; i <= n; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
