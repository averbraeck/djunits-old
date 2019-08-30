package org.djunits4.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.Unit;
import org.junit.Test;

/**
 * Test the DoubleScalar class.
 * <p>
 * This file was generated by the djunits value test classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DoubleScalarTest
{
    /**
     * Check that the value in a DoubleScalarmatches the expected value.
     * @param ds DoubleScalar&lt;?&gt;; the DoubleScalar to match
     * @param reference double; the reference value
     * @param precision double; the maximum allowed error
     * @param u Unit&lt;?&gt;; the expected type
     * @param expectAbsolute boolean; if true; ds should be Absolute; if false; ds should be Relative
     */
    private static void checkContentsAndType(final AbstractDoubleScalar<?, ?> ds, final double reference,
            final double precision, final Unit<?> u, final boolean expectAbsolute)
    {
        assertTrue("DoubleScalar should not be null", null != ds);
        assertEquals("Value should match", reference, ds.getInUnit(), precision);
        assertEquals("Unit should be " + u.toString(), u, ds.getUnit());
        assertTrue("Should be " + (expectAbsolute ? "Absolute" : "Relative"),
                expectAbsolute ? ds.isAbsolute() : ds.isRelative());
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringAbsTest()
    {
        AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.KELVIN;
        double value = 38.0;
        DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> ds = new DoubleScalar.Abs<>(value, tempUnit);
        String result = ds.toString(true, true);
        assertTrue("toString result contains \"Abs \"", result.contains("Abs "));
        assertTrue("toString result contains \"K\"", result.contains("K"));
    }

    /**
     * Test constructor, verify the various fields in the constructed objects, test conversions to related units.
     */
    @Test
    public final void basicsAbsTest()
    {
        AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.DEGREE_CELSIUS;
        double value = 38.0;
        DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> temperatureDS =
                new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit);
        checkContentsAndType(temperatureDS, value, 0.001, tempUnit, true);
        assertEquals("Value in SI is equivalent in Kelvin", 311.15, temperatureDS.getSI(), 0.05);
        assertEquals("Value in Fahrenheit", 100.4, temperatureDS.getInUnit(AbsoluteTemperatureUnit.DEGREE_FAHRENHEIT), 0.1);
        double out = temperatureDS.getInUnit();
        assertEquals("Value should match", value, out, 0.001);
        DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> mds =
                new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit);
        checkContentsAndType(mds, value, 0.001, tempUnit, true);
        mds = new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(-200, tempUnit);
        assertEquals("-200 Celsius roughly equivalent to 73 Kelvin", 73.0d, mds.getSI(), 1.0d);
        mds = new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(temperatureDS);
        checkContentsAndType(mds, value, 0.001, tempUnit, true);
        DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> temperature2DS =
                new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(temperatureDS);
        assertTrue("temperature2DS should be equal to temperatureDS", temperature2DS.equals(temperatureDS));
        assertTrue("Value is Absolute", temperatureDS.isAbsolute());
        assertFalse("Value is not Relative", temperatureDS.isRelative());
        temperatureDS = new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, AbsoluteTemperatureUnit.KELVIN);
        checkContentsAndType(temperatureDS, value, 0.001, AbsoluteTemperatureUnit.KELVIN, true);
        out = temperatureDS.getSI();
        assertEquals("Value should match", value, out, 0.001);
        for (int i = -100; i <= 100; i++)
        {
            double v = i / 10.0;
            mds = new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(v, AbsoluteTemperatureUnit.DEFAULT);
            assertEquals("intValue should round like Math.round", Math.round(v), mds.intValue(), 0.0001);
            assertEquals("longValue should round like Math.round", Math.round(v), mds.longValue(), 0.0001);
            assertEquals("floatValue should return the value", v, mds.floatValue(), 0.0001);
            assertEquals("doubleValue should return the value", v, mds.doubleValue(), 0.0001);
        }
    }

    /**
     * Test the equals method.
     */
    @Test
    public final void equalsAbsTest()
    {
        LengthUnit lengthUnit = LengthUnit.METER;
        PositionUnit positionUnit = PositionUnit.DEFAULT;
        double value = 38.0;
        DoubleScalar.Abs<PositionUnit, LengthUnit> ds = new DoubleScalar.Abs<PositionUnit, LengthUnit>(value, positionUnit);
        assertTrue("Equal to itself", ds.equals(ds));
        assertFalse("Not equal to null", ds.equals(null));
        assertFalse("Not equal to some other kind of object; e.g. a String", ds.equals(new String("abc")));
        DoubleScalar.Rel<LengthUnit> dsCounterPart = new DoubleScalar.Rel<LengthUnit>(value, lengthUnit);
        assertFalse("Not equal if one Absolute and other Relative", ds.equals(dsCounterPart));
        DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit> dsWrongBaseUnit =
                new DoubleScalar.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, AbsoluteTemperatureUnit.KELVIN);
        assertEquals("The underlying SI values are the same", ds.getSI(), dsWrongBaseUnit.getSI(), 0.0001);
        assertFalse("Not equals because the standard SI unit differs", ds.equals(dsWrongBaseUnit));
        DoubleScalar.Abs<PositionUnit, LengthUnit> dsCompatibleUnit =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(38000.0, PositionUnit.MILLIMETER);
        assertFalse("Units are different", ds.getUnit().equals(dsCompatibleUnit.getUnit()));
        assertTrue("equals returns true", ds.equals(dsCompatibleUnit));
        DoubleScalar.Abs<PositionUnit, LengthUnit> dsDifferentValue =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(123.456, PositionUnit.MILLIMETER);
        assertFalse("Different value makes equals return false", ds.equals(dsDifferentValue));
    }

    /**
     * Test the relational operations.
     */
    @Test
    public final void relOpAbsTest()
    {
        DoubleScalar.Abs<PositionUnit, LengthUnit> base =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(123, PositionUnit.KILOMETER);
        DoubleScalar.Abs<PositionUnit, LengthUnit> same =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(123000, PositionUnit.METER);
        DoubleScalar.Abs<PositionUnit, LengthUnit> smaller =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(122999, PositionUnit.METER);
        DoubleScalar.Abs<PositionUnit, LengthUnit> larger =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(123001, PositionUnit.METER);
        assertFalse("123km < 123000m", base.lt(same));
        assertTrue("123km <= 123000m", base.le(same));
        assertTrue("123km >= 123000m", base.ge(same));
        assertFalse("NOT 123km > 123000m", base.gt(same));
        assertTrue("123km == 123000m", base.eq(same));
        assertFalse("NOT 123km != 123000m", base.ne(same));
        assertTrue("123km < 123001m", base.lt(larger));
        assertTrue("123km > 122999m", base.gt(smaller));
        assertTrue("123km >= 123000m", base.ge(same));
        assertFalse("NOT 123km > 123000m", base.gt(same));
        assertFalse("NOT 123km < 123000m", base.lt(same));
        assertTrue("123km <= 123000m", base.le(same));
        assertTrue("123km != 123001m", base.ne(larger));
        assertFalse("NOT 123km == 123001m", base.eq(larger));
        assertTrue("123km != 122999m", base.ne(smaller));
        assertFalse("NOT 123km == 122999m", base.eq(smaller));
        assertFalse("NOT 123km >= 123001m", base.ge(larger));
        assertFalse("NOT 123km <= 122999m", base.le(smaller));
    }

    /**
     * Test the Math functions.
     */
    @Test
    public final void mathFunctionsTestAbsTest()
    {
        double[] seedValues = {-10, -2, -1, -0.5, -0.1, 0, 0.1, 0.5, 1, 2, 10};
        for (double seedValue : seedValues)
        {
            double input = seedValue;
            DoubleScalar.Abs<PositionUnit, LengthUnit> ds;
            ds = new DoubleScalar.Abs<PositionUnit, LengthUnit>(input, PositionUnit.DEFAULT);
            MathTester.tester(input, "ceil", ds.ceil(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.ceil(d);
                }
            });
            ds = new DoubleScalar.Abs<PositionUnit, LengthUnit>(input, PositionUnit.DEFAULT);
            MathTester.tester(input, "floor", ds.floor(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.floor(d);
                }
            });
            ds = new DoubleScalar.Abs<PositionUnit, LengthUnit>(input, PositionUnit.DEFAULT);
            MathTester.tester(input, "rint", ds.rint(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.rint(d);
                }
            });
            ds = new DoubleScalar.Abs<PositionUnit, LengthUnit>(input, PositionUnit.DEFAULT);
            MathTester.tester(input, "round", ds.round(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.round(d);
                }
            });
        }
    }

    /**
     * Test plus(DoubleScalarAbs, DoubleScalarRel).
     */
    @Test
    public final void binaryplusOfAbsAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Abs<PositionUnit, LengthUnit> left =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        DoubleScalar.Abs<PositionUnit, LengthUnit> result = DoubleScalar.plus(left, right);
        assertEquals("value of element should be SI plus of contributing elements", left.getSI() + right.getSI(),
                result.getSI(), 0.001);
    }

    /**
     * Test minus(DoubleScalarAbs, DoubleScalarRel).
     */
    @Test
    public final void binaryminusOfAbsAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Abs<PositionUnit, LengthUnit> left =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(leftValue, PositionUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        DoubleScalar.Abs<PositionUnit, LengthUnit> result = DoubleScalar.minus(left, right);
        assertEquals("value of element should be SI minus of contributing elements", left.getSI() - right.getSI(),
                result.getSI(), 0.001);
    }

    /**
     * Test that the toString method returns something sensible.
     */
    @Test
    public final void toStringRelTest()
    {
        TemperatureUnit tempUnit = TemperatureUnit.KELVIN;
        double value = 38.0;
        DoubleScalar.Rel<TemperatureUnit> ds = new DoubleScalar.Rel<TemperatureUnit>(value, tempUnit);
        String result = ds.toString(true, true);
        assertTrue("toString result contains \"Rel \"", result.contains("Rel "));
        assertTrue("toString result contains \"K\"", result.contains("K"));
    }

    /**
     * Test constructor, verify the various fields in the constructed objects, test conversions to related units.
     */
    @Test
    public final void basicsRelTest()
    {
        TemperatureUnit tempUnit = TemperatureUnit.DEGREE_CELSIUS;
        double value = 38.0;
        DoubleScalar.Rel<TemperatureUnit> temperatureDS = new DoubleScalar.Rel<TemperatureUnit>(value, tempUnit);
        checkContentsAndType(temperatureDS, value, 0.001, tempUnit, false);
        assertEquals("Value in SI is equivalent in Kelvin", 38.0, temperatureDS.getSI(), 0.05);
        assertEquals("Value in Fahrenheit", 38.0 * 9.0 / 5.0, temperatureDS.getInUnit(TemperatureUnit.DEGREE_FAHRENHEIT), 0.1);
        double out = temperatureDS.getInUnit();
        assertEquals("Value should match", value, out, 0.001);
        DoubleScalar.Rel<TemperatureUnit> mds = new DoubleScalar.Rel<TemperatureUnit>(value, tempUnit);
        checkContentsAndType(mds, value, 0.001, tempUnit, false);
        DoubleScalar.Rel<TemperatureUnit> temperature2DS = new DoubleScalar.Rel<TemperatureUnit>(temperatureDS);
        assertTrue("temperature2DS should be equal to temperatureDS", temperature2DS.equals(temperatureDS));
        assertTrue("Value is Relative", temperatureDS.isRelative());
        assertFalse("Value is not Absolute", temperatureDS.isAbsolute());
        temperatureDS = new DoubleScalar.Rel<TemperatureUnit>(value, TemperatureUnit.KELVIN);
        checkContentsAndType(temperatureDS, value, 0.001, TemperatureUnit.KELVIN, false);
        out = temperatureDS.getSI();
        assertEquals("Value should match", value, out, 0.001);
        for (int i = -100; i <= 100; i++)
        {
            double v = i / 10.0;
            mds = new DoubleScalar.Rel<TemperatureUnit>(v, TemperatureUnit.SI);
            assertEquals("intValue should round like Math.round", Math.round(v), mds.intValue(), 0.0001);
            assertEquals("longValue should round like Math.round", Math.round(v), mds.longValue(), 0.0001);
            assertEquals("floatValue should return the value", v, mds.floatValue(), 0.0001);
            assertEquals("doubleValue should return the value", v, mds.doubleValue(), 0.0001);
        }
    }

    /**
     * Test the equals method.
     */
    @Test
    public final void equalsRelTest()
    {
        LengthUnit lengthUnit = LengthUnit.METER;
        PositionUnit positionUnit = PositionUnit.DEFAULT;
        double value = 38.0;
        DoubleScalar.Rel<LengthUnit> ds = new DoubleScalar.Rel<LengthUnit>(value, lengthUnit);
        assertTrue("Equal to itself", ds.equals(ds));
        assertFalse("Not equal to null", ds.equals(null));
        assertFalse("Not equal to some other kind of object; e.g. a String", ds.equals(new String("abc")));
        DoubleScalar.Abs<PositionUnit, LengthUnit> dsCounterPart =
                new DoubleScalar.Abs<PositionUnit, LengthUnit>(value, positionUnit);
        assertFalse("Not equal if one Absolute and other Relative", ds.equals(dsCounterPart));
        DoubleScalar.Rel<TemperatureUnit> dsWrongBaseUnit =
                new DoubleScalar.Rel<TemperatureUnit>(value, TemperatureUnit.KELVIN);
        assertEquals("The underlying SI values are the same", ds.getSI(), dsWrongBaseUnit.getSI(), 0.0001);
        assertFalse("Not equals because the standard SI unit differs", ds.equals(dsWrongBaseUnit));
        DoubleScalar.Rel<LengthUnit> dsCompatibleUnit = new DoubleScalar.Rel<LengthUnit>(38000.0, LengthUnit.MILLIMETER);
        assertFalse("Units are different", ds.getUnit().equals(dsCompatibleUnit.getUnit()));
        assertTrue("equals returns true", ds.equals(dsCompatibleUnit));
        DoubleScalar.Rel<LengthUnit> dsDifferentValue = new DoubleScalar.Rel<LengthUnit>(123.456, LengthUnit.MILLIMETER);
        assertFalse("Different value makes equals return false", ds.equals(dsDifferentValue));
    }

    /**
     * Test the relational operations.
     */
    @Test
    public final void relOpRelTest()
    {
        DoubleScalar.Rel<LengthUnit> base = new DoubleScalar.Rel<LengthUnit>(123, LengthUnit.KILOMETER);
        DoubleScalar.Rel<LengthUnit> same = new DoubleScalar.Rel<LengthUnit>(123000, LengthUnit.METER);
        DoubleScalar.Rel<LengthUnit> smaller = new DoubleScalar.Rel<LengthUnit>(122999, LengthUnit.METER);
        DoubleScalar.Rel<LengthUnit> larger = new DoubleScalar.Rel<LengthUnit>(123001, LengthUnit.METER);
        assertFalse("123km < 123000m", base.lt(same));
        assertTrue("123km <= 123000m", base.le(same));
        assertTrue("123km >= 123000m", base.ge(same));
        assertFalse("NOT 123km > 123000m", base.gt(same));
        assertTrue("123km == 123000m", base.eq(same));
        assertFalse("NOT 123km != 123000m", base.ne(same));
        assertTrue("123km < 123001m", base.lt(larger));
        assertTrue("123km > 122999m", base.gt(smaller));
        assertTrue("123km >= 123000m", base.ge(same));
        assertFalse("NOT 123km > 123000m", base.gt(same));
        assertFalse("NOT 123km < 123000m", base.lt(same));
        assertTrue("123km <= 123000m", base.le(same));
        assertTrue("123km != 123001m", base.ne(larger));
        assertFalse("NOT 123km == 123001m", base.eq(larger));
        assertTrue("123km != 122999m", base.ne(smaller));
        assertFalse("NOT 123km == 122999m", base.eq(smaller));
        assertFalse("NOT 123km >= 123001m", base.ge(larger));
        assertFalse("NOT 123km <= 122999m", base.le(smaller));
    }

    /**
     * Test the Math functions.
     */
    @Test
    public final void mathFunctionsTestRelTest()
    {
        double[] seedValues = {-10, -2, -1, -0.5, -0.1, 0, 0.1, 0.5, 1, 2, 10};
        for (double seedValue : seedValues)
        {
            double input = seedValue;
            DoubleScalar.Rel<LengthUnit> ds;
            ds = new DoubleScalar.Rel<LengthUnit>(input, LengthUnit.METER);
            MathTester.tester(input, "abs", ds.abs(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.abs(d);
                }
            });
            ds = new DoubleScalar.Rel<LengthUnit>(input, LengthUnit.METER);
            MathTester.tester(input, "ceil", ds.ceil(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.ceil(d);
                }
            });
            ds = new DoubleScalar.Rel<LengthUnit>(input, LengthUnit.METER);
            MathTester.tester(input, "floor", ds.floor(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.floor(d);
                }
            });
            ds = new DoubleScalar.Rel<LengthUnit>(input, LengthUnit.METER);
            MathTester.tester(input, "rint", ds.rint(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.rint(d);
                }
            });
            ds = new DoubleScalar.Rel<LengthUnit>(input, LengthUnit.METER);
            MathTester.tester(input, "round", ds.round(), 0.001, new DoubleToDouble()
            {
                @Override
                public double function(final double d)
                {
                    return Math.round(d);
                }
            });
        }
    }

    /**
     * Test plus(DoubleScalarRel, DoubleScalarRel).
     */
    @Test
    public final void binaryplusOfRelAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Rel<LengthUnit> left = new DoubleScalar.Rel<LengthUnit>(leftValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> result = DoubleScalar.plus(left, right);
        assertEquals("value of element should be SI plus of contributing elements", left.getSI() + right.getSI(),
                result.getSI(), 0.001);
    }

    /**
     * Test minus(DoubleScalarRel, DoubleScalarRel).
     */
    @Test
    public final void binaryminusOfRelAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Rel<LengthUnit> left = new DoubleScalar.Rel<LengthUnit>(leftValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> result = DoubleScalar.minus(left, right);
        assertEquals("value of element should be SI minus of contributing elements", left.getSI() - right.getSI(),
                result.getSI(), 0.001);
    }

    /**
     * Test multiply(DoubleScalarRel, DoubleScalarRel).
     */
    @Test
    public final void binarymultiplyOfRelAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Rel<LengthUnit> left = new DoubleScalar.Rel<LengthUnit>(leftValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        SIScalar result = DoubleScalar.multiply(left, right);
        assertEquals("value of element should be SI multiply of contributing elements", left.getSI() * right.getSI(),
                result.getSI(), 0.001);
    }

    /**
     * Test divide(DoubleScalarRel, DoubleScalarRel).
     */
    @Test
    public final void binarydivideOfRelAndRelTest()
    {
        double leftValue = 123.4;
        double rightValue = 234.5;
        DoubleScalar.Rel<LengthUnit> left = new DoubleScalar.Rel<LengthUnit>(leftValue, LengthUnit.MILE);
        DoubleScalar.Rel<LengthUnit> right = new DoubleScalar.Rel<LengthUnit>(rightValue, LengthUnit.MILE);
        SIScalar result = DoubleScalar.divide(left, right);
        assertEquals("value of element should be SI divide of contributing elements", left.getSI() / right.getSI(),
                result.getSI(), 0.001);
    }

    /** */
    interface DoubleToDouble
    {
        /**
         * @param d double; value
         * @return double value
         */
        double function(double d);
    }

    /** */
    abstract static class MathTester
    {
        /**
         * Test a math function.
         * @param inputValue double; unprocessed value
         * @param operation String; description of method that is being tested
         * @param actualResult DoubleScalar&lt;?&gt;; the actual result of the operation
         * @param precision double; expected accuracy
         * @param function DoubleToDouble; encapsulated function that converts one inputValue to an outputValue
         */
        public static void tester(final double inputValue, final String operation,
                final AbstractDoubleScalar<?, ?> actualResult, final double precision, final DoubleToDouble function)
        {
            double expectedResult = function.function(inputValue);
            double got = actualResult.getSI();
            String description = String.format("%s(%f->%f should be equal to %f with precision %f", operation, inputValue,
                    expectedResult, got, precision);
            // System.out.println(description);
            assertEquals(description, expectedResult, got, precision);
        }

    }

}
