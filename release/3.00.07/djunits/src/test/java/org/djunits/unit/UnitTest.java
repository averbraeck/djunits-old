package org.djunits.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 18, 2014 <br>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitTest
{
    /**
     * Test the lookupUnitWithSICoefficients method.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void lookupUnitWithSICoefficients()
    {
        // System.out.println(Unit.lookupUnitWithSICoefficients(ElectricalPotentialUnit.ABVOLT.getSICoefficients().toString())
        // .toString());
        // System.out.println(ElectricalPotentialUnit.ABVOLT.getSICoefficients().toString());
        // System.out.println(ElectricalPotentialUnit.VOLT.getSICoefficients().toString());
        assertTrue("ABVOLT is expressed in Volt",
                Unit.lookupUnitWithSICoefficients(ElectricalPotentialUnit.ABVOLT.getSICoefficients().toString())
                        .contains(ElectricalPotentialUnit.VOLT));
        assertTrue("ABVOLT / STATAMPERE is expressed in Ohm",
                Unit.lookupUnitWithSICoefficients(SICoefficients.divide(ElectricalPotentialUnit.ABVOLT.getSICoefficients(),
                        ElectricalCurrentUnit.STATAMPERE.getSICoefficients()).toString())
                        .contains(ElectricalResistanceUnit.OHM));
        assertTrue(
                "ABVOLT * STATAMPERE is expressed in Watt", Unit
                        .lookupUnitWithSICoefficients(
                                SICoefficients.multiply(ElectricalPotentialUnit.ABVOLT.getSICoefficients(),
                                        ElectricalCurrentUnit.STATAMPERE.getSICoefficients()).toString())
                        .contains(PowerUnit.WATT));
        assertTrue("ABVOLT / Watt is expressed in 1/A",
                Unit.lookupOrCreateUnitWithSICoefficients(SICoefficients
                        .divide(ElectricalPotentialUnit.ABVOLT.getSICoefficients(), PowerUnit.WATT.getSICoefficients())
                        .toString()).toString().contains("1/A"));
        assertTrue("ABVOLT * KILOVOLT is expressed in kg2.m4/s6/A2", Unit
                .lookupOrCreateUnitWithSICoefficients(
                        SICoefficients.multiply(ElectricalPotentialUnit.ABVOLT.getSICoefficients(),
                                ElectricalPotentialUnit.KILOVOLT.getSICoefficients()).toString())
                .toString().contains("kg2m4/s6A2"));
    }

    /**
     * Check objects returned by getAllUnitsOfType.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void getAllUnitsOfType()
    {
        Unit<?>[] baseUnits = { MassUnit.KILOGRAM, LengthUnit.METER, ElectricalCurrentUnit.AMPERE, DurationUnit.SECOND,
                TemperatureUnit.KELVIN, /*
                                         * LuminousIntencity . CANDELA , ? ? ? . mol
                                         */ };
        for (Unit<?> u : baseUnits)
        {
            for (Object unitObject : u.getAllUnitsOfThisType())
            {
                assertTrue("getAllUnitsOfThisType returns Units", unitObject instanceof Unit);
                Unit<?> u2 = (Unit<?>) unitObject;
                assertEquals("Standard unit of " + u2 + " should be " + u, u, u2.getStandardUnit());
            }
        }
    }

    /**
     * Test all constructors for UnitException.
     */
    @Test
    public final void unitExceptionTest()
    {
        String message = "MessageString";
        Exception e = new UnitException(message);
        assertTrue("Exception should not be null", null != e);
        assertEquals("message should be our message", message, e.getMessage());
        assertEquals("cause should be null", null, e.getCause());
        e = new UnitException();
        assertTrue("Exception should not be null", null != e);
        assertEquals("cause should be null", null, e.getCause());
        String causeString = "CauseString";
        Throwable cause = new Throwable(causeString);
        e = new UnitException(cause);
        assertTrue("Exception should not be null", null != e);
        assertEquals("cause should not be our cause", cause, e.getCause());
        assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
        e = new UnitException(message, cause);
        assertTrue("Exception should not be null", null != e);
        assertEquals("message should be our message", message, e.getMessage());
        assertEquals("cause should not be our cause", cause, e.getCause());
        assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
        for (boolean enableSuppression : new boolean[] { true, false })
        {
            for (boolean writableStackTrace : new boolean[] { true, false })
            {
                e = new UnitException(message, cause, enableSuppression, writableStackTrace);
                assertTrue("Exception should not be null", null != e);
                assertEquals("message should be our message", message, e.getMessage());
                assertEquals("cause should not be our cause", cause, e.getCause());
                assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
                // Don't know how to check if suppression is enabled/disabled
                StackTraceElement[] stackTrace = new StackTraceElement[1];
                stackTrace[0] = new StackTraceElement("a", "b", "c", 1234);
                try
                {
                    e.setStackTrace(stackTrace);
                }
                catch (Exception e1)
                {
                    assertTrue("Stack trace should be writable", writableStackTrace);
                    continue;
                }
                // You wouldn't believe it, but a call to setStackTrace if non-writable is silently ignored
                StackTraceElement[] retrievedStackTrace = e.getStackTrace();
                if (retrievedStackTrace.length > 0)
                {
                    assertTrue("stack trace should be writable", writableStackTrace);
                }
            }
        }
    }

}
