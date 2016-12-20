#include <iostream>

using namespace std;

int first_occurence_helper(int array[], int k, int lo, int hi) {
	return -1;
}

int first_occurence(int array[], int k) {
	//int length = sizeof(array) / sizeof(array[0]);
	int length = sizeof(array)/sizeof(array[0]);
	return first_occurence_helper(array, k, 0, length - 1);
}


int main(int argc, char* argv[]) {
	int array[] = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
	//int index = first_occurence(array, 108);
    //cout << index << endl;
    return 0;
}
