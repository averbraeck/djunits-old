package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Temperature units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TemperatureUnit extends LinearUnit<TemperatureUnit>
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
        SI = new TemperatureUnit("TemperatureUnit.K", SI_BASE);
        KELVIN = SI;
        DEGREE_CELSIUS = new TemperatureUnit("TemperatureUnit.dgC", SI_DERIVED, KELVIN, 1.0);
        DEGREE_FAHRENHEIT = new TemperatureUnit("TemperatureUnit.dgF", IMPERIAL, KELVIN, 5.0 / 9.0);
        DEGREE_RANKINE = new TemperatureUnit("TemperatureUnit.dgR", OTHER, KELVIN, 5.0 / 9.0);
        DEGREE_REAUMUR = new TemperatureUnit("TemperatureUnit.dgRe", OTHER, KELVIN, 4.0 / 5.0);
    }

    /**
     * Build a standard TemperatureUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private TemperatureUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a standard TemperatureUnit with a conversion factor and offset to Kelvin.
     * @param abbreviationKey String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit TemperatureUnit; the unit to convert to
     * @param scaleFactorToStandardUnit double; multiply by this number to convert to the standard unit
     */
    private TemperatureUnit(final String abbreviationKey, final UnitSystem unitSystem, final TemperatureUnit referenceUnit,
            final double scaleFactorToStandardUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToStandardUnit);
    }

    /**
     * Build a user-defined TemperatureUnit with a conversion factor and offset to Kelvin.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit TemperatureUnit; the unit to convert to
     * @param scaleFactorToStandardUnit double; multiply by this number to convert to the standard unit
     * @param offsetToKelvin double; the offsetToKelvin to add to convert to the standard (e.g., SI) unit
     */
    public TemperatureUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final TemperatureUnit referenceUnit, final double scaleFactorToStandardUnit, final double offsetToKelvin)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToStandardUnit);
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
