import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
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
	JTextArea talkArea= new JTextArea(25, 73);
	JTextArea input= new JTextArea(2,65);
	JScrollPane sideBar= new JScrollPane(talkArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//This is to load the image of the bot into an icon form
	ImageIcon icon = new ImageIcon("img/bot.png");


	
	//This 2D array will contain the bots responses
	String[][] Responses= {
			//greeting
			{"Hello there, my name is Elon, What would you like to ask me today?", "I'm very good, thank you."},
			//Thank you
			{"You're welcome"},
			//Default
			{"Sorry I did not understand that. I may not have enough updates to understand what you were asking"},
			//Goodbye
			{"It was a pleasure to talk to you","Have a great day","See you later","Goodbye", "We must colonize Mars!"},
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
			{ "I'm a big fan of dogecoin, and all forms of cryptocurrency!", "Spaceships are cool I guess.",
					"I love cars! I remember when I bought my first McLaren F1.", "I love anime!" },
			// Interests facts
			{ "Probably Parasite, it was definitely the best movie of 2019.",
					"Black Mirror, I really like the concepts it explores.",
					"I really enjoyed Your Name, but i'm also a fan of Studio Ghibli. Princess Mononoke is one of my favourite\n\tfilms by them.",
					"My favourite airplane is the SR-71 Blackbird. The A-XII in X AE A-XII is the predecessor to this plane." },
			//Life Facts
			{"I was born in Pretoria, South Africa.", "June 28 1971.","Thank you for asking. I'm 49 now and will be 50 this year.", 
				"My parents were Maye who was my mother and Errol who was my father. I am not very fond of my father."," I have two siblings. Tosca who is my sister and Kimbal who is my brother",
				"I started university in Pretoria, which I later moved to Canada and went to Queens university. \n\tThen after two years I transferred to the University of Pennsylvania. \n\tAfter That I started my phd at stanford where I dropped out after two days.",
				"I have had two wives but those ended in divorce. I am currently am dating the musician grimes",
				"My first wife's name was Justine Wilson and we were married from 2000-2008. We had 5 children. \n\tOne of our kids Nevada unfortunately passed away due to sudden infant death syndrome",
				"My second wife's name was Talula Riley and we were married from 2010-2016",
				"I am currently dating the musician Grimes. We have one child together named X AE A-XII.\n\tWe had a fun time naming this one.",
				"When I was 12 I sold my first game Blastar for $500.",
				"I taught myself to code when I was around 10 years old",
				"I mainly spend my time between SpaceX and Tesla, and i'm heavily involved with the engineering decisions\n\tat those companies. Though I also spend a lot of my time at OpenAI too.",
				"I own a lot of cars, but mainly drive my Model S. Though I only drive Teslas now, i've owned a \n\t1978 BMW 320i and a 1967 Jaguar (E-type)."
				},
			//Appearances/Interviews
			{ "I had a cameo in The Simpsons, The Big Bang theory, South Park, and Rick and Morty. Maybe you've seen\n\tone of my episodes?",
			  "Yes, I was on Joe Rogan's podcast. In 2018 I think. We talked about all sorts of things, but I got\n\tin trouble for that one thing I did..." }

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
		
		//Add a GIF as a jLabel based on URL.
		try {
		//GIF: Harrington, D. (2020). Pixel-Robot[GIF]. Retrieved from https://opengameart.org/content/pixel-robot.
		URL url = new URL("https://opengameart.org/sites/default/files/robot-idle.gif");
		JLabel gif = new JLabel(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(78, 78, Image.SCALE_DEFAULT)));
		pane.add(gif);
		}
		catch(MalformedURLException e) {
			System.out.println(e);
		}
		
		//set the background image of the window
		pane.setBackground(new Color(0,150,200));
		//add the pane
		add(pane);
		//Set the talk area box that it cannot be editable
		talkArea.setEditable(false);
		//adding a keylistener that can listen for events
		input.addKeyListener(this);
		//Set the font
		input.setFont(new javax.swing.plaf.FontUIResource("Comic Sans MS",Font.BOLD,12));
		talkArea.setFont(new javax.swing.plaf.FontUIResource("Comic Sans MS",Font.BOLD,12));
		//set the window to become visible
		setVisible(true);
		//Calling the addText method to add text to the text ares
		addText("\t\t\tPlease type Q to end the conversation\n" );
		
		

		
	
		
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
			addText("\n-->You:\t"+msg+"\n");
			
			//Check to see if the input is a question.
			Boolean question;
			if(msg.indexOf('?') != -1) 
				question = true;
			else
				question = false;
			
			// Replace all punctuation so it doesn't interfere with responses
			msg = msg.replace('?', (char)32);
			msg = msg.replace('.', (char)32);
			msg = msg.replace(',', (char)32);
			
			//trim the end of whitespaces
			msg=msg.trim();
			//convert the msg to lower case so case doesn't matter
			msg=msg.toLowerCase();
			
			//call the response method sending the msg String 
			response(msg, question);
			
			
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
	public void response(String s, Boolean question) {
		int r,c;
		//make a list of every work in the message
		List<String> sent= Arrays.asList(s.split(" "));
		addText("\n-->Elon:\t");
		//if it is hello print a greeting
		if(sent.contains("hello")||sent.contains("hi")||sent.contains("hey")) {
			r=0;
			c=0;
			
		}
		//response to how are you?
		else if(sent.contains("how")&&sent.contains("are")&&sent.contains("you")) {
			r=0;
			c=1;
			
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
			c = 7;
		}
		else if(sent.contains("second")&&sent.contains("wife")) {
			r = 7;
			c = 8;
		}
		else if(sent.contains("wife")||sent.contains("married")) {
			r = 7;
			c = 6;
		}
		else if(sent.contains("currently")||sent.contains("dating")||sent.contains("grimes")) {
			r = 7;
			c = 9;
		}
		else if(sent.contains("first")&&(sent.contains("software")||sent.contains("game"))) {
			r =7;
			c = 10;
		}
		else if(sent.contains("how")&&sent.contains("learn")&&(sent.contains("code")||sent.contains("program"))) {
			r = 7;
			c = 11;
		}
		else if (sent.contains("spend")&&(sent.contains("time")||sent.contains("freetime"))){
			r = 7;
			c = 12;
			
		}
		else if(sent.contains("car")&&(sent.contains("drive")||sent.contains("own"))) {
			r = 7;
			c = 13;
			
		}
//--------------------------------------------------Appearances/interviews---------------------------------------------------------//	
		//Shows he has appeared in.
		else if(sent.contains("what")&&(sent.contains("shows")||sent.contains("show"))&&sent.contains("appeared")) {
			r = 8;
			c = 0;
		}
		//Joe rogan podcast
		else if(sent.contains("joe")&&sent.contains("rogan")) {
		   r= 8;
		   c= 1;
		   
		}
//--------------------------------------------------Interests---------------------------------------------------------//		
		//Asking about specific favorite things
		else if((sent.contains("favourite")||sent.contains("favorite"))&&sent.contains("movie")) {
			r = 6;
			c = 0;
			}
		//Favorite show
		else if((sent.contains("favourite")||sent.contains("favorite"))&&(sent.contains("series")||sent.contains("show"))) {
			r = 6;	
			c = 1;
		    }
		else if((sent.contains("favourite")||sent.contains("favorite"))&&(sent.contains("anime"))) {
			r = 6;	
			c = 2;
		    }
		else if((sent.contains("favourite")||sent.contains("favorite"))&&(sent.contains("aircraft")||sent.contains("airplane"))) {
			r = 6;
			c = 3;
		}
		// Random favorite thing
		else if((sent.contains("favorite")||sent.contains("favourite"))&&(sent.contains("things")||sent.contains("hobbies")||sent.contains("thing"))) {
			r = 5;
			c=(int)Math.round(Math.random()*3);
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
			c=(int)Math.round(Math.random()*4);
			input.disable();
		}
		//default case
		else {
			r=2;
			c=0;
		}
		
	    // If the msg received was a question and the response is not default. There is a 1/5 chance bot responds this.
		if(question&&r!=2&&((int)Math.round(Math.random()*4))==4) {
			addText("That's a great question!\n");
			addText("\n-->Elon:\t");
		}
		
		//add the response to the text Area
		addText(Responses[r][c]+"\n");	
		
		//again checking if it was q and making a visible message saying the chat has ended across window
		if(sent.contains("q"))
			addText("--------------------------------------------Chat Has Ended--------------------------------------------");
		
		
		//Changed length from the og below. Fixed bug where the window moves out of frame on the x axis when q is pressed. 
		//addText("-------------------------------------------------------------------------------------Chat Has Ended------------------------------------------------------------------------------------");
	}	 
	

	
}
