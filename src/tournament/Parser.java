package tournament;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Parser {

	public static Conflict parse(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		ArrayList<Character> chars = new ArrayList<Character>();
		while (s.hasNextLine()) {
			chars.add(new Character(s.nextLine()));
		}
		Collections.shuffle(chars);
		/*for (Character c:chars) {
			System.out.println(c.getStringRep());
		}*/
		int level = 1;
		Conflict topC = makeConflict(1, chars);
		while (!chars.isEmpty()) {
			Conflict newC = makeConflict(level, chars);
			topC = new Conflict(topC, newC);
			level++;
		}
		return topC;
	}
	
	private static Conflict makeConflict(int levels, ArrayList<Character> chars) {
		Conflict c;
		if (levels == 1) {
			Leaf<Character> l1, l2;
			if (!chars.isEmpty()) {
				l1 = new Leaf<Character>(chars.remove(0), true);
			} else {
				l1 = new Leaf<Character>(null, false);
			}
			
			if (!chars.isEmpty()) {
				l2 = new Leaf<Character>(chars.remove(0), true);
			} else {
				l2 = new Leaf<Character>(null, false);
			}
			
			c = new Conflict(l1, l2);
		} else {
			c = new Conflict(makeConflict(levels-1, chars), makeConflict(levels-1, chars));
		}
		
		return c;
		
	}
}
