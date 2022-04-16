//
// Created by Suhail Kandanur on 2022-03-29.
//

#include <iostream>
#include <vector>

bool winGameHelper(const std::vector<int> board, std::vector<int>& seq, int startPosition) {
    if(startPosition < 0 || startPosition >= board.size()) return false;
    if(startPosition == board.size() - 1) return true;
    int maxMoves = board[startPosition];
    for (int i = 1; i <= maxMoves; ++i) {
        if(winGameHelper(board, seq, startPosition + i)) {
            seq.emplace_back(i);
            return true;
        }
    }
    return false;
}
std::vector<int> winGame(const std::vector<int> board) {
    std::vector<int> seq = {};
    winGameHelper(board, seq, 0);
    std::reverse(seq.begin(), seq.end());
    return seq;
}
int main(int argc, char *argv[]) {
    //std::vector<int> board = {3, 3, 1, 0, 2, 0, 1};
    std::vector<int> board = {3, 2, 0, 0, 2, 0, 1};
    auto winningSeq = winGame(board);
    if(winningSeq.empty()) {
        std::cout << "Not winnable" << std::endl;
    } else {
        std::cout << "Winnable with sequence: ";
        for (int i = 0; i < winningSeq.size(); ++i) {
            std::cout << winningSeq[i];
        }
        std::cout << std::endl;
    }
    return 0;
}

