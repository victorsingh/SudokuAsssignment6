
public class SudokuSquareLinkedList {
		private SudokuSquareNode head;
		private SudokuSquareNode track;
		private int po = 0;
		
		public SudokuSquareLinkedList(SudokuSquareNode n){
			head = n;
			
		}
		
		
		
		public void append(SudokuSquareNode x){
			SudokuSquareNode current = head;
			while (current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(x);
		}
		
		public SudokuSquare getNext(){
			//po++;
			//System.out.print(po);
			if(track == null){
			SudokuSquareNode current = head;
			track = current;
			//System.out.println(track.getData());
			return track.getData();
			}else{
				track = track.getNext();
			}
			//System.out.println(track.getData());
			return track.getData();
			
		}
}
