package inferno.enemies;

import inferno.Player;
import inferno.World;

public class Imp extends Enemy {
	@Override
	public boolean inRange(){
		if(getWorld().getPlayer().getPosX()-getPosX()<=1&&getWorld().getPlayer().getPosY()-getPosY()<=1) return true;
		

		
return false;
	}
	
	@Override
	public void checkPlayerSpotted(){
		int x=getPosX(), y=getPosY();
		Player p=getWorld().getPlayer();
		if(Math.abs(p.getPosX()-x)<4||Math.abs(p.getPosY()-y)<4){ //this is a temporary thing all enemies have blindivision for now a better vision alogortihm will be written when time is avalible
			setPlayerSpotted(true);
			
			
			
		}
		else setPlayerSpotted(false);
	}
	
	
	
	@Override
	public void step() {  //shitty algorithm that selects movement and attacks
		if(isPlayerSpotted()){
			
			if(!inRange()){
				int x=getPosX();
				int y=getPosY();
				int playerX=getWorld().getPlayer().getPosX();
				int playerY=getWorld().getPlayer().getPosY();
				int disx=Math.abs(playerX-x);
				int disy=Math.abs(-y);
				int bestChangeX = 0;
				int bestChangeY=0;
				boolean xy=true; //false is y true is x
				
				if(playerY>getPosY()) bestChangeY=y+1;
				else bestChangeY=y-1;

				if(playerX>getPosX()) bestChangeX=x+1;
				else bestChangeX=x-1;
				World w=getWorld();
				
				//possibly make this a method
				boolean right, up, left, down;  //if right is free of a wall
				if(w.WallAt(x+1, y)) right=false;
				else right=true;
				if(w.WallAt(x, y+1)) up=false;
				else up=true;
				if(w.WallAt(x-1, y)) left=false;
				else left=true;
				if(w.WallAt(x, y-1)) down=false;
				else down=true;
				
				boolean optimal=false;
				if(disx<disy){
					xy=false;
				}
				if(xy){
					if(!w.WallAt(bestChangeX, getPosY()))setPosX(bestChangeX);
					optimal=true;
				}else{
					if(!w.WallAt(getPosX(), bestChangeY)) setPosY(bestChangeY);
					optimal=true;
				}
				if(!optimal){
				if(right) setPosX(x+1);
				else if(up) setPosY(y+1);
				else if(left) setPosX(x-1);
				else if(down) setPosY(y-1);
				}
				checkPlayerSpotted();
			}else{
				int move=(int) (Math.random()*getAbilities().length);
				getAbilities()[move].effect(getStats(), getWorld().getPlayer().getStats());
				checkPlayerSpotted();
			}

			
		}else{
			//random movement, implement wall collision checking later
			int x=(int) (Math.random()*2);
			int y=(int) (Math.random()*2);
			if(Math.random()<.5)x*=-1;
			if(Math.random()<.5)y*=-1;
			
			setPosX(x+getPosX());
			setPosY(y+getPosY());
			checkPlayerSpotted();
			
		}
		
		
		
	}
	
	
	
}
