package com.suhailkandanur.eopi.ch19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a 2D array of black and white entries representing a maze with designated entrance and exit points,
 * find a path from the entrance to the exit, if one exists.
 * Created by suhail on 2016-11-25.
 */
public class SearchAMazeP19_1 {
    public static List<Point> findPath(int[][] maze, Point start, Point end) {
        if (maze == null || start == null || end == null) {
            return Collections.emptyList();
        }
        int[][] visited = new int[maze.length][maze[0].length];
        List<Point> list = traverseMaze(maze, visited, start, end);
        Collections.reverse(list);
        return list;
    }

    public static List<Point> traverseMaze(int[][] maze, int[][] visited, Point from, Point to) {
        if (maze == null || maze.length < 1 || from == null || to == null)
            return Collections.emptyList();
        if (from.equals(to))
            return Arrays.asList(to);
        if (from.getX() < 0 || from.getX() >= maze.length || from.getY() < 0 || from.getY() >= maze[0].length) {
            return Collections.emptyList();
        }

        if (to.getX() < 0 || to.getX() >= maze.length || to.getY() < 0 || to.getY() >= maze[0].length) {
            return Collections.emptyList();
        }

        if(maze[from.getX()][from.getY()] == 1 || visited[from.getX()][from.getY()] == 1) //the cell is blocked or cell already visited, cannot traverse
            return Collections.emptyList();

        visited[from.getX()][from.getY()] = 1;
        List<Point> path = new ArrayList<>();
        List<Point> pathFromLeft = traverseMaze(maze, visited, from.left(), to);
        if(pathFromLeft != null && pathFromLeft.size() > 0) {
            path.addAll(pathFromLeft);
        } else {
            List<Point> pathFromRight = traverseMaze(maze, visited, from.right(), to);
            if (pathFromRight != null && pathFromRight.size() > 0) {
                path.addAll(pathFromRight);
            } else {
                List<Point> pathFromTop = traverseMaze(maze, visited, from.up(), to);
                if (pathFromTop != null && pathFromTop.size() > 0) {
                    path.addAll(pathFromTop);
                } else {
                    List<Point> pathFromDown = traverseMaze(maze, visited, from.down(), to);
                    if (pathFromDown != null || pathFromDown.size() > 0)
                        path.addAll(pathFromDown);
                }
            }
        }
        visited[from.getX()][from.getY()] = 0;
        if(path != null && path.size() > 0) //there is a path to destination
            path.add(from);
        return path;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,0,1,0,1,0,0,0,0,0,1},
                {1,0,1,0,0,0,1,0,1,1,1,0,1},
                {1,0,0,0,1,1,1,0,0,0,0,0,1},
                {1,0,1,0,0,0,0,0,1,1,1,0,1},
                {1,0,1,0,1,1,1,0,1,0,0,0,1},
                {1,0,1,0,1,0,0,0,1,1,1,0,1},
                {1,0,1,0,1,1,1,0,1,0,1,0,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1}

        };
        List<Point> path = findPath(maze, new Point(1, 1), new Point(1, 11));
        printPoints(path);
    }

    private static void printPoints(List<Point> points) {
        if (points == null) {
            return;
        }
        String path = points.stream().map(p -> "(" + p.getX() + "," + p.getY() + ")").collect(Collectors.joining("->"));
        System.out.println(path);
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean equals(Point p) {
            return this.x == p.x && this.y == p.y;
        }

        public Point left() {
            return y < 1 ? null : new Point(x, y-1);
        }

        public Point right() {
            return new Point(x, y + 1);
        }

        public Point up() {
            return x < 1 ? null : new Point(x - 1, y);
        }

        public Point down() {
            return new Point(x + 1, y);
        }
    }
}
