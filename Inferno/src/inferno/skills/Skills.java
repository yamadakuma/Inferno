package inferno.skills;

import inferno.Stats;


public class Skills {
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}




	private String description;
	
	
	public void effect(Stats user,Stats target){  //just change to character since you can do get stats within or whatever is a future consideration
	}
	
	public String getDescrip(){return description;}
	public void setDescrip(String description){this.description=description;}

	

	
	public Skills(){
		
	}
}
