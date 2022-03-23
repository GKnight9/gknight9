package pizzaMenu;
/**
 * @author Garrett Knight
 * CSIS 2420
 * Final Project Pizza Menu
 * This class informs the user that their order has been placed
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class OrderConfirmation extends JFrame implements MouseListener{
	
	PizzaMenu pzm = new PizzaMenu();
	JFrame frame = new JFrame("G'Knight's Pizza");
	JLabel welcomeLabel = new JLabel("Hello!");
	JLabel welcomeLabel2 = new JLabel();
	 JPanel pizzaPanel, buttonPanel, headPanel;
	 JButton exit = new JButton("Exit");
	 JButton home = new JButton("Home");
	 JButton menu = new JButton("Menu");
	 
	 	JMenuBar menuBar;
	 	JMenu fileMenu;
		JMenu editMenu;
		JMenu helpMenu;
		JMenu navMenu;
		JMenuItem loadItem;
		JMenuItem saveItem;
		JMenuItem exitItem;
		JMenuItem homeItem;
		JMenuItem menuItem;
		JMenuItem newItem;
		JMenuItem winItem;
		JMenuItem cut,copy,paste,selectAll;    
		
	 private ActionListener press = new buttonListener();
	 private ActionListener listener = new buttonListener();
//	private String userInput;
	OrderConfirmation(int OrderNo, String customerName, double showPrice, int inches, String toppings, 
			String crustType, double tax, int numTopps, int numPizzas, String userInput, String orderStats, 
			double TAX_RATE) {
		
		// TO) {welcomeLabel.setBackground(Color.ORANGE);
		
		welcomeLabel.setBounds(0,50,2000, 405);
		welcomeLabel.setFont(new Font(null,Font.ITALIC,25));
		welcomeLabel.setForeground(new Color(0,153,0));
		welcomeLabel2.setBounds(0,500,2000, 405);
		welcomeLabel2.setFont(new Font(null,Font.ITALIC,25));
		welcomeLabel2.setForeground(new Color(0,153,0));
		welcomeLabel.setText("<html>" + customerName + ", your order is as follows: <br/><br/>Pizzas Ordered "
		+ numPizzas + "<br>" + inches + " inches<br/>" + toppings + " " + numTopps + " topping(s)<br/>" + 
		crustType + "<br/>" + String.format("The tax is: " + "$%.2f", tax) + String.format("<br/>Your total "
	    + "price is: $%.2f", showPrice + tax ) +  "<br/>Your order will be " + orderStats + " in "
	    		+ "30 minutes." + "<br>" + "Order #: " + OrderNo + "</html>");
		if (numPizzas > 1) {
			pzm.prepend(OrderNo, customerName, inches, crustType, showPrice, TAX_RATE, userInput, tax, toppings, 
					numTopps, numPizzas);
			welcomeLabel2.setText("<html>" + inches + " inches<br/>" + toppings + " " + numTopps + 
					" topping(s)<br/>" + crustType + "<br/>" + String.format("The tax is: " + "$%.2f", tax) + 
					String.format("<br/>Your total " + "price is: $%.2f", showPrice + tax ) + 
					"<br/>Your order will be " + orderStats + " in "+ "30 minutes." + "<br>" + "Order #: " + 
					OrderNo + "</html>");
			
		}
		frame.setJMenuBar(menuBar);
		
		//frame.setVisible(true);
		frame.add(welcomeLabel2);
		frame.add(welcomeLabel);
	//welcomeLabel.add(buttonPanel, BorderLayout.SOUTH);
	//welcomeLabel.add(pizzaPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 500);
		frame.setLayout(new BorderLayout(925, 0));
		frame.setVisible(true);
		MyFrame();
		createHeadPanel(customerName);
		createBackground();
		submitButton();
		
		
	}
	private void createBackground() {
		pizzaPanel = new JPanel();
		pizzaPanel.setLayout(new BorderLayout(925, 420));
		pizzaPanel.setBackground(Color.YELLOW);
		frame.add(pizzaPanel, BorderLayout.CENTER);pizzaPanel.add(headPanel, BorderLayout.NORTH);
	//	frame.setVisible(true);
	}
	private void submitButton() {
		buttonPanel = new JPanel(); // the panel is not visible in output
		home.setFocusable(false);
		/*send.setFocusable(false);*/
		exit.setFocusable(false);
		menu.setFocusable(false);
		buttonPanel.setBackground(Color.ORANGE);
