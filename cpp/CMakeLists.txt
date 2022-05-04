cmake_minimum_required(VERSION 3.21)
project(ElementOfProgrammingInterviews)

set(CMAKE_CXX_STANDARD 14)
add_executable(MergeSort MergeSort.cpp)

add_executable(FirstOccurance chapter12/first_occurence.cpp)

add_executable(BitSwap BitSwap.cpp)

add_executable(TwoSum TwoSum.cpp)

## Chapter 6
add_executable(DutchNationalFlag ch6/DutchNationalFlag.cpp)
add_executable(IncrementBigInteger ch6/IncrementBigInteger.cpp)
add_executable(BoardGameWinnable ch6/BoardGameWinnable.cpp)
add_executable(DeleteKeyFromArray ch6/DeleteKeyFromArray.cpp)
add_executable(ShiftArrayInPlace ch6/ShiftArrayInPlace.cpp)
add_executable(SudokuChecker ch6/SudokuChecker.cpp)
add_executable(RotateMatrix ch6/RotateMatrix.cpp)
add_executable(PrintMatrixSpiral ch6/PrintMatrixSpiral.cpp)

## Chapter 8
add_executable(MergeLinkedLists ch8/MergeLinkedLists.cpp)
add_executable(ReverseLinkedList ch8/ReverseLinkedList.cpp)
add_executable(ReverseSubList ch8/ReverseSubList.cpp)

# Chapter 9
add_executable(StackWithMax ch9/StackWithMax.cpp)

## Chapter 13
add_executable(LRUCache ch13/LRUCache.cpp)

## Chapter 15
add_executable(CheckBSTValid ch15/CheckBSTValid.cpp)

## Chapter 16
add_executable(TowersOfHanoi ch16/TowerOfHanoi.cpp)

## Chapter 19
add_executable(SearchMaze ch19/SearchMaze.cpp)