
//Lina Mikhaylichenko
// DNA Class implementation
 
#include <iostream>
#include <string>
#include "DNA.h"

using namespace std;
//costructors 
DNA::DNA() {} 
DNA::DNA(string lab, int accID, string seq, int length, int i){
    setLabal(lab);
    setAccessionID(accID);
    setSequence(seq);
    setLengthOfSeq(length);
    setIndex(i);
}
//function to print everithing from DNA object
void DNA::print(){}
