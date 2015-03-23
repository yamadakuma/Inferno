package inferno;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Character {
	
	private BufferedImage sprite=null;
	
	private boolean moving;
	
	public Player(){
		try {
			sprite=ImageIO.read(new File("imgs/sprites/player_forward_center.png"));
		} catch (IOException e) {
			System.out.println("Player sprite not found.");
		}	//end try/catch
	}
	
	public void draw(Graphics g) {
		int y=32*getPosY();
		int x=32*getPosX();
		g.drawImage(sprite, x, y, null);
	}	//end draw
	
	public void move(String dir) {
		setMoving(true);
		if (dir.equals("left")) {
			setPosX(getPosX()-1);
		}	//end if
		else if (dir.equals("right")) {
			setPosX(getPosX()+1);
		}
		else if (dir.equals("down")) {
			setPosY(getPosY()+1);
		}
		else if (dir.equals("up")) {
			setPosY(getPosY()-1);
		}
	}	//end move

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
