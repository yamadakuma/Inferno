package inferno;

import inferno.skills.Skills;

public class Character {
	private Skills[] abilities;
	private Stats stats;
	private String name;
	private boolean dead;
	private int posX;
	private int posY;
	private World w;
	
	public Character(){
		
	}
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public Character(World w){
		this.setWorld(w);
	}


	public Skills[] getAbilities() {
		return abilities;
	}


	public void setAbilities(Skills[] abilities) {
		this.abilities = abilities;
	}


	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void useSkill(int index, Character Target){
		if(!dead)	abilities[index].effect(stats, Target.getStats());
		if(Target.getStats().getCurrentHP()<=0){ 
			Target.getStats().setCurrentHP(0);
			Target.setdead(true);
		
		}
	}
	

	public boolean isdead() {
		return dead;
	}


	public void setdead(boolean dead) {
		this.dead = dead;
	}


	public World getWorld() {
		return w;
	}


	public void setWorld(World w) {
		this.w = w;
	}
}
