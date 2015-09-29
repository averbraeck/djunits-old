package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard solid angle unit.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleSolidUnit extends Unit<AngleSolidUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for solid angle is steradian. */
    public static final AngleSolidUnit SI;

    /** steradian. */
    public static final AngleSolidUnit STERADIAN;

    /** square degree. */
    public static final AngleSolidUnit SQUARE_DEGREE;

    static
    {
        SI = new AngleSolidUnit("AngleSolidUnit.steradian", "AngleSolidUnit.sr", SI_DERIVED);
        STERADIAN = SI;
        SQUARE_DEGREE =
            new AngleSolidUnit("AngleSolidUnit.square_degree", "AngleSolidUnit.sq_deg", SI_DERIVED, STERADIAN,
                (Math.PI / 180.0) * (Math.PI / 180.0), true);
    }

    /**
     * Build a standard unit.
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private AngleSolidUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /**
     * Construct a derived unit as a conversion from another unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private AngleSolidUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final AngleSolidUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public AngleSolidUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final AngleSolidUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolidUnit getStandardUnit()
    {
        return STERADIAN;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

}
