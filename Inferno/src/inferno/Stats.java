package inferno;

public class Stats {
	private int MaxHP;
	private int MaxMana;
	private int CurrentHP;
	private int CurrentMana;
	private int Attack;
	private int Defense;
	private int Magic;
	public int getAttack() {
		return Attack;
	}
	public void setAttack(int attack) {
		Attack = attack;
	}
	public int getDefense() {
		return Defense;
	}
	public void setDefense(int defense) {
		Defense = defense;
	}
	public int getMagic() {
		return Magic;
	}
	public void setMagic(int magic) {
		Magic = magic;
	}
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
	public int getMaxMana() {
		return MaxMana;
	}
	public void setMaxMana(int maxMana) {
		MaxMana = maxMana;
	}
	public int getCurrentHP() {
		return CurrentHP;
	}
	public void setCurrentHP(int currentHP) {
		CurrentHP = currentHP;
	}
	public int getCurrentMana() {
		return CurrentMana;
	}
	public void setCurrentMana(int currentMana) {
		CurrentMana = currentMana;
	}
	public String toString(){
		String a="";
		a="HP:"+CurrentHP+"/"+MaxHP+" ";
		a+="Mana:"+CurrentMana+"/"+MaxMana+" ";
		a+="Atk:"+Attack+" ";
		a+="Def:"+Defense+" ";
		a+="Mag:"+Magic+" ";
		
		return a;
	}
	public void setAll(int maxHP, int maxMana,int currentHP,int currentMana,int attack,int defense,int magic){
		Attack = attack;
		Defense = defense;
		Magic = magic;
		MaxHP = maxHP;
		MaxMana = maxMana;
		CurrentHP = currentHP;
		CurrentMana = currentMana;
		
	}
	
	
}
