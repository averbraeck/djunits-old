package org.djunits4.value;

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

import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.LinearScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;
import org.djunits4.unit.util.UNITS;
import org.djunits4.util.ClassUtil;
import org.djunits4.value.vdouble.scalar.AbstractDoubleScalar;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.DoubleScalar;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vdouble.vector.AbstractDoubleVector;
import org.djunits4.value.vdouble.vector.DoubleVectorInterface;
import org.djunits4.value.vdouble.vector.MutableDoubleVectorInterface;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalar;
import org.djunits4.value.vfloat.scalar.FloatSIScalar;
import org.djunits4.value.vfloat.scalar.FloatScalar;
import org.djunits4.value.vfloat.vector.AbstractFloatVector;
import org.djunits4.value.vfloat.vector.FloatVectorInterface;
import org.djunits4.value.vfloat.vector.MutableFloatVectorInterface;
import org.junit.Assert;
import org.junit.Test;

/**
 * Find all various methods and prove their correctness.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * version Sep 14, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <TypedDoubleVectorAbs> Type of the object to perform the test on
 */
public class VectorOperationsTest<TypedDoubleVectorAbs> implements UNITS
{
    /**
     * Perform many tests on the double and float vector types.
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws SecurityException on reflection error
     * @throws ValueException when index out of range
     */
    @Test
    public final void vectorOperationsTest()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException, ValueException
    {
        doubleOrFloatVectorOperationsTest(true); // Double precision versions
        doubleOrFloatVectorOperationsTest(false); // Float versions
    }

    /**
     * Perform many tests on vector types.
     * @param doubleType boolean; if true; perform tests on DoubleScalar types; if false; perform tests on FloatScalar types
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws SecurityException on reflection error
     * @throws ValueException when index out of range
     */
    private void doubleOrFloatVectorOperationsTest(final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException, ValueException
    {
        final String upperVectorType = "Vector";
        final String floatPrefix = doubleType ? "" : "Float";
        String doubleOrFloat = doubleType ? "double" : "float";
        for (boolean mutable : new boolean[] {false, true})
        {
            for (StorageType storageType : StorageType.values())
            {
                // get the interfaces such as org.djunits4.value.vdouble.vector.Time
                for (int i = 0; i < CLASSNAMES.ABS.length; i++)
                {
                    String vectorNameAbs = CLASSNAMES.ABS[i];
                    Class<?> vectorClassAbs = null;
                    String classNameAbs = "org.djunits4.value.v" + doubleOrFloat + ".vector." + (mutable ? "Mutable" : "")
                            + floatPrefix + vectorNameAbs + upperVectorType;
                    System.out.println("Looking up class " + classNameAbs);
                    vectorClassAbs = Class.forName(classNameAbs);
                    Class<?> vectorClassRel = null;

                    String vectorNameRel = CLASSNAMES.ABS_REL[i];
                    String classNameRel = "org.djunits4.value.v" + doubleOrFloat + ".vector." + (mutable ? "Mutable" : "")
                            + floatPrefix + vectorNameRel + upperVectorType;
                    vectorClassRel = Class.forName(classNameRel);

                    testMethods(vectorClassAbs, true, doubleType, storageType, mutable);
                    testMethods(vectorClassRel, false, doubleType, storageType, mutable);
                    // testAbsRelConversion(vectorClass, true, doubleType, StorageType.DENSE);
                    // testAbsRelConversion(vectorClass, true, doubleType, StorageType.SPARSE);
                }
                // get the interfaces such as org.djunits4.value.vXXXX.vector.Area
                for (String vectorName : CLASSNAMES.REL)
                {
                    String vectorClassName = (doubleType ? "" : "Float") + vectorName;
                    String fullClassName = "org.djunits4.value.v" + doubleOrFloat + ".vector." + (mutable ? "Mutable" : "")
                            + vectorClassName + "Vector";
                    Class<?> vectorClass = null;
                    vectorClass = Class.forName(fullClassName);
                    testMethods(vectorClass, false, doubleType, storageType, mutable);
                }
            }
        }
    }

    /**
     * Find the methods defined in the class itself (not in a superclass) called multiplyBy or divideBy and test the method.
     * Also test the Unary methods of the class.
     * @param vectorClassAbsRel class to test
     * @param isAbs boolean; if true; the vectorClassAbsRel must be absolute; if false; the vectorClassAbsRel must be Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false perform tests on FloatScalar
     * @param storageType StorageType; DENSE or SPARSE
     * @param mutable boolean; if true; the vectorClass should be mutable; if false; the vectorClass should not be mutable
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws ValueException whhen index out of range
     */
    private void testMethods(final Class<?> vectorClassAbsRel, final boolean isAbs, final boolean doubleType,
            final StorageType storageType, final boolean mutable) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        // System.out.print(listMethods(vectorClassAbsRel, "multiplyBy", "\t"));
        for (Method method : vectorClassAbsRel.getMethods())
        {
            // System.out.println("Method name is " + method.getName());
            if (method.getName().equals("multiplyBy"))
            {
                testMultiplyByOrDivideByMethod(vectorClassAbsRel, method, true, doubleType, isAbs, storageType);
            }
            else if (method.getName().equals("divideBy"))
            {
                testMultiplyByOrDivideByMethod(vectorClassAbsRel, method, false, doubleType, isAbs, storageType);
            }
        }
        testConstructors(vectorClassAbsRel, isAbs, doubleType, mutable, storageType);
        testGet(vectorClassAbsRel, isAbs, doubleType, mutable, storageType);
        testUnaryMethods(vectorClassAbsRel, isAbs, doubleType, mutable, storageType);
        testInterpolateMethod(vectorClassAbsRel, isAbs, doubleType, storageType);
    }

