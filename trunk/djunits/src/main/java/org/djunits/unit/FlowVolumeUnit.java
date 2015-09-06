package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;
import static org.djunits.unit.unitsystem.UnitSystem.US_CUSTOMARY;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The volume flow rate is the volume of fluid which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowVolumeUnit extends Unit<FlowVolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of length for the flow unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the flow unit, e.g., second. */
    private final TimeUnit timeUnit;

    /** The SI unit for volume flow rate is m^3/s. */
    public static final FlowVolumeUnit SI;

    /** m^3/s. */
    public static final FlowVolumeUnit CUBIC_METER_PER_SECOND;

    /** m^3/min. */
    public static final FlowVolumeUnit CUBIC_METER_PER_MINUTE;

    /** m^3/hour. */
    public static final FlowVolumeUnit CUBIC_METER_PER_HOUR;

    /** m^3/day. */
    public static final FlowVolumeUnit CUBIC_METER_PER_DAY;

    /** L/s. */
    public static final FlowVolumeUnit LITER_PER_SECOND;

    /** L/min. */
    public static final FlowVolumeUnit LITER_PER_MINUTE;

    /** L/hour. */
    public static final FlowVolumeUnit LITER_PER_HOUR;

    /** L/day. */
    public static final FlowVolumeUnit LITER_PER_DAY;

    /** ft^3/s. */
    public static final FlowVolumeUnit CUBIC_FEET_PER_SECOND;

    /** ft^3/min. */
    public static final FlowVolumeUnit CUBIC_FEET_PER_MINUTE;

    /** in^3/s. */
    public static final FlowVolumeUnit CUBIC_INCH_PER_SECOND;

    /** in^3/min. */
    public static final FlowVolumeUnit CUBIC_INCH_PER_MINUTE;

    /** gallon/s (US). */
    public static final FlowVolumeUnit GALLON_PER_SECOND;

    /** gallon/min (US). */
    public static final FlowVolumeUnit GALLON_PER_MINUTE;

    /** gallon/hour (US). */
    public static final FlowVolumeUnit GALLON_PER_HOUR;

    /** gallon/day (US). */
    public static final FlowVolumeUnit GALLON_PER_DAY;

    static
    {
        SI =
            new FlowVolumeUnit(LengthUnit.METER, TimeUnit.SECOND, "FlowVolumeUnit.cubic_meter_per_second",
                "FlowVolumeUnit.m^3/s", SI_DERIVED, true);
        CUBIC_METER_PER_SECOND = SI;
        CUBIC_METER_PER_MINUTE =
            new FlowVolumeUnit(LengthUnit.METER, TimeUnit.MINUTE, "FlowVolumeUnit.cubic_meter_per_minute",
                "FlowVolumeUnit.m^3/min", SI_ACCEPTED, true);
        CUBIC_METER_PER_HOUR =
            new FlowVolumeUnit(LengthUnit.METER, TimeUnit.HOUR, "FlowVolumeUnit.cubic_meter_per_hour",
                "FlowVolumeUnit.m^3/h", SI_ACCEPTED, true);
        CUBIC_METER_PER_DAY =
            new FlowVolumeUnit(LengthUnit.METER, TimeUnit.DAY, "FlowVolumeUnit.cubic_meter_per_day", "FlowVolumeUnit.m^3/d",
                SI_ACCEPTED, true);
        LITER_PER_SECOND =
            new FlowVolumeUnit(VolumeUnit.LITER, TimeUnit.SECOND, "FlowVolumeUnit.liter_per_second", "FlowVolumeUnit.L/s",
                SI_ACCEPTED, true);
        LITER_PER_MINUTE =
            new FlowVolumeUnit(VolumeUnit.LITER, TimeUnit.MINUTE, "FlowVolumeUnit.liter_per_minute", "FlowVolumeUnit.L/min",
                SI_ACCEPTED, true);
        LITER_PER_HOUR =
            new FlowVolumeUnit(VolumeUnit.LITER, TimeUnit.HOUR, "FlowVolumeUnit.liter_per_hour", "FlowVolumeUnit.L/h",
                SI_ACCEPTED, true);
        LITER_PER_DAY =
            new FlowVolumeUnit(VolumeUnit.LITER, TimeUnit.DAY, "FlowVolumeUnit.liter_per_day", "FlowVolumeUnit.L/d",
                SI_ACCEPTED, true);
        CUBIC_FEET_PER_SECOND =
            new FlowVolumeUnit(LengthUnit.FOOT, TimeUnit.SECOND, "FlowVolumeUnit.cubic_feet_per_second",
                "FlowVolumeUnit.ft^3/s", IMPERIAL, true);
        CUBIC_FEET_PER_MINUTE =
            new FlowVolumeUnit(LengthUnit.FOOT, TimeUnit.MINUTE, "FlowVolumeUnit.cubic_feet_per_minute",
                "FlowVolumeUnit.ft^3/min", IMPERIAL, true);
        CUBIC_INCH_PER_SECOND =
            new FlowVolumeUnit(LengthUnit.INCH, TimeUnit.SECOND, "FlowVolumeUnit.cubic_inch_per_second",
                "FlowVolumeUnit.in^3/s", IMPERIAL, true);
        CUBIC_INCH_PER_MINUTE =
            new FlowVolumeUnit(LengthUnit.INCH, TimeUnit.MINUTE, "FlowVolumeUnit.cubic_inch_per_minute",
                "FlowVolumeUnit.in^3/min", IMPERIAL, true);
        GALLON_PER_SECOND =
            new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, TimeUnit.SECOND, "FlowVolumeUnit.gallon_(US)_per_second",
                "FlowVolumeUnit.gal/s", US_CUSTOMARY, true);
        GALLON_PER_MINUTE =
            new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, TimeUnit.MINUTE, "FlowVolumeUnit.gallon_(US)_per_minute",
                "FlowVolumeUnit.gal/min", US_CUSTOMARY, true);
        GALLON_PER_HOUR =
            new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, TimeUnit.HOUR, "FlowVolumeUnit.gallon_(US)_per_hour",
                "FlowVolumeUnit.gal/h", US_CUSTOMARY, true);
        GALLON_PER_DAY =
            new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, TimeUnit.DAY, "FlowVolumeUnit.gallon_(US)_per_day",
                "FlowVolumeUnit.gal/d", US_CUSTOMARY, true);
    }

    /**
     * Create a flow-volumeunit based on length (cubed) per time unit.
     * @param lengthUnit the unit of length for the flow unit, e.g., meter
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FlowVolumeUnit(final LengthUnit lengthUnit, final TimeUnit timeUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, CUBIC_METER_PER_SECOND, Math.pow(lengthUnit
            .getConversionFactorToStandardUnit(), 3.0)
            / timeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.lengthUnit = lengthUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Create a user-defined flow-volumeunit based on length (cubed) per time unit.
     * @param lengthUnit the unit of length for the flow unit, e.g., meter
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public FlowVolumeUnit(final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Create a flow-volumeunit based as a volume unit per time unit.
     * @param volumeUnit the unit of volume for the flow unit, e.g., cubic meter
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FlowVolumeUnit(final VolumeUnit volumeUnit, final TimeUnit timeUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, CUBIC_METER_PER_SECOND, volumeUnit
            .getConversionFactorToStandardUnit()
            / timeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.lengthUnit = volumeUnit.getLengthUnit();
        this.timeUnit = timeUnit;
    }

    /**
     * Create a user-defined flow-volumeunit based as a volume unit per time unit.
     * @param volumeUnit the unit of volume for the flow unit, e.g., cubic meter
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public FlowVolumeUnit(final VolumeUnit volumeUnit, final TimeUnit timeUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(volumeUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Create a flow-volumeunit based on another flow-volumeunit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FlowVolumeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final FlowVolumeUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public FlowVolumeUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final FlowVolumeUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * @return lengthUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /**
     * @return timeUnit
     */
    public final TimeUnit getTimeUnit()
    {
        return this.timeUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolumeUnit getStandardUnit()
    {
        return CUBIC_METER_PER_SECOND;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m3/s";
    }

}
