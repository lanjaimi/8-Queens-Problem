//---------------------------------------------------------------------------
//
// Stack Node
//
// Author: Vic Berry
// Date: 03/19/19
// Class: MET CS342
// Issues: None known
//
// Description:
// Specialized Node for the 8 Queens problem.  It basically contains a row and column
//
// Assumptions:
// Should only be used for a chess board
//

public class Node {

	private int row;
	private int col;
	private Node next;
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
