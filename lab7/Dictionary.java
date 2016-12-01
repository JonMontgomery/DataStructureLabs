// Cmps12M - Lab 7 
// Implementing BST Dictionary in Java based on C version on website
// Jonathan Montgomery - jopmontg@ucsc.edu


public class Dictionary implements DictionaryInterface{

    private class Node{
	Obj item;
	Node left;
	Node right;

	Node(Obj y){
	  item = y;
	  left = null;
	  right = null;

	}
    }

    private class Obj{
	String key;
	String value;

	Obj(String x, String y){
	    key = x;
	    value = y;
	}
    }

    private Node Root;
    private int Items;

    public Dictionary(){
	Root = null;
	Items = 0;
    }

    private Node findKey(Node Root, String k){
	if(Root == null || Root.item.key.equals(k)){
	    return Root;
	}
	if(Root.item.key.compareTo(k)>0){
	    return findKey(Root.left, k);
	} else {
	    return findKey(Root.right, k);

	}

    }

    private Node findParent(Node New, Node Root){
	Node P = null;
	if(New!=Root){
	    P = Root;
	    while(P.left!=New && P.right!=New){
		if(New.item.key.compareTo(P.item.key)<0){
		    P = P.left;
		}
	     else {
		P = P.right;
	     }
	    }
	}
	return P;
    }

    private Node findLeftmost(Node R){
	Node L = R;
	if(L!=null){
	    for(; L.left!=null; L=L.left){
		return L;
	    }
	}
	return L;
    }

    public boolean isEmpty(){
	return(Items == 0);
    }

    public int size(){
	return Items;
    }

    public String lookup(String key){
	Node N = findKey(Root, key);
	return(N==null ? null : N.item.value);
    }

    public void insert(String key, String value) throws DuplicateKeyException{
	Node A = new Node(new Obj(key, value));
	Node B = Root;
	Node C = null;
	while(B!=null){
	    C = B;
	    if(B.item.key.compareTo(key)>0){
		B = B.left;
	    } else {
		B = B.right;
	    }
	}
    if(C==null){
	Root = A;	
    } else{
	if(C.item.key.compareTo(key)>0){
	    C.left = A;
	}
	else {
	    C.right = A;
	}
      }
       Items++;
    }

    public void delete(String key) throws KeyNotFoundException{
	Node N = findKey(Root, key);
	Node B = findParent(N, Root);
	if(N.left == null && N.right == null){
	    if(N == Root){
		Root = null;
	    } else {
	    Node A = findParent(N, Root);
	    if(A.right == N){
		A.right = null;
	    }
	    else {
		A.left = null;
	    }
	    }
	}
	else if(N.right==null){
		if(N == Root){
		    Root = N.left;
		}
		else{
		    if(B.right == N){
			B.right = N.left;
		    }
		    else {
			B.left = N.left;
		       }
		}
	}
       else if(N.left==null){
	   if(N == Root){
	       Root = N.right;
	   }else{
	       if(B.right == N){
		   B.right = N.right;
	       }else{
		   B.left = N.right;
	       }
	   }
       } else {
	    Node C = findLeftmost(N.right);
	    N.item.key = C.item.key;
	    N.item.value = C.item.value;
	    Node D = findParent(C, N);
	    if(D.right == C){
		D.right = C.right;
	    }
	    else {
		D.left = C.right;
	    }
       }
	  Items--;
    }

    public void makeEmpty(){
	Root = null;
	Items = 0;
    }

    void printInOrder(Node N){
	if(N!=null){
	    printInOrder(N.left);
	    System.out.println(N.item.key + " " + N.item.value);
	    printInOrder(N.right);
	}
    }

    public String toString(){
	printInOrder(Root);
	return " ";
    }
}
