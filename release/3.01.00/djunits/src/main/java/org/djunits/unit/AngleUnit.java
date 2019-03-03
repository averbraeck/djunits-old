package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.scale.GradeScale;
import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard angle unit. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Note that the Angle is <b>counter</b>clockwise.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleUnit extends Unit<AngleUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for angle is radian. */
    public static final AngleUnit SI;

    /** radian. */
    public static final AngleUnit RADIAN;

    /** percent (non-linear, 100% is 45 degrees; 90 degrees is infinite). */
    public static final AngleUnit PERCENT;

    /** degree. */
    public static final AngleUnit DEGREE;

    /** arcminute. */
    public static final AngleUnit ARCMINUTE;

    /** arcsecond. */
    public static final AngleUnit ARCSECOND;

    /** grad. */
    public static final AngleUnit GRAD;

    /** centesimal arcminute. */
    public static final AngleUnit CENTESIMAL_ARCMINUTE;

    /** centesimal arcsecond. */
    public static final AngleUnit CENTESIMAL_ARCSECOND;

    static
    {
        SI = new AngleUnit("AngleUnit.rad", SI_DERIVED);
        RADIAN = SI;
        DEGREE = new AngleUnit("AngleUnit.deg", SI_ACCEPTED, RADIAN, Math.PI / 180.0);
        ARCMINUTE = new AngleUnit("AngleUnit.arcmin", SI_ACCEPTED, DEGREE, 1.0 / 60.0);
        ARCSECOND = new AngleUnit("AngleUnit.arcsec", SI_ACCEPTED, DEGREE, 1.0 / 3600.0);
        GRAD = new AngleUnit("AngleUnit.grad", OTHER, RADIAN, 2.0 * Math.PI / 400.0);
        CENTESIMAL_ARCMINUTE = new AngleUnit("AngleUnit.centesimal_arcmin", OTHER, GRAD, 1.0 / 100.0);
        CENTESIMAL_ARCSECOND = new AngleUnit("AngleUnit.centesimal_arcsec", OTHER, GRAD, 1.0 / 10000.0);
        PERCENT = new AngleUnit("AngleUnit.perc", OTHER, new GradeScale(0.01));

    }

    /**
     * Build a standard unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private AngleUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a unit by converting it from another unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AngleUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private AngleUnit(final String abbreviationKey, final UnitSystem unitSystem, final AngleUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, new LinearScale(
                ((LinearScale) referenceUnit.getScale()).getConversionFactorToStandardUnit() * scaleFactorToReferenceUnit));
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AngleUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public AngleUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final AngleUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, new LinearScale(
                ((LinearScale) referenceUnit.getScale()).getConversionFactorToStandardUnit() * scaleFactorToReferenceUnit));
    }

    /**
     * Build an angle-slope unit with its own scale.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scale Scale; the scale to use
     */
    private AngleUnit(final String abbreviationKey, final UnitSystem unitSystem, final Scale scale)
    {
        super(abbreviationKey, unitSystem, scale);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleUnit getStandardUnit()
    {
        return RADIAN;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getScale() == null) ? 0 : getScale().hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AngleUnit other = (AngleUnit) obj;
        if (getScale() == null)
        {
            if (other.getScale() != null)
                return false;
        }
        else if (!getScale().equals(other.getScale()))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equalsIgnoreNaming(final Object obj)
    {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        AngleUnit other = (AngleUnit) obj;
        if (getScale() == null)
        {
            if (other.getScale() != null)
                return false;
        }
        else if (!getScale().equals(other.getScale()))
            return false;
        return true;
    }

}
