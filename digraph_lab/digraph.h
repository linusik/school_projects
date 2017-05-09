//header file digraph
//Lina Mikhaylichenko

#ifndef DIGRAPH_H
#define DIGRAPH_H
#include <iostream>
#include <string>
#include <vector>

using namespace std;


class Digraph{
//private data members
private:
    int numVertices;
    int numEdges;
    string label;
    int delVertices;
    struct node{
        string label;
        node* next;
    };
    vector<node*> adjList;
public:
	//constructors
    //Digraph ();
    Digraph (string filename);
    //destructor
    ~Digraph();
    //geters and setters
    int getNumVertices(){
        return numVertices;
    }
    void setNumVertices(int i){
		numVertices = i;
	}
	int getNumEdges(){
		return numEdges;
	}
	void setEdges(int i){
		numEdges = i;
	}
	string getLabel(){
		return label;
	}
	void setVertices(string i){
		label = i;
	}

    void addVertex(string course1, string course2);
	void delVertex(string label);
	string getTopoSort();
};

#endif
