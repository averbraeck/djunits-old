package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard solid angle unit.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleSolidUnit extends LinearUnit<AngleSolidUnit>
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
        SI = new AngleSolidUnit("AngleSolidUnit.sr", SI_DERIVED);
        STERADIAN = SI;
        SQUARE_DEGREE =
                new AngleSolidUnit("AngleSolidUnit.sq_deg", SI_DERIVED, STERADIAN, (Math.PI / 180.0) * (Math.PI / 180.0));
    }

    /**
     * Build a standard unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private AngleSolidUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Construct a derived unit as a conversion from another unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AngleSolidUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private AngleSolidUnit(final String abbreviationKey, final UnitSystem unitSystem, final AngleSolidUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AngleSolidUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public AngleSolidUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final AngleSolidUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