//		buttonPanel.setLayout(new BorderLayout(82, 42));
		 // Components Added using Flow Layout
		home.addActionListener(press);
		home.addMouseListener(this);
		home.setBackground(new Color(0,153,0));
		home.setForeground(Color.BLACK);
		home.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		buttonPanel.add(home);
		menu.addActionListener(press);
		menu.addMouseListener(this);
		menu.setBackground(new Color(255,51,51));
		menu.setForeground(Color.BLACK);
		menu.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		buttonPanel.add(menu);
		/*send.addActionListener(press);
		send.setBackground(new Color(0,153,0));
		buttonPanel.add(send);*/
		
		exit.addActionListener(press);
		exit.addMouseListener(this);
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		buttonPanel.add(exit);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		}
	private void createHeadPanel(String customer) {
		headPanel = new JPanel();
		JLabel label;
	   
	headPanel.add(label = new JLabel("Thanks " + customer + "!"));
	   headPanel.setBackground(new Color(153,102,0));
	   label.setFont(new Font("Monaco",Font.ITALIC,25));
	   label.setForeground(Color.GREEN);

	
	//frame.setVisible(true);
	}
	private void MyFrame() {		
		
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**/
		
		//loadIcon = new ImageIcon("load.png");
		//saveIcon = new ImageIcon("save.png");
		//exitIcon = new ImageIcon("exit.png");
		
		menuBar = new JMenuBar();
		//	menuBar.setSize(1000,50);
			menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

			
			fileMenu = new JMenu("File");
			
			navMenu = new JMenu("Navigate");
			editMenu = new JMenu("Edit");
			helpMenu = new JMenu("Help");
			
			cut=new JMenuItem("cut");    
			copy=new JMenuItem("copy");    
			paste=new JMenuItem("paste");    
			selectAll=new JMenuItem("selectAll");    
			cut.addActionListener(listener);    
			copy.addActionListener(listener);    
			paste.addActionListener(listener);    
			selectAll.addActionListener(listener); 
			
			newItem = new JMenuItem("New");
			loadItem = new JMenuItem("Load");
			saveItem = new JMenuItem("Save");
			exitItem = new JMenuItem("Exit");
			homeItem = new JMenuItem("Home");
			menuItem = new JMenuItem("Menu");
			winItem = new JMenuItem("New Window");
			
			newItem.addActionListener(listener);
			loadItem.addActionListener(listener);
			saveItem.addActionListener(listener);
			exitItem.addActionListener(listener);
			homeItem.addActionListener(listener);
			menuItem.addActionListener(listener);
			winItem.addActionListener(listener);
			//loadItem.setIcon(loadIcon);
			//saveItem.setIcon(saveIcon);
			//exitItem.setIcon(exitIcon);
			
			fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
			editMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
			helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for help
			navMenu.setMnemonic(KeyEvent.VK_N); // Alt + n for navigate
			loadItem.setMnemonic(KeyEvent.VK_L); // l for load
			saveItem.setMnemonic(KeyEvent.VK_S); // s for save
			exitItem.setMnemonic(KeyEvent.VK_E); // e for exit
			homeItem.setMnemonic(KeyEvent.VK_H); // h for homepage
			menuItem.setMnemonic(KeyEvent.VK_M); // m to open menu
			newItem.setMnemonic(KeyEvent.VK_N); // n to open window
			winItem.setMnemonic(KeyEvent.VK_W); // w to open duplicate window
			
			fileMenu.add(newItem);
			fileMenu.add(winItem);
			fileMenu.add(loadItem);
			fileMenu.add(saveItem);
			fileMenu.add(exitItem);
			
			editMenu.add(cut);editMenu.add(copy);editMenu.add(paste);editMenu.add(selectAll);
			
			navMenu.add(homeItem);
			navMenu.add(menuItem);
			//menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			loadItem.setBackground(Color.WHITE);
		
			saveItem.setBackground(Color.WHITE);
			exitItem.setBackground(Color.WHITE);
			homeItem.setBackground(Color.WHITE);
			menuItem.setBackground(Color.WHITE);
			newItem.setBackground(Color.WHITE);
			winItem.setBackground(Color.WHITE);
			cut.setBackground(Color.WHITE);
			copy.setBackground(Color.WHITE);
			paste.setBackground(Color.WHITE);
			selectAll.setBackground(Color.WHITE);
			menuBar.add(fileMenu);
			menuBar.add(editMenu);
			menuBar.add(navMenu);
			menuBar.add(helpMenu);
			menuBar.setBackground(Color.LIGHT_GRAY);
			//Menu Bar font
			fileMenu.setFont(new Font("Times New Roman",Font.PLAIN,18));
			editMenu.setFont(new Font("Times New Roman",Font.PLAIN,18));
			helpMenu.setFont(new Font("Times New Roman",Font.PLAIN,18));
			navMenu.setFont(new Font("Times New Roman",Font.PLAIN,18));
			//Item Menu Font
			loadItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			saveItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			exitItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			homeItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			menuItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			newItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			winItem.setFont(new Font("Times New Roman",Font.PLAIN,15));
			//Edit Menu
			cut.setFont(new Font("Times New Roman",Font.PLAIN,15));
			copy.setFont(new Font("Times New Roman",Font.PLAIN,15));
			paste.setFont(new Font("Times New Roman",Font.PLAIN,15));
			selectAll.setFont(new Font("Times New Roman",Font.PLAIN,15));
		frame.add(menuBar, BorderLayout.NORTH);
	}
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== exit) {
				
				frame.dispose();
				System.out.println("Goodbye.");
			}
			if(e.getSource()== home) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
			}
			if(e.getSource()== menu) {
				
				frame.dispose();
				PizzaPriceFrame pPF = new PizzaPriceFrame();
			}
			if(e.getSource()==loadItem) {
				System.out.println("*beep boop* you loaded a file");
			}
			if(e.getSource()==saveItem) {
				System.out.println("*beep boop* you saved a file");
			}
			if(e.getSource()==exitItem) {
				System.exit(0);
				System.out.println("Goodbye.");
			}
			if(e.getSource()==homeItem) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* you back to homepage");
			}
			if(e.getSource()==menuItem) {
				
				frame.dispose();
				PizzaPriceFrame pPF = new PizzaPriceFrame();
				System.out.println("To the order frame.");
			}
			if(e.getSource()==newItem) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* reopen current page");
			}
			if(e.getSource()==winItem) {
				
				
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* opens new window");
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		 if(e.getSource()==home) {
				home.setForeground(Color.white);
				home.setBackground(new Color(0, 204, 0));
			}
		 if(e.getSource()== menu) {
				menu.setForeground(Color.white);
				menu.setBackground(new Color(255,102,102));
			}
		 if(e.getSource()== exit) {
				exit.setForeground(Color.white);
				exit.setBackground(Color.LIGHT_GRAY);
			}
	} 
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//button.setBackground(Color.RED);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		//For the navigation buttons
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(255, 51, 51));
		home.setForeground(Color.BLACK);
		home.setBackground(new Color(0,153,0));
		exit.setForeground(Color.BLACK);
		exit.setBackground(Color.GRAY);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


