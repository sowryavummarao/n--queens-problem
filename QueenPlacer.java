package com.example.helloworld.nqueenproblem;

import com.example.helloworld.bank.QueueAdder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowryavummarao on 9/14/17.
 */
public class QueenPlacer {
    private int boardSize;
    private int solutionCounter = 1;
    public QueenPlacer(int boardSize){
        this.boardSize = boardSize;
    }
    public void placeQueen(int row,Board starter){
        if (row == boardSize){
            System.out.println("Solution #" + solutionCounter++);
            starter.showBoard();
        }
        else {
            for (int column = 0; column < boardSize; column++) {
                if (starter.isFeasible(row, column)) {
                    Board newBoard = starter.clone();
                    newBoard.setQueen(row, column);
                    placeQueen(row + 1,newBoard);
                }
            }
        }
    }
    public void place(){
        placeQueen(0,new Board(boardSize));
    }
    //    public SudokuBoard placeQueens(){
//        int currentRow = 0;
//        List<int[]> possibleLocations = new ArrayList<>();
//        possibleLocations.add(board.getRow(currentRow));
//        while (currentRow < boardSize) {
//        }
//    }
    public static void main(String[] args) {
        QueenPlacer queenPlacer = new QueenPlacer(16);
        queenPlacer.place();
    }
}
