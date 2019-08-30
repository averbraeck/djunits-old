package org.djunits4.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.SpeedUnit;
import org.junit.Test;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class AsScalarTest
{

    /** test casting to other scalars. */
    @Test
    public void testAsScalar()
    {
        Duration d = Duration.createSI(10.0);
        Length l = Length.valueOf("50.0 m");
        SIScalar pace = DoubleScalar.divide(d, l);
        System.out.println("pace = " + pace);
        assertEquals("s/m", pace.getUnit().toString());
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
            System.out.println("ok");
        }

        try
        {
            ohm180.multiplyBy(ohm90).as(Speed.ZERO);
            fail("Translating Ohms to Speed should have failed");
        }
        catch (Exception e)
        {
            System.out.println("ok");
        }

        try
        {
            ohm180.multiplyBy(ohm90).as(Speed.class);
            fail("Translating Ohms to Speed should have failed");
        }
        catch (Exception e)
        {
            System.out.println("ok");
        }
    }

}
