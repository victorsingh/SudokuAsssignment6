import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SudokuButton extends JButton implements ActionListener{
	

	private int value;
	private static boolean Linked = false;
	private int thisNumber = 0;
	private static SudokuButton selected;
	public static ButtonGroup group = new ButtonGroup();
	private SudokuSquare ownSquare;
	private static EButtonLinkedList EBLL;
	public SudokuButton(SudokuSquare oS){
		super(""+oS.getValue());
		this.addActionListener(this);
		value = oS.getValue();
		ownSquare = oS;
		group.add(this);
		if(this.ownSquare.isLocked()==false){
			if(Linked==false){
				EBLL = new EButtonLinkedList(new EraseableButtons(this));
				Linked = true;
			}else{
				EBLL.append(new EraseableButtons(this));
			}
		}
		
	
		
	}
	
	public void actionPerformed(ActionEvent event){
		selected = this;
		this.setSelected(true);
		JOptionPane.showMessageDialog(null, "Enter value for button" + "( " + ownSquare.getRow() + "," + ownSquare.getColumn() + ")");
		//getButton();
		
	}
	public static SudokuButton getButton(){
		return selected;
	}
	public SudokuSquare getSquare(){
		return ownSquare;
	}
	public void changeValue(int val){
		
		this.setText(""+val);
	}
	public static EButtonLinkedList returnLink(){
		return EBLL;
	}
}
