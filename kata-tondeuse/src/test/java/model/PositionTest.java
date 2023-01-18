package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void nextPositionAlwaysNorth() {
        //GIVEN
        Position positionActual = new Position(3,4);
        Dimension dimension = new Dimension(5,6);
        Position positionExpected = new Position(3,6);
        //WHEN
        positionActual.nextPosition(Direction.N, dimension);
        positionActual.nextPosition(Direction.N, dimension);
        positionActual.nextPosition(Direction.N, dimension);

        //THEN
        assertTrue(positionExpected.equals(positionActual));
    }

    @Test
    void nextPositionAlwaysSouth() {
        //GIVEN
        Position positionActual = new Position(3,2);
        Dimension dimension = new Dimension(5,6);
        Position positionExpected = new Position(3,0);

        //WHEN
        positionActual.nextPosition(Direction.S, dimension);
        positionActual.nextPosition(Direction.S, dimension);
        positionActual.nextPosition(Direction.S, dimension);

        //THEN
        assertTrue(positionExpected.equals(positionActual));
    }

    @Test
    void nextPositionAlwaysWest() {
        //GIVEN
        Position positionActual = new Position(3,2);
        Dimension dimension = new Dimension(5,6);
        Position positionExpected = new Position(0,2);

        //WHEN
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.W, dimension);

        //THEN
        assertTrue(positionExpected.equals(positionActual));
    }

    @Test
    void nextPositionAlwaysEst() {
        //GIVEN
        Position positionActual = new Position(3,2);
        Dimension dimension = new Dimension(5,6);
        Position positionExpected = new Position(5,2);

        //WHEN
        positionActual.nextPosition(Direction.E, dimension);
        positionActual.nextPosition(Direction.E, dimension);
        positionActual.nextPosition(Direction.E, dimension);
        positionActual.nextPosition(Direction.E, dimension);
        positionActual.nextPosition(Direction.E, dimension);

        //THEN
        assertTrue(positionExpected.equals(positionActual));
    }


    @Test
    void nextPositionAllDirection() {
        //GIVEN
        Position positionActual = new Position(3,2);
        Dimension dimension = new Dimension(5,6);
        Position positionExpected = new Position(2, 0);

        //WHEN
        positionActual.nextPosition(Direction.N, dimension);
        positionActual.nextPosition(Direction.E, dimension);
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.W, dimension);
        positionActual.nextPosition(Direction.S, dimension);
        positionActual.nextPosition(Direction.S, dimension);
        positionActual.nextPosition(Direction.S, dimension);

        //THEN
        assertTrue(positionExpected.equals(positionActual));
    }
}