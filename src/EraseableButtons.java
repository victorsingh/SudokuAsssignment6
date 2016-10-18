
public class EraseableButtons {
	private SudokuButton data;
	private EraseableButtons next;
	
	public EraseableButtons(SudokuButton d){
		data = d;
	}
	
	public EraseableButtons (SudokuButton d, EraseableButtons n){
		data = d;
		next = n;
	}
	
	public SudokuButton getData(){return data;}
	public EraseableButtons getNext(){return next;}
	public void setNext(EraseableButtons n){next = n;}
}
