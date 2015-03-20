package inferno.enemies;

import inferno.Character;

public class Enemy extends Character {
	private boolean PlayerSpotted;
	public void step() {  //algorithm that selects movement and attacks
		
	}

	public Enemy() {
		
	}

	public boolean isPlayerSpotted() {
		return PlayerSpotted;
	}

	public void setPlayerSpotted(boolean playerSpotted) {
		PlayerSpotted = playerSpotted;
	}
	
	public void checkPlayerSpotted(){ //varies based on enemy possibly add a basic one that ~80-90% of enemies use, either that or ignore 100%
		
	}
	public boolean inRange(){
		return false;
	}
	

}
