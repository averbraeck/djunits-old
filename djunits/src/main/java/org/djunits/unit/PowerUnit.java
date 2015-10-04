package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS;
import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of power.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class PowerUnit extends Unit<PowerUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the power unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the power unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the power unit, e.g., second. */
    private final TimeUnit timeUnit;

    /** The SI unit for power is watt. */
    public static final PowerUnit SI;

    /** watt. */
    public static final PowerUnit WATT;

    /** kilowatt. */
    public static final PowerUnit KILOWATT;

    /** megawatt. */
    public static final PowerUnit MEGAWATT;

    /** gigawatt. */
    public static final PowerUnit GIGAWATT;

    /** foot-pound-force per hour. */
    public static final PowerUnit FOOT_POUND_FORCE_PER_HOUR;

    /** foot-pound-force per minute. */
    public static final PowerUnit FOOT_POUND_FORCE_PER_MINUTE;

    /** foot-pound-force per second. */
    public static final PowerUnit FOOT_POUND_FORCE_PER_SECOND;

    /** horsepower (metric). */
    public static final PowerUnit HORSEPOWER_METRIC;

    /** sthene-meter per second. */
    public static final PowerUnit STHENE_METER_PER_SECOND;

    /** erg per second. */
    public static final PowerUnit ERG_PER_SECOND;

    static
    {
        SI =
            new PowerUnit(MassUnit.KILOGRAM, LengthUnit.METER, TimeUnit.SECOND, "PowerUnit.watt", "PowerUnit.W",
                SI_DERIVED, true);
        WATT = SI;
        KILOWATT = new PowerUnit("PowerUnit.kilowatt", "PowerUnit.kW", SI_DERIVED, WATT, 1000.0, true);
        MEGAWATT = new PowerUnit("PowerUnit.megawatt", "PowerUnit.MW", SI_DERIVED, WATT, 1.0E6, true);
        GIGAWATT = new PowerUnit("PowerUnit.gigawatt", "PowerUnit.GW", SI_DERIVED, WATT, 1.0E9, true);
        FOOT_POUND_FORCE_PER_HOUR =
            new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, TimeUnit.HOUR, "PowerUnit.foot_pound-force_per_hour",
                "PowerUnit.ft.lbf/h", IMPERIAL, true);
        FOOT_POUND_FORCE_PER_MINUTE =
            new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, TimeUnit.MINUTE,
                "PowerUnit.foot_pound-force_per_minute", "PowerUnit.ft.lbf/min", IMPERIAL, true);
        FOOT_POUND_FORCE_PER_SECOND =
            new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, TimeUnit.SECOND,
                "PowerUnit.foot_pound-force_per_second", "PowerUnit.ft.lbf/s", IMPERIAL, true);
        HORSEPOWER_METRIC =
            new PowerUnit("PowerUnit.horsepower_(metric)", "PowerUnit.hp", OTHER, WATT, 735.49875, true);
        STHENE_METER_PER_SECOND =
            new PowerUnit(ForceUnit.STHENE, LengthUnit.METER, TimeUnit.SECOND, "PowerUnit.sthene-meter_per_second",
                "PowerUnit.sn.m/s", MTS, true);
        ERG_PER_SECOND =
            new PowerUnit(ForceUnit.DYNE, LengthUnit.CENTIMETER, TimeUnit.SECOND, "PowerUnit.erg_per_second",
                "PowerUnit.erg/s", CGS, true);
    }

    /**
     * Define a PowerUnit based on its constituent base units, e.g. a W = km.m^2/s^3.
     * @param massUnit the unit of mass for the power unit, e.g., kilogram
     * @param lengthUnit the unit of length for the power unit, e.g., meter
     * @param timeUnit the unit of time for the power unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private PowerUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit,
        final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, WATT, massUnit
            .getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            / Math.pow(timeUnit.getConversionFactorToStandardUnit(), 3.0), standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Define a user-defined PowerUnit based on its constituent base units, e.g. a W = km.m^2/s^3.
     * @param massUnit the unit of mass for the power unit, e.g., kilogram
     * @param lengthUnit the unit of length for the power unit, e.g., meter
     * @param timeUnit the unit of time for the power unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public PowerUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Define an PowerUnit based on a LengthUnit, a ForceUnit, and a TimeUnit, e.g. a W = N.m/s.
     * @param forceUnit the unit of force for the power unit, e.g., Newton
     * @param lengthUnit the unit of length for the power unit, e.g., meter
     * @param timeUnit the unit of time for the power unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private PowerUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit,
        final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, WATT, lengthUnit
            .getConversionFactorToStandardUnit()
            * forceUnit.getConversionFactorToStandardUnit() / timeUnit.getConversionFactorToStandardUnit(),
            standardUnit);
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.timeUnit = forceUnit.getTimeUnit();
    }

    /**
     * Define a user-defined PowerUnit based on a LengthUnit, a ForceUnit, and a TimeUnit, e.g. a W = N.m/s.
     * @param lengthUnit the unit of length for the power unit, e.g., meter
     * @param forceUnit the unit of force for the power unit, e.g., Newton
     * @param timeUnit the unit of time for the power unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public PowerUnit(final LengthUnit lengthUnit, final ForceUnit forceUnit, final TimeUnit timeUnit,
        final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this(forceUnit, lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a PowerUnit with a conversion factor to another PowerUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private PowerUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final PowerUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined PowerUnit with a conversion factor to another PowerUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public PowerUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final PowerUnit referenceUnit, final double conversionFactorToReferenceUnit)
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
    public final PowerUnit getStandardUnit()
    {
        return WATT;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s3";
    }

}
