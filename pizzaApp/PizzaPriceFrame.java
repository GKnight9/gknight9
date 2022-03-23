package pizzaMenu;
/**
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This class contains the commands of the GUI Window
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import org.omg.CORBA.portable.InputStream;
public class PizzaPriceFrame extends JFrame implements MouseListener, ChangeListener{
private static final long serialVersionUID = 1L;
private JFrame frame;
private JPanel pizzaPanel, centerPanel, pricePanel, checkBoxPanel, radioButtonPanel, textPanel, buttonPanel, 
labelItem, headPanel, switchPanel, buttoonPanel, topPanel, butonPanel, msgDis, sneakPeak, navigatorPanel, slot1, 
slot2, navPanel, comment;
private final int FRAME_WIDTH = MAXIMIZED_BOTH;
private final int FRAME_HEIGHT = 900;
private ButtonGroup group;
private JRadioButton smallButton, mediumButton, largeButton, xlargeButton, bgCheese, 
invisButton;
private JCheckBox peppCheckBox, mushCheckBox, onionCheckBox, sausCheckBox, pineCheckBox, olivCheckBox, jalCheckBox,
hamCheckBox, belCheckBox, bacCheckBox;
private JTextField priceTextField, typeTextField, qtyTextField, toppTextfield, taxTextField;
Color preserveBackgroundColor;
JComboBox comboBox;
JLabel chooseType;
TitledBorder rlabel;
JPanel hType;
JTextArea ta;
JButton send = new JButton("Submit");
JButton reset = new JButton("Reset");
JButton exit = new JButton("Exit");
JButton add = new JButton("Add");
JButton clear = new JButton("Clear");
JButton all = new JButton("All");
JButton clear1 = new JButton("Clear");
JButton home = new JButton("Home");
JButton refresh = new JButton("Refresh");
JButton cancel = new JButton("Cancel");
JToggleButton button = new JToggleButton("");
JToggleButton button1 = new JToggleButton("");
JLabel messageLabel = new JLabel();
JLabel errMSG = new JLabel();
JLabel myLabel = new JLabel();

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

HashMap<String,String> logininfo = new HashMap<String,String>();
private double price = 0.0;
private double topPrice = 0.0;
private double showPrice = 0.0;
final double TAX_RATE = .08;
double delivFee = 0.0;
int numPizzas = 1;
String[] pizzaCrust = {"Choose", "Hand-tossed ", "Thin-crust", "Deep-dish", "Stuffed-crust"};
private ActionListener listener = new PriceListener();
private ActionListener press = new PriceListener();
//private MouseListener listen = new mouseListener();
Color bg;
MyPanel panel;
private JSpinner spinner;

SpinnerModel value =  
new SpinnerNumberModel(1, //initial value  
   0, //minimum value  
   100, //maximum value  
   1); //step  
public PizzaPriceFrame() {
pizzaPanel = new JPanel();
pizzaPanel.setLayout(new BorderLayout(10, 10));
pizzaPanel.setBackground(Color.YELLOW);
createRadioButtonPanel();
createTextPanel();
createCheckBoxPanel();
try {
java.io.InputStream is = PizzaPriceFrame.class.getResourceAsStream("the-shire-font/TheShireItalic-e7xx.ttf");
Font font = Font.createFont(Font.TRUETYPE_FONT, is);

Font sizedFont = font.deriveFont(12f);
myLabel.setFont(sizedFont);
} catch (FontFormatException | IOException ex) {
    Logger.getLogger(PizzaPriceFrame.class.getName()).log(Level.SEVERE, null, ex);
    return;
}
MyFrame();
myPanel();
createCombox();
setJToggleButton();
submitButton();
createPricePanel();
createCenterPanel();
createHeadPanel();
textArea();
//msgLabel();
//pizzaPanel.add(menuBar, BorderLayout.NORTH);
pizzaPanel.add(centerPanel, BorderLayout.CENTER);
pizzaPanel.add(pricePanel, BorderLayout.SOUTH);
spinner = new JSpinner(value);
//create an object of the class

pricePanel.add(spinner);
pizzaPanel.add(headPanel, BorderLayout.NORTH);
pizzaPanel.add(navigatorPanel, BorderLayout.WEST);
frame = new JFrame(" G'Knights Pizza");
frame.getContentPane().add(pizzaPanel, BorderLayout.CENTER);
//frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocation(100, 100);
frame.setVisible(true);
frame.setJMenuBar(menuBar);

frame.setVisible(true);
}
/*errMSG.setVerticalTextPosition(JLabel.BOTTOM);
*/
//messageLabel.setBounds(125,25,250,35);
//errMSG.setBounds(120, 250, 250, 35);
//errMSG.setLocation(10,150);

