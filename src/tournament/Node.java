package tournament;

public interface Node<E extends Entrant> {

	public int getDepth();
	public E getContents();
	public void playRound(int depth);
	public boolean getFilled();
}
