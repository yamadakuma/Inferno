package inferno;

import inferno.enemies.Imp;

public class Main {
	public static void main(String args[]){
		Imp a=new Imp();
		a.setPosX(10);
		a.setPosY(15);
		int i=10;
		while(i>0){
			i--;
			a.step();
		}
		
	}
}
