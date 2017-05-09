//Lina Mikhaylichenko
// sequenceDatabase Class implementation

#include <fstream>
#include <iostream>
#include <string>
#include <array>
#include "DNA.h"
#include "sequenceDatabase.h"
#include "DNAList.h"

using namespace std;

// constructor 
sequenceDatabase::sequenceDatabase() {}

//implemantation of importEntries function that prints out ID's of each object from the file
void sequenceDatabase::importEntries(string file){

    //declaration of local variables
    char line;
    string temp;
    ifstream myFile;
    myFile.open(file);
    if (!myFile)
    {
        cout << "Can't open file";
    }
    //check if we have labels (characters) in the file and, assosiatedwith labels, ID's
    if (myFile.is_open()){
        dna = new DNA(); //create an object of DNA class;
        string label;
        int accessionID;
        string sequence;
        int lengthOfSeq;
        int index;
        while(myFile >> line){
            if (line == 'D'){
            //read line with all information we have to have for DNA
            myFile >> label >> accessionID >> sequence >> lengthOfSeq >> index;
            // set all info to an our dna object we created before
            dna->setLabal(label);
            dna->setAccessionID(accessionID);
            dna->setSequence(sequence);
            (*dna).setLengthOfSeq(lengthOfSeq);
            (*dna).setIndex(index);
            list->push_back(dna);
            cout << "Adding ";
            cout << (*dna).getAccessionID();
            cout << " ..." << '\n' << endl;
            }
            else if (line == 'S'){
                cout << "Entries: NYI" << '\n' << endl;
            }
            //print
            else if (line == 'P'){
                myFile >> accessionID;
                cout << "Printing ";
                cout << accessionID;
                cout << " ..." << '\n' << endl;
            }
            //delete
            else if (line == 'O'){
                myFile >> accessionID;
                cout << "Obliterating ";
                cout << accessionID;
                cout << " ..." << '\n' << endl;
            }
        }
    }
    myFile.close();
}
