package com.epam;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@State(Scope.Benchmark)
public class GameEngineBenchmark {

    @Param({"10", "100", "1000"})
    private int numberIterations;

    private boolean[][] field;
    private GameEngine engine;

    @Setup
    public void setup() {
        // TODO initialize field & engine
    }

    @Benchmark
    public boolean[][] compute() {
        return engine.compute(field, numberIterations);
    }
}
