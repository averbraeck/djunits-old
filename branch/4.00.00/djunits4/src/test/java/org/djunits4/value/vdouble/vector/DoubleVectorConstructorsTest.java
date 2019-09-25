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
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.AbsoluteTemperature;
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
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
                if (doubleVector instanceof Relative)
                {
                    assertEquals("zSum", zSum, ((AbstractDoubleVectorRel<?, ?, ?>) doubleVector).zSum().getSI(), 0.001);
                }
                String scalarClassName = "org.djunits4.value.vdouble.scalar." + className;
                Class<?> scalarClass = Class.forName(scalarClassName);
                assertEquals("getScalarClass", scalarClass, doubleVector.getScalarClass());
                doubleVector = DoubleVector.instantiateSI(testValues, standardUnit, storageType);
                compareValues(testValues, doubleVector.getValuesSI());
                assertEquals("Unit must match", standardUnit, doubleVector.getUnit());
                assertEquals("StorageType must match", storageType, doubleVector.getStorageType());
                try
                {
                    doubleVector.setSI(0, 0);
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                try
                {
                    doubleVector.setInUnit(0, 0);
                    fail("double vector should be immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
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
        double[] testValues = new double[] { 0, 123.456d, 0, -273.15, -273.15, 0, -273.15, 234.567d, 0, 0 };
        int cardinality = 0;
        int offsetCardinality = testValues.length;
        AbsoluteTemperature[] at = new AbsoluteTemperature[testValues.length];
        List<AbsoluteTemperature> al = new ArrayList<>();
        List<Double> adl = new ArrayList<>();
        SortedMap<Integer, AbsoluteTemperature> map = new TreeMap<>();
        SortedMap<Integer, AbsoluteTemperature> notQuiteSparseMap = new TreeMap<>();
        SortedMap<Integer, Double> mapd = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            adl.add(testValues[i]);
            AbsoluteTemperature value = new AbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0 != value.si)
            {
                cardinality++;
                map.put(i, value);
                mapd.put(i, value.si);
                notQuiteSparseMap.put(i, value);
            }
            else if (i % 2 == 0)
            {
                notQuiteSparseMap.put(i, value);
            }
            if (testValues[i] == -273.15)
            {
                offsetCardinality--;
            }
        }
        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] { AbsoluteTemperatureUnit.KELVIN,
                    AbsoluteTemperatureUnit.DEGREE_CELSIUS })
            {
                double offset = temperatureUnit.equals(AbsoluteTemperatureUnit.KELVIN) ? 0 : 273.15;

                AbsoluteTemperatureVector atv = DoubleVector.instantiate(testValues, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());
                atv = DoubleVector.instantiate(testValues, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());

                atv = DoubleVector.instantiateSI(testValues, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateSI(testValues, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiateSI(adl, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateSI(adl, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiate(adl, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());
                atv = DoubleVector.instantiate(adl, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());

                atv = DoubleVector.instantiate(at, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiate(at, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiateList(al, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateList(al, temperatureUnit, storageType, AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiateMap(map, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateMap(map, testValues.length, temperatureUnit, storageType,
                        AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiateMap(notQuiteSparseMap, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateMap(notQuiteSparseMap, testValues.length, temperatureUnit, storageType,
                        AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiate(mapd, testValues.length, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());
                atv = DoubleVector.instantiate(mapd, testValues.length, temperatureUnit, storageType,
                        AbsoluteTemperatureVector.class);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", offset == 0 ? cardinality : offsetCardinality, atv.cardinality());

                atv = DoubleVector.instantiateSI(mapd, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());
                atv = DoubleVector.instantiateSI(mapd, testValues.length, temperatureUnit, storageType,
                        AbsoluteTemperatureVector.class);
                compareValues(testValues, atv.getValuesSI());
                assertEquals("Unit must match", temperatureUnit, atv.getUnit());
                assertEquals("cardinality", cardinality, atv.cardinality());

                atv = DoubleVector.instantiate(testValues, temperatureUnit, storageType);
                try
                {
                    atv.setInUnit(0, 0, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT);
                    fail("should have been immutable");
                }
                catch (ValueRuntimeException vre)
                {
                    // Ignore expected exception
                }
                AbsoluteTemperatureVector matv = atv.mutable();
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
                    double v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + offset, v, 0.001);
                    v += 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value + 100 is returned", testValues[index] + 100 + offset, v, 0.001);
                }
                for (int index = testValues.length; --index >= 0;)
                {
                    // read and check, change and check again
                    double v = matv.getSI(index);
                    assertEquals("initial value + 100 is returned", testValues[index] + 100 + offset, v, 0.001);
                    v -= 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + offset, v, 0.001);
                }
                assertEquals("Cardinality should be back to original value", 0 == offset ? cardinality : offsetCardinality,
                        matv.cardinality());
                for (int index = 0; index < testValues.length; index++)
                {
                    // read and check; change, read again and check again
                    double v = matv.getSI(index);
                    assertEquals("initial value is returned", testValues[index] + offset, v, 0.001);
                    v += 100;
                    matv.setSI(index, v);
                    v = matv.getSI(index);
                    assertEquals("initial value + 100 is returned", testValues[index] + 100 + offset, v, 0.001);
                }
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
                assertEquals("zSum", zSum, siv.zSum().getSI(), 0.001);
                assertEquals("getScalarClass return SIScalar", SIScalar.class, siv.getScalarClass());
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
     * Test all the exception that the constructors may throw.
     * @throws UnitException when that happens uncaught; this test has failed
     * @throws ValueRuntimeException when that happens uncaught; this test has failed
     */
    @Test
    public void exceptionsTest() throws ValueRuntimeException, UnitException
    {
        double[] testValues = new double[] { 0, 123.456d, 0, -273.15, -273.15, 0, -273.15, 234.567d, 0, 0 };
        AbsoluteTemperature[] at = new AbsoluteTemperature[testValues.length];
        List<AbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, AbsoluteTemperature> map = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            AbsoluteTemperature value = new AbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0 != value.si)
            {
                map.put(i, value);
            }
        }

        DoubleVector.instantiate(testValues, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            DoubleVector.instantiate((double[]) null, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiate(testValues, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiate(testValues, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        DoubleVector.instantiate(at, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            DoubleVector.instantiate((AbsoluteTemperature[]) null, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiate(at, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiate(at, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        DoubleVector.instantiateList(al, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            DoubleVector.instantiateList((List<AbsoluteTemperature>) null, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateList(al, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateList(al, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        DoubleVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
        try
        {
            DoubleVector.instantiateMap((SortedMap<Integer, AbsoluteTemperature>) null, testValues.length,
                    AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateMap(map, testValues.length, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, null);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateMap(map, -1, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("negative length should have thrown an exception");
        }
        catch (NegativeArraySizeException nase)
        {
            // Ignore expected exception
        }
        try
        {
            DoubleVector.instantiateMap(map, 1, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("bad length should have thrown an exception");
        }
        catch (ArrayIndexOutOfBoundsException aeoobe)
        {
            // Ignore expected exception
        }
        map.put(-1, at[0]);
        try
        {
            DoubleVector.instantiateMap(map, testValues.length, AbsoluteTemperatureUnit.KELVIN, StorageType.DENSE);
            fail("bad entry in map should have thrown an exception");
        }
        catch (ArrayIndexOutOfBoundsException aeoobe)
        {
            // Ignore expected exception
        }
        map.remove(-1); // Remove the offending entry
        UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase("AbsoluteTemperature" + "Unit");
        SIVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), StorageType.DENSE);
        try
        {
            SIVector.instantiate((double[]) null, SIUnit.of(unitBase.getSiDimensions()), StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            SIVector.instantiate((List<Double>) null, SIUnit.of(unitBase.getSiDimensions()), StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (ValueRuntimeException vre)
        {
            // Ignore expected exception
        }
        try
        {
            SIVector.instantiate(testValues, null, StorageType.DENSE);
            fail("null pointer should have thrown an exception");
        }
        catch (NullPointerException npe)
        {
            // Ignore expected exception
        }
        try
        {
            SIVector.instantiate(testValues, SIUnit.of(unitBase.getSiDimensions()), null);
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
        double[] testValues = new double[4000];
        for (int i = 0; i < testValues.length; i++)
        {
            testValues[i] = i % 3 != 0 ? 0 : (100.0 + i);
        }
        AbsoluteTemperature[] at = new AbsoluteTemperature[testValues.length];
        List<AbsoluteTemperature> al = new ArrayList<>();
        SortedMap<Integer, AbsoluteTemperature> map = new TreeMap<>();
        for (int i = 0; i < testValues.length; i++)
        {
            AbsoluteTemperature value = new AbsoluteTemperature(testValues[i], AbsoluteTemperatureUnit.KELVIN);
            at[i] = value;
            al.add(value);
            if (0.0 != value.si)
            {
                map.put(i, value);
            }
        }
        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] { AbsoluteTemperatureUnit.KELVIN,
                    AbsoluteTemperatureUnit.DEGREE_CELSIUS })
            {
                double offset = temperatureUnit.equals(AbsoluteTemperatureUnit.KELVIN) ? 0 : 273.15;
                AbsoluteTemperatureVector atv = DoubleVector.instantiate(testValues, temperatureUnit, storageType);
                compareValuesWithOffset(offset, testValues, atv.getValuesSI());
                atv = DoubleVector.instantiateList(al, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
                atv = DoubleVector.instantiateMap(map, testValues.length, temperatureUnit, storageType);
                compareValues(testValues, atv.getValuesSI());
            }
        }
    }

    /**
     * Test the plus and similar methods.
     */
    @Test
    public void operationTest()
    {
        double[] testValues = new double[] { 0, 123.456d, 0, -273.15, -273.15, 0, -273.15, 234.567d, 0, 0 };
        double[] testValues2 = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (AbsoluteTemperatureUnit temperatureUnit : new AbsoluteTemperatureUnit[] { AbsoluteTemperatureUnit.KELVIN,
                AbsoluteTemperatureUnit.DEGREE_CELSIUS, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT })
        {
            for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
            {
                AbsoluteTemperatureVector atv = DoubleVector.instantiate(testValues, temperatureUnit, storageType);
                for (TemperatureUnit relativeTemperatureUnit : new TemperatureUnit[] { TemperatureUnit.KELVIN,
                        TemperatureUnit.DEGREE_CELSIUS, TemperatureUnit.DEGREE_FAHRENHEIT })
                {
                    for (StorageType storageType2 : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
                    {
                        TemperatureVector rtv = DoubleVector.instantiate(testValues2, relativeTemperatureUnit, storageType2);
                        AbsoluteTemperatureVector sumtv = atv.plus(rtv);
                        System.out.println("atv:" + atv);
                        System.out.println("rtv:" + rtv);
                        System.out.println("sum:" + sumtv);
                        System.out.println("");
                    }
                }
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
     * Compare two double arrays with offset.
     * @param offset double; the expected difference
     * @param reference double[]; the reference values
     * @param got double[] the values that should match the reference values
     */
    public void compareValuesWithOffset(final double offset, final double[] reference, final double[] got)
    {
        assertEquals("length of reference must equal length of result ", reference.length, got.length);
        for (int i = 0; i < reference.length; i++)
        {
            assertEquals("value at each index must match", reference[i] + offset, got[i], 0.001);
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