private void createRadioButtonPanel() {
radioButtonPanel = new JPanel();
/*rlabel = new JLabel();
radioButtonPanel.add(rlabel);*/
radioButtonPanel.setBorder((Border) (rlabel = new TitledBorder(new EtchedBorder(), "Pizza Size ")));
radioButtonPanel.setBackground(Color.ORANGE);
rlabel.setTitleFont(new Font("Monaco",Font.ITALIC,18));
group = new ButtonGroup();
smallButton = new JRadioButton(" Small (10 Inch) $10.99");
smallButton.setBackground(Color.ORANGE);
smallButton.setForeground(Color.BLACK);
smallButton.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
group.add(smallButton);
smallButton.addActionListener(listener);
smallButton.addMouseListener(this);
radioButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));
radioButtonPanel.add(smallButton);
mediumButton = new JRadioButton(" Medium (12  Inch) $12.99");
mediumButton.setBackground(Color.ORANGE);
mediumButton.setForeground(Color.BLACK);
mediumButton.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
group.add(mediumButton);
mediumButton.addActionListener(listener);
mediumButton.addMouseListener(this);
radioButtonPanel.add(mediumButton);
largeButton = new JRadioButton(" Large (14 Inch) $14.99");
largeButton.setBackground(Color.ORANGE);
largeButton.setForeground(Color.BLACK);
largeButton.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
group.add(largeButton);
largeButton.addActionListener(listener);
largeButton.addMouseListener(this);
radioButtonPanel.add(largeButton);
xlargeButton = new JRadioButton(" X-Large (16 Inch) $16.99");
xlargeButton.setBackground(Color.ORANGE);
xlargeButton.setForeground(Color.BLACK);
xlargeButton.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
group.add(xlargeButton);
xlargeButton.addActionListener(listener);
xlargeButton.addMouseListener(this);
radioButtonPanel.add(xlargeButton);
bgCheese = new JRadioButton(" Big Cheese (2 Feet) $24.49");
bgCheese.setBackground(Color.ORANGE);
bgCheese.setForeground(Color.BLACK);
bgCheese.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
group.add(bgCheese);
bgCheese.addActionListener(listener);
bgCheese.addMouseListener(this);
radioButtonPanel.add(bgCheese);
invisButton = new JRadioButton();
group.add(invisButton);
invisButton.addActionListener(listener);

butonPanel = new JPanel();
butonPanel.setBackground(new Color(153,102,0));
butonPanel.setLayout(new BorderLayout(10, 10));
butonPanel.setPreferredSize(new Dimension(70, 15));
butonPanel.add(clear1,  BorderLayout.EAST);
clear1.setFocusable(false);
clear1.setPreferredSize(new Dimension(65, 5));
clear1.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
clear1.setForeground(Color.BLACK);
clear1.setBackground(new Color(51,153,225));
clear1.addMouseListener(this);
clear1.addActionListener(press);
radioButtonPanel.add(butonPanel);
}

