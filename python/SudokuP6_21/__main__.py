#!/usr/bin/env python3

import re

def is_board_valid(board):
    M = len(board)
    N = len(board[0])
    if M is not N:
        return False

    # check duplicates in cols and rows
    for i in range(0, M):
        rows = [0] * 9
        cols = [0] * 9

        row = i
        for j in range(0, M):
            val = int(board[row][j])
            if val is 0:
                continue

            if cols[val-1] != 0:
                print("duplicate found at ", row, j)
                return False
            cols[val-1] = 1

        col = i
        for j in range(0, M):
            val = int(board[j][col])
            if val is 0:
                continue
            if rows[val-1] != 0:
                print("duplicate found ", j, col)
                return False
            rows[val-1] = 1

    # check for duplicates in each 3x3 box
    for i in range(0, M, 3):
        for j in range(0, N, 3):
            vals = [0] * 9
            for k in range(i, i+3):
                for l in range(j, j+3):
                    val = int(board[k][l])
                    if val is 0:
                        continue
                    if vals[val-1] != 0:
                        print("duplicate found ", k, l)
                        return False
                    vals[val-1] = 1
    return True


def print_board(board):
    M = len(board)
    N = len(board[0])
    for i in range(0, M):
        for j in range(0, N):
            print(board[i][j], end=" ")
        print()


fname = "easy50.txt"
example = 1
sudoku_board = []
with open(fname) as f:
    eg_count = 0
    if eg_count != (example - 1):
        for line in f:
            if re.match("=+", line) is not None:
                eg_count+=1

            if eg_count == (example - 1):
                break

    for line in f:
        if re.match("=+", line) is  None:
            sudoku_board.append(list(line.rstrip('\n')))
        else:
            break

print_board(sudoku_board)
print(len(sudoku_board), len(sudoku_board[0]))
print("is_board_valid", is_board_valid(sudoku_board))