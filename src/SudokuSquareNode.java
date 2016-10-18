
public class SudokuSquareNode {

	private SudokuSquare data;
	private SudokuSquareNode next;
	
	public SudokuSquareNode(SudokuSquare d){
		data = d;
	}
	
	public SudokuSquareNode(SudokuSquare d, SudokuSquareNode n){
		data = d;
		next = n;
	}
	
	public SudokuSquare getData(){return data;}
	public SudokuSquareNode getNext(){return next;}
	public void setNext(SudokuSquareNode n){next = n;}
	
}

