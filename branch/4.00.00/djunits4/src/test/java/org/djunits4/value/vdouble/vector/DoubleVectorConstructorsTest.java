package org.djunits4.value.vdouble.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.AbsoluteTemperature;
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

        for (String className : CLASSNAMES.ALL_NODIM_LIST)
        {
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
            // double
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            double[] testValues = new double[] { 0, 123.456d, 0, 0, 234.567d, 0, 0 };
            int cardinality = 0;
            double zSum = 0;
            List<Double> list = new ArrayList<>();
            SortedMap<Integer, Double> map = new TreeMap<>();
            SortedMap<Integer, Double> notQuiteSparseMap = new TreeMap<>();
            for (int index = 0; index < testValues.length; index++)
            {
                double value = testValues[index];
                if (0.0 != value)
                {
                    cardinality++;
                    zSum += value;
                    map.put(index, value);
                    notQuiteSparseMap.put(index, value);
                }
                else if (index % 2 == 0)
                {
                    notQuiteSparseMap.put(index, value);
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
                doubleVector = DoubleVector.instantiateSI(testValues, standardUnit, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
                assertEquals("Unit must match", standardUnit, doubleVector.getUnit());
                assertEquals("StorageType must match", storageType, doubleVector.getStorageType());
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
                assertEquals("Unit must match", standardUnit, doubleVector.getUnit());
                compareValues(testValues, doubleVector.getValuesSI());
                doubleVector = DoubleVector.instantiate(map, testValues.length, standardUnit, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
                doubleVector = DoubleVector.instantiate(notQuiteSparseMap, testValues.length, standardUnit, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
                Scalar<?, ?>[] scalarValues = doubleVector.getScalars();
                assertEquals("length of array of scalars", testValues.length, scalarValues.length);
                for (int i = 0; i < testValues.length; i++)
                {
                    Scalar<?, ?> s = scalarValues[i];
                    assertEquals("unit of scalar matches", s.getUnit(), standardUnit);
                    assertEquals("value of scalar matches", ((AbstractDoubleScalar<?, ?>) s).getSI(), testValues[i], 0.001);
                }
                // TODO get this to compile: doubleVector = DoubleVector.instantiate(scalarValues, standardUnit, storageType);
                doubleVector = DoubleVector.instantiateSI(list, standardUnit, storageType);
                assertEquals("Unit must match", standardUnit, doubleVector.getUnit());
                compareValues(testValues, doubleVector.getValuesSI());
            }
        }
    }

    /**
     * Test constructors of array, list, map with the AbsoluteTemperature unit.
     */
    @Test
    public void instantiateListTest()
    {
        double[] testValues = new double[] { 0, 123.456d, 0, 0, 234.567d, 0, 0 };
        int cardinality = 0;
        double zSum = 0;
        AbsoluteTemperature[] at = new AbsoluteTemperature[testValues.length];
        List<AbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, AbsoluteTemperature> map = new TreeMap<>();
        SortedMap<Integer, AbsoluteTemperature> notQuiteSparseMap = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            AbsoluteTemperature value = new AbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0 != value.si)
            {
                cardinality++;
                zSum += value.si;
                map.put(i, value);
                notQuiteSparseMap.put(i, value);
            }
            else if (i % 2 == 0)
            {
                notQuiteSparseMap.put(i, value);
            }
        }
        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] { AbsoluteTemperatureUnit.KELVIN,
                    AbsoluteTemperatureUnit.DEGREE_CELSIUS })
            {
                AbsoluteTemperatureVector atv = DoubleVector.instantiate(at, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = DoubleVector.instantiateList(al, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = DoubleVector.instantiateMap(map, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = DoubleVector.instantiateMap(notQuiteSparseMap, testValues.length, temperatureUnit,
                        storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
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

        for (String className : CLASSNAMES.ALL_NODIM_LIST)
        {
            System.out.println("class name is " + className);
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
            // double
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            double[] testValues = new double[] { 0, 123.456d, 0, 0, 234.567d, 0 };
            int cardinality = 0;
            double zSum = 0;
            List<Double> list = new ArrayList<>();
            SortedMap<Integer, Double> map = new TreeMap<>();
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
                SIVector siv = SIVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), storageType);
                System.out.println(siv);
                compareValues(testValues, siv.getValuesSI());
                // assertEquals("Underlying standardUnit must match", standardUnit, siv.getUnit());
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
                    assertEquals("SIDimensions match", s.getUnit().getUnitBase().getSiDimensions(), unitBase.getSiDimensions());
                    assertEquals("value of scalar matches", s.getInUnit(), testValues[nextIndex], 0.001);
                    nextIndex++;
                }
                siv = SIVector.instantiate(list, SIUnit.of(unitBase.getSiDimensions()), storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = SIVector.instantiate(map, testValues.length, SIUnit.of(unitBase.getSiDimensions()), storageType);
                compareValues(testValues, siv.getValuesSI());
                System.out.println("Creating SIVector for unit " + standardUnit.getId());
                siv = SIVector.of(testValues, standardUnit.getUnitBase().getSiDimensions().toString(true, true, true),
                        storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = SIVector.of(list, unitBase.getSiDimensions().toString(true, true, true), storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = SIVector.of(map, unitBase.getSiDimensions().toString(true, true, true), testValues.length, storageType);
                compareValues(testValues, siv.getValuesSI());
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
