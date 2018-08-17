import java.util.ArrayList;
public class Stack<T> {

	private ArrayList< T > elements; 
	public Stack() {
		this( 1 ); 
	} 
	public Stack( int i ) {
		elements = new ArrayList< T >(i); 
	}
	public void push(T p) {
		System.out.println(p);
		elements.add(p); 
	} 
	public T pop() {
		if ( elements.isEmpty() ) 
			throw new EmptyStackException();
		return elements.remove( elements.size() - 1 );
	} 
	public String toString(){
		return elements.toString();
	} 
}