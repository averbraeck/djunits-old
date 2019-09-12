package org.djunits4.value.vdouble.vector;

import static org.junit.Assert.assertEquals;

import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.vector.base.DoubleVectorUtil;
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
public class DoubleVectorUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     * @throws ValueRuntimeException on instantiation error
     */
    @Test
    public final void instantiateTest() throws ValueRuntimeException
    {
        double[] a12 = new double[] {1.0, 2.0};
        double[] a1020 = new double[] {10.0, 20.0};
        double[] a12h = new double[] {100.0, 200.0};
        double[] a12k = new double[] {1000.0, 2000.0};
        double[] a12k10 = new double[] {10000.0, 20000.0};

        DimensionlessVector dimensionless = DoubleVectorUtil.instantiate(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0, dimensionless.getSI(0), 0.0001d);

        AccelerationVector acceleration = DoubleVectorUtil.instantiate(a1020, AccelerationUnit.SI, StorageType.DENSE);
        assertEquals("Acceleration", 10.0, acceleration.getSI(0), 0.0001d);
        acceleration =
                DoubleVectorUtil.instantiate(new double[] {12960.0, 10.0}, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 1.0, acceleration.getSI(0), 0.001d);

        AngleSolidVector angleSolid = DoubleVectorUtil.instantiate(a1020, AngleSolidUnit.SI, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0, angleSolid.getSI(0), 0.0001d);
        angleSolid = DoubleVectorUtil.instantiate(a12, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.getSI(0), 0.001d);

        AngleVector angle = DoubleVectorUtil.instantiate(a1020, AngleUnit.SI, StorageType.DENSE);
        assertEquals("Angle", 10.0, angle.getSI(0), 0.0001d);
        angle = DoubleVectorUtil.instantiate(a12, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", Math.PI / 180.0, angle.getSI(0), 0.001d);

        DirectionVector direction = DoubleVectorUtil.instantiate(a1020, DirectionUnit.DEFAULT, StorageType.DENSE);
        assertEquals("Direction", 10.0, direction.getSI(0), 0.0001d);
        direction = DoubleVectorUtil.instantiate(a12, DirectionUnit.EAST_DEGREE, StorageType.DENSE);
        assertEquals("Direction", Math.PI / 180.0, direction.getSI(0), 0.001d);

        AreaVector area = DoubleVectorUtil.instantiate(a1020, AreaUnit.SI, StorageType.DENSE);
        assertEquals("Area", 10.0, area.getSI(0), 0.0001d);
        area = DoubleVectorUtil.instantiate(a12, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10000.0, area.getSI(0), 0.001d);

        // TODO: other base units

    }

    /**
     * Test the instantiation utility function of classes for anonymous units, also for the compiler.
     * @throws ValueRuntimeException on instantiation error
     */
    @Test
    public final void anonymousUnitTest() throws ValueRuntimeException
    {
        double[] a12 = new double[] {1.0, 2.0};
        double[] a1020 = new double[] {10.0, 20.0};
        double[] a12h = new double[] {100.0, 200.0};
        double[] a12k = new double[] {1000.0, 2000.0};
        double[] a12k10 = new double[] {10000.0, 20000.0};

        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        LengthVector length = DoubleVectorUtil.instantiateAnonymous(a1020, unitSI, StorageType.DENSE);
        assertEquals("Length", 10.0, length.getSI(0), 0.0001d);
        length = DoubleVectorUtil.instantiateAnonymous(a12, unitKM, StorageType.DENSE);
        assertEquals("Length", 1000.0, length.getSI(0), 0.001d);

        // TODO: other base units

    }
}
