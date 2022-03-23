package pizzaMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



//import pizzaMenu.PizzaPriceFrame.PriceListener;

public class homePage extends JFrame implements MouseListener{
	
	private JFrame frame;
	private final int FRAME_WIDTH = 1050;
	private final int FRAME_HEIGHT = 675;
	private JPanel pizzaPanel, centerPanel, basePanel,  buttonPanel, 
	headPanel, msgBox;
	Color preserveBackgroundColor;
	private JLabel label;
	JLabel welcomeLabel = new JLabel("Hello!");
	JButton send = new JButton("Submit");
	JButton reset = new JButton("Refresh");
	JButton exit = new JButton("Exit");
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

	private ActionListener press = new optionListener();
	private ActionListener listener = new optionListener();
	public homePage() {
		MyFrame();
		pizzaPanel = new JPanel();
		pizzaPanel.setLayout(new BorderLayout(10, 10));
		//pizzaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		pizzaPanel.setBackground(Color.YELLOW);
		pizzaPanel.setPreferredSize(new Dimension(1050, 800));
		welcomeLabel();
		submitButton();
		createBasePanel();
		createCenterPanel();
		createHeadPanel();
//		addPicture();
		pizzaPanel.add(menuBar, BorderLayout.NORTH);
		pizzaPanel.add(headPanel, BorderLayout.NORTH);
		
		pizzaPanel.add(centerPanel/*, BorderLayout.CENTER*/);
		
		pizzaPanel.add(basePanel, BorderLayout.SOUTH);

//	pizzaPanel.add(label);
		frame = new JFrame(" G'Knights Pizza");
		frame.add(pizzaPanel, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocation(100, 100);
		frame.setVisible(true);
		frame.setJMenuBar(menuBar);
	//	frame.setLayout(layoutMgr);
		frame.setVisible(true);
	//	frame.getContentPane().add(label);
	}
	private void createBasePanel() {
		basePanel = new JPanel();
		basePanel.add(new JLabel());
		basePanel.setBackground(new Color(153,102,0));
		basePanel.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addPicture() {
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pepperoniPizza.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBorder(new TitledBorder(new EtchedBorder(65, new Color(0,153,0), preserveBackgroundColor)));
	// label.setLayout(new FlowLayout(FlowLayout.CENTER));
		label.setBackground(Color.BLUE);
		label.setVisible(true);
	}
	private void createCenterPanel() {
		
		addPicture();
		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(1050, 400));
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setBackground(Color.yellow);
		
		centerPanel.add(msgBox, BorderLayout.NORTH);
		centerPanel.add(label, BorderLayout.SOUTH);

		}
	private void createHeadPanel() {
		headPanel = new JPanel();
		JLabel label;
	   headPanel.add(label = new JLabel("Welcome to G'Knights Pizza! "));
	   headPanel.setBackground(Color.ORANGE);
	   label.setFont(new Font("Monaco",Font.ITALIC,25));
	   label.setForeground(Color.blue);
	  
	}
	private void submitButton() {
		buttonPanel = new JPanel(); // the panel is not visible in output
		reset.setFocusable(false);
	//	send.setFocusable(false);
		exit.setFocusable(false);
		menu.setFocusable(false);
		buttonPanel.setBackground(Color.ORANGE);
		 // Components Added using Flow Layout
		menu.addActionListener(press);
		menu.addMouseListener(this);
		menu.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		menu.setBackground(new Color(255,51,51));
		menu.setForeground(Color.BLACK);
		buttonPanel.add(menu);
		send.addActionListener(press);
		send.setBackground(new Color(0,153,0));
	//	buttonPanel.add(send);
		reset.addActionListener(press);
		reset.addMouseListener(this);
		reset.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		reset.setBackground(new Color(51,153,225));
		reset.setForeground(Color.BLACK);
		buttonPanel.add(reset);
		exit.addActionListener(press);
		exit.addMouseListener(this);
		exit.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.BLACK);
		buttonPanel.add(exit);
		//buttonPanel.add(messageLabel, BorderLayout.SOUTH);
		}
	private void welcomeLabel() {
		msgBox = new JPanel();
		msgBox.setPreferredSize(new Dimension(600, 100));
		msgBox.setBackground(Color.RED);
		msgBox.setBorder(new TitledBorder(new EtchedBorder(75, new Color(0,153,0), preserveBackgroundColor)));
		welcomeLabel.setFont(new Font(null,Font.ITALIC,15));
		welcomeLabel.setForeground(new Color(0,153,0));
		welcomeLabel.setText("<html>Here at G-Knight Pizza we are serving you your own costumizable pizzas!"
				+ " We're a family <br/>owned franchise bringing you the first-class dining experience. Download "
				+ "our "+ "<br/>" + "pizza-app today and " + "we can hook you up anytime anywhere.</html>");
		msgBox.add(welcomeLabel);
	}
	private void MyFrame(){		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}
	private class optionListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource()== exit) {
				
				frame.dispose();
				System.out.println("Goodbye.");
			}
			if(event.getSource()== menu) {
				
				frame.dispose();
				PizzaPriceFrame pPF = new PizzaPriceFrame();
			}
			if(event.getSource()== reset) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
			}
			if(event.getSource()==loadItem) {
				System.out.println("*beep boop* you loaded a file");
			}
			if(event.getSource()==saveItem) {
				System.out.println("*beep boop* you saved a file");
			}
			if(event.getSource()==exitItem) {
				System.exit(0);
				System.out.println("Goodbye.");
			}
			if(event.getSource()==homeItem) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* you back to homepage");
			}
			if(event.getSource()==menuItem) {
				
				frame.dispose();
				PizzaPriceFrame pPF = new PizzaPriceFrame();
				System.out.println("To the order frame.");
			}
			if(event.getSource()==newItem) {
				
				frame.dispose();
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* reopen current page");
			}
			if(event.getSource()==winItem) {
				
				
				homePage hmp = new homePage(); 
				System.out.println("*beep boop* opens new window");
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		 if(e.getSource()== reset) {
				reset.setForeground(Color.white);
				reset.setBackground(new Color(51, 204, 255));
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
		menu.setBackground(new Color(255,51,51));
		reset.setForeground(Color.BLACK);
		reset.setBackground(new Color(51,153,225));
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
