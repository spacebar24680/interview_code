#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <vector>
#include <stdlib.h>
using namespace std;

int main(int argc, char *argv[]){
	ifstream file;
	file.open(argv[1]);
	
	string lineBuffer = "";
	while(!file.eof()){
		getline(file, lineBuffer);
		if(lineBuffer.length() == 0)
			continue; //ignore all empty lines
		else{
			// do something here
			//cout << lineBuffer << "\n";
			// Look for the first repeating character. Then compare if what's in between matches
			string character;
			stringstream stream (lineBuffer);
			vector<int> nums; // declares a vector of integers 
			while(getline(stream, character, ' ')){
				nums.push_back(atoi(character.c_str()));
				cout << "Added: " << atoi(character.c_str()) << "\n";
			}
		}
	}

	return 0;
}