package inferno.enemies;

import inferno.Player;

public class Archer extends Enemy {
	
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
	public void step() {  //algorithm that selects movement and attacks
		if(isPlayerSpotted()){
			
			
			
		}else{
			int x=(int) (Math.random()*2);
			int y=(int) (Math.random()*2);
			if(Math.random()<.5)x*=-1;
			if(Math.random()<.5)y*=-1;
			
			setPosX(x+getPosX());
			setPosY(y+getPosY());
		}
		
		
		
	}
	
}
