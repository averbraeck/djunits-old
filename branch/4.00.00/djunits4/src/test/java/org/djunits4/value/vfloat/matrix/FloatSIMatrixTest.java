package org.djunits4.value.vfloat.matrix;

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
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.base.FloatMatrix;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.FloatDimensionlessVector;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class FloatSIMatrixTest
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
    public <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>, V extends AbstractFloatVectorRel<U, S, V>,
            M extends AbstractFloatMatrixRel<U, S, V, M>> void testAsAll()
                    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
                    InvocationTargetException, ClassNotFoundException, UnitException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        float[][] denseTestData = FLOATMATRIX.denseRectArrays(5, 10);
        AbstractFloatMatrixRel<DimensionlessUnit, FloatDimensionless, FloatDimensionlessVector,
                FloatDimensionlessMatrix> dimlessMatrix = FloatMatrix.instantiate(
                        FloatMatrixData.instantiate(denseTestData, DimensionlessUnit.SI.getScale(), StorageType.DENSE),
                        DimensionlessUnit.SI);
        dimlessMatrix = dimlessMatrix.mutable().divide(dimlessMatrix).asDimensionless(); // unit matrix
        for (String type : CLASSNAMES.REL_ALL_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<U> unitBase = (UnitBase<U>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (U unit : unitBase.getUnitsById().values())
            {
                AbstractFloatMatrixRel<U, S, V, M> matrix = (AbstractFloatMatrixRel<U, S, V, M>) FloatMatrix
                        .instantiate(FloatMatrixData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                FloatSIMatrix mult = matrix.times(dimlessMatrix);
                Method asMethod = FloatSIMatrix.class.getDeclaredMethod("as" + type);
                AbstractFloatMatrixRel<U, S, V, M> asMatrix = (AbstractFloatMatrixRel<U, S, V, M>) asMethod.invoke(mult);
                assertEquals(matrix.getDisplayUnit().getStandardUnit(), asMatrix.getDisplayUnit());
                for (int row = 0; row < denseTestData.length; row++)
                {
                    for (int col = 0; col < denseTestData[0].length; col++)
                    {
                        assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), matrix.getSI(row, col),
                                asMatrix.getSI(row, col), matrix.getSI(row, col) / 1000.0);
                    }
                }

                Method asMethodDisplayUnit = FloatSIMatrix.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractFloatMatrixRel<U, S, V, M> asMatrixDisplayUnit =
                        (AbstractFloatMatrixRel<U, S, V, M>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(matrix.getDisplayUnit().getStandardUnit(), asMatrixDisplayUnit.getDisplayUnit());

                for (int row = 0; row < denseTestData.length; row++)
                {
                    for (int col = 0; col < denseTestData[0].length; col++)
                    {
                        assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), matrix.getSI(row, col),
                                asMatrixDisplayUnit.getSI(row, col), matrix.getSI(row, col) / 1000.0);
                    }
                }

                // test exception for wrong 'as'
                FloatSIMatrix cd4sr2 = FloatSIMatrix.instantiate(denseTestData, SIUnit.of("cd4/sr2"), StorageType.DENSE);
                try
                {
                    AbstractFloatMatrixRel<U, S, V, M> asMatrixDim =
                            (AbstractFloatMatrixRel<U, S, V, M>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asMatrixDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractFloatMatrixRel<U, S, V, M> asMatrixDim =
                            (AbstractFloatMatrixRel<U, S, V, M>) asMethodDisplayUnit.invoke(cd4sr2, matrix.getDisplayUnit());
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asMatrixDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }
            }
        }
    }
}