    /**
     * Test a multiplication method for a Relative vector. Note: filter out the method that multiplies by a constant...
     * @param vectorClass Class&lt;?&gt;; the Relative class for the multiplication, e.g. Length
     * @param method the method 'multiplyBy' for that class
     * @param multiply boolean; if true; test a multiplyBy method; if false; test a divideBy method
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param abs boolean; if true; the vector class is absolute; if false; the vector class is relative
     * @param storageType StorageType; DENSE or SPARSE
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws ValueException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws SecurityException when index out of range
     */
    private void testMultiplyByOrDivideByMethod(final Class<?> vectorClass, final Method method, final boolean multiply,
            final boolean doubleType, final boolean abs, final StorageType storageType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException, ValueException
    {
        // System.out.println(method.getName() + paramsToString(method.getParameterTypes()));
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            fail("DoubleScalar class " + vectorClass.getName() + "." + method.getName() + "() has " + parTypes.length
                    + " parameters, <> 1");
        }
        Class<?> parameterClass = parTypes[0];
        if (parameterClass.toString().equals("double") || parameterClass.toString().equals("float"))
        {
            // Tested elsewhere.
            return;
        }
        // FIXME: multiplyBy and divideBy are currently only available for a non mutable argument.
        // Next if statement is always taken.
        // It is quite possible that multiplyBy will be restricted to Dimensionless vector arguments.
        if (!vectorClass.isAssignableFrom(parameterClass))
        {
            return;
        }

        Class<?> returnClass = method.getReturnType();
        if (!vectorClass.isAssignableFrom(returnClass))
        {
            Assert.fail("DoubleScalar class " + vectorClass.getName()
                    + ".multiplyBy() has return type with incompatible class: " + returnClass.getName());
        }

        // get the SI coefficients of the unit classes, scalar type, parameter type and return type
        String returnSI = getCoefficients(getUnitClass(returnClass));
        String scalarSI = getCoefficients(getUnitClass(vectorClass));
        String paramSI = getCoefficients(getUnitClass(parameterClass));
        // print what we just have found
        System.out.println(vectorClass.getName().replaceFirst("org.djunits4.value.vdouble.scalar.", "") + "."
                + (multiply ? "multiplyBy" : "divideBy") + "("
                + parameterClass.getName().replaceFirst("org.djunits4.value.vdouble.scalar.", "") + ") => "
                + returnClass.getName().replaceFirst("org.djunits4.value.vdouble.scalar.", "") + ": " + scalarSI
                + (multiply ? " * " : " : ") + paramSI + " => " + returnSI);

        Constructor<?> constructor = vectorClass.getConstructor(double.class, getUnitClass(vectorClass));
        if (doubleType)
        {
            DoubleScalar.Rel<?> left =
                    (DoubleScalar.Rel<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(vectorClass)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            DoubleScalar.Rel<?> right =
                    (DoubleScalar.Rel<?>) constructor.newInstance(456d, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            double expectedValue = multiply ? 123d * 456 : 123d / 456;

            if (multiply)
            {
                Method multiplyMethod = vectorClass.getDeclaredMethod("multiplyBy", new Class[] {parameterClass});
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Rel<?>) result).getSI();
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = vectorClass.getDeclaredMethod("divideBy", new Class[] {parameterClass});
                Object result = divideMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Rel<?>) result).getSI();
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            SIScalar result = multiply ? DoubleScalar.multiply(left, right) : DoubleScalar.divide(left, right);
            // System.out.println("result is " + result);
            String resultCoefficients = result.getUnit().getUnitBase().getSiDimensions().toString();
            assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
        }
        else
        {
            FloatScalar.Rel<?> left =
                    (FloatScalar.Rel<?>) constructor.newInstance(123f, getSIUnitInstance(getUnitClass(vectorClass)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            FloatScalar.Rel<?> right =
                    (FloatScalar.Rel<?>) constructor.newInstance(456f, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            float expectedValue = multiply ? 123f * 456 : 123f / 456;

            if (multiply)
            {
                Method multiplyMethod = vectorClass.getDeclaredMethod("multiplyBy", new Class[] {parameterClass});
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((FloatScalar.Rel<?>) result).getSI();
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = vectorClass.getDeclaredMethod("divideBy", new Class[] {parameterClass});
                Object result = divideMethod.invoke(left, right);
                float resultSI = ((FloatScalar.Rel<?>) result).getSI();
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            FloatSIScalar result = multiply ? FloatScalar.multiply(left, right) : FloatScalar.divide(left, right);
            // System.out.println("result is " + result);
            String resultCoefficients = result.getUnit().getUnitBase().getSiDimensions().toString();
            assertEquals("SI coefficients of result should match expected SI coefficients", resultCoefficients, returnSI);
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
        Field si = clas.getField("SI");
        Unit<?> u = ((Unit<?>) si.get(clas));
        String r = u.getUnitBase().getSiDimensions().toString();
        return r;
        // return ((Unit<?>) si.get(clas)).getBaseUnit().getSiDimensions().toString();
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
        // TODO: Check for BASE field in absolutes, SI field in relatives
        Field si = null;
        try
        {
            si = clas.getField("SI");
        }
        catch (NoSuchFieldException nsfe)
        {
            si = clas.getField("DEFAULT");
        }
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
     * @param storageType StorageType; DENSE or SPARSE
     * @param got the (DoubleVector?) object
     * @param expected double[] or float[] with expected values
     * @param precision double; maximum error of the results
     * @throws ValueException when index out of range
     */
    private void verifyAbsRelPrecisionAndValues(final boolean abs, final boolean doubleType, final StorageType storageType,
            final Object got, final Object expected, final double precision) throws ValueException
    {
        int size = doubleType ? ((double[]) expected).length : ((float[]) expected).length;
        int refSize = doubleType ? ((double[]) expected).length : ((float[]) expected).length;
        assertEquals("size of resulting array", refSize, size);
        for (int i = 0; i < size; i++)
        {
            double result = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, got, i);
            assertEquals("value check", doubleType ? ((double[]) expected)[i] : ((float[]) expected)[i], result, precision);
        }
    }

    /**
     * Verify the Absoluteness or Relativeness of a DoubleScalar and return the SI value.
     * @param abs boolean; expected Absolute- or Relativeness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param storageType StorageType; the expected StorageType (DENSE or SPARSE)
     * @param o the (DoubleScalar?) object
     * @param index int; the index of the value to return
     * @return double; the SI value
     * @throws ValueException when index out of range
     */
    private double verifyAbsRelPrecisionAndExtractSI(final boolean abs, final boolean doubleType, final StorageType storageType,
            final Object o, final int index) throws ValueException
    {
        double result = Double.NaN;
        if (doubleType)
        {
            if (!(o instanceof DoubleVectorInterface))
            {
                fail("object is not a DoubleVector");
            }
            AbstractDoubleVector<?, ?> dv = (AbstractDoubleVector<?, ?>) o;
            result = dv.getSI(index);
            assertEquals("StorageType", storageType, dv.getStorageType());
        }
        else
        {
            if (!(o instanceof FloatVectorInterface))
            {
                fail("object is not a FloatVector");
            }
            AbstractFloatVector<?, ?> fv = (AbstractFloatVector<?, ?>) o;
            result = fv.getSI(index);
            assertEquals("StorageType", storageType, fv.getStorageType());
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
     * @param abs boolean; if true; test Absolute class; if false; test the Relative class
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param mutable boolean; if true; perform test for mutable version; if false; perform test for non-mutable version
     * @param storageType StorageType; Dense or Sparse
     * @throws NoSuchMethodException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on class or method resolving error
     * @throws ValueException when index out of range
     */
    private void testConstructors(final Class<?> vectorClass, final boolean abs, final boolean doubleType,
            final boolean mutable, final StorageType storageType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = {1.23456, 2.34567, 3.45678};
        float[] floatValue = {1.23456f, 2.34567f, 3.45678f};
        Object value = doubleType ? doubleValue : floatValue;
        findAndTestConstructor(vectorClass, new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType},
                abs, doubleType, storageType, value);
        // What is the corresponding Scalar type?
        String scalarClassName = vectorClass.getName();
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("Vector", "");
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("vector", "scalar");
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("Mutable", "");
        // System.out.println("name is " + scalarClassName);
        Class<?> scalarClassAbsRel = Class.forName(scalarClassName);
        // System.out.println("class is " + scalarClassAbsRel);
        if (doubleType)
        {
            List<Double> list = new ArrayList<Double>();
            for (int i = 0; i < doubleValue.length; i++)
            {
                list.add(doubleValue[i]);
            }
            findAndTestConstructor(vectorClass, new Object[] {list, getSIUnitInstance(getUnitClass(vectorClass)), storageType},
                    abs, doubleType, storageType, value);
            // Construct a list of scalar objects
            Constructor<?> constructor =
                    scalarClassAbsRel.getConstructor(new Class<?>[] {double.class, getUnitClass(vectorClass)});
            List<Object> objectList = new ArrayList<Object>();
            for (Double d : list)
            {
                objectList.add(constructor.newInstance(d, getSIUnitInstance(getUnitClass(vectorClass))));
            }
            findAndTestConstructor(vectorClass, new Object[] {objectList, storageType}, abs, doubleType, storageType, value);
            // Construct an array of the correct scalar objects
            Object[] objectArray = (Object[]) Array.newInstance(scalarClassAbsRel, objectList.size());
            for (int i = 0; i < objectList.size(); i++)
            {
                objectArray[i] = objectList.get(i);
            }
            findAndTestConstructor(vectorClass, new Object[] {objectArray, storageType}, abs, doubleType, storageType, value);
            SortedMap<Integer, Object> map = new TreeMap<Integer, Object>();
            for (int i = 0; i < objectList.size(); i++)
            {
                map.put(i, objectList.get(i));
            }
            // System.out.println("int is assignable from Integer ? " + int.class.isAssignableFrom(Integer.class));
            findAndTestConstructor(vectorClass, new Object[] {map, objectList.size(), storageType}, abs, doubleType,
                    storageType, value);
            map.clear();
            for (int i = 0; i < doubleValue.length; i++)
            {
                map.put(i, doubleValue[i]);
            }
            findAndTestConstructor(vectorClass,
                    new Object[] {map, getSIUnitInstance(getUnitClass(vectorClass)), doubleValue.length, storageType}, abs,
                    doubleType, storageType, value);
        }
        else
        {
            List<Float> list = new ArrayList<Float>();
            for (int i = 0; i < floatValue.length; i++)
            {
                list.add(floatValue[i]);
            }
            findAndTestConstructor(vectorClass, new Object[] {list, getSIUnitInstance(getUnitClass(vectorClass)), storageType},
                    abs, doubleType, storageType, value);
            // Construct a list of scalar objects
            Constructor<?> constructor =
                    scalarClassAbsRel.getConstructor(new Class<?>[] {double.class, getUnitClass(vectorClass)});
            List<Object> objectList = new ArrayList<Object>();
            for (Float f : list)
            {
                objectList.add(constructor.newInstance(f, getSIUnitInstance(getUnitClass(vectorClass))));
            }
            findAndTestConstructor(vectorClass, new Object[] {objectList, storageType}, abs, doubleType, storageType, value);
            // Construct an array of the correct scalar objects
            Object[] objectArray = (Object[]) Array.newInstance(scalarClassAbsRel, objectList.size());
            for (int i = 0; i < objectList.size(); i++)
            {
                objectArray[i] = objectList.get(i);
            }
            findAndTestConstructor(vectorClass, new Object[] {objectArray, storageType}, abs, doubleType, storageType, value);
            SortedMap<Integer, Object> map = new TreeMap<Integer, Object>();
            for (int i = 0; i < objectList.size(); i++)
            {
                map.put(i, objectList.get(i));
            }
            // System.out.println("int is assignable from Integer ? " + int.class.isAssignableFrom(Integer.class));
            findAndTestConstructor(vectorClass, new Object[] {map, objectList.size(), storageType}, abs, doubleType,
                    storageType, value);
            map.clear();
            for (int i = 0; i < floatValue.length; i++)
            {
                map.put(i, floatValue[i]);
            }
            findAndTestConstructor(vectorClass,
                    new Object[] {map, getSIUnitInstance(getUnitClass(vectorClass)), floatValue.length, storageType}, abs,
                    doubleType, storageType, value);
        }
    }

    /**
     * Return a string with the types of all types of a class array.
     * @param params Class&lt;?&gt;[]; the class array
     * @return String
     */
    private String paramsToString(final Class<?>[] params)
    {
        StringBuilder result = new StringBuilder();
        result.append("(");
        String separator = "";
        for (Class<?> parType : params)
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
     * @param doubleType boolean; if true; the args argument is array of double; of false; the args argument is array of float
     * @return constructed object
     * @throws NoSuchMethodException on reflection error
     * @throws SecurityException on reflection error
     * @throws InstantiationException on reflection error
     * @throws IllegalAccessException on reflection error
     * @throws IllegalArgumentException on reflection error
     * @throws InvocationTargetException on reflection error
     * @throws ValueException when index out of range
     */
    private Object findAndExecuteConstructor(final Class<?> vectorClass, final Object[] args, final boolean doubleType)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ValueException
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
            // System.out.println("Found constructor for " + vectorClass + " " + paramsToString(c.getParameterTypes()));
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
        }
        // Constructor<?> constructor = vectorClass.getConstructor(parameterTypes);
        if (null == constructor)
        {
            System.out.println("No suitable constructor for " + vectorClass + ":");
            for (int i = 0; i < args.length; i++)
            {
                System.out.println("\tparameter type[" + i + "] is " + args[i].getClass());
            }
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
     * @param expectedStorageType StorageType; the expected Storage type (DENSE or SPARSE)
     * @param expectedResult Object; either array of double, or array of float
     * @throws NoSuchMethodException on class or method resolving error
     * @throws SecurityException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws IllegalArgumentException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws ValueException when index out of range
     */
    private void findAndTestConstructor(final Class<?> vectorClass, final Object[] args, final boolean abs,
            final boolean doubleType, final StorageType expectedStorageType, final Object expectedResult)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ValueException
    {
        verifyAbsRelPrecisionAndValues(abs, doubleType, expectedStorageType,
                findAndExecuteConstructor(vectorClass, args, doubleType), expectedResult, 0.0001);
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
     * @throws ClassNotFoundException on class or method resolving error
     * @throws ValueException when index out of range
     */
    private void testGet(final Class<?> vectorClass, final boolean abs, final boolean doubleType, final boolean mutable,
            final StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = {1.23456, 2.34567, 3.45678};
        float[] floatValue = {1.23456f, 2.34567f, 3.45678f};
        Object value = doubleType ? doubleValue : floatValue;
        Object vector = findAndExecuteConstructor(vectorClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
        if (doubleType)
        {
            AbstractDoubleVector<?, ?> dv = (AbstractDoubleVector<?, ?>) vector;
            for (int i = 0; i < doubleValue.length; i++)
            {
                AbstractDoubleScalar<?, ?> ds = dv.get(i);
                double got = ds.getSI();
                assertEquals("get returns expected value", doubleValue[i], got, 0.0001);
            }
        }
        else
        {
            AbstractFloatVector<?, ?> fv = (AbstractFloatVector<?, ?>) vector;
            for (int i = 0; i < floatValue.length; i++)
            {
                AbstractFloatScalar<?, ?> fs = fv.get(i);
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
     * @throws ClassNotFoundException on class or method resolving error
     * @throws ValueException when index out of range
     */
    private void testUnaryMethods(final Class<?> vectorClass, final boolean abs, final boolean doubleType,
            final boolean mutable, final StorageType storageType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[] doubleValue = {1.23456, -2.34567, 3.45678};
        float[] floatValue = {1.23456f, -2.34567f, 3.45678f};
        Object value = doubleType ? doubleValue : floatValue;
        Object left = findAndExecuteConstructor(vectorClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
        Object result;
        if (doubleType)
        {
            result = ((DoubleVectorInterface<?>) left).toSparse();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.SPARSE, result, value, 0.0001);
            result = ((DoubleVectorInterface<?>) left).toDense();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.DENSE, result, value, 0.0001);
            result = ((DoubleVectorInterface<?>) left).mutable();
            verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, value, 0.0001);
            result = ((MutableDoubleVectorInterface<?>) result).immutable();
            verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, value, 0.0001);
            if (abs)
            {
                double[] thirdValue = new double[doubleValue.length];
                double[] twoThirdValue = new double[doubleValue.length];
                for (int i = 0; i < thirdValue.length; i++)
                {
                    thirdValue[i] = doubleValue[i] / 3;
                    twoThirdValue[i] = 2 * thirdValue[i];
                }
                // FIXME - Peter does not know how to write this with generics...
                // Does not work yet because mixed mutable immutable minus does not exist yet
                // Object right =
                // findAndExecuteConstructor(vectorClass, new Object[] { thirdValue,
                // getSIUnitInstance(getUnitClass(vectorClass)), storageType }, abs, doubleType);
                // System.out.println("left : " + left.getClass() + " right : " + right.getClass());
                // System.out.println(Arrays.toString(left.getClass().ClassUtil.resolveMethod(left.getClass(),
                // s()).replaceAll(" org", "\norg"));
                // System.out.println("super class " + right.getClass().getSuperclass());
                // Method minus = left.getClass().getMethod("minus", new Class<?>[] { right.getClass().getSuperclass() });
                // result = minus.invoke(left, right);
                // result = left.minus(right);
                // verifyAbsRelPrecisionAndValues(false, doubleType, storageType, result, twoThirdValue, 0.0001);
            }
        }
        else
        {
            result = ((FloatVectorInterface<?>) left).toSparse();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.SPARSE, result, value, 0.0001);
            result = ((FloatVectorInterface<?>) left).toDense();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.DENSE, result, value, 0.0001);
            result = ((FloatVectorInterface<?>) left).mutable();
            verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, value, 0.0001);
            result = ((MutableFloatVectorInterface<?>) result).immutable();
            verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, value, 0.0001);
            if (abs)
            {
                double[] thirdValue = new double[floatValue.length];
                double[] twoThirdValue = new double[floatValue.length];
                for (int i = 0; i < thirdValue.length; i++)
                {
                    thirdValue[i] = floatValue[i] / 3;
                    twoThirdValue[i] = 2 * thirdValue[i];
                }
                // FIXME - Peter does not know how to write this with generics...
                // Does not work yet because mixed mutable immutable minus does not exist yet
                // Object right =
                // findAndExecuteConstructor(vectorClass, new Object[] { thirdValue,
                // getSIUnitInstance(getUnitClass(vectorClass)), storageType }, abs, doubleType);
                // System.out.println("left : " + left.getClass() + " right : " + right.getClass());
                // System.out.println(Arrays.toString(left.getClass().getMethods()).replaceAll(" org", "\norg"));
                // System.out.println("super class " + right.getClass().getSuperclass());
                // Method minus = ClassUtil.resolveMethod(left.getClass(), "minus", new Class<?>[] {
                // right.getClass().getSuperclass() });
                // result = minus.invoke(left, right);
                // result = left.minus(right);
                // verifyAbsRelPrecisionAndValues(false, doubleType, storageType, result, twoThirdValue, 0.0001);
            }
        }

        if (mutable)
        {
            double doubleDifference = 42.42;
            float floatDifference = 42.42f;
            Class<?> argumentClass = doubleType ? double.class : float.class;
            Method incrementBy = ClassUtil.resolveMethod(vectorClass, "incrementBy", new Class<?>[] {argumentClass});
            incrementBy = ClassUtil.resolveMethod(vectorClass, "incrementBy", new Class<?>[] {argumentClass});
            incrementBy.setAccessible(true);
            // System.out.print(paramsToString(incrementBy.getParameterTypes()));
            // System.out.println("type of value is " + value.getClass());
            // System.out.println("type of difference is " + difference.getClass());
            if (doubleType)
            {
                result = incrementBy.invoke(left, new Object[] {doubleDifference});
            }
            else
            {
                result = incrementBy.invoke(left, new Object[] {floatDifference});
            }
            for (int i = 0; i < doubleValue.length; i++)
            {
                double resultElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i);
                assertEquals("value check result",
                        doubleType ? (doubleValue[i] + doubleDifference) : (floatValue[i] + floatDifference), resultElement,
                        0.00001);
                // Check that original is also modified
                double originalElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i);
                assertEquals("value check original",
                        doubleType ? (doubleValue[i] + doubleDifference) : (floatValue[i] + floatDifference), originalElement,
                        0.00001);
            }
            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            Method decrementBy = ClassUtil.resolveMethod(vectorClass, "decrementBy", new Class<?>[] {argumentClass});
            decrementBy.setAccessible(true);
            if (doubleType)
            {
                result = decrementBy.invoke(left, new Object[] {doubleDifference});
            }
            else
            {
                result = decrementBy.invoke(left, new Object[] {floatDifference});
            }
            for (int i = 0; i < doubleValue.length; i++)
            {
                double resultElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i);
                assertEquals("value check",
                        doubleType ? (doubleValue[i] - doubleDifference) : (floatValue[i] - floatDifference), resultElement,
                        0.00001);
                // Check that original is also modified
                double originalElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i);
                assertEquals("value check original",
                        doubleType ? (doubleValue[i] - doubleDifference) : (floatValue[i] - floatDifference), originalElement,
                        0.00001);
            }

            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            Method mathMethod = ClassUtil.resolveMethod(vectorClass, "ceil", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation",
                        doubleType ? Math.ceil(doubleValue[i]) : ((float) Math.ceil(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation",
                        doubleType ? Math.ceil(doubleValue[i]) : ((float) Math.ceil(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }

            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(vectorClass, "floor", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation",
                        doubleType ? Math.floor(doubleValue[i]) : ((float) Math.floor(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation",
                        doubleType ? Math.floor(doubleValue[i]) : ((float) Math.floor(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }

            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(vectorClass, "rint", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation",
                        doubleType ? Math.rint(doubleValue[i]) : ((float) Math.rint(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation",
                        doubleType ? Math.rint(doubleValue[i]) : ((float) Math.rint(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }

            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(vectorClass, "round", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation",
                        doubleType ? Math.round(doubleValue[i]) : ((float) Math.round(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation",
                        doubleType ? Math.round(doubleValue[i]) : ((float) Math.round(doubleValue[i])),
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }

            if (!abs)
            {
                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "abs", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.abs(doubleValue[i]) : ((float) Math.abs(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.abs(doubleValue[i]) : ((float) Math.abs(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }
            }

            if (vectorClass.getName().contains("Dimensionless"))
            {
                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "acos", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.acos(doubleValue[i]) : ((float) Math.acos(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.acos(doubleValue[i]) : ((float) Math.acos(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "asin", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.asin(doubleValue[i]) : ((float) Math.asin(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.asin(doubleValue[i]) : ((float) Math.asin(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "atan", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.atan(doubleValue[i]) : ((float) Math.atan(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.atan(doubleValue[i]) : ((float) Math.atan(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "cbrt", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.cbrt(doubleValue[i]) : ((float) Math.cbrt(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.cbrt(doubleValue[i]) : ((float) Math.cbrt(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "cos", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.cos(doubleValue[i]) : ((float) Math.cos(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.cos(doubleValue[i]) : ((float) Math.cos(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "cosh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.cosh(doubleValue[i]) : ((float) Math.cosh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.cosh(doubleValue[i]) : ((float) Math.cosh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "exp", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.exp(doubleValue[i]) : ((float) Math.exp(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.exp(doubleValue[i]) : ((float) Math.exp(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "expm1", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.expm1(doubleValue[i]) : ((float) Math.expm1(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.expm1(doubleValue[i]) : ((float) Math.expm1(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "log", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.log(doubleValue[i]) : ((float) Math.log(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.log(doubleValue[i]) : ((float) Math.log(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "log10", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.log10(doubleValue[i]) : ((float) Math.log10(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.log10(doubleValue[i]) : ((float) Math.log10(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "log1p", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.log1p(doubleValue[i]) : ((float) Math.log1p(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.log1p(doubleValue[i]) : ((float) Math.log1p(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "signum", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.signum(doubleValue[i]) : ((float) Math.signum(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.signum(doubleValue[i]) : ((float) Math.signum(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "sin", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.sin(doubleValue[i]) : ((float) Math.sin(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.sin(doubleValue[i]) : ((float) Math.sin(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "sinh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.sinh(doubleValue[i]) : ((float) Math.sinh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.sinh(doubleValue[i]) : ((float) Math.sinh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "sqrt", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.sqrt(doubleValue[i]) : ((float) Math.sqrt(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.sqrt(doubleValue[i]) : ((float) Math.sqrt(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "tan", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.tan(doubleValue[i]) : ((float) Math.tan(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.tan(doubleValue[i]) : ((float) Math.tan(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "tanh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.tanh(doubleValue[i]) : ((float) Math.tanh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.tanh(doubleValue[i]) : ((float) Math.tanh(doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "inv", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation", doubleType ? (1.0 / doubleValue[i]) : ((float) (1.0 / doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation", doubleType ? (1.0 / doubleValue[i]) : ((float) (1.0 / doubleValue[i])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                for (double power : new double[] {-3, -Math.PI, -1, -0.5, 0, 0.5, 1, Math.PI, 3})
                {
                    left = findAndExecuteConstructor(vectorClass,
                            new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                    mathMethod = ClassUtil.resolveMethod(vectorClass, "pow", new Class[] {double.class});
                    mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                    result = mathMethod.invoke(left, power);
                    for (int i = 0; i < doubleValue.length; i++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.pow(doubleValue[i], power) : ((float) Math.pow(doubleValue[i], power)),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.pow(doubleValue[i], power) : ((float) Math.pow(doubleValue[i], power)),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                    }
                }

                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(vectorClass, "normalize", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                mathMethod.invoke(left);
                double sum = 0;
                for (double v : doubleValue)
                {
                    sum += v;
                }
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of operation", doubleType ? (doubleValue[i] / sum) : ((float) (doubleValue[i] / sum)),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                }

                double[] doubleZeroZSum = {-4, 4, -1, 1, 0};
                float[] floatZeroZSum = {-4, 4, -1, 1, 0};
                Object zeroZSumValue = doubleType ? doubleZeroZSum : floatZeroZSum;
                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {zeroZSumValue, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                try
                {
                    mathMethod.invoke(left);
                    fail("normalize should have thrown a ValueException because zSum is 0");
                }
                catch (Exception ve)
                {
                    if (!(ve.getCause() instanceof ValueException))
                    {
                        fail("Thrown exception should have been a ValueException");
                    }
                    // ignore expected exception
                }

            }
        }

        left = findAndExecuteConstructor(vectorClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
        if (mutable)
        {
            Method multiplyBy =
                    ClassUtil.resolveMethod(vectorClass, "multiplyBy", new Class[] {doubleType ? double.class : float.class});
            multiplyBy.setAccessible(true); // FIXME this should not be necessary
            if (doubleType)
            {
                result = multiplyBy.invoke(left, Math.PI);
            }
            else
            {
                result = multiplyBy.invoke(left, (float) Math.PI);
            }
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation", doubleValue[i] * Math.PI,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation", doubleValue[i] * Math.PI,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }
            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            Method divideBy =
                    ClassUtil.resolveMethod(vectorClass, "divideBy", new Class[] {doubleType ? double.class : float.class});
            divideBy.setAccessible(true); // FIXME this should not be necessary
            if (doubleType)
            {
                result = divideBy.invoke(left, Math.PI);
            }
            else
            {
                result = divideBy.invoke(left, (float) Math.PI);
            }
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of operation", doubleValue[i] / Math.PI,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                // Check that original is also modified
                assertEquals("Result of operation", doubleValue[i] / Math.PI,
                        verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
            }
            double[] zDoubleValues = {0, 0, 0, 0, 0, 0, 0};
            float[] zFloatValues = {0, 0, 0, 0, 0, 0, 0};
            Object zValues = doubleType ? zDoubleValues : zFloatValues;
            Method set = ClassUtil.resolveMethod(vectorClass, "setSI",
                    new Class[] {int.class, doubleType ? double.class : float.class});
            set.setAccessible(true);
            for (int pivot2 = 0; pivot2 < zDoubleValues.length; pivot2++)
            {
                for (int pivot = 0; pivot < zDoubleValues.length; pivot++)
                {
                    if (pivot == pivot2)
                    {
                        continue;
                    }
                    left = findAndExecuteConstructor(vectorClass,
                            new Object[] {zValues, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                    // System.out.println("initial " + pivot + ", " + pivot2 + " " + left);
                    if (doubleType)
                    {
                        set.invoke(left, new Object[] {pivot, Math.PI * (pivot + 1)});
                    }
                    else
                    {
                        set.invoke(left, new Object[] {pivot, (float) (Math.PI * (pivot + 1))});
                    }
                    // System.out.println("after one set " + left);
                    for (int i = 0; i < zDoubleValues.length; i++)
                    {
                        assertEquals("after one set, i=" + i, i == pivot ? Math.PI * (pivot + 1) : 0,
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                    }
                    if (doubleType)
                    {
                        set.invoke(left, new Object[] {pivot2, Math.PI * (pivot2 + 20)});
                    }
                    else
                    {
                        set.invoke(left, new Object[] {pivot2, (float) (Math.PI * (pivot2 + 20))});
                    }
                    // System.out.println("after second set " + left);
                    for (int i = 0; i < zDoubleValues.length; i++)
                    {
                        assertEquals("after second set, i=" + i,
                                i == pivot ? Math.PI * (pivot + 1) : i == pivot2 ? Math.PI * (pivot2 + 20) : 0,
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                    }
                    for (int i = 0; i < zDoubleValues.length; i++)
                    {
                        if (i == pivot || i == pivot2)
                        {
                            continue;
                        }
                        if (doubleType)
                        {
                            set.invoke(left, new Object[] {i, (double) (i + 1)});
                        }
                        else
                        {
                            set.invoke(left, new Object[] {i, (float) (i + 1)});
                        }
                    }
                    // System.out.println("after fill " + left);
                    for (int i = 0; i < zDoubleValues.length; i++)
                    {
                        assertEquals("after all set i=" + i + " pivot=" + pivot + ", pivot2=" + pivot2,
                                i == pivot ? Math.PI * (pivot + 1) : i == pivot2 ? Math.PI * (pivot2 + 20) : i + 1,
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, i), 0.01);
                    }
                }
            }
        }
        Object compatibleRight = null;
        Object compatibleRel = null;
        // TODO: Probably we exclude too much here for the tests...
        if (!vectorClass.getName().contains("Dimensionless") && !vectorClass.getName().contains("Temperature")
                && !vectorClass.getName().contains("Position") && !vectorClass.getName().contains("Time")
                && !vectorClass.getName().contains("Direction"))
        {
            // Construct a new unit to test mixed unit plus and minus
            Class<?> unitClass = getUnitClass(vectorClass);
            UnitSystem unitSystem = UnitSystem.SI_DERIVED;
            Unit<?> referenceUnit;
            // Call the getUnit method of left
            Method getUnitMethod = ClassUtil.resolveMethod(vectorClass, "getUnit");
            referenceUnit = (Unit<?>) getUnitMethod.invoke(left);
            Constructor<?> unitConstructor = unitClass.getConstructor(); // empty constructor -- provide Builder
            Unit newUnit = (Unit) unitConstructor.newInstance();
            Method buildMethod = ClassUtil.resolveMethod(Unit.class, "build", Unit.Builder.class);
            Unit.Builder builder = new Unit.Builder<>();
            builder.setId("7abbr");
            builder.setName("7fullName");
            builder.setUnitSystem(unitSystem);
            builder.setScale(new LinearScale(7));
            builder.setUnitBase((UnitBase) getSIUnitInstance(unitClass).getUnitBase());
            builder.setSiPrefixes(SIPrefixes.NONE);
            buildMethod.setAccessible(true);
            buildMethod.invoke(newUnit, builder);

            // System.out.println("new unit prints like " + newUnit);
            compatibleRight = findAndExecuteConstructor(vectorClass, new Object[] {value, newUnit, storageType}, doubleType);
            // System.out.println("compatibleRight prints like \"" + compatibleRight + "\"");
            if (abs)
            {
                String className = vectorClass.getName();
                for (int i = 0; i < CLASSNAMES.ABS.length; i++)
                {
                    className = className.replaceAll(CLASSNAMES.ABS[i], CLASSNAMES.ABS_REL[i]);
                }
                Class<?> relClass = Class.forName(className);
                compatibleRel = findAndExecuteConstructor(relClass, new Object[] {value, newUnit, storageType}, doubleType);
                // System.out.println("compatibleRel prints like \"" + compatibleRight + "\"");
            }
            newUnit.getUnitBase().unregister(newUnit);
        }
        if (null != compatibleRight)
        {
            left = findAndExecuteConstructor(vectorClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
            // System.out.print(listMethods(vectorClass, "plus", "\t"));
            // System.out.println("Mutable is " + mutable);
            if (!mutable)
            { // FIXME: should also work for mutable and mix of mutable and immutable
              // System.out.println("Type of right is " + compatibleRight.getClass());
                if (!abs)
                {
                    Method plus = ClassUtil.resolveMethod(vectorClass, "plus",
                            new Class<?>[] {compatibleRight.getClass().getSuperclass()});
                    plus.setAccessible(true);
                    result = plus.invoke(left, compatibleRight);
                    for (int i = 0; i < doubleValue.length; i++)
                    {
                        assertEquals("Result of mixed operation", 8 * doubleValue[i],
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    }
                }
                if (null != compatibleRel)
                {
                    // System.out.print(listMethods(vectorClass, "plus", "\t"));
                    // System.out.println("Type of rel is " + compatibleRel.getClass());
                    Method plus = ClassUtil.resolveMethod(vectorClass, "plus",
                            new Class<?>[] {compatibleRel.getClass().getSuperclass()});
                    plus.setAccessible(true);
                    result = plus.invoke(left, compatibleRel);
                    for (int i = 0; i < doubleValue.length; i++)
                    {
                        assertEquals("Result of mixed operation", 8 * doubleValue[i],
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, i), 0.01);
                    }
                }
            }
        }
        left = findAndExecuteConstructor(vectorClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
        if (!mutable)
        {
            // System.out.print(listMethods(vectorClass, "minus", "\t"));
            Method minus = ClassUtil.resolveMethod(vectorClass, "minus", new Class[] {vectorClass.getSuperclass()});
            minus.setAccessible(true);
            result = minus.invoke(left, left);
            for (int i = 0; i < doubleValue.length; i++)
            {
                assertEquals("Result of minus", 0, verifyAbsRelPrecisionAndExtractSI(false, doubleType, storageType, result, i),
                        0.01);
            }
            if (null != compatibleRight)
            {
                left = findAndExecuteConstructor(vectorClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(vectorClass)), storageType}, doubleType);
                result = minus.invoke(left, compatibleRight);
                for (int i = 0; i < doubleValue.length; i++)
                {
                    assertEquals("Result of minus with compatible arg", -6 * doubleValue[i],
                            verifyAbsRelPrecisionAndExtractSI(false, doubleType, storageType, result, i), 0.01);
                }
            }
        }
    }

    /**
     * List all methods matching the given name.
     * @param theClass Class&lt;?&gt;; the class
     * @param name String; the name of the method, or null to list all methods in the class
     * @param prefix String; prefix for each line in the result;
     * @return String
     */
    public final String listMethods(final Class<?> theClass, final String name, final String prefix)
    {
        StringBuilder result = new StringBuilder();
        for (Method m : theClass.getMethods())
        {
            if (null == name || name.equals(m.getName()))
            {
                result.append(
                        prefix + m.getName() + paramsToString(m.getParameterTypes()) + " -> " + m.getReturnType() + "\r\n");
            }
        }
        return result.toString();
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
     * @throws ValueException when index out of range
     */
    private void testInterpolateMethod(final Class<?> vectorClass, final boolean abs, final boolean doubleType,
            final StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ValueException
    {
        // System.out.println("class name is " + vectorClass.getName());
        Constructor<?> constructor = vectorClass.getConstructor(doubleType ? double[].class : float[].class,
                getUnitClass(vectorClass), StorageType.class);
        if (doubleType)
        {
            double[] zeroValue = {1.23456, 2.45678};
            // AbstractDoubleVector<?, ?> zero =
            // abs ? (DoubleVector.Abs<?>) constructor.newInstance(zeroValue,
            // getSIUnitInstance(getUnitClass(vectorClass)), storageType) : (DoubleVector.Rel<?>) constructor
            // .newInstance(zeroValue, getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            AbstractDoubleVector<?, ?> zero = (AbstractDoubleVector<?, ?>) constructor.newInstance(zeroValue,
                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            double[] oneValue = {3.45678, 4.678901};
            AbstractDoubleVector<?, ?> one = (AbstractDoubleVector<?, ?>) constructor.newInstance(oneValue,
                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            for (double ratio : new double[] {-5, -1, 0, 0.3, 1, 2, 10})
            {
                double[] expectedResult = new double[zeroValue.length];
                for (int i = 0; i < expectedResult.length; i++)
                {
                    expectedResult[i] = (1.0 - ratio) * zeroValue[i] + ratio * oneValue[i];
                }
                // TODO: interpolate is not yet generated by the code generator ...
                // Method interpolate = ClassUtil.resolveMethod(vectorClass, "interpolate", vectorClass, vectorClass,
                // double.class);
                // AbstractDoubleScalar<?, ?> result;
                // result = (AbstractDoubleScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                // verifyAbsRelPrecisionAndValues(abs, doubleType, result, expectedResult, 0.01);
            }
            Method toArray = ClassUtil.resolveMethod(vectorClass, "toArray");
            AbstractDoubleScalar<?, ?>[] result = (AbstractDoubleScalar<?, ?>[]) toArray.invoke(zero);
            assertEquals("toArray result has correct number of entries", zero.size(), result.length);
            for (int index = 0; index < result.length; index++)
            {
                assertEquals("Element in array has correct value", zeroValue[index], result[index].getSI(), 0.001);
            }
        }
        else
        {
            float[] zeroValue = {1.23456f, 2.45678f};
            AbstractFloatVector<?, ?> zero = (AbstractFloatVector<?, ?>) constructor.newInstance(zeroValue,
                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            float[] oneValue = {3.45678f, 4.678901f};
            AbstractFloatVector<?, ?> one = (AbstractFloatVector<?, ?>) constructor.newInstance(oneValue,
                    getSIUnitInstance(getUnitClass(vectorClass)), storageType);
            for (float ratio : new float[] {-5, -1, 0, 0.3f, 1, 2, 10})
            {
                float[] expectedResult = new float[zeroValue.length];
                for (int i = 0; i < expectedResult.length; i++)
                {
                    expectedResult[i] = (float) ((1.0 - ratio) * zeroValue[i] + ratio * oneValue[i]);
                }
                // Method interpolate = ClassUtil.resolveMethod(vectorClass, "interpolate", vectorClass, vectorClass,
                // float.class);
                // AbstractFloatScalar<?, ?> result;
                // result = (AbstractFloatScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                // verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, expectedResult, 0.01);
            }
            Method toArray = ClassUtil.resolveMethod(vectorClass, "toArray");
            AbstractFloatScalar<?, ?>[] result = (AbstractFloatScalar<?, ?>[]) toArray.invoke(zero);
            assertEquals("toArray result has correct number of entries", zero.size(), result.length);
            for (int index = 0; index < result.length; index++)
            {
                assertEquals("Element in array has correct value", zeroValue[index], result[index].getSI(), 0.001);
            }
        }
    }

    /**
     * Various small experiments are done here. <br>
     * Prove (?) that order of items does not change in Arrays.stream(a).parallel().toArray().
     * @param args String[]; command line arguments; not used
     * @throws ValueException when index out of range
     */
    public static void main(final String[] args) throws ValueException
    {
        Length l = new Length(3, METER);
        Length w = new Length(2, METER);
        Area area = l.multiplyBy(w);
        System.out.println("Area is " + area);

        // Does not work (and should not work).
        // Position la = new Position(5, METER);
        // Position lb = new Position(7, METER);
        // la.multiplyBy(lb);

        // Check that Arrays.stream(.).parallel().toArray() does not affect ordering of elements
        // NB. The fact that this code finds no problem is no guarantee that this will always work.
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
