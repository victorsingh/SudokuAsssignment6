
public class SudokuBoard {
	public int counter = 0;
	private SudokuSquare [][] board  = new SudokuSquare[4][4];
	public SudokuBoard(SudokuSquareLinkedList x){
		
		for(int f = 0; f<6;f++){
			SudokuSquare xz = x.getNext();
			//System.out.println(f);
			board[xz.getRow()][xz.getColumn()] = xz;
		}
		for(int i = 0; i<4; i++)
			for(int j = 0; j<4; j++){
				if(board[i][j] != null) continue;
				//a = new SudokuSquare(i,j);
				board[i][j] = new SudokuSquare(i,j);
				//System.out.println(0);
				
				
			}
		
	}
	
	public boolean isValid(int r, int c, int v){
		
		SudokuSquare [] quadrant1 = {board[0][0],board[0][1],board[1][0],board[1][1]};
		SudokuSquare [] quadrant2 = {board[0][2],board[0][3],board[1][2],board[1][3]};
		SudokuSquare [] quadrant3 = {board[2][0],board[2][1],board[3][0],board[3][1]};
		SudokuSquare [] quadrant4 = {board[2][2],board[2][3],board[3][2],board[3][3]};
		SudokuSquare [] total[] = {quadrant1,quadrant2,quadrant3,quadrant4};
	
		if(v>4||v<0){
			return false;
		}
		for(int i = 0; i<4;i++){
				if(board[i][c].getValue() ==  v/*board[r][c].getValue()*/){
					//System.out.println("error1");
					if(i == r) continue;
					return false;
				}
		}
		for(int j = 0; j<4;j++){
			if(board[r][j].getValue() ==  v/*board[r][c].getValue()*/){
				if(j == c) continue;
				//System.out.println("error2");
				return false;
			}
		}
		
		
		for(int r0 = 0; r0<4; r0++){
			for(int c0 = 0; c0<4;c0++){
				if(total[r0][c0].getRow() == board[r][c].getRow() && total[r0][c0].getColumn() == board[r][c].getColumn()){
					int quadrant = r0;
					//System.out.println("Quadrant " + quadrant + " " + total[r0][c0].getRow() + " " + total[r0][c0].getColumn() + "--" + board[r][c].getRow());
						for(int a = 0;a<4;a++){
							if(total[quadrant][a].getValue()==v){
								if(total[quadrant][a].getColumn()==c && total[quadrant][a].getRow()==r){
									continue;
								}
								//System.out.println(total[quadrant][a].getRow() + " " + total[quadrant][a].getColumn());
								return false;
							}
						}
						
				}
			}
		}
		System.out.println("good to go");
		
		return true;
	}
	
	void enterMove(int r,int c,int v){
		try{
			if(isValid(r,c,v)){
				board[r][c].setValue(v);
				//System.out.println(board[r][c].getColumn());
				
			}else { throw new SudokuException();}
		}catch(SudokuException e){
				
		}
	}
	
	public void reset(){
		for(int r = 0; r<4;r++){
			for(int c = 0; c<4; c++){
				if(board[r][c].isLocked() == false){
					board[r][c].setValue(0);
				}
			}
		}
	}
	
	public SudokuSquare getSquare(int r, int c){
		return board[r][c];
	}
	
	public boolean isFull(){
		for(int r = 0; r<4;r++){
			for(int c = 0; c<4; c++){
				if(board[r][c].getValue()==0){
					return false;
				}
			}
		}
		return true;
	}
	
	
}