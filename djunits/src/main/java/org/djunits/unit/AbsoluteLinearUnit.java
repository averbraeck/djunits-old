package org.djunits.unit;

import org.djunits.unit.scale.OffsetLinearScale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * An absolute unit is a unit that needs to be defined with a "distance" to the reference absolute unit. E.g., for Time, an
 * absolute reference unit has to be chosen such as an Epoch (e.g., 0001-01-01 AD at 00:00), where other TimeUnits can be
 * defined relative to that reference unit (e.g., POSIX time, 1-1-1970 at 00:00, which is 719162 days after the reference time).
 * <p>
 * An absolute unit is always a unit with an OffsetLinearScale. The offset defines how far away the origin of that absolute unit
 * is compared to the base unit. The linear scale indicates in what default "steps" compared to the reference relative scale the
 * absolute scale is used. For temperature, this is very clear. Degrees Celcius is shifted 273.15 compared to the origin of the
 * Kelvin scale, and the linear unit is 1 (relatively, 1 Kelvin is one degree Celcius). For Degree Fahrenheit, the linear scale
 * is 5/9, and the offset is 459.67. For Direction, North can be chosen as 0, and radians (SI) as the default angle. But one
 * could also define a NORTH_DEGREES absolute direction unit, or a WEST_RADIANS one. Similar choices can be made for time and
 * position.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Apr 27, 2017 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @param <AU> the absolute unit.
 * @param <RU> the correcponding relative unit
 */
public abstract class AbsoluteLinearUnit<AU extends LinearUnit<AU>, RU extends Unit<RU>> extends LinearUnit<AU>
        implements AbsoluteUnit
{
    /** */
    private static final long serialVersionUID = 20170427L;

    /** the corresponding relative unit belonging to this absolute unit. */
    private final RU relativeUnit;

    /**
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial; often the unit system for an absolute unit will be OTHER
     * @param scaleFactorToReferenceUnit multiply by this number to convert to the standard unit
     * @param offsetToReferenceUnit the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    protected AbsoluteLinearUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final double scaleFactorToReferenceUnit, final double offsetToReferenceUnit,
            final boolean standardUnit, final RU relativeUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem,
                new OffsetLinearScale(scaleFactorToReferenceUnit, offsetToReferenceUnit), standardUnit);
        this.relativeUnit = relativeUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final OffsetLinearScale getScale()
    {
        return (OffsetLinearScale) super.getScale();
    }

    /** {@inheritDoc} */
    @Override
    public final double getOffset()
    {
        return getScale().getOffsetToStandardUnit();
    }

    /**
     * Return the corresponding relative unit that belongs to this absolute unit.
     * @return the relative unit that belongs to this absolute unit
     */
    public final RU getRelativeUnit()
    {
        return this.relativeUnit;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getOffset());
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        AbsoluteLinearUnit<?, ?> other = (AbsoluteLinearUnit<?, ?>) obj;
        if (Double.doubleToLongBits(getOffset()) != Double.doubleToLongBits(other.getOffset()))
            return false;
        return true;
    }

}
