package org.djunits4.value.vfloat.vector;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
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
                    //new FloatVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(value, tempUnit, StorageType.SPARSE);
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
        toStringAbsTest();
    }

}
