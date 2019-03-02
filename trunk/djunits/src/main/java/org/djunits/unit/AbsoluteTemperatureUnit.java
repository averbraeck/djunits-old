package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * AbsoluteTemperature units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-01-30 14:23:11 +0100 (Mon, 30 Jan 2017) $, @version $Revision: 234 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AbsoluteTemperatureUnit extends AbsoluteLinearUnit<AbsoluteTemperatureUnit, TemperatureUnit>
{
    /** */
    private static final long serialVersionUID = 20140605L;

    /** The BASE unit for temperature is Kelvin. */
    public static final AbsoluteTemperatureUnit BASE;

    /** Kelvin. */
    public static final AbsoluteTemperatureUnit KELVIN;

    /** Degree Celsius. */
    public static final AbsoluteTemperatureUnit DEGREE_CELSIUS;

    /** Degree Fahrenheit. */
    public static final AbsoluteTemperatureUnit DEGREE_FAHRENHEIT;

    /** Degree Rankine. */
    public static final AbsoluteTemperatureUnit DEGREE_RANKINE;

    /** Degree Reaumur. */
    public static final AbsoluteTemperatureUnit DEGREE_REAUMUR;

    static
    {
        BASE = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.K", OTHER, 1.0, 0.0, TemperatureUnit.KELVIN);
        KELVIN = BASE;
        DEGREE_CELSIUS = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.dgC", SI_DERIVED, 1.0, 273.15,
                TemperatureUnit.DEGREE_CELSIUS);
        DEGREE_FAHRENHEIT = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.dgF", IMPERIAL, 5.0 / 9.0, 459.67,
                TemperatureUnit.DEGREE_FAHRENHEIT);
        DEGREE_RANKINE = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.dgR", OTHER, 5.0 / 9.0, 0.0,
                TemperatureUnit.DEGREE_RANKINE);
        DEGREE_REAUMUR = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.dgRe", OTHER, 4.0 / 5.0, 273.15,
                TemperatureUnit.DEGREE_REAUMUR);
    }

    /**
     * Build a AbsoluteTemperatureUnit with a conversion factor and offset to Kelvin.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit double; multiply by this number to convert to the standard unit
     * @param offsetToStandardUnit double; the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     * @param relativeUnit TemperatureUnit; the corresponding relative unit belonging to this absolute unit
     */
    private AbsoluteTemperatureUnit(final String abbreviationKey, final UnitSystem unitSystem,
            final double conversionFactorToStandardUnit, final double offsetToStandardUnit, final TemperatureUnit relativeUnit)
    {
        super(abbreviationKey, unitSystem, conversionFactorToStandardUnit, offsetToStandardUnit, relativeUnit);
    }

    /**
     * Build a user-defined AbsoluteTemperatureUnit with a conversion factor and offset to Kelvin.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit double; multiply by this number to convert to the standard unit
     * @param offsetToKelvin double; the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     * @param relativeUnit TemperatureUnit; the corresponding relative unit belonging to this absolute unit
     */
    public AbsoluteTemperatureUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final double conversionFactorToStandardUnit, final double offsetToKelvin, final TemperatureUnit relativeUnit)
    {
        super(name, abbreviation, unitSystem, conversionFactorToStandardUnit, offsetToKelvin, relativeUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperatureUnit getStandardUnit()
    {
        return KELVIN;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "K";
    }

}
