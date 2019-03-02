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
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class PowerUnit extends LinearUnit<PowerUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the power unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the power unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the power unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for power is watt. */
    public static final PowerUnit SI;

    /** femtowatt. */
    public static final PowerUnit FEMTOWATT;

    /** picowatt. */
    public static final PowerUnit PICOWATT;

    /** nanowatt. */
    public static final PowerUnit NANOWATT;

    /** microwatt. */
    public static final PowerUnit MICROWATT;

    /** milliwatt. */
    public static final PowerUnit MILLIWATT;

    /** watt. */
    public static final PowerUnit WATT;

    /** kiloawatt. */
    public static final PowerUnit KILOWATT;

    /** megawatt. */
    public static final PowerUnit MEGAWATT;

    /** gigawatt. */
    public static final PowerUnit GIGAWATT;

    /** terawatt. */
    public static final PowerUnit TERAWATT;

    /** petawatt. */
    public static final PowerUnit PETAWATT;

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
        SI = new PowerUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "PowerUnit.W", SI_DERIVED);
        WATT = SI;
        FEMTOWATT = new PowerUnit("PowerUnit.fW", SI_DERIVED, WATT, 1.0E-15);
        PICOWATT = new PowerUnit("PowerUnit.pW", SI_DERIVED, WATT, 1.0E-12);
        NANOWATT = new PowerUnit("PowerUnit.nW", SI_DERIVED, WATT, 1.0E-9);
        MICROWATT = new PowerUnit("PowerUnit.muW", SI_DERIVED, WATT, 1.0E-6);
        MILLIWATT = new PowerUnit("PowerUnit.mW", SI_DERIVED, WATT, 1.0E-3);
        KILOWATT = new PowerUnit("PowerUnit.kW", SI_DERIVED, WATT, 1.0E3);
        MEGAWATT = new PowerUnit("PowerUnit.MW", SI_DERIVED, WATT, 1.0E6);
        GIGAWATT = new PowerUnit("PowerUnit.GW", SI_DERIVED, WATT, 1.0E9);
        TERAWATT = new PowerUnit("PowerUnit.TW", SI_DERIVED, WATT, 1.0E12);
        PETAWATT = new PowerUnit("PowerUnit.PW", SI_DERIVED, WATT, 1.0E15);
        FOOT_POUND_FORCE_PER_HOUR =
                new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, DurationUnit.HOUR, "PowerUnit.ft.lbf/h", IMPERIAL);
        FOOT_POUND_FORCE_PER_MINUTE =
                new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, DurationUnit.MINUTE, "PowerUnit.ft.lbf/min", IMPERIAL);
        FOOT_POUND_FORCE_PER_SECOND =
                new PowerUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, DurationUnit.SECOND, "PowerUnit.ft.lbf/s", IMPERIAL);
        HORSEPOWER_METRIC = new PowerUnit("PowerUnit.hp", OTHER, WATT, 735.49875);
        STHENE_METER_PER_SECOND =
                new PowerUnit(ForceUnit.STHENE, LengthUnit.METER, DurationUnit.SECOND, "PowerUnit.sn.m/s", MTS);
        ERG_PER_SECOND = new PowerUnit(ForceUnit.DYNE, LengthUnit.CENTIMETER, DurationUnit.SECOND, "PowerUnit.erg/s", CGS);
    }

    /**
     * Define a PowerUnit based on its constituent base units, e.g. a W = km.m^2/s^3.
     * @param massUnit MassUnit; the unit of mass for the power unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the power unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the power unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private PowerUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, WATT, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / Math.pow(durationUnit.getScaleFactor(), 3.0));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined PowerUnit based on its constituent base units, e.g. a W = km.m^2/s^3.
     * @param massUnit MassUnit; the unit of mass for the power unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the power unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the power unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public PowerUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, WATT, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / Math.pow(durationUnit.getScaleFactor(), 3.0));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define an PowerUnit based on a LengthUnit, a ForceUnit, and a TimeUnit, e.g. a W = N.m/s.
     * @param forceUnit ForceUnit; the unit of force for the power unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the power unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the power unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private PowerUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, WATT,
                lengthUnit.getScaleFactor() * forceUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Define a user-defined PowerUnit based on a LengthUnit, a ForceUnit, and a TimeUnit, e.g. a W = N.m/s.
     * @param lengthUnit LengthUnit; the unit of length for the power unit, e.g., meter
     * @param forceUnit ForceUnit; the unit of force for the power unit, e.g., Newton
     * @param durationUnit DurationUnit; the unit of time for the power unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public PowerUnit(final LengthUnit lengthUnit, final ForceUnit forceUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, WATT,
                lengthUnit.getScaleFactor() * forceUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Build a PowerUnit with a conversion factor to another PowerUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit PowerUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private PowerUnit(final String abbreviationKey, final UnitSystem unitSystem, final PowerUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined PowerUnit with a conversion factor to another PowerUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit PowerUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public PowerUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final PowerUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
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