private void createCombox()  {
	UIManager.put("ComboBox.selectionBackground",new javax.swing.plaf.ColorUIResource(new Color(0,153, 0)));
	UIManager.put("ComboBox.selectionForeground",new javax.swing.plaf.ColorUIResource(Color.WHITE));
	labelItem = new JPanel();
	labelItem.setLayout(new GridLayout(1, 1));
	
	
	comboBox = new JComboBox(pizzaCrust);
	//comboBox.setLayout(new GridLayout(1, 1));
/*	chooseType = new JLabel("Choose");
	
//	chooseType.addMouseListener(listen);
	comboBox.add(chooseType);*/
	comboBox.setBorder(rlabel = new TitledBorder(new EtchedBorder(), "Type of Crust"));
	rlabel.setTitleFont(new Font("Monaco",Font.ITALIC,18));
	comboBox.setFont(new Font("Monaco",Font.PLAIN,15));
	comboBox.setBackground(Color.ORANGE);
	comboBox.setForeground(Color.BLACK);
	comboBox.addActionListener((ActionListener) listener);
	comboBox.addMouseListener(this);
	comboBox.setSelectedItem("Choose");
	labelItem.add(comboBox);
	for (String crust : pizzaCrust ) {
		crust = "Choose";
	}
/*	comboBox.add(hType);
	hType = new JPanel();
//	hType = pizzaCrust[1];
	hType.setBackground(Color.cyan);
	comboBox.addMouseListener(this);
//	hType.setBackground();
	//comboBox.setVisible(false);*/
	
	
}
private void setJToggleButton() { 

    switchPanel = new JPanel(); 
    switchPanel.setPreferredSize(new Dimension(125, 75));
    switchPanel.setLayout(new GridLayout(1, 2));
    switchPanel.setBorder(rlabel = new TitledBorder(new EtchedBorder(), "OrderType"));
    rlabel.setTitleFont(new Font("Monaco",Font.ITALIC,18));
    switchPanel.setBackground(Color.ORANGE);
   
    slot1 = new JPanel();
    slot1.add(button); 
    slot1.setPreferredSize(new Dimension(100, 35));
    slot1.setBackground(Color.ORANGE);
    switchPanel.add(slot1); 
    button.setText("Pick-Up");  
    button.setFont(new Font("HP Simplified Jpan",Font.BOLD,14));
    button.setBackground(bg);
    button.setPreferredSize(new Dimension(100, 30));
    button.addActionListener(listener);
    button.addMouseListener(this);
}  
private void createTextPanel() {
textPanel = new JPanel();
textPanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
textPanel.setBackground(Color.ORANGE);
textPanel.setLayout(new GridLayout());
textPanel.add(new JLabel(" Your Name: "));
textPanel.setFont(new Font("HP Simplified Jpan",Font.PLAIN,12));
typeTextField = new JTextField(12);

typeTextField.setFont(new Font("Serif", Font.BOLD, 12));
typeTextField.setEditable(true);
typeTextField.setForeground(Color.black);
typeTextField.setBackground(Color.WHITE);
typeTextField.setDisabledTextColor(Color.black);
typeTextField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
textPanel.add(typeTextField);

}
private void createCheckBoxPanel() {
checkBoxPanel = new JPanel();

checkBoxPanel.setLayout(new GridLayout(6, 2));
checkBoxPanel.setBackground(Color.ORANGE);
checkBoxPanel.setBorder(rlabel = new TitledBorder(new EtchedBorder(), "Toppings "));
rlabel.setTitleFont(new Font("Monaco",Font.ITALIC,18));
peppCheckBox = new JCheckBox(" Pepperoni $1.50");
peppCheckBox.setBackground(Color.ORANGE);
peppCheckBox.setForeground(Color.BLACK);
peppCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
peppCheckBox.addActionListener(listener);
peppCheckBox.addMouseListener(this); 
checkBoxPanel.add(peppCheckBox);
mushCheckBox = new JCheckBox(" Mushrooms $1.25");
mushCheckBox.setBackground(Color.ORANGE);
mushCheckBox.setForeground(Color.BLACK);
mushCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
mushCheckBox.addActionListener(listener);
mushCheckBox.addMouseListener(this); 
checkBoxPanel.add(mushCheckBox);
onionCheckBox = new JCheckBox(" Onion $1.25");
onionCheckBox.setBackground(Color.ORANGE);
onionCheckBox.setForeground(Color.BLACK);
onionCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
onionCheckBox.addActionListener(listener);
onionCheckBox.addMouseListener(this); 
checkBoxPanel.add(onionCheckBox);
sausCheckBox = new JCheckBox(" Sausage $1.50");
sausCheckBox.setBackground(Color.ORANGE);
sausCheckBox.setForeground(Color.BLACK);
sausCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
sausCheckBox.addActionListener(listener);
sausCheckBox.addMouseListener(this); 
checkBoxPanel.add(sausCheckBox);
pineCheckBox = new JCheckBox(" Pineapple $1.75");
pineCheckBox.setBackground(Color.ORANGE);
pineCheckBox.setForeground(Color.BLACK);
pineCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
pineCheckBox.addActionListener(listener);
pineCheckBox.addMouseListener(this); 
checkBoxPanel.add(pineCheckBox);
olivCheckBox = new JCheckBox(" Olives $1.25");
olivCheckBox.setBackground(Color.ORANGE);
olivCheckBox.setForeground(Color.BLACK);
olivCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
olivCheckBox.addActionListener(listener);
olivCheckBox.addMouseListener(this); 
checkBoxPanel.add(olivCheckBox);
jalCheckBox = new JCheckBox(" Jalapenos $2.00");
jalCheckBox.setBackground(Color.ORANGE);
jalCheckBox.setForeground(Color.BLACK);
jalCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
jalCheckBox.addActionListener(listener);
jalCheckBox.addMouseListener(this); 
checkBoxPanel.add(jalCheckBox);
hamCheckBox = new JCheckBox(" Ham $1.75");
hamCheckBox.setBackground(Color.ORANGE);
hamCheckBox.setForeground(Color.BLACK);
hamCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
hamCheckBox.addActionListener(listener);
hamCheckBox.addMouseListener(this); 
checkBoxPanel.add(hamCheckBox);
belCheckBox = new JCheckBox(" Bell Pepper $1.25");
belCheckBox.setBackground(Color.ORANGE);
belCheckBox.setForeground(Color.BLACK);
belCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
belCheckBox.addActionListener(listener);
belCheckBox.addMouseListener(this); 
checkBoxPanel.add(belCheckBox);
bacCheckBox = new JCheckBox(" Canadian Bacon $1.50");
bacCheckBox.setBackground(Color.ORANGE);
bacCheckBox.setForeground(Color.BLACK);
bacCheckBox.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
bacCheckBox.addActionListener(listener);
bacCheckBox.addMouseListener(this); 
checkBoxPanel.add(bacCheckBox);
//checkBoxPanel.add(new JLabel("$1.25 each"));

topPanel = new JPanel();
topPanel.add(new JLabel("No. Toppings: "));
topPanel.setBackground(new Color(153,102,0));
toppTextfield = new JTextField(2);
topPanel.setPreferredSize(new Dimension(25, 20));
toppTextfield.setFont(new Font("Serif", Font.BOLD, 12));
toppTextfield.setEditable(false);
toppTextfield.setForeground(Color.black);
toppTextfield.setBackground(Color.WHITE);
toppTextfield.setDisabledTextColor(Color.red);
toppTextfield.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
topPanel.add(toppTextfield);
checkBoxPanel.add(topPanel);

buttoonPanel = new JPanel(); // the panel is not visible in output
all.setFocusable(false);
clear.setFocusable(false);
buttoonPanel.add(all);
buttoonPanel.add(clear);
buttoonPanel.setBackground(new Color(153,102,0));
all.setPreferredSize(new Dimension(65, 20));
all.setBackground(new Color(255,51,51));
all.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
all.setForeground(Color.BLACK);
all.addActionListener(press);
all.addMouseListener(this);
clear.setPreferredSize(new Dimension(65, 20));
clear.setBackground(new Color(51,153,225));
clear.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
clear.setForeground(Color.BLACK);
clear.addActionListener(press);
clear.addMouseListener(this);
checkBoxPanel.add(buttoonPanel);


}

