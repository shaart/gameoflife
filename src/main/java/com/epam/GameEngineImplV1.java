package com.epam;

import java.util.Arrays;

public class GameEngineImplV1 implements GameEngine {

  private static final int[][] NEIGHBOURS = {
      {-1, -1}, {-1, 0}, {-1, +1},
      {0, -1}, {0, +1},
      {+1, -1}, {+1, 0}, {+1, +1}};

  private static boolean nextState(boolean[][] field, int r, int c) {
    int neighbours = 0;
    for (int[] offset : NEIGHBOURS) {
      if (neighbours > 3) {
        break;
      }

      int row = index(r + offset[0], field.length);
      int col = index(c + offset[1], field[r].length);

      if (field[row][col]) {
        neighbours++;
      }
    }

    return neighbours == 2 && field[r][c] || neighbours == 3;
  }

  private static int index(int curIndex, int length) {
    return (curIndex + length) % length;
  }

  @Override
  public boolean[][] compute(boolean[][] initialState, int numberIterations) {
    final int ROWS = initialState.length;
    final int COLUMNS = initialState[0].length;
    boolean[][] currIter = initialState;
    boolean[][] nextIter = new boolean[ROWS][COLUMNS];
    boolean[][] temp;

    for (int iter = 0; iter < numberIterations; iter++) {
      for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLUMNS; j++) {
          nextIter[i][j] = nextState(currIter, i, j);
        }
      }
      temp = currIter;
      currIter = nextIter;
      nextIter = temp;

      System.out.println(Arrays.deepToString(currIter));
    }

    return currIter;
  }
}