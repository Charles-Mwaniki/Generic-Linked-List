
/*
 * Name:
 * Student ID:
 * 
 */

/*
 * Class ListTestOne
 *  Creates tests on our user defined linked list data structure
 */

import java.util.Random;//import the Random class
import java.util.Scanner;// import the Scanner class


public class ListTestOne{
	
	public static void main(String[] args){
		//create new object of MyIntList class to access the data members
		MyIntList<Integer> listTest=new MyIntList<>();
		Random randm=new Random();//creates an object of Random class to create random Integers
		Scanner scan=new Scanner(System.in);//[scan object to retrieve user input from the keyboard
		/*
		 * add a bunch of integer values to an instance
		 * of your linked list
		 * 
		 */
		for(int i=1;i<=10;i++){
			listTest.add(randm.nextInt(10));//adds random integers to the list between 1 and 10
			//listTest.add(scan.nextInt()); //uncomment this line if you want to add Integers manually
		}
	/*
	 * prints an instance of the linked list
	 */
	System.out.println("Dump the contents of the list");
	listTest.dump();// dump the contents of the list to the screen
	
	System.out.println("Enter a number to remove from the list");
	int n=scan.nextInt();//get the integer from the keyboard
	//remove some value from the list
	listTest.remove(n);
	
	System.out.println("Dump the remaining contents of the list");
	//print the remains of the list
	listTest.dump();// dump the contents of the list to the screen
	
		}
	
	
}
