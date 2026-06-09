
import java.util.*;//O(1)
public class Mergesort {//O(1)
	public static void main(String[] args) {//O(1)
	
		// creating scanner to take inputs for the array that is to be created
		Scanner scanner = new Scanner(System.in);//O(1)
		//input for size of array
		System.out.println("Please specify size of array: ");//O(1)
		 int size=scanner.nextInt();//O(1)
		 //implementing input size based on whether the array will be int or string based in the future
		 String[] stringArray = new String[size];//O(1)
			int[] intArray=new int[size];//O(1)
			//asks user to specify data type
		System.out.println("Please specify data type of array (Integer or String): ");//O(1)
		String type = scanner.next();//O(1)
		//executes different code based on which type of array was chosen 
		//below is the string variant
		if(type.equals("String")|| type.equals("STRING")|| type.equals("string")){//O(1)
			//unique text for first input
			System.out.println("Please input the first value of the Array: ");//O(1)
			stringArray[0] = scanner.next();//O(1)
			//for loop that runs for the length of the size input earlier
			for(int i=0; i<size-1; i++) {//O(n)
				//if statement to detect when the last value is input and executes the sorting method
				if(i==size-2) {//O(n)
					System.out.println("Please input the final value:  ");//O(n)
					stringArray[i+1] = scanner.next();//O(n)
					//shows original array for confirmation/comparison
					System.out.println("Your current array is:  " + Arrays.toString(stringArray));//O(n)
					//shows that sorting is being executed
					System.out.println("Sorting array...");//O(n)
					//displays new sorted array                                        //calls up merge function for strings so that is properly sorted and displayed in the printed line
					System.out.println("Your sorted array is now:  " + Arrays.toString(mergeSortString(stringArray)));//O((n^2)*log(n))
				
				}
				//continues loop so that all inputs can be inserted
				else {//O(n)
				System.out.println("Please input the next value:  ");//O(n)
				stringArray[i+1] = scanner.next();//O(n)
				}
			}
		
		}
		//second case where the data type is an integer
		else if (type.equals("INTEGER")|| type.equals("integer")|| type.equals("int")|| type.equals("Integer")){//O(1)
			//same process for input as the string array, just the respective data types are switched over to int
			System.out.println("Please input the first value of the Array: ");//O(1)
			stringArray[0] = scanner.next();//O(1)
			//same for loop as in the string variant
			for(int i=0; i<size-1; i++) {//O(n)
				//if statement to deliberate difference between the middle inputs and the final one
				if(i==size-2) {//O(n)
					System.out.println("Please input the final value:  ");//O(n)
					intArray[i+1] = scanner.nextInt();//O(n)
					//shows current array
					System.out.println("Your current array is:  " + Arrays.toString(intArray));//O(n)
					System.out.println("Sorting array...");//O(n)
					//gets value of how many times the original array must be divided and resorted until it can be re printed
					 int compCount = mergeSortInt(intArray);//O((n^2)*long(n))
					System.out.print("Your sorted array is now:  ");
					//now displays the new array calculated in the mergeSort method that was also used to compute the number of divisions
					printArr(intArray);//O((n^2)*log(n))
				}
				//once again the else statement is used to continue the loop
				else {//O(n)
				System.out.println("Please input the next value:  ");//O(n)
				intArray[i+1] = scanner.nextInt();//O(n)
				}}}
		//special case for undesired inputs
		else {//O(n)
			System.out.println("INVALID VALUE");//O(1)
			
		}
		System.out.println("Thank You for Using array sorter run again if you wish to sort a new array  ");
	}
	// publicly sorts an array of integers so that the main method can utilize it
	 public static int mergeSortInt(final int[] arr) {//O(n)
	        return mergeSortInt(arr, 0, arr.length - 1);//O(n)
	    }
	 //does the same for the string version of the merge sort
	 public static String[] mergeSortString(final String[] arr) { //O(n)
	        return mergeSortString(arr, 0, arr.length - 1);//O(n)
	    }
	 //function for merge sort of the string that determines how the array should be divided and reordered
	 private static String[] mergeSortString(final String[] arr, final int low, final int high) {//O(n)
	        //checks to see if the array has the same number for the low end and high end, or has no length if so then returns the array with the lowest value
	        if (low == high) {//O(n)
	            String[] A = { arr[low] };//O(n)
	           
	            return A;//O(n)
	        }
	        //creates a mid point in the array by subtracting the ends of each array from each other dividing by 2 and adding the lower end's value back on to get the middle of the array/
	        // the extra math involving subtraction is used so that when the sub arrays are used during the recursion we can get an accurate midpoint between two non zero values
	        int mid = low + (high - low) / 2;//O(n)
	        //recursion occurs here, further dividing the array into as many sections as it needs to
	        String[] arr1 = mergeSortString(arr, low, mid);//O(n*log(n))
	        String[] arr2 = mergeSortString(arr, mid + 1, high);//O(n*log(n))
	 //the alphaMerge function is the function that applies the alphabetical sorting to each sub array/ division
	        String[] arr3 = alphaMerge(arr1, arr2);//O(n*long(n))
	        //once completed returns the final array that is either used in the end result
	        return arr3;
	    }
	 //function that is used to sort alphabetically as mentioned prior
	    static String[] alphaMerge(String[] Arr1, String[] Arr2)//O(n*log(n))
	    {
	    	//gives values to the lengths of each sub array
	        int m = Arr1.length;//O(n*log(n))
	        int n = Arr2.length;//O(n*log(n))
	        //creates new array with the lenght of both arrays
	        String[] Arr3 = new String[m + n];//O(n*log(n))
	 //sets values that will be used to progress the while loops
	        int idx = 0;//O(n*log(n))
	 
	        int i = 0;//O(n*log(n))
	        int j = 0;//O(n*log(n))
	 //while loop used to compare and sort each input alphabetically
	        while (i < m && j < n) {//O((n^2)*log(n)) remove 2 b/c it is coefficient
	            //uses new function to determine which element is alphabetically smaller and placing it in its respective position
	        	if (isAlphabeticallySmaller(//O((n^2)*log(n))
	                    Arr1[i], Arr2[j])) {//O((n^2)*log(n))
	                Arr3[idx] = Arr1[i];//O((n^2)*log(n))
	                i++;//O((n^2)*log(n))
	                idx++;//O((n^2)*log(n))
	            }
	        	//if an element isnt smaller than the one it is being compared too then it holds its place in the new array for the time being
	            else {//O(2(n^2)*log(n)) remove 2 b/c it is coefficient
	                Arr3[idx] = Arr2[j];//O((n^2)*log(n))
	                j++;//O((n^2)*log(n))
	                idx++;//O((n^2)*log(n)))
	            }
	        }
	        //loop is used so that the indexes of the first sub array are aligned with the first values of the new array
	        while (i < m) {//O((n^2)*log(n)) same case for the last while
	            Arr3[idx] = Arr1[i];//O((n^2)*log(n))
	            i++;//O((n^2)*log(n))
	            idx++;//O((n^2)*log(n))
	        }
	        //same goal for alignment with this loop just for the end sub array
	        while (j < n) {//O((n^2)*log(n)) ignore coeffs again
	            Arr3[idx] = Arr2[j];//O((n^2)*log(n))
	            j++;//O((n^2)*log(n))
	            idx++;//O((n^2)*log(n))
	        //returns final sorted output to be displayed in the main driver function
	        }
	            return Arr3;//O((n^2)*log(n))
	    }
	 
