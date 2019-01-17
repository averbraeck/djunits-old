package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Dimensionless unit.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class DimensionlessUnit extends Unit<DimensionlessUnit>
{
    /** */
    private static final long serialVersionUID = 20150830L;

    /** The SI unit for a dimensionless unit is "1" or N/A. */
    public static final DimensionlessUnit SI;

    static
    {
        SI = new DimensionlessUnit("DimensionlessUnit.si", "DimensionlessUnit.si", OTHER);
    }

    /**
     * @param nameKey String; the key to the locale file for the long name of the unit
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private DimensionlessUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /** {@inheritDoc} */
    @Override
    public DimensionlessUnit getStandardUnit()
    {
        return SI;
    }

    /** {@inheritDoc} */
    @Override
    public String getSICoefficientsString()
    {
        return "1";
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equalsIgnoreNaming(final Object obj)
    {
        // Two DimensionlessUnit instances are always the same numerically, as they are unscaled.
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
}
