#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <vector>
#include <stdlib.h>
using namespace std;

int getIndex(vector<int> list, int target, int start);

int main(int argc, char *argv[]){
	ifstream file;
	file.open(argv[1]);
	
	string lineBuffer = "";
	while(!file.eof()){
		getline(file, lineBuffer);
		if(lineBuffer.length() == 0)
			continue; //ignore all empty lines
		else{
			
			// Look for the first repeating character. Then compare if what's in between matches
			string character;
			stringstream stream (lineBuffer);
			vector<int> nums; // declares a vector of integers 
			while(getline(stream, character, ' ')){
				nums.push_back(atoi(character.c_str()));
				//cout << "Added: " << atoi(character.c_str()) << "\n";
			}

			// Now we have a vector of integers
			for(unsigned int c = 0; c < nums.size(); c++){
				
				// Check for next occurrence of the number
				int currNum = nums[c];
				
				//cout << "Checking if element exists later in array" << "\n";

				int nextIndex = getIndex(nums, currNum, c+1);

				if(nextIndex != -1){
					// The element exists later in the list

					// Make a copy of the c pointer
					int front = c;

					// Make a copy of the later pointer
					int back = nextIndex;

					bool cycle = true;

					//cout << "About to enter while and nextIndex = " << nextIndex << " and c = " << c << "\n";

					while(front != nextIndex){
						if(nums[front] != nums[back]){
							cycle = false;
						}
						front++;
						back++;
					}

					if(cycle == true){
						// Print out the cycle
						front = c;
						while(front != nextIndex){
							cout << nums[front];
							if(front + 1 != nextIndex)
								cout << " ";
							front++;
						}
						// Now we're done with this input
						cout << "\n";
						break;
					}
				}
			}
		}
	}

	return 0;
}


// Returns the index or -1 if not found
int getIndex(vector<int> list, int target, int start){
	//cout << "entered getIndex with start= " << start << " and target = " << target << "\n";
	for(unsigned int c =start; c < list.size(); c++){
		if(target == list[c]){
			//cout << "returning with index = " << c << "\n";
			return c;
		}
	}
	return -1;
}