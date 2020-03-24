/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaellam
 */
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import ShortestPathMaze.ShortestPathMaze;

public class ShortestPathMazeTest {
    ShortestPathMaze maze;
    @Before
    public void initialize(){
        ShortestPathMaze maze = new ShortestPathMaze();
        maze.setShortestPath(Integer.MAX_VALUE);
    }
    @Test
    public void TwoMainPathBoard() { 
      int[][] board = {
          {0,2,0,0,0,0}, 
          {0,1,1,0,0,0}, 
          {1,1,1,1,1,0}, 
          {1,0,0,0,1,0}, 
          {1,1,1,1,1,0}, 
          {0,0,2,0,0,0}};
      int[] start = {0,1}; 
      int[] end = {5,2};
      int shortestPath = maze.findShortestPath(board, start, end);
      System.out.println("Shortest Path for Two Path Board: " + shortestPath);
      Assert.assertEquals(9, shortestPath);
    }
    
    @Test
    public void MultiplePathBoard() { 
      int[][] board = {
          {0,2,0,0,0,0}, 
          {0,1,1,0,0,0}, 
          {1,1,1,1,1,0}, 
          {1,1,1,1,1,0}, 
          {1,1,1,1,1,0}, 
          {0,0,2,0,0,0}};
      int[] start = {0,1}; 
      int[] end = {5,2};
      int shortestPath = maze.findShortestPath(board, start, end);
      System.out.println("Shortest Path for multi path board: " + shortestPath);
      Assert.assertEquals(7, shortestPath);
    }
    @Test
    public void StraightPathWithOptionsBoard() { 
      int[][] board = {
          {0,1,2,0,0,0}, 
          {0,0,1,1,1,0}, 
          {1,1,1,0,1,0}, 
          {1,1,1,1,1,0}, 
          {1,1,1,1,1,0}, 
          {0,0,2,0,0,0}};
      int[] start = {0,2}; 
      int[] end = {5,2};
      int shortestPath = maze.findShortestPath(board, start, end);
      System.out.println("Shortest Path for straight path with options board: " + shortestPath);
      Assert.assertEquals(6, shortestPath);
    }
    @Test
    public void StraightPathBoard() { 
      int[][] board = {
          {0,0,2,0,0,0}, 
          {0,0,1,0,0,0}, 
          {1,0,1,0,1,0}, 
          {1,0,1,0,1,0}, 
          {1,0,1,0,1,0}, 
          {0,0,2,0,0,0}};
      int[] start = {0,2}; 
      int[] end = {5,2};
      int shortestPath = maze.findShortestPath(board, start, end);
      System.out.print("Shortest Path for straight path board: ");
      System.out.println(shortestPath);
      Assert.assertEquals(6, shortestPath);
    }
    
    @Test
    public void LoopedPathBoard() { 
      int[][] board = {
          {0,2,0,0,0,0}, 
          {0,1,1,1,0,0}, 
          {0,1,0,1,1,0}, 
          {1,1,0,1,1,1}, 
          {1,0,1,1,1,1}, 
          {0,0,2,0,0,0}};
      int[] start = {0,1}; 
      int[] end = {5,2};
      int shortestPath = maze.findShortestPath(board, start, end);
      System.out.print("Shortest Path for looped board: ");
      System.out.println(shortestPath);
      Assert.assertEquals(9, shortestPath);
    }
    
    @Test
    public void nullBoard() { 
      int[][] board = {{}};
      int[] start = {}; 
      int[] end = {};
      int shortestPath = maze.findShortestPath(board, start, end);
      Assert.assertEquals(0, shortestPath);
    }
    
    @Test
    public void nullStartandEnd() { 
      int[][] board = {{0,0},{0,0}};
      int[] start = {}; 
      int[] end  = {};
      int shortestPath = maze.findShortestPath(board, start, end);
      Assert.assertEquals(0, shortestPath);
    }
    
    @Test
    public void setShortestPathSuccess() { 
      maze.setShortestPath(6);
      Assert.assertEquals(6,maze.getShortestPathCount());
    }
    
    @Test
    public void isAShorterPathTrue() { 
      Assert.assertEquals(true, maze.isAShorterPath(5));
    }
    
    @Test
    public void isAShorterPathFalse() { 
      maze.setShortestPath(5);
      Assert.assertEquals(false, maze.isAShorterPath(6));
    }
    
    @Test
    public void isAShorterPathSameLength() { 
      maze.setShortestPath(5);
      Assert.assertEquals(false, maze.isAShorterPath(5));
    }
}
