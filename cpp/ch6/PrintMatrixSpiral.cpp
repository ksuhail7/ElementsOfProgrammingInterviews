//
// Created by Suhail Kandanur on 2022-04-11.
//

#include <vector>
#include <iostream>

typedef std::vector<std::vector<int>> Int2D;

void printMatrixSpiralHelper(const Int2D& matrix, int top, int left, int size) {
    if (size < 1) return;
    if(size == 1) {
        std::cout << matrix[top][left] << std::endl;
        return;
    }

    // print first row
    for (int i = left; i < left + size -1; ++i) {
        std::cout << matrix[top][i] << " ";
    }

    // print last column
    for (int i = top; i < top + size - 1; ++i) {
        std::cout << matrix[i][left + size - 1] << " ";
    }
    //print last row
    for (int i = left+size-1; i > left; --i) {
        std::cout << matrix[top + size - 1][i] << " ";
    }
    // print first column
    for (int i = top + size - 1; i > top; --i) {
        std::cout << matrix[i][left] << " ";
    }
    printMatrixSpiralHelper(matrix, top + 1, left + 1, size - 2);
}

void printMatrixSpiral(const Int2D& matrix) {
    printMatrixSpiralHelper(matrix, 0, 0, matrix.size());
}
void printMatrix(const Int2D& matrix, std::ostream& out = std::cout) {
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = 0; matrix.size() > 0 && j < matrix[0].size(); ++j) {
            out << matrix[i][j] << " " ;
        }
        out << std::endl;
    }
}

int main(int argc, char *argv[]) {
    Int2D board2 = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
    Int2D board1 = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
    printMatrixSpiral(board2);
    printMatrixSpiral(board1);
    return 0;
}

