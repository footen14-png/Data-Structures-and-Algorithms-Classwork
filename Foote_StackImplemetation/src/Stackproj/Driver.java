package Stackproj;
//Java Program to Implement Stack in Java Using Array and

//Importing input output classes
import java.io.*;
//Importing all utility classes
import java.util.*;
public class Driver{

	// main driver method
	public static void main(String[] args)
	{
//declares integer stack based on CustomStack class
	CustomStack<Integer> s1 = new CustomStack<Integer>();
	//assigns length to stack
	s1.stack(3);
		// Pushing elements to integer stack - s1
		// Element 1 
		s1.push(25);
		// Element 2 
		s1.push(376);
		// Element 3
		s1.push(58);

		
	//prints new stack with the new elements
		System.out.println(
			"s1 after pushing 25, 376 and 58 :\n" + s1);
		//peeks current top element
		System.out.println("peeking top element of stack: "+s1.peek());
		
//flips the stack using the reverse method
		System.out.println("Printing Reverse of current stack"+ s1.reverse());
		//alerts user of pop
		System.out.println("popping same item out of the stack");
		//removes top item
		s1.pop();
		//displays size after the pop
		System.out.println("New size of stack is " + s1.size());
		//shows stack after pop
		System.out.println("s1 after pop :\n" + s1);
		//checks if stack is empty now
		System.out.println("Checking if Stack is empty: "+s1.isEmpty());
		//clears all items from the stack
		s1.clear();
		System.out.println("Stack has been cleared");
		
		//space between stacks
		System.out.println("");
		System.out.println("New stack with Strings:");
		//new stack with string items rather than integers
		CustomStack<String> s2 = new CustomStack<>();
		//checks before stack is full
		System.out.println("Checking if Stack is empty: "+s2.isEmpty());
		// Pushing elements to string stack - s2
		s2.stack(4);
		// Element 1 
		s2.push("car");
		// Element 2
		s2.push("tree");
		// Element 3 
		s2.push("house");
		// Element 4
		s2.push("phone");
		//shows stack
	System.out.println(
			"\ns2 after pushing 4 elements :\n" + s2);

		//shows top element
	System.out.println("peeking top element of stack: "+s2.peek());
		//reverse the order of this stack
		System.out.println("Printing Reverse of current stack"+ s2.reverse());
		//remove top item from the stack
		System.out.println("popping same item out of the stack");
		s2.pop();
		//show new size of the stack
		System.out.println("New size of stack is " + s2.size());
		//peeks new top element
		System.out.println("peeking new top element of stack : "+s2.peek());
		//checks if empty again
		System.out.println("Checking if Stack is empty: "+s2.isEmpty());
		System.out.println();
	
		//clears stack
		s2.clear();
		System.out.println("Stack has been cleared");
	
	
		
	
		
	}
}
