cmake_minimum_required(VERSION 3.21)
project(ElementOfProgrammingInterviews)

set(CMAKE_CXX_STANDARD 11)
add_executable(MergeSort MergeSort.cpp)

add_executable(FirstOccurance chapter12/first_occurence.cpp)

add_executable(BitSwap BitSwap.cpp)

add_executable(TwoSum TwoSum.cpp)

add_executable(DutchNationalFlag ch6/DutchNationalFlag.cpp)
add_executable(IncrementBigInteger ch6/IncrementBigInteger.cpp)
add_executable(BoardGameWinnable ch6/BoardGameWinnable.cpp)
add_executable(DeleteKeyFromArray ch6/DeleteKeyFromArray.cpp)
add_executable(ShiftArrayInPlace ch6/ShiftArrayInPlace.cpp)
add_executable(SudokuChecker ch6/SudokuChecker.cpp)
add_executable(RotateMatrix ch6/RotateMatrix.cpp)
add_executable(PrintMatrixSpiral ch6/PrintMatrixSpiral.cpp)