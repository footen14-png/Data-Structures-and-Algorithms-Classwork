package Stackproj;
import java.io.*;
import java.util.*;
//declares Stack class whith generic type T
 public class CustomStack<T> {
	//declares empty array list
	 ArrayList<T> A;
	 //sets up the value that will serve as the stack's top, -1 for base null case
	 int top=-1;
	 //declares variable for size of arraylist
	 int size;
	 //gives the array list a new size of one specified in the driver class
	 void stack (int size){
		 this.size=size;
		 
		 this.A= new ArrayList<T>(size);
	 }
	 //push method to insert items
	void push(T X) {
		//checks if top is greater than size and notifies user
		if(top+1==size) {
			System.out.println("Stack Overflow");
			
		}
		//if not overflow then increase the top amount
		else {
			//if not overflow then increase the top amount
			top=top+1;
			//if size is bigger than top then set new input variable as the top
			if (A.size()>top) {
				A.set(top, X);
			}
			// otherwise just add variable into the arraylist
			else {
				A.add(X);
			}
		}
		}
	//checks and returns top item
	Object peek() {
		//throw exception if null
		if (top==-1) {
			System.out.println("Stack Underflow");
			throw new NoSuchElementException();
		}
		//otherwise return top value
		else {
			return A.get(top);
		}
	}
	//similar to peek, but this time eliminates the top item
	void pop() {
		//same exception
		if (top==-1) {
			System.out.println("Stack Underflow");
			throw new NoSuchElementException();
		}
		//displays top item 
		else {
			System.out.println("Top Item:"+ A.get(top)+" has been removed from the stack");
			//removes top item and decreases size of arraylist
			top--;
			size--;
			}
	}
	//checks if array is empty
	boolean isEmpty() {
System.out.println("Displaying if the stack is empty (T or F):");
//if top==-1 return true else return false
		return top==-1;
	}
	//methoid to change stack values into a readable string for display
	 public String toString()
	    {
	 
	        String Ans = "[";
	        //loops for each item and individually turns each one to a string then adds them together
	        for (int i = 0; i < top; i++) {
	            Ans += String.valueOf(A.get(i)) + ", ";
	        }
	 
	        Ans += String.valueOf(A.get(top));
	        Ans+= "]";
	        //prints final constructed string
	        return Ans;
	    }
	 //returns size of string
	int size() {
		System.out.println("Number of items in the stack:");	
		//simply reads and returns the current size value
		return size;
	}
	//clears array
	public void clear() {
		A.clear();
	}
	//rearanges string so that the items are in reverse order
	public String reverse() {
		//uses for loop for the length of the array to pick out and replace each individual item in reverse order
		for (int i = 0, j = A.size() - 1; i < j; i++) {
	        A.add(i, A.remove(j));
	      	    }
		//makes it a string then returns
	        return A.toString();

	}
}
