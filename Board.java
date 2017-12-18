package com.example.helloworld.nqueenproblem;

import java.util.Arrays;

/**
 * Created by sowryavummarao on 9/13/17.
 */
public class Board {
    //0 means spot is available
    //1 means spot can't be filled
    //2 means there is a queen on the spot
    private int size;
    private int[][] board;
    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
    }
    public void showBoard() {
        for (int[] element : board) {
            System.out.println(Arrays.toString(element));
        }
    }
    public void setSpotToUnavailable(int row,int column){
        board[row][column] = 0;
    }
    public void setQueen(int row,int column){
        for (int i = 0;i < board.length;i++){
            board[row][i] = 1;
            board[i][column] = 1;
        }
        int startRow = Math.max(row - column,0);
        int startColumn = Math.max(column - row,0);
        while (startRow < size && startColumn < size){
            board[startRow++][startColumn++] = 1;
        }
        int positionsUp = Math.min(row,(Math.abs(size - column - 1)));
        startRow = row - positionsUp;
        startColumn = column + positionsUp;
        while (startRow < size && startColumn >= 0){
            board[startRow++][startColumn--] = 1;
        }
        board[row][column] = 2;
    }
//    public boolean isFeasible(int row,int column){
//        for (int i = 0;i < board.length;i++){
//            if (board[row][i] != 0 || board[i][column] != 0){
//                return false;
//            }
//        }
//        int startRow = Math.max(row - column,0);
//        int startColumn = Math.max(column - row,0);
//        while (startRow < size && startColumn < size){
//            if (board[startRow++][startColumn++] != 0){
//                return false;
//            }
//        }
//        int positionsUp = Math.min(row,(Math.abs(size - column - 1)));
//        startRow = row - positionsUp;
//        startColumn = column + positionsUp;
//        while (startRow < size && startColumn >= 0){
//            if (board[startRow++][startColumn--] != 0){
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isFeasible(int row,int column){
        return(board[row][column] == 0);
    }
    public Board clone(){
        Board clone = new Board(size);
        int y = 0;
        while(y < size){
            int x = 0;
            while (x < size){
                clone.board[y][x] = board[y][x];
                x++;
            }
            y++;
        }
        return clone;
    }
    public int[] getRow(int rowNumber){
        return board[rowNumber];
    }
    public static void main(String[] args) {
        Board test = new Board(8);
        test.setQueen(0,0);
        test.showBoard();
        System.out.println("-----");
        test.setQueen(7,5);
        test.showBoard();
        System.out.println(test.isFeasible(6,1));
        System.out.println("---");
        test.clone().showBoard();
    }
}
