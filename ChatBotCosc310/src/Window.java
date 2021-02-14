import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends JFrame implements KeyListener{
	//Here we make a window that will contain our text area box and the input box at the bottom as well as a scroll bar the shows up when needed
	JPanel pane= new JPanel();
	JTextArea talkArea= new JTextArea(30, 70);
	JTextArea input= new JTextArea(2,70);
	JScrollPane sideBar= new JScrollPane(talkArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//This is to load the image of the bot into an icon form
	ImageIcon icon= new ImageIcon("img/bot.png");
	//This 2D array will contain the bots responses
	String[][] Responses= {
			//greeting
			{"Hello there, my name is chef, What would you like to ask me today"},
			//answer
			{},
			//Default
			{"Sorry I did not understand that. I may not have enough updates to understand what you were asking"},
			//Goodbye
			{"It was a pleasure to talk to you","Have a great day","See you later","Goodbye"}
	};
	//Constructor to creat the window
	public Window() {
		//set the title
		super("Celeb Bot");
		//set the size of the window and set it so it can't be resized
		setSize(800,600);
		setResizable(false);
		//set it so it closes when you press the X in the corner
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//set the icon of the program to our image
		setIconImage(icon.getImage());
		
		//to our window we need to add out scrollbar and our input text box
		pane.add(sideBar);
		pane.add(input);
		//set the background image of the window
		pane.setBackground(new Color(0,150,200));
		//add the pane
		add(pane);
		
		//Set the talk area box that it cannot be editable
		talkArea.setEditable(false);
		//adding a keylistener that can listen for events
		input.addKeyListener(this);
		
		//set the window to become visible
		setVisible(true);
		//Calling the addText method to add text to the text ares
		addText("\t\t\tPlease type Q to end the conversation\n\n\n");
		
	}

	//Don't use this method atm
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//a method that is called when button is pressed
	public void keyPressed(KeyEvent e) {
		
		//if the key pressed is enter
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			//set the input field so it is not editable
			input.setEditable(false);
			//put the the sentence in the input text field into a String
			String msg=input.getText();
			//set the input field to empty
			input.setText("");
			//Call the method that adds the text to the text are
			addText("\n-->You:\t "+msg+"\n");
			//trim the end of whitespaces
			msg=msg.trim();
			//convert the msg to lower case so case doesn't matter
			msg=msg.toLowerCase();
			//call the response method sending the msg String
			response(msg);
		}
	}

	//When a key is released
	public void keyReleased(KeyEvent e) {
		//if the key was enter set the input field back so it is editable
		if(e.getKeyCode()==KeyEvent.VK_ENTER);
			input.setEditable(true);
		
	}
	//add text method to text area
	public void addText(String s) {
		talkArea.setText(talkArea.getText()+s);
	}
	
	
	//A delay method I wanted to implement so the bot seems human and is taking time to reply
	public void delay(int seconds) {
		try {
		    Thread.sleep(seconds * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
	
	//The method that will get the bots response
	public void response(String s) {
		int r,c;
		//make a list of every work in the message
		List<String> sent= Arrays.asList(s.split(" "));
		addText("\n-->Bot:\t");
		//if it is hello print a greeting
		if(sent.contains("hello")) {
			r=0;
			c=0;
			
		}
		//if its q end the chat and disable the input field
		else if(sent.contains("q")) {
			r=3;
			c=(int)Math.round(Math.random()*3);
			input.disable();
		}
		//default case
		else {
			r=2;
			c=0;
		}
		//add the response to the text Area
		addText(Responses[r][c]+"\n");	
		//again checking if it was q and making a visible message saying the chat has ended across window
		if(sent.contains("q"))
			addText("-------------------------------------------------------------------------------------Chat Has Ended------------------------------------------------------------------------------------");
	}	

	
}
