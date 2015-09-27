package org.djunits.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits.unit.Unit;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.junit.Assert;
import org.junit.Test;

/**
 * Find all multiplyBy and divideBy operations and prove the type correctness.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 14, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ScalarOperationsTest
{
    /** The classes that are absolute and relative (.Abs and .Rel, or $Abs and $Rel for class names). */
    public static final String[] CLASSNAMES_ABSREL = new String[] { "AnglePlane", "AngleSlope", "Dimensionless", "Length",
            "Temperature", "Time" };

    /** The classes that are just relative (name = class name). */
    public static final String[] CLASSNAMES_REL = new String[] { "Acceleration", "AngleSolid", "Area", "Density",
            "ElectricalCharge", "ElectricalCurrent", "ElectricalPotential", "ElectricalResistance", "Energy", "FlowMass",
            "FlowVolume", "Force", "Frequency", "LinearDensity", "Mass", "Power", "Pressure", "Speed", "Torque", "Volume" };

    /** The money classes that are just relative (name = class name); these classes don't have an si field. */
    public static final String[] CLASSNAMES_MONEY = new String[] { "Money", "MoneyPerArea", "MoneyPerEnergy", "MoneyPerLength",
            "MoneyPerMass", "MoneyPerTime", "MoneyPerVolume" };

    /**
     * Test constructor on the specified double scalar classes.
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     */
    @SuppressWarnings("static-method")
    @Test
    public final void scalarOperationsTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException
    {
        doubleOrFloatScalarOperationsTest(true); // Double precision versions
        doubleOrFloatScalarOperationsTest(false); // Float versions
    }

    /**
     * Perform many tests on scalar types.
     * @param doubleType boolean; if true; perform tests on DoubleScalar types; if false; perform tests on FloatScalar types
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     */
    private void doubleOrFloatScalarOperationsTest(final boolean doubleType) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException
    {
        final String upperType = doubleType ? "Double" : "Float";
        final String type = upperType.toLowerCase();
        // get the interfaces such as org.djunits.value.vdouble.scalar.Time
        for (String scalarClassName : CLASSNAMES_ABSREL)
        {
            for (String subClassName : new String[] { "$Rel", "$Abs" })
            {
                boolean isAbs = subClassName.contains("Abs");
                Class<?> scalarClassAbsRel = null;
                // get the subClassName implementation of that class
                try
                {
                    scalarClassAbsRel =
                            Class.forName("org.djunits.value.v" + type + ".scalar." + scalarClassName + subClassName);
                }
                catch (ClassNotFoundException exception)
                {
                    fail("Class Rel not found for " + upperType + "Scalar class " + "org.djunits.value.v" + type + ".scalar."
                            + scalarClassName);
                }
                testMethods(scalarClassAbsRel, isAbs, doubleType);
                testAbsRelConversion(scalarClassAbsRel, isAbs, doubleType);
            }
        }

        // get the interfaces such as org.djunits.value.vXXXX.scalar.Area
        for (String scalarClassName : CLASSNAMES_REL)
        {
            Class<?> scalarClassRel = null;
            try
            {
                scalarClassRel = Class.forName("org.djunits.value.v" + type + ".scalar." + scalarClassName);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class Rel not found for " + upperType + "DoubleScalar class " + "org.djunits.value.v" + type + ".scalar."
                        + scalarClassName);
            }
            testMethods(scalarClassRel, false, doubleType);
        }

        // get the interfaces such as org.djunits.value.vXXXX.scalar.MoneyPerArea
        for (String scalarClassName : CLASSNAMES_MONEY)
        {
            Class<?> scalarClassMoney = null;
            try
            {
                scalarClassMoney = Class.forName("org.djunits.value.v" + type + ".scalar." + scalarClassName);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class Rel not found for " + upperType + "DoubleScalar class " + "org.djunits.value.v" + type + ".scalar."
                        + scalarClassName);
            }
            testMethods(scalarClassMoney, false, doubleType);
        }
    }

    /**
     * Test the toAbs or toRel method.
     * @param scalarClassAbsRel class to test
     * @param isAbs boolean; if true; the scalarClassAbsRel must be aAsolute; if false; the scalarClassAbsRel must be Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false perform tests on FloatScalar
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws NoSuchFieldException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private void testAbsRelConversion(final Class<?> scalarClassAbsRel, boolean isAbs, boolean doubleType)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
    {
        double inValue = 1.23456;
        Constructor<?> constructor =
                scalarClassAbsRel.getConstructor(doubleType ? double.class : float.class, getUnitClass(scalarClassAbsRel));
        Object from;
        if (doubleType)
        {
            from =
                    isAbs ? (DoubleScalar.Abs<?>) constructor.newInstance(inValue,
                            getSIUnitInstance(getUnitClass(scalarClassAbsRel))) : (DoubleScalar.Rel<?>) constructor
                            .newInstance(inValue, getSIUnitInstance(getUnitClass(scalarClassAbsRel)));
        }
        else
        {
            from =
                    isAbs ? (FloatScalar.Abs<?>) constructor.newInstance((float) inValue,
                            getSIUnitInstance(getUnitClass(scalarClassAbsRel))) : (FloatScalar.Rel<?>) constructor.newInstance(
                            (float) inValue, getSIUnitInstance(getUnitClass(scalarClassAbsRel)));
        }
        Method method = scalarClassAbsRel.getDeclaredMethod(isAbs ? "toRel" : "toAbs");
        Object to = method.invoke(from);
        double toValue = verifyAbsRelPrecisionAndExtractSI(!isAbs, doubleType, to);
        assertEquals("Value after Abs/Rel conversion should be equal to input value", inValue, toValue, 0.00001);
    }

    /**
     * Find the methods defined in the class itself (not in a superclass) called multiplyBy or divideBy and test the method.
     * Also test the Unary methods of the class.
     * @param scalarClassAbsRel class to test
     * @param isAbs boolean; if true; the scalarClassAbsRel must be aAsolute; if false; the scalarClassAbsRel must be Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false perform tests on FloatScalar
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     */
    private void testMethods(final Class<?> scalarClassAbsRel, final boolean isAbs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException
    {
        for (Method method : scalarClassAbsRel.getDeclaredMethods())
        {
            if (method.getName().equals("multiplyBy"))
            {
                // note: filter out the method that multiplies by a constant...
                testMultiplyOrDivideMethodAbsRel(scalarClassAbsRel, isAbs, method, true, doubleType);
            }
            else if (method.getName().equals("divideBy"))
            {
                testMultiplyOrDivideMethodAbsRel(scalarClassAbsRel, isAbs, method, false, doubleType);
            }
        }
        testUnaryMethods(scalarClassAbsRel, isAbs, doubleType);
        testInterpolateMethod(scalarClassAbsRel, isAbs, doubleType);
    }

    /**
     * Test a multiplication method for an Abs or Rel scalar. Note: filter out the method that multiplies by a constant...
     * @param scalarClass the Abs or Rel class for the multiplication, e.g. Length.Rel
     * @param abs boolean; true to test the Abs sub-class; false to test the Rel sub-class
     * @param method the method 'multiplyBy' for that class
     * @param multiply boolean; if true; test a multiplyBy method; if false; test a divideBy method
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     */
    private void testMultiplyOrDivideMethodAbsRel(final Class<?> scalarClass, final boolean abs, final Method method,
            final boolean multiply, final boolean doubleType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException
    {
        Class<?> relativeOrAbsoluteClass = null;
        try
        {
            relativeOrAbsoluteClass = Class.forName("org.djunits.value." + (abs ? "Absolute" : "Relative"));
        }
        catch (ClassNotFoundException exception)
        {
            fail("Could not find org.djunits.value.Relative class");
        }
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            fail("DoubleScalar class " + scalarClass.getName() + "." + method.getName() + "() has " + parTypes.length
                    + " parameters, <> 1");
        }
        Class<?> parameterClass = parTypes[0];
        if (parameterClass.toString().equals("double"))
        {
            // not interested in multiplying a scalar with a double.
            return;
        }
        if (!relativeOrAbsoluteClass.isAssignableFrom(parameterClass))
        {
            System.out.println("abs=" + abs + ", method=" + scalarClass.getName() + "." + method.getName() + " param="
                    + parameterClass.getName());
            return;
            // Assert.fail("DoubleScalar class " + scalarClass.getName() + "." + method.getName() + "() has parameter with non-"
            // + relativeOrAbsoluteClass + " class: " + relativeOrAbsoluteClass.getName());
        }

        Class<?> returnClass = method.getReturnType();
        if (!relativeOrAbsoluteClass.isAssignableFrom(returnClass))
        {
            Assert.fail("DoubleScalar class " + scalarClass.getName()
                    + ".multiplyBy() has return type with non-relative class: " + returnClass.getName());
        }

        // get the SI coefficients of the unit classes, scalar type, parameter type and return type
        String returnSI = getCoefficients(getUnitClass(returnClass));
        String scalarSI = getCoefficients(getUnitClass(scalarClass));
        String paramSI = getCoefficients(getUnitClass(parameterClass));
        // print what we just have found
        System.out.println(scalarClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + "."
                + (multiply ? "multiplyBy" : "divideBy") + "("
                + parameterClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ") => "
                + returnClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ": " + scalarSI
                + (multiply ? " * " : " : ") + paramSI + " => " + returnSI);

        Constructor<?> constructor = scalarClass.getConstructor(double.class, getUnitClass(scalarClass));
        if (abs)
        {
            fail("Absolute types should not have a multiply or divide method");
            DoubleScalar.Abs<?> left =
                    (DoubleScalar.Abs<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(scalarClass)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            DoubleScalar.Abs<?> right =
                    (DoubleScalar.Abs<?>) constructor.newInstance(456d, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            double expectedValue = multiply ? 123d * 456 : 123d / 456;

            if (multiply)
            {
                Method multiplyMethod = scalarClass.getDeclaredMethod("multiplyBy", new Class[] { parameterClass });
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Abs<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = scalarClass.getDeclaredMethod("divideBy", new Class[] { parameterClass });
                Object result = divideMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Abs<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            DoubleScalar.Abs<?> result = multiply ? DoubleScalar.multiply(left, right) : DoubleScalar.divide(left, right);
            // System.out.println("result is " + result);
            String resultCoefficients = result.getUnit().getSICoefficientsString();
            assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
        }
        else
        {
            if (doubleType)
            {
                DoubleScalar.Rel<?> left =
                        (DoubleScalar.Rel<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(scalarClass)));
                // System.out.println("constructed left: " + left);
                constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
                DoubleScalar.Rel<?> right =
                        (DoubleScalar.Rel<?>) constructor.newInstance(456d, getSIUnitInstance(getUnitClass(parameterClass)));
                // System.out.println("constructed right: " + right);
                double expectedValue = multiply ? 123d * 456 : 123d / 456;

                if (multiply)
                {
                    Method multiplyMethod = scalarClass.getDeclaredMethod("multiplyBy", new Class[] { parameterClass });
                    Object result = multiplyMethod.invoke(left, right);
                    double resultSI = ((DoubleScalar.Rel<?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                else
                {
                    Method divideMethod = scalarClass.getDeclaredMethod("divideBy", new Class[] { parameterClass });
                    Object result = divideMethod.invoke(left, right);
                    double resultSI = ((DoubleScalar.Rel<?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                DoubleScalar.Rel<?> result = multiply ? DoubleScalar.multiply(left, right) : DoubleScalar.divide(left, right);
                // System.out.println("result is " + result);
                String resultCoefficients = result.getUnit().getSICoefficientsString();
                assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
            }
            else
            {
                FloatScalar.Rel<?> left =
                        (FloatScalar.Rel<?>) constructor.newInstance(123f, getSIUnitInstance(getUnitClass(scalarClass)));
                // System.out.println("constructed left: " + left);
                constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
                FloatScalar.Rel<?> right =
                        (FloatScalar.Rel<?>) constructor.newInstance(456f, getSIUnitInstance(getUnitClass(parameterClass)));
                // System.out.println("constructed right: " + right);
                float expectedValue = multiply ? 123f * 456 : 123f / 456;

                if (multiply)
                {
                    Method multiplyMethod = scalarClass.getDeclaredMethod("multiplyBy", new Class[] { parameterClass });
                    Object result = multiplyMethod.invoke(left, right);
                    double resultSI = ((FloatScalar.Rel<?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                else
                {
                    Method divideMethod = scalarClass.getDeclaredMethod("divideBy", new Class[] { parameterClass });
                    Object result = divideMethod.invoke(left, right);
                    float resultSI = ((FloatScalar.Rel<?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                FloatScalar.Rel<?> result = multiply ? FloatScalar.multiply(left, right) : FloatScalar.divide(left, right);
                // System.out.println("result is " + result);
                String resultCoefficients = result.getUnit().getSICoefficientsString();
                assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
            }
        }
    }

    /**
     * Obtain the SI coefficient string of a DJUNITS class.
     * @param clas Class&lt;?&gt;; the DJUNITS class
     * @return String
     * @throws IllegalAccessException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     */
    private String getCoefficients(final Class<?> clas) throws IllegalAccessException, NoSuchFieldException
    {
        if (clas.getName().contains("Money"))
        {
            // get any static field of the type itself
            for (Field field : clas.getDeclaredFields())
            {
                if (field.getType().equals(clas))
                {
                    return ((Unit<?>) field.get(clas)).getSICoefficientsString();
                }
            }
            return "1";
        }
        Field si = clas.getField("SI");
        Unit<?> u = ((Unit<?>) si.get(clas));
        String r = u.getSICoefficientsString();
        return r;
        // return ((Unit<?>) si.get(clas)).getSICoefficientsString();
    }

    /**
     * Obtain the SI coefficient string of a DJUNITS class.
     * @param clas Class&lt;?&gt;; the DJUNITS class
     * @return String
     * @throws NoSuchFieldException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     */
    private Unit<?> getSIUnitInstance(final Class<?> clas) throws NoSuchFieldException, IllegalAccessException
    {
        if (clas.getName().contains("Money"))
        {
            // get any static field of the type itself
            for (Field field : clas.getDeclaredFields())
            {
                if (field.getType().equals(clas))
                {
                    return ((Unit<?>) field.get(clas));
                }
            }
            return null;
        }
        Field si = clas.getField("SI");
        return ((Unit<?>) si.get(clas));
    }

    /**
     * Get the unit of a Scalar class by looking at the constructor with two arguments -- the second argument is the unit type.
     * @param scalarClass the class to find the unit for
     * @return the unit class for this scalar class
     */
    private Class<?> getUnitClass(final Class<?> scalarClass)
    {
        Constructor<?>[] constructors = scalarClass.getConstructors();
        for (Constructor<?> constructor : constructors)
        {
            Class<?>[] parTypes = constructor.getParameterTypes();
            if (parTypes.length == 2 && Unit.class.isAssignableFrom(parTypes[1]))
            {
                return parTypes[1];
            }
        }
        Assert.fail("Could not find constructor with one unit for Scalar class " + scalarClass.getName());
        return null;
    }

    /**
     * Verify the Absolute-ness or Relative-ness of a DoubleScalar and return the SI value.
     * @param abs boolean; expected Absolute- or Relative-ness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param o the (DoubleScalar?) object
     * @return double; the SI value
     */
    private double verifyAbsRelPrecisionAndExtractSI(final boolean abs, final boolean doubleType, final Object o)
    {
        double result = Double.NaN;
        if (doubleType)
        {
            if (!(o instanceof DoubleScalar))
            {
                fail("object is not a DoubleScalar");
            }
            result = ((DoubleScalar<?>) o).getSI();
        }
        else
        {
            if (!(o instanceof FloatScalar))
            {
                fail("object is not a FloatScalar");
            }
            result = ((FloatScalar<?>) o).getSI();
        }
        if (o instanceof Absolute)
        {
            if (!abs)
            {
                fail("Result should have been Absolute");
            }
        }
        else if (o instanceof Relative)
        {
            if (abs)
            {
                fail("Result should have been Relative");
            }
        }
        else
        {
            fail("Result is neither Absolute, nor Relative");
        }
        return result;
    }

    /**
     * @param scalarClass the class to test
     * @param abs abs or rel class
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     */
    private void testUnaryMethods(final Class<?> scalarClass, final boolean abs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException
    {
        double value = 1.23456;
        Constructor<?> constructor =
                scalarClass.getConstructor(doubleType ? double.class : float.class, getUnitClass(scalarClass));
        Object left;
        if (doubleType)
        {
            left =
                    abs ? (DoubleScalar.Abs<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(scalarClass)))
                            : (DoubleScalar.Rel<?>) constructor
                                    .newInstance(value, getSIUnitInstance(getUnitClass(scalarClass)));
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = scalarClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1)
                {
                    DoubleScalar<?> newInstance = (DoubleScalar<?>) c.newInstance(left);
                    assertEquals("Result of constructor should be equal to original", value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, newInstance), 0.01);
                }
            }
        }
        else
        {
            left =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance((float) value,
                            getSIUnitInstance(getUnitClass(scalarClass))) : (FloatScalar.Rel<?>) constructor.newInstance(
                            (float) value, getSIUnitInstance(getUnitClass(scalarClass)));
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = scalarClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1)
                {
                    // System.out.println("parType is " + parTypes[0]);
                    FloatScalar<?> newInstance = (FloatScalar<?>) c.newInstance(left);
                    assertEquals("Result of constructor should be equal to original", value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, newInstance), 0.01);
                }
            }
        }
        Object result;

        Method methodAbs = scalarClass.getDeclaredMethod("abs", new Class[] {});
        result = methodAbs.invoke(left);
        assertEquals("Result of operation", Math.abs(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method asin = scalarClass.getDeclaredMethod("asin", new Class[] {});
        result = asin.invoke(left);
        assertEquals("Result of operation", Math.asin(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method acos = scalarClass.getDeclaredMethod("acos", new Class[] {});
        result = acos.invoke(left);
        assertEquals("Result of operation", Math.acos(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method atan = scalarClass.getDeclaredMethod("atan", new Class[] {});
        result = atan.invoke(left);
        assertEquals("Result of operation", Math.atan(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method cbrt = scalarClass.getDeclaredMethod("cbrt", new Class[] {});
        result = cbrt.invoke(left);
        assertEquals("Result of operation", Math.cbrt(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method ceil = scalarClass.getDeclaredMethod("ceil", new Class[] {});
        result = ceil.invoke(left);
        assertEquals("Result of operation", Math.ceil(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method cos = scalarClass.getDeclaredMethod("cos", new Class[] {});
        result = cos.invoke(left);
        assertEquals("Result of operation", Math.cos(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method cosh = scalarClass.getDeclaredMethod("cosh", new Class[] {});
        result = cosh.invoke(left);
        assertEquals("Result of operation", Math.cosh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method exp = scalarClass.getDeclaredMethod("exp", new Class[] {});
        result = exp.invoke(left);
        assertEquals("Result of operation", Math.exp(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method expm1 = scalarClass.getDeclaredMethod("expm1", new Class[] {});
        result = expm1.invoke(left);
        assertEquals("Result of operation", Math.expm1(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method floor = scalarClass.getDeclaredMethod("floor", new Class[] {});
        result = floor.invoke(left);
        assertEquals("Result of operation", Math.floor(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method log = scalarClass.getDeclaredMethod("log", new Class[] {});
        result = log.invoke(left);
        assertEquals("Result of operation", Math.log(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method log10 = scalarClass.getDeclaredMethod("log10", new Class[] {});
        result = log10.invoke(left);
        assertEquals("Result of operation", Math.log10(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method log1p = scalarClass.getDeclaredMethod("log1p", new Class[] {});
        result = log1p.invoke(left);
        assertEquals("Result of operation", Math.log1p(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method rint = scalarClass.getDeclaredMethod("rint", new Class[] {});
        result = rint.invoke(left);
        assertEquals("Result of operation", Math.rint(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method round = scalarClass.getDeclaredMethod("round", new Class[] {});
        result = round.invoke(left);
        assertEquals("Result of operation", Math.round(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method signum = scalarClass.getDeclaredMethod("signum", new Class[] {});
        result = signum.invoke(left);
        assertEquals("Result of operation", Math.signum(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                0.01);

        Method sin = scalarClass.getDeclaredMethod("sin", new Class[] {});
        result = sin.invoke(left);
        assertEquals("Result of operation", Math.sin(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method sinh = scalarClass.getDeclaredMethod("sinh", new Class[] {});
        result = sinh.invoke(left);
        assertEquals("Result of operation", Math.sinh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method sqrt = scalarClass.getDeclaredMethod("sqrt", new Class[] {});
        result = sqrt.invoke(left);
        assertEquals("Result of operation", Math.sqrt(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method tan = scalarClass.getDeclaredMethod("tan", new Class[] {});
        result = tan.invoke(left);
        assertEquals("Result of operation", Math.tan(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method tanh = scalarClass.getDeclaredMethod("tanh", new Class[] {});
        result = tanh.invoke(left);
        assertEquals("Result of operation", Math.tanh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method inv = scalarClass.getDeclaredMethod("inv", new Class[] {});
        result = inv.invoke(left);
        assertEquals("Result of operation", 1 / value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method toDegrees = scalarClass.getDeclaredMethod("toDegrees", new Class[] {});
        result = toDegrees.invoke(left);
        assertEquals("Result of operation", Math.toDegrees(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                0.01);

        Method toRadians = scalarClass.getDeclaredMethod("toRadians", new Class[] {});
        result = toRadians.invoke(left);
        assertEquals("Result of operation", Math.toRadians(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                0.01);

        Method pow = scalarClass.getDeclaredMethod("pow", new Class[] { double.class });
        result = pow.invoke(left, Math.PI);
        assertEquals("Result of operation", Math.pow(value, Math.PI),
                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        if (!abs)
        {
            Method multiplyBy = scalarClass.getDeclaredMethod("multiplyBy", new Class[] { double.class });
            result = multiplyBy.invoke(left, Math.PI);
            assertEquals("Result of operation", Math.PI * value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method divideBy = scalarClass.getDeclaredMethod("divideBy", new Class[] { double.class });
            result = divideBy.invoke(left, Math.PI);
            assertEquals("Result of operation", value / Math.PI, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method plus = scalarClass.getDeclaredMethod("plus", new Class[] { scalarClass });
            result = plus.invoke(left, left);
            assertEquals("Result of operation", value + value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);
        }

        Method minus = scalarClass.getDeclaredMethod("minus", new Class[] { scalarClass });
        result = minus.invoke(left, left);
        assertEquals("Result of operation", 0, verifyAbsRelPrecisionAndExtractSI(false, doubleType, result), 0.01);

    }

    /**
     * Test the interpolate method.
     * @param scalarClass Class&lt;?&gt;; the class to test
     * @param abs boolean; if true; scalarClass is Absolute; if false; scalarClass is Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     */
    private void testInterpolateMethod(final Class<?> scalarClass, final boolean abs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException
    {
        Constructor<?> constructor = scalarClass.getConstructor(double.class, getUnitClass(scalarClass));
        if (doubleType)
        {
            double zeroValue = 1.23456;
            DoubleScalar<?> zero =
                    abs ? (DoubleScalar.Abs<?>) constructor
                            .newInstance(zeroValue, getSIUnitInstance(getUnitClass(scalarClass)))
                            : (DoubleScalar.Rel<?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass)));
            double oneValue = 3.45678;
            DoubleScalar<?> one =
                    abs ? (DoubleScalar.Abs<?>) constructor.newInstance(oneValue, getSIUnitInstance(getUnitClass(scalarClass)))
                            : (DoubleScalar.Rel<?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass)));
            for (double ratio : new double[] { -5, -1, 0, 0.3, 1, 2, 10 })
            {
                double expectedResult = (1.0 - ratio) * zeroValue + ratio * oneValue;
                Method interpolate = scalarClass.getMethod("interpolate", scalarClass, scalarClass, double.class);
                DoubleScalar<?> result;
                result = (DoubleScalar<?>) interpolate.invoke(null, zero, one, ratio);
                assertEquals("Result of operation", expectedResult, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
            }
        }
        else
        {
            float zeroValue = 1.23456f;
            FloatScalar<?> zero =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance(zeroValue, getSIUnitInstance(getUnitClass(scalarClass)))
                            : (FloatScalar.Rel<?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass)));
            float oneValue = 3.45678f;
            FloatScalar<?> one =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance(oneValue, getSIUnitInstance(getUnitClass(scalarClass)))
                            : (FloatScalar.Rel<?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass)));
            for (float ratio : new float[] { -5, -1, 0, 0.3f, 1, 2, 10 })
            {
                float expectedResult = (1.0f - ratio) * zeroValue + ratio * oneValue;
                Method interpolate = scalarClass.getMethod("interpolate", scalarClass, scalarClass, float.class);
                FloatScalar<?> result;
                result = (FloatScalar<?>) interpolate.invoke(null, zero, one, ratio);
                assertEquals("Result of operation", expectedResult, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
            }
        }
    }

}
