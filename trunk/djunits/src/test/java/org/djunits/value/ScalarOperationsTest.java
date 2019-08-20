package org.djunits.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits.unit.Unit;
import org.djunits.unit.unitsystem.UnitSystem;
import org.djunits.util.ClassUtil;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalar;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarAbs;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarRel;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.DoubleScalarInterface;
import org.djunits.value.vfloat.scalar.AbstractFloatScalar;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarAbs;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarRel;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.djunits.value.vfloat.scalar.FloatScalarInterface;
import org.junit.Assert;
import org.junit.Test;

/**
 * Find all plus, minus, multiplyBy and divideBy operations and prove the type correctness.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 14, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ScalarOperationsTest
{
    /** The classes that are absolute (name = class name). */
    public static final String[] CLASSNAMES_ABS = new String[] { "AbsoluteTemperature", "Direction", "Position", "Time" };

    /** The relative classes that mirror the absolute ones (name = class name). */
    public static final String[] CLASSNAMES_ABS_REL = new String[] { "Temperature", "Angle", "Length", "Duration" };

    /** The classes that are just relative (name = class name). */
    public static final String[] CLASSNAMES_REL = new String[] { "Angle", "Acceleration", "AngleSolid", "Area", "Density",
            "Dimensionless", "Duration", "ElectricalCharge", "ElectricalCurrent", "ElectricalPotential", "ElectricalResistance",
            "Energy", "FlowMass", "FlowVolume", "Force", "Frequency", "Length", "LinearDensity", "Mass", "Power", "Pressure",
            "Speed", "Temperature", "Torque", "Volume" };

    /** The money classes that are just relative (name = class name); these classes don't have an si field. */
    public static final String[] CLASSNAMES_MONEY = new String[] { "Money", "MoneyPerArea", "MoneyPerEnergy", "MoneyPerLength",
            "MoneyPerMass", "MoneyPerDuration", "MoneyPerVolume" };

    /**
     * Test constructor on the specified double scalar classes.
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws SecurityException on reflection error
     */
    @Test
    public final void scalarOperationsTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException
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
     * @throws ClassNotFoundException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws SecurityException on reflection error
     */
    private void doubleOrFloatScalarOperationsTest(final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException
    {
        final String upperType = doubleType ? "Double" : "Float";
        final String type = upperType.toLowerCase();
        // get the interfaces such as org.djunits.value.vdouble.scalar.Time
        for (int i = 0; i < CLASSNAMES_ABS.length; i++)
        {
            String scalarNameAbs = CLASSNAMES_ABS[i];
            String scalarNameRel = CLASSNAMES_ABS_REL[i];
            String scalarClassNameAbs = doubleType ? scalarNameAbs : "Float" + scalarNameAbs;
            String scalarClassNameRel = doubleType ? scalarNameRel : "Float" + scalarNameRel;
            Class<?> scalarClassAbs = null;
            Class<?> scalarClassRel = null;
            // get the subClassName implementation of that class
            try
            {
                scalarClassAbs = Class.forName("org.djunits.value.v" + type + ".scalar." + scalarClassNameAbs);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class Rel not found for " + upperType + "Scalar class " + "org.djunits.value.v" + type + ".scalar."
                        + scalarClassNameAbs);
            }
            try
            {
                scalarClassRel = Class.forName("org.djunits.value.v" + type + ".scalar." + scalarClassNameRel);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class Rel not found for " + upperType + "Scalar class " + "org.djunits.value.v" + type + ".scalar."
                        + scalarClassNameRel);
            }
            testMethods(scalarClassAbs, true, doubleType);
            testMethods(scalarClassRel, false, doubleType);
        }

        // get the interfaces such as org.djunits.value.vXXXX.scalar.Area
        for (String scalarName : CLASSNAMES_REL)
        {
            String scalarClassName = doubleType ? scalarName : "Float" + scalarName;
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
        for (String scalarName : CLASSNAMES_MONEY)
        {
            String scalarClassName = doubleType ? scalarName : "Float" + scalarName;
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
     * @throws ClassNotFoundException on reflection error
     */
    private void testMethods(final Class<?> scalarClassAbsRel, final boolean isAbs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, ClassNotFoundException
    {
        for (Method method : scalarClassAbsRel.getMethods())
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
        testStaticMethods(scalarClassAbsRel, isAbs, doubleType);
    }

    /**
     * Test a multiplication method for an Abs or Rel scalar. Note: filter out the method that multiplies by a constant...
     * @param scalarClass the Abs or Rel class for the multiplication, e.g. Length
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
        if (parameterClass.toString().equals("double") || parameterClass.toString().equals("float"))
        {
            // not interested in multiplying a scalar with a double.
            return;
        }
        if (!relativeOrAbsoluteClass.isAssignableFrom(parameterClass))
        {
            System.out.println("abs=" + abs + ", method=" + scalarClass.getName() + "." + method.getName() + " param="
                    + parameterClass.getName());
            Assert.fail("DoubleScalar class " + scalarClass.getName() + "." + method.getName() + "() has parameter with non-"
                    + relativeOrAbsoluteClass + " class: " + relativeOrAbsoluteClass.getName());
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
            AbstractDoubleScalarAbs<?, ?, ?, ?> left = (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(123d,
                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            AbstractDoubleScalarAbs<?, ?, ?, ?> right = (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(456d,
                    getSIUnitInstance(getUnitClass(parameterClass), abs));
            // System.out.println("constructed right: " + right);
            double expectedValue = multiply ? 123d * 456 : 123d / 456;

            if (multiply)
            {
                Method multiplyMethod = ClassUtil.resolveMethod(scalarClass, "multiplyBy", new Class[] { parameterClass });
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((AbstractDoubleScalarAbs<?, ?, ?, ?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = ClassUtil.resolveMethod(scalarClass, "divideBy", new Class[] { parameterClass });
                Object result = divideMethod.invoke(left, right);
                double resultSI = ((AbstractDoubleScalarAbs<?, ?, ?, ?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
        }
        else
        {
            if (doubleType)
            {
                AbstractDoubleScalarRel<?, ?> left = (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(123d,
                        getSIUnitInstance(getUnitClass(scalarClass), abs));
                // System.out.println("constructed left: " + left);
                constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
                AbstractDoubleScalarRel<?, ?> right = (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(456d,
                        getSIUnitInstance(getUnitClass(parameterClass), abs));
                // System.out.println("constructed right: " + right);
                double expectedValue = multiply ? 123d * 456 : 123d / 456;

                if (multiply)
                {
                    Method multiplyMethod = ClassUtil.resolveMethod(scalarClass, "multiplyBy", new Class[] { parameterClass });
                    Object result = multiplyMethod.invoke(left, right);
                    double resultSI = ((AbstractDoubleScalarRel<?, ?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                else
                {
                    Method divideMethod = ClassUtil.resolveMethod(scalarClass, "divideBy", new Class[] { parameterClass });
                    Object result = divideMethod.invoke(left, right);
                    double resultSI = ((AbstractDoubleScalarRel<?, ?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                AbstractDoubleScalarRel<?, ?> result =
                        multiply ? DoubleScalar.multiply(left, right) : DoubleScalar.divide(left, right);
                // System.out.println("result is " + result);
                String resultCoefficients = result.getUnit().getSICoefficientsString();
                assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
            }
            else
            {
                AbstractFloatScalarRel<?, ?> left = (AbstractFloatScalarRel<?, ?>) constructor.newInstance(123f,
                        getSIUnitInstance(getUnitClass(scalarClass), abs));
                // System.out.println("constructed left: " + left);
                constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
                AbstractFloatScalarRel<?, ?> right = (AbstractFloatScalarRel<?, ?>) constructor.newInstance(456f,
                        getSIUnitInstance(getUnitClass(parameterClass), abs));
                // System.out.println("constructed right: " + right);
                float expectedValue = multiply ? 123f * 456 : 123f / 456;

                if (multiply)
                {
                    Method multiplyMethod = ClassUtil.resolveMethod(scalarClass, "multiplyBy", new Class[] { parameterClass });
                    Object result = multiplyMethod.invoke(left, right);
                    double resultSI = ((AbstractFloatScalarRel<?, ?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                else
                {
                    Method divideMethod = ClassUtil.resolveMethod(scalarClass, "divideBy", new Class[] { parameterClass });
                    Object result = divideMethod.invoke(left, right);
                    float resultSI = ((AbstractFloatScalarRel<?, ?>) result).si;
                    assertEquals("Result of operation", expectedValue, resultSI, 0.01);
                }
                AbstractFloatScalarRel<?, ?> result =
                        multiply ? FloatScalar.multiply(left, right) : FloatScalar.divide(left, right);
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
     * @param isAbs true when abs
     * @return String
     * @throws NoSuchFieldException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     */
    private Unit<?> getSIUnitInstance(final Class<?> clas, final boolean isAbs)
            throws NoSuchFieldException, IllegalAccessException
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
        Field si = isAbs ? clas.getField("BASE") : clas.getField("SI");
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
            if (!(o instanceof DoubleScalarInterface))
            {
                fail("object is not a DoubleScalar");
            }
            result = ((AbstractDoubleScalar<?, ?>) o).getSI();
        }
        else
        {
            if (!(o instanceof FloatScalarInterface))
            {
                fail("object is not a FloatScalar");
            }
            result = ((AbstractFloatScalar<?, ?>) o).getSI();
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
     * @throws ClassNotFoundException on class or method resolving error
     */
    private void testUnaryMethods(final Class<?> scalarClass, final boolean abs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, ClassNotFoundException
    {
        double value = 1.23456;
        Constructor<?> constructor =
                scalarClass.getConstructor(doubleType ? double.class : float.class, getUnitClass(scalarClass));
        Object left;
        if (doubleType)
        {
            left = abs
                    ? (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(value,
                            getSIUnitInstance(getUnitClass(scalarClass), abs))
                    : (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(value,
                            getSIUnitInstance(getUnitClass(scalarClass), abs));
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = scalarClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1)
                {
                    AbstractDoubleScalar<?, ?> newInstance = (AbstractDoubleScalar<?, ?>) c.newInstance(left);
                    assertEquals("Result of constructor should be equal to original", value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, newInstance), 0.01);
                }
            }
        }
        else
        {
            left = abs
                    ? (AbstractFloatScalarAbs<?, ?, ?, ?>) constructor.newInstance((float) value,
                            getSIUnitInstance(getUnitClass(scalarClass), abs))
                    : (AbstractFloatScalarRel<?, ?>) constructor.newInstance((float) value,
                            getSIUnitInstance(getUnitClass(scalarClass), abs));
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = scalarClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1)
                {
                    // System.out.println("parType is " + parTypes[0]);
                    AbstractFloatScalar<?, ?> newInstance = (AbstractFloatScalar<?, ?>) c.newInstance(left);
                    assertEquals("Result of constructor should be equal to original", value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, newInstance), 0.01);
                }
            }
        }
        Object result;

        Method ceil = ClassUtil.resolveMethod(scalarClass, "ceil", new Class[] {});
        result = ceil.invoke(left);
        assertEquals("Result of operation", Math.ceil(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method floor = ClassUtil.resolveMethod(scalarClass, "floor", new Class[] {});
        result = floor.invoke(left);
        assertEquals("Result of operation", Math.floor(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                0.01);

        Method rint = ClassUtil.resolveMethod(scalarClass, "rint", new Class[] {});
        result = rint.invoke(left);
        assertEquals("Result of operation", Math.rint(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

        Method round = ClassUtil.resolveMethod(scalarClass, "round", new Class[] {});
        result = round.invoke(left);
        assertEquals("Result of operation", Math.round(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                0.01);
        
        if (!abs)
        {
            Method methodAbs = ClassUtil.resolveMethod(scalarClass, "abs", new Class[] {});
            result = methodAbs.invoke(left);
            assertEquals("Result of operation", Math.abs(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);
        }

        if (scalarClass.getName().contains("Dimensionless"))
        {
            Method asin = ClassUtil.resolveMethod(scalarClass, "asin", new Class[] {});
            result = asin.invoke(left);
            assertEquals("Result of operation", Math.asin(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method acos = ClassUtil.resolveMethod(scalarClass, "acos", new Class[] {});
            result = acos.invoke(left);
            assertEquals("Result of operation", Math.acos(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method atan = ClassUtil.resolveMethod(scalarClass, "atan", new Class[] {});
            result = atan.invoke(left);
            assertEquals("Result of operation", Math.atan(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method cbrt = ClassUtil.resolveMethod(scalarClass, "cbrt", new Class[] {});
            result = cbrt.invoke(left);
            assertEquals("Result of operation", Math.cbrt(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method cos = ClassUtil.resolveMethod(scalarClass, "cos", new Class[] {});
            result = cos.invoke(left);
            assertEquals("Result of operation", Math.cos(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method cosh = ClassUtil.resolveMethod(scalarClass, "cosh", new Class[] {});
            result = cosh.invoke(left);
            assertEquals("Result of operation", Math.cosh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method exp = ClassUtil.resolveMethod(scalarClass, "exp", new Class[] {});
            result = exp.invoke(left);
            assertEquals("Result of operation", Math.exp(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method expm1 = ClassUtil.resolveMethod(scalarClass, "expm1", new Class[] {});
            result = expm1.invoke(left);
            assertEquals("Result of operation", Math.expm1(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method log = ClassUtil.resolveMethod(scalarClass, "log", new Class[] {});
            result = log.invoke(left);
            assertEquals("Result of operation", Math.log(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method log10 = ClassUtil.resolveMethod(scalarClass, "log10", new Class[] {});
            result = log10.invoke(left);
            assertEquals("Result of operation", Math.log10(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method log1p = ClassUtil.resolveMethod(scalarClass, "log1p", new Class[] {});
            result = log1p.invoke(left);
            assertEquals("Result of operation", Math.log1p(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method signum = ClassUtil.resolveMethod(scalarClass, "signum", new Class[] {});
            result = signum.invoke(left);
            assertEquals("Result of operation", Math.signum(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method sin = ClassUtil.resolveMethod(scalarClass, "sin", new Class[] {});
            result = sin.invoke(left);
            assertEquals("Result of operation", Math.sin(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method sinh = ClassUtil.resolveMethod(scalarClass, "sinh", new Class[] {});
            result = sinh.invoke(left);
            assertEquals("Result of operation", Math.sinh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method sqrt = ClassUtil.resolveMethod(scalarClass, "sqrt", new Class[] {});
            result = sqrt.invoke(left);
            assertEquals("Result of operation", Math.sqrt(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method tan = ClassUtil.resolveMethod(scalarClass, "tan", new Class[] {});
            result = tan.invoke(left);
            assertEquals("Result of operation", Math.tan(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method tanh = ClassUtil.resolveMethod(scalarClass, "tanh", new Class[] {});
            result = tanh.invoke(left);
            assertEquals("Result of operation", Math.tanh(value), verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method inv = ClassUtil.resolveMethod(scalarClass, "inv", new Class[] {});
            result = inv.invoke(left);
            assertEquals("Result of operation", 1 / value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);

            Method pow = ClassUtil.resolveMethod(scalarClass, "pow", new Class[] { double.class });
            result = pow.invoke(left, Math.PI);
            assertEquals("Result of operation", Math.pow(value, Math.PI),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result), 0.01);
        }

        Object compatibleRight = null;
        // TODO: Probably we exclude too much here for the tests...
        if (!scalarClass.getName().contains("Money") && !scalarClass.getName().contains("Dimensionless")
                && !scalarClass.getName().contains("Temperature") && !scalarClass.getName().contains("Position")
                && !scalarClass.getName().contains("Time") && !scalarClass.getName().contains("Direction"))
        {
            // Construct a new unit to test mixed unit plus and minus
            Class<?> unitClass = getUnitClass(scalarClass);
            UnitSystem unitSystem = UnitSystem.SI_DERIVED;
            Unit<?> referenceUnit;
            // Call the getUnit method of left
            Method getUnitMethod = ClassUtil.resolveMethod(scalarClass, "getUnit");
            referenceUnit = (Unit<?>) getUnitMethod.invoke(left);
            Constructor<?> unitConstructor =
                    unitClass.getConstructor(String.class, String.class, UnitSystem.class, unitClass, double.class);
            Object newUnit = unitConstructor.newInstance("7fullName", "7abbr", unitSystem, referenceUnit, 7d);
            // System.out.println("new unit prints like " + newUnit);
            if (doubleType)
            {
                compatibleRight = abs ? (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(value, newUnit)
                        : (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(value, newUnit);
            }
            else
            {
                compatibleRight = abs ? (AbstractFloatScalarAbs<?, ?, ?, ?>) constructor.newInstance((float) value, newUnit)
                        : (AbstractFloatScalarRel<?, ?>) constructor.newInstance((float) value, newUnit);
            }
            // System.out.println("compatibleRight prints like \"" + compatibleRight + "\"");
        }
        if (!abs)
        {
            Method multiplyBy =
                    ClassUtil.resolveMethod(scalarClass, "multiplyBy", new Class[] { doubleType ? double.class : float.class });
            result = doubleType ? multiplyBy.invoke(left, Math.PI) : multiplyBy.invoke(left, (float) Math.PI);
            assertEquals("Result of operation", Math.PI * value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method divideBy =
                    ClassUtil.resolveMethod(scalarClass, "divideBy", new Class[] { doubleType ? double.class : float.class });
            result = doubleType ? divideBy.invoke(left, Math.PI) : divideBy.invoke(left, (float) Math.PI);
            assertEquals("Result of operation", value / Math.PI, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            Method plus = ClassUtil.resolveMethod(scalarClass, "plus", new Class[] { scalarClass });
            result = plus.invoke(left, left);
            assertEquals("Result of operation", value + value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                    0.01);

            if (null != compatibleRight)
            {
                result = plus.invoke(left, compatibleRight);
                assertEquals("Result of mixed operation", 8 * value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
                // Swap the operands
                // System.out.println("finding plus method for " + compatibleRight.getClass().getName() + " left type is "
                // + left.getClass().getName());
                plus = ClassUtil.resolveMethod(scalarClass, "plus", new Class[] { compatibleRight.getClass().getSuperclass() });
                result = plus.invoke(compatibleRight, left);
                assertEquals("Result of mixed operation", 8 * value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
                if (scalarClass.getName().contains("$Rel"))
                {
                    // Make an Absolute for one operand
                    String absScalarClassName = scalarClass.getName().replace("$Rel", "$Abs");
                    Class<?> absScalarClass = Class.forName(absScalarClassName);
                    Constructor<?> absScalarConstructor = absScalarClass.getConstructor(doubleType ? double.class : float.class,
                            getUnitClass(absScalarClass));
                    Object absOperand = null;
                    // System.out.println("unit is " + getUnitClass(absScalarClass));
                    if (doubleType)
                    {
                        absOperand =
                                absScalarConstructor.newInstance(value, getSIUnitInstance(getUnitClass(absScalarClass), true));
                    }
                    else
                    {
                        absOperand = absScalarConstructor.newInstance((float) value,
                                getSIUnitInstance(getUnitClass(absScalarClass), true));
                    }
                    // abs plus rel yields abs
                    plus = ClassUtil.resolveMethod(absScalarClass, "plus", scalarClass);
                    result = plus.invoke(absOperand, left);
                    assertEquals("Result of mixed abs + rel", 2 * value,
                            verifyAbsRelPrecisionAndExtractSI(true, doubleType, result), 0.01);
                    Method toAbs = compatibleRight.getClass().getMethod("toAbs");
                    Object absCompatible = toAbs.invoke(compatibleRight);
                    result = plus.invoke(absCompatible, left);
                    assertEquals("Result of mixed compatible abs + rel", 8 * value,
                            verifyAbsRelPrecisionAndExtractSI(true, doubleType, result), 0.01);
                    // rel plus abs yields abs
                    plus = ClassUtil.resolveMethod(scalarClass, "plus", absScalarClass);
                    result = plus.invoke(left, absOperand);
                    assertEquals("Result of mixed rel + abs", 2 * value,
                            verifyAbsRelPrecisionAndExtractSI(true, doubleType, result), 0.01);
                    result = plus.invoke(left, absCompatible);
                    assertEquals("Result of mixed rel + compatible abs", 8 * value,
                            verifyAbsRelPrecisionAndExtractSI(true, doubleType, result), 0.01);
                }
            }
        }

        Method minus = ClassUtil.resolveMethod(scalarClass, "minus", new Class[] { scalarClass });
        result = minus.invoke(left, left);
        assertEquals("Result of minus", 0, verifyAbsRelPrecisionAndExtractSI(false, doubleType, result), 0.01);
        if (null != compatibleRight)
        {
            result = minus.invoke(left, compatibleRight);
            assertEquals("Result of minus with compatible arg for " + left + " and " + compatibleRight, -6 * value,
                    verifyAbsRelPrecisionAndExtractSI(false, doubleType, result), 0.01);
        }
        if (scalarClass.getName().contains("$Rel") || scalarClass.getName().contains("$Abs"))
        {
            // Make an Absolute for one operand
            String absScalarClassName = scalarClass.getName().replace("$Rel", "$Abs");
            Class<?> absScalarClass = Class.forName(absScalarClassName);
            Constructor<?> absScalarConstructor =
                    absScalarClass.getConstructor(doubleType ? double.class : float.class, getUnitClass(absScalarClass));
            Object absOperand = null;
            // System.out.println("unit is " + getUnitClass(absScalarClass));
            if (doubleType)
            {
                absOperand = absScalarConstructor.newInstance(value, getSIUnitInstance(getUnitClass(absScalarClass), true));
            }
            else
            {
                absOperand =
                        absScalarConstructor.newInstance((float) value, getSIUnitInstance(getUnitClass(absScalarClass), true));
            }
            minus = ClassUtil.resolveMethod(absScalarClass, "minus", scalarClass);
            result = minus.invoke(absOperand, left);
            assertEquals("Result of abs or rel minus rel", 0, verifyAbsRelPrecisionAndExtractSI(!abs, doubleType, result),
                    0.01);
            if (null != compatibleRight && scalarClass.getName().contains("$Rel"))
            {
                Method toAbs = compatibleRight.getClass().getMethod("toAbs");
                Object absCompatible = toAbs.invoke(compatibleRight);
                result = minus.invoke(absCompatible, left);
                assertEquals("Result of compatible abs or rel minus rel", 6 * value,
                        verifyAbsRelPrecisionAndExtractSI(!abs, doubleType, result), 0.01);
            }
        }
    }

    /**
     * Test the various static methods.
     * @param scalarClass Class&lt;?&gt;; the class to test
     * @param abs boolean; if true; scalarClass is Absolute; if false; scalarClass is Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     */
    private void testStaticMethods(final Class<?> scalarClass, final boolean abs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException
    {
        Constructor<?> constructor = scalarClass.getConstructor(double.class, getUnitClass(scalarClass));
        if (doubleType)
        {
            double zeroValue = 1.23456;
            AbstractDoubleScalar<?,
                    ?> zero = abs
                            ? (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs))
                            : (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            double oneValue = 3.45678;
            AbstractDoubleScalar<?,
                    ?> one = abs
                            ? (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs))
                            : (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            for (double ratio : new double[] { -5, -1, 0, 0.3, 1, 2, 10 })
            {
                double expectedResult = (1.0 - ratio) * zeroValue + ratio * oneValue;
                Method interpolate =
                        ClassUtil.resolveMethod(scalarClass, "interpolate", scalarClass, scalarClass, double.class);
                AbstractDoubleScalar<?, ?> result;
                result = (AbstractDoubleScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                assertEquals("Result of operation", expectedResult, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
            }
            /*-
            double biggestValue = 345.678;
            AbstractDoubleScalar<?,
                    ?> biggest = abs
                            ? (AbstractDoubleScalarAbs<?, ?, ?, ?>) constructor.newInstance(biggestValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs))
                            : (AbstractDoubleScalarRel<?, ?>) constructor.newInstance(biggestValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            */
            Method max = ClassUtil.resolveMethod(scalarClass, "max", scalarClass, scalarClass);
            AbstractDoubleScalar<?, ?> result = (AbstractDoubleScalar<?, ?>) max.invoke(null, zero, one);
            assertEquals("max returns object with maximum value", one, result);
            result = (AbstractDoubleScalar<?, ?>) max.invoke(null, one, zero);
            assertEquals("max returns object with maximum value", one, result);
            /*-
            max = ClassUtil.resolveMethod(scalarClass,  "max", scalarClass, scalarClass, scalarClass);
            result = (AbstractDoubleScalar<?, ?>) max.invoke(null,  zero, biggest, one);
            assertEquals("max returns object with maximum value", biggest, result);
            */
            Method min = ClassUtil.resolveMethod(scalarClass, "min", scalarClass, scalarClass);
            result = (AbstractDoubleScalar<?, ?>) min.invoke(null, zero, one);
            assertEquals("min returns object with maximum value", zero, result);
            result = (AbstractDoubleScalar<?, ?>) min.invoke(null, one, zero);
            assertEquals("min returns object with maximum value", zero, result);
            if ((!scalarClass.getName().contains(".ElectricalResistance")) && (!scalarClass.getName().contains(".Money")))
            {
                Method valueOf = ClassUtil.resolveMethod(scalarClass, "valueOf", String.class);
                String string = zero.toString();
                result = (AbstractDoubleScalar<?, ?>) valueOf.invoke(null, string);
                assertEquals("valueOf toString returns a decent approximation of the input", zeroValue, result.getSI(), 0.001);
                try
                {
                    valueOf.invoke(null, (String) null);
                    fail("Null string in valueOf should have thrown an IllegalArgumentException (which may have been converted "
                            + "into an InvocationTargetException)");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
                try
                {
                    valueOf.invoke(null, "");
                    fail("Empty string in valueOf should have thrown an IllegalArgumentException");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
                try
                {
                    valueOf.invoke(null, "NONSENSEVALUE");
                    fail("Nonsense string in valueOf should have thrown an IllegalArgumentException");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
            }
            
            if (!scalarClass.getName().contains(".Money"))
            {
                Method createSI = ClassUtil.resolveMethod(scalarClass, "createSI", double.class);
                result = (AbstractDoubleScalar<?, ?>) createSI.invoke(null, zeroValue);
                assertEquals("SI value was correctly set", zeroValue, result.getSI(), 0.0001);
            }
        }
        else
        {
            float zeroValue = 1.23456f;
            AbstractFloatScalar<?,
                    ?> zero = abs
                            ? (AbstractFloatScalarAbs<?, ?, ?, ?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs))
                            : (AbstractFloatScalarRel<?, ?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            float oneValue = 3.45678f;
            AbstractFloatScalar<?,
                    ?> one = abs
                            ? (AbstractFloatScalarAbs<?, ?, ?, ?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs))
                            : (AbstractFloatScalarRel<?, ?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(scalarClass), abs));
            for (float ratio : new float[] { -5, -1, 0, 0.3f, 1, 2, 10 })
            {
                float expectedResult = (1.0f - ratio) * zeroValue + ratio * oneValue;
                Method interpolate = ClassUtil.resolveMethod(scalarClass, "interpolate", scalarClass, scalarClass, float.class);
                AbstractFloatScalar<?, ?> result;
                result = (AbstractFloatScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                assertEquals("Result of operation", expectedResult, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result),
                        0.01);
            }
            Method max = ClassUtil.resolveMethod(scalarClass, "max", scalarClass, scalarClass);
            AbstractFloatScalar<?, ?> result = (AbstractFloatScalar<?, ?>) max.invoke(null, zero, one);
            assertEquals("max return object with maximum value", one, result);
            result = (AbstractFloatScalar<?, ?>) max.invoke(null, one, zero);
            assertEquals("max return object with maximum value", one, result);
            Method min = ClassUtil.resolveMethod(scalarClass, "min", scalarClass, scalarClass);
            result = (AbstractFloatScalar<?, ?>) min.invoke(null, zero, one);
            assertEquals("min returns object with maximum value", zero, result);
            result = (AbstractFloatScalar<?, ?>) min.invoke(null, one, zero);
            assertEquals("min returns object with maximum value", zero, result);
            if ((!scalarClass.getName().contains(".FloatElectricalResistance"))
                    && (!scalarClass.getName().contains(".FloatMoney")))
            {
                Method valueOf = ClassUtil.resolveMethod(scalarClass, "valueOf", String.class);
                String string = zero.toString();
                result = (AbstractFloatScalar<?, ?>) valueOf.invoke(null, string);
                assertEquals("valueOf toString returns a decent approximation of the input", zeroValue, result.getSI(), 0.001);
                try
                {
                    valueOf.invoke(null, (String) null);
                    fail("Null string in valueOf should have thrown an IllegalArgumentException (which may have been converted "
                            + "into an InvocationTargetException)");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
                try
                {
                    valueOf.invoke(null, "");
                    fail("Empty string in valueOf should have thrown an IllegalArgumentException");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
                try
                {
                    valueOf.invoke(null, "NONSENSEVALUE");
                    fail("Nonsense string in valueOf should have thrown an IllegalArgumentException");
                }
                catch (IllegalArgumentException | InvocationTargetException iae)
                {
                    // Ignore expected exception
                }
            }
            if (!scalarClass.getName().contains(".FloatMoney"))
            {
                Method createSI = ClassUtil.resolveMethod(scalarClass, "createSI", float.class);
                result = (AbstractFloatScalar<?, ?>) createSI.invoke(null, zeroValue);
                assertEquals("SI value was correctly set", zeroValue, result.getSI(), 0.0001);
            }
        }
    }

}
