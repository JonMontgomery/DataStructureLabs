//-----------------------------------------------------------------------------
// Recursion.java
// Template for CMPS 12B pa1.  Fill in the five recursive functions below.
// Jonathan Montgomery
//-----------------------------------------------------------------------------

class Recursion {
   
   // reverseArray1()
   // Places the leftmost n elements of X[] into the rightmost n positions in
   // Y[] in reverse order
   static void reverseArray1(int[] X, int n, int[] Y){
       if(n > 0){ // if there is more than one element, reverse
	   Y[Y.length - n] = X[n-1]; // array length - amount of elements from X to reverse
	   reverseArray1(X, n-1, Y);  // recursive call, decrements n
       }else if(n == 0){ // if no elements, just return
	   return;
       }
       
   }

   // reverseArray2()
   // Places the rightmost n elements of X[] into the leftmost n positions in
   // Y[] in reverse order.
   static void reverseArray2(int[] X, int n, int[] Y){
       if(n > 0){
	   Y[n-1] = X[X.length - n]; // X.length - num of elements to place into Y leftmost
	   reverseArray2(X, n-1, Y); // recursive call
       }else if(n == 0){
	   return;
       }
 
   }
   

   // reverseArray3()
   // Reverses the subarray X[i...j].
   static void reverseArray3(int[] X, int i, int j){
       if(i <= j){
	   int temp = X[j]; // temp var holds X of j
	   X[j] = X[i]; // then set j = i
	   X[i] = temp; // then reverse by setting i equal to j 
	   reverseArray3(X, i+1, j-1); // recursive call to move i forward, and j back
       }else if(i >= j){
	   return;
       }

   }
   
   // maxArrayIndex()
   // returns the index of the largest value in int array X
   static int maxArrayIndex(int[] X, int p, int r){
       if(p == r){ // if only one element return that elements
	   return r;
       }else{
	   int q = (p+r)/2; // split array in half
	   int start = maxArrayIndex(X, p, q); // start indices called recursively to split
	   int end = maxArrayIndex(X, q+1, r);  // end indices called recursively to split
	   if(X[start] > X[end]){ // if the values of start's indices are greater than end, max
	     return start;
	 }else {
	     return end; // else end is the max
	 }
       } 
   }
   // minArrayIndex()
   // returns the index of the smallest value in int array X
   static int minArrayIndex(int[] X, int p, int r){
       if(p == r){
	   return r; // opposite of above function
       }else{
	  int q = (p+r)/2;
	  int start = minArrayIndex(X, p, q);
	  int end = minArrayIndex(X, q+1, r);
	    if(X[start] < X[end]){
	       return start;
	   }else {
	       return end;
	   }
       }
   }
   
   // main()
   public static void main(String[] args){
      
      int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
      int[] B = new int[A.length];
      int[] C = new int[A.length];
      int minIndex = minArrayIndex(A, 0, A.length-1);
      int maxIndex = maxArrayIndex(A, 0, A.length-1);
      
      for(int x: A) System.out.print(x+" ");
      System.out.println(); 
      
      System.out.println( "minIndex = " + minIndex );  
      System.out.println( "maxIndex = " + maxIndex );  

      reverseArray1(A, A.length, B);
      for(int x: B) System.out.print(x+" ");
      System.out.println();
      
      reverseArray2(A, A.length, C);
      for(int x: C) System.out.print(x+" ");
      System.out.println();
      
      reverseArray3(A, 0, A.length-1);
      for(int x: A) System.out.print(x+" ");
      System.out.println();  
      
   }
   
}
/* Output:
-1 2 6 12 9 2 -5 -2 8 5 7
minIndex = 6
maxIndex = 3
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
*/
