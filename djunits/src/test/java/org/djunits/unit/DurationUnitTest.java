package org.djunits.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits.locale.DefaultLocale;
import org.djunits.unit.unitsystem.UnitSystem;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DurationUnitTest extends AbstractLinearUnitTest<DurationUnit>
{
    /**
     * Set the locale to "en" so we know what texts should be retrieved from the resources.
     */
    @Before
    public final void setup()
    {
        DefaultLocale.setLocale(new Locale("en"));
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        assertEquals("s", DurationUnit.SI.getQuantity().getSiDimensions().toString(true, false));
        checkUnitRatioNameAndAbbreviation(DurationUnit.SECOND, 1, 0.00000001, "second", "s");
        checkUnitRatioNameAndAbbreviation(DurationUnit.HOUR, 3600, 0.0005, "hour", "h");
        checkUnitRatioNameAndAbbreviation(DurationUnit.DAY, 86400, 0.001, "day", "day");
        // Check two conversions between non-standard units
        assertEquals("one DAY is 24 HOUR", 24, getMultiplicationFactorTo(DurationUnit.DAY, DurationUnit.HOUR), 0.0001);
        assertEquals("one HOUR is about 0.0417 DAY", 0.0417, getMultiplicationFactorTo(DurationUnit.HOUR, DurationUnit.DAY),
                0.0001);
        // Check conversion factor to standard unit for all remaining time units
        checkUnitRatioNameAndAbbreviation(DurationUnit.MILLISECOND, 0.001, 0.00000001, "millisecond", "ms");
        checkUnitRatioNameAndAbbreviation(DurationUnit.MINUTE, 60, 0.000001, "minute", "min");
        checkUnitRatioNameAndAbbreviation(DurationUnit.WEEK, 7 * 86400, 0.1, "week", "wk");
    }

    /**
     * Verify that we can create our own duration unit.
     */
    @Test
    public final void createDurationUnit()
    {
        DurationUnit myTU = DurationUnit.SECOND.deriveLinear(14.0 * 86400, "fn", "Fortnight", UnitSystem.OTHER);
        assertTrue("Can create a new DurationUnit", null != myTU);
        checkUnitRatioNameAndAbbreviation(myTU, 14 * 86400, 1, "Fortnight", "fn");
        DurationUnit.BASE.unregister(myTU);
    }

}
