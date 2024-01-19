#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N;
string fileName;
vector<string> fileNameVec;

int main() {
	int j = 1;
	string temp = "", result = "";
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> fileName;
		fileNameVec.push_back(fileName);
	}

	temp = fileNameVec.at(0);
	result = fileNameVec.at(0);

	while (j < fileNameVec.size()) {

		
		for (int k = 0; k < fileName.length(); k++) {
			
			if (temp[k] != fileNameVec.at(j)[k]) {
				result[k] = '?';
			}
			else {
				if (result[k] == '?') continue;
				
				result[k] = temp[k];
			}
		}
		j++;
	}

	cout << result;
	
	return 0;
}