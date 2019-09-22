package org.djunits4.value.vfloat.vector;

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
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalar;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.djunits4.value.vfloat.vector.base.FloatVectorInterface;
import org.junit.Test;

/**
 * Test constructors of FloatVector.
 */
public class FloatVectorConstructorsTest
{
    /**
     * Test the constructors of FloatVector.
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
            // float
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            float[] testValues = new float[] {0, 123.456f, 0, 0, 234.567f, 0, 0};
            int cardinality = 0;
            float zSum = 0;
            List<Float> list = new ArrayList<>();
            SortedMap<Integer, Float> map = new TreeMap<>();
            SortedMap<Integer, Float> notQuiteSparseMap = new TreeMap<>();
            for (int index = 0; index < testValues.length; index++)
            {
                float value = testValues[index];
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
            for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
            {
                FloatVectorInterface<?, ?, ?> floatVector = FloatVector.instantiate(testValues, standardUnit, storageType);
                // System.out.println(floatVector);
                compareValues(testValues, floatVector.getValuesSI());
                assertEquals("Unit must match", standardUnit, floatVector.getUnit());
                assertEquals("StorageType must match", storageType, floatVector.getStorageType());
                assertEquals("Cardinality", cardinality, floatVector.cardinality());
                assertEquals("zSum", zSum, floatVector.zSum(), 0.001);
                String scalarClassName = "org.djunits4.value.vfloat.scalar.Float" + className;
                Class<?> scalarClass = Class.forName(scalarClassName);
                assertEquals("getScalarClass", scalarClass, floatVector.getScalarClass());
                floatVector = FloatVector.instantiateSI(testValues, standardUnit, storageType);
                compareValues(testValues, floatVector.getValuesSI());
                assertEquals("Unit must match", standardUnit, floatVector.getUnit());
                assertEquals("StorageType must match", storageType, floatVector.getStorageType());
                try
                {
                    floatVector.setSI(0, 0);
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    floatVector.setInUnit(0, 0);
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    floatVector.ceil();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                FloatVectorInterface<?, ?, ?> mutable = floatVector.mutable();
                mutable.setSI(0, 0);
                mutable.setInUnit(0, 0);
                try
                {
                    mutable.setSI(-1, 0);
                    fail("negative index should have thrown an excpetion");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    mutable.setSI(testValues.length, 0);
                    fail("negative index should have thrown an excpetion");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                mutable.setSI(testValues.length - 1, 0);
                mutable.ceil();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("ceil", Math.ceil(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                FloatVectorInterface<?, ?, ?> immutable = floatVector.immutable();
                try
                {
                    immutable.ceil();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    floatVector.floor();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    floatVector.rint();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    floatVector.neg();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                mutable = floatVector.mutable().mutable();
                mutable.floor();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("floor", Math.floor(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = floatVector.mutable();
                mutable.rint();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("rint", Math.rint(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                mutable = floatVector.mutable();
                mutable.neg();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("neg", -testValues[index], mutable.getInUnit(index), 0.001);
                }
                int nextIndex = 0;
                for (Iterator<?> iterator = floatVector.iterator(); iterator.hasNext();)
                {
                    AbstractFloatScalar<?, ?> s = (AbstractFloatScalar<?, ?>) iterator.next();
                    assertEquals("unit of scalar matches", s.getUnit(), standardUnit);
                    assertEquals("value of scalar matches", s.getInUnit(), testValues[nextIndex], 0.001);
                    nextIndex++;
                }
                // This does not compile
                // FloatVectorInterface<?, ?, ?> secondary = FloatVector.instantiateAnonymous(floatVector.getScalars(),
                // standardUnit);
                floatVector = FloatVector.instantiate(list, standardUnit, storageType);
                assertEquals("Unit must match", standardUnit, floatVector.getUnit());
                compareValues(testValues, floatVector.getValuesSI());
                floatVector = FloatVector.instantiate(map, testValues.length, standardUnit, storageType);
                compareValues(testValues, floatVector.getValuesSI());
                floatVector = FloatVector.instantiate(notQuiteSparseMap, testValues.length, standardUnit, storageType);
                compareValues(testValues, floatVector.getValuesSI());
                Scalar<?, ?>[] scalarValues = floatVector.getScalars();
                assertEquals("length of array of scalars", testValues.length, scalarValues.length);
                for (int i = 0; i < testValues.length; i++)
                {
                    Scalar<?, ?> s = scalarValues[i];
                    assertEquals("unit of scalar matches", s.getUnit(), standardUnit);
                    assertEquals("value of scalar matches", ((AbstractFloatScalar<?, ?>) s).getSI(), testValues[i], 0.001);
                }
                // TODO get this to compile: floatVector = FloatVector.instantiate(scalarValues, standardUnit, storageType);
                floatVector = FloatVector.instantiateSI(list, standardUnit, storageType);
                assertEquals("Unit must match", standardUnit, floatVector.getUnit());
                compareValues(testValues, floatVector.getValuesSI());
            }
        }
    }

    /**
     * Test constructors of array, list, map with the FloatAbsoluteTemperature unit.
     */
    @Test
    public void instantiateListTest()
    {
        float[] testValues = new float[] {0, 123.456f, 0, 0, 234.567f, 0, 0};
        int cardinality = 0;
        float zSum = 0;
        FloatAbsoluteTemperature[] at = new FloatAbsoluteTemperature[testValues.length];
        List<FloatAbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, FloatAbsoluteTemperature> map = new TreeMap<>();
        SortedMap<Integer, FloatAbsoluteTemperature> notQuiteSparseMap = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            FloatAbsoluteTemperature value = new FloatAbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
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
        for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
        {
            for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] {AbsoluteTemperatureUnit.KELVIN,
                    AbsoluteTemperatureUnit.DEGREE_CELSIUS})
            {
                float offset = temperatureUnit.equals(AbsoluteTemperatureUnit.KELVIN) ? 0f : 273.15f;
                FloatAbsoluteTemperatureVector atv = FloatVector.instantiate(testValues, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : testValues.length, atv.cardinality());
                assertEquals("zSum", zSum + testValues.length * offset, atv.zSum(), 0.001);
                atv = FloatVector.instantiate(at, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = FloatVector.instantiateList(al, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = FloatVector.instantiateMap(map, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                atv = FloatVector.instantiateMap(notQuiteSparseMap, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                assertEquals("zSum", zSum, atv.zSum(), 0.001);
                try
                {
                    atv.setInUnit(0, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                    fail("should have been immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                FloatAbsoluteTemperatureVector matv = atv.mutable();
                matv.setInUnit(0, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                assertEquals("Setting temp in F should have stored equivalent value in K", matv.getSI(0), 255.37, 0.01);
                try
                {
                    matv.setInUnit(-1, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                    fail("negative index should have thrown an exception");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                matv.setInUnit(testValues.length - 1, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                try
                {
                    matv.setInUnit(testValues.length, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                    fail("too large index should have thrown an exception");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                // More complete memory test; somewhat inspired on mats+
                matv = atv.mutable();
                for (int index = 0; index < testValues.length; index++)
                {
                    // read and check; change, read again and check again
                    float v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index], v, 0.001);
                    v += 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + 100, v, 0.001);
                }
                for (int index = testValues.length; --index >= 0;)
                {
                    // read and check, change and check again
                    float v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + 100, v, 0.001);
                    v -= 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index], v, 0.001);
                }
                assertEquals("Cardinality should be back to original value", cardinality, matv.cardinality());
                for (int index = 0; index < testValues.length; index++)
                {
                    // read and check; change, read again and check again
                    float v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index], v, 0.001);
                    v += 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + 100, v, 0.001);
                }
            }
        }
    }

    /**
     * Test the FloatSIVector class.
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
            // float
            @SuppressWarnings("rawtypes")
            Unit standardUnit = unitBase.getStandardUnit();
            float[] testValues = new float[] {0, 123.456f, 0, 0, 234.567f, 0};
            int cardinality = 0;
            float zSum = 0;
            List<Float> list = new ArrayList<>();
            SortedMap<Integer, Float> map = new TreeMap<>();
            for (int index = 0; index < testValues.length; index++)
            {
                float value = testValues[index];
                if (0.0 != value)
                {
                    cardinality++;
                    zSum += value;
                    map.put(index, value);
                }
                list.add(value);
            }
            for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
            {
                FloatSIVector siv = FloatVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), storageType);
                System.out.println(siv);
                compareValues(testValues, siv.getValuesSI());
                // assertEquals("Underlying standardUnit must match", standardUnit, siv.getUnit());
                assertEquals("StorageType must match", storageType, siv.getStorageType());
                assertEquals("Cardinality", cardinality, siv.cardinality());
                assertEquals("zSum", zSum, siv.zSum(), 0.001);
                // String scalarClassName = "org.djunits4.value.vfloat.scalar." + className;
                // Class<?> scalarClass = Class.forName(scalarClassName);
                // assertEquals("getScalarClass", scalarClass, siv.getScalarClass());
                try
                {
                    siv.ceil();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                FloatSIVector mutable = siv.mutable();
                mutable.ceil();
                for (int index = 0; index < testValues.length; index++)
                {
                    assertEquals("ceil", Math.ceil(testValues[index]), mutable.getInUnit(index), 0.001);
                }
                FloatVectorInterface<?, ?, ?> immutable = siv.immutable();
                try
                {
                    immutable.ceil();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.floor();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.rint();
                    fail("float vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    siv.neg();
                    fail("float vector should be immutable");
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
                    AbstractFloatScalar<?, ?> s = (AbstractFloatScalar<?, ?>) iterator.next();
                    assertEquals("SIDimensions match", s.getUnit().getUnitBase().getSiDimensions(), unitBase.getSiDimensions());
                    assertEquals("value of scalar matches", s.getInUnit(), testValues[nextIndex], 0.001);
                    nextIndex++;
                }
                siv = FloatVector.instantiate(list, SIUnit.of(unitBase.getSiDimensions()), storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = FloatVector.instantiate(map, testValues.length, SIUnit.of(unitBase.getSiDimensions()), storageType);
                compareValues(testValues, siv.getValuesSI());
                System.out.println("Creating FloatSIVector for unit " + standardUnit.getId());
                siv = FloatSIVector.of(testValues, standardUnit.getUnitBase().getSiDimensions().toString(true, true, true),
                        storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = FloatSIVector.of(list, unitBase.getSiDimensions().toString(true, true, true), storageType);
                compareValues(testValues, siv.getValuesSI());
                siv = FloatSIVector.of(map, unitBase.getSiDimensions().toString(true, true, true), testValues.length,
                        storageType);
                compareValues(testValues, siv.getValuesSI());
            }
        }

    }

    /**
     * Test all the exception that the constructors may throw.
     * @throws UnitException when that happens uncaught; this test has failed
     * @throws ValueRuntimeException when that happens uncaught; this test has failed
     */
    @Test
    public void exceptionsTest() throws ValueRuntimeException, UnitException
    {
        float[] testValues = new float[] {0f, 123.456f, 0f, 0f, 234.567f, 0f, 0f};
        FloatAbsoluteTemperature[] at = new FloatAbsoluteTemperature[testValues.length];
        List<FloatAbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, FloatAbsoluteTemperature> map = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            FloatAbsoluteTemperature value = new FloatAbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0f != value.si)
            {
                map.put(i, value);
            }
        }

        FloatVector.instantiate(testValues, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            FloatVector.instantiate((float[]) null, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(testValues, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(testValues, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        FloatVector.instantiate(at, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            FloatVector.instantiate((FloatAbsoluteTemperature[]) null, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(at, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(at, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        FloatVector.instantiateList(al, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            FloatVector.instantiateList((List<FloatAbsoluteTemperature>) null, AbsoluteTemperatureUnit.KELVIN,
                    StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateList(al, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateList(al, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        FloatVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            FloatVector.instantiateMap((SortedMap<Integer, FloatAbsoluteTemperature>) null, testValues.length,
                    AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateMap(map, testValues.length, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateMap(map, -1, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("negative length should have thrown an exception");
        }
        catch (NegativeArraySizeException nase)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiateMap(map, 1, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("bad length should have thrown an exception");
        }
        catch (ArrayIndexOutOfBoundsException aeoobe)
        {
            // Ignore expected exception
        }
        map.put(-1, at[0]);
        try
        {
            FloatVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("bad entry in map should have thrown an exception");
        }
        catch (ArrayIndexOutOfBoundsException aeoobe)
        {
            // Ignore expected exception
        }
        map.remove(-1); // Remove the offending entry
        UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase("AbsoluteTemperature" + "Unit");
        FloatVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), StorageType.DENSE);
        try
        {
            FloatVector.instantiate((float[]) null, SIUnit.of(unitBase.getSiDimensions()), StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(testValues, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            FloatVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
    }

    /**
     * Test that parallelized operations work
     */
    @Test
    public void parallelTest()
    {
        float[] testValues = new float[4000];
        for (int i = 0; i < testValues.length; i++)
        {
            testValues[i] = i % 3 != 0 ? 0f : (100.0f + i);
        }
        FloatAbsoluteTemperature[] at = new FloatAbsoluteTemperature[testValues.length];
        List<FloatAbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, FloatAbsoluteTemperature> map = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            FloatAbsoluteTemperature value = new FloatAbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0 != value.si)
            {
                map.put(i, value);
            }
        }
        for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
        {
            for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] {AbsoluteTemperatureUnit.KELVIN,
                    AbsoluteTemperatureUnit.DEGREE_CELSIUS})
            {
                float offset = temperatureUnit.equals(AbsoluteTemperatureUnit.KELVIN) ? 0f : 273.15f;
                FloatAbsoluteTemperatureVector atv = FloatVector.instantiate(testValues, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                atv = FloatVector.instantiateList(al, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                atv = FloatVector.instantiateMap(map, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
            }
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

    /**
     * Compare two float arrays with offset.
     * @param offset float; the expected difference
     * @param reference float[]; the reference values
     * @param got float[] the values that should match the reference values
     */
    public void compareValuesWithOffset(final float offset, final float[] reference, final float[] got)
    {
        assertEquals("length of reference must equal length of result ", reference.length, got.length);
        for (int i = 0; i < reference.length; i++)
        {
            assertEquals("value at each index must match", reference[i] + offset, got[i], 0.001);
        }
    }
}
