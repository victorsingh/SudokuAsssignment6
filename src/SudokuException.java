import javax.swing.JOptionPane;

public class SudokuException extends Exception {
	SudokuException(){
		JOptionPane.showMessageDialog(null,"This is not a valid move.");
	}
}
