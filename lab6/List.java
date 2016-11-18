// List Generic ADT
// Based on IntegerListADT on webpage
// Jonathan Montgomery - Lab 6

public class List<T> implements ListInterface<T> {

      private class Node {
	  T item;
	  Node next;

	  Node(T x){
	      item = x;
	      next = null;
	  }
      }


      private Node head;
      private int numItems;


      public List(){
          head = null;
	  numItems = 0;

      }


      private Node find(int index){
	  Node N = head;
	  for(int i = 1; i < index; i++){
	      N = N.next;
	  }
	  return N;
      }

      public boolean isEmpty(){
	  return(numItems == 0);
      }

      public int size() {
	  return numItems;
      }

      public T get(int index) throws ListIndexOutOfBoundsException {
      
	  Node N = find(index);
	  return N.item;
      }

      public void add(int index, T newItem) {
	
	  if(index==1){
	      Node N = new Node(newItem);
	      N.next = head;
	      head = N;
	  }else{
	      Node P = find(index-1); // at this point index >= 2
	      Node C = P.next;
	      P.next = new Node(newItem);
	      P = P.next;
	      P.next = C;
	  }
	  numItems++;
      }

      public void remove(int index){
	  if(index==1){
	      Node N = head;
	      head = head.next;
	      N.next = null;
	  }else{
	      Node P = find(index-1);
	      Node N = P.next;
	      P.next = N.next;
	      N.next = null;
	  }
	  numItems--;
      }

      public void removeAll(){
	  head = null;
	  numItems = 0;
      }

      public String toString(){
	  StringBuffer sb = new StringBuffer();
	  Node N = head;

	  for( ; N!=null; N=N.next){
	      sb.append(N.item).append(" ");
	  }
	  return new String(sb);
      }


      public boolean equals(Object rhs){
	  boolean eq = false;
	  List<T> R = null;
	  Node N = null;
	  Node M = null;

	  if(this.getClass()==rhs.getClass()){
	      R = (List<T>)rhs;
	      eq = ( this.numItems == R.numItems );

	      N = this.head;
	      M = R.head;
	      while(eq && N!=null){
		  eq = (N.item == M.item);
		  N = N.next;
		  M = M.next;
	      }
	  }
	  return eq;
      }



}
