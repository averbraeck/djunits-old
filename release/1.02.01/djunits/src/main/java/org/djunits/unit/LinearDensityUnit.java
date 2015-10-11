package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Objects per unit of distance.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version 11 nov. 2014 <br>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LinearDensityUnit extends Unit<LinearDensityUnit>
{
    /** */
    private static final long serialVersionUID = 20141111L;

    /** the actual length unit, e.g. meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for objects per unit of distance is 1/meter. */
    public static final LinearDensityUnit SI;

    /** 1/meter. */
    public static final LinearDensityUnit PER_METER;

    /** 1/millimeter. */
    public static final LinearDensityUnit PER_MILLIMETER;

    /** 1/centimeter. */
    public static final LinearDensityUnit PER_CENTIMETER;

    /** 1/decimeter. */
    public static final LinearDensityUnit PER_DECIMETER;

    /** 1/decameter. */
    public static final LinearDensityUnit PER_DEKAMETER;

    /** 1/hectometer. */
    public static final LinearDensityUnit PER_HECTOMETER;

    /** 1/kilometer. */
    public static final LinearDensityUnit PER_KILOMETER;

    /** 1/foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final LinearDensityUnit PER_FOOT;

    /** 1/inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final LinearDensityUnit PER_INCH;

    /** 1/mile (international) = 5280 ft = 1760 yd. */
    public static final LinearDensityUnit PER_MILE;

    /** 1/nautical mile (international) = 1852 m. */
    public static final LinearDensityUnit PER_NAUTICAL_MILE;

    /** 1/yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final LinearDensityUnit PER_YARD;

    static
    {
        SI =
            new LinearDensityUnit(LengthUnit.METER, "LinearDensityUnit.per_meter", "LinearDensityUnit./m", SI_DERIVED,
                true);
        PER_METER = SI;
        PER_MILLIMETER =
            new LinearDensityUnit("LinearDensityUnit.per_millimeter", "LinearDensityUnit./mm", SI_DERIVED, PER_METER,
                1000.0, true);
        PER_CENTIMETER =
            new LinearDensityUnit("LinearDensityUnit.per_centimeter", "LinearDensityUnit./cm", SI_DERIVED, PER_METER,
                100.0, true);
        PER_DECIMETER =
            new LinearDensityUnit("LinearDensityUnit.per_decimeter", "LinearDensityUnit./dm", SI_DERIVED, PER_METER,
                10.0, true);
        PER_DEKAMETER =
            new LinearDensityUnit("LinearDensityUnit.per_dekameter", "LinearDensityUnit./dam", SI_DERIVED, PER_METER,
                0.1, true);
        PER_HECTOMETER =
            new LinearDensityUnit("LinearDensityUnit.per_hectometer", "LinearDensityUnit./hm", SI_DERIVED, PER_METER,
                0.01, true);
        PER_KILOMETER =
            new LinearDensityUnit("LinearDensityUnit.per_kilometer", "LinearDensityUnit./km", SI_DERIVED, PER_METER,
                0.001, true);
        PER_FOOT =
            new LinearDensityUnit("LinearDensityUnit.per_foot", "LinearDensityUnit./ft", IMPERIAL, PER_METER,
                1.0 / 0.3048, true);
        PER_INCH =
            new LinearDensityUnit("LinearDensityUnit.per_inch", "LinearDensityUnit./in", IMPERIAL, PER_FOOT, 12.0, true);
        PER_MILE =
            new LinearDensityUnit("LinearDensityUnit.per_mile", "LinearDensityUnit./mi", IMPERIAL, PER_FOOT,
                1.0 / 5280.0, true);
        PER_NAUTICAL_MILE =
            new LinearDensityUnit("LinearDensityUnit.per_nauticalMile", "LinearDensityUnit./NM", IMPERIAL, PER_METER,
                1.0 / 1852.0, true);
        PER_YARD =
            new LinearDensityUnit("LinearDensityUnit.per_yard", "LinearDensityUnit./yd", IMPERIAL, PER_FOOT, 1.0 / 3.0,
                true);
    }

    /**
     * Define a LinearDensityUnit based on length. You can define unit like "per meter" here.
     * @param lengthUnit the unit of length for the linear density unit, e.g., meter
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private LinearDensityUnit(final LengthUnit lengthUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, PER_METER, 1.0 / lengthUnit
            .getConversionFactorToStandardUnit(), standardUnit);
        this.lengthUnit = lengthUnit;
    }

    /**
     * Define a user-defined LinearDensityUnit based on length. You can define unit like "per furlong" here.
     * @param lengthUnit the unit of length for the linear density unit, e.g., meter
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public LinearDensityUnit(final LengthUnit lengthUnit, final String name, final String abbreviation,
        final UnitSystem unitSystem)
    {
        this(lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a LinearDensityUnit with a conversion factor to another LinearDensityUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private LinearDensityUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final LinearDensityUnit referenceUnit,
        final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined LinearDensityUnit with a conversion factor to another LinearDensityUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public LinearDensityUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final LinearDensityUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * @return timeUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensityUnit getStandardUnit()
    {
        return PER_METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/m";
    }

}
