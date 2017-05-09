//.cpp file digraph
//Lina Mikhaylichenko

#include<iostream>
#include <string>
#include <fstream>
#include"digraph.h"

using namespace std;


////constructor
Digraph::Digraph(string file){
	numEdges = 0;
	numVertices = 0;
	adjList.reserve(200);
	adjList.resize(200);
	vector<node*>::iterator iter;
	for (iter = adjList.begin(); iter != adjList.end(); ++iter)
	{
        *iter = NULL;
	}
	//declaration of local variables
	string course1;
	string course2;
	ifstream myFile;
	//open file to read 
	myFile.open(file);

	//check if file is open
	if (!myFile)
	{
		cout << "Can't open file";
	}
	while(myFile >> course1 >> course2){
		if (course1 != " ")
			addVertex(course1, course2);
	}
	myFile.close();
	delVertices = numVertices;
}

//destructor
Digraph::~Digraph(){
}

//add Vertex to an adjacency list
void Digraph::addVertex(string course1, string course2){
	//check if table has the course1
	//go through list andd add course to empty index 
	for (unsigned i = 0; i < adjList.size(); i++){
		if (adjList[i] == NULL){
			if (course1 != "NONE"){ //if course doesnt related to any other course
				adjList[i] = new node;
				adjList[i]->label = course1;
				adjList[i]->next = NULL;
				numVertices++; // add one more vertex
			}
			break;
		}
		//check if list has such a course1
        else if (adjList[i]->label == course1)
			break;
	}
	//check if table has the course2
	//go through list andd add course to empty index
	for (unsigned i = 0; i < adjList.size(); i++){
		if (adjList[i] == NULL){
			adjList[i] = new node;
			adjList[i]->label = course2;
			adjList[i]->next = NULL;
			numVertices++;// add one more vertex
			break;
		}
		////check if list has such a course2
		else if (adjList[i]->label == course2)
			break;
	}
	////if one element or more add course to the list
	for (unsigned i = 0; i < adjList.size(); i++){
		if (adjList[i] == NULL)//if there is no more vertexes, break the loop
			break;
		//add veretex to the end of adjecency list
		if (adjList[i]->label == course1){ 
			node* item = new node;
			node* curr = NULL;
			item->label = course2;
			item->next = NULL;
			curr = adjList[i];
			while (curr->next != NULL){
				curr = curr->next;
			}
			curr->next = item;
			//add one more adge
			numEdges++;
			break;
		}
	}
};

//topological sort
string Digraph::getTopoSort(){
	//local variables
	string courseOrder;
	string courseString;
	//while there is one or more vertices in the list
	while (adjList[0] != NULL){
	//go through the list 
	//if there is such a course then add vertice to the end of the list 
		for (int index = 0; index < delVertices; index++){
			if (adjList[index]->next == NULL){
				courseString = adjList[index]->label;
				//add vertice to output
				courseOrder = courseString + "\n" + courseOrder;
				//delete vertice from the list
				delete adjList[index];
				int i = index;
				//move up all other vertices
				for (i; i < delVertices; i++){
					adjList[i] = adjList[i+1];
				}
				adjList[i+1] = NULL;
				//delete all edges related to this course
				delVertex(courseString);
				delVertices--;
				break;
			}
		}
	}
	return courseOrder;
}

//delete all edges related to such a course
void Digraph::delVertex(string course){
	node* del = NULL;
	for (int i = 0; i < delVertices; i++){
		node* curr = adjList[i];
		node* temp = adjList[i];
		//go through the linked list and find the course
		while (curr != NULL && curr->label != course){
			temp = curr;
			curr = curr->next;
		}
		//if course is found delete 
		if (curr != NULL){
			del = curr; 
			curr = curr->next;
			temp->next = curr;
			delete del;
			del = NULL;
		}
	}
}
