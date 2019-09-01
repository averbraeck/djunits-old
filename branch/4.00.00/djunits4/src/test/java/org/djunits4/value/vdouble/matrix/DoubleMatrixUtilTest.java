package org.djunits4.value.vdouble.matrix;

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
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class DoubleMatrixUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     * @throws ValueException on instantiation error
     */
    @Test
    public final void instantiateTest() throws ValueException
    {
        double[][] a12 = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
        double[][] a1020 = new double[][] { { 10.0, 20.0 }, { 30.0, 40.0 } };
        double[][] a12h = new double[][] { { 100.0, 200.0 }, { 300.0, 400.0 } };
        double[][] a12k = new double[][] { { 1000.0, 2000.0 }, { 3000.0, 4000.0 } };
        double[][] a12k10 = new double[][] { { 10000.0, 20000.0 }, { 30000.0, 40000.0 } };

        DimensionlessMatrix dimensionless = DoubleMatrixUtil.instantiate(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0, dimensionless.getSI(0, 0), 0.0001d);
        dimensionless = DoubleMatrixUtil.instantiateSI(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0, dimensionless.getSI(0, 0), 0.0001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        AccelerationMatrix acceleration = DoubleMatrixUtil.instantiate(a1020, AccelerationUnit.SI, StorageType.DENSE);
        assertEquals("Acceleration", 10.0, acceleration.getSI(0, 0), 0.0001d);
        acceleration = DoubleMatrixUtil.instantiate(new double[][] { { 12960.0, 10.0 }, { 30.0, 40.0 } },
                AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 1.0, acceleration.getSI(0, 0), 0.001d);
        acceleration = DoubleMatrixUtil.instantiateSI(a1020, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 10.0, acceleration.getSI(0, 0), 0.0001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        AngleSolidMatrix angleSolid = DoubleMatrixUtil.instantiate(a1020, AngleSolidUnit.SI, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0, angleSolid.getSI(0, 0), 0.0001d);
        angleSolid = DoubleMatrixUtil.instantiate(a12, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.getSI(0, 0), 0.001d);
        angleSolid = DoubleMatrixUtil.instantiateSI(a1020, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0, angleSolid.getSI(0, 0), 0.0001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        AngleMatrix angle = DoubleMatrixUtil.instantiate(a1020, AngleUnit.SI, StorageType.DENSE);
        assertEquals("Angle", 10.0, angle.getSI(0, 0), 0.0001d);
        angle = DoubleMatrixUtil.instantiate(a12, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", Math.PI / 180.0, angle.getSI(0, 0), 0.001d);
        angle = DoubleMatrixUtil.instantiateSI(a1020, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", 10.0, angle.getSI(0, 0), 0.0001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        DirectionMatrix direction = DoubleMatrixUtil.instantiate(a1020, DirectionUnit.DEFAULT, StorageType.DENSE);
        assertEquals("Direction", 10.0, direction.getSI(0, 0), 0.0001d);
        direction = DoubleMatrixUtil.instantiate(a12, DirectionUnit.EAST_DEGREE, StorageType.DENSE);
        assertEquals("Direction", Math.PI / 180.0, direction.getSI(0, 0), 0.001d);
        direction = DoubleMatrixUtil.instantiateSI(a1020, DirectionUnit.EAST_DEGREE, StorageType.DENSE);
        assertEquals("Direction", 10.0, direction.getSI(0, 0), 0.0001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        AreaMatrix area = DoubleMatrixUtil.instantiate(a1020, AreaUnit.SI, StorageType.DENSE);
        assertEquals("Area", 10.0, area.getSI(0, 0), 0.0001d);
        area = DoubleMatrixUtil.instantiate(a12, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10000.0, area.getSI(0, 0), 0.001d);
        area = DoubleMatrixUtil.instantiateSI(a1020, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10.0, area.getSI(0, 0), 0.0001d);
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
        double[][] a12 = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
        double[][] a1020 = new double[][] { { 10.0, 20.0 }, { 30.0, 40.0 } };
        double[][] a12h = new double[][] { { 100.0, 200.0 }, { 300.0, 400.0 } };
        double[][] a12k = new double[][] { { 1000.0, 2000.0 }, { 3000.0, 4000.0 } };
        double[][] a12k10 = new double[][] { { 10000.0, 20000.0 }, { 30000.0, 40000.0 } };

        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        LengthMatrix length = DoubleMatrixUtil.instantiateAnonymous(a1020, unitSI, StorageType.DENSE);
        assertEquals("Length", 10.0, length.getSI(0, 0), 0.0001d);
        length = DoubleMatrixUtil.instantiateAnonymous(a12, unitKM, StorageType.DENSE);
        assertEquals("Length", 1000.0, length.getSI(0, 0), 0.001d);
        length = DoubleMatrixUtil.instantiateAnonymousSI(a1020, unitKM, StorageType.DENSE);
        assertEquals("Length", 10.0, length.getSI(0, 0), 0.0001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

    }
}
