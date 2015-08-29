package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Helper class to create arbitrary SI units.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Jun 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class SIUnit extends Unit<SIUnit>
{
    /** */
    private static final long serialVersionUID = 20140615L;

    /**
     * Create an arbitrary SI unit based on a coefficient string, such as m3/cd2.
     * @param siCoefficientString String; textual description of the unit.
     */
    public SIUnit(final String siCoefficientString)
    {
        super(siCoefficientString, siCoefficientString, UnitSystem.SI_DERIVED, true);
    }

    /** {@inheritDoc} */
    @Override
    public final SIUnit getStandardUnit()
    {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return this.getAbbreviationKey().replace("SIUnit.", "");
    }

}
