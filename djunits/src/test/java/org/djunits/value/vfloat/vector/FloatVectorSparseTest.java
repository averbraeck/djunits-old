package org.djunits.value.vfloat.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.junit.Test;

/**
 * Test the FloatVector class.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatVectorSparseTest
{
    /**
     * Generate sparse test data.
     * @param size int; number of values in the result
     * @param startValue float; seed value
     * @param firstNonZero int; index of first non-zero value
     * @param zeroRangeLength int; number of zero values to insert between each pair of generated (probably non-zero) values
     * @return float[]
     */
    private static float[] data(final int size, final float startValue, final int firstNonZero, final int zeroRangeLength)
    {
        float[] result = new float[size];
        for (int index = firstNonZero; index < size; index += zeroRangeLength + 1)
        {
            result[index] = index - firstNonZero + startValue;
        }
        return result;
    }

    /**
     * Check that the values in a FloatVectormatch the expected values.
     * @param dv FloatVector&lt;?&gt;; the FloatVector to match
     * @param reference float[]; the reference values
     * @param precision double; the maximum allowed error
     * @param u Unit&lt;?&gt;; the expected type
     * @param expectAbsolute boolean; if true; dv should be Absolute; if false; dv should be Relative
     */
    private static void checkContentsAndType(final AbstractFloatVector<?, ?> dv, final float[] reference,
            final double precision, final Unit<?> u, final boolean expectAbsolute)
    {
        assertTrue("FloatVector should not be null", null != dv);
        for (int index = dv.size(); --index >= 0;)
        {
            try
            {
                assertEquals("Value should match", reference[index], dv.getInUnit(index), precision);
            }
            catch (ValueException exception)
            {
                fail("Unexpected exception");
            }
        }
        assertEquals("Unit should be " + u.toString(), u, dv.getUnit());
        assertTrue("Should be " + (expectAbsolute ? "Absolute" : "Relative"),
                expectAbsolute ? dv.isAbsolute() : dv.isRelative());
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringAbsTest()
    {
        try
        {
            AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.KELVIN;
            float[] value = data(99, 38.0f, 2, 10);
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dv =
                    new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            String result = dv.toString(true, true);
            assertTrue("toString result contains \" Abs \"", result.contains(" Abs "));
            assertTrue("toString result contains \"K\"", result.contains("K"));
            assertTrue("toString result starts with \"Immutable \"", result.startsWith("Immutable"));
            assertTrue("toString contains \"Sparse\"", result.contains("Sparse"));
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringMutableAbsTest()
    {
        try
        {
            AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.KELVIN;
            float[] value = data(99, 38.0f, 2, 10);
            MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dv =
                    new MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            String result = dv.toString(true, true);
            assertTrue("toString result contains \" Abs \"", result.contains(" Abs "));
            assertTrue("toString result contains \"K\"", result.contains("K"));
            assertTrue("toString result starts with \"Immutable \"", result.startsWith("Mutable"));
            assertTrue("toString contains \"Sparse\"", result.contains("Sparse"));
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test constructor, verify the various fields in the constructed objects, test conversions to related units.
     */
    @SuppressWarnings({ "static-method", "unchecked" })
    @Test
    public final void basicsAbsTest()
    {
        try
        {
            AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.DEGREE_CELSIUS;
            float[] value = data(99, 38.0f, 2, 10);
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> temperatureDV =
                    new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            checkContentsAndType(temperatureDV, value, 0.001, tempUnit, true);
            assertEquals("Value in SI is equivalent in Kelvin", 311.15, temperatureDV.getSI(2), 0.05);
            assertEquals("Value in Fahrenheit", 100.4, temperatureDV.getInUnit(2, AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT),
                    0.1);
            float[] out = temperatureDV.getValuesInUnit();
            for (int index = 0; index < value.length; index++)
            {
                assertEquals("Value should match", value[index], out[index], 0.001);
            }
            MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> mdv =
                    new MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            checkContentsAndType(mdv, value, 0.001, tempUnit, true);
            mdv.setSI(0, 73);
            float safe = value[0];
            value[0] = -200; // Approximate Celsius equivalent of 73 Kelvin
            checkContentsAndType(mdv, value, 1, tempUnit, true);
            value[0] = safe; // Restore
            mdv.set(0, temperatureDV.get(0));
            checkContentsAndType(mdv, value, 0.001, tempUnit, true);
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> temperature2DV =
                    new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(temperatureDV.getValuesSI(),
                            AbsoluteTemperatureUnit.KELVIN, StorageType.SPARSE);
            assertTrue("temperature2DV should be equal to temperatureDV", temperature2DV.equals(temperatureDV));
            assertTrue("Value is Absolute", temperatureDV.isAbsolute());
            assertFalse("Value is not Relative", temperatureDV.isRelative());
            temperatureDV = new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, AbsoluteTemperatureUnit.KELVIN,
                    StorageType.SPARSE);
            checkContentsAndType(temperatureDV, value, 0.001, AbsoluteTemperatureUnit.KELVIN, true);
            out = temperatureDV.getValuesSI();
            for (int index = 0; index < value.length; index++)
            {
                assertEquals("Value should match", value[index], out[index], 0.001);
            }
            FloatScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>[] scalar = new FloatScalar.Abs[value.length];
            for (int index = 0; index < value.length; index++)
            {
                scalar[index] = new FloatScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value[index],
                        AbsoluteTemperatureUnit.DEGREE_CELSIUS);
            }
            temperatureDV = new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(scalar, StorageType.SPARSE);
            checkContentsAndType(temperatureDV, value, 0.001, tempUnit, true);
            assertEquals("All cells != 0; cardinality should equal number of cells", value.length, temperatureDV.cardinality());
            float sum = 0;
            for (int index = 0; index < value.length; index++)
            {
                sum += temperatureDV.getSI(index);
            }
            assertEquals("zSum should be sum of all values", sum, temperatureDV.zSum(), 0.1);
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test conversion to mutable equivalent and back.
     */
    @Test
    public final void toMutableAndBackAbsTest()
    {
        try
        {
            AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.DEGREE_CELSIUS;
            float[] value = data(99, 38.0f, 2, 10);
            float[] value2 = data(99, 38.0f, 2, 10);
            value2[0] = 12345;
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dv =
                    new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dvCopy = dv;
            MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> mdv = dv.mutable();
            checkContentsAndType(dv, value, 0.001, tempUnit, true);
            checkContentsAndType(mdv, value, 0.001, tempUnit, true);
            checkContentsAndType(dvCopy, value, 0.001, tempUnit, true);
            MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> mdvCopy = mdv.copy();
            checkContentsAndType(mdvCopy, value, 0.001, tempUnit, true);
            MutableFloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> mmdv = mdv.mutable();
            checkContentsAndType(mmdv, value, 0.001, tempUnit, true);
            assertEquals("hashCode is independent on mutability", dv.hashCode(), mdv.hashCode());
            // Modify mdv
            mdv.setInUnit(0, 12345, AbsoluteTemperatureUnit.DEGREE_CELSIUS);
            checkContentsAndType(dv, value, 0.001, tempUnit, true);
            checkContentsAndType(mdv, value2, 0.01, tempUnit, true);
            checkContentsAndType(mdvCopy, value, 0.001, tempUnit, true);
            checkContentsAndType(mmdv, value, 0.001, tempUnit, true);
            FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> idv = mdv.immutable();
            assertTrue("Different value extremely likely results in different hashCode", dv.hashCode() != mdv.hashCode());
            // Restore value of mdv
            mdv.setSI(0, dv.getSI(0));
            checkContentsAndType(idv, value2, 0.01, tempUnit, true);
            checkContentsAndType(mdv, value, 0.001, tempUnit, true);
            checkContentsAndType(mmdv, value, 0.001, tempUnit, true);
            mmdv.setSI(0, 0);
            checkContentsAndType(mdv, value, 0.001, tempUnit, true);
            assertEquals("value should be about -273", -273, mmdv.getInUnit(0, tempUnit), 0.2);
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test the equals method.
     */
    @Test
    public final void equalsAbsTest()
    {
        LengthUnit lengthUnit = LengthUnit.METER;
        PositionUnit positionUnit = PositionUnit.BASE;
        float value = 38.0f;
        FloatScalar.Abs<PositionUnit, LengthUnit> dv = new FloatScalar.Abs<PositionUnit, LengthUnit>(value, positionUnit);
        assertTrue("Equal to itself", dv.equals(dv));
        assertFalse("Not equal to null", dv.equals(null));
        assertFalse("Not equal to some other kind of object; e.g. a String", dv.equals(new String("abc")));
        FloatScalar.Rel<LengthUnit> dvCounterPart = new FloatScalar.Rel<LengthUnit>(value, lengthUnit);
        assertFalse("Not equal if one Absolute and other Relative", dv.equals(dvCounterPart));
        FloatScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dvWrongBaseUnit =
                new FloatScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, AbsoluteTemperatureUnit.KELVIN);
        assertEquals("The underlying SI values are the same", dv.getSI(), dvWrongBaseUnit.getSI(), 0.0001);
        assertFalse("Not equals because the standard SI unit differs", dv.equals(dvWrongBaseUnit));
        FloatScalar.Abs<PositionUnit, LengthUnit> dvCompatibleUnit =
                new FloatScalar.Abs<PositionUnit, LengthUnit>(38000.0f, PositionUnit.MILLIMETER);
        assertFalse("Units are different", dv.getUnit().equals(dvCompatibleUnit.getUnit()));
        assertTrue("equals returns true", dv.equals(dvCompatibleUnit));
        FloatScalar.Abs<PositionUnit, LengthUnit> dvDifferentValue =
                new FloatScalar.Abs<PositionUnit, LengthUnit>(123.456f, PositionUnit.MILLIMETER);
        assertFalse("Different value makes equals return false", dv.equals(dvDifferentValue));
    }

    /**
     * Test the Math functions.
     */
    @Test
    public final void mathFunctionsTestAbsTest()
    {
        float[] seedValues = { -10f, -2f, -1f, -0.5f, -0.1f, 0f, 0.1f, 0.5f, 1f, 2f, 10f };
        for (float seedValue : seedValues)
        {
            float[] input = data(99, seedValue, 2, 10);
            MutableFloatVector.Abs<PositionUnit, LengthUnit> dv;
            try
            {
                dv = new MutableFloatVector.Abs<PositionUnit, LengthUnit>(input, PositionUnit.METER, StorageType.SPARSE);
                dv.ceil();
                MathTester.tester(input, "ceil", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.ceil(d);
                    }
                });
                dv = new MutableFloatVector.Abs<PositionUnit, LengthUnit>(input, PositionUnit.METER, StorageType.SPARSE);
                dv.floor();
                MathTester.tester(input, "floor", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.floor(d);
                    }
                });
                dv = new MutableFloatVector.Abs<PositionUnit, LengthUnit>(input, PositionUnit.METER, StorageType.SPARSE);
                dv.rint();
                MathTester.tester(input, "rint", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.rint(d);
                    }
                });
                dv = new MutableFloatVector.Abs<PositionUnit, LengthUnit>(input, PositionUnit.METER, StorageType.SPARSE);
                dv.round();
                MathTester.tester(input, "round", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return Math.round(d);
                    }
                });
            }
            catch (ValueException ve)
            {
                fail("Caught unexpected ValueException: " + ve.toString());
            }
        }
    }

    /**
     * Test plus(FloatVectorAbs.Sparse, FloatVectorRel.Dense).
     */
    @Test
    public final void binaryplusOfAbsSparseAndRelDenseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Abs<PositionUnit, LengthUnit> left =
                    new FloatVector.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Abs<?, ?> result = left.plus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI plus of contributing elements", left.getSI(i) + right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test minus(FloatVectorAbs.Sparse, FloatVectorRel.Dense).
     */
    @Test
    public final void binaryminusOfAbsSparseAndRelDenseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Abs<PositionUnit, LengthUnit> left =
                    new FloatVector.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Abs<?, ?> result = left.minus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI minus of contributing elements", left.getSI(i) - right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test plus(FloatVectorAbs.Sparse, FloatVectorRel.Sparse).
     */
    @Test
    public final void binaryplusOfAbsSparseAndRelSparseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Abs<PositionUnit, LengthUnit> left =
                    new FloatVector.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Abs<?, ?> result = left.plus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI plus of contributing elements", left.getSI(i) + right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test minus(FloatVectorAbs.Sparse, FloatVectorRel.Sparse).
     */
    @Test
    public final void binaryminusOfAbsSparseAndRelSparseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Abs<PositionUnit, LengthUnit> left =
                    new FloatVector.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Abs<?, ?> result = left.minus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI minus of contributing elements", left.getSI(i) - right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test that malformed or mismatching arrays throw a ValueException.
     */
    @Test
    public final void sizeCheckAbsTest()
    {
        int junk = 0;
        try
        {
            // null array
            new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>((float[]) null,
                    AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT, StorageType.SPARSE);
            fail("Preceding code should have thrown a ValueException");
        }
        catch (ValueException ve)
        {
            // Ignore (exception was expected)
            junk++;
        }
        assertTrue("The variable junk is only used to suppress annoying warnings of the code checker", junk > 0);
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringRelTest()
    {
        try
        {
            TemperatureUnit tempUnit = TemperatureUnit.KELVIN;
            float[] value = data(99, 38.0f, 2, 10);
            FloatVector.Rel<TemperatureUnit> dv = new FloatVector.Rel<TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            String result = dv.toString(true, true);
            assertTrue("toString result contains \" Rel \"", result.contains(" Rel "));
            assertTrue("toString result contains \"K\"", result.contains("K"));
            assertTrue("toString result starts with \"Immutable \"", result.startsWith("Immutable"));
            assertTrue("toString contains \"Sparse\"", result.contains("Sparse"));
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringMutableRelTest()
    {
        try
        {
            TemperatureUnit tempUnit = TemperatureUnit.KELVIN;
            float[] value = data(99, 38.0f, 2, 10);
            MutableFloatVector.Rel<TemperatureUnit> dv =
                    new MutableFloatVector.Rel<TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            String result = dv.toString(true, true);
            assertTrue("toString result contains \" Rel \"", result.contains(" Rel "));
            assertTrue("toString result contains \"K\"", result.contains("K"));
            assertTrue("toString result starts with \"Immutable \"", result.startsWith("Mutable"));
            assertTrue("toString contains \"Sparse\"", result.contains("Sparse"));
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test constructor, verify the various fields in the constructed objects, test conversions to related units.
     */
    @SuppressWarnings({ "static-method", "unchecked" })
    @Test
    public final void basicsRelTest()
    {
        try
        {
            TemperatureUnit tempUnit = TemperatureUnit.DEGREE_CELSIUS;
            float[] value = data(99, 38.0f, 2, 10);
            FloatVector.Rel<TemperatureUnit> temperatureFV =
                    new FloatVector.Rel<TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            checkContentsAndType(temperatureFV, value, 0.001, tempUnit, false);
            assertEquals("Value in SI is equivalent in Kelvin", 38.0, temperatureFV.getSI(2), 0.05);
            assertEquals("Value in Fahrenheit", 38.0 * 9.0 / 5.0, temperatureFV.getInUnit(2, TemperatureUnit.DEGREE_FAHRENHEIT),
                    0.1);
            float[] out = temperatureFV.getValuesInUnit();
            for (int index = 0; index < value.length; index++)
            {
                assertEquals("Value should match", value[index], out[index], 0.001);
            }
            MutableFloatVector.Rel<TemperatureUnit> mdv =
                    new MutableFloatVector.Rel<TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            checkContentsAndType(mdv, value, 0.001, tempUnit, false);
            FloatVector.Rel<TemperatureUnit> temperature2DV = new FloatVector.Rel<TemperatureUnit>(temperatureFV.getValuesSI(),
                    TemperatureUnit.KELVIN, StorageType.SPARSE);
            assertTrue("temperature2DV should be equal to temperatureDV", temperature2DV.equals(temperatureFV));
            assertTrue("Value is Relative", temperatureFV.isRelative());
            assertFalse("Value is not Absolute", temperatureFV.isAbsolute());
            temperatureFV = new FloatVector.Rel<TemperatureUnit>(value, TemperatureUnit.KELVIN, StorageType.SPARSE);
            checkContentsAndType(temperatureFV, value, 0.001, TemperatureUnit.KELVIN, false);
            out = temperatureFV.getValuesSI();
            for (int index = 0; index < value.length; index++)
            {
                assertEquals("Value should match", value[index], out[index], 0.001);
            }
            FloatScalar.Rel<TemperatureUnit>[] scalar = new FloatScalar.Rel[value.length];
            for (int index = 0; index < value.length; index++)
            {
                scalar[index] = new FloatScalar.Rel<TemperatureUnit>(value[index], TemperatureUnit.DEGREE_CELSIUS);
            }
            temperatureFV = new FloatVector.Rel<TemperatureUnit>(scalar, StorageType.SPARSE);
            checkContentsAndType(temperatureFV, value, 0.001, tempUnit, false);
            int nonNullCount = 0;
            for (int i = 0; i < value.length; i++)
            {
                if (value[i] != 0f)
                {
                    nonNullCount++;
                }
            }
            assertEquals("All cells != 0; cardinality should equal number of cells", nonNullCount, temperatureFV.cardinality());
            float sum = 0;
            for (int index = 0; index < value.length; index++)
            {
                sum += temperatureFV.getSI(index);
            }
            assertEquals("zSum should be sum of all values", sum, temperatureFV.zSum(), 0.001);
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test conversion to mutable equivalent and back.
     */
    @Test
    public final void toMutableAndBackRelTest()
    {
        try
        {
            TemperatureUnit tempUnit = TemperatureUnit.DEGREE_CELSIUS;
            float[] value = data(99, 38.0f, 2, 10);
            float[] value2 = data(99, 38.0f, 2, 10);
            value2[0] = 12345;
            FloatVector.Rel<TemperatureUnit> dv = new FloatVector.Rel<TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            FloatVector.Rel<TemperatureUnit> dvCopy = dv;
            MutableFloatVector.Rel<TemperatureUnit> mdv = dv.mutable();
            checkContentsAndType(dv, value, 0.001, tempUnit, false);
            checkContentsAndType(mdv, value, 0.001, tempUnit, false);
            checkContentsAndType(dvCopy, value, 0.001, tempUnit, false);
            MutableFloatVector.Rel<TemperatureUnit> mdvCopy = mdv.copy();
            checkContentsAndType(mdvCopy, value, 0.001, tempUnit, false);
            MutableFloatVector.Rel<TemperatureUnit> mmdv = mdv.mutable();
            checkContentsAndType(mmdv, value, 0.001, tempUnit, false);
            assertEquals("hashCode is independent on mutability", dv.hashCode(), mdv.hashCode());
            // Modify mdv
            mdv.setInUnit(0, 12345, TemperatureUnit.DEGREE_CELSIUS);
            checkContentsAndType(dv, value, 0.001, tempUnit, false);
            checkContentsAndType(mdv, value2, 0.01, tempUnit, false);
            checkContentsAndType(mdvCopy, value, 0.001, tempUnit, false);
            checkContentsAndType(mmdv, value, 0.001, tempUnit, false);
            FloatVector.Rel<TemperatureUnit> idv = mdv.immutable();
            assertTrue("Different value extremely likely results in different hashCode", dv.hashCode() != mdv.hashCode());
            // Restore value of mdv
            mdv.setSI(0, dv.getSI(0));
            checkContentsAndType(idv, value2, 0.01, tempUnit, false);
            checkContentsAndType(mdv, value, 0.001, tempUnit, false);
            checkContentsAndType(mmdv, value, 0.001, tempUnit, false);
            mmdv.setSI(0, 0);
            checkContentsAndType(mdv, value, 0.001, tempUnit, false);
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * Test the equals method.
     */
    @Test
    public final void equalsRelTest()
    {
        LengthUnit lengthUnit = LengthUnit.METER;
        PositionUnit positionUnit = PositionUnit.BASE;
        float value = 38.0f;
        FloatScalar.Rel<LengthUnit> dv = new FloatScalar.Rel<LengthUnit>(value, lengthUnit);
        assertTrue("Equal to itself", dv.equals(dv));
        assertFalse("Not equal to null", dv.equals(null));
        assertFalse("Not equal to some other kind of object; e.g. a String", dv.equals(new String("abc")));
        FloatScalar.Abs<PositionUnit, LengthUnit> dvCounterPart =
                new FloatScalar.Abs<PositionUnit, LengthUnit>(value, positionUnit);
        assertFalse("Not equal if one Absolute and other Relative", dv.equals(dvCounterPart));
        FloatScalar.Rel<TemperatureUnit> dvWrongBaseUnit = new FloatScalar.Rel<TemperatureUnit>(value, TemperatureUnit.KELVIN);
        assertEquals("The underlying SI values are the same", dv.getSI(), dvWrongBaseUnit.getSI(), 0.0001);
        assertFalse("Not equals because the standard SI unit differs", dv.equals(dvWrongBaseUnit));
        FloatScalar.Rel<LengthUnit> dvCompatibleUnit = new FloatScalar.Rel<LengthUnit>(38000.0f, LengthUnit.MILLIMETER);
        assertFalse("Units are different", dv.getUnit().equals(dvCompatibleUnit.getUnit()));
        assertTrue("equals returns true", dv.equals(dvCompatibleUnit));
        FloatScalar.Rel<LengthUnit> dvDifferentValue = new FloatScalar.Rel<LengthUnit>(123.456f, LengthUnit.MILLIMETER);
        assertFalse("Different value makes equals return false", dv.equals(dvDifferentValue));
    }

    /**
     * Test the Math functions.
     */
    @Test
    public final void mathFunctionsTestRelTest()
    {
        float[] seedValues = { -10f, -2f, -1f, -0.5f, -0.1f, 0f, 0.1f, 0.5f, 1f, 2f, 10f };
        for (float seedValue : seedValues)
        {
            float[] input = data(99, seedValue, 2, 10);
            MutableFloatVector.Rel<LengthUnit> dv;
            try
            {
                dv = new MutableFloatVector.Rel<LengthUnit>(input, LengthUnit.METER, StorageType.SPARSE);
                dv.abs();
                MathTester.tester(input, "abs", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return Math.abs(d);
                    }
                });
                dv = new MutableFloatVector.Rel<LengthUnit>(input, LengthUnit.METER, StorageType.SPARSE);
                dv.ceil();
                MathTester.tester(input, "ceil", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.ceil(d);
                    }
                });
                dv = new MutableFloatVector.Rel<LengthUnit>(input, LengthUnit.METER, StorageType.SPARSE);
                dv.floor();
                MathTester.tester(input, "floor", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.floor(d);
                    }
                });
                dv = new MutableFloatVector.Rel<LengthUnit>(input, LengthUnit.METER, StorageType.SPARSE);
                dv.rint();
                MathTester.tester(input, "rint", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return (float) Math.rint(d);
                    }
                });
                dv = new MutableFloatVector.Rel<LengthUnit>(input, LengthUnit.METER, StorageType.SPARSE);
                dv.round();
                MathTester.tester(input, "round", dv, 0.001, new FloatToFloat()
                {
                    @Override
                    public float function(final float d)
                    {
                        return Math.round(d);
                    }
                });
            }
            catch (ValueException ve)
            {
                fail("Caught unexpected ValueException: " + ve.toString());
            }
        }
    }

    /**
     * Test plus(FloatVectorRel.Sparse, FloatVectorRel.Dense).
     */
    @Test
    public final void binaryplusOfRelSparseAndRelDenseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.plus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI plus of contributing elements", left.getSI(i) + right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test minus(FloatVectorRel.Sparse, FloatVectorRel.Dense).
     */
    @Test
    public final void binaryminusOfRelSparseAndRelDenseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.minus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI minus of contributing elements", left.getSI(i) - right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test times(FloatVectorRel.Sparse, FloatVectorRel.Dense).
     */
    @Test
    public final void binarytimesOfRelSparseAndRelDenseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.times(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI times of contributing elements", left.getSI(i) * right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test plus(FloatVectorRel.Sparse, FloatVectorRel.Sparse).
     */
    @Test
    public final void binaryplusOfRelSparseAndRelSparseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.plus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI plus of contributing elements", left.getSI(i) + right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test minus(FloatVectorRel.Sparse, FloatVectorRel.Sparse).
     */
    @Test
    public final void binaryminusOfRelSparseAndRelSparseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.minus(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI minus of contributing elements", left.getSI(i) - right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test times(FloatVectorRel.Sparse, FloatVectorRel.Sparse).
     */
    @Test
    public final void binarytimesOfRelSparseAndRelSparseTest()
    {
        try
        {
            float[] leftValue = data(99, 123.4f, 2, 10);
            float[] rightValue = data(99, 234.5f, 3, 3);
            FloatVector.Rel<LengthUnit> left = new FloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
            FloatVector.Rel<LengthUnit> right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
            FloatVector.Rel<?> result = left.times(right);
            for (int i = 0; i < leftValue.length; i++)
            {
                assertEquals("value of element should be SI times of contributing elements", left.getSI(i) * right.getSI(i),
                        result.getSI(i), 0.001);
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test that malformed or mismatching arrays throw a ValueException.
     */
    @Test
    public final void sizeCheckRelTest()
    {
        int junk = 0;
        try
        {
            // null array
            new FloatVector.Rel<TemperatureUnit>((float[]) null, TemperatureUnit.DEGREE_FAHRENHEIT, StorageType.SPARSE);
            fail("Preceding code should have thrown a ValueException");
        }
        catch (ValueException ve)
        {
            // Ignore (exception was expected)
            junk++;
        }
        assertTrue("The variable junk is only used to suppress annoying warnings of the code checker", junk > 0);
    }

    /**
     * Test the incrementBy method.
     */
    @Test
    public final void incrementByTest()
    {
        try
        {
            for (int firstStep : new int[] {3, 10})
            {
                float[] leftValue = data(99, 123.4f, 2, firstStep);
                float[] rightValue = data(99, 234.5f, 3, 13 - firstStep);
                MutableFloatVector.Rel<LengthUnit> left =
                        new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                MutableFloatVector.Rel<LengthUnit> referenceLeft = left.copy();
                FloatVector.Rel<LengthUnit> right =
                        new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
                left.incrementBy(right);
                for (int i = 0; i < leftValue.length; i++)
                {
                    assertEquals("value of element should be sum of contributing elements",
                            referenceLeft.getSI(i) + right.getSI(i), left.getSI(i), 0.001);
                }
                left = new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.SPARSE);
                left.incrementBy(right);
                for (int i = 0; i < leftValue.length; i++)
                {
                    assertEquals("value of element should be sum of contributing elements",
                            referenceLeft.getSI(i) + right.getSI(i), left.getSI(i), 0.001);
                }
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test the decrementBy method.
     */
    @Test
    public final void decrementByTest()
    {
        try
        {
            for (int firstStep : new int[] {3, 10})
            {
                float[] leftValue = data(99, 123.4f, 2, firstStep);
                float[] rightValue = data(99, 234.5f, 3, 13 - firstStep);
                MutableFloatVector.Rel<LengthUnit> left =
                        new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                MutableFloatVector.Rel<LengthUnit> referenceLeft = left.copy();
                FloatVector.Rel<LengthUnit> right =
                        new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
                left.decrementBy(right);
                for (int i = 0; i < leftValue.length; i++)
                {
                    assertEquals("value of element should be difference of contributing elements",
                            referenceLeft.getSI(i) - right.getSI(i), left.getSI(i), 0.001);
                }
                left = new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.SPARSE);
                left.decrementBy(right);
                for (int i = 0; i < leftValue.length; i++)
                {
                    assertEquals("value of element should be difference of contributing elements",
                            referenceLeft.getSI(i) - right.getSI(i), left.getSI(i), 0.001);
                }
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test the multiplyBy method.
     */
    @Test
    public final void multiplyByTest()
    {
        try
        {
            for (int firstStep : new int[] { 3, 10 })
            {
                for (boolean lastNanOrdering : new boolean[] {false, true})
                {
                    float[] leftValue = data(99, 123.4f, 2, firstStep);
                    float[] rightValue = data(99, 234.5f, 3, 13 - firstStep);
                    leftValue[0] = Float.NaN;
                    leftValue[1] = Float.NaN;
                    rightValue[1] = Float.NaN;
                    rightValue[2] = Float.NaN;
                    if (lastNanOrdering)
                    {
                        leftValue[98] = Float.NaN;
                        leftValue[97] = Float.NaN;
                        rightValue[97] = Float.NaN;
                        rightValue[96] = Float.NaN;
                    }
                    else
                    {
                        rightValue[98] = Float.NaN;
                        rightValue[97] = Float.NaN;
                        leftValue[97] = Float.NaN;
                        leftValue[96] = Float.NaN;
                    }
                    MutableFloatVector.Rel<LengthUnit> left =
                            new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                    MutableFloatVector.Rel<LengthUnit> referenceLeft = left.copy();
                    FloatVector.Rel<LengthUnit> right =
                            new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
                    left.multiplyBy(right);
                    for (int i = 0; i < leftValue.length; i++)
                    {
                        assertEquals("value of element should be product of contributing elements",
                                referenceLeft.getSI(i) * right.getSI(i), left.getSI(i), 0.001);
                    }
                    left = new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                    right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.SPARSE);
                    left.multiplyBy(right);
                    for (int i = 0; i < leftValue.length; i++)
                    {
                        assertEquals("value of element should be product of contributing elements",
                                referenceLeft.getSI(i) * right.getSI(i), left.getSI(i), 0.001);
                    }
                }
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /**
     * Test the divideBy method.
     */
    @Test
    public final void divideByTest()
    {
        try
        {
            for (int firstStep : new int[] { 3, 10 })
            {
                for (boolean lastNanOrdering : new boolean[] {false, true})
                {
                    float[] leftValue = data(99, 123.4f, 2, firstStep);
                    float[] rightValue = data(99, 234.5f, 3, 13 - firstStep);
                    leftValue[0] = Float.NaN;
                    leftValue[1] = Float.NaN;
                    rightValue[1] = Float.NaN;
                    rightValue[2] = Float.NaN;
                    if (lastNanOrdering)
                    {
                        leftValue[98] = Float.NaN;
                        leftValue[97] = Float.NaN;
                        rightValue[97] = Float.NaN;
                        rightValue[96] = Float.NaN;
                    }
                    else
                    {
                        rightValue[98] = Float.NaN;
                        rightValue[97] = Float.NaN;
                        leftValue[97] = Float.NaN;
                        leftValue[96] = Float.NaN;
                    }
                    MutableFloatVector.Rel<LengthUnit> left =
                            new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                    MutableFloatVector.Rel<LengthUnit> referenceLeft = left.copy();
                    FloatVector.Rel<LengthUnit> right =
                            new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.DENSE);
                    left.divideBy(right);
                    for (int i = 0; i < leftValue.length; i++)
                    {
                        float expect = referenceLeft.getSI(i) / right.getSI(i);
                        if (Float.isNaN(expect))
                        {
                            assertTrue("value of element should be NaN", Float.isNaN(left.getSI(i)));
                        }
                        else if (Float.isInfinite(expect))
                        {
                            assertTrue("value of element should be infinite", Float.isInfinite(left.getSI(i)));
                        }
                        else
                        {
                            assertEquals("value of element should be ratio of contributing elements", expect, left.getSI(i),
                                    0.001);
                        }
                    }
                    left = new MutableFloatVector.Rel<LengthUnit>(leftValue, LengthUnit.MILE, StorageType.SPARSE);
                    right = new FloatVector.Rel<LengthUnit>(rightValue, LengthUnit.MILE, StorageType.SPARSE);
                    left.divideBy(right);
                    for (int i = 0; i < leftValue.length; i++)
                    {
                        float expect = referenceLeft.getSI(i) / right.getSI(i);
                        if (Float.isNaN(expect))
                        {
                            assertTrue("value of element should be NaN", Float.isNaN(left.getSI(i)));
                        }
                        else if (Float.isInfinite(expect))
                        {
                            assertTrue("value of element should be infinite", Float.isInfinite(left.getSI(i)));
                        }
                        else
                        {
                            assertEquals("value of element should be ratio of contributing elements", expect, left.getSI(i),
                                    0.001);
                        }
                    }
                }
            }
        }
        catch (ValueException ve)
        {
            fail("Caught unexpected ValueException: " + ve.toString());
        }
    }

    /** */
    interface FloatToFloat
    {
        /**
         * @param d float; value
         * @return float value
         */
        float function(float d);
    }

    /** */
    abstract static class MathTester
    {
        /**
         * Test a math function.
         * @param inputValues float[]; unprocessed value
         * @param operation String; description of method that is being tested
         * @param actualResult FloatVector&lt;?&gt;; the actual result of the operation
         * @param precision double; expected accuracy
         * @param function FloatToFloat; encapsulated function that converts one inputValue to an outputValue
         */
        public static void tester(final float[] inputValues, final String operation,
                final AbstractFloatVector<?, ?> actualResult, final double precision, final FloatToFloat function)
        {
            for (int i = 0; i < inputValues.length; i++)
            {
                float expectedResult = function.function(inputValues[i]);
                float got = 0;
                try
                {
                    got = actualResult.getSI(i);
                }
                catch (ValueException ve)
                {
                    fail("Caught unexpected exception: " + ve.toString());
                }
                String description = String.format("%s(%f->%f should be equal to %f with precision %f", operation,
                        inputValues[i], expectedResult, got, precision);
                // System.out.println(description);
                assertEquals(description, expectedResult, got, precision);
            }
        }

    }

}