	   //boolean values that are used to compare whether two selected elements are alphabetically smaller than the other
	    static boolean isAlphabeticallySmaller(//O((n^2)*log(n))
	        String str1, String str2)//O((n^2)*log(n))
	    {
	        str1 = str1.toUpperCase();//O((n^2)*log(n))
	        str2 = str2.toUpperCase();//O((n^2)*log(n))
	        if (str1.compareTo(str2) < 0) {//O((n^2)*log(n))
	            return true;//O((n^2)*log(n))
	        }
	        return false;//O((n^2)*log(n))
	    }
	 
	 // method for the rest of the math required for the sorting
	 private static int mergeSortInt(final int[] arr, final int low, final int high) {//O(n)
	        int compCount = 0;  // counts number of comparisons made//O(n)

	        // Base case: a segment of length <= 1 is sorted by definition
	        if (arr.length > 1) {//O(n)
	            // Divide the array into two halves
	            int mid = arr.length / 2;//O(n)
	            int[] left = Arrays.copyOfRange(arr, 0, mid);//O(n)
	            int[] right = Arrays.copyOfRange(arr, mid, arr.length);//O(n)

	            // Recursively sort the left and right halves
	            compCount += mergeSortInt(left);//O(n*log(n))
	            compCount += mergeSortInt(right);//O(n*log(n))

	            // Merge the sorted halves
	            int i = 0, j = 0, k = 0;//O(n*log(n))
	            while (i < left.length && j < right.length) {//O((n^2)*log(n))
	                if (left[i] <= right[j]) {//O((n^2)*log(n))
	                    arr[k++] = left[i++];//O((n^2)*log(n))
	                } else {//O((n^2)*log(n))
	                    arr[k++] = right[j++];//O((n^2)*log(n))
	                }
	                compCount++;//O((n^2)*log(n))
	            }
	            //aligns halves with new array again
	            while (i < left.length) {//O((n^2)*log(n))
	                arr[k++] = left[i++];//O((n^2)*log(n))
	            }
	            while (j < right.length) {//O((n^2)*log(n))
	                arr[k++] = right[j++];//O((n^2)*log(n))
	            }
	        }
	        //returns number of comparisons that will be used to order to fulfill the data type requirement needed for the public version of the function
	            return compCount;//O((n^2)*log(n))
	        }
	 //function is designed to print the array made in the private method
	 public static void printArr(int[] arr) {//O((n^2)*log(n))
	        System.out.print("[");//O((n^2)*log(n))
	        //lists array out by individual element based on the new sorted array
	        for (int i = 0; i < arr.length; i++) {//O((n^2)*log(n)); o notation stays the same because this would essentially make the loops in the driver act like 2n^2 which coefficients can be ignored
	            System.out.print(arr[i]);//O((n^2)*log(n))
	            if (i < arr.length - 1) {//O((n^2)*log(n))
	                System.out.print(", ");//O((n^2)*log(n))
	            }
	        }
	        System.out.println("]");//O((n^2)*log(n))
	    }
}//final time complexity of code is calculated to be O((n^2)*log(n))
// i came to this conclusion because the code remained at O(1) until each of the array's
//respective for loops are called in which then the complexity rises to O(n).
//following this, within each of these loops functions that involve both a number of recursion and while loops are called
//which means that the while loops up the complexity of each if statement to n^2 on top of being multiplied by the recursion's log(n)
//this means by the end the result, while neglecting a few coeffecients, come to be O((n^2)*log(n)).
