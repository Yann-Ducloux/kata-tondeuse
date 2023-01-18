package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void turnLeft450() {
        //GIVEN
        Direction directionActual = Direction.N;
        Direction directionExpected = Direction.W;

        //WHEN
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnLeft();

        //THEN
        assertEquals(directionExpected, directionActual);
    }

    @Test
    void turnRight360() {
        //GIVEN
        Direction directionActual = Direction.S;
        Direction directionExpected = Direction.E;

        //WHEN
        directionActual = directionActual.turnRight();
        directionActual = directionActual.turnRight();
        directionActual = directionActual.turnRight();

        //THEN
        assertEquals(directionExpected, directionActual);
    }
    @Test
    void turnLeftAndTurnRight() {
        //GIVEN
        Direction directionActual = Direction.N;
        Direction directionExpected = Direction.E;

        //WHEN
        directionActual = directionActual.turnRight();
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnLeft();
        directionActual = directionActual.turnRight();
        directionActual = directionActual.turnRight();

        //THEN
        assertEquals(directionExpected, directionActual);
    }
}