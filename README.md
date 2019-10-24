8 queen problem
The eight queens problem is the problem of placing eight queens on an 8×8 chessboard such that none of them attack one another 
(no two are in the same row, column, or diagonal). More generally, the n queens problem places n queens on an n×n chessboard.

This program is an iterative implementation of a brute forcemethod of attacking this problem.
It compares new queens on the board againstall other queens, and moves the current one until it fits. 
If it fails to fit it is popped off the board, and the previous queen is moved.
