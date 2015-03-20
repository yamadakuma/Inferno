package inferno.skills;

import inferno.Stats;

public class RandomAttack extends Skills {
	public RandomAttack(){	
		setDescrip("This skill looks only at your attack and the enemy's defense but randomizes");
	}
	@Override
	public void effect(Stats user,Stats target){
		int damage=user.getAttack()-target.getDefense();
		int randomFact=(int) (Math.random()*7-3);
		damage-=randomFact;
		if(damage<0) damage=0;
		
		target.setCurrentHP(target.getCurrentHP()-damage);
	}

}
