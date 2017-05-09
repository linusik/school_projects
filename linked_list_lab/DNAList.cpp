//Lina Mikhaylichenko
// DNAList Class implementation

#include <iostream>
#include <string>
#include "DNAList.h"

//constrictor
DNAList::DNAList(){
	headPtr = NULL;
}
//destructor
DNAList::~DNAList(){
	headPtr = NULL;
	delete headPtr;
}

//
void DNAList::push_back(DNA* newDNA){
	DNANode *temp = new DNANode;

	// create a new node and set it up
	temp->dnaPtr = newDNA;
	// it has no next element now
    temp->next = nullptr;
	// or you need to find the last node
	headPtr = temp;
	// starting at head and going from node to node
    while (last->next){
		last = last->next;
	} 
    last->next = temp;
}



DNA* DNAList::find(int id){
	DNANode *temp;
	temp = headPtr;
	//empty list
    if (temp == NULL)
		cerr << "Can not find item (9999)!";
	//going through the list, finding needed id
	while (temp->next){
		if ( temp->dnaPtr->getIndex() == id){
			cerr << "Printing " << id << "...";
			return temp->dnaPtr;
		}
	}
	//didn’t find needed id
	if (temp == NULL)
		cerr << "Can not find item (9999)!";
	return temp;
}



void DNAList::obliterate(int id){
	//list is empty
	if (headPtr == NULL)
		cerr << "Can not delete DNA (9999), NOT found!"; 
	//find node with id provided to delete
	else {
		DNANode *curr =  headPtr; //set up pointer to head of the list
		DNANode *temp =  NULL;
		while (curr->next){
			if ( curr->dnaPtr->getIndex() == id){ //found id from DNA object
				cerr << "Obliterating " << id << " ...";
				if (headPtr == curr){
					headPtr = headPtr->next;
				}
				else{
					temp->next = curr->next;
				}
			break;
			}
		}
		//didn’t find needed id
		if (curr == NULL)
			cerr << "Can not delete DNA (9999), NOT found!"; 

	}
}

//count pointers in linked list 
int DNAList::size(){
	DNANode *temp =  headPtr;
	int count = 0;
	while(temp->next){
		count++;
	}
	return count;
}
