package com.epam;

import org.junit.jupiter.api.Test;

class GameEngineBasisConfigurationsTest {

    @Test
    void standardAliveSectorTest2() {
        boolean[][] initialState = {
            {false, false, false, false, false},
            {false, true,  false, false, false},
            {false, false, false, true, false},
            {false, false, true,  false, false},
            {false, false, false, false, false}
        };
        int numberIterations = 1;

        // TODO execute

        boolean[][] expectedState = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, true,  false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        // TODO assertions
    }
}