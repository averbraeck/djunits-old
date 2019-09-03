package org.djunits4.value.vfloat.vector;

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
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.junit.Test;

/**
 * Test the instantiation utility functions.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class FloatVectorUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     * @throws ValueException on instantiation error
     */
    @Test
    public final void instantiateTest() throws ValueException
    {
        float[] a12 = new float[] {1.0f, 2.0f};
        float[] a1020 = new float[] {10.0f, 20.0f};
        float[] a12h = new float[] {100.0f, 200.0f};
        float[] a12k = new float[] {1000.0f, 2000.0f};
        float[] a12k10 = new float[] {10000.0f, 20000.0f};

        FloatDimensionlessVector dimensionless = FloatVectorUtil.instantiate(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0f, dimensionless.getSI(0), 0.001d);
        dimensionless = FloatVectorUtil.instantiateSI(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0f, dimensionless.getSI(0), 0.001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        FloatAccelerationVector acceleration = FloatVectorUtil.instantiate(a1020, AccelerationUnit.SI, StorageType.DENSE);
        assertEquals("Acceleration", 10.0f, acceleration.getSI(0), 0.001d);
        acceleration =
                FloatVectorUtil.instantiate(new float[] {12960.0f, 10.0f}, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 1.0f, acceleration.getSI(0), 0.001d);
        acceleration = FloatVectorUtil.instantiateSI(a1020, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 10.0f, acceleration.getSI(0), 0.001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        FloatAngleSolidVector angleSolid = FloatVectorUtil.instantiate(a1020, AngleSolidUnit.SI, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0f, angleSolid.getSI(0), 0.001d);
        angleSolid = FloatVectorUtil.instantiate(a12, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.getSI(0), 0.001d);
        angleSolid = FloatVectorUtil.instantiateSI(a1020, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0f, angleSolid.getSI(0), 0.001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        FloatAngleVector angle = FloatVectorUtil.instantiate(a1020, AngleUnit.SI, StorageType.DENSE);
        assertEquals("Angle", 10.0f, angle.getSI(0), 0.001d);
        angle = FloatVectorUtil.instantiate(a12, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", Math.PI / 180.0f, angle.getSI(0), 0.001d);
        angle = FloatVectorUtil.instantiateSI(a1020, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", 10.0f, angle.getSI(0), 0.001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        FloatDirectionVector direction = FloatVectorUtil.instantiate(a1020, DirectionUnit.DEFAULT, StorageType.DENSE);
        assertEquals("Direction", 10.0f, direction.getSI(0), 0.001d);
        direction = FloatVectorUtil.instantiate(a12, DirectionUnit.EAST_DEGREE, StorageType.DENSE);
        assertEquals("Direction", Math.PI / 180.0f, direction.getSI(0), 0.001d);
        direction = FloatVectorUtil.instantiateSI(a1020, DirectionUnit.EAST_DEGREE, StorageType.DENSE);
        assertEquals("Direction", 10.0f, direction.getSI(0), 0.001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        FloatAreaVector area = FloatVectorUtil.instantiate(a1020, AreaUnit.SI, StorageType.DENSE);
        assertEquals("Area", 10.0f, area.getSI(0), 0.001d);
        area = FloatVectorUtil.instantiate(a12, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10000.0f, area.getSI(0), 0.001d);
        area = FloatVectorUtil.instantiateSI(a1020, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10.0f, area.getSI(0), 0.001d);
        assertSame("Area", AreaUnit.HECTARE, area.getUnit());

        // TODO: other base units

    }

    /**
     * Test the instantiation utility function of classes for anonymous units, also for the compiler.
     * @throws ValueException on instantiation error
     */
    @Test
    public final void anonymousUnitTest() throws ValueException
    {
        float[] a12 = new float[] {1.0f, 2.0f};
        float[] a1020 = new float[] {10.0f, 20.0f};
        float[] a12h = new float[] {100.0f, 200.0f};
        float[] a12k = new float[] {1000.0f, 2000.0f};
        float[] a12k10 = new float[] {10000.0f, 20000.0f};

        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        FloatLengthVector length = FloatVectorUtil.instantiateAnonymous(a1020, unitSI, StorageType.DENSE);
        assertEquals("Length", 10.0f, length.getSI(0), 0.001d);
        length = FloatVectorUtil.instantiateAnonymous(a12, unitKM, StorageType.DENSE);
        assertEquals("Length", 1000.0f, length.getSI(0), 0.001d);
        length = FloatVectorUtil.instantiateAnonymousSI(a1020, unitKM, StorageType.DENSE);
        assertEquals("Length", 10.0f, length.getSI(0), 0.001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

    }
}
