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
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class LinearDensityUnitTest extends AbstractLinearUnitTest<LinearDensityUnit>
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
        checkKeys(LinearDensityUnit.PER_METER, "LinearDensityUnit.per_meter", "LinearDensityUnit./m");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioNameAndAbbreviation(LinearDensityUnit.PER_METER, 1, 0.000001, "per meter", "/m");
        checkUnitRatioNameAndAbbreviation(LinearDensityUnit.PER_KILOMETER, 0.001, 0.0000001, "per kilometer", "/km");
        checkUnitRatioNameAndAbbreviation(LinearDensityUnit.PER_MILLIMETER, 1000, 0.01, "per millimeter", "/mm");
        // Check two conversions between non-standard units
        assertEquals("one per millimeter is 1000000 per kilometer", 1000000,
                getMultiplicationFactorTo(LinearDensityUnit.PER_MILLIMETER, LinearDensityUnit.PER_KILOMETER), 0.1);
        assertEquals("one per kilometer is 0.000001 per millimeter", 0.000001,
                getMultiplicationFactorTo(LinearDensityUnit.PER_KILOMETER, LinearDensityUnit.PER_MILLIMETER), 0.00000005);
    }

    /**
     * Verify that we can create our own Frequency unit.
     */
    @Test
    public final void createLinearDensityUnit()
    {
        LinearDensityUnit muLDU = new LinearDensityUnit("PerInch", "/in", OTHER, LinearDensityUnit.PER_METER, 2.54 / 100);
        assertTrue("Can create a new LinearDensityUnit", null != muLDU);
        checkUnitRatioNameAndAbbreviation(muLDU, 0.0254, 0.000001, "PerInch", "/in");
        deregisterUnit(muLDU);
    }

}
