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
public class AngleSolidUnitTest extends AbstractLinearUnitTest<AngleSolidUnit>
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
        assertEquals("sr", AngleSolidUnit.SI.getUnitBase().getSiDimensions().toString(true, false));
        checkUnitRatioNameAndAbbreviation(AngleSolidUnit.STERADIAN, 1, 0.0000001, "steradian", "sr");
        checkUnitRatioNameAndAbbreviation(AngleSolidUnit.SQUARE_DEGREE, 1.0 / 3283, 0.0005, "square degree", "sq.deg");
        // Check two conversions between units
        assertEquals("one STERADIAN is about 3283 SQUARE_DEGREE", 3283,
                getMultiplicationFactorTo(AngleSolidUnit.STERADIAN, AngleSolidUnit.SQUARE_DEGREE), 0.5);
        assertEquals("one SQUARE_DEGREE is about 0.0003045 STERADIAN", 0.0003045,
                getMultiplicationFactorTo(AngleSolidUnit.SQUARE_DEGREE, AngleSolidUnit.STERADIAN), 0.0000005);
    }

    /**
     * Verify that we can create our own angle unit.
     */
    @Test
    public final void createSolidAngleUnit()
    {
        AngleSolidUnit myAPU = AngleSolidUnit.STERADIAN.deriveLinear(0.19634954085, "pt", "point", UnitSystem.OTHER);
        assertTrue("Can create a new TimeUnit", null != myAPU);
        checkUnitRatioNameAndAbbreviation(myAPU, 0.19634954085, 0.0000001, "point", "pt");
        AngleSolidUnit.BASE.unregister(myAPU);
    }
}