//Creating the panel at bottom and adding toppTextfield.setText(String.format(" %d", numTopps));components
private void submitButton() {
buttonPanel = new JPanel(); // the panel is not visible in output
reset.setFocusable(false);
send.setFocusable(false);
exit.setFocusable(false);
add.setFocusable(false);
buttonPanel.setBackground(Color.ORANGE);
 // Components Added using Flow Layout
add.addActionListener(press);
add.addMouseListener(this);
add.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
add.setBackground(new Color(255,51,51));
add.setForeground(Color.BLACK);
add.setPreferredSize(new Dimension(65, 50));
buttonPanel.add(add);
send.addActionListener(press);
send.addMouseListener(this);
send.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
send.setBackground(new Color(0,153,0));
send.setForeground(Color.BLACK);
send.setPreferredSize(new Dimension(85, 50));
buttonPanel.add(send);
reset.addActionListener(press);
reset.addMouseListener(this);
reset.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
reset.setBackground(new Color(51,153,225));
reset.setForeground(Color.BLACK);
reset.setPreferredSize(new Dimension(80, 50));
buttonPanel.add(reset);
exit.addActionListener(press);
exit.addMouseListener(this);
exit.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
exit.setBackground(Color.GRAY);
exit.setForeground(Color.BLACK);
exit.setPreferredSize(new Dimension(80, 20));
cancel.addActionListener(press);
cancel.addMouseListener(this);
cancel.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 16));
cancel.setBackground(Color.LIGHT_GRAY);
cancel.setForeground(Color.BLACK);
cancel.setPreferredSize(new Dimension(80, 50));
buttonPanel.add(cancel);
//buttonPanel.add(messageLabel, BorderLayout.SOUTH);
home.setFocusable(false);
refresh.setFocusable(false);


buttonPanel.setBackground(Color.ORANGE);
//buttonPanel.setLayout(new BorderLayout(82, 42));
navigatorPanel = new JPanel();
navigatorPanel.setPreferredSize(new Dimension (85,50));
navigatorPanel.setBackground(Color.YELLOW);
home.addActionListener(press);
home.addMouseListener(this);
home.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
home.setBackground(Color.GREEN);
home.setForeground(Color.BLACK);
home.setPreferredSize(new Dimension(80, 20));
refresh.addActionListener(press);
refresh.addMouseListener(this);
refresh.setFont(new Font("HP Simplified Jpan",Font.PLAIN, 12));
refresh.setBackground(Color.CYAN);
refresh.setForeground(Color.BLACK);
refresh.setPreferredSize(new Dimension(80, 20));

