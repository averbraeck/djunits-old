package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * AbsoluteTemperature units.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
        BASE = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.kelvin", "AbsoluteTemperatureUnit.K", OTHER, 1.0, 0.0, true,
                TemperatureUnit.KELVIN);
        KELVIN = BASE;
        DEGREE_CELSIUS = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.degree_Celsius", "AbsoluteTemperatureUnit.dgC",
                SI_DERIVED, 1.0, 273.15, true, TemperatureUnit.DEGREE_CELSIUS);
        DEGREE_FAHRENHEIT = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.degree_Fahrenheit",
                "AbsoluteTemperatureUnit.dgF", IMPERIAL, 5.0 / 9.0, 459.67, true, TemperatureUnit.DEGREE_FAHRENHEIT);
        DEGREE_RANKINE = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.degree_Rankine", "AbsoluteTemperatureUnit.dgR",
                OTHER, 5.0 / 9.0, 0.0, true, TemperatureUnit.DEGREE_RANKINE);
        DEGREE_REAUMUR = new AbsoluteTemperatureUnit("AbsoluteTemperatureUnit.degree_Reaumur", "AbsoluteTemperatureUnit.dgRe",
                OTHER, 4.0 / 5.0, 273.15, true, TemperatureUnit.DEGREE_REAUMUR);
    }

    /**
     * Build a AbsoluteTemperatureUnit with a conversion factor and offset to Kelvin.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit multiply by this number to convert to the standard unit
     * @param offsetToStandardUnit the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    private AbsoluteTemperatureUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final double conversionFactorToStandardUnit, final double offsetToStandardUnit,
            final boolean standardUnit, final TemperatureUnit relativeUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, conversionFactorToStandardUnit, offsetToStandardUnit,
                standardUnit, relativeUnit);
    }

    /**
     * Build a user-defined AbsoluteTemperatureUnit with a conversion factor and offset to Kelvin.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit multiply by this number to convert to the standard unit
     * @param offsetToKelvin the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    public AbsoluteTemperatureUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final double conversionFactorToStandardUnit, final double offsetToKelvin, final TemperatureUnit relativeUnit)
    {
        this(name, abbreviation, unitSystem, conversionFactorToStandardUnit, offsetToKelvin, false, relativeUnit);
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
