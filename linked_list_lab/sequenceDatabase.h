//Lina Mikhaylichenko
//sequenceDatabase header class

#include <iostream>
#include <string>
#include "DNA.h"
#include "DNAList.h"

using namespace std;

class sequenceDatabase{
public:
    sequenceDatabase();
    void importEntries( string commandsFilename);
private:
	DNA* dna;
	DNAList* list;

};
