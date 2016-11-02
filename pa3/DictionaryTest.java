// ------------------------------------------------
// Authors :
// Jonathan Montgomery, Edited/Assist :  Xinyuan Lu
// Testing implementation of Dictionary.java
// ------------------------------------------------

public class DictionaryTest{

    public static void main(String[] args){
	Dictionary Test = new Dictionary();

	if(Test.isEmpty()==true){
	    System.out.println("Empty Function : SUCCESS\n");
	} else {
	    System.out.println("Empty Function : FAILED\n");
	}

	if(Test.size()==0){
	    System.out.println("Size Function : SUCCESS\n");
	}else{
            System.out.println("Size Function : FAILED\n");
	}

	// Testing insert function
	    Test.insert("jon", "1");
	    Test.insert("cat", "2");
	    Test.insert("program", "3");
	    Test.insert("cool", "4");
	    System.out.println(Test);


	    // Testing size of dictionary which should be 4
	    System.out.println(Test.size());


	    // Delete function tests
            Test.delete("cat");

	    System.out.println(Test);

	    System.out.println(Test.size());

	    // Duplicate key excep test

	        // Test.insert("jon", "5");


	    // Lookup of cool should be a value of 4
	    System.out.println(Test.lookup("cool"));

	   
           // dictionary should be empty after function call			       
	   Test.makeEmpty();
	   System.out.println(Test);
			       
	


	 // More tests	
	     Test.insert("fun", "10");
	     Test.insert("yay", "20");
	     Test.insert("wee", "30");
	     Test.insert("nice", "40");
             Test.insert("word", "50");
	     Test.insert("sweet", "60");

	     System.out.println(Test);
	     // false, 6 items 
	     System.out.println(Test.isEmpty());

	     // nice, value = 40
	     System.out.println(Test.lookup("nice"));

	     Test.delete("wee");
	     Test.delete("fun");
	
	     // value should be 0, since it was removed

	     System.out.println(Test.lookup("fun"));

	     // excep thrown key not found

	     Test.delete("yo");
  
	     Test.makeEmpty();

	     System.out.println(Test);
 
    }
}
