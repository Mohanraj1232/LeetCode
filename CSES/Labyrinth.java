/*
 You are given a map of a labyrinth, and your task is to find a path from start to end. You can walk left, right, up and down.
Input
The first input line has two integers n and m: the height and width of the map.
Then there are n lines of m characters describing the labyrinth. Each character is . (floor), # (wall), A (start), or B (end). There is exactly one A and one B in the input.
Output
First print "YES", if there is a path, and "NO" otherwise.
If there is a path, print the length of the shortest such path and its description as a string consisting of characters L (left), R (right), U (up), and D (down). You can print any valid solution.
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Labyrinth {
    static int R, C;
    static int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static char directions[] = {''}

    static boolean isValid(int currR, int currC) {
        return currR >= 0 && currR < R && currC >= 0 && currC < C;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        Queue<State> queue = new LinkedList<>();
        char matrix[][] = new char[R][C];
        for (int row = 0; row < R; row++) {
            String str = sc.nextLine().trim();
            for (int col = 0; col < C; col++) {
                matrix[row][col] = str.charAt(col);
                if(matrix[row][col] == 'A'){
                    queue.offer(new State(row ,col));
                }
            }
        }
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){

            }
        }
    }
}

class State{
    int row;
    int col;
    StringBuilder res;
    State(){
        res = new StringBuilder();
    }
    State(int row ,int col){
        this.row = row;
        this.col = col;
        res = new StringBuilder();
    }
}
