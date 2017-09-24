package tournament;

public class Character implements Entrant{

	private String name;
	
	public Character(String name) {
		this.name = name;
	}
	
	public String getStringRep(){
		return name;
	}
}
