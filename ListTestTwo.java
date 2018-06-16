
/*
 * Name:
 * Student ID:
 */

/*
 * Class ListTestTwo
 * Creates new lists and adds new elements to the list
 * Outputs the content of the lists to the screen 
 * 
 */

import java.util.Random;
import java.util.Scanner;
public class ListTestTwo {

	public static void main(String[] args){
		/*
		 * first instance of the linked list
		 */
		//create new listTestOne object of MyIntList class to create a new list
		MyIntList<Integer> listTestOne = new MyIntList<Integer>();
		
		Random randm=new Random();//creates an object of Random class to create random Integers
		Scanner scan=new Scanner(System.in);//[scan object to retrieve user input from the keyboard
		//add 50 random integer values between 0 and 100
		for(int i=1;i<=50;i++){
			listTestOne.add(randm.nextInt(100));//adds random integers to the list between 0 and 10
			//uncomment the following 2 lines if you want to add integers manually
			//int m=scan.nextInt(); //gets an integer from user input
			//listTestOne.add(m); //uncomment this line if you want to add Integers manually
		}

		
		System.out.println(" test one");
		listTestOne.dump();//dump the contents of the List One to the screen
		System.out.println();//create a blank line between screen output
		
		/*
		 * second instance of the linked list
		 */
		//create a second object of MyIntList class to create the second list
		MyIntList<Integer> listTestTwo = new MyIntList<Integer>();
		
		//add 50 random integer values between 0 and 100
		for(int i=1;i<=50;i++){
			listTestTwo.add(randm.nextInt(100));//adds random integers to the list between 0 and 10
			//uncomment the following 2 lines if you want to add integers manually
			//int n=scan.nextInt(); //gets an integer from user input
			//listTestTwo.add(n); //uncomment this line if you want to add Integers manually
		}
		
		
		System.out.println(" test two");
		listTestTwo.dump();//dump the contents of the List Two to the screen
		System.out.println();//create a blank line between screen output
		
		/*
		 * 
		 * creates an initially empty third list, then one-by-one use getFirst() and
		 *  remove() to take values out of one of the lists, use hasItem()
		 *   to see if that value is in the other list and, if so, add it to the third list. 
		 *  
		 */
		//create an object of MyIntList class to create the third list
		MyIntList<Integer> listTestFinal = new MyIntList<Integer>();
		int j=1;
		while(j<=listTestOne.length()) {//loop between the bounds of the size of the first list
			if(listTestOne.isEmpty() !=true) {//check if list is empty, if not copy integers found in list one and list two
				if(listTestTwo.hasItem(listTestOne.getFirst())== true) {
					listTestFinal.add(listTestOne.getFirst());// add a copy of integers found in both list one and list two
					//listTestTwo.remove(listTestOne.getFirst());// optional, remove elements from both list one and list two
				}
			listTestOne.remove(listTestOne.getFirst());//remove the element in first list to prevent looping over the same integer again
			}
			j++;//loop counter
		}
		
		System.out.println("test final");
		listTestFinal.dump();//dump the contents of the final list to the screen
	
		/*
		 * extra object to test the insert(x) method
		 */
	
		System.out.println();
		System.out.println("The insert(x) method test");
		//The insert(x) method test
		//create an object of MyIntList class to create a new list to test insert(x) method
		MyIntList<Integer> myLL = new MyIntList<>();
    	Random r=new Random();//create object of Random class to create new random integers
    	for(int i=0;i<50;i++) {//add 50 random integers to test the method
            myLL.insert(r.nextInt(100));//add random integers between 0 and 100
            //uncomment the following 2 lines if you want to add integers manually
			//int x=scan.nextInt(); //gets an integer from user input
			//myLL.insert(x); //uncomment this line if you want to add Integers manually
            
    	}
       
        myLL.dump();//dump the contents of the created test list to the screen
        
	}
	
	
	
}
