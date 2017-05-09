//Lina Mikhaylichenko
// DNA header class


//using #ifndef to make header file compiled
#ifndef DNA_H
#define DNA_H
#include <iostream>
#include <string>

using namespace std;

class DNA{
    //data members
private:
    string label;
    int accessionID;
    string sequence;
    int lengthOfSeq;
    int index;
public:
    //constructors
    DNA ();
    DNA (string lab, int accID, string seq, int length, int i);
    string getLabel(){
        return label;
    }
    //setters and getters
    int getAccessionID(){
        return accessionID;
    }
    string getSequence(){
        return sequence;
    }
    int getLengthOfSeg(){
        return lengthOfSeq;
    }
    int getIndex(){
        return index;
    }
    void setLabal(string l){
        label = l;
    }
    void setAccessionID(int id){
        accessionID= id;
    }
    void setSequence(string seq){
        sequence = seq;
    }
    void setLengthOfSeq(int length){
        lengthOfSeq = length;
    }
    void setIndex(int i ){
        index = i;
    }
    //member function
    void print();

};
#endif
