package org.djunits4.value.vdouble.vector;

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
import org.djunits4.value.vdouble.scalar.Dimensionless;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class DoubleSIVectorTest
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
    public <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>,
            V extends AbstractDoubleVectorRel<U, S, V>> void testAsAll()
                    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
                    InvocationTargetException, ClassNotFoundException, UnitException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        double[] denseTestData = DOUBLEVECTOR.denseArray(50);
        AbstractDoubleVectorRel<DimensionlessUnit, Dimensionless,
                DimensionlessVector> dimlessVector = DoubleVector.instantiate(
                        DoubleVectorData.instantiate(denseTestData, DimensionlessUnit.SI.getScale(), StorageType.DENSE),
                        DimensionlessUnit.SI);
        dimlessVector = dimlessVector.mutable().divide(dimlessVector).asDimensionless(); // unit matrix
        for (String type : CLASSNAMES.REL_ALL_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<U> unitBase = (UnitBase<U>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (U unit : unitBase.getUnitsById().values())
            {
                AbstractDoubleVectorRel<U, S, V> matrix = (AbstractDoubleVectorRel<U, S, V>) DoubleVector
                        .instantiate(DoubleVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                SIVector mult = matrix.times(dimlessVector);
                Method asMethod = SIVector.class.getDeclaredMethod("as" + type);
                AbstractDoubleVectorRel<U, S, V> asVector = (AbstractDoubleVectorRel<U, S, V>) asMethod.invoke(mult);
                assertEquals(matrix.getDisplayUnit().getStandardUnit(), asVector.getDisplayUnit());
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), matrix.getSI(index),
                            asVector.getSI(index), matrix.getSI(index) / 1000.0);
                }

                Method asMethodDisplayUnit = SIVector.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractDoubleVectorRel<U, S, V> asVectorDisplayUnit =
                        (AbstractDoubleVectorRel<U, S, V>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(matrix.getDisplayUnit().getStandardUnit(), asVectorDisplayUnit.getDisplayUnit());

                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), matrix.getSI(index),
                            asVectorDisplayUnit.getSI(index), matrix.getSI(index) / 1000.0);
                }

                // test exception for wrong 'as'
                SIVector cd4sr2 = SIVector.instantiate(denseTestData, SIUnit.of("cd4/sr2"), StorageType.DENSE);
                try
                {
                    AbstractDoubleVectorRel<U, S, V> asVectorDim = (AbstractDoubleVectorRel<U, S, V>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractDoubleVectorRel<U, S, V> asVectorDim =
                            (AbstractDoubleVectorRel<U, S, V>) asMethodDisplayUnit.invoke(cd4sr2, matrix.getDisplayUnit());
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