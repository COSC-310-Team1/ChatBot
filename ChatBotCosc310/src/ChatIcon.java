import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ChatIcon {


public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public boolean isMoving() {
	return isMoving;
}

public Image getImage() {
return pic;
}

//Function for moving icon. Must choose the y coordinate where the icon stops moving and how much it moves each call in y direction.
public void move(int incrementY, int stopY) {
	
	//Stop moving if reached final Y.
	if (this.getY() == stopY) {
		isMoving = false;
	//If moving keep moving
	} else if (isMoving) {
		this.setY(this.getY() + incrementY);
	}
	//If not moving and move is called then start moving.
	else {
		isMoving = true;
	}
	
}

//Fairly self explanatory x,y position, size(height and width I kept the same), and a boolean to tell if the icon is moving.
//I used imageIcon because they're easier to use than images. I can change this if need be.
private boolean isMoving;
private int size;
private int x;
private int y;
public Image pic;

//constructor
ChatIcon(int x, int y, int size, String imgfile)
{
pic = Toolkit.getDefaultToolkit().getImage("img/musk.png");
this.x = x;
this.y = y;
this.size = size;
this.isMoving = false;
}



}
