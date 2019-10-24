//---------------------------------------------------------------------------
//
// 8 Queens (Stack Based)
// Solves the 8 Queens problem utilizing a stack.
//
// Author: Vic Berry
// Date: 03/19/19
// Class: MET CS342
// Issues: None known
//
// Description:
// This program is an iterative implementation of a brute force
// method of attacking this problem. It compares new queens on the board against
// all other queens, and moves the current one until it fits.  If it fails to fit
// it is popped off the board, and the previous queen is moved.
//
// Assumptions:
// The board will start with a queen at 1,1.
//

public class Driver {

	///////////////////////////////////////////////////////////////////
	/// main program entry point									///
	/// Input : arguments.  (these are ignored for this program)	///
	/// Output: None 												///
	/// Returns nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	///////////////////////////////////////////////////////////////////
	/// doIt (Worker method called from main)						///
	/// Input : None 												///
	/// Output: None 												///
	/// Returns Nothing												///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public void doIt() {
		
		// Allocate a Queen Stack for this attempt
		QueenStack stack = new QueenStack();

		// Start with the initial queen in the 1,1 location
		stack.push(1,1);

		// We will stop when success is set to true.
		boolean success = false;

		// Loop placing queens and adjusting their positions.
		while(!success && !stack.isEmpty()) {
			
			// If the board is not safe (Queens can take each other) adjust the queens
			if (!stack.boardSafe()) {

				// If the queen on top of the stack is in column 8, pop it off until the top queen
				// is no longer in column 8
				while (stack.top().getCol() == stack.BOARD_SIZE) {
					stack.pop();
				}

				// Getting here the top queen is not in column 8, move it over by one column
				// pop it off
				Node n = stack.pop();
				// adjust and push
				stack.push(n.getRow(), n.getCol()+1);
			} else if (stack.size() == stack.BOARD_SIZE) {
				// If we get here the board is safe, and 8 queens are on it, this is 
				// the successful outcome.
				System.out.println("SUCCESS");
				stack.displayBoard();
				success = true;
			} else {
				// The board is safe, but not enough queens, add one
				//System.out.println("Pushing");
				stack.push(stack.size()+1, 1);
			}
		}
	}

}
