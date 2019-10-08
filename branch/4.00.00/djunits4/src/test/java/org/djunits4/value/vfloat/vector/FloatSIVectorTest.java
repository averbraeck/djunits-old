package org.djunits4.value.vfloat.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.unit.util.UnitException;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class FloatSIVectorTest
{

    /**
     * Test all "asXX" methods.
     * @throws SecurityException on error
     * @throws NoSuchMethodException on error
     * @throws InvocationTargetException on error
     * @throws IllegalArgumentException on error
     * @throws IllegalAccessException on error
     * @throws ClassNotFoundException on error
     * @throws UnitException on error
     */
    @SuppressWarnings("unchecked")
    @Test
    public <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>,
            V extends AbstractFloatVectorRel<U, S, V>> void testAsAll()
                    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
                    InvocationTargetException, ClassNotFoundException, UnitException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        float[] denseTestData = FLOATVECTOR.denseArray(50);
        AbstractFloatVectorRel<DimensionlessUnit, FloatDimensionless,
                FloatDimensionlessVector> dimlessVector = FloatVector.instantiate(
                        FloatVectorData.instantiate(denseTestData, DimensionlessUnit.SI.getScale(), StorageType.DENSE),
                        DimensionlessUnit.SI);
        dimlessVector = dimlessVector.mutable().divide(dimlessVector).asDimensionless(); // unit vector
        for (String type : CLASSNAMES.REL_ALL_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<U> unitBase = (UnitBase<U>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (U unit : unitBase.getUnitsById().values())
            {
                AbstractFloatVectorRel<U, S, V> vector = (AbstractFloatVectorRel<U, S, V>) FloatVector
                        .instantiate(FloatVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                AbstractFloatVectorRel<U, S, V> sparseVector = vector.toSparse();
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals("Value at index matches", vector.getSI(index), sparseVector.getSI(index), 0.0);
                }

                FloatSIVector mult = vector.times(dimlessVector);
                Method asMethod = FloatSIVector.class.getDeclaredMethod("as" + type);
                AbstractFloatVectorRel<U, S, V> asVector = (AbstractFloatVectorRel<U, S, V>) asMethod.invoke(mult);
                assertEquals(vector.getDisplayUnit().getStandardUnit(), asVector.getDisplayUnit());
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), vector.getSI(index),
                            asVector.getSI(index), vector.getSI(index) / 1000.0);
                }

                Method asMethodDisplayUnit = FloatSIVector.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractFloatVectorRel<U, S, V> asVectorDisplayUnit =
                        (AbstractFloatVectorRel<U, S, V>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(vector.getDisplayUnit().getStandardUnit(), asVectorDisplayUnit.getDisplayUnit());

                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), vector.getSI(index),
                            asVectorDisplayUnit.getSI(index), vector.getSI(index) / 1000.0);
                }

                // test exception for wrong 'as'
                FloatSIVector cd4sr2 = FloatSIVector.instantiate(denseTestData, SIUnit.of("cd4/sr2"), StorageType.DENSE);
                try
                {
                    AbstractFloatVectorRel<U, S, V> asVectorDim = (AbstractFloatVectorRel<U, S, V>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractFloatVectorRel<U, S, V> asVectorDim =
                            (AbstractFloatVectorRel<U, S, V>) asMethodDisplayUnit.invoke(cd4sr2, vector.getDisplayUnit());
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }
            }
        }
    }
}
