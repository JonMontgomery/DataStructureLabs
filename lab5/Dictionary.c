// CMPS 12m Lab5
// Jonathan Montgomery
// jopmontg@ucsc.edu
// DictionaryADT


#include <assert.h>
#include <stdio.h>
#include "Dictionary.h"
#include <stdlib.h>
#include <string.h>

//Struct datatypes based off of IntegerStack.c ADT provided on website

typedef struct NodeField{
  char* key;
  char* value;
  struct NodeField* next;
}NodeField;

typedef NodeField* Node;

typedef struct DictionaryObj{ 
    Node head;
    Node previous;
    int number;
}DictionaryObj;


Node newNode(char* key, char* value){
  Node node = malloc(sizeof(NodeField));
  assert(node!=NULL);
  node->key = key;
  node->value = value;
  node->next = NULL;
  return(node);
}

Dictionary newDictionary(void){
  Dictionary D  = malloc(sizeof(DictionaryObj));
  assert(D!=NULL);
  D->head = NULL;
  D->previous = NULL;
  D->number = 0;
  return D;

}

int isEmpty(Dictionary D){
  if(D==NULL){
    exit(EXIT_FAILURE);
  }
  if(D->number == 0){
    return 1;
  } else {
    return 0;
  }

}

// wrote findkey function but never used
Node findKey(char* k){
  Node index;
  while(index!=NULL){
    if(strcmp(index->key, k)==1){
      return index;
    }else{
      index = index->next;
    }
  }
  return 0;
}

// based on IntegerStack.c function
void freeNode(Node* pN){
  if( pN!=NULL && *pN!=NULL){
    free(*pN);
    *pN = NULL;
  }
}

void freeDictionary(Dictionary* pD){
  free(*pD);
  *pD = NULL;
}

int size(Dictionary D){
  return D->number;
}

// Based on pa3 lookup function
char* lookup(Dictionary D, char* k){
  if(D==NULL){
    exit(EXIT_FAILURE);
  }
  Node temp = D->head;
  while(temp != NULL){ // find key that matches node key and return that value
    if(strcmp(temp->key,k)== 0){
      return temp->value;
    }
    temp = temp->next;
  }
  return 0;
}
void insert(Dictionary D, char* k, char* v){
 if(D==NULL){
   exit(EXIT_FAILURE);
  }
 if(D->head == NULL) { // if no objects, insert will intialize first node
   D->head = D->previous = newNode(k, v);
 } else if(D->number==0){
   D->head = D->previous = newNode(k, v);
 } else { // insert new node, rearrange list pointers
       Node node = newNode(k, v);
       D->previous->next = node;
       D->previous = node;
   }
    D->number++;
}

void delete(Dictionary D, char* k){
  Node temp = D->head;
  if(strcmp(temp->key,k)==0){
    Node temp2 = temp->next;
    D->head = temp2;
    freeNode(&temp);
  }else{
    while(strcmp(temp->next->key, k)!=0){ // check to find location of key and corresponding value
      temp = temp->next;
    }
    temp->next = temp->next->next; // delete by rearranging linked pointers
    freeNode(&temp); // free the node from the list
  }
  D->number--;
}
void makeEmpty(Dictionary D){
  freeNode(&D->head);
  D->number = 0;
}

void printDictionary(FILE* out, Dictionary D){
  for(Node N = D->head; N!=NULL; N = N->next){
    fprintf(out, " %s %s \n ", N->key, N->value); 
  }
}

