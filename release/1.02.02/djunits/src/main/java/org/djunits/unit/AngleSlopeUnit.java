package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.scale.GradeScale;
import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard slope angle unit. Several conversion factors have been taken from <a
 * href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleSlopeUnit extends Unit<AngleSlopeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for slope angle is radian. */
    public static final AngleSlopeUnit SI;

    /** radian. */
    public static final AngleSlopeUnit RADIAN;

    /** percent. */
    public static final AngleSlopeUnit PERCENT;

    /** degree. */
    public static final AngleSlopeUnit DEGREE;

    /** arcminute. */
    public static final AngleSlopeUnit ARCMINUTE;

    /** arcsecond. */
    public static final AngleSlopeUnit ARCSECOND;

    /** grad. */
    public static final AngleSlopeUnit GRAD;

    /** centesimal arcminute. */
    public static final AngleSlopeUnit CENTESIMAL_ARCMINUTE;

    /** centesimal arcsecond. */
    public static final AngleSlopeUnit CENTESIMAL_ARCSECOND;

    static
    {
        SI = new AngleSlopeUnit("AngleSlopeUnit.radian", "AngleSlopeUnit.rad", SI_DERIVED);
        RADIAN = SI;
        DEGREE =
            new AngleSlopeUnit("AngleSlopeUnit.degree", "AngleSlopeUnit.deg", SI_ACCEPTED, RADIAN, Math.PI / 180.0,
                true);
        ARCMINUTE =
            new AngleSlopeUnit("AngleSlopeUnit.arcminute", "AngleSlopeUnit.arcmin", SI_ACCEPTED, DEGREE, 1.0 / 60.0,
                true);
        ARCSECOND =
            new AngleSlopeUnit("AngleSlopeUnit.arcsecond", "AngleSlopeUnit.arcsec", SI_ACCEPTED, DEGREE, 1.0 / 3600.0,
                true);
        GRAD =
            new AngleSlopeUnit("AngleSlopeUnit.gradian", "AngleSlopeUnit.grad", OTHER, RADIAN, 2.0 * Math.PI / 400.0,
                true);
        CENTESIMAL_ARCMINUTE =
            new AngleSlopeUnit("AngleSlopeUnit.centesimal_arcminute", "AngleSlopeUnit.centesimal_arcmin", OTHER, GRAD,
                1.0 / 100.0, true);
        CENTESIMAL_ARCSECOND =
            new AngleSlopeUnit("AngleSlopeUnit.centesimal_arcsecond", "AngleSlopeUnit.centesimal_arcsec", OTHER, GRAD,
                1.0 / 10000.0, true);
        PERCENT =
            new AngleSlopeUnit("AngleSlopeUnit.percent", "AngleSlopeUnit.perc", OTHER, new GradeScale(0.01), true);

    }

    /**
     * Build a standard unit.
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private AngleSlopeUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /**
     * Build a unit by converting it from another unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private AngleSlopeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final AngleSlopeUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, new LinearScale(((LinearScale) referenceUnit
            .getScale()).getConversionFactorToStandardUnit()
            * conversionFactorToReferenceUnit), standardUnit);
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public AngleSlopeUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final AngleSlopeUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * Build an angle-slope unit with its own scale.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scale the scale to use
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private AngleSlopeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final Scale scale, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, scale, standardUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlopeUnit getStandardUnit()
    {
        return RADIAN;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

}