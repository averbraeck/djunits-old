package org.djunits.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;

import org.djunits.unit.DirectionUnit;
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
}
