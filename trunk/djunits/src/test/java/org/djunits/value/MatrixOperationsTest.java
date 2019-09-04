package org.djunits.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.djunits.unit.UNITS;
import org.djunits.unit.Unit;
import org.djunits.unit.unitsystem.UnitSystem;
import org.djunits.util.ClassUtil;
import org.djunits.value.vdouble.matrix.AbstractDoubleMatrix;
import org.djunits.value.vdouble.matrix.DoubleMatrixInterface;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalar;
import org.djunits.value.vdouble.scalar.Area;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vfloat.matrix.AbstractFloatMatrix;
import org.djunits.value.vfloat.matrix.FloatMatrixInterface;
import org.djunits.value.vfloat.scalar.AbstractFloatScalar;
import org.djunits.value.vfloat.scalar.FloatScalar;
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
 * @param <TypedDoubleMatrixAbs> Type of the object to perform the test on
 */
public class MatrixOperationsTest<TypedDoubleMatrixAbs> implements UNITS
{
    /** The classes that are absolute (name = class name). */
    public static final String[] CLASSNAMES_ABS = new String[] {"AbsoluteTemperature", "Direction", "Position", "Time"};

    /** The relative classes that mirror the absolute ones (name = class name). */
    public static final String[] CLASSNAMES_ABS_REL = new String[] {"Temperature", "Angle", "Length", "Duration"};

    /** The classes that are just relative (name = class name). */
    public static final String[] CLASSNAMES_REL = new String[] {"Angle", "Acceleration", "AngleSolid", "Area", "Density",
            "Dimensionless", "Duration", "ElectricalCharge", "ElectricalCurrent", "ElectricalPotential", "ElectricalResistance",
            "Energy", "FlowMass", "FlowVolume", "Force", "Frequency", "Length", "LinearDensity", "Mass", "Power", "Pressure",
            "Speed", "Temperature", "Torque", "Volume"};

    /** The money classes that are just relative (name = class name); these classes don't have an si field. */
    public static final String[] CLASSNAMES_MONEY = new String[] {"Money", "MoneyPerArea", "MoneyPerEnergy", "MoneyPerLength",
            "MoneyPerMass", "MoneyPerDuration", "MoneyPerVolume"};

