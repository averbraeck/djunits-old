package org.djunits4.value.vdouble.scalar;

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
import org.djunits4.value.vfloat.scalar.FloatSpeed;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIScalarTest
{

    /** test casting to other scalars. */
    @Test
    public void testAsScalar()
    {
        Duration d = Duration.createSI(10.0);
        Length l = Length.valueOf("50.0 m");
        SIScalar pace = DoubleScalar.divide(d, l);
        System.out.println("pace = " + pace);
        assertEquals("pace has as unit " + pace.getUnit().toString() + " instead of s/m", "s/m", pace.getUnit().toString());
        assertEquals(0.2, pace.getSI(), 0.00001);
        assertTrue(pace.toString().startsWith("0.200"));
        assertTrue(pace.toString().endsWith("s/m"));

        ElectricalResistance ohm180 = new ElectricalResistance(180, ElectricalResistanceUnit.KILOOHM);
        ElectricalResistance ohm90 = new ElectricalResistance(90, ElectricalResistanceUnit.KILOOHM);
        Speed pace2xAsSpeed = pace.multiplyBy(ohm180).divideBy(ohm90).reciprocal().as(Speed.ZERO);
        System.out.println("pace2x = " + pace2xAsSpeed);
        assertEquals("m/s", pace2xAsSpeed.getUnit().toString());
        assertEquals(2.5, pace2xAsSpeed.getSI(), 0.00001);

        Speed pace2xAsSpeedMih = pace.multiplyBy(ohm180).divideBy(ohm90).reciprocal().as(Speed.ZERO, SpeedUnit.MILE_PER_HOUR);
        System.out.println("pace2xMi/h = " + pace2xAsSpeedMih);
        assertEquals("mi/h", pace2xAsSpeedMih.getUnit().toString());
        assertEquals(2.5, pace2xAsSpeedMih.getSI(), 0.00001);

        Speed speed = pace.reciprocal().as(Speed.class);
        System.out.println("speed = " + speed);
        assertEquals("m/s", speed.getUnit().toString());
        assertEquals(5.0, speed.getSI(), 0.00001);
        assertTrue(speed.toString().startsWith("5.000"));
        assertTrue(speed.toString().endsWith("m/s"));
        assertTrue("toString with display unit contains display unit", 
                speed.toString(SpeedUnit.FOOT_PER_HOUR).indexOf("ft/h") > 0);
        FloatSpeed fs = FloatSpeed.createSI((float) speed.si);
        assertTrue("toString with display unit contains display unit", 
                fs.toString(SpeedUnit.FOOT_PER_HOUR).indexOf("ft/h") > 0);

        Speed speedKmh = pace.reciprocal().as(Speed.class, SpeedUnit.KM_PER_HOUR);
        System.out.println("speedKm/h = " + speedKmh);
        assertEquals("km/h", speedKmh.getUnit().toString());
        assertEquals(5.0, speedKmh.getSI(), 0.00001);
        assertTrue(speedKmh.toString().startsWith("18.000"));
        assertTrue(speedKmh.toString().endsWith("km/h"));

        try
        {
            ohm180.multiplyBy(ohm90).asSpeed();
            fail("Translating Ohms to Speed should have failed");
        }
        catch (Exception e)
        {
            // ok!
        }

        try
        {
            ohm180.multiplyBy(ohm90).as(Speed.ZERO);
            fail("Translating Ohms to Speed should have failed");
        }
        catch (Exception e)
        {
            // ok!
        }

        try
        {
            ohm180.multiplyBy(ohm90).as(Speed.class);
            fail("Translating Ohms to Speed should have failed");
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
            Unit<?> unit1 = unitBase1.getUnitsById().values().iterator().next();
            for (String type2 : CLASSNAMES.REL)
            {
                UnitBase<?> unitBase2 = UnitTypes.INSTANCE.getUnitBase(type2 + "Unit");
                SIDimensions siDim2 = unitBase2.getSiDimensions();
                for (Unit<?> unit2 : unitBase2.getUnitsById().values())
                {
                    AbstractDoubleScalarRel<?, ?> scalar1 =
                            (AbstractDoubleScalarRel<?, ?>) DoubleScalarUtil.instantiateAnonymous(12.0, unit1);
                    AbstractDoubleScalarRel<?, ?> scalar2 =
                            (AbstractDoubleScalarRel<?, ?>) DoubleScalarUtil.instantiateAnonymous(0.5, unit2);
                    SIScalar scalar12a = DoubleScalar.multiply(scalar1, scalar2);
                    SIScalar scalar12b = scalar1.multiplyBy(scalar2);
                    SIScalar scalar12c = scalar2.multiplyBy(scalar1);
                    assertEquals(scalar12a.si, scalar12b.si, scalar12a.si / 10000.0);
                    assertEquals("scalar12a.getUnit(): [" + scalar12a.getUnit() + "] != scalar12b.getUnit(): ["
                            + scalar12b.getUnit() + "]", scalar12a.getUnit(), scalar12b.getUnit());
                    assertEquals(scalar12a.si, scalar12c.si, scalar12a.si / 10000.0);
                    assertEquals(scalar12a.getUnit(), scalar12c.getUnit());
                    assertEquals(siDim1.plus(siDim2), scalar12a.getUnit().getUnitBase().getSiDimensions());
                    assertFalse(scalar12a.si == 0.0);
                    assertFalse(Double.isInfinite(scalar12a.si));
                    assertFalse(Double.isNaN(scalar12a.si));
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
            Unit<?> unit1 = unitBase1.getUnitsById().values().iterator().next();
            for (String type2 : CLASSNAMES.REL)
            {
                UnitBase<?> unitBase2 = UnitTypes.INSTANCE.getUnitBase(type2 + "Unit");
                SIDimensions siDim2 = unitBase2.getSiDimensions();
                for (Unit<?> unit2 : unitBase2.getUnitsById().values())
                {
                    AbstractDoubleScalarRel<?, ?> scalar1 =
                            (AbstractDoubleScalarRel<?, ?>) DoubleScalarUtil.instantiateAnonymous(12.0, unit1);
                    AbstractDoubleScalarRel<?, ?> scalar2 =
                            (AbstractDoubleScalarRel<?, ?>) DoubleScalarUtil.instantiateAnonymous(0.5, unit2);
                    SIScalar scalar12a = DoubleScalar.divide(scalar1, scalar2);
                    SIScalar scalar12b = scalar1.divideBy(scalar2);
                    SIScalar scalar12c = scalar2.divideBy(scalar1);
                    assertEquals(scalar12a.si, scalar12b.si, scalar12a.si / 10000.0);
                    assertEquals("scalar12a.getUnit(): [" + scalar12a.getUnit() + "] != scalar12b.getUnit(): ["
                            + scalar12b.getUnit() + "]", scalar12a.getUnit(), scalar12b.getUnit());
                    assertEquals(siDim1.minus(siDim2), scalar12b.getUnit().getUnitBase().getSiDimensions());
                    assertEquals(siDim2.minus(siDim1), scalar12c.getUnit().getUnitBase().getSiDimensions());
                    assertFalse(scalar12a.si == 0.0);
                    assertFalse(Double.isInfinite(scalar12a.si));
                    assertFalse(Double.isNaN(scalar12a.si));
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

        AbstractDoubleScalarRel<?, ?> dimless = new Dimensionless(1.0, DimensionlessUnit.SI);
        for (String type : CLASSNAMES.REL)
        {
            Class.forName("org.djunits4.unit." + type + "Unit");
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(type + "Unit");
            for (Unit<?> unit : unitBase.getUnitsById().values())
            {
                AbstractDoubleScalarRel<?, ?> scalar =
                        (AbstractDoubleScalarRel<?, ?>) DoubleScalarUtil.instantiateAnonymous(12.0, unit);
                SIScalar mult = scalar.multiplyBy(dimless);
                Method asMethod = SIScalar.class.getDeclaredMethod("as" + type);
                AbstractDoubleScalarRel<?, ?> asScalar = (AbstractDoubleScalarRel<?, ?>) asMethod.invoke(mult);
                assertEquals(scalar.getUnit().getStandardUnit(), asScalar.getUnit());
                assertEquals(scalar.si, asScalar.si, scalar.si / 1000.0);

                Method asMethodDisplayUnit = SIScalar.class.getDeclaredMethod("as" + type, unit.getClass());
                AbstractDoubleScalarRel<?, ?> asScalarDisplayUnit =
                        (AbstractDoubleScalarRel<?, ?>) asMethodDisplayUnit.invoke(mult, unit.getStandardUnit());
                assertEquals(scalar.getUnit().getStandardUnit(), asScalarDisplayUnit.getUnit());
                assertEquals(scalar.si, asScalarDisplayUnit.si, scalar.si / 1000.0);

                // test exception for wrong 'as'
                SIScalar cd4sr2 = SIScalar.createSI(8.0, SIUnit.of("cd4/sr2"));
                try
                {
                    AbstractDoubleScalarRel<?, ?> asScalarDim = (AbstractDoubleScalarRel<?, ?>) asMethod.invoke(cd4sr2);
                    fail("should not be able to carry out 'as'" + type + " on cd4/sr2 SI unit -- resulted in " + asScalarDim);
                }
                catch (InvocationTargetException | UnitRuntimeException e)
                {
                    // ok
                }

                try
                {
                    AbstractDoubleScalarRel<?, ?> asScalarDim =
                            (AbstractDoubleScalarRel<?, ?>) asMethodDisplayUnit.invoke(cd4sr2, scalar.getUnit());
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
     * Test the min, max, createSI, interpolate, comparison methods.
     * @throws UnitException on error
     */
    @Test
    public void testDoubleMethods() throws UnitException
    {
        SIUnit paceUnit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of("s/m"));
        SIScalar pace1 = SIScalar.createSI(1.0, paceUnit);
        SIScalar pace1a = new SIScalar(pace1);
        assertEquals(pace1, pace1a);
        SIScalar pace2 = new SIScalar(2.0, paceUnit);
        assertEquals(2.0, pace2.si, 0.001);
        SIScalar pace3 = pace1.multiplyBy(3.0);
        assertEquals(3.0, pace3.si, 0.001);
        SIScalar pace5 = pace1.instantiateRel(5.0, paceUnit);
        assertEquals(5.0, pace5.si, 0.001);
        SIScalar pace7 = SIScalar.createSI(14.0, paceUnit).divideBy(2.0);
        assertEquals(7.0, pace7.si, 0.001);
        SIScalar pace4 = SIScalar.interpolate(pace1, pace7, 0.5);
        assertEquals(4.0, pace4.si, 0.001);

        assertTrue("ne0", pace1.ne0());
        assertTrue("ge0", pace1.ge0());
        assertTrue("gt0", pace1.gt0());
        assertFalse("le0", pace1.le0());
        assertFalse("eq0", pace1.eq0());
        assertFalse("lt0", pace1.lt0());
        
        SIScalar pace0 = pace1.minus(pace1);
        assertEquals("0", 0.0, pace0.si, 0);
        assertFalse("ne0", pace0.ne0());
        assertTrue("ge0", pace0.ge0());
        assertFalse("gt0", pace0.gt0());
        assertTrue("le0", pace0.le0());
        assertTrue("eq0", pace0.eq0());
        assertFalse("lt0", pace0.lt0());
        
        SIScalar negativePace = pace0.minus(pace1);
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

        assertEquals(pace2, SIScalar.max(pace1, pace2));
        assertEquals(pace3, SIScalar.max(pace1, pace2, pace3));
        assertEquals(pace4, SIScalar.max(pace1, pace2, pace3, pace4));
        assertEquals(pace2, SIScalar.max(pace2, pace1));
        assertEquals(pace3, SIScalar.max(pace3, pace2, pace1));
        assertEquals(pace4, SIScalar.max(pace4, pace3, pace2, pace1));

        assertEquals(pace1, SIScalar.min(pace1, pace2));
        assertEquals(pace1, SIScalar.min(pace1, pace2, pace3));
        assertEquals(pace1, SIScalar.min(pace1, pace2, pace3, pace4));
        assertEquals(pace1, SIScalar.min(pace2, pace1));
        assertEquals(pace1, SIScalar.min(pace3, pace2, pace1));
        assertEquals(pace1, SIScalar.min(pace4, pace3, pace2, pace1));

        Dimensionless dim = pace7.divideBy(pace2).asDimensionless();
        assertEquals(3.5, dim.si, 0.001);
    }
   
}