package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Standard plane angle unit. Several conversion factors have been taken from <a
 * href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AnglePlaneUnit extends Unit<AnglePlaneUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for plane angle is radian. */
    public static final AnglePlaneUnit SI;

    /** radian. */
    public static final AnglePlaneUnit RADIAN;

    /** degree. */
    public static final AnglePlaneUnit DEGREE;

    /** arcminute. */
    public static final AnglePlaneUnit ARCMINUTE;

    /** arcsecond. */
    public static final AnglePlaneUnit ARCSECOND;

    /** grad. */
    public static final AnglePlaneUnit GRAD;

    /** centesimal arcminute. */
    public static final AnglePlaneUnit CENTESIMAL_ARCMINUTE;

    /** centesimal arcsecond. */
    public static final AnglePlaneUnit CENTESIMAL_ARCSECOND;

    static
    {
        SI = new AnglePlaneUnit("AnglePlaneUnit.radian", "AnglePlaneUnit.rad", SI_DERIVED);
        RADIAN = SI;
        DEGREE =
            new AnglePlaneUnit("AnglePlaneUnit.degree", "AnglePlaneUnit.deg", SI_ACCEPTED, RADIAN, Math.PI / 180.0,
                true);
        ARCMINUTE =
            new AnglePlaneUnit("AnglePlaneUnit.arcminute", "AnglePlaneUnit.arcmin", SI_ACCEPTED, DEGREE, 1.0 / 60.0,
                true);
        ARCSECOND =
            new AnglePlaneUnit("AnglePlaneUnit.arcsecond", "AnglePlaneUnit.arcsec", SI_ACCEPTED, DEGREE, 1.0 / 3600.0,
                true);
        GRAD =
            new AnglePlaneUnit("AnglePlaneUnit.gradian", "AnglePlaneUnit.grad", OTHER, RADIAN, 2.0 * Math.PI / 400.0,
                true);
        CENTESIMAL_ARCMINUTE =
            new AnglePlaneUnit("AnglePlaneUnit.centesimal_arcminute", "AnglePlaneUnit.centesimal_arcmin", OTHER, GRAD,
                1.0 / 100.0, true);
        CENTESIMAL_ARCSECOND =
            new AnglePlaneUnit("AnglePlaneUnit.centesimal_arcsecond", "AnglePlaneUnit.centesimal_arcsec", OTHER, GRAD,
                1.0 / 10000.0, true);
    }

    /**
     * Build a standard unit.
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private AnglePlaneUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
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
    private AnglePlaneUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final AnglePlaneUnit referenceUnit, final double conversionFactorToReferenceUnit,
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
    public AnglePlaneUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final AnglePlaneUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /** {@inheritDoc} */
    @Override
    public final AnglePlaneUnit getStandardUnit()
    {
        return RADIAN;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static double normalize(final double angle)
    {
        double normalized = angle % (2 * Math.PI);
        if (normalized < 0.0)
        {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static float normalize(final float angle)
    {
        float normalized = (float) (angle % (2 * Math.PI));
        if (normalized < 0.0)
        {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static DoubleScalar.Abs<AnglePlaneUnit> normalize(final DoubleScalar.Abs<AnglePlaneUnit> angle)
    {
        double normalized = normalize(angle.getSI()) / angle.getUnit().getConversionFactorToStandardUnit();
        return new DoubleScalar.Abs<AnglePlaneUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static DoubleScalar.Rel<AnglePlaneUnit> normalize(final DoubleScalar.Rel<AnglePlaneUnit> angle)
    {
        double normalized = normalize(angle.getSI()) / angle.getUnit().getConversionFactorToStandardUnit();
        return new DoubleScalar.Rel<AnglePlaneUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static FloatScalar.Abs<AnglePlaneUnit> normalize(final FloatScalar.Abs<AnglePlaneUnit> angle)
    {
        float normalized = (float) (normalize(angle.getSI()) / angle.getUnit().getConversionFactorToStandardUnit());
        return new FloatScalar.Abs<AnglePlaneUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle original angle.
     * @return angle between 0 and 2 * PI.
     */
    public static FloatScalar.Rel<AnglePlaneUnit> normalize(final FloatScalar.Rel<AnglePlaneUnit> angle)
    {
        float normalized = (float) (normalize(angle.getSI()) / angle.getUnit().getConversionFactorToStandardUnit());
        return new FloatScalar.Rel<AnglePlaneUnit>(normalized, angle.getUnit());
    }

}
