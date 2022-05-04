//
// Created by Suhail Kandanur on 2022-04-22.
//

#include <iostream>
#include <vector>

typedef std::vector<std::vector<int>> Maze2D;
typedef std::pair<int, int> Coord;

void searchPathHelper(const Maze2D& maze, Coord from, Coord to, std::vector<Coord>& path, std::vector<int>& visited) {
    int size = maze.size();
    if(visited[size * from.first + from.second] == 1) {
        std::cout << from.first << ", " << from.second << " already visited" << std::endl;
        return;
    }
    visited[from.first * size + from.second] = 1;
    if(from == to) {
        std::cout << "Reached destination" << std::endl;
        path.emplace_back(to);
        return;
    }

    // go up
    Coord up = std::make_pair(from.first - 1, from.second);
    if(up.first >= 0 && maze[up.first][up.second] != 1) {
        std::cout << "Searching up from " << from.first << ", " << from.second << std::endl;
        assert(up.first >= 0 && up.first < size);
        assert(up.second >= 0 &&  up.second < size);
        searchPathHelper(maze, up, to, path, visited);
        if(path.size() > 0) {
            path.emplace_back(from);
            return;
        }
    }

    // go down
    Coord down = std::make_pair(from.first + 1, from.second);
    if(down.first < size && maze[down.first][down.second] != 1) {
        std::cout << "Searching down from " << from.first << ", " << from.second << std::endl;
        assert(down.first >= 0 && down.first < size);
        assert(down.second >= 0 &&  down.second < size);
        searchPathHelper(maze, down, to, path, visited);
        if(path.size() > 0) {
            path.emplace_back(from);
            return;
        }
    }

    // go left
    Coord left = std::make_pair(from.first, from.second-1);
    if(left.second >= 0  && maze[left.first][left.second] != 1) {
        std::cout << "Searching left from " << from.first << ", " << from.second << std::endl;
        assert(left.first >= 0 && left.first < size);
        assert(left.second >= 0 &&  left.second < size);
        searchPathHelper(maze, left, to, path, visited);
        if(path.size() > 0) {
            path.emplace_back(from);
            return;
        }
    }

    // go right
    Coord right = std::make_pair(from.first, from.second + 1);
    if (right.second < size && maze[right.first][right.second] != 1) {
        std::cout << "Searching right from " << from.first << ", " << from.second << std::endl;
        assert(right.first >= 0 && right.first < size);
        assert(right.second >= 0 &&  right.second < size);
        searchPathHelper(maze, right, to, path, visited);
        if (path.size() > 0) {
            path.emplace_back(from);
            return;
        }
    }
    visited[from.first * size + from.second] = 0;
    std::cout << "Resetting visited flag for " << from.first << ", " << from.second << std::endl;
}
std::vector<Coord> searchPath(const Maze2D &maze, Coord from, Coord to) {
   std::vector<Coord> path;
   std::vector<int> visited(maze.size() * maze.size());
   std::cout << "Visited: " ;
   for(auto visit : visited) {
       std::cout << visit << ", ";
   }
   std::cout << std::endl;
   searchPathHelper(maze, from, to, path, visited);
   std::cout << "path length: " << path.size() << std::endl;
   return path;
}

int main(int argc, char *argv[]) {
    Maze2D maze = {{1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                   {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 0, 1, 1, 0, 1, 1},
                   {0, 0, 0, 1, 1, 1, 0, 0, 1, 1},
                   {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                   {0, 1, 1, 0, 0, 1, 0, 1, 1, 0},
                   {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                   {1, 0, 1, 1, 0, 0, 0, 1, 1, 1},
                   {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}
    };

    auto path = searchPath(maze, std::make_pair(9, 0), std::make_pair(0, 9));
    std::reverse(path.begin(), path.end());
    for(Coord coord : path) {
        std::cout << "(" << coord.first << ", " << coord.second << ") -> ";
    }
    std::cout << std::endl;
    return 0;
}
