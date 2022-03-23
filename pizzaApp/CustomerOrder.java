package pizzaMenu;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This class prompts user to place pizza order
 */
import java.util.Scanner;

public class CustomerOrder {
	
	
    public static void main(String[] args) {

        PizzaMenu pzm = new PizzaMenu();
  //       PizzaPriceFrame pPF = new PizzaPriceFrame(); 
         String pizza = "These are the records of the pizza orders!";
         
         EventQueue.invokeLater(new Runnable() {
        	 @Override
        	 public void run() {
        		 long start = System.nanoTime();
        		 System.out.println("Run");
 		//	 PizzaPriceFrame pPF = new PizzaPriceFrame();
 			 homePage hmp = new homePage(); 
 			 pzm.printOrderManager();
 			 
 		 /* 	 String fonts[] = 
 				      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

 				    for (int i = 0; i < fonts.length; i++) {
 				      System.out.println(fonts[i]);
 				    }
		 //   File csvFile = new File("pizzaOrders.csv"); 
		    
        	 try {  
          //       FileWriter myWriter = new FileWriter("pizzaOrders.csv");
          //   FileWriter yoWriter = new FileWriter("pizzaOrders.txt");
      //      PrintWriter out = new PrintWriter(csvFile);
           myWriter.close();
             yoWriter.write(pizza);
             yoWriter.close();
          myWriter.write(out);
        //    out.println(pizza);
         //    System.out.println("Successfully wrote to the file.");
           } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           } */
        	
        	
        	 
        	 }
        	 });
         
       /* String firstName; // User's first name
        String lastName; // User's last name
        String email; // User's email address
        float phone; // User's phone number
        int numberOfPizzasOrdered;
        char crustType; // For type of crust

        String crust = "Hand-tossed"; // Name of crust

        double cost = 12.99; // Cost of the pizza

        final double TAX_RATE = .08; // Sales tax rate

        double tax; // Amount of tax

        char choice; // User's choice

        String userInput; // User input

        String toppings = "Cheese "; // List of toppings

        int numTopps = 0; // Number of toppings*/

        // Prompts user and gets their name.

      //Adding a new Order
        /* 
        
		pzm.append(OrderNo, firstName, inches, crust, cost, TAX_RATE, userInput);*/
     //   /*  pzm.append(OrderNo, customerName, inches, crustType,  toppings, showPrice);
      /*  System.out.print("Enter number of Pizza Orders: ");
        numberOfPizzasOrdered = numberOfPizzasOrderedScanner.nextInt();
        System.out.println("");

        System.out.print("Enter your first name: ");

        firstName = input.nextLine();

        System.out.println("Enter Your last name: ");
        lastName = input.nextLine();
        System.out.println("Enter your phone number: ");
        phone = input.nextFloat();
        System.out.println("Enter your email: "); 
        email = input.nextLine();*/
        
      /*  System.out.println("        10            $10.99");
        System.out.println("        12            $12.99");
        System.out.println("        14            $14.99");
        System.out.println("        16            $16.99");

        System.out.println("What size pizza " + "would you like?");

        System.out.print("10, 12, 14, or 16 " + "(enter the number only): ");

        

        // ADD LINES HERE FOR TASK #2

        // Set price and size of pizza ordered.

        // Consume the remaining newline character.

       

            
        input.nextLine();

        // Prompt user and get crust choice.

        System.out.println("What type of crust " + "do you want? ");

        System.out.print("(H)Hand-tossed, " + "(T) Thin-crust, or " + "(D) Deep-dish " + "(enter H, T, or D): ");

        userInput = input.nextLine();

        crustType = userInput.charAt(0);

        // ADD LINES FOR TASK #3

        // Set user's crust choice on pizza ordered

        // Prompt user and get topping choices one at a time.

        if (crustType == 'H')

            crust = "Hand-tossed";

        else if (crustType == 'T')

            crust = "Thin-crust";

        else if (crustType == 'D')

            crust = "Deep-dish";

        System.out.println("All pizzas come with cheese.");

        System.out.println("Additional toppings are " + "$1.25 each, choose from:");

        System.out.println("Pepperoni, Sausage, " + "Onion, Mushroom");

        // If topping is desired,

        // add to topping list and number of toppings

        System.out.print("Do you want Pepperoni? (Y/N): ");

        userInput = input.nextLine();

        choice = userInput.charAt(0);

        if (choice == 'Y' || choice == 'y') {

        	numTopps += 1;

            toppings = toppings + "Pepperoni ";

        }

        System.out.print("Do you want Sausage? (Y/N): ");

        userInput = input.nextLine();

        choice = userInput.charAt(0);

        if (choice == 'Y' || choice == 'y') {

        	numTopps += 1;

            toppings = toppings + "Sausage ";

        }

        System.out.print("Do you want Onion? (Y/N): ");

        userInput = input.nextLine();

        choice = userInput.charAt(0);

        if (choice == 'Y' || choice == 'y') {

        	numTopps += 1;

            toppings = toppings + "Onion ";

        }

        System.out.print("Do you want Mushroom? (Y/N): ");

        userInput = input.nextLine();

        choice = userInput.charAt(0);

        if (choice == 'Y' || choice == 'y') {

        	numTopps += 1;

            toppings = toppings + "Mushroom ";

        }

        // Add additional toppings cost to cost of pizza.

        cost = cost + (1.25 * numTopps);

        // Display order confirmation.

        System.out.println();

        System.out.println("Your order is as follows: ");

        System.out.println(inches + " inch pizza");

        System.out.println(crust + " crust");

        System.out.println(toppings);

        // ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES

        System.out.printf("The cost of your order " + "is: $%.2f\n", cost);

        // Calculate and display tax and total cost.

        tax = cost * TAX_RATE;

        System.out.printf("The tax is: $%.2f\n", tax);

        System.out.printf("The total due is: $%.2f\n", (tax + cost));

        System.out.println("Your order will be ready " + "for pickup in 30 minutes.");

    }*/

}}
