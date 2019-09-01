package org.djunits4.value.vfloat.scalar;

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
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class FloatScalarUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     */
    @Test
    public final void instantiateTest()
    {
        FloatDimensionless dimensionless = FloatScalarUtil.instantiate(10.0f, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0f, dimensionless.getSI(), 0.001d);
        dimensionless = FloatScalarUtil.instantiateSI(10.0f, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0f, dimensionless.getSI(), 0.001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        FloatAcceleration acceleration = FloatScalarUtil.instantiate(10.0f, AccelerationUnit.SI);
        assertEquals("Acceleration", 10.0f, acceleration.getSI(), 0.001d);
        acceleration = FloatScalarUtil.instantiate(12960.0f, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 1.0, acceleration.getSI(), 0.001d);
        acceleration = FloatScalarUtil.instantiateSI(10.0f, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 10.0f, acceleration.getSI(), 0.001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        FloatAngleSolid angleSolid = FloatScalarUtil.instantiate(10.0f, AngleSolidUnit.SI);
        assertEquals("AngleSolid", 10.0f, angleSolid.getSI(), 0.001d);
        angleSolid = FloatScalarUtil.instantiate(1.0f, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.getSI(), 0.001d);
        angleSolid = FloatScalarUtil.instantiateSI(10.0f, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", 10.0f, angleSolid.getSI(), 0.001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        FloatAngle angle = FloatScalarUtil.instantiate(10.0f, AngleUnit.SI);
        assertEquals("Angle", 10.0f, angle.getSI(), 0.001d);
        angle = FloatScalarUtil.instantiate(1.0f, AngleUnit.DEGREE);
        assertEquals("Angle", Math.PI / 180.0, angle.getSI(), 0.001d);
        angle = FloatScalarUtil.instantiateSI(10.0f, AngleUnit.DEGREE);
        assertEquals("Angle", 10.0f, angle.getSI(), 0.001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        FloatDirection direction = FloatScalarUtil.instantiate(10.0f, DirectionUnit.DEFAULT);
        assertEquals("Direction", 10.0f, direction.getSI(), 0.001d);
        direction = FloatScalarUtil.instantiate(1.0f, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", Math.PI / 180.0, direction.getSI(), 0.001d);
        direction = FloatScalarUtil.instantiateSI(10.0f, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", 10.0f, direction.getSI(), 0.001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        FloatArea area = FloatScalarUtil.instantiate(10.0f, AreaUnit.SI);
        assertEquals("Area", 10.0f, area.getSI(), 0.001d);
        area = FloatScalarUtil.instantiate(1.0f, AreaUnit.HECTARE);
        assertEquals("Area", 10000.0, area.getSI(), 0.001d);
        area = FloatScalarUtil.instantiateSI(10.0f, AreaUnit.HECTARE);
        assertEquals("Area", 10.0f, area.getSI(), 0.001d);
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
        FloatLength length = FloatScalarUtil.instantiateAnonymous(10.0f, unitSI);
        assertEquals("Length", 10.0f, length.getSI(), 0.001d);
        length = FloatScalarUtil.instantiateAnonymous(1.0f, unitKM);
        assertEquals("Length", 1000.0, length.getSI(), 0.001d);
        length = FloatScalarUtil.instantiateAnonymousSI(10.0f, unitKM);
        assertEquals("Length", 10.0f, length.getSI(), 0.001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

    }
}
