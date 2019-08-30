package org.djunits4.unit;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.djunits4.locale.DefaultLocale;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalCurrentUnitTest extends AbstractLinearUnitTest<ElectricalCurrentUnit>
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
        checkUnitRatioNameAndAbbreviation(ElectricalCurrentUnit.AMPERE, 1, 0.00000001, "ampere", "A");
        checkUnitRatioNameAndAbbreviation(ElectricalCurrentUnit.MILLIAMPERE, 0.001, 0.000000001, "milliampere", "mA");
        // Check two conversions between two units
        assertEquals("one AMPERE is 1000 MILLI AMPERE", 1000,
                getMultiplicationFactorTo(ElectricalCurrentUnit.AMPERE, ElectricalCurrentUnit.MILLIAMPERE), 0.01);
        assertEquals("one MILLI AMPERE is 0.001 AMPERE", 0.001,
                getMultiplicationFactorTo(ElectricalCurrentUnit.MILLIAMPERE, ElectricalCurrentUnit.AMPERE), 0.0001);
    }

}
