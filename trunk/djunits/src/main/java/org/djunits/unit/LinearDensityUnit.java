package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Objects per unit of distance.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class LinearDensityUnit extends LinearUnit<LinearDensityUnit>
{
    /** */
    private static final long serialVersionUID = 20141111L;

    /** the actual length unit, e.g. meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for objects per unit of distance is 1/meter. */
    public static final LinearDensityUnit SI;

    /** 1/am. */
    public static final LinearDensityUnit PER_ATTOMETER;

    /** 1/fm. */
    public static final LinearDensityUnit PER_FEMTOMETER;

    /** 1/pm. */
    public static final LinearDensityUnit PER_PICOMETER;

    /** 1/nm. */
    public static final LinearDensityUnit PER_NANOMETER;

    /** 1/&#181;m. */
    public static final LinearDensityUnit PER_MICROMETER;

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

    /** 1/megameter. */
    public static final LinearDensityUnit PER_MEGAMETER;

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

    /** 1/Astronomical Unit. */
    public static final LinearDensityUnit PER_ASTRONOMICAL_UNIT;

    /** 1/Lightyear. */
    public static final LinearDensityUnit PER_LIGHTYEAR;

    /** 1/Parsec. */
    public static final LinearDensityUnit PER_PARSEC;

    /** 1/Angstrom. */
    public static final LinearDensityUnit PER_ANGSTROM;

    static
    {
        SI = new LinearDensityUnit(LengthUnit.METER, "LinearDensityUnit./m", SI_DERIVED);
        PER_METER = SI;
        PER_ATTOMETER = new LinearDensityUnit("LinearDensityUnit./am", SI_DERIVED, PER_METER, 1.0E18);
        PER_FEMTOMETER = new LinearDensityUnit("LinearDensityUnit./fm", SI_DERIVED, PER_METER, 1.0E15);
        PER_PICOMETER = new LinearDensityUnit("LinearDensityUnit./pm", SI_DERIVED, PER_METER, 1.0E12);
        PER_NANOMETER = new LinearDensityUnit("LinearDensityUnit./nm", SI_DERIVED, PER_METER, 1.0E9);
        PER_MICROMETER = new LinearDensityUnit("LinearDensityUnit./mum", SI_DERIVED, PER_METER, 1.0E6);
        PER_MILLIMETER = new LinearDensityUnit("LinearDensityUnit./mm", SI_DERIVED, PER_METER, 1000.0);
        PER_CENTIMETER = new LinearDensityUnit("LinearDensityUnit./cm", SI_DERIVED, PER_METER, 100.0);
        PER_DECIMETER = new LinearDensityUnit("LinearDensityUnit./dm", SI_DERIVED, PER_METER, 10.0);
        PER_DEKAMETER = new LinearDensityUnit("LinearDensityUnit./dam", SI_DERIVED, PER_METER, 0.1);
        PER_HECTOMETER = new LinearDensityUnit("LinearDensityUnit./hm", SI_DERIVED, PER_METER, 0.01);
        PER_KILOMETER = new LinearDensityUnit("LinearDensityUnit./km", SI_DERIVED, PER_METER, 0.001);
        PER_MEGAMETER = new LinearDensityUnit("LinearDensityUnit./Mm", SI_DERIVED, PER_METER, 1.0E-6);
        PER_FOOT = new LinearDensityUnit("LinearDensityUnit./ft", IMPERIAL, PER_METER, 1.0 / 0.3048);
        PER_INCH = new LinearDensityUnit("LinearDensityUnit./in", IMPERIAL, PER_FOOT, 12.0);
        PER_MILE = new LinearDensityUnit("LinearDensityUnit./mi", IMPERIAL, PER_FOOT, 1.0 / 5280.0);
        PER_NAUTICAL_MILE = new LinearDensityUnit("LinearDensityUnit./NM", IMPERIAL, PER_METER, 1.0 / 1852.0);
        PER_YARD = new LinearDensityUnit("LinearDensityUnit./yd", IMPERIAL, PER_FOOT, 1.0 / 3.0);
        PER_ASTRONOMICAL_UNIT = new LinearDensityUnit("LinearDensityUnit./AU", OTHER, PER_METER, 1.0 / 149597870700.0);
        PER_LIGHTYEAR = new LinearDensityUnit("LinearDensityUnit./ly", OTHER, PER_METER, 1.0 / 9460730472580800.0);
        PER_PARSEC = new LinearDensityUnit("LinearDensityUnit./pc", OTHER, PER_LIGHTYEAR, Math.PI / 648000.0);
        PER_ANGSTROM = new LinearDensityUnit("LinearDensityUnit./A", OTHER, PER_METER, 1.0 / 1E-10);
    }

    /**
     * Define a LinearDensityUnit based on length. You can define unit like "per meter" here.
     * @param lengthUnit LengthUnit; the unit of length for the linear density unit, e.g., meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private LinearDensityUnit(final LengthUnit lengthUnit, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, PER_METER, 1.0 / lengthUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
    }

    /**
     * Define a user-defined LinearDensityUnit based on length. You can define unit like "per furlong" here.
     * @param lengthUnit LengthUnit; the unit of length for the linear density unit, e.g., meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public LinearDensityUnit(final LengthUnit lengthUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, PER_METER, 1.0 / lengthUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
    }

    /**
     * Build a LinearDensityUnit with a conversion factor to another LinearDensityUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit LinearDensityUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private LinearDensityUnit(final String abbreviationKey, final UnitSystem unitSystem, final LinearDensityUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined LinearDensityUnit with a conversion factor to another LinearDensityUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit LinearDensityUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public LinearDensityUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final LinearDensityUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * @return durationUnit
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
