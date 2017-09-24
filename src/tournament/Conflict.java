package tournament;

import java.util.Scanner;

public class Conflict<E extends Entrant> implements Node{

	public Node<E> p1;
	public Node<E> p2;
	private E winner;
	private boolean played;
	
	public Conflict(Node l1, Node l2) {
		p1 = l1;
		p2 = l2;
		played = false;
	}
	
	public int getDepth() {
		return p1.getDepth() + 1;
	}
	
	
	
	public void playRound(int depth){
		if (depth == 1) {
			
			
			if (p1.getFilled() && p2.getFilled()) {
				System.out.println(p1.getContents().getStringRep() + " (a) vs " + p2.getContents().getStringRep()+" (b)");
				String in = new Scanner(System.in).nextLine();
				if (in.equals("a")) {
					this.winner = p1.getContents();
					played = true;
				} else if (in.equals("b")) {
					this.winner = p2.getContents();
					played = true;
				} else {
					System.out.println("Invalid input");
					playRound(depth);
				}
			} else if (p1.getFilled()) {
				this.winner = p1.getContents();
				played = true;
			} else if (p2.getFilled()){
				this.winner = p2.getContents();
				played = true;
			} else {
				return;
			}
		} else {
			p1.playRound(depth-1);
			p2.playRound(depth-1);
		}
	}
	
	public void play() {
		for (int x = getDepth(); x > 0; x--) {
			playRound(x);
		}
		System.out.println("Winner: " + winner.getStringRep());
	}
	
	
	
	public E getContents() {
		if (played) {
			return winner;
		} else {
			return null;
		}
	}

	public boolean getFilled() {
		return played;
	}
	
}
