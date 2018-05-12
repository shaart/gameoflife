package com.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GameEngineImplV2 implements GameEngine {

  private static final int[][] NEIGHBOURS = {
      {-1, -1}, {-1, 0}, {-1, +1},
      {0, -1}, {0, +1},
      {+1, -1}, {+1, 0}, {+1, +1}};

  private static Set<Coord> checkedNextIter = new LinkedHashSet<>();

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

  private static List<Coord> setNeighboursNextState(boolean[][] curIter, boolean[][] nextIter,
      int r, int c) {
    List<Coord> willAlive = new ArrayList<>();

    for (int[] offset : NEIGHBOURS) {

      int row = index(r + offset[0], curIter.length);
      int col = index(c + offset[1], curIter[r].length);

      if (checkedNextIter.contains(new Coord(row, col))) {
        continue;
      }

      boolean isAliveNextIter = nextState(curIter, row, col);
      nextIter[row][col] = isAliveNextIter;
      Coord coord = new Coord(row, col);
      if (isAliveNextIter) {
        willAlive.add(coord);
      }
      checkedNextIter.add(coord);
    }

    return willAlive;
  }

  private static int index(int curIndex, int length) {
    return (curIndex + length) % length;
  }

  @Override
  public boolean[][] compute(boolean[][] initialState, int numberIterations) {
    boolean[][] currIter = initialState;
    final int ROWS = initialState.length;
    final int COLUMNS = initialState[0].length;

    boolean[][] nextIter = new boolean[ROWS][COLUMNS];
    boolean[][] temp;

    List<Coord> aliveNow = new ArrayList<>();

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (currIter[i][j]) {
          aliveNow.add(new Coord(i, j));
        }
      }
    }

    List<Coord> newAlivesAtNext = new ArrayList<>();
    for (int iter = 0; iter < numberIterations; iter++) {
      newAlivesAtNext.clear();
      checkedNextIter.clear();

      for (int i = 0; i < aliveNow.size(); i++) {
        int column = aliveNow.get(i).getColumn();
        int row = aliveNow.get(i).getRow();

        newAlivesAtNext.addAll(setNeighboursNextState(currIter, nextIter, row, column));

        Coord coord = new Coord(row, column);
        if (checkedNextIter.contains(coord)) {
          continue;
        }

        boolean willAlive = nextState(currIter, row, column);
        nextIter[row][column] = willAlive;

        if (!willAlive) {
          aliveNow.remove(i);
          i--;
        }
        checkedNextIter.add(coord);
      }

      temp = currIter;
      currIter = nextIter;
      nextIter = temp;

      System.out.println(Arrays.deepToString(currIter));
    }

    return currIter;
  }
}