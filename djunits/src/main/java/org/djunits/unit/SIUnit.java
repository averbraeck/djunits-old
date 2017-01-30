package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Helper class to create arbitrary SI units.
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
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

    /**
     * Create an arbitrary SI unit based on a coefficient string, such as m3/cd2.
     * @param siCoefficientString String; textual description of the unit.
     * @param standardUnit boolean; if true; the new unit is standard and there should be localization info; if false;
     *            localization will not be available
     */
    public SIUnit(final String siCoefficientString, final boolean standardUnit)
    {
        super(siCoefficientString, siCoefficientString, UnitSystem.SI_DERIVED, standardUnit);
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
        if (null == this.getAbbreviationKey())
        {
            return this.getAbbreviation().replace("SIUnit.", ""); // FIXME: this is horrible / PK
            // We need a better way to determine if a unit is supposed to have localization information.
        }
        return this.getAbbreviationKey().replace("SIUnit.", "");
    }

}
