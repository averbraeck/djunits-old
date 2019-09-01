package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;
import static org.djunits.unit.unitsystem.UnitSystem.US_CUSTOMARY;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The volume flow rate is the volume of fluid which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowVolumeUnit extends LinearUnit<FlowVolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of length for the flow unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the flow unit, e.g., second. */
    private final DurationUnit durationUnit;

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
        SI = new FlowVolumeUnit(LengthUnit.METER, DurationUnit.SECOND, "FlowVolumeUnit.m^3/s", SI_DERIVED);
        CUBIC_METER_PER_SECOND = SI;
        CUBIC_METER_PER_MINUTE =
                new FlowVolumeUnit(LengthUnit.METER, DurationUnit.MINUTE, "FlowVolumeUnit.m^3/min", SI_ACCEPTED);
        CUBIC_METER_PER_HOUR = new FlowVolumeUnit(LengthUnit.METER, DurationUnit.HOUR, "FlowVolumeUnit.m^3/h", SI_ACCEPTED);
        CUBIC_METER_PER_DAY = new FlowVolumeUnit(LengthUnit.METER, DurationUnit.DAY, "FlowVolumeUnit.m^3/d", SI_ACCEPTED);
        LITER_PER_SECOND = new FlowVolumeUnit(VolumeUnit.LITER, DurationUnit.SECOND, "FlowVolumeUnit.L/s", SI_ACCEPTED);
        LITER_PER_MINUTE = new FlowVolumeUnit(VolumeUnit.LITER, DurationUnit.MINUTE, "FlowVolumeUnit.L/min", SI_ACCEPTED);
        LITER_PER_HOUR = new FlowVolumeUnit(VolumeUnit.LITER, DurationUnit.HOUR, "FlowVolumeUnit.L/h", SI_ACCEPTED);
        LITER_PER_DAY = new FlowVolumeUnit(VolumeUnit.LITER, DurationUnit.DAY, "FlowVolumeUnit.L/d", SI_ACCEPTED);
        CUBIC_FEET_PER_SECOND = new FlowVolumeUnit(LengthUnit.FOOT, DurationUnit.SECOND, "FlowVolumeUnit.ft^3/s", IMPERIAL);
        CUBIC_FEET_PER_MINUTE = new FlowVolumeUnit(LengthUnit.FOOT, DurationUnit.MINUTE, "FlowVolumeUnit.ft^3/min", IMPERIAL);
        CUBIC_INCH_PER_SECOND = new FlowVolumeUnit(LengthUnit.INCH, DurationUnit.SECOND, "FlowVolumeUnit.in^3/s", IMPERIAL);
        CUBIC_INCH_PER_MINUTE = new FlowVolumeUnit(LengthUnit.INCH, DurationUnit.MINUTE, "FlowVolumeUnit.in^3/min", IMPERIAL);
        GALLON_PER_SECOND =
                new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, DurationUnit.SECOND, "FlowVolumeUnit.gal/s", US_CUSTOMARY);
        GALLON_PER_MINUTE =
                new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, DurationUnit.MINUTE, "FlowVolumeUnit.gal/min", US_CUSTOMARY);
        GALLON_PER_HOUR =
                new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, DurationUnit.HOUR, "FlowVolumeUnit.gal/h", US_CUSTOMARY);
        GALLON_PER_DAY = new FlowVolumeUnit(VolumeUnit.GALLON_US_FLUID, DurationUnit.DAY, "FlowVolumeUnit.gal/d", US_CUSTOMARY);
    }

    /**
     * Create a flow-volumeunit based on length (cubed) per time unit.
     * @param lengthUnit LengthUnit; the unit of length for the flow unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private FlowVolumeUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, CUBIC_METER_PER_SECOND,
                Math.pow(lengthUnit.getScaleFactor(), 3.0) / durationUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a user-defined flow-volumeunit based on length (cubed) per time unit.
     * @param lengthUnit LengthUnit; the unit of length for the flow unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public FlowVolumeUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, CUBIC_METER_PER_SECOND,
                Math.pow(lengthUnit.getScaleFactor(), 3.0) / durationUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a flow-volumeunit based as a volume unit per time unit.
     * @param volumeUnit VolumeUnit; the unit of volume for the flow unit, e.g., cubic meter
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private FlowVolumeUnit(final VolumeUnit volumeUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, CUBIC_METER_PER_SECOND, volumeUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.lengthUnit = volumeUnit.getLengthUnit();
        this.durationUnit = durationUnit;
    }

    /**
     * Create a user-defined flow-volumeunit based as a volume unit per time unit.
     * @param volumeUnit VolumeUnit; the unit of volume for the flow unit, e.g., cubic meter
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public FlowVolumeUnit(final VolumeUnit volumeUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, CUBIC_METER_PER_SECOND,
                volumeUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.lengthUnit = volumeUnit.getLengthUnit();
        this.durationUnit = durationUnit;
    }

    /**
     * Create a flow-volumeunit based on another flow-volumeunit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FlowVolumeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private FlowVolumeUnit(final String abbreviationKey, final UnitSystem unitSystem, final FlowVolumeUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FlowVolumeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public FlowVolumeUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final FlowVolumeUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * @return lengthUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /**
     * @return durationUnit
     */
    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
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
