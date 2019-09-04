package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;
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
public class ElectricalResistanceUnitTest extends AbstractLinearUnitTest<ElectricalResistanceUnit>
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
        checkKeys(ElectricalResistanceUnit.OHM, "ElectricalResistanceUnit.ohm_(name)", "ElectricalResistanceUnit.ohm");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioNameAndAbbreviation(ElectricalResistanceUnit.OHM, 1, 0.00000001, "ohm", "\u03A9");
        checkUnitRatioNameAndAbbreviation(ElectricalResistanceUnit.MILLIOHM, 0.001, 0.00000000001, "milliohm", "m\u03A9");
        checkUnitRatioNameAndAbbreviation(ElectricalResistanceUnit.KILOOHM, 1000, 0.005, "kilo-ohm", "k\u03A9");
        // Check two conversions between non-standard units
        assertEquals("one KILOOHM is 1000000 MILLIOHM", 1000000,
                getMultiplicationFactorTo(ElectricalResistanceUnit.KILOOHM, ElectricalResistanceUnit.MILLIOHM), 0.0001);
    }

    /**
     * Verify that we can create our own electrical resistance unit.
     */
    @Test
    public final void createElectricalResistanceUnit()
    {
        ElectricalResistanceUnit myERU =
                new ElectricalResistanceUnit("GigaOhm", "GOhm", SI_DERIVED, ElectricalResistanceUnit.OHM, 1e9);
        assertTrue("Can create a new ElectricalResistanceUnit", null != myERU);
        checkUnitRatioNameAndAbbreviation(myERU, 1e9, 0.1, "GigaOhm", "GOhm");
        deregisterUnit(myERU);

        ElectricalResistanceUnit abOhm = new ElectricalResistanceUnit(ElectricalPotentialUnit.ABVOLT,
                ElectricalCurrentUnit.ABAMPERE, "AbOhm", "AOhm", UnitSystem.CGS);
        assertTrue("Can create Abohm unit", null != abOhm);
        checkUnitRatioNameAndAbbreviation(abOhm, 1e-9, 1e-12, "AbOhm", "AOhm");
        deregisterUnit(abOhm);
    }

}
