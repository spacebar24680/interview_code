#include <stdio.h>
#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char * argv[]){
	ifstream file;
	file.open(argv[1]);
	
	string lineBuffer = "";
	while(!file.eof()){
		getline(file, lineBuffer);
		if(lineBuffer.length() == 0)
			continue; //ignore all empty lines
		else{
			for(unsigned int c = 0; c < lineBuffer.length(); c++){
				if(lineBuffer.find_first_of(lineBuffer[c]) == lineBuffer.find_last_of(lineBuffer[c])){
					cout << lineBuffer[c] << "\n";
					break;
				}
			}
		}
	}
}