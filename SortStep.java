import java.util.*;

/**
 *  Driver program for the Sorts class.
 */

public class SortStep{
  private Scanner console;
  private ArrayList <Integer> myArray;
  private Sorts mySorts;
  private String listType;

  /**
   *  Constructor for the SortStep object
   */
  public SortStep(){
    console = new Scanner(System.in);
    mySorts = new Sorts();
    myArray = null;
    listType = "Integer";
  }

  /**
   *  Asks the user to select a sorting algorithm, fills the array
   *  with an amount of random integer data chosen by the user, calls
   *  the sorting algorithm, and gives an option of printing out the
   *  data after it has been sorted.
   */
  public void sortMenu(){
    String choice;
    String print;

    do{
      System.out.println();
      System.out.println("Sorting algorithm menu");
      System.out.println();
      System.out.println("(1) Bubble sort");
      System.out.println("(2) Selection sort");
      System.out.println("(3) Insertion sort");
      System.out.println("(4) Recursive mergesort");
      System.out.println("(5) Fill with Integers");
      System.out.println("(6) Sequential Search");
      System.out.println("(7) Binary Search");
      System.out.println("(Q) Quit");
      System.out.println();
      System.out.print("Choice ---> ");
      choice = console.next() + " ";
      if ('1' <= choice.charAt(0) && choice.charAt(0) <= '7'){
        System.out.println();

        mySorts.setStepCount(0);

        switch (choice.charAt(0)){
            case '1':
              resetArray();
              mySorts.bubbleSort(myArray);
              break;
            case '2':
              resetArray();
              mySorts.selectionSort(myArray);
              break;
            case '3':
              resetArray();
              mySorts.insertionSort(myArray);
              break;
            case '4':
              resetArray();
              int last = myArray.size() - 1;
              mySorts.mergeSort(myArray, 0, last);
              break;
            case '5':
        	  listType = "Integer";
              break;    
            case '6':
            System.out.println("What number are you searching for?");
            int n = console.nextInt();
            System.out.println(mySorts.sequentialSearch(myArray, n));
            
            break; 
            case '7':
            System.out.println("What number are you searching for?");
            int num = console.nextInt();
            System.out.println(mySorts.binarySearch(myArray, num));
            
            break;
            
           
        }

        if ('1' <= choice.charAt(0) && choice.charAt(0) <= '4'){
        	System.out.println();
        	System.out.println("Array sorted to:");
	        screenOutput();
	        System.out.println();
	        System.out.println("# steps = " + mySorts.getStepCount());
	        System.out.println();
        }
        if('6' <= choice.charAt(0) && choice.charAt(0) <= '7'){
            System.out.println();
            System.out.println("Number of Steps =" + mySorts.getStepCount());
        }
      }
    } while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
  }

  /**
   *  Initializes myArray with random integers in the range
   *  1..largestInt
   *
   * @param  numInts     number of integers to generate (size of
   *      myArray)
   * @param  largestInt  largest possible random integer to create
   */
  private void fillArrayWithInts(){
    
    System.out.print("How many numbers do you wish to generate? ");
    int numInts = console.nextInt();
    System.out.print("Largest integer to generate? ");
    int largestInt = console.nextInt();
    
    Random randGen = new Random();
    myArray = new ArrayList <Integer>();

    for (int loop = 0; loop < numInts; loop++){
      Integer x = new Integer(randGen.nextInt(largestInt) + 1);
      myArray.add(x);
    }
  }

  /**
   *  reset the array for the next sort
   */
  private void resetArray(){
    if (myArray == null || listType.equals("Integer")){
    	fillArrayWithInts();
    }

    System.out.println();
    System.out.println("Array is reset to:");
    screenOutput();
  }

  /**
   *  prints out the contents of the array in tabular form, 12 columns
   */
  private void screenOutput(){
    for (int loop = 0; loop < myArray.size(); loop++){
      if (loop % 12 == 0){
        System.out.println();
      }
      System.out.print(myArray.get(loop) + "  ");
    }
    System.out.println();
  }

  
}
