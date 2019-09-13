package org.djunits4.value.vdouble.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.djunits4.value.vdouble.vector.base.DoubleVectorInterface;
import org.junit.Test;

/**
 * Test constructors of DoubleVector.
 */
public class DoubleVectorConstructorsTest
{
    /**
     * Test the constructors of DoubleVector.
     * @throws ClassNotFoundException if that happens uncaught; this test has failed
     * @throws SecurityException if that happens uncaught; this test has failed
     * @throws NoSuchMethodException if that happens uncaught; this test has failed
     * @throws InvocationTargetException if that happens uncaught; this test has failed
     * @throws IllegalArgumentException if that happens uncaught; this test has failed
     * @throws IllegalAccessException if that happens uncaught; this test has failed
     * @throws InstantiationException if that happens uncaught; this test has failed
     */
    @SuppressWarnings("unchecked")
    @Test
    public void instantiatorTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        // Force loading of all classes
        LengthUnit length = UNITS.METER;
        if (length == null)
        {
            fail();
        }

        for (String className : CLASSNAMES.ALL_NODIM)
        {
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
            // double
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            double[] testValues = new double[] { 0, 123.456d, 0, 0, 234.567d, 0 };
            int cardinality = 0;
            double zSum = 0;
            List<Double> list = new ArrayList<>();
            Map<Integer, Double> map = new HashMap<>();
            for (int index = 0; index < testValues.length; index++)
            {
                double value = testValues[index];
                if (0.0 != value)
                {
                    cardinality++;
                    zSum += value;
                    map.put(index, value);
                }
                list.add(value);
            }
            for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
            {
                DoubleVectorInterface<?, ?, ?> doubleVector = DoubleVector.instantiate(testValues, standardUnit, storageType);
                // System.out.println(doubleVector);
                compareValues(testValues, doubleVector.getValuesSI());
                assertEquals("Unit must match", standardUnit, doubleVector.getUnit());
                assertEquals("StorageType must match", storageType, doubleVector.getStorageType());
                assertEquals("Cardinality", cardinality, doubleVector.cardinality());
                assertEquals("zSum", zSum, doubleVector.zSum(), 0.001);
                String scalarClassName = "org.djunits4.value.vdouble.scalar." + className;
                Class<?> scalarClass = Class.forName(scalarClassName);
                assertEquals("getScalarClass", scalarClass, doubleVector.getScalarClass());
                try
                {
                    doubleVector.ceil();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                DoubleVectorInterface<?, ?, ?> mutable = doubleVector.mutable();
                mutable.ceil();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("ceil", Math.ceil(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                DoubleVectorInterface<?, ?, ?> immutable = doubleVector.immutable();
                try
                {
                    immutable.ceil();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    doubleVector.floor();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    doubleVector.rint();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    doubleVector.neg();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                mutable = doubleVector.mutable().mutable();
                mutable.floor();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("floor", Math.floor(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = doubleVector.mutable();
                mutable.rint();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("rint", Math.rint(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = doubleVector.mutable();
                mutable.neg();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("neg", -testValues[index], mutable.getInUnit(index), 0.001);
                }
                int nextIndex = 0;
                for (Iterator<?> iterator = doubleVector.iterator(); iterator.hasNext();)
                {
                    AbstractDoubleScalar<?, ?> s = (AbstractDoubleScalar<?, ?>) iterator.next();
                    assertEquals("unit of scalar matches", s.getUnit(), standardUnit);
                    assertEquals("value of scalar matches", s.getInUnit(), testValues[nextIndex], 0.001);
                    nextIndex++;
                }
                // This does not compile
                // DoubleVectorInterface<?, ?, ?> secondary = DoubleVector.instantiateAnonymous(doubleVector.getScalars(),
                // standardUnit);
                doubleVector = DoubleVector.instantiate(list, standardUnit, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
                doubleVector = DoubleVector.instantiate(map, standardUnit, testValues.length, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
            }
        }
    }

    /**
     * Test the SIVector class.
     * @throws UnitException if that happens uncaught; this test has failed
     * @throws ValueRuntimeException if that happens uncaught; this test has failed
     * @throws ClassNotFoundException if that happens uncaught; this test has failed
     */
    @Test
    public void siVectorTest() throws ValueRuntimeException, UnitException, ClassNotFoundException
    {
        // Force loading of all classes
        LengthUnit length = UNITS.METER;
        if (length == null)
        {
            fail();
        }

        for (String className : CLASSNAMES.ALL_NODIM)
        {
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
            // double
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            double[] testValues = new double[] { 0, 123.456d, 0, 0, 234.567d, 0 };
            int cardinality = 0;
            double zSum = 0;
            List<Double> list = new ArrayList<>();
            Map<Integer, Double> map = new HashMap<>();
            for (int index = 0; index < testValues.length; index++)
            {
                double value = testValues[index];
                if (0.0 != value)
                {
                    cardinality++;
                    zSum += value;
                    map.put(index, value);
                }
                list.add(value);
            }
            for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
            {
                SIVector siv = SIVector.create(testValues, SIUnit.of(unitBase.getSiDimensions()), storageType);
                System.out.println(siv);
                compareValues(testValues, siv.getValuesSI());
                //assertEquals("Underlying standardUnit must match", standardUnit, siv.getUnit());
                assertEquals("StorageType must match", storageType, siv.getStorageType());
                assertEquals("Cardinality", cardinality, siv.cardinality());
                assertEquals("zSum", zSum, siv.zSum(), 0.001);
                // String scalarClassName = "org.djunits4.value.vdouble.scalar." + className;
                // Class<?> scalarClass = Class.forName(scalarClassName);
                // assertEquals("getScalarClass", scalarClass, siv.getScalarClass());
                try
                {
                    siv.ceil();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                /*-
                SIVector mutable = siv.mutable();
                mutable.ceil();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("ceil", Math.ceil(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                DoubleVectorInterface<?, ?, ?> immutable = siv.immutable();
                try
                {
                    immutable.ceil();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.floor();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.rint();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.neg();
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                mutable = siv.mutable().mutable();
                mutable.floor();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("floor", Math.floor(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = siv.mutable();
                mutable.rint();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("rint", Math.rint(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = siv.mutable();
                mutable.neg();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("neg", -testValues[index], mutable.getInUnit(index), 0.001);
                }
                int nextIndex = 0;
                for (Iterator<?> iterator = siv.iterator(); iterator.hasNext();)
                {
                    AbstractDoubleScalar<?, ?> s = (AbstractDoubleScalar<?, ?>) iterator.next();
                    assertEquals("unit of scalar matches", s.getUnit(), standardUnit);
                    assertEquals("value of scalar matches", s.getInUnit(), testValues[nextIndex], 0.001);
                    nextIndex++;
                }
                // This does not compile
                // DoubleVectorInterface<?, ?, ?> secondary = DoubleVector.instantiateAnonymous(doubleVector.getScalars(),
                // standardUnit);
                siv = SIVector.create(list, SIUnit.of(unitBase.getSiDimensions()), storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = SIVector.create(map, SIUnit.of(unitBase.getSiDimensions()), testValues.length, storageType);
                compareValues(testValues, siv.getValuesSI());
                */
            }
        }

    }

    /**
     * Compare two double arrays.
     * @param reference double[]; the reference values
     * @param got double[] the values that should match the reference values
     */
    public void compareValues(final double[] reference, final double[] got)
    {
        assertEquals("length of reference must equal length of result ", reference.length, got.length);
        for (int i = 0; i < reference.length; i++)
        {
            assertEquals("value at each index must match", reference[i], got[i], 0.001);
        }
    }

    /**
     * Compare two float arrays.
     * @param reference float[]; the reference values
     * @param got float[] the values that should match the reference values
     */
    public void compareValues(final float[] reference, final float[] got)
    {
        assertEquals("length of reference must equal length of result ", reference.length, got.length);
        for (int i = 0; i < reference.length; i++)
        {
            assertEquals("value at each index must match", reference[i], got[i], 0.001);
        }
    }

}
