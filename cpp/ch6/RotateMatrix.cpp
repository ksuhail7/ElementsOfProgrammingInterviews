//
// Created by Suhail Kandanur on 2022-04-11.
//

#include <vector>
#include <iostream>

typedef std::vector<std::vector<int>> Int2D;
Int2D rotateMatrix(const Int2D& matrix) {
    int n = matrix.size();
    Int2D rotatedMatrix(n);
    for (int i = 0; i < n; ++i) {
        rotatedMatrix[i] = std::vector<int>(matrix[i].size());
    }
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = 0; matrix.size() > 0 && j < matrix[0].size(); ++j) {
            rotatedMatrix[i][j] = matrix[j][n-i-1];
        }
    }
    return rotatedMatrix;
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
    Int2D board1 = {{5,4,3, 6, 7, 8, 9, 1, 2},
                                            {6,7,2,1,9,5,3,4,8},
                                            {1,9,8,3,4,2,5,6,7},
                                            {8,5,9,7,6,1,4,2,3},
                                            {4,2,6,8,5,3,7,9,1},
                                            {7,1,3,9,2,4,8,5,6},
                                            {9,6,1,5,3,7,2,8,4},
                                            {2,8,7,4,1,9,6,3,5},
                                            {3,4,5,2,8,6,1,7,9}
    };

    Int2D board2 = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};

    auto rotatedMatrix = rotateMatrix(board2);
    printMatrix(rotatedMatrix);
    return 0;
}

