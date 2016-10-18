import javax.swing.JOptionPane;
public class SudokuSquare {
	private int row;
	private int column;
	private int value;
	private boolean locked;
	
	public SudokuSquare(int r, int c, int v){
		row = r;
		column = c;
		while(v<0||v>4){
			String x = JOptionPane.showInputDialog(null, "Enter a valid number");
			v = Integer.parseInt(x);
		}
		value = v;
		locked = true;
	}
	public SudokuSquare(int r, int c){
		row = r;
		column = c;
		locked = false;
		value = 0;
	}
	public  boolean isLocked(){
		if(locked == true) return true;
		else return false;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	public void setValue(int val){
		value = val;
	}
	public int getValue(){
		return value;
	}
	
}
