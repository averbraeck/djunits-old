package org.djunits.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.djunits.unit.Unit;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.vector.DoubleVector;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.djunits.value.vfloat.vector.FloatVector;
import org.junit.Assert;
import org.junit.Test;

/**
 * Find all plus, minus, multiplyBy and divideBy operations and prove the type correctness.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-10-04 13:58:23 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 84 $, by $Author: averbraeck $, initial
 * version Sep 14, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class VectorOperationsTest
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
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws ValueException
     */
    @SuppressWarnings("static-method")
    @Test
    public final void scalarOperationsTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, SecurityException, IllegalArgumentException,
            ClassNotFoundException, ValueException
    {
        doubleOrFloatScalarOperationsTest(true); // Double precision versions
        // TODO doubleOrFloatScalarOperationsTest(false); // Float versions
    }

    /**
     * Perform many tests on scalar types.
     * @param doubleType boolean; if true; perform tests on DoubleScalar types; if false; perform tests on FloatScalar types
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws ValueException
     */
    private void doubleOrFloatScalarOperationsTest(final boolean doubleType) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, ClassNotFoundException, ValueException
    {
        final String upperType = doubleType ? "Vector" : "FloatVector";
        String doubleOrFloat = doubleType ? "double" : "float";
        // get the interfaces such as org.djunits.value.vdouble.scalar.Time
        for (String vectorName : CLASSNAMES_ABSREL)
        {
            for (String subClassName : new String[] { "$Rel", "$Abs" })
            {
                boolean isAbs = subClassName.contains("Abs");
                Class<?> vectorClassAbsRel = null;
                // get the subClassName implementation of that class
                String className = "org.djunits.value.v" + doubleOrFloat + ".vector." + vectorName + upperType + subClassName;
                // System.out.println("Looking up class " + className);
                vectorClassAbsRel = Class.forName(className);
                testMethods(vectorClassAbsRel, isAbs, doubleType);
                testAbsRelConversion(vectorClassAbsRel, isAbs, doubleType, StorageType.DENSE);
                testAbsRelConversion(vectorClassAbsRel, isAbs, doubleType, StorageType.SPARSE);
            }
        }

        // get the interfaces such as org.djunits.value.vXXXX.scalar.Area
        for (String vectorName : CLASSNAMES_REL)
        {
            String vectorClassName = doubleType ? vectorName : "FloatVector" + vectorName;
            String fullClassName = "org.djunits.value.v" + doubleOrFloat + ".vector." + vectorClassName + "Vector";
            Class<?> vectorClassRel = null;
            try
            {
                vectorClassRel = Class.forName(fullClassName);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class not found for " + vectorClassName);
            }
            testMethods(vectorClassRel, false, doubleType);
        }

        // get the interfaces such as org.djunits.value.vXXXX.scalar.MoneyPerArea
        for (String vectorName : CLASSNAMES_MONEY)
        {
            String vectorClassName = doubleType ? vectorName : "Float" + vectorName;
            String fullClassName = "org.djunits.value.v" + doubleOrFloat + ".vector." + vectorClassName + "Vector";
            Class<?> scalarClassMoney = null;
            try
            {
                scalarClassMoney = Class.forName(fullClassName);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class not found for " + fullClassName);
            }
            testMethods(scalarClassMoney, false, doubleType);
        }
    }

    /**
     * Test the toAbs or toRel method.
     * @param vectorClassAbsRel class to test
     * @param isAbs boolean; if true; the scalarClassAbsRel must be aAsolute; if false; the scalarClassAbsRel must be Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false perform tests on FloatScalar
     * @param storageType StorageType; DENSE or SPARSE
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws NoSuchFieldException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ValueException
     */
    private void testAbsRelConversion(final Class<?> vectorClassAbsRel, boolean isAbs, boolean doubleType,
            StorageType storageType) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, ValueException
    {
        double[] doubleInValue = { 1.23456, 2.34567, 3.45678 };
        float[] floatInValue = { 1.23456f, 2.34567f, 3.45678f };
        Object inValue = doubleType ? doubleInValue : floatInValue;
        // System.out.println("Looking for constructor of " + vectorClassAbsRel.getName());
        Constructor<?> constructor =
                vectorClassAbsRel.getConstructor(doubleType ? double[].class : float[].class, getUnitClass(vectorClassAbsRel),
                        StorageType.class);
        Object from;
        if (doubleType)
        {
            from =
                    isAbs ? (DoubleVector.Abs<?>) constructor.newInstance(inValue,
                            getSIUnitInstance(getUnitClass(vectorClassAbsRel)), storageType)
                            : (DoubleVector.Rel<?>) constructor.newInstance(inValue,
                                    getSIUnitInstance(getUnitClass(vectorClassAbsRel)), storageType);
        }
        else
        {
            from =
                    isAbs ? (FloatVector.Abs<?>) constructor.newInstance((float) inValue,
                            getSIUnitInstance(getUnitClass(vectorClassAbsRel)), storageType) : (FloatVector.Rel<?>) constructor
                            .newInstance((float) inValue, getSIUnitInstance(getUnitClass(vectorClassAbsRel)), storageType);
        }
        // testje
        // AnglePlaneVector.Rel.Dense apvrd = new AnglePlaneVector.Rel.Dense(new double[] { 0.1, 2.3 },
        // AnglePlaneUnit.ARCSECOND);
        // apvrd.toAbs();

        // System.out.println("Looking for method " + (isAbs ? "toRel" : "toAbs"));
        Method method = vectorClassAbsRel.getMethod(isAbs ? "toRel" : "toAbs");
        Object result = method.invoke(from);
        verifyAbsRelPrecisionAndValues(!isAbs, doubleType, result, doubleType ? doubleInValue : floatInValue, 0.000001);
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
     * @throws ClassNotFoundException
     * @throws ValueException
     */
    private void testMethods(final Class<?> scalarClassAbsRel, final boolean isAbs, final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, ClassNotFoundException, ValueException
    {
        for (Method method : scalarClassAbsRel.getDeclaredMethods())
        {
            // System.out.println("Method name is " + method.getName());
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
        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (boolean mutable : new boolean[] { true, false })
            {
                testConstructors(scalarClassAbsRel, isAbs, doubleType, mutable, storageType);
                testGet(scalarClassAbsRel, isAbs, doubleType, mutable, storageType);
                testUnaryMethods(scalarClassAbsRel, isAbs, doubleType, mutable, storageType);
            }
            testInterpolateMethod(scalarClassAbsRel, isAbs, doubleType, storageType);
        }
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
     * @throws ClassNotFoundException
     */
    private void testMultiplyOrDivideMethodAbsRel(final Class<?> scalarClass, final boolean abs, final Method method,
            final boolean multiply, final boolean doubleType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException
    {
        Class<?> relativeOrAbsoluteClass = null;
        relativeOrAbsoluteClass = Class.forName("org.djunits.value." + (abs ? "Absolute" : "Relative"));
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
     * @param vectorClass the class to find the unit for
     * @return the unit class for this scalar class
     */
    private Class<?> getUnitClass(final Class<?> vectorClass)
    {
        Constructor<?>[] constructors = vectorClass.getConstructors();
        for (Constructor<?> constructor : constructors)
        {
            Class<?>[] parTypes = constructor.getParameterTypes();
            // System.out.print("Found constructor " + vectorClass + "(");
            // String separator = "";
            // for (Class<?> parType : parTypes)
            // {
            // System.out.print(separator + parType);
            // separator = ", ";
            // }
            // System.out.println(")");
            if (parTypes.length >= 2 && Unit.class.isAssignableFrom(parTypes[1]))
            {
                return parTypes[1];
            }
        }
        Assert.fail("Could not find constructor with a unit as 2nd argument for Vector class " + vectorClass.getName());
        return null;
    }

    /**
     * Verify the Absoluteness, Relativeness, and SI values of a DoubleVector or FloatVector.
     * @param abs boolean; expected Absolute- or Relative-ness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param got the (DoubleVector?) object
     * @param expected double[] or float[] with expected values
     * @param precision double; maximum error of the results
     * @throws ValueException
     */
    private void verifyAbsRelPrecisionAndValues(final boolean abs, final boolean doubleType, final Object got,
            final Object expected, double precision) throws ValueException
    {
        int size = doubleType ? ((double[]) expected).length : ((float[]) expected).length;
        int refSize = doubleType ? ((double[]) expected).length : ((float[]) expected).length;
        assertEquals("size of resulting array", refSize, size);
        for (int i = 0; i < size; i++)
        {
            double result = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, got, i);
            assertEquals("value check", doubleType ? ((double[]) expected)[i] : ((float[]) expected)[i], result, precision);
        }
    }

    /**
     * Verify the Absoluteness or Relativeness of a DoubleScalar and return the SI value.
     * @param abs boolean; expected Absolute- or Relativeness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param o the (DoubleScalar?) object
     * @param index int; the index of the value to return
     * @return double; the SI value
     * @throws ValueException
     */
    private double verifyAbsRelPrecisionAndExtractSI(final boolean abs, final boolean doubleType, final Object o, int index)
            throws ValueException
    {
        double result = Double.NaN;
        if (doubleType)
        {
            if (!(o instanceof DoubleVector))
            {
                fail("object is not a DoubleVector");
            }
            result = ((DoubleVector<?>) o).getSI(index);
        }
        else
        {
            if (!(o instanceof FloatVector))
            {
                fail("object is not a FloatVector");
            }
            result = ((FloatVector<?>) o).getSI(index);
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
     * @param vectorClass the class to test
     * @param abs boolean; if true; the absolute version is tested; if false; the relative version is tested
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param mutable boolean; if true; perform test for mutable version; if false; perform test for non-mutable version
     * @param storageType StorageType; Dense or Sparse
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException
     * @throws ValueException
     */
    private void testConstructors(final Class<?> vectorClass, final boolean abs, final boolean doubleType, boolean mutable,
            StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = { 1.23456, 2.34567, 3.45678 };
        float[] floatValue = { 1.23456f, 2.34567f, 3.45678f };
        Object value = doubleType ? doubleValue : floatValue;
        findAndTestConstructor(vectorClass, new Object[] { value, getSIUnitInstance(getUnitClass(vectorClass)), storageType },
                abs, doubleType, value);
        if (doubleType)
        {
            List<Double> list = new ArrayList<Double>();
            for (int i = 0; i < doubleValue.length; i++)
            {
                list.add(doubleValue[i]);
            }
            findAndTestConstructor(vectorClass,
                    new Object[] { list, getSIUnitInstance(getUnitClass(vectorClass)), storageType }, abs, doubleType, value);
            // Construct a list of scalar objects
            // What is the corresponding Scalar type?
            String scalarClassName = vectorClass.getName();
            // System.out.println("name is " + scalarClassName);
            scalarClassName = scalarClassName.replaceFirst("Vector", "");
            // System.out.println("name is " + scalarClassName);
            scalarClassName = scalarClassName.replaceFirst("vector", "scalar");
            // System.out.println("name is " + scalarClassName);
            Class<?> scalarClassAbsRel = Class.forName(scalarClassName);
            // System.out.println("class is " + scalarClassAbsRel);
            Constructor<?> constructor =
                    scalarClassAbsRel.getConstructor(new Class<?>[] { double.class, getUnitClass(vectorClass) });
            List<Object> objectList = new ArrayList<Object>();
            for (Double d : list)
            {
                objectList.add(constructor.newInstance(d, getSIUnitInstance(getUnitClass(vectorClass))));
            }
            findAndTestConstructor(vectorClass, new Object[] { objectList, storageType }, abs, doubleType, value);
            // Construct an array of the correct scalar objects
            Object[] objectArray = (Object[]) Array.newInstance(scalarClassAbsRel, objectList.size());
            for (int i = 0; i < objectList.size(); i++)
            {
                objectArray[i] = objectList.get(i);
            }
            findAndTestConstructor(vectorClass, new Object[] { objectArray, storageType }, abs, doubleType, value);
            SortedMap<Integer, Object> map = new TreeMap<Integer, Object>();
            for (int i = 0; i < objectList.size(); i++)
            {
                map.put(i, objectList.get(i));
            }
            // System.out.println("int is assignable from Integer ? " + int.class.isAssignableFrom(Integer.class));
            findAndTestConstructor(vectorClass, new Object[] { map, objectList.size(), storageType }, abs, doubleType, value);
            map.clear();
            for (int i = 0; i < doubleValue.length; i++)
            {
                map.put(i, doubleValue[i]);
            }
            findAndTestConstructor(vectorClass, new Object[] { map, getSIUnitInstance(getUnitClass(vectorClass)),
                    doubleValue.length, storageType }, abs, doubleType, value);
        }
        else
        {
            List<Float> list = new ArrayList<Float>();
            for (int i = 0; i < floatValue.length; i++)
            {
                list.add(floatValue[i]);
            }
            findAndTestConstructor(vectorClass,
                    new Object[] { list, getSIUnitInstance(getUnitClass(vectorClass)), storageType }, abs, doubleType, value);
            // TODO add and convert all other stuff from the Float version
        }
    }

    /**
     * Return a String with detailed information about a Constructor.
     * @param constructor Constructor&lt;?&gt;; the Constructor
     * @return String
     */
    private String constructorToString(Constructor<?> constructor)
    {
        StringBuilder result = new StringBuilder();
        String separator = "(";
        for (Class<?> parType : constructor.getParameterTypes())
        {
            result.append(separator + parType);
            separator = ", ";
        }
        result.append(")");
        return result.toString();
    }

    /**
     * Find and execute a constructor and return the result.
     * @param vectorClass Class&lt;?&gt;; the class to which the constructor belongs
     * @param args Object[]; arguments to provide to the constructor
     * @param abs boolean; if true; the result of the constructor is expected to be Absolute; if false; the result of the
     *            constructor is expected to be relative
     * @param doubleType boolean; if true; the args argument is array of double; of false; the args argument is array of float
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ValueException
     */
    private Object findAndExecuteConstructor(final Class<?> vectorClass, final Object[] args, final boolean abs,
            final boolean doubleType) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, ValueException
    {
        Class<?>[] parameterTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++)
        {
            Class<?> c = args[i].getClass();
            if (c.isAssignableFrom(double[].class))
            {
                c = double[].class;
            }
            else if (c.isAssignableFrom(float[].class))
            {
                c = float[].class;
            }
            parameterTypes[i] = c;
            // System.out.println("parameter type[" + i + "] is " + c);
        }
        Constructor<?> constructor = null;
        for (Constructor<?> c : vectorClass.getConstructors())
        {
            // System.out.print("Found constructor for " + vectorClass + " " + constructorToString(c));
            Class<?>[] parTypes = c.getParameterTypes();
            boolean compatible = parTypes.length == args.length;
            for (int i = 0; i < parTypes.length; i++)
            {
                Class<?> parType = parTypes[i];
                if (compatible && !parType.isAssignableFrom(parameterTypes[i])
                        && (!(parType == int.class && parameterTypes[i] == Integer.class)))
                {
                    compatible = false;
                }
            }
            if (compatible)
            {
                // System.out.println(" MATCH");
                constructor = c;
            }
            else
            {
                // System.out.println("");
            }
        }
        // Constructor<?> constructor = vectorClass.getConstructor(parameterTypes);
        if (null == constructor)
        {
            // System.out.println("No suitable constructor");
            fail("Cannot find suitable constructor");
        }
        return constructor.newInstance(args);
    }

    /**
     * Find and execute a constructor and check the result.
     * @param vectorClass Class&lt;?&gt;; the class to which the constructor belongs
     * @param args Object[]; arguments to provide to the constructor
     * @param abs boolean; if true; the result of the constructor is expected to be Absolute; if false; the result of the
     *            constructor is expected to be relative
     * @param doubleType boolean; if true; the args argument is array of double; of false; the args argument is array of float
     * @param expectedResult Object; either array of double, or array of float
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ValueException
     */
    private void findAndTestConstructor(final Class<?> vectorClass, final Object[] args, final boolean abs,
            final boolean doubleType, final Object expectedResult) throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ValueException
    {
        verifyAbsRelPrecisionAndValues(abs, doubleType, findAndExecuteConstructor(vectorClass, args, abs, doubleType),
                expectedResult, 0.0001);
    }

    /**
     * Test the get method.
     * @param vectorClass the class to test
     * @param abs boolean; if true; the absolute version is tested; if false; the relative version is tested
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param mutable boolean; if true; perform test for mutable version; if false; perform test for non-mutable version
     * @param storageType StorageType; Dense or Sparse
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException
     * @throws ValueException
     */
    private void testGet(final Class<?> vectorClass, final boolean abs, final boolean doubleType, boolean mutable,
            StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = { 1.23456, 2.34567, 3.45678 };
        float[] floatValue = { 1.23456f, 2.34567f, 3.45678f };
        Object value = doubleType ? doubleValue : floatValue;
        Object vector =
                findAndExecuteConstructor(vectorClass, new Object[] { value, getSIUnitInstance(getUnitClass(vectorClass)),
                        storageType }, abs, doubleType);
        if (doubleType)
        {
            DoubleVector<?> dv = (DoubleVector<?>) vector;
            for (int i = 0; i < doubleValue.length; i++)
            {
                DoubleScalar<?> ds = dv.get(i);
                double got = ds.getSI();
                assertEquals("get returns expected value", doubleValue[i], got, 0.0001);
            }
        }
        else
        {
            FloatVector<?> fv = (FloatVector<?>) vector;
            for (int i = 0; i < doubleValue.length; i++)
            {
                FloatScalar<?> fs = fv.get(i);
                float got = fs.getSI();
                assertEquals("get returns expected value", doubleValue[i], got, 0.0001);
            }
        }
    }

    /**
     * @param vectorClass the class to test
     * @param abs abs or rel class
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param mutable boolean; if true; perform test for mutable version; if false; perform test for non-mutable version
     * @param storageType StorageType; Dense or Sparse
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException
     * @throws ValueException
     */
    private void testUnaryMethods(final Class<?> vectorClass, final boolean abs, final boolean doubleType, boolean mutable,
            StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = { 1.23456, 2.34567, 3.45678 };
        float[] floatValue = { 1.23456f, 2.34567f, 3.45678f };
        Object value = doubleType ? doubleValue : floatValue;
        Constructor<?> constructor =
                vectorClass.getConstructor(doubleType ? double[].class : float[].class, getUnitClass(vectorClass),
                        StorageType.class);
        Object left;
        if (doubleType)
        {
            left =
                    abs ? (DoubleVector.Abs<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(vectorClass)),
                            storageType) : (DoubleVector.Rel<?>) constructor.newInstance(value,
                            getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            // System.out.println("Constructed object of type " + vectorClass + ": " + left.toString());
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = vectorClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                // System.out.println("Constructor name is " + c.getName() + " parameters " + c.getParameterTypes());
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1 && parTypes[0] == vectorClass)
                {
                    DoubleVector<?> newInstance = (DoubleVector<?>) c.newInstance(left);
                    verifyAbsRelPrecisionAndValues(abs, doubleType, newInstance, value, 0.01);
                }
            }
        }
        else
        {
            left =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(vectorClass)))
                            : (FloatScalar.Rel<?>) constructor.newInstance(value, getSIUnitInstance(getUnitClass(vectorClass)),
                                    storageType);
            // Find the constructor that takes an object of the current class as the single argument
            Constructor<?>[] constructors = vectorClass.getConstructors();
            for (Constructor<?> c : constructors)
            {
                Class<?>[] parTypes = c.getParameterTypes();
                if (parTypes.length == 1)
                {
                    // System.out.println("parType is " + parTypes[0]);
                    FloatScalar<?> newInstance = (FloatScalar<?>) c.newInstance(left);
                    verifyAbsRelPrecisionAndValues(abs, doubleType, newInstance, value, 0.01);
                }
            }
        }
        Object result;

        /*-
        if (mutable)
        {
            Method methodAbs = vectorClass.getDeclaredMethod("abs", new Class[] {});
            result = methodAbs.invoke(left);
            assertEquals("Result of operation", Math.abs(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method asin = vectorClass.getDeclaredMethod("asin", new Class[] {});
            result = asin.invoke(left);
            assertEquals("Result of operation", Math.asin(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method acos = vectorClass.getDeclaredMethod("acos", new Class[] {});
            result = acos.invoke(left);
            assertEquals("Result of operation", Math.acos(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method atan = vectorClass.getDeclaredMethod("atan", new Class[] {});
            result = atan.invoke(left);
            assertEquals("Result of operation", Math.atan(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method cbrt = vectorClass.getDeclaredMethod("cbrt", new Class[] {});
            result = cbrt.invoke(left);
            assertEquals("Result of operation", Math.cbrt(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method ceil = vectorClass.getDeclaredMethod("ceil", new Class[] {});
            result = ceil.invoke(left);
            assertEquals("Result of operation", Math.ceil(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method cos = vectorClass.getDeclaredMethod("cos", new Class[] {});
            result = cos.invoke(left);
            assertEquals("Result of operation", Math.cos(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method cosh = vectorClass.getDeclaredMethod("cosh", new Class[] {});
            result = cosh.invoke(left);
            assertEquals("Result of operation", Math.cosh(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method exp = vectorClass.getDeclaredMethod("exp", new Class[] {});
            result = exp.invoke(left);
            assertEquals("Result of operation", Math.exp(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method expm1 = vectorClass.getDeclaredMethod("expm1", new Class[] {});
            result = expm1.invoke(left);
            assertEquals("Result of operation", Math.expm1(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method floor = vectorClass.getDeclaredMethod("floor", new Class[] {});
            result = floor.invoke(left);
            assertEquals("Result of operation", Math.floor(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method log = vectorClass.getDeclaredMethod("log", new Class[] {});
            result = log.invoke(left);
            assertEquals("Result of operation", Math.log(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method log10 = vectorClass.getDeclaredMethod("log10", new Class[] {});
            result = log10.invoke(left);
            assertEquals("Result of operation", Math.log10(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method log1p = vectorClass.getDeclaredMethod("log1p", new Class[] {});
            result = log1p.invoke(left);
            assertEquals("Result of operation", Math.log1p(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method rint = vectorClass.getDeclaredMethod("rint", new Class[] {});
            result = rint.invoke(left);
            assertEquals("Result of operation", Math.rint(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method round = vectorClass.getDeclaredMethod("round", new Class[] {});
            result = round.invoke(left);
            assertEquals("Result of operation", Math.round(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method signum = vectorClass.getDeclaredMethod("signum", new Class[] {});
            result = signum.invoke(left);
            assertEquals("Result of operation", Math.signum(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method sin = vectorClass.getDeclaredMethod("sin", new Class[] {});
            result = sin.invoke(left);
            assertEquals("Result of operation", Math.sin(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method sinh = vectorClass.getDeclaredMethod("sinh", new Class[] {});
            result = sinh.invoke(left);
            assertEquals("Result of operation", Math.sinh(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method sqrt = vectorClass.getDeclaredMethod("sqrt", new Class[] {});
            result = sqrt.invoke(left);
            assertEquals("Result of operation", Math.sqrt(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method tan = vectorClass.getDeclaredMethod("tan", new Class[] {});
            result = tan.invoke(left);
            assertEquals("Result of operation", Math.tan(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method tanh = vectorClass.getDeclaredMethod("tanh", new Class[] {});
            result = tanh.invoke(left);
            assertEquals("Result of operation", Math.tanh(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method inv = vectorClass.getDeclaredMethod("inv", new Class[] {});
            result = inv.invoke(left);
            assertEquals("Result of operation", 1 / value, verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX),
                    0.01);

            Method toDegrees = vectorClass.getDeclaredMethod("toDegrees", new Class[] {});
            result = toDegrees.invoke(left);
            assertEquals("Result of operation", Math.toDegrees(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method toRadians = vectorClass.getDeclaredMethod("toRadians", new Class[] {});
            result = toRadians.invoke(left);
            assertEquals("Result of operation", Math.toRadians(value),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Method pow = vectorClass.getDeclaredMethod("pow", new Class[] { double.class });
            result = pow.invoke(left, Math.PI);
            assertEquals("Result of operation", Math.pow(value, Math.PI),
                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

            Object compatibleRight = null;
            if (!vectorClass.getName().contains("Money") && !vectorClass.getName().contains("Dimensionless")
                    && !vectorClass.getName().contains("Temperature"))
            {
                // Construct a new unit to test mixed unit plus and minus
                Class<?> unitClass = getUnitClass(vectorClass);
                UnitSystem unitSystem = UnitSystem.SI_DERIVED;
                Unit<?> referenceUnit;
                // Call the getUnit method of left
                Method getUnitMethod = vectorClass.getMethod("getUnit");
                referenceUnit = (Unit<?>) getUnitMethod.invoke(left);
                Constructor<?> unitConstructor =
                        unitClass.getConstructor(String.class, String.class, UnitSystem.class, unitClass, double.class);
                Object newUnit = unitConstructor.newInstance("7fullName", "7abbr", unitSystem, referenceUnit, 7d);
                System.out.println("new unit prints like " + newUnit);
                if (doubleType)
                {
                    compatibleRight =
                            abs ? (DoubleScalar.Abs<?>) constructor.newInstance(value, newUnit)
                                    : (DoubleScalar.Rel<?>) constructor.newInstance(value, newUnit);
                }
                else
                {
                    compatibleRight =
                            abs ? (FloatScalar.Abs<?>) constructor.newInstance((float) value, newUnit)
                                    : (FloatScalar.Rel<?>) constructor.newInstance((float) value, newUnit);
                }
                // System.out.println("compatibleRight prints like \"" + compatibleRight + "\"");
            }
            if (!abs)
            {
                Method multiplyBy = vectorClass.getDeclaredMethod("multiplyBy", new Class[] { double.class });
                result = multiplyBy.invoke(left, Math.PI);
                assertEquals("Result of operation", Math.PI * value,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

                Method divideBy = vectorClass.getDeclaredMethod("divideBy", new Class[] { double.class });
                result = divideBy.invoke(left, Math.PI);
                assertEquals("Result of operation", value / Math.PI,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

                Method plus = vectorClass.getDeclaredMethod("plus", new Class[] { vectorClass });
                result = plus.invoke(left, left);
                assertEquals("Result of operation", value + value,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);

                if (null != compatibleRight)
                {
                    result = plus.invoke(left, compatibleRight);
                    assertEquals("Result of mixed operation", 8 * value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);
                    // Swap the operands
                    System.out.println("finding plus method for " + compatibleRight.getClass().getName() + " left type is "
                            + left.getClass().getName());
                    plus = vectorClass.getDeclaredMethod("plus", new Class[] { compatibleRight.getClass() });
                    result = plus.invoke(compatibleRight, left);
                    assertEquals("Result of mixed operation", 8 * value,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, result, XXXX), 0.01);
                    if (vectorClass.getName().contains("$Rel"))
                    {
                        // Make an Absolute for one operand
                        String absScalarClassName = vectorClass.getName().replace("$Rel", "$Abs");
                        Class<?> absScalarClass = Class.forName(absScalarClassName);
                        Constructor<?> absScalarConstructor =
                                absScalarClass.getConstructor(doubleType ? double.class : float.class,
                                        getUnitClass(absScalarClass));
                        Object absOperand = null;
                        System.out.println("unit is " + getUnitClass(absScalarClass));
                        if (doubleType)
                        {
                            absOperand =
                                    absScalarConstructor.newInstance(value, getSIUnitInstance(getUnitClass(absScalarClass)));
                        }
                        else
                        {
                            absOperand =
                                    absScalarConstructor.newInstance((float) value,
                                            getSIUnitInstance(getUnitClass(absScalarClass)));
                        }
                        // abs plus rel yields abs
                        plus = absScalarClass.getDeclaredMethod("plus", vectorClass);
                        result = plus.invoke(absOperand, left);
                        assertEquals("Result of mixed abs + rel", 2 * value,
                                verifyAbsRelPrecisionAndExtractSI(true, doubleType, result, XXXX), 0.01);
                        Method toAbs = compatibleRight.getClass().getDeclaredMethod("toAbs");
                        Object absCompatible = toAbs.invoke(compatibleRight);
                        result = plus.invoke(absCompatible, left);
                        assertEquals("Result of mixed compatible abs + rel", 8 * value,
                                verifyAbsRelPrecisionAndExtractSI(true, doubleType, result, XXXX), 0.01);
                        // rel plus abs yields abs
                        plus = vectorClass.getDeclaredMethod("plus", absScalarClass);
                        result = plus.invoke(left, absOperand);
                        assertEquals("Result of mixed rel + abs", 2 * value,
                                verifyAbsRelPrecisionAndExtractSI(true, doubleType, result, XXXX), 0.01);
                        result = plus.invoke(left, absCompatible);
                        assertEquals("Result of mixed rel + compatible abs", 8 * value,
                                verifyAbsRelPrecisionAndExtractSI(true, doubleType, result, XXXX), 0.01);
                    }
                }
            }
            Method minus = vectorClass.getDeclaredMethod("minus", new Class[] { vectorClass });
            result = minus.invoke(left, left);
            assertEquals("Result of minus", 0, verifyAbsRelPrecisionAndExtractSI(false, doubleType, result, XXXX), 0.01);
            if (null != compatibleRight)
            {
                result = minus.invoke(left, compatibleRight);
                assertEquals("Result of minus with compatible arg", -6 * value,
                        verifyAbsRelPrecisionAndExtractSI(false, doubleType, result, XXXX), 0.01);
            }
            if (vectorClass.getName().contains("$Rel") || vectorClass.getName().contains("$Abs"))
            {
                // Make an Absolute for one operand
                String absScalarClassName = vectorClass.getName().replace("$Rel", "$Abs");
                Class<?> absScalarClass = Class.forName(absScalarClassName);
                Constructor<?> absScalarConstructor =
                        absScalarClass.getConstructor(doubleType ? double.class : float.class, getUnitClass(absScalarClass));
                Object absOperand = null;
                System.out.println("unit is " + getUnitClass(absScalarClass));
                if (doubleType)
                {
                    absOperand = absScalarConstructor.newInstance(value, getSIUnitInstance(getUnitClass(absScalarClass)));
                }
                else
                {
                    absOperand =
                            absScalarConstructor.newInstance((float) value, getSIUnitInstance(getUnitClass(absScalarClass)));
                }
                minus = absScalarClass.getDeclaredMethod("minus", vectorClass);
                result = minus.invoke(absOperand, left);
                assertEquals("Result of abs or rel minus rel", 0,
                        verifyAbsRelPrecisionAndExtractSI(!abs, doubleType, result, XXXX), 0.01);
                if (null != compatibleRight && vectorClass.getName().contains("$Rel"))
                {
                    Method toAbs = compatibleRight.getClass().getDeclaredMethod("toAbs");
                    Object absCompatible = toAbs.invoke(compatibleRight);
                    result = minus.invoke(absCompatible, left);
                    assertEquals("Result of compatible abs or rel minus rel", 6 * value,
                            verifyAbsRelPrecisionAndExtractSI(!abs, doubleType, result, XXXX), 0.01);
                }
            }
        }
         */
    }

    /**
     * Test the interpolate method.
     * @param vectorClass Class&lt;?&gt;; the class to test
     * @param abs boolean; if true; scalarClass is Absolute; if false; scalarClass is Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param storageType StorageType; DENSE or SPARSE
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws ValueException
     */
    private void testInterpolateMethod(final Class<?> vectorClass, final boolean abs, final boolean doubleType,
            StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ValueException
    {
        // System.out.println("class name is " + vectorClass.getName());
        Constructor<?> constructor =
                vectorClass.getConstructor(doubleType ? double[].class : float[].class, getUnitClass(vectorClass),
                        StorageType.class);
        if (doubleType)
        {
            double[] zeroValue = { 1.23456, 2.45678 };
            DoubleVector<?> zero =
                    abs ? (DoubleVector.Abs<?>) constructor.newInstance(zeroValue,
                            getSIUnitInstance(getUnitClass(vectorClass)), storageType) : (DoubleVector.Rel<?>) constructor
                            .newInstance(zeroValue, getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            double[] oneValue = { 3.45678, 4.678901 };
            DoubleVector<?> one =
                    abs ? (DoubleVector.Abs<?>) constructor.newInstance(oneValue, getSIUnitInstance(getUnitClass(vectorClass)),
                            storageType) : (DoubleVector.Rel<?>) constructor.newInstance(oneValue,
                            getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            for (double ratio : new double[] { -5, -1, 0, 0.3, 1, 2, 10 })
            {
                double[] expectedResult = new double[zeroValue.length];
                for (int i = 0; i < expectedResult.length; i++)
                {
                    expectedResult[i] = (1.0 - ratio) * zeroValue[i] + ratio * oneValue[i];
                }
                // TODO: interpolate is not yet generated by the code generator ...
                // Method interpolate = vectorClass.getMethod("interpolate", vectorClass, vectorClass, double.class);
                // DoubleScalar<?> result;
                // result = (DoubleScalar<?>) interpolate.invoke(null, zero, one, ratio);
                // verifyAbsRelPrecisionAndValues(abs, doubleType, result, expectedResult, 0.01);
            }
        }
        else
        {
            float[] zeroValue = { 1.23456f, 2.45678f };
            FloatScalar<?> zero =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance(zeroValue, getSIUnitInstance(getUnitClass(vectorClass)))
                            : (FloatScalar.Rel<?>) constructor.newInstance(zeroValue,
                                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            float[] oneValue = { 3.45678f, 4.678901f };
            FloatScalar<?> one =
                    abs ? (FloatScalar.Abs<?>) constructor.newInstance(oneValue, getSIUnitInstance(getUnitClass(vectorClass)))
                            : (FloatScalar.Rel<?>) constructor.newInstance(oneValue,
                                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            for (float ratio : new float[] { -5, -1, 0, 0.3f, 1, 2, 10 })
            {
                float[] expectedResult = new float[zeroValue.length];
                for (int i = 0; i < expectedResult.length; i++)
                {
                    expectedResult[i] = (float) ((1.0 - ratio) * zeroValue[i] + ratio * oneValue[i]);
                }
                Method interpolate = vectorClass.getMethod("interpolate", vectorClass, vectorClass, float.class);
                FloatScalar<?> result;
                result = (FloatScalar<?>) interpolate.invoke(null, zero, one, ratio);
                verifyAbsRelPrecisionAndValues(abs, doubleType, result, expectedResult, 0.01);
            }
        }
    }

    /**
     * Prove (?) that order of items does not change in Arrays.stream(a).parallel().toArray().
     * @param args String[]; command line arguments; not used
     */
    public static void main(String[] args)
    {
        int size = 100000000;
        int[] a = new int[size];
        for (int i = 0; i < size; i++)
        {
            a[i] = i;
        }

        int[] b = Arrays.stream(a).parallel().toArray();
        for (int i = 0; i < size; i++)
        {
            if (b[i] != i)
            {
                System.out.println("Oops b[" + i + "] is " + b[i]);
            }
        }
        System.out.println("finished");
    }
}
