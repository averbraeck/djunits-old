package org.djunits4.value.vdouble.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.djunits4.Try;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.userdefined.Jerk;
import org.djunits4.userdefined.JerkUnit;
import org.djunits4.userdefined.JerkVector;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.junit.Test;

/**
 * DoubleVectorInstantiateTest.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class DoubleVectorInstantiateTest
{
    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseData()
    {
        LengthVector lvdkm10 = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lvdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvdkm10.getDisplayUnit());

        LengthVector lvskm10 = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lvskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());
        assertEquals(lvdkm10, lvdkm10.toDense());
        assertEquals(lvskm10, lvskm10.toSparse());
        assertTrue(lvdkm10.isDense());
        assertTrue(lvskm10.isSparse());

        LengthVector lvdsi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvdsi10.getDisplayUnit());

        LengthVector lvssi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvssi10.getDisplayUnit());

        LengthVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Length.class), LengthUnit.HECTOMETER,
                StorageType.DENSE);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvdsc10.getDisplayUnit());

        LengthVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Length.class), LengthUnit.HECTOMETER,
                StorageType.SPARSE);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseData()
    {
        LengthVector lvdkm10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lvdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvdkm10.getDisplayUnit());

        LengthVector lvskm10 =
                DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lvskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());

        LengthVector lvdsi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvdsi10.getDisplayUnit());

        LengthVector lvssi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvssi10.getDisplayUnit());

        LengthVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Length.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvdsc10.getDisplayUnit());

        LengthVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Length.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseDataWithClass()
    {
        AreaVector lvdkm10 = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvdkm10.getDisplayUnit());

        AreaVector lvskm10 = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lvskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());

        AreaVector lvdsi10 = DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvdsi10.getDisplayUnit());

        AreaVector lvssi10 = DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvssi10.getDisplayUnit());

        AreaVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvdsc10.getDisplayUnit());

        AreaVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseDataWithClass()
    {
        AreaVector lvdkm10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvdkm10.getDisplayUnit());

        AreaVector lvskm10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lvskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());

        AreaVector lvdsi10 = DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvdsi10.getDisplayUnit());

        AreaVector lvssi10 = DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvssi10.getDisplayUnit());

        AreaVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvdsc10.getDisplayUnit());

        AreaVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseDataWithUserDefinedClass()
    {
        JerkVector lvdkm10 =
                DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), JerkUnit.JERK, StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvdkm10.getDisplayUnit());

        JerkVector lvskm10 =
                DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), JerkUnit.JERK, StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101, lvskm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());

        JerkVector lvdsi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), JerkUnit.JERK, StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsi10.getDisplayUnit());

        JerkVector lvssi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.denseArray(100), JerkUnit.JERK, StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssi10.getDisplayUnit());

        JerkVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Jerk.class), JerkUnit.JERK,
                StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsc10.getDisplayUnit());

        JerkVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.denseScalarArray(100, Jerk.class), JerkUnit.JERK,
                StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseDataWithUserDefinedClass()
    {
        JerkVector lvdkm10 =
                DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvdkm10.getDisplayUnit());

        JerkVector lvskm10 =
                DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11, lvskm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertNotEquals(lvdkm10, lvdkm10.toSparse());
        assertNotEquals(lvskm10, lvskm10.toDense());

        JerkVector lvdsi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsi10.getDisplayUnit());

        JerkVector lvssi10 =
                DoubleVector.instantiateSI(DOUBLEVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssi10.getDisplayUnit());

        JerkVector lvdsc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Jerk.class), JerkUnit.JERK,
                StorageType.DENSE, JerkVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsc10.getDisplayUnit());

        JerkVector lvssc10 = DoubleVector.instantiate(DOUBLEVECTOR.sparseScalarArray(100, Jerk.class), JerkUnit.JERK,
                StorageType.SPARSE, JerkVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     * @throws UnitException on error
     */
    @Test
    public void testInstantiateSIUnit() throws UnitException
    {
        SIVector si10dd = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(100, si10dd.size());
        assertEquals(100, si10dd.cardinality());
        assertEquals(50 * 101, si10dd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10dd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIVector si10ds = DoubleVector.instantiate(DOUBLEVECTOR.denseArray(100), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(100, si10ds.size());
        assertEquals(100, si10ds.cardinality());
        assertEquals(50 * 101, si10ds.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ds.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIVector si10sd = DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(100, si10sd.size());
        assertEquals(10, si10sd.cardinality());
        assertEquals(5 * 11, si10sd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10sd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIVector si10ss = DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(100), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(100, si10ss.size());
        assertEquals(10, si10ss.cardinality());
        assertEquals(5 * 11, si10ss.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ss.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        assertEquals(si10dd, si10ds.toDense());
        assertEquals(si10ds, si10dd.toSparse());
        assertEquals(si10dd, si10dd.toDense());
        assertEquals(si10ds, si10ds.toSparse());
        assertEquals(si10dd, si10dd.toSparse().toDense());
        assertEquals(si10ds, si10ds.toDense().toSparse());

        assertEquals(si10sd, si10ss.toDense());
        assertEquals(si10ss, si10sd.toSparse());
        assertEquals(si10sd, si10sd.toDense());
        assertEquals(si10ss, si10ss.toSparse());
        assertEquals(si10sd, si10sd.toSparse().toDense());
        assertEquals(si10ss, si10ss.toDense().toSparse());
    }

    // =============================================== EDGE CASE MATRICES ===================================================

    /**
     * Test the instantiation of dense and sparse matrix types with one vect or one column, and errors with null pointers and/or
     * zero vects/columns.
     */
    @Test
    public void testInstantiateEdgeCases()
    {
        // DENSE DATA

        SpeedVector vect1dd =
                DoubleVector.instantiate(DOUBLEVECTOR.denseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, vect1dd.size());
        assertEquals(1, vect1dd.cardinality());
        assertEquals(1, vect1dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1dd.getDisplayUnit());

        SpeedVector vect1ds =
                DoubleVector.instantiate(DOUBLEVECTOR.denseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, vect1ds.size());
        assertEquals(1, vect1ds.cardinality());
        assertEquals(1, vect1ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1ds.getDisplayUnit());

        // SPARSE DATA

        SpeedVector vect1sd =
                DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, vect1sd.size());
        assertEquals(1, vect1sd.cardinality());
        assertEquals(1, vect1sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1sd.getDisplayUnit());

        SpeedVector vect1ss =
                DoubleVector.instantiate(DOUBLEVECTOR.sparseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, vect1ss.size());
        assertEquals(1, vect1ss.cardinality());
        assertEquals(1, vect1ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1ss.getDisplayUnit());

        // NULL / ZERO ROWS / ZERO COLS

        double[] d0 = new double[0];
        double[] d1 = new double[1];

        new Try()
        {
            public @Override void execute()
            {
                DoubleVector.instantiate(d0, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with zero vects should have thrown an exception", ValueRuntimeException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleVector.instantiate((double[]) null, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with null input should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleVector.instantiate(d1, null, StorageType.DENSE);
            }
        }.test("constructing matrix with null unit should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleVector.instantiate(d1, SpeedUnit.METER_PER_SECOND, null);
            }
        }.test("constructing matrix with null storage type should have thrown an exception", NullPointerException.class);
    }
}
