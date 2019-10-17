package org.djunits4.value.vdouble.matrix;

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
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.base.DoubleMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Dimensionless;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.vector.DimensionlessVector;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class DoubleSIMatrixTest
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
    public <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>, V extends AbstractDoubleVectorRel<U, S, V>,
            M extends AbstractDoubleMatrixRel<U, S, V, M>> void testAsAll()
                    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
                    InvocationTargetException, ClassNotFoundException, UnitException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        double[][] denseTestData = DOUBLEMATRIX.denseRectArrays(5, 10);
        AbstractDoubleMatrixRel<DimensionlessUnit, Dimensionless, DimensionlessVector,
                DimensionlessMatrix> dimlessMatrix = DoubleMatrix.instantiate(
                        DoubleMatrixData.instantiate(denseTestData, DimensionlessUnit.SI.getScale(), StorageType.DENSE),
                        DimensionlessUnit.SI);
        dimlessMatrix = dimlessMatrix.mutable().divide(dimlessMatrix).asDimensionless(); // unit matrix
        for (String type : CLASSNAMES.REL_ALL_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<U> unitBase = (UnitBase<U>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (U unit : unitBase.getUnitsById().values())
            {
                AbstractDoubleMatrixRel<U, S, V, M> matrix = (AbstractDoubleMatrixRel<U, S, V, M>) DoubleMatrix
                        .instantiate(DoubleMatrixData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                SIMatrix mult = matrix.times(dimlessMatrix);
                Method asMethod = SIMatrix.class.getDeclaredMethod("as" + type);
                AbstractDoubleMatrixRel<U, S, V, M> asMatrix = (AbstractDoubleMatrixRel<U, S, V, M>) asMethod.invoke(mult);
                assertEquals(matrix.getDisplayUnit().getStandardUnit(), asMatrix.getDisplayUnit());
                for (int row = 0; row < denseTestData.length; row++)
                {
                    for (int col = 0; col < denseTestData[0].length; col++)
                    {
                        assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), matrix.getSI(row, col),
                                asMatrix.getSI(row, col), matrix.getSI(row, col) / 1000.0);
                    }
                }

                Method asMethodDisplayUnit = SIMatrix.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractDoubleMatrixRel<U, S, V, M> asMatrixDisplayUnit =
                        (AbstractDoubleMatrixRel<U, S, V, M>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
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
                SIMatrix cd4sr2 = SIMatrix.instantiate(denseTestData, SIUnit.of("cd4/sr2"), StorageType.DENSE);
                try
                {
                    AbstractDoubleMatrixRel<U, S, V, M> asMatrixDim =
                            (AbstractDoubleMatrixRel<U, S, V, M>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asMatrixDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractDoubleMatrixRel<U, S, V, M> asMatrixDim =
                            (AbstractDoubleMatrixRel<U, S, V, M>) asMethodDisplayUnit.invoke(cd4sr2, matrix.getDisplayUnit());
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asMatrixDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }
                SIMatrix sim =
                        SIMatrix.of(denseTestData, unitBase.getSiDimensions().toString(true, true, true), StorageType.DENSE);
                for (int row = 0; row < denseTestData.length; row++)
                {
                    for (int col = 0; col < denseTestData[0].length; col++)
                    {
                        assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), denseTestData[row][col],
                                sim.getInUnit(row, col), 0.001);
                    }
                }
            }
        }
    }
    
}