    /**
     * Perform many tests on the double and float matrix types.
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
    public final void matrixOperationsTest()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException, ValueException
    {
        doubleOrFloatMatrixOperationsTest(true); // Double precision versions
        doubleOrFloatMatrixOperationsTest(false); // Float versions
    }

    /**
     * Perform many tests on matrix types.
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
    private void doubleOrFloatMatrixOperationsTest(final boolean doubleType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, ClassNotFoundException, ValueException
    {
        final String upperMatrixType = "Matrix";
        final String floatPrefix = doubleType ? "" : "Float";
        String doubleOrFloat = doubleType ? "double" : "float";
        for (boolean mutable : new boolean[] {false, true})
        {
            for (StorageType storageType : StorageType.values())
            {
                // get the interfaces such as org.djunits.value.vdouble.matrix.Time
                for (int i = 0; i < CLASSNAMES_ABS.length; i++)
                {
                    String matrixNameAbs = CLASSNAMES_ABS[i];
                    Class<?> matrixClassAbs = null;
                    String classNameAbs = "org.djunits.value.v" + doubleOrFloat + ".matrix." + (mutable ? "Mutable" : "")
                            + floatPrefix + matrixNameAbs + upperMatrixType;
                    System.out.println("Looking up class " + classNameAbs);
                    matrixClassAbs = Class.forName(classNameAbs);
                    Class<?> matrixClassRel = null;

                    String matrixNameRel = CLASSNAMES_ABS_REL[i];
                    String classNameRel = "org.djunits.value.v" + doubleOrFloat + ".matrix." + (mutable ? "Mutable" : "")
                            + floatPrefix + matrixNameRel + upperMatrixType;
                    matrixClassRel = Class.forName(classNameRel);

                    testMethods(matrixClassAbs, true, doubleType, storageType, mutable);
                    testMethods(matrixClassRel, false, doubleType, storageType, mutable);
                    // testAbsRelConversion(matrixClass, true, doubleType, StorageType.DENSE);
                    // testAbsRelConversion(matrixClass, true, doubleType, StorageType.SPARSE);
                }
                // get the interfaces such as org.djunits.value.vXXXX.matrix.Area
                for (String matrixName : CLASSNAMES_REL)
                {
                    String matrixClassName = (doubleType ? "" : "Float") + matrixName;
                    String fullClassName = "org.djunits.value.v" + doubleOrFloat + ".matrix." + (mutable ? "Mutable" : "")
                            + matrixClassName + "Matrix";
                    Class<?> matrixClass = null;
                    matrixClass = Class.forName(fullClassName);
                    testMethods(matrixClass, false, doubleType, storageType, mutable);
                }
                // get the interfaces such as org.djunits.value.vXXXX.scalar.MoneyPerArea
                for (String matrixName : CLASSNAMES_MONEY)
                {
                    String matrixClassName = doubleType ? matrixName : "Float" + matrixName;
                    String fullClassName = "org.djunits.value.v" + doubleOrFloat + ".matrix." + (mutable ? "Mutable" : "")
                            + matrixClassName + "Matrix";
                    Class<?> matrixClass = null;
                    matrixClass = Class.forName(fullClassName);
                    testMethods(matrixClass, false, doubleType, storageType, mutable);
                }
            }
        }
    }

    /**
     * Find the methods defined in the class itself (not in a superclass) called multiplyBy or divideBy and test the method.
     * Also test the Unary methods of the class.
     * @param matrixClassAbsRel class to test
     * @param isAbs boolean; if true; the matrixClassAbsRel must be absolute; if false; the matrixClassAbsRel must be Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false perform tests on FloatScalar
     * @param storageType StorageType; DENSE or SPARSE
     * @param mutable boolean; if true; the matrixClass should be mutable; if false; the matrixClass should not be mutable
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws ClassNotFoundException on reflection error
     * @throws ValueException whhen index out of range
     */
    private void testMethods(final Class<?> matrixClassAbsRel, final boolean isAbs, final boolean doubleType,
            final StorageType storageType, final boolean mutable) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        // System.out.print(listMethods(matrixClassAbsRel, "multiplyBy", "\t"));
        for (Method method : matrixClassAbsRel.getMethods())
        {
            // System.out.println("Method name is " + method.getName());
            if (method.getName().equals("multiplyBy"))
            {
                testMultiplyByOrDivideByMethod(matrixClassAbsRel, method, true, doubleType, isAbs, storageType);
            }
            else if (method.getName().equals("divideBy"))
            {
                testMultiplyByOrDivideByMethod(matrixClassAbsRel, method, false, doubleType, isAbs, storageType);
            }
        }
        testConstructors(matrixClassAbsRel, isAbs, doubleType, mutable, storageType);
        testGet(matrixClassAbsRel, isAbs, doubleType, mutable, storageType);
        testUnaryMethods(matrixClassAbsRel, isAbs, doubleType, mutable, storageType);
        testInterpolateMethod(matrixClassAbsRel, isAbs, doubleType, storageType);
    }

    /**
     * Test a multiplication method for a Relative matrix. Note: filter out the method that multiplies by a constant...
     * @param matrixClass Class&lt;?&gt;; the Relative class for the multiplication, e.g. Length
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
    private void testMultiplyByOrDivideByMethod(final Class<?> matrixClass, final Method method, final boolean multiply,
            final boolean doubleType, final boolean abs, final StorageType storageType)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException, ValueException
    {
        // System.out.println(method.getName() + paramsToString(method.getParameterTypes()));
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            fail("DoubleScalar class " + matrixClass.getName() + "." + method.getName() + "() has " + parTypes.length
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
        // It is quite possible that multiplyBy will be restricted to Dimensionless matrix arguments.
        if (!matrixClass.isAssignableFrom(parameterClass))
        {
            return;
        }

        Class<?> returnClass = method.getReturnType();
        if (!matrixClass.isAssignableFrom(returnClass))
        {
            Assert.fail("DoubleScalar class " + matrixClass.getName()
                    + ".multiplyBy() has return type with incompatible class: " + returnClass.getName());
        }

        // get the SI coefficients of the unit classes, scalar type, parameter type and return type
        String returnSI = getCoefficients(getUnitClass(returnClass));
        String scalarSI = getCoefficients(getUnitClass(matrixClass));
        String paramSI = getCoefficients(getUnitClass(parameterClass));
        // print what we just have found
        System.out.println(matrixClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + "."
                + (multiply ? "multiplyBy" : "divideBy") + "("
                + parameterClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ") => "
                + returnClass.getName().replaceFirst("org.djunits.value.vdouble.scalar.", "") + ": " + scalarSI
                + (multiply ? " * " : " : ") + paramSI + " => " + returnSI);

        Constructor<?> constructor = matrixClass.getConstructor(double.class, getUnitClass(matrixClass));
        if (doubleType)
        {
            DoubleScalar.Rel<?> left =
                    (DoubleScalar.Rel<?>) constructor.newInstance(123d, getSIUnitInstance(getUnitClass(matrixClass)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            DoubleScalar.Rel<?> right =
                    (DoubleScalar.Rel<?>) constructor.newInstance(456d, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            double expectedValue = multiply ? 123d * 456 : 123d / 456;

            if (multiply)
            {
                Method multiplyMethod = matrixClass.getDeclaredMethod("multiplyBy", new Class[] {parameterClass});
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((DoubleScalar.Rel<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = matrixClass.getDeclaredMethod("divideBy", new Class[] {parameterClass});
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
                    (FloatScalar.Rel<?>) constructor.newInstance(123f, getSIUnitInstance(getUnitClass(matrixClass)));
            // System.out.println("constructed left: " + left);
            constructor = parameterClass.getConstructor(double.class, getUnitClass(parameterClass));
            FloatScalar.Rel<?> right =
                    (FloatScalar.Rel<?>) constructor.newInstance(456f, getSIUnitInstance(getUnitClass(parameterClass)));
            // System.out.println("constructed right: " + right);
            float expectedValue = multiply ? 123f * 456 : 123f / 456;

            if (multiply)
            {
                Method multiplyMethod = matrixClass.getDeclaredMethod("multiplyBy", new Class[] {parameterClass});
                Object result = multiplyMethod.invoke(left, right);
                double resultSI = ((FloatScalar.Rel<?>) result).si;
                assertEquals("Result of operation", expectedValue, resultSI, 0.01);
            }
            else
            {
                Method divideMethod = matrixClass.getDeclaredMethod("divideBy", new Class[] {parameterClass});
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
        // TODO: Check for BASE field in absolutes, SI field in relatives
        Field si = null;
        try
        {
            si = clas.getField("SI");
        }
        catch (NoSuchFieldException nsfe)
        {
            si = clas.getField("BASE");
        }
        return ((Unit<?>) si.get(clas));
    }

    /**
     * Get the unit of a Scalar class by looking at the constructor with two arguments -- the second argument is the unit type.
     * @param matrixClass the class to find the unit for
     * @return the unit class for this scalar class
     */
    private Class<?> getUnitClass(final Class<?> matrixClass)
    {
        Constructor<?>[] constructors = matrixClass.getConstructors();
        for (Constructor<?> constructor : constructors)
        {
            Class<?>[] parTypes = constructor.getParameterTypes();
            // System.out.print("Found constructor " + matrixClass + "(");
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
        Assert.fail("Could not find constructor with a unit as 2nd argument for Matrix class " + matrixClass.getName());
        return null;
    }

    /**
     * Verify the Absoluteness, Relativeness, and SI values of a DoubleMatrix or FloatMatrix.
     * @param abs boolean; expected Absolute- or Relative-ness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param storageType StorageType; DENSE or SPARSE
     * @param got the (DoubleMatrix?) object
     * @param expected double[] or float[] with expected values
     * @param precision double; maximum error of the results
     * @throws ValueException when index out of range
     */
    private void verifyAbsRelPrecisionAndValues(final boolean abs, final boolean doubleType, final StorageType storageType,
            final Object got, final Object expected, final double precision) throws ValueException
    {
        int height = doubleType ? ((double[][]) expected).length : ((float[][]) expected).length;
        int refSize = doubleType ? ((double[][]) expected).length : ((float[][]) expected).length;
        assertEquals("size of resulting array", refSize, height);
        int width = doubleType ? ((double[][]) expected)[0].length : ((float[][]) expected)[0].length;
        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < width; col++)
            {
                double result = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, got, row, col);
                assertEquals("value check", doubleType ? ((double[][]) expected)[row][col] : ((float[][]) expected)[row][col],
                        result, precision);
            }
        }
    }

    /**
     * Verify the Absoluteness or Relativeness of a DoubleScalar and return the SI value.
     * @param abs boolean; expected Absolute- or Relativeness
     * @param doubleType boolean; if true; double is expected; if false; float is expected
     * @param storageType StorageType; the expected StorageType (DENSE or SPARSE)
     * @param o the (DoubleScalar?) object
     * @param row int; row of the value to return
     * @param col int; column of the value to return
     * @return double; the SI value
     * @throws ValueException when index out of range
     */
    private double verifyAbsRelPrecisionAndExtractSI(final boolean abs, final boolean doubleType, final StorageType storageType,
            final Object o, final int row, int col) throws ValueException
    {
        double result = Double.NaN;
        if (doubleType)
        {
            if (!(o instanceof DoubleMatrixInterface))
            {
                fail("object is not a DoubleMatrix");
            }
            AbstractDoubleMatrix<?, ?> dv = (AbstractDoubleMatrix<?, ?>) o;
            result = dv.getSI(row, col);
            assertEquals("StorageType", storageType, dv.getStorageType());
        }
        else
        {
            if (!(o instanceof FloatMatrixInterface))
            {
                fail("object is not a FloatMatrix");
            }
            AbstractFloatMatrix<?, ?> fv = (AbstractFloatMatrix<?, ?>) o;
            result = fv.getSI(row, col);
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
     * @param matrixClass the class to test
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
    private void testConstructors(final Class<?> matrixClass, final boolean abs, final boolean doubleType,
            final boolean mutable, final StorageType storageType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[][] doubleValue = {{1.23456, 2.34567, 3.45678}, {4.56789, 5.67890, 6.78901}};
        float[][] floatValue = {{1.23456f, 2.34567f, 3.45678f}, {4.56789f, 5.67890f, 6.78901f}};
        Object value = doubleType ? doubleValue : floatValue;
        findAndTestConstructor(matrixClass, new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType},
                abs, doubleType, storageType, value);
        // What is the corresponding Scalar type?
        String scalarClassName = matrixClass.getName();
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("Matrix", "");
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("matrix", "scalar");
        // System.out.println("name is " + scalarClassName);
        scalarClassName = scalarClassName.replaceFirst("Mutable", "");
        // System.out.println("name is " + scalarClassName);
        Class<?> scalarClassAbsRel = Class.forName(scalarClassName);
        // System.out.println("class is " + scalarClassAbsRel);
        if (doubleType)
        {
            Constructor<?> constructor =
                    scalarClassAbsRel.getConstructor(new Class<?>[] {double.class, getUnitClass(matrixClass)});
            // Construct a matrix of the correct scalar objects
            Object[][] objectArray =
                    (Object[][]) Array.newInstance(scalarClassAbsRel, doubleValue.length, doubleValue[0].length);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    objectArray[row][col] =
                            constructor.newInstance(doubleValue[row][col], getSIUnitInstance(getUnitClass(matrixClass)));
                }
            }
            findAndTestConstructor(matrixClass, new Object[] {objectArray, storageType}, abs, doubleType, storageType, value);
        }
        else
        {
            Constructor<?> constructor =
                    scalarClassAbsRel.getConstructor(new Class<?>[] {float.class, getUnitClass(matrixClass)});
            // Construct a matrix of the correct scalar objects
            Object[][] objectArray = (Object[][]) Array.newInstance(scalarClassAbsRel, floatValue.length, floatValue[0].length);
            for (int row = 0; row < floatValue.length; row++)
            {
                for (int col = 0; col < floatValue[row].length; col++)
                {
                    objectArray[row][col] =
                            constructor.newInstance(floatValue[row][col], getSIUnitInstance(getUnitClass(matrixClass)));
                }
            }
            findAndTestConstructor(matrixClass, new Object[] {objectArray, storageType}, abs, doubleType, storageType, value);
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
     * @param matrixClass Class&lt;?&gt;; the class to which the constructor belongs
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
    private Object findAndExecuteConstructor(final Class<?> matrixClass, final Object[] args, final boolean doubleType)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ValueException
    {
        Class<?>[] parameterTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++)
        {
            Class<?> c = args[i].getClass();
            if (c.isAssignableFrom(double[][].class))
            {
                c = double[][].class;
            }
            else if (c.isAssignableFrom(float[][].class))
            {
                c = float[][].class;
            }
            parameterTypes[i] = c;
            // System.out.println("parameter type[" + i + "] is " + c);
        }
        Constructor<?> constructor = null;
        for (Constructor<?> c : matrixClass.getConstructors())
        {
            // System.out.println("Found constructor for " + matrixClass + " " + paramsToString(c.getParameterTypes()));
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
        // Constructor<?> constructor = matrixClass.getConstructor(parameterTypes);
        if (null == constructor)
        {
            System.out.println("No suitable constructor for " + matrixClass + ":");
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
     * @param matrixClass Class&lt;?&gt;; the class to which the constructor belongs
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
    private void findAndTestConstructor(final Class<?> matrixClass, final Object[] args, final boolean abs,
            final boolean doubleType, final StorageType expectedStorageType, final Object expectedResult)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ValueException
    {
        verifyAbsRelPrecisionAndValues(abs, doubleType, expectedStorageType,
                findAndExecuteConstructor(matrixClass, args, doubleType), expectedResult, 0.0001);
    }

    /**
     * Test the get method.
     * @param matrixClass the class to test
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
    private void testGet(final Class<?> matrixClass, final boolean abs, final boolean doubleType, final boolean mutable,
            final StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[][] doubleValue = {{1.23456, 2.34567, 3.45678}, {4.56789, 5.67890, 6.78901}};
        float[][] floatValue = {{1.23456f, 2.34567f, 3.45678f}, {4.56789f, 5.67890f, 6.78901f}};
        Object value = doubleType ? doubleValue : floatValue;
        Object matrix = findAndExecuteConstructor(matrixClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
        if (doubleType)
        {
            AbstractDoubleMatrix<?, ?> dv = (AbstractDoubleMatrix<?, ?>) matrix;
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    AbstractDoubleScalar<?, ?> ds = dv.get(row, col);
                    double got = ds.getSI();
                    assertEquals("get returns expected value", doubleValue[row][col], got, 0.0001);
                }
            }
        }
        else
        {
            AbstractFloatMatrix<?, ?> fv = (AbstractFloatMatrix<?, ?>) matrix;
            for (int row = 0; row < floatValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    AbstractFloatScalar<?, ?> fs = fv.get(row, col);
                    float got = fs.getSI();
                    assertEquals("get returns expected value", doubleValue[row][col], got, 0.0001);
                }
            }
        }
    }

    /**
     * @param matrixClass the class to test
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
    private void testUnaryMethods(final Class<?> matrixClass, final boolean abs, final boolean doubleType,
            final boolean mutable, final StorageType storageType) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ValueException
    {
        double[][] doubleValue = {{1.23456, 2.34567, 3.45678}, {4.56789, 5.67890, 6.78901}};
        float[][] floatValue = {{1.23456f, 2.34567f, 3.45678f}, {4.56789f, 5.67890f, 6.78901f}};
        Object value = doubleType ? doubleValue : floatValue;
        Object left = findAndExecuteConstructor(matrixClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
        Object result;
        if (doubleType)
        {
            result = ((DoubleMatrixInterface<?>) left).toSparse();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.SPARSE, result, value, 0.0001);
            result = ((DoubleMatrixInterface<?>) left).toDense();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.DENSE, result, value, 0.0001);
            // TODO not complete; see VectorOperationsTest
        }
        else
        {
            result = ((FloatMatrixInterface<?>) left).toSparse();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.SPARSE, result, value, 0.0001);
            result = ((FloatMatrixInterface<?>) left).toDense();
            verifyAbsRelPrecisionAndValues(abs, doubleType, StorageType.DENSE, result, value, 0.0001);
            // TODO not complete; see VectorOperationsTest
        }

        if (mutable)
        {
            double doubleDifference = 42.42;
            float floatDifference = 42.42f;
            Class<?> argumentClass = doubleType ? double.class : float.class;
            Method incrementBy = ClassUtil.resolveMethod(matrixClass, "incrementBy", new Class<?>[] {argumentClass});
            incrementBy = ClassUtil.resolveMethod(matrixClass, "incrementBy", new Class<?>[] {argumentClass});
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
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    double resultElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col);
                    assertEquals("value check result",
                            doubleType ? (doubleValue[row][col] + doubleDifference) : (floatValue[row][col] + floatDifference),
                            resultElement, 0.00001);
                    // Check that original is also modified
                    double originalElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col);
                    assertEquals("value check original",
                            doubleType ? (doubleValue[row][col] + doubleDifference) : (floatValue[row][col] + floatDifference),
                            originalElement, 0.00001);
                }
            }
            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            Method decrementBy = ClassUtil.resolveMethod(matrixClass, "decrementBy", new Class<?>[] {argumentClass});
            decrementBy.setAccessible(true);
            if (doubleType)
            {
                result = decrementBy.invoke(left, new Object[] {doubleDifference});
            }
            else
            {
                result = decrementBy.invoke(left, new Object[] {floatDifference});
            }
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    double resultElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col);
                    assertEquals("value check",
                            doubleType ? (doubleValue[row][col] - doubleDifference) : (floatValue[row][col] - floatDifference),
                            resultElement, 0.00001);
                    // Check that original is also modified
                    double originalElement = verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col);
                    assertEquals("value check original",
                            doubleType ? (doubleValue[row][col] - doubleDifference) : (floatValue[row][col] - floatDifference),
                            originalElement, 0.00001);
                }
            }

            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            Method mathMethod = ClassUtil.resolveMethod(matrixClass, "ceil", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.ceil(doubleValue[row][col]) : ((float) Math.ceil(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.ceil(doubleValue[row][col]) : ((float) Math.ceil(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }

            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(matrixClass, "floor", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.floor(doubleValue[row][col]) : ((float) Math.floor(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.floor(doubleValue[row][col]) : ((float) Math.floor(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }

            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(matrixClass, "rint", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.rint(doubleValue[row][col]) : ((float) Math.rint(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.rint(doubleValue[row][col]) : ((float) Math.rint(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }

            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            mathMethod = ClassUtil.resolveMethod(matrixClass, "round", new Class[] {});
            mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
            result = mathMethod.invoke(left);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation",
                            doubleType ? Math.round(doubleValue[row][col]) : ((float) Math.round(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation",
                            doubleType ? Math.round(doubleValue[row][col]) : ((float) Math.round(doubleValue[row][col])),
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }

            if (!abs)
            {
                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "abs", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.abs(doubleValue[row][col]) : ((float) Math.abs(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.abs(doubleValue[row][col]) : ((float) Math.abs(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }
            }

            if (matrixClass.getName().contains("Dimensionless"))
            {
                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "acos", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.acos(doubleValue[row][col]) : ((float) Math.acos(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.acos(doubleValue[row][col]) : ((float) Math.acos(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "asin", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.asin(doubleValue[row][col]) : ((float) Math.asin(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.asin(doubleValue[row][col]) : ((float) Math.asin(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "atan", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.atan(doubleValue[row][col]) : ((float) Math.atan(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.atan(doubleValue[row][col]) : ((float) Math.atan(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "cbrt", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.cbrt(doubleValue[row][col]) : ((float) Math.cbrt(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.cbrt(doubleValue[row][col]) : ((float) Math.cbrt(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "cos", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.cos(doubleValue[row][col]) : ((float) Math.cos(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.cos(doubleValue[row][col]) : ((float) Math.cos(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "cosh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.cosh(doubleValue[row][col]) : ((float) Math.cosh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.cosh(doubleValue[row][col]) : ((float) Math.cosh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "exp", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.exp(doubleValue[row][col]) : ((float) Math.exp(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.exp(doubleValue[row][col]) : ((float) Math.exp(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "expm1", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.expm1(doubleValue[row][col]) : ((float) Math.expm1(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.expm1(doubleValue[row][col]) : ((float) Math.expm1(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "log", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.log(doubleValue[row][col]) : ((float) Math.log(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.log(doubleValue[row][col]) : ((float) Math.log(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "log10", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.log10(doubleValue[row][col]) : ((float) Math.log10(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.log10(doubleValue[row][col]) : ((float) Math.log10(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "log1p", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.log1p(doubleValue[row][col]) : ((float) Math.log1p(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.log1p(doubleValue[row][col]) : ((float) Math.log1p(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "signum", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.signum(doubleValue[row][col]) : ((float) Math.signum(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.signum(doubleValue[row][col]) : ((float) Math.signum(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "sin", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.sin(doubleValue[row][col]) : ((float) Math.sin(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.sin(doubleValue[row][col]) : ((float) Math.sin(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "sinh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.sinh(doubleValue[row][col]) : ((float) Math.sinh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.sinh(doubleValue[row][col]) : ((float) Math.sinh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "sqrt", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.sqrt(doubleValue[row][col]) : ((float) Math.sqrt(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.sqrt(doubleValue[row][col]) : ((float) Math.sqrt(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "tan", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.tan(doubleValue[row][col]) : ((float) Math.tan(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.tan(doubleValue[row][col]) : ((float) Math.tan(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "tanh", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? Math.tanh(doubleValue[row][col]) : ((float) Math.tanh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? Math.tanh(doubleValue[row][col]) : ((float) Math.tanh(doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "inv", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                result = mathMethod.invoke(left);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? (1.0 / doubleValue[row][col]) : ((float) (1.0 / doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        // Check that original is also modified
                        assertEquals("Result of operation",
                                doubleType ? (1.0 / doubleValue[row][col]) : ((float) (1.0 / doubleValue[row][col])),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                for (double power : new double[] {-3, -Math.PI, -1, -0.5, 0, 0.5, 1, Math.PI, 3})
                {
                    left = findAndExecuteConstructor(matrixClass,
                            new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                    mathMethod = ClassUtil.resolveMethod(matrixClass, "pow", new Class[] {double.class});
                    mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                    result = mathMethod.invoke(left, power);
                    for (int row = 0; row < doubleValue.length; row++)
                    {
                        for (int col = 0; col < doubleValue[row].length; col++)
                        {
                            assertEquals("Result of operation",
                                    doubleType ? Math.pow(doubleValue[row][col], power)
                                            : ((float) Math.pow(doubleValue[row][col], power)),
                                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                            // Check that original is also modified
                            assertEquals("Result of operation",
                                    doubleType ? Math.pow(doubleValue[row][col], power)
                                            : ((float) Math.pow(doubleValue[row][col], power)),
                                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                        }
                    }
                }

                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                mathMethod = ClassUtil.resolveMethod(matrixClass, "normalize", new Class[] {});
                mathMethod.setAccessible(true); // because MutableTyped classes are package protected...
                mathMethod.invoke(left);
                double sum = 0;
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (double v : doubleValue[row])
                    {
                        sum += v;
                    }
                }
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of operation",
                                doubleType ? (doubleValue[row][col] / sum) : ((float) (doubleValue[row][col] / sum)),
                                verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                    }
                }

                double[][] doubleZeroZSum = {{-4, 4, -1, 1, 0}, {5, 0, 0, 0, -5}};
                float[][] floatZeroZSum = {{-4, 4, -1, 1, 0}, {5, 0, 0, 0, -5}};
                Object zeroZSumValue = doubleType ? doubleZeroZSum : floatZeroZSum;
                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {zeroZSumValue, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
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

        left = findAndExecuteConstructor(matrixClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
        if (mutable)
        {
            Method multiplyBy =
                    ClassUtil.resolveMethod(matrixClass, "multiplyBy", new Class[] {doubleType ? double.class : float.class});
            multiplyBy.setAccessible(true); // FIXME this should not be necessary
            if (doubleType)
            {
                result = multiplyBy.invoke(left, Math.PI);
            }
            else
            {
                result = multiplyBy.invoke(left, (float) Math.PI);
            }
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation", doubleValue[row][col] * Math.PI,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation", doubleValue[row][col] * Math.PI,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }
            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            Method divideBy =
                    ClassUtil.resolveMethod(matrixClass, "divideBy", new Class[] {doubleType ? double.class : float.class});
            divideBy.setAccessible(true); // FIXME this should not be necessary
            if (doubleType)
            {
                result = divideBy.invoke(left, Math.PI);
            }
            else
            {
                result = divideBy.invoke(left, (float) Math.PI);
            }
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of operation", doubleValue[row][col] / Math.PI,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                    // Check that original is also modified
                    assertEquals("Result of operation", doubleValue[row][col] / Math.PI,
                            verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, left, row, col), 0.01);
                }
            }
        }
        Object compatibleRight = null;
        Object compatibleRel = null;
        // TODO: Probably we exclude too much here for the tests...
        if (!matrixClass.getName().contains("Money") && !matrixClass.getName().contains("Dimensionless")
                && !matrixClass.getName().contains("Temperature") && !matrixClass.getName().contains("Position")
                && !matrixClass.getName().contains("Time") && !matrixClass.getName().contains("Direction"))
        {
            // Construct a new unit to test mixed unit plus and minus
            Class<?> unitClass = getUnitClass(matrixClass);
            UnitSystem unitSystem = UnitSystem.SI_DERIVED;
            Unit<?> referenceUnit;
            // Call the getUnit method of left
            Method getUnitMethod = ClassUtil.resolveMethod(matrixClass, "getUnit");
            referenceUnit = (Unit<?>) getUnitMethod.invoke(left);
            Constructor<?> unitConstructor =
                    unitClass.getConstructor(String.class, String.class, UnitSystem.class, unitClass, double.class);
            Object newUnit = unitConstructor.newInstance("7fullName", "7abbr", unitSystem, referenceUnit, 7d);
            // System.out.println("new unit prints like " + newUnit);
            compatibleRight = findAndExecuteConstructor(matrixClass, new Object[] {value, newUnit, storageType}, doubleType);
            // System.out.println("compatibleRight prints like \"" + compatibleRight + "\"");
            if (abs)
            {
                String className = matrixClass.getName();
                for (int i = 0; i < CLASSNAMES_ABS.length; i++)
                {
                    className = className.replaceAll(CLASSNAMES_ABS[i], CLASSNAMES_ABS_REL[i]);
                }
                Class<?> relClass = Class.forName(className);
                compatibleRel = findAndExecuteConstructor(relClass, new Object[] {value, newUnit, storageType}, doubleType);
                // System.out.println("compatibleRel prints like \"" + compatibleRight + "\"");
            }
        }
        if (null != compatibleRight)
        {
            left = findAndExecuteConstructor(matrixClass,
                    new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
            // System.out.print(listMethods(matrixClass, "plus", "\t"));
            // System.out.println("Mutable is " + mutable);
            if (!mutable)
            { // FIXME: should also work for mutable and mix of mutable and immutable
              // System.out.println("Type of right is " + compatibleRight.getClass());
                if (!abs)
                {
                    Method plus = ClassUtil.resolveMethod(matrixClass, "plus",
                            new Class<?>[] {compatibleRight.getClass().getSuperclass()});
                    plus.setAccessible(true);
                    result = plus.invoke(left, compatibleRight);
                    for (int row = 0; row < doubleValue.length; row++)
                    {
                        for (int col = 0; col < doubleValue[row].length; col++)
                        {
                            assertEquals("Result of mixed operation", 8 * doubleValue[row][col],
                                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        }
                    }
                }
                if (null != compatibleRel)
                {
                    // System.out.print(listMethods(matrixClass, "plus", "\t"));
                    // System.out.println("Type of rel is " + compatibleRel.getClass());
                    Method plus = ClassUtil.resolveMethod(matrixClass, "plus",
                            new Class<?>[] {compatibleRel.getClass().getSuperclass()});
                    plus.setAccessible(true);
                    result = plus.invoke(left, compatibleRel);
                    for (int row = 0; row < doubleValue.length; row++)
                    {
                        for (int col = 0; col < doubleValue[row].length; col++)
                        {
                            assertEquals("Result of mixed operation", 8 * doubleValue[row][col],
                                    verifyAbsRelPrecisionAndExtractSI(abs, doubleType, storageType, result, row, col), 0.01);
                        }
                    }
                }
            }
        }
        left = findAndExecuteConstructor(matrixClass,
                new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
        if (!mutable)
        {
            // System.out.print(listMethods(matrixClass, "minus", "\t"));
            Method minus = ClassUtil.resolveMethod(matrixClass, "minus", new Class[] {matrixClass.getSuperclass()});
            minus.setAccessible(true);
            result = minus.invoke(left, left);
            for (int row = 0; row < doubleValue.length; row++)
            {
                for (int col = 0; col < doubleValue[row].length; col++)
                {
                    assertEquals("Result of minus", 0,
                            verifyAbsRelPrecisionAndExtractSI(false, doubleType, storageType, result, row, col), 0.01);
                }
            }
            if (null != compatibleRight)
            {
                left = findAndExecuteConstructor(matrixClass,
                        new Object[] {value, getSIUnitInstance(getUnitClass(matrixClass)), storageType}, doubleType);
                result = minus.invoke(left, compatibleRight);
                for (int row = 0; row < doubleValue.length; row++)
                {
                    for (int col = 0; col < doubleValue[row].length; col++)
                    {
                        assertEquals("Result of minus with compatible arg", -6 * doubleValue[row][col],
                                verifyAbsRelPrecisionAndExtractSI(false, doubleType, storageType, result, row, col), 0.01);
                    }
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
     * @param matrixClass Class&lt;?&gt;; the class to test
     * @param abs boolean; if true; matrixClass is Absolute; if false; matrixClass is Relative
     * @param doubleType boolean; if true; perform tests on DoubleScalar; if false; perform tests on FloatScalar
     * @param storageType StorageType; DENSE or SPARSE
     * @throws NoSuchMethodException on class or method resolving error
     * @throws NoSuchFieldException on class or method resolving error
     * @throws InvocationTargetException on class or method resolving error
     * @throws IllegalAccessException on class or method resolving error
     * @throws InstantiationException on class or method resolving error
     * @throws ValueException when index out of range
     */
    private void testInterpolateMethod(final Class<?> matrixClass, final boolean abs, final boolean doubleType,
            final StorageType storageType) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchFieldException, ValueException
    {
        // System.out.println("class name is " + matrixClass.getName());
        Constructor<?> constructor = matrixClass.getConstructor(doubleType ? double[][].class : float[][].class,
                getUnitClass(matrixClass), StorageType.class);
        if (doubleType)
        {
            double[][] zeroValue = {{1.23456, 2.45678}, {3.5678, 4.8765}};
            // AbstractDoubleMatrix<?, ?> zero =
            // abs ? (DoubleMatrix.Abs<?>) constructor.newInstance(zeroValue,
            // getSIUnitInstance(getUnitClass(matrixClass)), storageType) : (DoubleMatrix.Rel<?>) constructor
            // .newInstance(zeroValue, getSIUnitInstance(getUnitClass(matrixClass)), storageType);
            AbstractDoubleMatrix<?, ?> zero = (AbstractDoubleMatrix<?, ?>) constructor.newInstance(zeroValue,
                    getSIUnitInstance(getUnitClass(matrixClass)), storageType);
            double[][] oneValue = {{3.45678, 4.678901}, {8.654, 9.35}};
            AbstractDoubleMatrix<?, ?> one = (AbstractDoubleMatrix<?, ?>) constructor.newInstance(oneValue,
                    getSIUnitInstance(getUnitClass(matrixClass)), storageType);
            for (double ratio : new double[] {-5, -1, 0, 0.3, 1, 2, 10})
            {
                double[][] expectedResult = new double[zeroValue.length][zeroValue[0].length];
                for (int row = 0; row < expectedResult.length; row++)
                {
                    for (int col = 0; col < expectedResult[0].length; col++)
                    {
                        expectedResult[row][col] = (1.0 - ratio) * zeroValue[row][col] + ratio * oneValue[row][col];
                    }
                }
                // Method interpolate = ClassUtil.resolveMethod(matrixClass, "interpolate", matrixClass, matrixClass,
                // double.class);
                // AbstractDoubleScalar<?, ?> result;
                // result = (AbstractDoubleScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                // verifyAbsRelPrecisionAndValues(abs, doubleType, result, expectedResult, 0.01);
            }
            // Method toArray = ClassUtil.resolveMethod(matrixClass, "toArray");
            // AbstractDoubleScalar<?, ?>[][] result = (AbstractDoubleScalar<?, ?>[][]) toArray.invoke(zero);
            // assertEquals("toArray result has correct number of rows", zero.rows(), result.length);
            // assertEquals("toArray result has correct number of entries", zero.columns(), result[0].length);
            // for (int row = 0; row < result.length; row++)
            // {
            // for (int col = 0; col < result[0].length; col++)
            // {
            // assertEquals("Element in array has correct value", zeroValue[row][col], result[row][col].getSI(), 0.001);
            // }
            // }
        }
        else
        {
            float[][] zeroValue = {{1.23456f, 2.45678f}, {4.654f, 987.2f}};
            AbstractFloatMatrix<?, ?> zero = (AbstractFloatMatrix<?, ?>) constructor.newInstance(zeroValue,
                    getSIUnitInstance(getUnitClass(matrixClass)), storageType);
            float[][] oneValue = {{3.45678f, 4.678901f}, {2.222f, 3.333f}};
            AbstractFloatMatrix<?, ?> one = (AbstractFloatMatrix<?, ?>) constructor.newInstance(oneValue,
                    getSIUnitInstance(getUnitClass(matrixClass)), storageType);
            for (float ratio : new float[] {-5, -1, 0, 0.3f, 1, 2, 10})
            {
                float[][] expectedResult = new float[zeroValue.length][zeroValue[0].length];
                for (int row = 0; row < expectedResult.length; row++)
                {
                    for (int col = 0; col < expectedResult[0].length; col++)
                    {
                        expectedResult[row][col] = (float) ((1.0 - ratio) * zeroValue[row][col] + ratio * oneValue[row][col]);
                    }
                }
                // Method interpolate = ClassUtil.resolveMethod(vectorClass, "interpolate", vectorClass, vectorClass,
                // float.class);
                // AbstractFloatScalar<?, ?> result;
                // result = (AbstractFloatScalar<?, ?>) interpolate.invoke(null, zero, one, ratio);
                // verifyAbsRelPrecisionAndValues(abs, doubleType, storageType, result, expectedResult, 0.01);
            }
            // Method toArray = ClassUtil.resolveMethod(matrixClass, "toArray");
            // AbstractFloatScalar<?, ?>[][] result = (AbstractFloatScalar<?, ?>[][]) toArray.invoke(zero);
            // assertEquals("toArray result has correct number of rows", zero.rows(), result.length);
            // assertEquals("toArray result has correct number of columns", zero.columns(), result[0].length);
            // for (int row = 0; row < result.length; row++)
            // {
            // for (int col = 0; col < result[0].length; col++)
            // {
            // assertEquals("Element in array has correct value", zeroValue[row][col], result[row][col].getSI(), 0.001);
            // }
            // }
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
