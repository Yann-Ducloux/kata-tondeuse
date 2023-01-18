package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {

    @Test
    void YInZone() {
        //GIVEN
        Dimension dimension = new Dimension(4, 5);
        int y = 4;

        //WHEN
        Boolean yInZoneActual = dimension.YInZone(y);

        //THEN
        assertTrue(yInZoneActual);
    }
    @Test
    void YInNotZone() {
        //GIVEN
        Dimension dimension = new Dimension(3, 6);
        int y = 7;

        //WHEN
        Boolean yInZoneActual = dimension.YInZone(y);

        //THEN
        assertFalse(yInZoneActual);
    }

    @Test
    void XInZone() {
        //GIVEN
        Dimension dimension = new Dimension(7, 6);
        int x = 5;

        //WHEN
        Boolean xInZoneActual = dimension.XInZone(x);

        //THEN
        assertTrue(xInZoneActual);
    }

    @Test
    void XInNotZone() {
        //GIVEN
        Dimension dimension = new Dimension(7, 6);
        int x = 8;

        //WHEN
        Boolean xInZoneActual = dimension.XInZone(x);

        //THEN
        assertFalse(xInZoneActual);
    }
}