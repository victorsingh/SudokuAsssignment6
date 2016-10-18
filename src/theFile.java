import java.io.*;
import java.util.*;



public class theFile {
	private static int  row;
	private static int column;
	private static int  value;
	private static int counterC = 0;
	private static int counterR = 0;
	private static int counterV = 0;
	private static String title;
	SudokuSquareNode squares;
	private SudokuBoard w;
	private Scanner x;
	public theFile(){
		openFile();
		title = x.nextLine();
		//System.out.print(title);
		
	}
	
	public void openFile(){
		try{
			/*x = new Scanner(new File("C:/Users/Victor_2/workspace/PracticingWithFiles/src/sb.txt"));*/
			x = new Scanner(new File("sb.txt"));
		}
		catch(Exception e){
			System.out.println("File not found");
		}
	}
	public void roundOfRead(){
		int i = 0;
		SudokuSquareLinkedList preMade;
		preMade = new SudokuSquareLinkedList(new SudokuSquareNode(new SudokuSquare(row,column,value)));
		while(x.hasNext()==true){
		row = Integer.parseInt(x.next());
	
		column = Integer.parseInt(x.next());
		
		value = Integer.parseInt(x.next());
		
		preMade.append(new SudokuSquareNode(new SudokuSquare(row,column,value)));
		}
		w = new SudokuBoard(preMade);
		getSudokuBoard();
		
		
	}
	public SudokuBoard getSudokuBoard(){
		return w;
	}
	public boolean hasNext(){
		return x.hasNext();
	}
	
	public int getRow(){
		counterR++;
		return row;
		
	}
	public int getCol(){
		counterC++;
		return column;
		
	}
	public int getValue(){
		counterV++;
		return value;
		
	}
	
	public  void closeFile(){
		x.close();
	}
}
