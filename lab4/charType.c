
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>

#define MAX_STRING_LENGTH 100

void extract_chars(char* s, char* a, char* d, char* p, char* w);

int main(int argc, char* argv[]){
  FILE* in;
  FILE* out;
  int numLine = 1;
  char* line;
  char* alpha_num;
  char* decimal;
  char* punc;
  char* space;

  if(argc != 3){
    printf("Usage: %s input-file output-file\n", argv[0]);
    exit(EXIT_FAILURE);

  }

  if( (in=fopen(argv[1], "r"))==NULL){
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }

  if( (out=fopen(argv[2], "w"))==NULL){
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);

  }

  line = calloc(MAX_STRING_LENGTH+1, sizeof(char));
  alpha_num = calloc(MAX_STRING_LENGTH+1, sizeof(char));
  decimal = calloc(MAX_STRING_LENGTH+1, sizeof(char));
  punc = calloc(MAX_STRING_LENGTH+1, sizeof(char));
  space = calloc(MAX_STRING_LENGTH+1, sizeof(char));
  assert(line!=NULL && alpha_num!=NULL && decimal!=NULL && punc!=NULL && space!=NULL);
  

  while( fgets(line, MAX_STRING_LENGTH, in)!= NULL){
    extract_chars(line, alpha_num, decimal, punc, space);
    
    fprintf(out, "%s%d%s\n", "Line", numLine, " has : ");

   if((int)strlen(alpha_num)>1){    
     fprintf(out, "%d%s%s\n", (int)strlen(alpha_num), " alphabetic characters: ", alpha_num);
   } else {   
     fprintf(out, "%d%s%s\n", (int)strlen(alpha_num), " alphabetic character: ", alpha_num);
   }

   if((int)strlen(decimal)>1){
     fprintf(out, "%d%s%s\n", (int)strlen(decimal), " decimal characters: ", decimal);
   } else {
     fprintf(out, "%d%s%s\n", (int)strlen(decimal), " decimal character: ", decimal);
   }

   if((int)strlen(punc)>1){
     fprintf(out, "%d%s%s\n", (int)strlen(punc), " puncunation characters: " , punc);
   } else {
     fprintf(out, "%d%s%s\n", (int)strlen(punc), " puncunation character: " , punc);
   }
   
   if((int)strlen(space)>1){
     fprintf(out, "%d%s%s\n", (int)strlen(space), " whitespace characters: ", space);
   } else {
     fprintf(out, "%d%s%s\n", (int)strlen(space), " whitespace character: ", space);
   }
    numLine++;
  }

    free(line);
    free(alpha_num);
    free(decimal);
    free(punc);
    free(space);
    
    fclose(in);
    fclose(out);
    
    return EXIT_SUCCESS;

}

    void extract_chars(char* s, char* a, char* d, char* p, char* w){
      int i = 0, j = 0, num = 0, punc = 0, space = 0; 
      while(s[i]!= '\0' && i<MAX_STRING_LENGTH){
	if(islower(s[i])){
	    a[j++] = s[i];
	    i++;
	  }
	  else if(isalpha(s[i])){
	    a[j++] = s[i];
	    i++;  
	   }  
   
	    else if(isdigit(s[i])){
	    d[num++] = s[i];
	    i++;
	}
	      else if(ispunct(s[i])){
	    p[punc++] = s[i];
	    i++;
	}
	      else if(isspace(s[i])){
	    w[space++] = s[i];
	    i++;
	}
	  a[j] = '\0';
	  d[num] = '\0';
	  p[punc] = '\0';
	  w[space] = '\0';
    }
    }

