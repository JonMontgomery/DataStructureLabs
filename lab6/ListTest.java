//-----------------------------------------------------------------------------
// IntegerListTest.java
// A test client for the IntegerList ADT from website
//-----------------------------------------------------------------------------

public class IntegerListTest{

    public static void main(String[] args){
	IntegerList A = new IntegerList();
	IntegerList B = new IntegerList();
	int i, j;

	for(i=1; i<=100; i++){
	    j = i*i;
	    A.add(i, j);
	    B.add(i, (j+i)/2);
	}

	System.out.println(A);
	System.out.println();
	System.out.println(B);
	System.out.println();
	System.out.println(A.equals(B));
	System.out.println();
	System.out.println(A.size());
	System.out.println();
	System.out.println(B.size());
	System.out.println();

	for(i=1; i<=10; i++){
	    A.remove(9*i);
	    B.remove(8*i-3);
	}

	System.out.println(A.size());
	System.out.println();
	System.out.println(B.size());
	System.out.println();
	System.out.println(B.get(37));
 
}
