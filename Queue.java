import java.util.ArrayList;
public class Queue<T> {

	private ArrayList< T > elements; 
	public Queue() {
		this( 1 ); 
	} 
	public Queue( int i ) {
		elements = new ArrayList< T >(i); 
	}
	public void push(T p) {
		elements.add(0,p); 
	} 
	public T pop() {
		if ( elements.isEmpty() ) 
			throw new EmptyQueueException();
		return elements.remove(0);
	}

	public String toString(){
		return elements.toString();
	} 
}