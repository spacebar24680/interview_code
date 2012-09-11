#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char *argv[]){
	ifstream file;
	file.open(argv[1]);
	
	while(!file.eof()){
		getline(file, lineBuffer);
		if(lineBuffer.length() == 0)
			continue; //ignore all empty lines
		else{
			// do something here
			cout << lineBuffer;
		}
	}

	return 0;
}