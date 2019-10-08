package org.djunits4.value.vdouble.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.unit.AbsoluteLinearUnit;
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
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarAbs;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRelWithAbs;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRelWithAbs;
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
    public <AU extends AbsoluteLinearUnit<AU, RU>, A extends AbstractDoubleScalarAbs<AU, A, RU, R>,
            AV extends AbstractDoubleVectorAbs<AU, A, AV, RU, R, RV>, RU extends Unit<RU>,
            R extends AbstractDoubleScalarRelWithAbs<AU, A, RU, R>,
            RV extends AbstractDoubleVectorRelWithAbs<AU, A, AV, RU, R, RV>> void testAsAll()
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
        dimlessVector = dimlessVector.mutable().divide(dimlessVector).asDimensionless(); // unit vector
        for (String type : CLASSNAMES.REL_ALL_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<RU> unitBase = (UnitBase<RU>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (RU unit : unitBase.getUnitsById().values())
            {
                AbstractDoubleVectorRel<RU, R, RV> vector = (AbstractDoubleVectorRel<RU, R, RV>) DoubleVector
                        .instantiate(DoubleVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                AbstractDoubleVectorRel<RU, R, RV> sparseVector = vector.toSparse();
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals("Value at index matches", vector.getSI(index), sparseVector.getSI(index), 0.0);
                }

                SIVector mult = vector.times(dimlessVector);
                Method asMethod = SIVector.class.getDeclaredMethod("as" + type);
                AbstractDoubleVectorRel<RU, R, RV> asVector = (AbstractDoubleVectorRel<RU, R, RV>) asMethod.invoke(mult);
                assertEquals(vector.getDisplayUnit().getStandardUnit(), asVector.getDisplayUnit());
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), vector.getSI(index),
                            asVector.getSI(index), vector.getSI(index) / 1000.0);
                }

                Method asMethodDisplayUnit = SIVector.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractDoubleVectorRel<RU, R, RV> asVectorDisplayUnit =
                        (AbstractDoubleVectorRel<RU, R, RV>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(vector.getDisplayUnit().getStandardUnit(), asVectorDisplayUnit.getDisplayUnit());

                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), vector.getSI(index),
                            asVectorDisplayUnit.getSI(index), vector.getSI(index) / 1000.0);
                }

                // test exception for wrong 'as'
                SIVector cd4sr2 = SIVector.instantiate(denseTestData, SIUnit.of("cd4/sr2"), StorageType.DENSE);
                try
                {
                    AbstractDoubleVectorRel<RU, R, RV> asVectorDim =
                            (AbstractDoubleVectorRel<RU, R, RV>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractDoubleVectorRel<RU, R, RV> asVectorDim =
                            (AbstractDoubleVectorRel<RU, R, RV>) asMethodDisplayUnit.invoke(cd4sr2, vector.getDisplayUnit());
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }
            }
        }
        for (String type : CLASSNAMES.ABS_LIST)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<AU> unitBase = (UnitBase<AU>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (AU unit : unitBase.getUnitsById().values())
            {
                AbstractDoubleVectorAbs<AU, A, AV, RU, R, RV> vector =
                        (AbstractDoubleVectorAbs<AU, A, AV, RU, R, RV>) DoubleVector.instantiate(
                                DoubleVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                AbstractDoubleVectorAbs<?, ?, ?, ?, ?, ?> sparseVector = vector.toSparse();
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals("Value at index matches", vector.getSI(index), sparseVector.getSI(index), 0.0);
                }
                Class<A> scalarClass = vector.getScalarClass();
                assertTrue("Scalar class is correct kind of vdouble.scalar class",
                        scalarClass.getName().equals("org.djunits4.value.vdouble.scalar." + type));
                double testValue = 123.45;
                A scalarAbs = vector.instantiateScalarSI(testValue, unit);
                assertEquals("Scalar has correct value", testValue, scalarAbs.getSI(), 0.001);
                assertEquals("Scalar ahs correct displayUnit", unit, scalarAbs.getDisplayUnit());
                UnitBase<RU> relativeUnitBase = (UnitBase<RU>) UnitTypes.INSTANCE
                        .getUnitBase(CLASSNAMES.REL_WITH_ABS_LIST.get(CLASSNAMES.ABS_LIST.indexOf(type)) + "Unit");
                for (RU relativeUnit : relativeUnitBase.getUnitsById().values())
                {
                    R scalarRel = vector.instantiateScalarRelSI(testValue, relativeUnit);
                    assertEquals("display unit of scalarRel matches", relativeUnit, scalarRel.getDisplayUnit());
                    assertEquals("value of scalarRel matches", testValue, scalarRel.getSI(), 0.001);
                }
            }
        }
    }

}
