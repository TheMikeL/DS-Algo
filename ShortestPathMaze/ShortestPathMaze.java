/*
// Given an N^N board.
// Move up, down, left, and right if the next position is 1.
// Find the shortest path that can go from start to end.
// Output: Shortest Path Count and record path
// Start and End Value: 2
// Road: 1
// Wall: 0
 */
package ShortestPathMaze;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author michaellam
 */
public class ShortestPathMaze {
    private static int shortestPathCount = Integer.MAX_VALUE;
    public static int[] endPoint;
    public static int[][] shortestPath;
    
    public static int findShortestPath(int[][] maze, int[] start, int[] end){
        if (maze.length == 0 || maze[0].length == 0 || start.length == 0) return 0;
        shortestPath = new int[maze.length * 2][2];
        endPoint = end;
        traverseMaze(maze, start[0], start[1], new ArrayList<>(), 0);
        System.out.println(Arrays.deepToString(shortestPath));
        return shortestPathCount;
    }
    
    public static void traverseMaze(int[][] maze, int x, int y, ArrayList<int[]> result, int pathCount){
        if (x < 0 || x >= maze.length || 
            y < 0 || y >= maze[0].length ||
            maze[x][y] == 0){
            return;
        }
        int[] currentPosition = new int[]{x,y};
        result.add(currentPosition);
        maze[x][y] = 0;
        pathCount++;

        
        if (x == endPoint[0] && y == endPoint[1]){
            if (isAShorterPath(pathCount)){
                shortestPath = result.toArray(new int[result.size()][]);
                setShortestPath(pathCount);
            }
        }
        traverseMaze(maze, x + 1, y, result, pathCount);
        traverseMaze(maze, x - 1, y, result, pathCount);
        traverseMaze(maze, x, y + 1, result, pathCount);
        traverseMaze(maze, x, y - 1, result, pathCount);
        result.remove(result.size() - 1);
        maze[x][y] = 1;
    }
    
    public static boolean isAShorterPath(int pathCount){
        if (pathCount < shortestPathCount){
            return true;
        }
        return false;
    }
    
    public static void setShortestPath(int currentPath){
        shortestPathCount = currentPath;
    }
    public static int getShortestPathCount(){
        return shortestPathCount;
    }
}

