package inferno.display;

import inferno.Player;
import inferno.World;
import inferno.enemies.Enemy;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameScreen extends Canvas implements Runnable, KeyListener {

	private BufferedImage[] tiles=new BufferedImage[9];
	private BufferedImage enemySprite=null;
	private BufferedImage itemSprite=null;
	private World dungeon=new World();
	private Player pc=new Player();
	private long lastDrawTime;
	private int[] keysDown=new int[0];	
	private Thread drawMe;
	private boolean keyReleased=false, shouldMove=false;
	private Enemy[] mons;
	
	private boolean prevL, prevR, prevD, prevU;

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setSize(512,406);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		GameScreen game=new GameScreen();
		jf.add(game);
		jf.addKeyListener(game);
		jf.setVisible(true);
	}	//end main

	public GameScreen() {
		super();
		try {
			tiles[0]=ImageIO.read(new File("imgs/tiles/browntile_BL.png"));
			tiles[1]=ImageIO.read(new File("imgs/tiles/browntile_B.png"));
			tiles[2]=ImageIO.read(new File("imgs/tiles/browntile_BR.png"));
			tiles[3]=ImageIO.read(new File("imgs/tiles/browntile_L.png"));
			tiles[4]=ImageIO.read(new File("imgs/tiles/browntile_C.png"));
			tiles[5]=ImageIO.read(new File("imgs/tiles/browntile_R.png"));
			tiles[6]=ImageIO.read(new File("imgs/tiles/browntile_TL.png"));
			tiles[7]=ImageIO.read(new File("imgs/tiles/browntile_T.png"));
			tiles[8]=ImageIO.read(new File("imgs/tiles/browntile_TR.png"));
			enemySprite=ImageIO.read(new File("imgs/sprites/enemysprite.png"));
			itemSprite=ImageIO.read(new File("imgs/sprites/potionsprite.png"));
		} catch(IOException e) {
			System.out.println("Image(s) not found.");
		}	//end try/catch
		dungeon=new World();
		pc=new Player();
		mons=new Enemy[0];
		dungeon.setPlayer(pc);
		dungeon.setMonsters(mons);
		drawMe=new Thread(this); //create a thread for an object
		drawMe.start(); 
	}	//end constructor

	public void run(){
		while(Thread.currentThread()==drawMe){
			repaint(); //redraw screen
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		Image i=createImage(getWidth(), getHeight());
		updateFrame((Graphics2D)(i.getGraphics()));
		g.drawImage(i,0,0,this);
		lastDrawTime=System.currentTimeMillis();

	}	//end paint

	public void updateFrame(Graphics g) {
		boolean CurrentL=false, CurrentR = false, CurrentD=false, CurrentU=false;
		
		drawTiles(g);
		pc.draw(g);
		boolean takeStep=false;
		if (!shouldMove) {
			takeStep=true;
		}	//end if
		String dir="";
		for(int i=0;i<keysDown.length;i++){
			if(keysDown[i]==KeyEvent.VK_RIGHT){//check if right key is pressed
				
				prevR=true; CurrentR=true;
				shouldMove=true;
			}	//end if
			if(keysDown[i]==KeyEvent.VK_LEFT){//check if left key is pressed
				 
				 prevL=true; CurrentL=true;
				shouldMove=true;
			}	//end if
			if(keysDown[i]==KeyEvent.VK_UP){//check if right key is pressed
				 
				 prevU=true; CurrentU=true;
				shouldMove=true;
			}	//end if
			if(keysDown[i]==KeyEvent.VK_DOWN){//check if left key is pressed
				
				 prevD=true; CurrentD=true;
				shouldMove=true;
			}	//end if
			if(CurrentR==false&&prevR==true){
				dir="right";
				keyReleased=true;
				prevR=false;
			}else if(CurrentL==false&&prevL==true){
				dir="left";
				keyReleased=true;
				prevL=false;
			}else if(CurrentU==false&&prevU==true){
				dir="up";
				keyReleased=true;
				prevU=false;
			}else if(CurrentD==false&&prevD==true){
				dir="down";
				keyReleased=true;
				prevD=false;
			}
			
		}	//end for loop
		if(keyReleased&&shouldMove){
			System.out.println("yo");
			pc.move(dir);
			pc.draw(g);
		}	//end if
		if (takeStep) {
			dungeon.step();
		}	//end if
	}	//end updateFrame

	public void drawTiles(Graphics g) {
		Scanner sc=null;
		try {
			sc=new Scanner(new FileReader(new File("maps/terrainmap.txt")));
		} catch (FileNotFoundException e) {
			System.out.println(".txt file not found.");
		}	//end try/catch
		int ht=0;
		while(sc.hasNext()) {
			String line=sc.nextLine();
			for (int i=0;i<line.length();i++) {
				
				g.drawImage(tiles[Integer.parseInt(line.charAt(i)+"")-1], i*32, ht, null);
			}	//end for loop
			ht+=32;
		}	//end while loop
	}	//end drawTiles

	public void keyReleased(KeyEvent keyE) {
		// Remove key released
		int[] newDown=new int[keysDown.length-1];
		int atLoc=0;
		for (int i = 0; i < keysDown.length; i++) {
			if(keysDown[i]!=keyE.getKeyCode()){
				newDown[atLoc]=keysDown[i];
				atLoc++;
			}	//end if
		}	//end for loop
		keysDown=newDown;
	}//end keyReleased

	public void keyPressed(KeyEvent keyE) {
		boolean add=true;
		int[] newDown=new int[keysDown.length+1];
		for (int i = 0; i < keysDown.length; i++) {
			if(keysDown[i]==keyE.getKeyCode())	{add=false;break;}
			newDown[i]=keysDown[i];
		}

		if(add){

			newDown[keysDown.length]=keyE.getKeyCode();
			keysDown=newDown;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}	//end GameScreen
