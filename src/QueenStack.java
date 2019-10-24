//---------------------------------------------------------------------------
//
// 8 Queens Stack (QueenStack)
// Stack for the purposes of solving the 8 Queens problem.
//
// Author: Vic Berry
// Date: 03/19/19
// Class: MET CS342
// Issues: None known
//
// Description:
// This is a modified stack that allows chess manipulations for the 8 Queens problem.
// To avoid problems with information sharing this stack also knows about printing the board
// in addition to whether queens on the board can attack each other.
//
// Assumptions:
// Is intended only for the 8 Queens problem
//

public class QueenStack  {
	/* Constants */
	public final int BOARD_SIZE = 8;
	public final int MAX_QUEENS	= 8;
	
	// Head of the list for the stack, and the count of elements.
	private Node head = null;
	private int count = 0;
	
	///////////////////////////////////////////////////////////////////
	/// push (Add item to stack) 									///
	/// Input : row and col to be pushed 							///
	/// Output: Always true 										///
	/// Returns true if insert is successful, false otherwise 		///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public boolean push(int row, int col) {
		// Allocate a new node and fill it in
		Node n = new Node();
		n.setRow(row);
		n.setCol(col);
		n.setNext(head);
		
		// Add to head of linked list
		head = n;
		count++;
		return true;
	}

	///////////////////////////////////////////////////////////////////
	/// pop (Remove item from stack) 								///
	/// Input : nothing 											///
	/// Output: stack Node.									///
	/// Returns Node if pop is successful, null otherwise 			///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public Node pop() {
		if (isEmpty()) {
			// return null if empty stack
			return null;
		} else {
			// grab Node from head of list, and return it.
			Node tmp = head;
			head = head.getNext();
			count--;
			return tmp;
		}
	}

	///////////////////////////////////////////////////////////////////
	/// isEmpty (Are there Nodes on the stack?) 					///
	/// Input : None 												///
	/// Output: boolean 											///
	/// Returns true if empty, false otherwise 						///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public boolean isEmpty() {
		return (count == 0);
	}

	///////////////////////////////////////////////////////////////////
	/// Queue_add (Add item to queue) ///
	/// Input : data to be inserted ///
	/// Output: None ///
	/// Returns true if insert is successful, false otherwise ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public Node top() {
		if (isEmpty()) {
			return null;
		} else {
			Node n = head;
			return n;
		}
	}

	///////////////////////////////////////////////////////////////////
	/// Queue_add (Add item to queue) ///
	/// Input : data to be inserted ///
	/// Output: None ///
	/// Returns true if insert is successful, false otherwise ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	///////////////////////////////////////////////////////////////////
	/// Queue_add (Add item to queue) ///
	/// Input : data to be inserted ///
	/// Output: None ///
	/// Returns true if insert is successful, false otherwise ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public void clear() {
		head = null;
		count = 0;
	}
	
	///////////////////////////////////////////////////////////////////
	/// displayBoard (prints graphical representation of board)		///
	/// Input : None 												///
	/// Output: void 												///
	///    	Display the board, shows the queens in their respective	///
	///		positions on the board.									///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void displayBoard()
	{
		int row;				/* Current row           */
		int col;				/* Current col           */
		int i, j;				/* Various loop counters */

		for (row = 1; row <= BOARD_SIZE; row++) {
			
			// This section prints the first line of the board.
			// This is probably overkill, but it allows for arbitrary board sizes
			System.out.printf("+");
			for (j = 1; j <= BOARD_SIZE; j++) {
				System.out.printf("---+");
			}
			System.out.printf("\n");
			System.out.printf("|");

			// Print each individual row of the board
			for (col = 1; col <= BOARD_SIZE; col++) {
				// This will search the stack to get each queen and see if it should
				// be printed.  I know this is not very efficient, but it is easy to implement
				Node tmp = head;
				for (i = 1; i <= size() ; i++) {
					if ((tmp.getRow() == row) &&
							(tmp.getCol() == col)) {
						System.out.printf(" Q |");
						break;		// Can't be two here
					}
					tmp = tmp.getNext();
				}
				// If we found no queen, print a space 
				if (i == size()+1) {
					System.out.printf("   |");
				}
			}
			System.out.printf("\n");
		}
		// Print bottom of board
		System.out.printf("+");
		for (j = 0; j < BOARD_SIZE; j++) {
			System.out.printf("---+");
		}
		System.out.printf("\n");
	}

	///////////////////////////////////////////////////////////////////
	/// boardSafe 	(Determines if all queens in the stack are safe ///
	///				from each other) 								///
	/// Input : none 												///
	/// Output: boolean 											///
	/// Returns true if insert is safe, false otherwise 			///
	/// ///
	///////////////////////////////////////////////////////////////////
	public boolean boardSafe()
	{
		int i, j;				// Loop Variables 
		int x, y;				// More loop vars 

		// Loop through the array of queens comparing the current queen
		// against all remaining queens.  If we fail any test we exit.
		
		// We will compare the queen at tmp with the queens at tmp2
		Node tmp = head;
		for (i = 0; i < size(); i++) {
			
			// Grab the next queen in the stack
			Node tmp2 = tmp.getNext();
			for (j = i+1; j < size(); j++) {
				if (tmp.getRow() == tmp2.getRow()) // Two in same row 
					return false;

				if (tmp.getCol() == tmp2.getCol()) // Two in same col 
					return false;

				// To determine the diagonal queens we can utilize the algorithm
				// that states that if the absolute value of the rows subtracted
				// is equal to the absolute value of the columns subtracted,
				// these two queens are on a diagonal to each other.
				x = tmp.getRow() - tmp2.getRow();
				y = tmp.getCol() - tmp2.getCol();
				if (Math.abs(x) == Math.abs(y))
					return false;
				
				// Move on to the next queen
				tmp2 = tmp2.getNext();
			}
			// Check the next queen down the stack
			tmp = tmp.getNext();
		}
		//System.out.println("DONE");
		return true;
	}
	
	
	///////////////////////////////////////////////////////////////////
	/// toString (print the stack) 									///
	/// Input : None 												///
	/// Output: String representation of stack 						///
	///  															///
	///////////////////////////////////////////////////////////////////
	public String toString() {
		if (isEmpty()) {
			return "<Empty>";
		}
		String rtn = "";
		Node tmp = head;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				rtn += "top -> " + tmp.getRow() + ", " + tmp.getCol() + "\n";
			} else {
				rtn += "       " + tmp.getRow() + ", " + tmp.getCol() + "\n";
			}
			tmp = tmp.getNext();
		}
		return rtn;
	}

}
