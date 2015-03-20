package inferno;

import inferno.enemies.Enemy;

//so this is basically the class everything is stored in, so there'll be an array of monsters and such and blah 
public class World {
	private Enemy[] monsters;
	private Player player;
	public World(){
		
	}

	public Enemy[] getMonsters() {
		return monsters;
	}

	public void setMonsters(Enemy[] monsters) {
		this.monsters = monsters;
	}
	
	public void addMonsters(Enemy[] monsters){
		int size=monsters.length+this.monsters.length;
		Enemy[] newMon=new Enemy[size];
		for(int i=0;i<this.monsters.length;i++){
			newMon[i]=this.monsters[i];
		}
		for(int i=0;i<monsters.length;i++){
			newMon[i+this.monsters.length]=monsters[i];
		}
	}
	//this increments the world and makes all the monsters take a turn, environmental hazards activate and whatever else is dependent upon turns
	public void step(){
		for(int i=0;i<monsters.length;i++){
			if(monsters[i].isdead()){
				
				Enemy[] m=new Enemy[monsters.length-1];
				for(int j=0;j<monsters.length;j++){
					if(j<i)m[j]=monsters[j];
					else if(j>i) m[j-1]=monsters[j];
				}
				monsters=m;
				i--;
			}
			monsters[i].step();
		}
		
		
	}
	public boolean WallAt(int x,int y){
		
		return false;
	}
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
