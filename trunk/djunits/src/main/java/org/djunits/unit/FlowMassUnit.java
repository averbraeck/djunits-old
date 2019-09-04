package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The mass flow rate is the mass of a substance which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowMassUnit extends LinearUnit<FlowMassUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the flow unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of time for the flow unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for mass flow rate is kg/s. */
    public static final FlowMassUnit SI;

    /** kg/s. */
    public static final FlowMassUnit KILOGRAM_PER_SECOND;

    /** lb/s. */
    public static final FlowMassUnit POUND_PER_SECOND;

    static
    {
        SI = new FlowMassUnit(MassUnit.KILOGRAM, DurationUnit.SECOND, "FlowMassUnit.kg/s", SI_DERIVED);
        KILOGRAM_PER_SECOND = SI;
        POUND_PER_SECOND = new FlowMassUnit(MassUnit.POUND, DurationUnit.SECOND, "FlowMassUnit.lb/s", IMPERIAL);
    }

    /**
     * Create a flow-massunit based on mass and time.
     * @param massUnit MassUnit; the unit of mass for the flow unit, e.g., kilogram
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private FlowMassUnit(final MassUnit massUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, KILOGRAM_PER_SECOND, massUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.massUnit = massUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a user-defined flow-massunit based on mass and time.
     * @param massUnit MassUnit; the unit of mass for the flow unit, e.g., kilogram
     * @param durationUnit DurationUnit; the unit of time for the flow unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public FlowMassUnit(final MassUnit massUnit, final DurationUnit durationUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, KILOGRAM_PER_SECOND, massUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.massUnit = massUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a flow-massunit based on another flow-massunit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FlowMassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private FlowMassUnit(final String abbreviationKey, final UnitSystem unitSystem, final FlowMassUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FlowMassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public FlowMassUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final FlowMassUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * @return massUnit
     */
    public final MassUnit getMassUnit()
    {
        return this.massUnit;
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
    public final FlowMassUnit getStandardUnit()
    {
        return KILOGRAM_PER_SECOND;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kg/s";
    }

}
