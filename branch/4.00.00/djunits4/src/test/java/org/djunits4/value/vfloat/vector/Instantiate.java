package org.djunits4.value.vfloat.vector;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.LengthVector;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVector;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
import org.djunits4.value.vfloat.vector.base.FloatVector;

/**
 * Instantiate.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class Instantiate
{
    private static float[] data(final int size, final float startValue, final int firstNonZero, final int zeroRangeLength)
    {
        float[] result = new float[size];
        for (int index = firstNonZero; index < size; index += zeroRangeLength + 1)
        {
            result[index] = index - firstNonZero + startValue;
        }
        return result;
    }

    public static void testList()
    {
        List<Length> ll = new ArrayList();
        ll.add(Length.of(1.0, "km"));
        ll.add(Length.of(2.0, "km"));
        ll.add(Length.of(3.0, "km"));
        ll.add(Length.of(5.0, "km"));
        LengthVector lv = DoubleVector.instantiateList(ll, LengthUnit.INCH, StorageType.DENSE);
        System.out.println(lv.toString(true, true));
        
        List<AbstractDoubleScalar<?, ?>> al = new ArrayList<>();
        al.add(Length.of(1.0, "km"));
        al.add(Length.of(2.0, "km"));
        al.add(Length.of(3.0, "km"));
        al.add(Length.of(5.0, "km"));
        DoubleVectorData dvd = DoubleVectorData.instantiateList(al, StorageType.DENSE);
        AbstractDoubleVector<?, ?, ?> av = DoubleVector.instantiateAnonymous(dvd, LengthUnit.INCH);
        System.out.println(av.toString(true, true));
    }

    /**
     * Test that the toString method returns something sensible.
     */
    public static final void toStringAbsTest()
    {
        try
        {
            AbsoluteTemperatureUnit tempUnit = AbsoluteTemperatureUnit.KELVIN;
            float[] value = data(99, 38.0f, 2, 10);
            FloatAbsoluteTemperatureVector dv = FloatVector.instantiate(value, tempUnit, StorageType.SPARSE);
            // new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
            String result = dv.toString(true, true);
            System.out.println(result);
            assertTrue("toString result contains \" Abs \"", result.contains(" Abs "));
            assertTrue("toString result contains \"K\"", result.contains("K"));
            assertTrue("toString result starts with \"Immutable \"", result.startsWith("Immutable"));
            assertTrue("toString contains \"Sparse\"", result.contains("Sparse"));
        }
        catch (ValueRuntimeException ve)
        {
            fail("Caught unexpected exception: " + ve.toString());
        }
    }

    /**
     * @param args args
     */
    public static void main(String[] args)
    {
        // toStringAbsTest();
        testList();
    }

}
