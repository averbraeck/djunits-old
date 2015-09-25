package org.djunits.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.Relative;
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
public class DoubleScalarOperationsTest
{
    /**
     * Test constructor on the interfaces that DOUBLE_SCALAR extends.
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    @SuppressWarnings("static-method")
    @Test
    public final void doubleScalarOperationsTest() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<?> ds = DOUBLE_SCALAR.class;
        // get an array of the DOUBLE_SCALAR$* classes
        for (Class<?> dsClass : ds.getClasses())
        {
            // get the interfaces such as org.djunits.value.vdouble.scalar.Area
            for (Class<?> scalarClass : dsClass.getInterfaces())
            {
                for (String subClassName : new String[] { "$Rel", "$Abs" })
                {

                    Class<?> scalarClassRel = null;
                    // get the subClassName implementation of that class
                    try
                    {
                        scalarClassRel = Class.forName(scalarClass.getName() + subClassName);
                    }
                    catch (ClassNotFoundException exception)
                    {
                        Assert.fail("Class Rel not found for DoubleScalar class " + scalarClass.getName());
                    }
                    // find the methods defined in the class itself (not in a superclass) called multiplyBy
                    for (Method method : scalarClassRel.getDeclaredMethods())
                    {
                        if (method.getName().equals("multiplyBy"))
                        {
                            // note: filter out the method that multiplies by a constant...
                            testMultiplyOrDivideMethodRel(scalarClassRel, subClassName.contains("Abs"), method, true);
                        }
                        else if (method.getName().equals("divideBy"))
                        {
                            testMultiplyOrDivideMethodRel(scalarClassRel, subClassName.contains("Abs"), method, false);
                        }
                    }
                    testUnaryMethods(scalarClassRel, subClassName.contains("Abs"));
                }
            }
        }
    }

    /**
     * Test a multiplication method for a Rel scalar. Note: filter out the method that multiplies by a constant...
     * @param scalarClass the Abs or Rel class for the multiplication, e.g. Length.Rel
     * @param abs boolean; true to test the Abs sub-class; false to test the Rel sub-class
     * @param method the method 'multiplyBy' for that class
     * @param multiply boolean; if true; test a multiplyBy method; if false; test a divideBy method
     */
    private void testMultiplyOrDivideMethodRel(final Class<?> scalarClass, boolean abs, final Method method, boolean multiply)
    {
        Class<?> relativeOrAbsoluteClass = null;
        try
        {
            relativeOrAbsoluteClass = Class.forName("org.djunits.value." + (abs ? "Absolute" : "Relative"));
        }
        catch (ClassNotFoundException exception)
        {
            Assert.fail("Could not find org.djunits.value.Relative class");
        }
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            Assert.fail("DoubleScalar class " + scalarClass.getName() + "." + method.getName() + "() has " + parTypes.length
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

        try
        {
            Constructor<?> constructor = scalarClass.getConstructor(double.class, getUnitClass(scalarClass));
            if (abs)
            {
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
        }
        catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Obtain the SI coefficient string of a DJUNITS class.
     * @param clas Class&lt;?&gt;; the DJUNITS class
     * @return String
     */
    private String getCoefficients(Class<?> clas)
    {
        if (clas.getName().contains("Money"))
        {
            try
            {
                // Just get the first one...
                Field[] fields = clas.getFields();
                if (0 == fields.length)
                {
                    return "1"; // Problem. No static instances of this class available
                }
                Field unitField = fields[0]; // Simply get the first one
                return ((Unit<?>) unitField.get(clas)).getSICoefficientsString();
            }
            catch (SecurityException | IllegalArgumentException | IllegalAccessException exception)
            {
                exception.printStackTrace();
            }
            return "1";
        }
        try
        {
            Field si = clas.getField("SI");
            Unit<?> u = ((Unit<?>) si.get(clas));
            String r = u.getSICoefficientsString();
            return r;
            // return ((Unit<?>) si.get(clas)).getSICoefficientsString();
        }
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException exception)
        {
            exception.printStackTrace();
            return "ERROR";
        }
    }

    /**
     * Obtain the SI coefficient string of a DJUNITS class.
     * @param clas Class&lt;?&gt;; the DJUNITS class
     * @return String
     */
    private Unit<?> getSIUnitInstance(Class<?> clas)
    {
        if (clas.getName().contains("Money"))
        {
            try
            {
                // Just get the first one...
                Field[] fields = clas.getFields();
                if (0 == fields.length)
                {
                    return null; // Problem. No static instances of this class available
                }
                Field unitField = fields[0]; // Simply get the first one
                return ((Unit<?>) unitField.get(clas));
            }
            catch (SecurityException | IllegalArgumentException | IllegalAccessException exception)
            {
                exception.printStackTrace();
            }
            return null;
        }
        try
        {
            Field si = clas.getField("SI");
            return ((Unit<?>) si.get(clas));
        }
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException exception)
        {
            exception.printStackTrace();
            return null;
        }
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
     * @param ds DoubleScalar&lt;?&gt;; the DoubleScalar
     * @return double; the SI value
     */
    private double verifyAbsRelAndExtractSI(boolean abs, Object o)
    {
        if (!(o instanceof DoubleScalar))
        {
            fail("ds is not a DoubleScalar");
        }
        DoubleScalar<?> ds = (DoubleScalar<?>) o;
        if (ds instanceof Absolute)
        {
            if (!abs)
            {
                fail("Result should have been Absolute");
            }
            return ((DoubleScalar.Abs<?>) ds).si;
        }
        else if (ds instanceof Relative)
        {
            if (abs)
            {
                fail("Result should have been Relative");
            }
            return ((DoubleScalar.Rel<?>) ds).si;
        }
        fail("Result is neither Absolute, nor Relative");
        return Double.NaN; // Not reached
    }

    /**
     * @param scalarClass
     * @param abs TODO
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void testUnaryMethods(final Class<?> scalarClass, boolean abs) throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        double value = 1.23456;
        Constructor<?> constructor = scalarClass.getConstructor(double.class, getUnitClass(scalarClass));
        DoubleScalar<?> left =
                abs ? (DoubleScalar.Abs<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(scalarClass)))
                        : (DoubleScalar.Rel<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(scalarClass)));
        Object result;

        Method methodAbs = scalarClass.getDeclaredMethod("abs", new Class[] {});
        result = methodAbs.invoke(left);
        assertEquals("Result of operation", Math.abs(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method asin = scalarClass.getDeclaredMethod("asin", new Class[] {});
        result = asin.invoke(left);
        assertEquals("Result of operation", Math.asin(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method acos = scalarClass.getDeclaredMethod("acos", new Class[] {});
        result = acos.invoke(left);
        assertEquals("Result of operation", Math.acos(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method atan = scalarClass.getDeclaredMethod("atan", new Class[] {});
        result = atan.invoke(left);
        assertEquals("Result of operation", Math.atan(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method cbrt = scalarClass.getDeclaredMethod("cbrt", new Class[] {});
        result = cbrt.invoke(left);
        assertEquals("Result of operation", Math.cbrt(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method ceil = scalarClass.getDeclaredMethod("ceil", new Class[] {});
        result = ceil.invoke(left);
        assertEquals("Result of operation", Math.ceil(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method cos = scalarClass.getDeclaredMethod("cos", new Class[] {});
        result = cos.invoke(left);
        assertEquals("Result of operation", Math.cos(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method cosh = scalarClass.getDeclaredMethod("cosh", new Class[] {});
        result = cosh.invoke(left);
        assertEquals("Result of operation", Math.cosh(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method exp = scalarClass.getDeclaredMethod("exp", new Class[] {});
        result = exp.invoke(left);
        assertEquals("Result of operation", Math.exp(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method expm1 = scalarClass.getDeclaredMethod("expm1", new Class[] {});
        result = expm1.invoke(left);
        assertEquals("Result of operation", Math.expm1(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method floor = scalarClass.getDeclaredMethod("floor", new Class[] {});
        result = floor.invoke(left);
        assertEquals("Result of operation", Math.floor(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method log = scalarClass.getDeclaredMethod("log", new Class[] {});
        result = log.invoke(left);
        assertEquals("Result of operation", Math.log(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method log10 = scalarClass.getDeclaredMethod("log10", new Class[] {});
        result = log10.invoke(left);
        assertEquals("Result of operation", Math.log10(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method log1p = scalarClass.getDeclaredMethod("log1p", new Class[] {});
        result = log1p.invoke(left);
        assertEquals("Result of operation", Math.log1p(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method rint = scalarClass.getDeclaredMethod("rint", new Class[] {});
        result = rint.invoke(left);
        assertEquals("Result of operation", Math.rint(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method round = scalarClass.getDeclaredMethod("round", new Class[] {});
        result = round.invoke(left);
        assertEquals("Result of operation", Math.round(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method signum = scalarClass.getDeclaredMethod("signum", new Class[] {});
        result = signum.invoke(left);
        assertEquals("Result of operation", Math.signum(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method sin = scalarClass.getDeclaredMethod("sin", new Class[] {});
        result = sin.invoke(left);
        assertEquals("Result of operation", Math.sin(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method sinh = scalarClass.getDeclaredMethod("sinh", new Class[] {});
        result = sinh.invoke(left);
        assertEquals("Result of operation", Math.sinh(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method sqrt = scalarClass.getDeclaredMethod("sqrt", new Class[] {});
        result = sqrt.invoke(left);
        assertEquals("Result of operation", Math.sqrt(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method tan = scalarClass.getDeclaredMethod("tan", new Class[] {});
        result = tan.invoke(left);
        assertEquals("Result of operation", Math.tan(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method tanh = scalarClass.getDeclaredMethod("tanh", new Class[] {});
        result = tanh.invoke(left);
        assertEquals("Result of operation", Math.tanh(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method inv = scalarClass.getDeclaredMethod("inv", new Class[] {});
        result = inv.invoke(left);
        assertEquals("Result of operation", 1 / value, verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method toDegrees = scalarClass.getDeclaredMethod("toDegrees", new Class[] {});
        result = toDegrees.invoke(left);
        assertEquals("Result of operation", Math.toDegrees(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method toRadians = scalarClass.getDeclaredMethod("toRadians", new Class[] {});
        result = toRadians.invoke(left);
        assertEquals("Result of operation", Math.toRadians(value), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method pow = scalarClass.getDeclaredMethod("pow", new Class[] { double.class });
        result = pow.invoke(left, Math.PI);
        assertEquals("Result of operation", Math.pow(value, Math.PI), verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method multiplyBy = scalarClass.getDeclaredMethod("multiplyBy", new Class[] { double.class });
        result = multiplyBy.invoke(left, Math.PI);
        assertEquals("Result of operation", Math.PI * value, verifyAbsRelAndExtractSI(abs, result), 0.01);

        Method divideBy = scalarClass.getDeclaredMethod("divideBy", new Class[] { double.class });
        result = divideBy.invoke(left, Math.PI);
        assertEquals("Result of operation", value / Math.PI, verifyAbsRelAndExtractSI(abs, result), 0.01);

        if (!abs)
        {
            Method plus = scalarClass.getDeclaredMethod("plus", new Class[] { scalarClass });
            result = plus.invoke(left, left);
            assertEquals("Result of operation", value + value, verifyAbsRelAndExtractSI(abs, result), 0.01);
        }

        Method minus = scalarClass.getDeclaredMethod("minus", new Class[] { scalarClass });
        result = minus.invoke(left, left);
        assertEquals("Result of operation", 0, verifyAbsRelAndExtractSI(false, result), 0.01);

    }

}
