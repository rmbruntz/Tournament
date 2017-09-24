package tournament;

public class Leaf<E extends Entrant> implements Node{

	private boolean filled;
	private E contents;
	
	public Leaf(E e, boolean filled) {
		this.contents = e;
		this.filled = filled;
	}
	
	
	public int getDepth() {
		return 0;
	}
	
	public String getBracket(int maxLength) {
		String s = contents.getStringRep();
		s = s.substring(0, Math.min(s.length(), maxLength));
		return s;
	}
	
	public E getContents() {
		return contents;
	}
	
	public void playRound(int depth) {
		
	}
	
	public boolean getFilled() {
		return filled;
	}
	
}
