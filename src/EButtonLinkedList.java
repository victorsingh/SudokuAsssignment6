
public class EButtonLinkedList {
	private EraseableButtons head;
	private EraseableButtons track;
	private int po = 0;
	
	public EButtonLinkedList(EraseableButtons n){
		head = n;
	}
	
	
	
	public void append(EraseableButtons x){
		EraseableButtons current = head;
		while (current.getNext()!=null){
			current = current.getNext();
		}
		current.setNext(x);
	}
	
	public SudokuButton getNext(){
		//po++;
		//System.out.print(po);
		if(track == null){
		EraseableButtons current = head;
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
