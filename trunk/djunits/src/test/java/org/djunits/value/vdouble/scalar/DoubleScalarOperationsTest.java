package org.djunits.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits.unit.Unit;
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
    public final void doubleScalarOperationsTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<?> ds = DOUBLE_SCALAR.class;
        // get an array of the DOUBLE_SCALAR$* classes
        for (Class<?> dsClass : ds.getClasses())
        {
            // get the interfaces such as org.djunits.value.vdouble.scalar.Area
            for (Class<?> scalarClass : dsClass.getInterfaces())
            {
                Class<?> scalarClassRel = null;
                // get the Rel implementation of that class
                try
                {
                    scalarClassRel = Class.forName(scalarClass.getName() + "$Rel");
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
                        testMultiplyOrDivideMethodRel(scalarClassRel, method, true);
                    }
                    else if (method.getName().equals("divideBy"))
                    {
                        testMultiplyOrDivideMethodRel(scalarClassRel, method, false);
                    }
                }
                textUnaryMethods(scalarClassRel);
            }
        }
    }

    /**
     * Test a multiplication method for a Rel scalar. Note: filter out the method that multiplies by a constant...
     * @param scalarClassRel the Rel class for the multiplication, e.g. Length.Rel
     * @param method the method 'multiplyBy' for that class
     * @param multiply boolean; if true; test a multiplyBy method; if false; test a divideBy method
     */
    private void testMultiplyOrDivideMethodRel(final Class<?> scalarClassRel, final Method method, boolean multiply)
    {
        Class<?> relativeClass = null;
        try
        {
            relativeClass = Class.forName("org.djunits.value.Relative");
        }
        catch (ClassNotFoundException exception)
        {
            Assert.fail("Could not find org.djunits.value.Relative class");
        }
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName() + ".multiplyBy() has " + parTypes.length
                    + " parameters, <> 1");
        }
        Class<?> parameterClass = parTypes[0];
        if (parameterClass.toString().equals("double"))
        {
            // not interested in multiplying a scalar with a double.
            return;
        }
        if (!relativeClass.isAssignableFrom(parameterClass))
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName()
                    + ".multiplyBy() has parameter with non-relative class: " + relativeClass.getName());
        }

        Class<?> returnClass = method.getReturnType();
        if (!relativeClass.isAssignableFrom(returnClass))
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName()
                    + ".multiplyBy() has return type with non-relative class: " + returnClass.getName());
        }

        // get the SI coefficients of the unit classes, scalar type, parameter type and return type
        String returnSI = getCoefficients(getUnitClass(returnClass));
        String scalarSI = getCoefficients(getUnitClass(scalarClassRel));
        String paramSI = getCoefficients(getUnitClass(parameterClass));
        // print what we just have found
        System.out.println(scalarClassRel.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + "."
                + (multiply ? "multiplyBy" : "divideBy") + "("
                + parameterClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ") => "
                + returnClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ": " + scalarSI
                + (multiply ? " * " : " : ") + paramSI + " => " + returnSI);
        
        try
        {
            Constructor<?> constructor = scalarClassRel.getConstructor(double.class, getUnitClass(scalarClassRel));
            DoubleScalar.Rel<?> left =
                    (DoubleScalar.Rel<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(scalarClassRel)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            DoubleScalar.Rel<?> right =
                    (DoubleScalar.Rel<?>) constructor.newInstance(456d, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            double expectedValue = multiply ? 123d * 456 : 123d / 456;

            if (multiply)
            {
                Method multiplyMethod = scalarClassRel.getDeclaredMethod("multiplyBy", new Class[]{parameterClass});
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Rel<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = scalarClassRel.getDeclaredMethod("divideBy", new Class[]{parameterClass});
                Object result = divideMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Rel<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            DoubleScalar.Rel<?> result = multiply ? DoubleScalar.multiply(left, right) : DoubleScalar.divide(left, right);
            // System.out.println("result is " + result);
            String resultCoefficients = result.getUnit().getSICoefficientsString();
            assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
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
     * 
     * @param scalarClassRel
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void textUnaryMethods(final Class<?> scalarClassRel) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Constructor<?> constructor = scalarClassRel.getConstructor(double.class, getUnitClass(scalarClassRel));
        DoubleScalar.Rel<?> left =
                (DoubleScalar.Rel<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(scalarClassRel)));
        
        Method asin = scalarClassRel.getDeclaredMethod("asin", new Class[]{});
        Object result = asin.invoke(left);
        double resultSI = ((DoubleScalar.Rel<?>) result).si;
        assertEquals("Result of operation", Math.asin(123), resultSI, 0.01);
        
        Method acos = scalarClassRel.getDeclaredMethod("acos", new Class[]{});
        result = acos.invoke(left);
        resultSI = ((DoubleScalar.Rel<?>) result).si;
        assertEquals("Result of operation", Math.acos(123), resultSI, 0.01);
        
    }
    
}
