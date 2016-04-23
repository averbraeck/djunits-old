package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.scale.OffsetLinearScale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Temperature units.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TemperatureUnit extends Unit<TemperatureUnit>
{
    /** */
    private static final long serialVersionUID = 20140605L;

    /** The SI unit for temperature is Kelvin. */
    public static final TemperatureUnit SI;

    /** Kelvin. */
    public static final TemperatureUnit KELVIN;

    /** Degree Celsius. */
    public static final TemperatureUnit DEGREE_CELSIUS;

    /** Degree Fahrenheit. */
    public static final TemperatureUnit DEGREE_FAHRENHEIT;

    /** Degree Rankine. */
    public static final TemperatureUnit DEGREE_RANKINE;

    /** Degree Reaumur. */
    public static final TemperatureUnit DEGREE_REAUMUR;

    static
    {
        SI = new TemperatureUnit("TemperatureUnit.kelvin", "TemperatureUnit.K", SI_BASE, 1.0, 0.0, true);
        KELVIN = SI;
        DEGREE_CELSIUS =
                new TemperatureUnit("TemperatureUnit.degree_Celsius", "TemperatureUnit.dgC", SI_DERIVED, 1.0, 273.15, true);
        DEGREE_FAHRENHEIT =
                new TemperatureUnit("TemperatureUnit.degree_Fahrenheit", "TemperatureUnit.dgF", IMPERIAL, 5.0 / 9.0, 459.67,
                        true);
        DEGREE_RANKINE =
                new TemperatureUnit("TemperatureUnit.degree_Rankine", "TemperatureUnit.dgR", OTHER, 5.0 / 9.0, 0.0, true);
        DEGREE_REAUMUR =
                new TemperatureUnit("TemperatureUnit.degree_Reaumur", "TemperatureUnit.dgRe", OTHER, 4.0 / 5.0, 273.15, true);
    }

    /**
     * Build a TemperatureUnit with a conversion factor and offset to Kelvin.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit multiply by this number to convert to the standard unit
     * @param offsetToKelvin the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private TemperatureUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final double conversionFactorToStandardUnit, final double offsetToKelvin,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, new OffsetLinearScale(conversionFactorToStandardUnit,
                offsetToKelvin), standardUnit);
    }

    /**
     * Build a user-defined TemperatureUnit with a conversion factor and offset to Kelvin.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param conversionFactorToStandardUnit multiply by this number to convert to the standard unit
     * @param offsetToKelvin the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     */
    public TemperatureUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final double conversionFactorToStandardUnit, final double offsetToKelvin)
    {
        this(name, abbreviation, unitSystem, conversionFactorToStandardUnit, offsetToKelvin, false);
    }

    /** {@inheritDoc} */
    @Override
    public final TemperatureUnit getStandardUnit()
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
