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
 * initial version Jun 6, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MassUnitTest extends AbstractLinearUnitTest<MassUnit>
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
     * Verify the result of some get*Key methods.
     */
    @Test
    public final void keys()
    {
        checkKeys(MassUnit.KILOGRAM, "MassUnit.kilogram", "MassUnit.kg");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioNameAndAbbreviation(MassUnit.KILOGRAM, 1, 0.00000001, "kilogram", "kg");
        checkUnitRatioNameAndAbbreviation(MassUnit.GRAM, 0.001, 0.000000001, "gram", "g");
        checkUnitRatioNameAndAbbreviation(MassUnit.POUND, 0.453592, 0.000001, "pound", "lb");
        // Check two conversions between non-standard units
        assertEquals("one POUND is 16 OUNCE", 16, getMultiplicationFactorTo(MassUnit.POUND, MassUnit.OUNCE), 0.00001);
        assertEquals("one OUNCE is 0.0625 POUND", 0.0625, getMultiplicationFactorTo(MassUnit.OUNCE, MassUnit.POUND), 0.000001);
        // Check conversion factor to standard unit for all remaining time units
        checkUnitRatioNameAndAbbreviation(MassUnit.OUNCE, 0.0283495, 0.0000001, "ounce", "oz");
        checkUnitRatioNameAndAbbreviation(MassUnit.TON_LONG, 1016.046906, 0.00001, "long ton", "long tn");
        checkUnitRatioNameAndAbbreviation(MassUnit.TON_SHORT, 907.18474, 0.00001, "short ton", "sh tn");
        checkUnitRatioNameAndAbbreviation(MassUnit.TON_METRIC, 1000, 0.001, "metric tonne", "t");
    }

    /**
     * Verify that we can create our own mass unit.
     */
    @Test
    public final void createMassUnit()
    {
        MassUnit myMU = new MassUnit("Person", "pn", OTHER, MassUnit.KILOGRAM, 80);
        assertTrue("Can create a new MassUnit", null != myMU);
        checkUnitRatioNameAndAbbreviation(myMU, 80, 1, "Person", "pn");
        deregisterUnit(myMU);
    }

}
