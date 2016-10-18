import java.awt.*;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;



public class GUI{
	private JFrame mainWindow;
	private JPanel output;
	private JPanel theBoard;
	private JPanel radioButtons;
	private JPanel input;
	private SudokuBoard b;
	public static SudokuOutput x;
	private Scanner scan;
	private int [] scanRow = new int[16];
	private int [] scanCol = new int[16];
	private int [] scanVal = new int[16];
	private SudokuButton[][] buttons = new SudokuButton[4][4];
	
	GUI(){
		link();
		initialize();
	    addOutput();
	    setBoard();
	    setRadioButtons();
	    addInput();		
	    
	}
	public SudokuBoard retBoard(SudokuBoard x){
		return x;
	}
	
	
	public void initialize(){
		mainWindow = new JFrame();
		mainWindow.setVisible(true);
		mainWindow.setSize(1000,1000);
		mainWindow.setLocation(100,100);
		mainWindow.setTitle("Sudoku");
		mainWindow.setLayout(new GridLayout(4,4));
		mainWindow.setVisible(true);
	}
	
	public void setRadioButtons(){
		radioButtons = new JPanel();
		radioButtons.setLayout(new GridLayout(1,3));
		SudokuRadioSelection isValid = new SudokuRadioSelection("isValid" , b);
		SudokuRadioSelection enter = new SudokuRadioSelection("enter" , b );
		SudokuRadioSelection reset = new SudokuRadioSelection("reset", b);
		SudokuRadioSelection clear = new SudokuRadioSelection("clear", b);
		ButtonGroup bg = new ButtonGroup();
		bg.add(enter);
		bg.add(reset);
		bg.add(isValid);
		bg.add(clear);
		radioButtons.add(isValid);
		radioButtons.add(enter);
		radioButtons.add(reset);
		radioButtons.add(clear);
		mainWindow.add(radioButtons);
		
		
	}
	
	public void setBoard(){
		theBoard = new JPanel();
		theBoard.setLayout(new GridLayout(4,4));
		
		for(int r = 0; r < 4; r++){
			for(int c = 0; c < 4; c++){
				buttons[r][c] = new SudokuButton(link().getSquare(r,c));
				
				if(link().getSquare(r,c).isLocked()==true){
					buttons[r][c].setEnabled(false);
				}
				//buttons[r][c].addActionListener(handler);
				//buttons[r][c].setText();
			}
		}
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				
				theBoard.add(buttons[i][j]);
			}
		}
		
		mainWindow.add(theBoard);
		
	}
	
	public void change(){
		buttons[0][1].setText(""+3);
	}
	
	public void addOutput(){
		output = new JPanel();
		output.setLayout(new GridLayout(1,1));
		x = new SudokuOutput("Please Enter A Move.		Note: To register a move, click on the Text box, enter a number, and press Enter - Victor Singh");
		x.setEditable(false);
		output.add(x);
		mainWindow.add(output);
	}
	
	public void addInput(){
		input = new JPanel();
		input.setLayout(new GridLayout(1,1));
		SudokuInput y = new SudokuInput();
		input.add(y);
		mainWindow.add(input);
		
	}
	public SudokuBoard link(){
		theFile x = new theFile();
		x.openFile();
		x.roundOfRead();
		x.closeFile();
		b = x.getSudokuBoard();
		return b;
	}
	
	public void run(){
		String x = JOptionPane.showInputDialog(null,"Enter a number");
		int xint = Integer.parseInt(x);
		String r2 = JOptionPane.showInputDialog(null, "What row?");
		int ri = Integer.parseInt(r2);
		String c = JOptionPane.showInputDialog(null,"What column?");
		int ci =Integer.parseInt(c);
		link().enterMove(ri,ci,xint);
	}
	
	/*public int ButtonColumn(SudokuButton x){
		return 0;
	}*/
	public void openFile(){
		try{
			scan = new Scanner(new File("C:/Users/Victor_2/workspace/PracticingWithFiles/src/sb.txt"));
		}
		catch(Exception e){
			System.out.println("File not found");
		}
	}
	public void roundOfRead(){
		
		for(int i = 0; scan.hasNext()==true; i++){
		scanRow[i] = Integer.parseInt(scan.next());
	
		scanCol[i] = Integer.parseInt(scan.next());
		
		scanVal[i] = Integer.parseInt(scan.next());
		
		}
		
		
	}


	
	
}
