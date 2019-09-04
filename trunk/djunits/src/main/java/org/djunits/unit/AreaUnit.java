package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * AreaUnit defines a number of common units for areas.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AreaUnit extends LinearUnit<AreaUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The unit of length for the area unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for area is m^2. */
    public static final AreaUnit SI;

    /** am^2. */
    public static final AreaUnit SQUARE_ATTOMETER;

    /** fm^2. */
    public static final AreaUnit SQUARE_FEMTOMETER;

    /** pm^2. */
    public static final AreaUnit SQUARE_PICOMETER;

    /** nm^2. */
    public static final AreaUnit SQUARE_NANOMETER;

    /** &#181;m^2. */
    public static final AreaUnit SQUARE_MICROMETER;

    /** mm^2. */
    public static final AreaUnit SQUARE_MILLIMETER;

    /** m^2. */
    public static final AreaUnit SQUARE_METER;

    /** cm^2. */
    public static final AreaUnit SQUARE_CENTIMETER;

    /** dm^2. */
    public static final AreaUnit SQUARE_DECIMETER;

    /** dam^2. */
    public static final AreaUnit SQUARE_DEKAMETER;

    /** hm^2. */
    public static final AreaUnit SQUARE_HECTOMETER;

    /** km^2. */
    public static final AreaUnit SQUARE_KILOMETER;

    /** Mm^2. */
    public static final AreaUnit SQUARE_MEGAMETER;

    /** centiare. */
    public static final AreaUnit CENTIARE;

    /** are. */
    public static final AreaUnit ARE;

    /** hectare. */
    public static final AreaUnit HECTARE;

    /** mile^2. */
    public static final AreaUnit SQUARE_MILE;

    /** Nautical mile^2. */
    public static final AreaUnit SQUARE_NAUTICAL_MILE;

    /** ft^2. */
    public static final AreaUnit SQUARE_FOOT;

    /** in^2. */
    public static final AreaUnit SQUARE_INCH;

    /** yd^2. */
    public static final AreaUnit SQUARE_YARD;

    /** acre (international). */
    public static final AreaUnit ACRE;

    static
    {
        SI = new AreaUnit(LengthUnit.METER, "AreaUnit.m^2", SI_DERIVED);
        SQUARE_METER = SI;
        SQUARE_ATTOMETER = new AreaUnit(LengthUnit.ATTOMETER, "AreaUnit.am^2", SI_DERIVED);
        SQUARE_FEMTOMETER = new AreaUnit(LengthUnit.FEMTOMETER, "AreaUnit.fm^2", SI_DERIVED);
        SQUARE_PICOMETER = new AreaUnit(LengthUnit.PICOMETER, "AreaUnit.pm^2", SI_DERIVED);
        SQUARE_NANOMETER = new AreaUnit(LengthUnit.NANOMETER, "AreaUnit.nm^2", SI_DERIVED);
        SQUARE_MICROMETER = new AreaUnit(LengthUnit.MICROMETER, "AreaUnit.mum^2", SI_DERIVED);
        SQUARE_MILLIMETER = new AreaUnit(LengthUnit.MILLIMETER, "AreaUnit.mm^2", SI_DERIVED);
        SQUARE_CENTIMETER = new AreaUnit(LengthUnit.CENTIMETER, "AreaUnit.cm^2", SI_DERIVED);
        SQUARE_DECIMETER = new AreaUnit(LengthUnit.DECIMETER, "AreaUnit.dm^2", SI_DERIVED);
        SQUARE_DEKAMETER = new AreaUnit(LengthUnit.DEKAMETER, "AreaUnit.dam^2", SI_DERIVED);
        SQUARE_HECTOMETER = new AreaUnit(LengthUnit.HECTOMETER, "AreaUnit.hm^2", SI_DERIVED);
        SQUARE_KILOMETER = new AreaUnit(LengthUnit.KILOMETER, "AreaUnit.km^2", SI_DERIVED);
        SQUARE_MEGAMETER = new AreaUnit(LengthUnit.MEGAMETER, "AreaUnit.Mm^2", SI_DERIVED);
        CENTIARE = new AreaUnit("AreaUnit.ca", OTHER, SQUARE_METER, 1.0);
        ARE = new AreaUnit("AreaUnit.a", OTHER, SQUARE_METER, 100.0);
        HECTARE = new AreaUnit("AreaUnit.ha", OTHER, ARE, 100.0);
        SQUARE_NAUTICAL_MILE = new AreaUnit(LengthUnit.NAUTICAL_MILE, "AreaUnit.Nmi^2", OTHER);
        SQUARE_MILE = new AreaUnit(LengthUnit.MILE, "AreaUnit.mi^2", IMPERIAL);
        SQUARE_FOOT = new AreaUnit(LengthUnit.FOOT, "AreaUnit.ft^2", IMPERIAL);
        SQUARE_INCH = new AreaUnit(LengthUnit.INCH, "AreaUnit.in^2", IMPERIAL);
        SQUARE_YARD = new AreaUnit(LengthUnit.YARD, "AreaUnit.yd^2", IMPERIAL);
        ACRE = new AreaUnit("AreaUnit.ac", IMPERIAL, SQUARE_YARD, 4840.0);
    }

    /**
     * Define area unit based on length.
     * @param lengthUnit LengthUnit; the unit of length for the area unit, e.g., meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private AreaUnit(final LengthUnit lengthUnit, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, SQUARE_METER, lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
    }

    /**
     * Create a user-defined area unit based on length.
     * @param lengthUnit LengthUnit; the unit of length for the area unit, e.g., meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public AreaUnit(final LengthUnit lengthUnit, final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, SQUARE_METER, lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
    }

    /**
     * This constructor constructs a unit out of another defined unit, e.g. an are is 100 m^2.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AreaUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private AreaUnit(final String abbreviationKey, final UnitSystem unitSystem, final AreaUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit, e.g. an are is 100 m^2.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AreaUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public AreaUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final AreaUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * @return lengthUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final AreaUnit getStandardUnit()
    {
        return SQUARE_METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m2";
    }

}
