package org.djunits.unit;

import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.scale.StandardScale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * A linear unit with easy-access constructor with a linear factor, and access to the linear factor. <br>
 * A linear unit is a unit that is linearly related to the SI standard unit. E.g. Mile is linearly related to meter (the SI unit
 * for length). Unlike temperature in degrees Celsius which is <strong>not</strong> linearly related to the Kelvin (the SI unit
 * for temperature).
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the linear Unit.
 */
public abstract class LinearUnit<U extends LinearUnit<U>> extends Unit<U>
{
    /** */
    private static final long serialVersionUID = 20151011L;

    /**
     * Build a standard unit with a linear scale and create the fields for that unit. For a standard unit, a UnitException is
     * silently ignored.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public LinearUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a standard unit with a linear conversion factor to another unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit U; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    protected LinearUnit(final String abbreviationKey, final UnitSystem unitSystem, final U referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit == null ? StandardScale.SCALE
                : new LinearScale(referenceUnit.getScale().getConversionFactorToStandardUnit() * scaleFactorToReferenceUnit));
    }

    /**
     * Build a standard unit with a specific conversion scale to/from the standard unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scale Scale; the conversion scale to use for this unit
     */
    protected LinearUnit(final String abbreviationKey, final UnitSystem unitSystem, final Scale scale)
    {
        super(abbreviationKey, unitSystem, scale);
    }

    /**
     * Build a user-defined unit with a linear scale and create the fields for that unit.
     * @param name String; the name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public LinearUnit(final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem);
    }

    /**
     * Build a user-defined unit with a linear conversion factor to another unit.
     * @param name String; the name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit U; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    protected LinearUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final U referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit == null ? StandardScale.SCALE
                : new LinearScale(referenceUnit.getScale().getConversionFactorToStandardUnit() * scaleFactorToReferenceUnit));
    }

    /**
     * Build a user-defined unit with a specific conversion scale to/from the standard unit.
     * @param name String; the name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scale Scale; the conversion scale to use for this unit
     */
    protected LinearUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final Scale scale)
    {
        super(name, abbreviation, unitSystem, scale);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public LinearScale getScale()
    {
        return (LinearScale) super.getScale();
    }

    /**
     * @return the conversion factor to the standard unit (e.g., the SI unit)
     */
    public final double getScaleFactor()
    {
        return getScale().getConversionFactorToStandardUnit();
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(this.getScaleFactor());
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
        LinearUnit<?> other = (LinearUnit<?>) obj;
        if (Double.doubleToLongBits(this.getScaleFactor()) != Double.doubleToLongBits(other.getScaleFactor()))
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
        LinearUnit<?> other = (LinearUnit<?>) obj;
        if (Double.doubleToLongBits(getScaleFactor()) != Double.doubleToLongBits(other.getScaleFactor()))
            return false;
        return true;
    }

}
