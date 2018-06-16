
/*
 * Name:
 * Student ID:
 * 
 */


/*
 * Class MyIntList<T>
 * generic class that defines operations on our user defined list data structure
 */

//Item<T> extends the Comparable<T> class so as to access its compareto() method in this class
public class MyIntList<T extends Comparable<T>> {

	public Item<T> head;//first element in the list: head
	public Item<T> last;//last element in the list: tail
	private int count=0;// size of the list when empty

	
	/*
	 * Class constructor
	 * 
	 */
		
	public MyIntList() {
		// TODO Auto-generated constructor stub
		this.head=null;//initialize the head of the list to null
		this.last = this.head;//initialize the tail of the list to null
	}


	/*add(int x) - adds to the head of the list a new node 
	 * with the value of the argument x.
	 */

	public void add(T data) {
		//create an object of the class Item<T> to access its data members
		Item<T> newData = new Item<T>(data);//add an element to the head of the list
		if (this.head == null) {//check if head is empty, add the new data to head if true
			this.head = newData;//initialise head to new data
			this.last = this.head;
		} else {
			this.last.setNext(newData);//set the data as the last element on the list
			this.last = newData;//set the last element as the object of data
		}
		count++;//increment the size of the list after addind an element
	}


	
	/* 
	 * hasItem(int x) - returns a boolean value that is true if the 
	 * linked list contains an Item whose value
		is x; false otherwise.
	 */
	
	public boolean hasItem(T data){
		//set a new object of the Item<T> class as the  head object
		Item<T> item=head;
		while (item != null) { //check if item is empty, if not, test if value of item is equal to value of data argument
			if (item.getData().equals(data))
				return true;
			item = item.getNext();//go to the next element in the list if item is not equal to value of data argument
		}
		return false; // if no data argument is not found in the list return false
	}
	
	
	/*
	 * remove(int x) - finds the first Item whose value is x and 
	 * removes that Item without affecting the
	 * order of the remaining Items in the list.
 	 * If the list has no Item with that value, the method should
	 * leave the list unchanged.
	 */
	public void remove(T data) {
		//set a new object of the Item<T> class as the  head object
		Item<T> current = head;
		if (this.head.getData().equals(data)) {//check if head equals to value of data argument 
			if (this.head.getNext() == null) {//check if the next element after head is not null
				//create a new Item<T> object to add data argument to the list
				Item<T> newNode = new Item<T>(data);
				this.head.setData(null);//set the value of head to null
				this.head = newNode;//set the head object to the value of Item<T> object
				this.last = this.head;//set the last element in the list to the head object
				
			} else {
				this.head.setData(null);//set the head object to null
				this.head = this.head.getNext();//initialise the head object to the value of the next element object
				count=count-1;//decrement the size of the list after removing an element from list
			}
		} 
		else {
			boolean wasDeleted = false;
			while (!wasDeleted) {
				Item<T> currentNext = current.getNext();
				if (currentNext.getData().equals(data)) {
					currentNext.setData(null);
					current.setNext(currentNext.getNext());
					currentNext = null;
					wasDeleted = true;
					count=count-1;//decrement the size of the list after removing an element from list
				} else {
					current = current.getNext();
				}
			}
		}
	}
///End of remove()


/*
 * length() - returns a count of the number of
 *  Items in the linked list.
 */
	
	public int length(){	
		return count;//return the size of the list
	}
	
///End of count
	
	
/*
 * isEmpty() - returns true if length() would return 0;
 *  false otherwise.
 * 
 */
	public boolean isEmpty(){
	    if (length()==0) // if head is empty return true else false 
	      return true;//true if list has no elements
	    else
	      return false;//false if the list has elements
	}
	
///End of isEmpty
	
/*
 * getFirst() - returns the data value stored in the first Item (i.e. the head),
 *  or -1 if the list is empty.	
 */
	public int getFirst() {
	      if(isEmpty()==false)//if list is not empty
	    	  return (Integer) head.getData();// return the value of the first element in the list
	      else
	    	  return -1;//else return -1
	   }
///End of getFirst
	

/*
 * dump() - for each Item in the list, print to the screen (i.e. System.out)
 *its data value on a line by itself, in the order the Items appear in the list.	
 */

	public void dump() {
		boolean checks = false;//checks variable to act as counter flag
		//create an Item<T> object and initialise it to value of head object
		Item<T> element = head;
		while (!checks) {//loop through all the elements in the list
			if (element != null) {// head is not null
				if (element.getNext() != null) {//if nest element after head is not null
					System.out.printf("%s\n",element.getData().toString());	//output to screen the value of the element 
					element = element.getNext();//get the next element after the printed one
				} else {
					System.out.printf(element.getData().toString());//print the elements in the list if the last item is reached
					checks = true;//set the check flag to true to stop the loop
				}
			} 
		}
		System.out.println();
	}

	/*
	 * insert(x) - assumes the list is sorted and inserts a new Item with value x 
	 * immediately in front of the first item of the list whose value is not less than x. 
	 */

	public void insert(T data) {//pass Integer of datatype T
		Item<T> new_data=new Item<>(data);// create new Item<T> object to add a new Integer to the list
		count++;//increment the list counter whenever we add an Integer to the list
	    Item<T> temp = head; // temp object of Item<T> to hold the value of head
	    Item<T> previous = null;//set the previous element to null
	    
	    //compare the value of temp obj and the new_data object then swap if not equal
	    while (temp != null && temp.getData().compareTo(new_data.getData())<0) {
	        previous = temp;
	        temp = temp.getNext();//get the next element in the list
	    }
	    //check if there is previous value,if not set the new_data to value of head
	    if (previous == null) {
	    	new_data.setNext(head);//set the next element as the value of head object 
	        head = new_data;//initialise the head object to the value of new_data object
	    } else {
	    	new_data.setNext(temp);//set the next element of new_data to value of temp object
	        previous.setNext(new_data);//set the previous element in the list to value of new_data object
	    }
	}//insert 

}///End of class

