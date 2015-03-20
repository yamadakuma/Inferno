package inferno;

import inferno.enemies.Enemy;
import inferno.skills.BasicAttack;
import inferno.skills.RandomAttack;
import inferno.skills.Skills;

public class TextBasedTestWorld {
	public static void main(String[] args){
		Player you=new Player();
		Enemy monster=new Enemy();
		you.setAbilities(new Skills[] {new BasicAttack(),new RandomAttack()});
		monster.setAbilities(new Skills[] {new BasicAttack(), new RandomAttack()});
		Stats yourStat=new Stats();
		Stats monStat=new Stats();
		yourStat.setAll(50, 10, 50, 0, 5, 3, 0);
		monStat.setAll(50, 10, 50, 0, 5, 3, 0);
		you.setStats(yourStat);monster.setStats(monStat);
		System.out.println("your HP is:"+you.getStats().getCurrentHP()+" monster HP is:"+monster.getStats().getCurrentHP());

		while(!you.isdead()&&!monster.isdead()){
		
			you.useSkill(1, monster);
			monster.useSkill(1, you);
			System.out.println("your HP is:"+you.getStats().getCurrentHP()+" monster HP is:"+monster.getStats().getCurrentHP());
			System.out.println(monster.getStats().toString());
		}
		
		
	}
}
