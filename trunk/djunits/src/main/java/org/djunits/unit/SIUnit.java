package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Helper class to create arbitrary SI units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        super(siCoefficientString, siCoefficientString, UnitSystem.SI_DERIVED);
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

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equalsIgnoreNaming(final Object obj)
    {
        // naming is done with a normalized SI-String, which should be equal when te SI units are equal.
        // Therefore, we can call the equals() method that compares class, name and abbreviation.
        return equals(obj);
    }

}
