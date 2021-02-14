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
	JPanel pane= new JPanel();
	JTextArea talkArea= new JTextArea(30, 70);
	JTextArea input= new JTextArea(2,70);
	JScrollPane sideBar= new JScrollPane(talkArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	ImageIcon icon= new ImageIcon("img/bot.png");
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

	public Window() {
		super("Celeb Bot");
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(icon.getImage());
		
		pane.add(sideBar);
		pane.add(input);
		pane.setBackground(new Color(0,150,200));
		add(pane);
		
		
		talkArea.setEditable(false);
		input.addKeyListener(this);
		
		
		setVisible(true);
		addText("\t\t\tPlease type Q to end the conversation\n\n\n");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			input.setEditable(false);
			String msg=input.getText();
			input.setText("");
			addText("\n-->You:\t "+msg+"\n");
			msg=msg.trim();
			msg=msg.toLowerCase();
			response(msg);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER);
			input.setEditable(true);
		
	}
	
	public void addText(String s) {
		talkArea.setText(talkArea.getText()+s);
	}
	public void delay(int seconds) {
		try {
		    Thread.sleep(seconds * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
	public void response(String s) {
		int r,c;
		List<String> sent= Arrays.asList(s.split(" "));
		addText("\n-->Bot:\t");
		if(sent.contains("hello")) {
			r=0;
			c=0;
			
		}
		else if(sent.contains("q")) {
			r=3;
			c=(int)Math.round(Math.random()*3);
			input.disable();
		}
		else {
			r=2;
			c=0;
		}
		addText(Responses[r][c]+"\n");	
		if(sent.contains("q"))
			addText("-------------------------------------------------------------------------------------Chat Has Ended------------------------------------------------------------------------------------");
	}	

	
}
