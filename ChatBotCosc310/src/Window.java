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
			//Thank you
			{"You're welcome"},
			//Default
			{"Sorry I did not understand that. I may not have enough updates to understand what you were asking"},
			//Goodbye
			{"It was a pleasure to talk to you","Have a great day","See you later","Goodbye"},
			//Career Facts
			{"My first company was Zip2,which eventually sold to Compaq for $307 million.",
				"I am the founder of Sace Exploration technologies, better known as SpaceX",
				"In 2008 I took over as CEO of Tesla.",
				"I was the cofounder of X.com, which later merged with confinity to form paypal and was then sold to ebay for $1.5 Billion!",
				"In 2015 I co-founded OpenAI, a non profit reasearch company.",
				"In 2016 I founded Nueralink, a company that focuses on bran-computer interactions.",
				"In 2006 I helped create SolarCity.",
				"The main companies I have been involved in are: Zip2,SpaceX,Tesla,OpenAI,Nueralink and SolarCity"},
			//general random interests
			{"I'm a big fan of dogecoin!", "Spaceships are cool.", "I love cars!"},
			//Interests facts
			{"Parasite.", "Black Mirror."},
			//Life Facts
			{"I was born in Pretoria, South Africa.", "June 28 1971.","Thank you for asking. I'm 49 now and will be 50 this year.", 
				"My parents were Maye who was my mother and Errol who was my father. I am not very fond of my father."," I have two siblings. Tosca who is my sister and Kimbal who is my brother",
				"I started university in Pretoria, which I later moved to Canada and went to Queens university. \n\tThen after two years I transferred to the University of Pennsylvania. \n\tAfter That I started my phd at stanford where I dropped out after two days.",
				"I have had two wives but those ended in divorce. I am currently am dating the musician grimes",
				"My first wife's name was Justine Wilson and we were married from 2000-2008. We had 5 children. \n\tOne of our kids Nevada unfortunately passed away due to sudden infant death syndrome",
				"My second wife's name was Talula Riley and we were married from 2010-2016",
				"I am currently dating the musician Grimes. We have one child together named X AE A-XII. We had a fun time naming this one"}
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
//--------------------------------------------------Life Facts---------------------------------------------------------//	
			// Asking where born
		else if(sent.contains("where")&&sent.contains("born")) {
			r = 7;
			c = 0;
			}//Asking when born
		else if(sent.contains("when")&&sent.contains("born")) {
			r = 7;
			c = 1;
		}//Asking age
		else if((sent.contains("old")||sent.contains("age"))&&(sent.contains("you")&&sent.contains("your"))) {
			r = 7;
			c = 2;
		}
		else if(sent.contains("who")&&sent.contains("parents")) {
			r = 7;
			c = 3;
		}
		else if(sent.contains("siblings")||sent.contains("brother")||sent.contains("sister")) {
			r = 7;
			c = 4;
		}
		else if(sent.contains("education")) {
			r = 7;
			c = 5;
		}
		else if(sent.contains("first")&&sent.contains("wife")) {
			r = 7;
			c = 6;
		}
		else if(sent.contains("second")&&sent.contains("wife")) {
			r = 7;
			c = 6;
		}
		else if(sent.contains("wife")||sent.contains("married")) {
			r = 7;
			c = 5;
		}
		else if(sent.contains("currently")||sent.contains("dating")||sent.contains("grimes")) {
			r = 7;
			c = 6;
		}
//--------------------------------------------------Interests---------------------------------------------------------//		
		//Asking about specific favorite things
		else if((sent.contains("favourite")||sent.contains("favorite"))&&sent.contains("movie")) {
			r = 6;
			c = 0;
			}
		else if((sent.contains("favourite")||sent.contains("favorite"))&&(sent.contains("series")||sent.contains("show"))) {
			r = 6;	
			c = 1;
		    }
		// Random favorite thing
		else if((sent.contains("favorite")||sent.contains("favourite"))&&(sent.contains("things")||sent.contains("hobbies")||sent.contains("thing"))) {
			r = 5;
			c=(int)Math.round(Math.random()*2);
		}
		
//----------------------------------------------------Career----------------------------------------------------------//
		
		else if((sent.contains("zip2")||sent.contains("first"))&&(sent.contains("company")||sent.contains("business"))) {
			r = 4;
			c = 0;
		}
		//SpaceX
		else if(sent.contains("spacex")) {
			r = 4;
			c = 1;
		}
		//tesla
		else if(sent.contains("tesla")) {
			r = 4;
			c = 2;
		}
		//paypal
		else if(sent.contains("x.com")||sent.contains("confinity")||sent.contains("ebay")||sent.contains("paypal")) {
			r = 4;
			c = 3;
		}
		//OpenAI
		else if(sent.contains("openai")) {
			r = 4;
			c = 4;
		}
		//Nueralink
		else if(sent.contains("nueralink")) {
			r = 4;
			c = 5;
		}
		//solar city
		else if(sent.contains("solarcity")) {
			r = 4;
			c = 6;
		}
		//if its q end the chat and disable the input field

		// list of all major companies
		else if((sent.contains("companies")||sent.contains("businesses"))&&sent.contains("what")) {
			r = 4;
			c = 7;
		}
		
//------------------------------------------------------Random-----------------------------------------------//
		else if(sent.contains("thanks")||(sent.contains("thank")&&sent.contains("you"))) {
			r = 1;
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
