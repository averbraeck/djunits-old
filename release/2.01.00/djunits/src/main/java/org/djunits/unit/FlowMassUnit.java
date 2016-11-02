package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The mass flow rate is the mass of a substance which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowMassUnit extends LinearUnit<FlowMassUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the flow unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of time for the flow unit, e.g., second. */
    private final TimeUnit timeUnit;

    /** The SI unit for mass flow rate is kg/s. */
    public static final FlowMassUnit SI;

    /** kg/s. */
    public static final FlowMassUnit KILOGRAM_PER_SECOND;

    /** lb/s. */
    public static final FlowMassUnit POUND_PER_SECOND;

    static
    {
        SI =
                new FlowMassUnit(MassUnit.KILOGRAM, TimeUnit.SECOND, "FlowMassUnit.kilogram_per_second", "FlowMassUnit.kg/s",
                        SI_DERIVED, true);
        KILOGRAM_PER_SECOND = SI;
        POUND_PER_SECOND =
                new FlowMassUnit(MassUnit.POUND, TimeUnit.SECOND, "FlowMassUnit.pound_per_second", "FlowMassUnit.lb/s",
                        IMPERIAL, true);
    }

    /**
     * Create a flow-massunit based on mass and time.
     * @param massUnit the unit of mass for the flow unit, e.g., kilogram
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FlowMassUnit(final MassUnit massUnit, final TimeUnit timeUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, KILOGRAM_PER_SECOND, massUnit
                .getConversionFactorToStandardUnit() / timeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.massUnit = massUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Create a user-defined flow-massunit based on mass and time.
     * @param massUnit the unit of mass for the flow unit, e.g., kilogram
     * @param timeUnit the unit of time for the flow unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public FlowMassUnit(final MassUnit massUnit, final TimeUnit timeUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(massUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Create a flow-massunit based on another flow-massunit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FlowMassUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final FlowMassUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
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
    public FlowMassUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final FlowMassUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * @return massUnit
     */
    public final MassUnit getMassUnit()
    {
        return this.massUnit;
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
