package org.djunits4.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;

import org.djunits4.unit.DirectionUnit;
import org.junit.Test;

/**
 * DirectionTest.java. <br>
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class DirectionTest
{
    /**
     * Check the conversions and counter clockwise direction.
     */
    @Test
    public final void testDirectionDegToRad()
    {
        Direction directionE10 = new Direction(10.0, DirectionUnit.EAST_DEGREE);
        assertEquals("10 degrees East should be pi*10/180 radians", Math.PI * (10.0 / 180.0), directionE10.si, 0.0001);
        Direction directionN10 = new Direction(10.0, DirectionUnit.NORTH_DEGREE);
        assertEquals("10 degrees North should be pi*100/180 radians", Math.PI * (100.0 / 180.0), directionN10.si, 0.0001);
    }

    /**
     * Check the conversions and counter clockwise direction.
     */
    @Test
    public final void testDirectionStringConversions()
    {
        assertEquals(0.0, Direction.valueOf("0.0 deg(E)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("180 deg(E)").si, 0.0001);
        assertEquals(0.0, Direction.valueOf("0.0deg(E)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("180deg(E)").si, 0.0001);

        assertEquals(0.0, Direction.valueOf("0.0 rad(E)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("3.1415927 rad(E)").si, 0.0001);
        assertEquals(0.0, Direction.valueOf("0.0rad(E)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("3.1415927rad(E)").si, 0.0001);

        assertEquals(0.5 * Math.PI, Direction.valueOf("0.0 deg(N)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("90 deg(N)").si, 0.0001);
        assertEquals(0.5 * Math.PI, Direction.valueOf("0.0deg(N)").si, 0.0001);
        assertEquals(Math.PI, Direction.valueOf("90deg(N)").si, 0.0001);

        assertEquals(0.5 * Math.PI, Direction.valueOf("0.0 rad(N)").si, 0.0001);
        assertEquals(1.5 * Math.PI, Direction.valueOf("3.1415927 rad(N)").si, 0.0001);
        assertEquals(0.5 * Math.PI, Direction.valueOf("0.0rad(N)").si, 0.0001);
        assertEquals(1.5 * Math.PI, Direction.valueOf("3.1415927rad(N)").si, 0.0001);
    }
}
