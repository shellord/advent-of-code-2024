package org.shellord.adventofcode;

public interface Solution<T> {
     Object parseInput();
     T partOne();
     T partTwo();
}