navigatorPanel.add(home);
navigatorPanel.add(refresh);
navigatorPanel.add(exit);
}
private void textArea() {
	comment = new JPanel();
	comment.setBackground(Color.ORANGE);
	comment.setBorder(rlabel = new TitledBorder(new EtchedBorder(), "Notes: "));
	rlabel.setTitleFont(new Font("Monaco",Font.ITALIC,18));
	comment.setPreferredSize(new Dimension(175, 170));
	ta =new JTextArea();    
	ta.setPreferredSize(new Dimension(160, 120)); 
	//ta.addActionListener(listener);
	comment.add(ta);
	//comment.setLayout(new FlowLayout(1000));
}
private void createPricePanel() {

pricePanel = new JPanel();

pricePanel.add(new JLabel("Tax: "));
taxTextField = new JTextField(4);
taxTextField.setFont(new Font("Serif", Font.BOLD, 12));
taxTextField.setEditable(false);
taxTextField.setForeground(Color.blue);
taxTextField.setBackground(Color.WHITE);
taxTextField.setDisabledTextColor(Color.red);
taxTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
pricePanel.add(taxTextField);
taxTextField.setText(" n/a");
pricePanel.add(new JLabel("Your Price:"));
pricePanel.setBackground(new Color(153,102,0));
priceTextField = new JTextField(7);
priceTextField.setFont(new Font("Serif", Font.BOLD, 12));
priceTextField.setEditable(false);
priceTextField.setForeground(Color.red);
priceTextField.setBackground(Color.WHITE);
priceTextField.setDisabledTextColor(Color.red);
priceTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
pricePanel.add(priceTextField);
priceTextField.setText(" n/a Price");
pricePanel.add(new JLabel("QTY:"));
//pricePanel.setBackground(new Color(153,102,0));
qtyTextField = new JTextField(2);
qtyTextField.setFont(new Font("Serif", Font.BOLD, 12));
qtyTextField.setEditable(false);
qtyTextField.setForeground(Color.black);
qtyTextField.setBackground(Color.WHITE);
qtyTextField.setDisabledTextColor(Color.red);
qtyTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
pricePanel.add(qtyTextField);
//spinner.addChangeListener(this);

/*pricePanel.add(new JLabel("No. Toppings: "));
toppTextfield = new JTextField(2);
toppTextfield.setFont(new Font("Serif", Font.BOLD, 12));
toppTextfield.setEditable(false);
toppTextfield.setForeground(Color.black);
toppTextfield.setBackground(Color.WHITE);
toppTextfield.setDisabledTextColor(Color.red);
toppTextfield.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
pricePanel.add(toppTextfield);*/
}
private void msgLabel() {
	msgDis = new JPanel();
	msgDis.setPreferredSize(new Dimension (275, 80));
	msgDis.setLayout(new GridLayout(2, 1));
	msgDis.setBackground(Color.YELLOW);
	messageLabel.setBounds(25,10,250,35);
	messageLabel.setHorizontalAlignment(JLabel.CENTER);
	errMSG.setBounds(120, 35, 250, 35);
	errMSG.setHorizontalTextPosition(JLabel.LEFT);
	msgDis.add(messageLabel);
	msgDis.add(errMSG);
	
}
private void createCenterPanel() {
centerPanel = new JPanel();
msgLabel();
textArea();
centerPanel.setBackground(Color.YELLOW);
//centerPanel.setLayout(new GridLayout(4, 3));
centerPanel.add(radioButtonPanel);
centerPanel.add(checkBoxPanel);
centerPanel.add(labelItem);
centerPanel.add(switchPanel);
centerPanel.add(textPanel);
centerPanel.add(comment);
//centerPanel.add(messageLabel, BorderLayout.SOUTH);
//centerPanel.add(errMSG, BorderLayout.SOUTH);
centerPanel.add(msgDis);

centerPanel.add(sneakPeak);
centerPanel.add(buttonPanel);

}
private void createHeadPanel() {
	headPanel = new JPanel();
	JLabel label;
	try {
		java.io.InputStream is = PizzaPriceFrame.class.getResourceAsStream("the-shire-font/TheShireItalic-e7xx.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);

		Font sizedFont = font.deriveFont(12f);
		myLabel.setFont(sizedFont);
		} catch (FontFormatException | IOException ex) {
		    Logger.getLogger(PizzaPriceFrame.class.getName()).log(Level.SEVERE, null, ex);
		    return;
		}
//	headPanel.add(menuBar, BorderLayout.NORTH);
   headPanel.add(label = new JLabel("Customize your Pizza! "));
   headPanel.setBackground(Color.ORANGE);
 //  headPanel.setPreferredSize(new Dimension(1000, 50));
   label.setFont(new Font("TheShireItalic-e7xx.ttf",Font.ITALIC,25));
   label.setForeground(Color.blue);
}
private void myPanel() {
	
	panel = new MyPanel();
	sneakPeak = new JPanel();
	sneakPeak.add(panel); 
	sneakPeak.setPreferredSize(new Dimension(500, 425));
	sneakPeak.setBackground(Color.CYAN);
	sneakPeak.setBorder(new TitledBorder(new EtchedBorder(65, new Color(0,153,0), preserveBackgroundColor)));
}

private void MyFrame(){		
	
	
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
@Override
public void mouseEntered(MouseEvent e) {
	// Invoked when the mouse enters a component
	//System.out.println("You entered the component");
if(e.getSource()== peppCheckBox) {
	peppCheckBox.setForeground(Color.white);
}
if(e.getSource()== mushCheckBox) {
	mushCheckBox.setForeground(Color.white);
}
if(e.getSource()== onionCheckBox) {
	onionCheckBox.setForeground(Color.white);
}
if(e.getSource()== sausCheckBox) {
	sausCheckBox.setForeground(Color.white);
}
if(e.getSource()== pineCheckBox) {
	pineCheckBox.setForeground(Color.white);
}
if(e.getSource()== olivCheckBox) {
olivCheckBox.setForeground(Color.white);
}
if(e.getSource()== jalCheckBox) {
		jalCheckBox.setForeground(Color.white);
} if(e.getSource()== belCheckBox) {
	belCheckBox.setForeground(Color.white);
}
if(e.getSource()== bacCheckBox) {
	bacCheckBox.setForeground(Color.white);
}
if(e.getSource()== hamCheckBox) {
	hamCheckBox.setForeground(Color.white);
}
if(e.getSource()== smallButton) {
	smallButton.setForeground(Color.white);
}
if(e.getSource()== mediumButton) {
	mediumButton.setForeground(Color.white);
}
if(e.getSource()== largeButton) {
	largeButton.setForeground(Color.white);
}
if(e.getSource()== xlargeButton) {
	xlargeButton.setForeground(Color.white);
}
if(e.getSource()== bgCheese) {
	bgCheese.setForeground(Color.white);
}
//For the buttons
if(e.getSource()== add) {
	add.setForeground(Color.white);
	add.setBackground(new Color(255,102,102));
	add.setPreferredSize(new Dimension(70, 70));
} if(e.getSource()== send) {
	send.setForeground(Color.white);
	send.setBackground(new Color(0, 204, 0));
} if(e.getSource()== reset) {
	reset.setForeground(Color.white);
	reset.setBackground(new Color(51, 204, 255));
} if(e.getSource()== cancel) {
	cancel.setForeground(Color.white);
	cancel.setBackground(new Color(153,153, 153));
} if(e.getSource()== exit) {
	exit.setForeground(Color.WHITE);
} if(e.getSource()== home) {
	home.setForeground(Color.GRAY);
} if(e.getSource()== refresh) {
	refresh.setForeground(Color.GRAY);
}
if(e.getSource()== clear) {
	clear.setForeground(Color.white);
	clear.setBackground(new Color(51, 204, 255));
} if(e.getSource()== clear1) {
	clear1.setForeground(Color.white);
	clear1.setBackground(new Color(51, 204, 255));
} if(e.getSource()== all) {
	all.setForeground(Color.white);
	all.setBackground(new Color(255,102,102));
}  if(e.getSource()== button) {
	button.setForeground(Color.DARK_GRAY);
	/*if(button.isSelected()) {
		button.setBackground(new Color(255,102,102));
	}
	else {}*/
	button.setBackground(new Color(0, 204, 0));
	
}

}

private class PriceListener implements ActionListener {
	PizzaMenu pzm = new PizzaMenu();
	 Random rand = new Random();
	 File csvFile = new File("pizzaOrders.txt"); 
	
	

	
public void actionPerformed(ActionEvent event) { 
 
String orderStats = null;
double tax;
String customerName = typeTextField.getText();
tax = showPrice * TAX_RATE;
int inches = 0;
String userInput = null;
String toppings = "Cheese, ";
String crustType = (String)comboBox.getSelectedItem();
int max = 99999;
int min = 0;
int numTopps = 0; // Number of toppings
int OrderNo = rand.nextInt((max - min) + 1) + min;  
button.setUI(new MetalToggleButtonUI() {
        @Override
        protected Color getSelectColor() {
            return Color.RED;
        }
    });

if(button.isSelected()) {
	//switchPanel.setBackground(bg);
   button.setText("Delivery");
    button.setForeground(Color.WHITE);
    button.setFont(new Font("HP Simplified Jpan",Font.BOLD,14));
    bg = Color.RED;
    messageLabel.setFont(new Font(null,Font.ITALIC,25));
	messageLabel.setText("Delivery");
	
	messageLabel.setForeground(Color.green);
	userInput = "Delivery";
	orderStats = "delivered ";
	delivFee = 7.00;
	 /*button1.setSelected(false);
	userInput = "Pickup ";
	orderStats = "ready for pickup ";*/
	delivFee = 7.00;
	//repaint();
}   

else {
	button.setText("Pick-Up");
	button.setForeground(Color.WHITE);
	button.setFont(new Font("HP Simplified Jpan",Font.BOLD,14));
    bg =  new Color(0,153,0);
    messageLabel.setFont(new Font(null,Font.ITALIC,25));
	messageLabel.setText("Pick-Up");
	messageLabel.setForeground(Color.green);/* */
	userInput = "Delivery";
	orderStats = "delivered ";
	delivFee = 0.0;
	
}

 //button.repaint();
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
	
	
topPrice = 0;

int nanoDivisor = 1000000000;


if (smallButton.isSelected()) {
price = 10.99;
inches = 10;
} else if (mediumButton.isSelected()) {
price = 12.99;
inches = 12;
} else if (largeButton.isSelected()) {
price = 14.99;
inches = 14;
} else if (xlargeButton.isSelected()) {
	price = 16.99;
	inches = 16;
}
else if (bgCheese.isSelected()) {
	price = 24.49;
	inches = 24;
}
if (peppCheckBox.isSelected()) {
topPrice += 1.50;
numTopps += 1;
toppings = toppings + "Pepperoni, ";
}  if (mushCheckBox.isSelected()) {
topPrice += 1.25;
numTopps += 1;
toppings = toppings + "Mushrooms, ";

}  if (onionCheckBox.isSelected()) {
topPrice += 1.25;
numTopps += 1;
toppings = toppings + "Onions, ";
}  if (sausCheckBox.isSelected()) {
	topPrice += 1.50;
	numTopps += 1;
	toppings = toppings + "Sausage, ";
} if (pineCheckBox.isSelected()) {
	topPrice += 1.75;
	numTopps += 1;
	toppings = toppings + "Pineapple, ";
} if (olivCheckBox.isSelected()) {
	topPrice += 1.25;
	numTopps += 1;
	toppings = toppings + "Olives, ";
} if (jalCheckBox.isSelected()) {
	topPrice += 2.00;
	numTopps += 1;
	toppings = toppings + "Jalapenos, ";
} if (hamCheckBox.isSelected()) {
	topPrice += 1.50;
	numTopps += 1;
	toppings = toppings + "Ham, ";
} if (belCheckBox.isSelected()) {
	topPrice += 1.25;
	numTopps += 1;
	toppings = toppings + "Bell Peppers, ";
} if (bacCheckBox.isSelected()) {
	topPrice += 1.50;
	numTopps += 1;
	toppings = toppings + "Canadian Bacon, ";
}

if (comboBox.getSelectedItem() == "Stuffed-crust") {
	topPrice += 1.50;
}
if(event.getSource()== exit) {
	
	frame.dispose();
	System.out.println("Goodbye.");
}
toppTextfield.setText(String.format(" %d", numTopps));

if(event.getSource()==all) {
	
	
	peppCheckBox.setSelected(true);
	mushCheckBox.setSelected(true);
	onionCheckBox.setSelected(true);
	sausCheckBox.setSelected(true);
	pineCheckBox.setSelected(true);
	olivCheckBox.setSelected(true);
	jalCheckBox.setSelected(true);
	hamCheckBox.setSelected(true);
	belCheckBox.setSelected(true);
	bacCheckBox.setSelected(true);
}
/*else {
	numTopps = 0;
	
	peppCheckBox.setSelected(false);
	mushCheckBox.setSelected(false);
	onionCheckBox.setSelected(false);
	sausCheckBox.setSelected(false);
	pineCheckBox.setSelected(false);
	olivCheckBox.setSelected(false);
	jalCheckBox.setSelected(false);
	hamCheckBox.setSelected(false);
}*/
if(event.getSource()==cut)    
ta.cut();    
if(event.getSource()==paste)    
ta.paste();    
if(event.getSource()==copy)    
ta.copy();    
if(event.getSource()==selectAll)    
ta.selectAll();    	
if(event.getSource()== clear) {
	
//	topPrice = 0;
//	numTopps = 0;
	
	peppCheckBox.setSelected(false);
	mushCheckBox.setSelected(false);
	onionCheckBox.setSelected(false);
	sausCheckBox.setSelected(false);
	pineCheckBox.setSelected(false);
	olivCheckBox.setSelected(false);
	jalCheckBox.setSelected(false);
	hamCheckBox.setSelected(false);
	belCheckBox.setSelected(false);
	bacCheckBox.setSelected(false);
}
if(event.getSource()== clear1) {
	
	invisButton.doClick();
	price = 0.0;
}
if(event.getSource()== reset) {
		typeTextField.setText("");
		topPrice = 0;
		price = 0;
		numTopps = 0;
		peppCheckBox.setSelected(false);
		mushCheckBox.setSelected(false);
		onionCheckBox.setSelected(false);
		sausCheckBox.setSelected(false);
		pineCheckBox.setSelected(false);
		olivCheckBox.setSelected(false);
		jalCheckBox.setSelected(false);
		hamCheckBox.setSelected(false);
		belCheckBox.setSelected(false);
		bacCheckBox.setSelected(false);
		invisButton.doClick();
		comboBox.setSelectedItem("Choose");
		numPizzas = 1;
		/*if (numPizzas > 1) {
			
			price += showPrice;
		}*/
	}

if(event.getSource()== home) {
	
	frame.dispose();
	homePage hmp = new homePage(); 
}
if(event.getSource()== refresh) {
	
	frame.dispose();
	PizzaPriceFrame pPF = new PizzaPriceFrame(); 
}
if(event.getSource()== cancel) {
	/*typeTextField.setText("");
	topPrice = 0;
	price = 0;
	numTopps = 0;
	peppCheckBox.setSelected(false);
	mushCheckBox.setSelected(false);
	onionCheckBox.setSelected(false);
	sausCheckBox.setSelected(false);
	pineCheckBox.setSelected(false);
	olivCheckBox.setSelected(false);
	jalCheckBox.setSelected(false);
	hamCheckBox.setSelected(false);
	invisButton.doClick();
	comboBox.setSelectedItem("Choose");
	numPizzas = 1;*/
	if (numPizzas > 1) {
		
		numPizzas --;
		pzm.delete(OrderNo, customerName, inches, crustType,   tax,TAX_RATE,  userInput,  showPrice, toppings
			,numTopps, numPizzas);
	}
	
}
if(event.getSource()== send) {
		
		
		if (typeTextField.getText().isEmpty() && comboBox.getSelectedItem().toString().equals("Choose") && 
				!smallButton.isSelected() && !mediumButton.isSelected() && !largeButton.isSelected() && 
				!xlargeButton.isSelected() && !bgCheese.isSelected()) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Enter name, select crust type and size!</html>");
			errMSG.setForeground(Color.red);
		}
		else if(typeTextField.getText().isEmpty() && comboBox.getSelectedItem().toString().equals("Choose")) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Enter name and select crust type!</html>");
			errMSG.setForeground(Color.red);
		}
		else if(typeTextField.getText().isEmpty() && !smallButton.isSelected() && !mediumButton.isSelected() 
				&& !largeButton.isSelected() && !xlargeButton.isSelected() && !bgCheese.isSelected()) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Enter name and select pizza size!</html>");
			errMSG.setForeground(Color.red);
		}
		
		else if (comboBox.getSelectedItem().toString().equals("Choose") && !smallButton.isSelected() && 
				!mediumButton.isSelected() && !largeButton.isSelected() && !xlargeButton.isSelected()
				&& !bgCheese.isSelected()) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Select crust type and size!</html>");
			errMSG.setForeground(Color.red);
		}
		else if (typeTextField.getText().isEmpty()) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Enter name!</html>");
			errMSG.setHorizontalAlignment(JLabel.CENTER);
			errMSG.setForeground(Color.red);
		}
		else if(comboBox.getSelectedItem().toString().equals("Choose")) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Select crust type!</html>");
			errMSG.setHorizontalAlignment(JLabel.CENTER);
			errMSG.setForeground(Color.red);
		}
		else if(!smallButton.isSelected() && !mediumButton.isSelected() && !largeButton.isSelected() 
				&& !xlargeButton.isSelected() && !bgCheese.isSelected()) {
			
			errMSG.setFont(new Font(null,Font.ITALIC,18));
			errMSG.setText("<html>Select pizza size!</html>");
			errMSG.setHorizontalAlignment(JLabel.CENTER);
			errMSG.setForeground(Color.red);
		}
		else {
			
			messageLabel.setFont(new Font(null,Font.ITALIC,25));
			messageLabel.setText("Thank you " + customerName + "!");
			messageLabel.setForeground(Color.green);
			frame.dispose();
			
	//		numPizzas += 1;
			OrderConfirmation orderPage = new OrderConfirmation(OrderNo, customerName, showPrice, inches, 
					toppings, crustType, tax, numTopps, numPizzas, userInput, orderStats, TAX_RATE);
			
			pzm.append(OrderNo, customerName, inches, crustType,   tax, TAX_RATE,  userInput,  showPrice,
					toppings, numTopps, numPizzas);
			 pzm.printOrderList();
			/*long start = System.nanoTime();
	 			
	 			long end = System.nanoTime();	
	 			long duration = end - start;
	 			double seconds = (double)duration/nanoDivisor;
	 			System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);*/
	 			//price + delivFee;
		}
		try {   
		 
		 PrintWriter out = new PrintWriter(csvFile);
       /*  FileWriter myWriter = new FileWriter("pizzaOrders.csv");
         FileWriter yoWriter = new FileWriter("pizzaOrders.txt");
         myWriter.write(pizza);
         myWriter.close();
         yoWriter.write(pizza);
         yoWriter.close();*/
		 out.println("PIZZA ORDER MANAGER");
		 int n = 75;
		for (int i = 1; i <= n; i++) {
				out.print("=");
			}
		 out.println();
		 out.println("Order No.\tCustomer\tQty.\tStatus\t\tTax\t\tAmount Due");
		 for (int i = 1; i <= n; i++) {
				out.print("=");
			}
		 out.println();
         out.print(OrderNo);
         out.print("\t\t" + customerName);
         out.print("\t\t" + numPizzas);
         out.print("\t\t" + userInput);
         out.printf("\t$%.2f",  tax);
         out.printf("\t$%.2f", showPrice);
        
        out.close();
        // System.out.println("Successfully wrote to the file.");
       } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       } 
		
}
if(event.getSource()== add) {
	
	
	/*if (comboBox.getSelectedItem().toString().equals("Choose") && !smallButton.isSelected() && 
			!mediumButton.isSelected() && !largeButton.isSelected() && !xlargeButton.isSelected()) {
		
		messageLabel.setFont(new Font(null,Font.ITALIC,18));
		messageLabel.setText("Select crust type and size!");
		messageLabel.setForeground(Color.red);
	}

	else if(comboBox.getSelectedItem().toString().equals("Choose")) {
		
		messageLabel.setFont(new Font(null,Font.ITALIC,18));
		messageLabel.setText("Select crust type!");
		messageLabel.setForeground(Color.red);
	}
	else if(!smallButton.isSelected() && !mediumButton.isSelected() && !largeButton.isSelected() 
			&& !xlargeButton.isSelected()) {
		
		messageLabel.setFont(new Font(null,Font.ITALIC,18));
		messageLabel.setText("Select pizza size!");
		messageLabel.setForeground(Color.red);
	}
	else {
		
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		messageLabel.setText("Next Pizza!");
		messageLabel.setForeground(Color.green);
		
		peppCheckBox.setSelected(false);
		mushCheckBox.setSelected(false);
		onionCheckBox.setSelected(false);
		sausCheckBox.setSelected(false);
		invisButton.doClick();
		comboBox.setSelectedItem("Choose");
		String userInput = null;
		
		price = showPrice;
		
		
	}*/
	pzm.prepend(OrderNo, customerName, inches, crustType,   tax,TAX_RATE,  userInput,  showPrice, toppings
				,numTopps, numPizzas);
	numPizzas += 1;
}

EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
 

showPrice = (price * numPizzas) + topPrice + delivFee;
taxTextField.setText(String.format(" $%.2f", tax));
priceTextField.setText(String.format(" $%.2f", showPrice));
qtyTextField.setText(String.format(" %d", numPizzas));

}
});
}


}

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	PizzaMenu pzm = new PizzaMenu();
@Override
public void run() {
PizzaPriceFrame pPF = new PizzaPriceFrame();
System.out.println("Run");
pzm.printOrderManager();

}
});
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	//button.setBackground(Color.RED);
}
@Override
public void mouseExited(MouseEvent e) {
	//For toppings menu
	peppCheckBox.setForeground(Color.BLACK);
	mushCheckBox.setForeground(Color.BLACK);
	onionCheckBox.setForeground(Color.BLACK);
	sausCheckBox.setForeground(Color.BLACK);
	pineCheckBox.setForeground(Color.BLACK);
	olivCheckBox.setForeground(Color.BLACK);
	jalCheckBox.setForeground(Color.BLACK);
	belCheckBox.setForeground(Color.BLACK);
	bacCheckBox.setForeground(Color.BLACK);
	hamCheckBox.setForeground(Color.BLACK);
	//For pizza size
	bgCheese.setForeground(Color.BLACK);
	smallButton.setForeground(Color.BLACK);
	mediumButton.setForeground(Color.BLACK);
	largeButton.setForeground(Color.BLACK);
	xlargeButton.setForeground(Color.BLACK);
	//For the order buttons
	add.setForeground(Color.BLACK);
	add.setBackground(new Color(255,51,51));
	add.setPreferredSize(new Dimension(65, 65));
	send.setForeground(Color.BLACK);
	send.setBackground(new Color(0,153,0));
	reset.setForeground(Color.BLACK);
	reset.setBackground(new Color(51,153,225));
	cancel.setForeground(Color.BLACK);
	cancel.setBackground(Color.LIGHT_GRAY);
	//For the navigation buttons
	exit.setForeground(Color.BLACK);
	home.setForeground(Color.BLACK);
	refresh.setForeground(Color.BLACK);
	//For the panel buttons
	clear.setForeground(Color.BLACK);
	clear.setBackground(new Color(51,153,225));
	clear1.setForeground(Color.BLACK);
	clear1.setBackground(new Color(51,153,225));
	all.setForeground(Color.BLACK);
	all.setBackground(new Color(255,51,51));
	//For toggle button
	button.setBackground(bg);
	button.setForeground(Color.WHITE);
	//Combobox
	comboBox.setBackground(Color.ORANGE);
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void stateChanged(ChangeEvent evt) {
	// TODO Auto-generated method stub
	//JSpinner
}
}
