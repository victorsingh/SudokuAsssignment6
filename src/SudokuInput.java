import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class SudokuInput extends JTextField implements ActionListener {

	private static String input;
	SudokuInput(){
		super();
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event){
		//if(Integer.parseInt(event.getActionCommand()) < 1 || Integer.parseInt(event.getActionCommand()) > 4 )
		
		input = event.getActionCommand();
		JOptionPane.showMessageDialog(null, "Your input has been recognized");
		
		
	}
	public static int getInput(){
		int numInput = Integer.parseInt(input);
		return numInput;
	}
}
