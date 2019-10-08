package org.djunits4.value.vfloat.vector;

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
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarAbs;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRelWithAbs;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorAbs;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRelWithAbs;
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
    public <AU extends AbsoluteLinearUnit<AU, RU>, A extends AbstractFloatScalarAbs<AU, A, RU, R>,
            AV extends AbstractFloatVectorAbs<AU, A, AV, RU, R, RV>, RU extends Unit<RU>,
            R extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>,
            RV extends AbstractFloatVectorRelWithAbs<AU, A, AV, RU, R, RV>> void testAsAll()
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
            UnitBase<RU> unitBase = (UnitBase<RU>) UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (RU unit : unitBase.getUnitsById().values())
            {
                AbstractFloatVectorRel<RU, R, RV> vector = (AbstractFloatVectorRel<RU, R, RV>) FloatVector
                        .instantiate(FloatVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                AbstractFloatVectorRel<RU, R, RV> sparseVector = vector.toSparse();
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals("Value at index matches", vector.getSI(index), sparseVector.getSI(index), 0.0);
                }

                FloatSIVector mult = vector.times(dimlessVector);
                Method asMethod = FloatSIVector.class.getDeclaredMethod("as" + type);
                AbstractFloatVectorRel<RU, R, RV> asVector = (AbstractFloatVectorRel<RU, R, RV>) asMethod.invoke(mult);
                assertEquals(vector.getDisplayUnit().getStandardUnit(), asVector.getDisplayUnit());
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals(type + ", unit: " + unit.getDefaultTextualAbbreviation(), vector.getSI(index),
                            asVector.getSI(index), vector.getSI(index) / 1000.0);
                }

                Method asMethodDisplayUnit = FloatSIVector.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractFloatVectorRel<RU, R, RV> asVectorDisplayUnit =
                        (AbstractFloatVectorRel<RU, R, RV>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
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
                    AbstractFloatVectorRel<RU, R, RV> asVectorDim = (AbstractFloatVectorRel<RU, R, RV>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asVectorDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractFloatVectorRel<RU, R, RV> asVectorDim =
                            (AbstractFloatVectorRel<RU, R, RV>) asMethodDisplayUnit.invoke(cd4sr2, vector.getDisplayUnit());
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
                AbstractFloatVectorAbs<AU, A, AV, RU, R, RV> vector = (AbstractFloatVectorAbs<AU, A, AV, RU, R, RV>) FloatVector
                        .instantiate(FloatVectorData.instantiate(denseTestData, unit.getScale(), StorageType.DENSE), unit);
                AbstractFloatVectorAbs<?, ?, ?, ?, ?, ?> sparseVector = vector.toSparse();
                for (int index = 0; index < denseTestData.length; index++)
                {
                    assertEquals("Value at index matches", vector.getSI(index), sparseVector.getSI(index), 0.0);
                }
                Class<A> scalarClass = vector.getScalarClass();
                assertTrue("Scalar class is correct kind of vfloat.scalar class",
                        scalarClass.getName().equals("org.djunits4.value.vfloat.scalar.Float" + type));
                float testValue = 123.45f;
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
