package org.djunits4.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits4.locale.DefaultLocale;
import org.djunits4.unit.unitsystem.UnitSystem;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-19 11:30:26 +0200 (Mon, 19 Aug 2019) $, @version $Revision: 425 $, by $Author: averbraeck $,
 * initial version Jun 4, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
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
        checkUnitRatioNameAndAbbreviation(DurationUnit.SECOND, 1, 0.00000001, "second", "s");
        checkUnitRatioNameAndAbbreviation(DurationUnit.HOUR, 3600, 0.0005, "hour", "hr");
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
