import java.awt.Color;
import java.awt.Graphics;
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
	JTextArea talkArea= new JTextArea(27, 69);
	JTextArea input= new JTextArea(2,69);
	JScrollPane sideBar= new JScrollPane(talkArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//This is to load the image of the bot into an icon form
	ImageIcon icon = new ImageIcon("img/bot.png");
	//Object for the elonPicture I created. Needed more variables and didn't want to clutter. --Ben
	ChatIcon elonPic;

	
	//This 2D array will contain the bots responses
	String[][] Responses= {
			//greeting
			{"Hello there, my name is Elon, What would you like to ask me today?"},
			//answer
			{},
			//Default
			{"Sorry I did not understand that. I may not have enough updates to understand what you were asking"},
			//Goodbye
			{"It was a pleasure to talk to you","Have a great day","See you later","Goodbye"},
			//Elon's age
			{"Thank you for asking. I'm 49 now and will be 50 this year."},
			//Elon's general interests
			{"I'm a big fan of dogecoin!", "Spaceships are cool.", "I love cars!"},
			//Elon's favourite specific favourite things
			{"Parasite.", "Black Mirror."},
			//Birth place
			{"I was born in Pretoria, South Africa, June 28 1971."}
	};
	
	//Constructor to create the window
	public Window() {
		//set the title
		super("Elon Bot");
		//set the size of the window and set it so it can't be resized
		setSize(800,600);
		setResizable(false);
		//set it so it closes when you press the X in the corner
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//set the icon of the program to our image
		setIconImage(icon.getImage());
		//For our window we need to add our scrollbar and our input text box
		pane.add(sideBar);
		pane.add(input);
		//Jlabel adds robot below chat window. Image can be changed for aesthetics.
		JLabel pic = new JLabel(new ImageIcon(icon.getImage()));
		pane.add(pic);
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
		addText("\t\t\tPlease type Q to end the conversation\n" );
		
		//Choose initial coordinates.
		elonPic = new ChatIcon(36,87,40, "img/musk.png");
		
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
			
			msg = msg.replace('?', (char)32);
			msg = msg.replace('.', (char)32);
			
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
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
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
		addText("\n-->Elon:\t");
		//if it is hello print a greeting
		if(sent.contains("hello")||sent.contains("hi")||sent.contains("hey")) {
			r=0;
			c=0;
			
		}
		// Asking how elon's age 
		else if(sent.contains("old")||sent.contains("age")&&(sent.contains("you")&&sent.contains("your"))) {
			r = 4;
			c = 0;
			
		}
		// Asking about elon's favourite things or hobbies. Two favorites to account for diff spelling
		else if((sent.contains("favorite")||(sent.contains("favourite"))&&sent.contains("things"))||sent.contains("hobbies")||sent.contains("thing")) {
			r = 5;
			c=(int)Math.round(Math.random()*2);
		
		}
	
		//Asking about specific favourite thing. Nested if's might not be the best, consider revision?
		else if(sent.contains("favourite")||sent.contains("favorite")){
			    r = 6;
			if(sent.contains("movie"))
				c = 0;
			 else if (sent.contains("series")||sent.contains("show"))
				c = 1;
			 else {
				r = 2;
				c = 0;
			}
		    }
			// Asking elon where or when he was born 
		else if((sent.contains("when")||sent.contains("where"))&&sent.contains("born")) {
			r = 7;
			c = 0;
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
		
	    //Moves the elon chat pic and paints it each time we chat with him
		elonPic.move(65,412);
		repaint();
		
		//again checking if it was q and making a visible message saying the chat has ended across window
		if(sent.contains("q"))
			addText("-------------------------------------------------------------------------------------Chat Has Ended------------------------------------------------------------------------------------");
	}	 
	

	 public void paint (Graphics g)
	    {  
		   
	       super.paint (g);
	       
	       //Draw based on coordinates when elon is moving, otherwise paint him in the corner.
	       if(elonPic.isMoving())
	       g.drawImage(elonPic.getImage(), elonPic.getX(), elonPic.getY(), elonPic.getSize(), elonPic.getSize(),this);
	       else
	       g.drawImage(elonPic.getImage(), 670, 379, 90, 90, this);
	       
	        
	    }

         

	
}
