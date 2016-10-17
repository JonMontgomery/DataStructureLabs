

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void stringReverse(char* s){
  int i = 0;
  int j = strlen(s)-1;
  char tmpSwap;
  while(i < j){
    tmpSwap = s[i];
    s[i] = s[j];
    s[j] = tmpSwap;
    i++;
    j--;

  }

}


int main (int argc, char * argv[]){
  FILE *in, *out;
  char word[256];

  if( argc != 3 ){
    printf("USAGE: %s <input file> <output file>\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  in = fopen(argv[1], "r");
  if(in == NULL){
    printf("Error: Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }

  out = fopen(argv[2], "w");
  if( out == NULL){
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }  

    while(fscanf(in, " %s", word)!=EOF){
      stringReverse(word);
      fprintf(out, "%s\r\n", word);
    }


    fclose(in);
    fclose(out);

    return(EXIT_SUCCESS);

}


