package org.djunits4.value.vfloat.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.util.UNITS;
import org.djunits4.unit.util.UnitException;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.scalar.base.FloatScalar;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIFloatScalarTest
{

    /** test casting to other scalars. */
    @Test
    public void testAsScalar()
    {
        FloatDuration d = FloatDuration.createSI(10.0f);
        FloatLength l = FloatLength.valueOf("50.0 m");
        FloatSIScalar pace = FloatScalar.divide(d, l);
        System.out.println("pace = " + pace);
        assertEquals("pace has as unit " + pace.getUnit().toString() + " instead of s/m", "s/m", pace.getUnit().toString());
        assertEquals(0.2, pace.getSI(), 0.00001);
        assertTrue(pace.toString().startsWith("0.200"));
        assertTrue(pace.toString().endsWith("s/m"));

        FloatElectricalResistance ohm180 = new FloatElectricalResistance(180.0f, ElectricalResistanceUnit.KILOOHM);
        FloatElectricalResistance ohm90 = new FloatElectricalResistance(90.0f, ElectricalResistanceUnit.KILOOHM);
        FloatSpeed pace2xAsFloatSpeed = pace.multiplyBy(ohm180).divideBy(ohm90).reciprocal().as(SpeedUnit.SI);
        System.out.println("pace2x = " + pace2xAsFloatSpeed);
        assertEquals("m/s", pace2xAsFloatSpeed.getUnit().toString());
        assertEquals(2.5, pace2xAsFloatSpeed.getSI(), 0.00001);

        FloatSpeed pace2xAsFloatSpeedMih =
                pace.multiplyBy(ohm180).divideBy(ohm90).reciprocal().as(SpeedUnit.MILE_PER_HOUR);
        System.out.println("pace2xMi/h = " + pace2xAsFloatSpeedMih);
        assertEquals("mi/h", pace2xAsFloatSpeedMih.getUnit().toString());
        assertEquals(2.5, pace2xAsFloatSpeedMih.getSI(), 0.00001);

        FloatSpeed speed = pace.reciprocal().as(SpeedUnit.SI);
        System.out.println("speed = " + speed);
        assertEquals("m/s", speed.getUnit().toString());
        assertEquals(5.0, speed.getSI(), 0.00001);
        assertTrue(speed.toString().startsWith("5.000"));
        assertTrue(speed.toString().endsWith("m/s"));

        FloatSpeed speedKmh = pace.reciprocal().as(SpeedUnit.KM_PER_HOUR);
        System.out.println("speedKm/h = " + speedKmh);
        assertEquals("km/h", speedKmh.getUnit().toString());
        assertEquals(5.0, speedKmh.getSI(), 0.00001);
        assertTrue(speedKmh.toString().startsWith("18.000"));
        assertTrue(speedKmh.toString().endsWith("km/h"));

        try
        {
            ohm180.multiplyBy(ohm90).asSpeed();
            fail("Translating Ohms to FloatSpeed should have failed");
        }
        catch (Exception e)
        {
            // ok!
        }

        try
        {
            ohm180.multiplyBy(ohm90).as(SpeedUnit.SI);
            fail("Translating Ohms to FloatSpeed should have failed");
        }
        catch (Exception e)
        {
            // ok!
        }
    }

    /**
     * Multiply a value for every unit with every value for every unit and test the SI dimensions
     * @throws ClassNotFoundException on error finding unit
     */
    @Test
    public void testMultiplyAll() throws ClassNotFoundException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        for (String type1 : CLASSNAMES.REL)
        {
            UnitBase<?> unitBase1 = UnitTypes.INSTANCE.getUnitBase(type1 + "Unit");
            System.out.println("multiply: " + type1 + "Unit");
            SIDimensions siDim1 = unitBase1.getSiDimensions();
            // prevent yocto multiplied by yocto (> Float.MAXVALUE)
            Unit<?> unit1 = unitBase1.getUnitsById().values().iterator().next().getStandardUnit();
            for (String type2 : CLASSNAMES.REL)
            {
                UnitBase<?> unitBase2 = UnitTypes.INSTANCE.getUnitBase(type2 + "Unit");
                SIDimensions siDim2 = unitBase2.getSiDimensions();
                for (Unit<?> unit2 : unitBase2.getUnitsById().values())
                {
                    if (unit2.getScale().toStandardUnit(1.0) < 1E-12 || unit2.getScale().toStandardUnit(1.0) > 1E12)
                        continue;
                    AbstractFloatScalarRel<?, ?> scalar1 =
                            (AbstractFloatScalarRel<?, ?>) FloatScalarUtil.instantiateAnonymous(12.0f, unit1);
                    AbstractFloatScalarRel<?, ?> scalar2 =
                            (AbstractFloatScalarRel<?, ?>) FloatScalarUtil.instantiateAnonymous(0.5f, unit2);
                    FloatSIScalar scalar12a = FloatScalar.multiply(scalar1, scalar2);
                    FloatSIScalar scalar12b = scalar1.multiplyBy(scalar2);
                    FloatSIScalar scalar12c = scalar2.multiplyBy(scalar1);
                    assertEquals(scalar12a.si, scalar12b.si, scalar12a.si / 10000.0f);
                    assertEquals("scalar12a.getUnit(): [" + scalar12a.getUnit() + "] != scalar12b.getUnit(): ["
                            + scalar12b.getUnit() + "]", scalar12a.getUnit(), scalar12b.getUnit());
                    assertEquals(scalar12a.si, scalar12c.si, scalar12a.si / 10000.0f);
                    assertEquals(scalar12a.getUnit(), scalar12c.getUnit());
                    assertEquals(siDim1.plus(siDim2), scalar12a.getUnit().getUnitBase().getSiDimensions());
                    assertFalse("zero for multiply " + scalar1 + " by " + scalar2, scalar12a.si == 0.0);
                    assertFalse("infinite value for " + scalar1 + "*" + scalar2, Float.isInfinite(scalar12a.si));
                    assertFalse(Float.isNaN(scalar12a.si));
                }
            }
        }
    }

    /**
     * Divide a value for every unit by every value for every unit and test the SI dimensions
     * @throws ClassNotFoundException on error finding unit
     */
    @Test
    public void testDivideAll() throws ClassNotFoundException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        for (String type1 : CLASSNAMES.REL)
        {
            UnitBase<?> unitBase1 = UnitTypes.INSTANCE.getUnitBase(type1 + "Unit");
            System.out.println("divide: " + type1 + "Unit");
            SIDimensions siDim1 = unitBase1.getSiDimensions();
            // prevent yotta divided by yocto (< Float.MINVALUE)
            Unit<?> unit1 = unitBase1.getUnitsById().values().iterator().next().getStandardUnit();
            for (String type2 : CLASSNAMES.REL)
            {
                UnitBase<?> unitBase2 = UnitTypes.INSTANCE.getUnitBase(type2 + "Unit");
                SIDimensions siDim2 = unitBase2.getSiDimensions();
                for (Unit<?> unit2 : unitBase2.getUnitsById().values())
                {
                    if (unit2.getScale().toStandardUnit(1.0) < 1E-12 || unit2.getScale().toStandardUnit(1.0) > 1E12)
                        continue;
                    AbstractFloatScalarRel<?, ?> scalar1 =
                            (AbstractFloatScalarRel<?, ?>) FloatScalarUtil.instantiateAnonymous(12.0f, unit1);
                    AbstractFloatScalarRel<?, ?> scalar2 =
                            (AbstractFloatScalarRel<?, ?>) FloatScalarUtil.instantiateAnonymous(0.5f, unit2);
                    FloatSIScalar scalar12a = FloatScalar.divide(scalar1, scalar2);
                    FloatSIScalar scalar12b = scalar1.divideBy(scalar2);
                    FloatSIScalar scalar12c = scalar2.divideBy(scalar1);
                    assertEquals(scalar12a.si, scalar12b.si, scalar12a.si / 10000.0f);
                    assertEquals("scalar12a.getUnit(): [" + scalar12a.getUnit() + "] != scalar12b.getUnit(): ["
                            + scalar12b.getUnit() + "]", scalar12a.getUnit(), scalar12b.getUnit());
                    assertEquals(siDim1.minus(siDim2), scalar12b.getUnit().getUnitBase().getSiDimensions());
                    assertEquals(siDim2.minus(siDim1), scalar12c.getUnit().getUnitBase().getSiDimensions());
                    assertFalse("zero for divide " + scalar1 + " by " + scalar2, scalar12a.si == 0.0);
                    assertFalse("infinite value for " + scalar1 + "/" + scalar2, Float.isInfinite(scalar12a.si));
                    assertFalse(Float.isNaN(scalar12a.si));
                }
            }
        }
    }

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
    @Test
    public void testAsAll() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, UnitException
    {
        // load all classes
        assertEquals("m", UNITS.METER.getId());

        AbstractFloatScalarRel<?, ?> dimless = new FloatDimensionless(1.0, DimensionlessUnit.SI);
        for (String type : CLASSNAMES.REL)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (Unit<?> unit : unitBase.getUnitsById().values())
            {
                AbstractFloatScalarRel<?, ?> scalar =
                        (AbstractFloatScalarRel<?, ?>) FloatScalarUtil.instantiateAnonymous(12.0f, unit);
                FloatSIScalar mult = scalar.multiplyBy(dimless);
                Method asMethod = FloatSIScalar.class.getDeclaredMethod("as" + type);
                AbstractFloatScalarRel<?, ?> asScalar = (AbstractFloatScalarRel<?, ?>) asMethod.invoke(mult);
                assertEquals(scalar.getUnit().getStandardUnit(), asScalar.getUnit());
                assertEquals(scalar.si, asScalar.si, scalar.si / 1000.0);

                Method asMethodDisplayUnit = FloatSIScalar.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractFloatScalarRel<?, ?> asScalarDisplayUnit =
                        (AbstractFloatScalarRel<?, ?>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(scalar.getUnit().getStandardUnit(), asScalarDisplayUnit.getUnit());
                assertEquals(scalar.si, asScalarDisplayUnit.si, scalar.si / 1000.0);

                // test exception for wrong 'as'
                FloatSIScalar cd4sr2 = FloatSIScalar.createSI(8.0f, SIUnit.of("cd4/sr2"));
                try
                {
                    AbstractFloatScalarRel<?, ?> asScalarDim = (AbstractFloatScalarRel<?, ?>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asScalarDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractFloatScalarRel<?, ?> asScalarDim =
                            (AbstractFloatScalarRel<?, ?>) asMethodDisplayUnit.invoke(cd4sr2, scalar.getUnit());
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asScalarDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }
            }
        }
    }

    /**
     * Test the min, max, createSI, interpolate methods.
     * @throws UnitException on error
     */
    @Test
    public void testMethods() throws UnitException
    {
        SIUnit paceUnit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of("s/m"));
        FloatSIScalar pace1 = FloatSIScalar.createSI(1.0f, paceUnit);
        FloatSIScalar pace1a = new FloatSIScalar(pace1);
        assertEquals(pace1, pace1a);
        FloatSIScalar pace2 = new FloatSIScalar(2.0f, paceUnit);
        assertEquals(2.0f, pace2.si, 0.001f);
        FloatSIScalar pace3 = pace1.multiplyBy(3.0f);
        assertEquals(3.0f, pace3.si, 0.001f);
        FloatSIScalar pace5 = pace1.instantiateRel(5.0f, paceUnit);
        assertEquals(5.0f, pace5.si, 0.001f);
        FloatSIScalar pace7 = FloatSIScalar.createSI(14.0f, paceUnit).divideBy(2.0f);
        assertEquals(7.0f, pace7.si, 0.001f);
        FloatSIScalar pace4 = FloatSIScalar.interpolate(pace1, pace7, 0.5f);
        assertEquals(4.0f, pace4.si, 0.001f);

        assertNotEquals(pace1, pace2);
        assertNotEquals(pace1, null);
        assertNotEquals(pace1, new Object());
        assertNotEquals(pace1.hashCode(), pace2.hashCode());
        assertEquals(pace1.hashCode(), pace1a.hashCode());

        assertEquals(pace2, FloatSIScalar.max(pace1, pace2));
        assertEquals(pace3, FloatSIScalar.max(pace1, pace2, pace3));
        assertEquals(pace4, FloatSIScalar.max(pace1, pace2, pace3, pace4));
        assertEquals(pace2, FloatSIScalar.max(pace2, pace1));
        assertEquals(pace3, FloatSIScalar.max(pace3, pace2, pace1));
        assertEquals(pace4, FloatSIScalar.max(pace4, pace3, pace2, pace1));

        assertEquals(pace1, FloatSIScalar.min(pace1, pace2));
        assertEquals(pace1, FloatSIScalar.min(pace1, pace2, pace3));
        assertEquals(pace1, FloatSIScalar.min(pace1, pace2, pace3, pace4));
        assertEquals(pace1, FloatSIScalar.min(pace2, pace1));
        assertEquals(pace1, FloatSIScalar.min(pace3, pace2, pace1));
        assertEquals(pace1, FloatSIScalar.min(pace4, pace3, pace2, pace1));

        FloatDimensionless dim = pace7.divideBy(pace2).asDimensionless();
        assertEquals(3.5, dim.si, 0.001);
    }

    /**
     * Test the min, max, createSI, interpolate, comparison methods.
     * @throws UnitException on error
     */
    @Test
    public void testFloatMethods() throws UnitException
    {
        SIUnit paceUnit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of("s/m"));
        FloatSIScalar pace1 = FloatSIScalar.createSI(1.0f, paceUnit);
        FloatSIScalar pace1a = new FloatSIScalar(pace1);
        assertEquals(pace1, pace1a);
        FloatSIScalar pace2 = new FloatSIScalar(2.0f, paceUnit);
        assertEquals(2.0, pace2.si, 0.001);
        FloatSIScalar pace3 = pace1.multiplyBy(3.0f);
        assertEquals(3.0, pace3.si, 0.001);
        FloatSIScalar pace5 = pace1.instantiateRel(5.0f, paceUnit);
        assertEquals(5.0, pace5.si, 0.001);
        FloatSIScalar pace7 = FloatSIScalar.createSI(14.0f, paceUnit).divideBy(2.0f);
        assertEquals(7.0, pace7.si, 0.001);
        FloatSIScalar pace4 = FloatSIScalar.interpolate(pace1, pace7, 0.5f);
        assertEquals(4.0, pace4.si, 0.001);

        assertTrue("ne0", pace1.ne0());
        assertTrue("ge0", pace1.ge0());
        assertTrue("gt0", pace1.gt0());
        assertFalse("le0", pace1.le0());
        assertFalse("eq0", pace1.eq0());
        assertFalse("lt0", pace1.lt0());

        FloatSIScalar pace0 = pace1.minus(pace1);
        assertEquals("0", 0.0, pace0.si, 0);
        assertFalse("ne0", pace0.ne0());
        assertTrue("ge0", pace0.ge0());
        assertFalse("gt0", pace0.gt0());
        assertTrue("le0", pace0.le0());
        assertTrue("eq0", pace0.eq0());
        assertFalse("lt0", pace0.lt0());

        FloatSIScalar negativePace = pace0.minus(pace1);
        assertTrue("ne0", negativePace.ne0());
        assertFalse("ge0", negativePace.ge0());
        assertFalse("gt0", negativePace.gt0());
        assertTrue("le0", negativePace.le0());
        assertFalse("eq0", negativePace.eq0());
        assertTrue("lt0", negativePace.lt0());

        assertEquals("compareto same", 0, pace1.compareTo(pace1));
        assertEquals("compareto bigger", -1, pace0.compareTo(pace1));
        assertEquals("compareto smaller", 1, pace0.compareTo(negativePace));

        assertNotEquals(pace1, pace2);
        assertNotEquals(pace1, null);
        assertNotEquals(pace1, new Object());
        assertNotEquals(pace1.hashCode(), pace2.hashCode());
        assertEquals(pace1.hashCode(), pace1a.hashCode());

        assertEquals(pace2, FloatSIScalar.max(pace1, pace2));
        assertEquals(pace3, FloatSIScalar.max(pace1, pace2, pace3));
        assertEquals(pace4, FloatSIScalar.max(pace1, pace2, pace3, pace4));
        assertEquals(pace2, FloatSIScalar.max(pace2, pace1));
        assertEquals(pace3, FloatSIScalar.max(pace3, pace2, pace1));
        assertEquals(pace4, FloatSIScalar.max(pace4, pace3, pace2, pace1));

        assertEquals(pace1, FloatSIScalar.min(pace1, pace2));
        assertEquals(pace1, FloatSIScalar.min(pace1, pace2, pace3));
        assertEquals(pace1, FloatSIScalar.min(pace1, pace2, pace3, pace4));
        assertEquals(pace1, FloatSIScalar.min(pace2, pace1));
        assertEquals(pace1, FloatSIScalar.min(pace3, pace2, pace1));
        assertEquals(pace1, FloatSIScalar.min(pace4, pace3, pace2, pace1));

        FloatDimensionless dim = pace7.divideBy(pace2).asDimensionless();
        assertEquals(3.5, dim.si, 0.001);
    }

}
