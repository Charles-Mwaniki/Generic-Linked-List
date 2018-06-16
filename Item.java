
/*
 * Name:
 * Student ID:
 */

/* Class Item<T>
 * Generic class that represents the user desired element type
 * 
 * 
 */
//Item<T> extends the Comparable<T> class so as to access its compareto() method in this class
public class Item<T extends Comparable<T>> {

	private T data;//element

	private Item<T> next;//link to next element
	
	//initializes the data members(nodes) to null
	public Item() {
		this.data = null;
		this.next = null;
	}

//initializes the data members(nodes) to argument passed
	public Item(T obj) {
		this.data = obj;
		this.next = null;
	}
	//setter method initializes the data to argument passed
	public void setData(T data) {
		this.data = data;
	}
	//setter method initializes the next node to the argument passed
	public void setNext(Item<T> next) {
		this.next = next;
	}
//getter method to return the next node
	public Item<T> getNext() {
		return next;
	}
//getter method to return the data value
	public T getData() {
		return data;
	}


}