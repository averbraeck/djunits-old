package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits.locale.DefaultLocale;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 4, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleSolidUnitTest extends AbstractLinearUnitTest<AngleSolidUnit>
{
    /**
     * Set the locale to "en" so we know what texts should be retrieved from the resources.
     */
    @SuppressWarnings("static-method")
    @Before
    public final void setup()
    {
        DefaultLocale.setLocale(new Locale("en"));
    }

    /**
     * Verify the result of some get*Key methods.
     */
    @Test
    public final void keys()
    {
        checkKeys(AngleSolidUnit.STERADIAN, "AngleSolidUnit.steradian", "AngleSolidUnit.sr");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
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
    public final void createAngleUnit()
    {
        AngleSolidUnit myAPU = new AngleSolidUnit("point", "pt", OTHER, AngleSolidUnit.STERADIAN, 0.19634954085);
        assertTrue("Can create a new TimeUnit", null != myAPU);
        checkUnitRatioNameAndAbbreviation(myAPU, 0.19634954085, 0.0000001, "point", "pt");
    }
}
