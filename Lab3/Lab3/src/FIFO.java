import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {
	
	private ArrayList<Object> queue;
	private int longestQueue;
	
	public FIFO() {
		queue = new ArrayList<>();
		longestQueue = 0;
	}
	
	@Override
	public boolean equals(Object f) throws ClassCastException {
		if(this.isEmpty()) {
			return false;
		}
		
		if(f.getClass() != this.getClass()) {
			throw new ClassCastException();
		}
				
		if(queue.size() != ((FIFO)f).getQueue().size()) {
			return false;
		}
		
		for(int i = 0; i < this.size(); i++ ) {
			

			//System.out.format("i: %d, value of this[i]: %d, type of f[i]: %d\n", i, Integer.valueOf(this.getQueue().get(i).toString()), Integer.valueOf(((FIFO)f).getQueue().get(i).toString()));
			
			if((this.getQueue().get(i) != null ? Integer.valueOf(this.getQueue().get(i).toString()) : null) != 
				(((FIFO)f).getQueue().get(i) != null ? Integer.valueOf(((FIFO)f).getQueue().get(i).toString()) : null) ) {		//Might be a pain in the ass to look at, but in essence: if the current object is'nt null, it is cast
																																//to a string and then an integer, If it is null, it just stays as a null. Then it compares the value with
																																//the same operation for the other object, f.
				return false;
			}
			
		}
		
		return true;
	}
	
	public ArrayList<Object> getQueue(){
		return queue;
	}
	
	@Override
	public void add(Object arg0) {

		queue.add(arg0);
		
		longestQueue = longestQueue > queue.size() ? longestQueue : queue.size();
		
	}

	@Override
	public Object first() throws NoSuchElementException {
		
		try {
			return queue.get(0);
		} catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int maxSize() {
		return longestQueue;
	}

	@Override
	public void removeFirst() throws NoSuchElementException {
		try {
			queue.remove(0);
		} catch (IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Queue: ");
		
		for(Object currentObject : this.queue) {
			buffer.append(String.format("(%s) ", currentObject == null ? null : currentObject.toString()));
		}
		
		return buffer.toString();
	}

}
