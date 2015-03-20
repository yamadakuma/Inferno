package inferno.skills;

import inferno.Stats;


public class BasicAttack extends Skills {
	public BasicAttack(){	
		setDescrip("This skill looks only at your attack and the enemy's defense");
	}
	@Override
	public void effect(Stats user,Stats target){
		int damage=user.getAttack()-target.getDefense();
		if(damage<0) damage=0;
		target.setCurrentHP(target.getCurrentHP()-damage);
	}
	

}
