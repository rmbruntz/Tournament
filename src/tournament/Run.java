package tournament;

import java.io.FileNotFoundException;

public class Run {

	public static void main(String[] args){
		Conflict c;
		try {
			c = Parser.parse("entrants");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			c = new Conflict(null, null);
			System.exit(0);
		}
		c.play();
	}
}
