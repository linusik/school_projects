//header DNAList file
//Lina Mikhaylichenko

#ifndef DNALIST_H
#define DNALIST_H
#include <iostream>
#include <string>
#include "DNA.h"


//struct that holds pointer to a DNA object  and a "next" pointer to a DNANode object 
	struct DNANode{
		DNA* dnaPtr;
		DNANode* next;
	};

class DNAList{
	//data members
    private:
        DNANode* headPtr;
		DNANode *last;
	public:
		DNAList();
        ~DNAList();
		void push_back(DNA* newDNA);
		DNA* find(int id);
		void obliterate(int id);
		int size();
		
};

#endif
