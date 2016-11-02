// -----------------------------------------------
// Dictionary.java implementation file
// Authors :
// Xinyuan Lu, Edited/Assist : Jonathan Montgomery
// -----------------------------------------------



public class Dictionary implements DictionaryInterface{

   Node start;
   Node current;
   int number;/*The index goes from 0 to somewhere*/

   public Dictionary(){
      start = current = null; // assert nodes to be null at intilization
      number = 0;
   }

    // define a class of nodes with string key/value
    private class Node{ 
      Node previous;
      Node next;
      String key;
      String value;
      private Node(String construct_key, String construct_value){
         key = construct_key;
         value = construct_value;
         next = null;
         previous = null;
      }
   }

   // isEmpty()
   // pre: none
   // returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty(){
      if(number == 0){
         return true;
      }
      return false;

   }

   // size()
   // pre: none
   // returns the number of entries in this Dictionary
   public int size(){
      return number;
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){
      //System.out.println("looking up for: " + key);
      Node myNode = findKey(key);
      if(myNode != null){
         return myNode.value;
      }
      return null;
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws DuplicateKeyException{
      if(findKey(key) != null){
	 throw new DuplicateKeyException(); // value matches that of a value with an existing key
      }else{
         if(current != null){
            current.next = new Node(key, value);
            current.next.previous = current; 
            current = current.next;
         }else{
            start = current = new Node(key, value);
         }
         number += 1;
         
      }
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException{
      Node myKey = findKey(key);
      if(myKey == null){
         throw new KeyNotFoundException();
      }else{
         if(myKey.next != null && myKey.previous != null){
            myKey.previous.next = myKey.next;
            myKey.next.previous = myKey.previous;
         }else if(myKey.previous == null && myKey.next != null){
            start = myKey.next;
            myKey.next.previous = null;
         }else if(myKey.previous != null && myKey.next == null){
            current = myKey.previous;
            myKey.previous.next = myKey.next;
         }else{
            start = current = null;
         }
         number -= 1; 

      }
   }


   // makeEmpty()
   // pre: none
   public void makeEmpty(){
      start = current = null;
      number = 0;
   }

   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
      String returnStr = "";
      Node idx = start;
      for(int i = 1; i <= number; i++){
         returnStr += idx.key;
         returnStr += " ";
         returnStr += idx.value;
         returnStr += "\n";
         idx = idx.next;
      }

      return returnStr;

   }

   
   private Node findKey(String key){
      Node idx = start;
      for(int i = 1; i <= number; i++){ // parses through index and compares numbers to key to find a match
         if(idx.key.equals(key)){
            return idx;
         }else{
            idx = idx.next;
         }
      }
      return null;
   }
}

