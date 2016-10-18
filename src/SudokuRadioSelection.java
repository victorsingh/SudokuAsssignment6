import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SudokuRadioSelection extends JRadioButton implements ActionListener {

	private static SudokuBoard board;
	public SudokuRadioSelection(String name, SudokuBoard b){
		super(name);
		board = b;
		this.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getActionCommand()=="isValid"){
			if(board.isValid(SudokuButton.getButton().getSquare().getRow(),SudokuButton.getButton().getSquare().getColumn(),SudokuInput.getInput()))
			GUI.x.setText("Yes, this move is valid!");
			else GUI.x.setText("No, this move NOT is valid! :(");

		}
		
		if(event.getActionCommand()=="enter"){
			//JOptionPane.showMessageDialog(null,(board.isValid(SudokuButton.getButton().getSquare().getRow(), SudokuButton.getButton().getSquare().getColumn(), SudokuInput.getInput())));
			Boolean z = board.isValid(SudokuButton.getButton().getSquare().getRow(), SudokuButton.getButton().getSquare().getColumn(), SudokuInput.getInput());
			try{
				if(z == true){
					GUI.x.setText("Got Input!");
					enterValue();
				}
				else if(z == false){
					throw new SudokuException();
				}
			}
			catch(SudokuException s){
				//Constrctor is called
			}
			if(board.isFull()){
				GUI.x.setText("You win!");
			}else{
				GUI.x.setText("Next Move?");
			}
			/*board.enterMove(SudokuButton.getButton().getSquare().getRow(), SudokuButton.getButton().getSquare().getColumn(), SudokuInput.getInput());
			SudokuButton.getButton().changeValue(SudokuInput.getInput());
			JOptionPane.showInputDialog(null, SudokuButton.getButton().getSquare().getValue());*/
			
		}
		if(event.getActionCommand()=="reset"){
			int stc = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?");
			if(stc == 0){
			board.reset();
			
			for(int i = 0; i<10; i++)
				SudokuButton.returnLink().getNext().setText("0");
				
			
			
			GUI.x.setText("Your Board has been Reset");
			}
		}
		if(event.getActionCommand() == "clear"){
			clearButton();
		}
		
	}
	
	public void enterValue(){
		board.enterMove(SudokuButton.getButton().getSquare().getRow(), SudokuButton.getButton().getSquare().getColumn(), SudokuInput.getInput());
		SudokuButton.getButton().changeValue(SudokuInput.getInput());
		//JOptionPane.showInputDialog(null, SudokuButton.getButton().getSquare().getValue());
	}
	public void clearButton(){
		SudokuButton.getButton().changeValue(0);
	}
}
