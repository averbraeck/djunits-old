package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of torque (moment of force).
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TorqueUnit extends Unit<TorqueUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The unit of mass for the torque unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** The unit of length for the torque unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** The unit of time for the torque unit, e.g., second. */
    private final TimeUnit timeUnit;

    /** The SI unit for torque is Newton meter. */
    public static final TorqueUnit SI;

    /** Newton meter. */
    public static final TorqueUnit NEWTON_METER;

    /** meter kilogram-force. */
    public static final TorqueUnit METER_KILOGRAM_FORCE;

    /** Pound foot. */
    public static final TorqueUnit POUND_FOOT;

    /** Pound inch. */
    public static final TorqueUnit POUND_INCH;

    static
    {
        SI =
            new TorqueUnit(MassUnit.KILOGRAM, LengthUnit.METER, TimeUnit.SECOND, "TorqueUnit.Newton_meter",
                "TorqueUnit.N.m", SI_DERIVED, true);
        NEWTON_METER = SI;
        METER_KILOGRAM_FORCE =
            new TorqueUnit(ForceUnit.KILOGRAM_FORCE, LengthUnit.METER, "TorqueUnit.meter_kilogram-force",
                "TorqueUnit.m.kgf", OTHER, true);
        POUND_FOOT =
            new TorqueUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, "TorqueUnit.pound-foot", "TorqueUnit.lbf.ft",
                IMPERIAL, true);
        POUND_INCH =
            new TorqueUnit(ForceUnit.POUND_FORCE, LengthUnit.INCH, "TorqueUnit.pound-inch", "TorqueUnit.lbf.in",
                IMPERIAL, true);
    }

    /**
     * Create a torque unit from mass, length and time units.
     * @param massUnit the unit of mass for the torque unit, e.g., kilogram
     * @param lengthUnit the unit of length for the torque unit, e.g., meter
     * @param timeUnit the unit of time for the torque unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private TorqueUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit,
        final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, NEWTON_METER, massUnit
            .getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            / (timeUnit.getConversionFactorToStandardUnit() * timeUnit.getConversionFactorToStandardUnit()),
            standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Create a user-defined torque unit from mass, length and time units.
     * @param massUnit the unit of mass for the torque unit, e.g., kilogram
     * @param lengthUnit the unit of length for the torque unit, e.g., meter
     * @param timeUnit the unit of time for the torque unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public TorqueUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Create a torque unit from force and length units.
     * @param forceUnit the unit of force for the torque unit, e.g., Newton
     * @param lengthUnit the unit of length for the torque unit, e.g., meter
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private TorqueUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, NEWTON_METER, forceUnit
            .getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.timeUnit = forceUnit.getTimeUnit();
    }

    /**
     * Create a user-defined torque unit from force and length units.
     * @param forceUnit the unit of force for the torque unit, e.g., Newton
     * @param lengthUnit the unit of length for the torque unit, e.g., meter
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public TorqueUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(forceUnit, lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Construct a torque unit based on another torque unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private TorqueUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final TorqueUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
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
    public TorqueUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final TorqueUnit referenceUnit, final double conversionFactorToReferenceUnit)
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
    public final TorqueUnit getStandardUnit()
    {
        return NEWTON_METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s2";
    }

}
