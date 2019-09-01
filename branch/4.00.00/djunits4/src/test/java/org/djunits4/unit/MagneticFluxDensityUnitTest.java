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
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-19 11:30:26 +0200 (Mon, 19 Aug 2019) $, @version $Revision: 425 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="https://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MagneticFluxDensityUnitTest extends AbstractLinearUnitTest<MagneticFluxDensityUnit>
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
        assertEquals("kg/s2A", MagneticFluxDensityUnit.SI.getUnitBase().getSiDimensions().toString(true, false));
        checkUnitRatioNameAndAbbreviation(MagneticFluxDensityUnit.TESLA, 1, 0.000001, "tesla", "T");
    }

    /**
     * Verify that we can create our own MagneticFluxDensity unit.
     */
    @Test
    public final void createMagneticFluxDensityUnit()
    {
        MagneticFluxDensityUnit myUnit = MagneticFluxDensityUnit.SI.deriveLinear(1.23, "my", "myMagneticFluxDensity", UnitSystem.OTHER);
        assertTrue("Can create a new MagneticFluxDensityUnit", null != myUnit);
        checkUnitRatioNameAndAbbreviation(myUnit, 1.23, 0.0001, "myMagneticFluxDensity", "my");
        MagneticFluxDensityUnit.BASE.unregister(myUnit);
    }

}
