package org.djunits.unit;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 4, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Make the test specific for this sub class of Unit
 */
public abstract class AbstractUnitTest<U extends Unit<U>>
{
    /**
     * Verify the localization of the name and abbreviation.
     * @param u Unit to check
     * @param expectedName String; expected name in the resources
     * @param expectedAbbreviation String; expected abbreviation in the resources
     */
    protected final void checkUnitNameAndAbbreviation(final U u, final String expectedName, final String expectedAbbreviation)
    {
        assertEquals(String.format("Name of %s is %s", u.getAbbreviationKey(), expectedName), expectedName, u.getName());
        assertEquals(String.format("Abbreviation of %s is %s", u.getAbbreviationKey(), expectedAbbreviation),
                expectedAbbreviation, u.getAbbreviation());
    }

    /**
     * Check the nameKey and abbreviationKey of a Unit.
     * @param u Unit to check
     * @param expectedNameKey String; expected name key
     * @param expectedAbbreviationKey String; expected abbreviation key
     */
    protected final void checkKeys(final U u, final String expectedNameKey, final String expectedAbbreviationKey)
    {
        assertEquals("abbreviation key", expectedAbbreviationKey, u.getAbbreviationKey());
    }
}
