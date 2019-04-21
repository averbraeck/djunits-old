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
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 6, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ForceUnitTest extends AbstractLinearUnitTest<ForceUnit>
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
        checkKeys(ForceUnit.NEWTON, "ForceUnit.newton", "ForceUnit.N");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioNameAndAbbreviation(ForceUnit.NEWTON, 1, 0.000001, "newton", "N");
        checkUnitRatioNameAndAbbreviation(ForceUnit.DYNE, 0.00001, 0.000000001, "dyne", "dyn");
        // Check two conversions between non-standard units
        assertEquals("one DYNE is about 1.019716e-6 KILOGRAM FORCE", 1.01971621e-6, getMultiplicationFactorTo(
            ForceUnit.DYNE, ForceUnit.KILOGRAM_FORCE), 0.00000000001);
        assertEquals("one KILOGRAM FORCE is about 980665 DYNE", 980665, getMultiplicationFactorTo(
            ForceUnit.KILOGRAM_FORCE, ForceUnit.DYNE), 0.5);
    }

    /**
     * Verify that we can create our own Force unit.
     */
    @Test
    public final void createForceUnit()
    {
        ForceUnit myFU = new ForceUnit("AntForce", "af", UnitSystem.OTHER, ForceUnit.KILOGRAM_FORCE, 0.002);
        assertTrue("Can create a new ForceUnit", null != myFU);
        checkUnitRatioNameAndAbbreviation(myFU, 0.002 * 9.8, 0.0001, "AntForce", "af");
    }

}