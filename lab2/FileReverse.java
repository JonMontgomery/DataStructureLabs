// File credit to example code from FileTokens and FileCopy from cs12b website
// Author : Jonathan Montgomery - jopmontg@ucsc.edu - CS12M
// Credit to java function guides on substring / charAt / token

import java.io.*;
 import java.util.Scanner;

class FileReverse{

   public static String stringReverse(String s, int n){
       if(n > 0){
	   // recursive call to get substring of starting index, and then add on first value at index 0
	   return stringReverse(s.substring(1), n-1) + s.charAt(0);
   }else {
       return s;
       }
   }


    public static void main(String[] args) throws IOException{
	
	
	if(args.length < 2){
	    System.out.println("Usage: FileReverse <input file>  <output file>");
	    System.exit(1);
	}

	Scanner in = new Scanner(new File(args[0]));
	PrintWriter out = new PrintWriter(new FileWriter(args[1]));
	
	while(in.hasNextLine() ){
 
	    String line = in.nextLine().trim() + " ";

	    String[] token = line.split("\\s+");
	   
	    for(int i = 0; i<token.length; i++){
		out.println(stringReverse(token[i], token[i].length())); // call stringReverse on tokenized list
	    }

	}

	in.close();
	out.close();
    }
}
