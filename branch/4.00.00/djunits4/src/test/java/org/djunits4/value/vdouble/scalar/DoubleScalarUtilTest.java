package org.djunits4.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.Unit;
import org.junit.Test;

/**
 * Test the instantiation utility functions.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class DoubleScalarUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     */
    @Test
    public final void instantiateTest()
    {
        Dimensionless dimensionless = DoubleScalarUtil.instantiate(10.0, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0, dimensionless.si, 0.0001d);
        dimensionless = DoubleScalarUtil.instantiateSI(10.0, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0, dimensionless.si, 0.0001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        Acceleration acceleration = DoubleScalarUtil.instantiate(10.0, AccelerationUnit.SI);
        assertEquals("Acceleration", 10.0, acceleration.si, 0.0001d);
        acceleration = DoubleScalarUtil.instantiate(12960.0, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 1.0, acceleration.si, 0.001d);
        acceleration = DoubleScalarUtil.instantiateSI(10.0, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 10.0, acceleration.si, 0.0001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        AngleSolid angleSolid = DoubleScalarUtil.instantiate(10.0, AngleSolidUnit.SI);
        assertEquals("AngleSolid", 10.0, angleSolid.si, 0.0001d);
        angleSolid = DoubleScalarUtil.instantiate(1.0, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.si, 0.001d);
        angleSolid = DoubleScalarUtil.instantiateSI(10.0, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", 10.0, angleSolid.si, 0.0001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        Angle angle = DoubleScalarUtil.instantiate(10.0, AngleUnit.SI);
        assertEquals("Angle", 10.0, angle.si, 0.0001d);
        angle = DoubleScalarUtil.instantiate(1.0, AngleUnit.DEGREE);
        assertEquals("Angle", Math.PI / 180.0, angle.si, 0.001d);
        angle = DoubleScalarUtil.instantiateSI(10.0, AngleUnit.DEGREE);
        assertEquals("Angle", 10.0, angle.si, 0.0001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        Direction direction = DoubleScalarUtil.instantiate(10.0, DirectionUnit.DEFAULT);
        assertEquals("Direction", 10.0, direction.si, 0.0001d);
        direction = DoubleScalarUtil.instantiate(1.0, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", Math.PI / 180.0, direction.si, 0.001d);
        direction = DoubleScalarUtil.instantiateSI(10.0, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", 10.0, direction.si, 0.0001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        Area area = DoubleScalarUtil.instantiate(10.0, AreaUnit.SI);
        assertEquals("Area", 10.0, area.si, 0.0001d);
        area = DoubleScalarUtil.instantiate(1.0, AreaUnit.HECTARE);
        assertEquals("Area", 10000.0, area.si, 0.001d);
        area = DoubleScalarUtil.instantiateSI(10.0, AreaUnit.HECTARE);
        assertEquals("Area", 10.0, area.si, 0.0001d);
        assertSame("Area", AreaUnit.HECTARE, area.getUnit());

        // TODO: other base units

    }

    /**
     * Test the instantiation utility function of classes for anonymous units, also for the compiler.
     */
    @Test
    public final void anonymousUnitTest()
    {
        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        Length length = DoubleScalarUtil.instantiateAnonymous(10.0, unitSI);
        assertEquals("Length", 10.0, length.si, 0.0001d);
        length = DoubleScalarUtil.instantiateAnonymous(1.0, unitKM);
        assertEquals("Length", 1000.0, length.si, 0.001d);
        length = DoubleScalarUtil.instantiateAnonymousSI(10.0, unitKM);
        assertEquals("Length", 10.0, length.si, 0.0001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

    }
}
