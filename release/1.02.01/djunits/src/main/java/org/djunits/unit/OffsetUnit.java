package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The OffsetUnit provides a unit where scales can have an offset, such as the temperature scale. Internally, all units are
 * internally <i>stored</i> as a standard unit with an offset and a conversion factor. This means that e.g., Kelvin is stored
 * with offset 0.0 and conversion factor 1.0, whereas degree Celsius is stored with offset -273.15 and conversion factor 1.0.
 * This means that if we have a Temperature, it is stored in Kelvins, and if we want to display it in degree Celsius, we have to
 * <i>divide</i> by the conversion factor and <i>subtract</i> the offset.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @param <U> the unit type
 */
public abstract class OffsetUnit<U extends Unit<U>> extends Unit<U>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the offset that has to be taken into account for conversions. */
    private final double offsetToStandardUnit;

    /**
     * Build a standard unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    public OffsetUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, standardUnit);
        this.offsetToStandardUnit = 0.0;
    }

    /**
     * Build an offset unit with a conversion factor and offset to another unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param offsetToStandardUnit the offset to add to convert to the standard (e.g., SI) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    public OffsetUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final U referenceUnit, final double conversionFactorToReferenceUnit,
        final double offsetToStandardUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.offsetToStandardUnit = offsetToStandardUnit;
    }

    /**
     * @return offset to the standard unit. E.g., -273.15 to go from degrees Celsius to Kelvin
     */
    public final double getOffsetToStandardUnit()
    {
        return this.offsetToStandardUnit;
    }

}
