package com.epam;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class GameEngineBasisConfigurationsTest {

  static Random rand = new Random();
  GameEngine engine = new GameEngineImplV1();
  //  GameEngine engine = new GameEngineImplV2();
  GameEngine engineNew = new GameEngineImplV2();

  public static int randInt(int min, int max) {

    return rand.nextInt((max - min) + 1) + min;
  }

  @Test
  void mustPass() {
    boolean[][] initialState = {
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, true},
        {false, false, false, false, false, false, false, false, false, false, true, false, false,
            false, false, false, false, true, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, true, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true,
            false, false, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, true,
            false, false, false, false, true, true, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false}
    };
    boolean[][] initialStateNew = {
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, true},
        {false, false, false, false, false, false, false, false, false, false, true, false, false,
            false, false, false, false, true, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, true, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true,
            false, false, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, true,
            false, false, false, false, true, true, false},
        {false, false, false, false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false}
    };
    int numberIterations = 6;

    boolean[][] result = engine.compute(initialState, numberIterations);
    System.out.println("result calc-ed");
    boolean[][] resultNew = engineNew.compute(initialStateNew, numberIterations);
    System.out.println("resultNew calc-ed");
    assertTrue(Arrays.deepEquals(result, resultNew));
  }

  @Test
  void standardAliveSectorTest2() {
    boolean[][] initialState = {
        {false, false, false, false, false},
        {false, true, false, false, false},
        {false, false, false, true, false},
        {false, false, true, false, false},
        {false, false, false, false, false}
    };
    int numberIterations = 1;

    boolean[][] expectedState = {
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);
    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void smallExploder() {
    boolean[][] initialState = {
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, true, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, true, true, true, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, true, false, true, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, true, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false}
    };
    int numberIterations = 100;

    boolean[][] result = engine.compute(initialState, numberIterations);
  }

  @Test
  void bigField() {
    int ROW_BOUND = 500;
    int COL_BOUND = 500;
    int ITER = 100;
    int ALIVE = 200;

    boolean[][] initialState = new boolean[ROW_BOUND][COL_BOUND];
    Random random = new Random();
    for (int i = 0; i < ALIVE; i++) {
      initialState[randInt(0, ROW_BOUND - 1)][randInt(0, COL_BOUND - 1)] = true;
    }

    int numberIterations = ITER;

    boolean[][] result = engine.compute(initialState, numberIterations);
    assertTrue(result != null);
  }

  @Test
  void sectorWithALot() {
    boolean[][] initialState = {
        {true, false, false},
        {false, true, true},
        {true, true, false}
    };
    int numberIterations = 1;

    boolean[][] expectedState = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);
    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void sectorWithTwo() {
    boolean[][] initialState = {
        {false, false, true},
        {false, true, false},
        {false, false, false}
    };
    int numberIterations = 1;

    boolean[][] expectedState = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);
    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void birthNew() {
    boolean[][] initialState = {
        {false, true, false},
        {true, false, false},
        {false, false, true}
    };
    int numberIterations = 1;

    boolean[][] expectedState = {
        {true, true, true},
        {true, true, true},
        {true, true, true}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);
    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void oneStep() {
    boolean[][] initialState = {
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, true, false},
        {false, true, true, true, false},
        {false, false, false, false, false}
    };
    int numberIterations = 1;

    boolean[][] expectedState = {
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, true, false, true, false},
        {false, false, true, true, false},
        {false, false, true, false, false}
    };
    boolean[][] result = engine.compute(initialState, numberIterations);

    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void twoStep() {
    boolean[][] initialState = {
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, true, false},
        {false, true, true, true, false},
        {false, false, false, false, false}
    };
    int numberIterations = 2;

    boolean[][] expectedState = {
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, true, false},
        {false, true, false, true, false},
        {false, false, true, true, false}
    };
    boolean[][] result = engine.compute(initialState, numberIterations);

    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void threeSteps() {
    boolean[][] initialState = {
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, true, false},
        {false, true, true, true, false},
        {false, false, false, false, false}
    };
    int numberIterations = 3;

    boolean[][] expectedState = {
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, true, true},
        {false, false, true, true, false}
    };
    boolean[][] result = engine.compute(initialState, numberIterations);

    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }

  @Test
  void sixSteps() {
    boolean[][] initialState = {
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, true, false},
        {false, true, true, true, false},
        {false, false, false, false, false}
    };
    int numberIterations = 6;

    boolean[][] expectedState = {
        {false, false, false, true, true},
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, true},
        {false, false, true, false, true}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);

    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }


  @Test
  void noLife() {
    boolean[][] initialState = {
        {false, false, false},
        {false, false, false}
    };
    int numberIterations = 6;

    boolean[][] expectedState = {
        {false, false, false},
        {false, false, false}
    };

    boolean[][] result = engine.compute(initialState, numberIterations);

    assertTrue(Arrays.deepEquals(result, expectedState), "arrays are not equal");
  }
}