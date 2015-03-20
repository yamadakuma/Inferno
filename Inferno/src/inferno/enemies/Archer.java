package inferno.enemies;

public class Archer extends Enemy {
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
