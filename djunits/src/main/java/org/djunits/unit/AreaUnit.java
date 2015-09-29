package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * AreaUnit defines a number of common units for areas.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AreaUnit extends Unit<AreaUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The unit of length for the area unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for area is m^2. */
    public static final AreaUnit SI;

    /** m^2. */
    public static final AreaUnit SQUARE_METER;

    /** km^2. */
    public static final AreaUnit SQUARE_KM;

    /** cm^2. */
    public static final AreaUnit SQUARE_CENTIMETER;

    /** cm^2. */
    public static final AreaUnit SQUARE_MILLIMETER;

    /** are. */
    public static final AreaUnit ARE;

    /** hectare. */
    public static final AreaUnit HECTARE;

    /** mile^2. */
    public static final AreaUnit SQUARE_MILE;

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
        SI = new AreaUnit(LengthUnit.METER, "AreaUnit.square_meter", "AreaUnit.m^2", SI_DERIVED, true);
        SQUARE_METER = SI;
        SQUARE_KM = new AreaUnit(LengthUnit.KILOMETER, "AreaUnit.square_kilometer", "AreaUnit.km^2", SI_DERIVED, true);
        SQUARE_CENTIMETER =
            new AreaUnit(LengthUnit.CENTIMETER, "AreaUnit.square_centimeter", "AreaUnit.cm^2", SI_DERIVED, true);
        SQUARE_MILLIMETER =
            new AreaUnit(LengthUnit.MILLIMETER, "AreaUnit.square_millimeter", "AreaUnit.mm^2", SI_DERIVED, true);
        ARE = new AreaUnit("AreaUnit.are", "AreaUnit.a", OTHER, SQUARE_METER, 100.0, true);
        HECTARE = new AreaUnit("AreaUnit.hectare", "AreaUnit.ha", OTHER, ARE, 100.0, true);
        SQUARE_MILE = new AreaUnit(LengthUnit.MILE, "AreaUnit.square_mile", "AreaUnit.mi^2", IMPERIAL, true);
        SQUARE_FOOT = new AreaUnit(LengthUnit.FOOT, "AreaUnit.square_foot", "AreaUnit.ft^2", IMPERIAL, true);
        SQUARE_INCH = new AreaUnit(LengthUnit.INCH, "AreaUnit.square_inch", "AreaUnit.in^2", IMPERIAL, true);
        SQUARE_YARD = new AreaUnit(LengthUnit.YARD, "AreaUnit.square_yard", "AreaUnit.yd^2", IMPERIAL, true);
        ACRE = new AreaUnit("AreaUnit.acre", "AreaUnit.ac", IMPERIAL, SQUARE_YARD, 4840.0, true);
    }

    /**
     * Define area unit based on length.
     * @param lengthUnit the unit of length for the area unit, e.g., meter
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private AreaUnit(final LengthUnit lengthUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, SQUARE_METER, lengthUnit
            .getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.lengthUnit = lengthUnit;
    }

    /**
     * Create a user-defined area unit based on length.
     * @param lengthUnit the unit of length for the area unit, e.g., meter
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public AreaUnit(final LengthUnit lengthUnit, final String name, final String abbreviation,
        final UnitSystem unitSystem)
    {
        this(lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * This constructor constructs a unit out of another defined unit, e.g. an are is 100 m^2.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private AreaUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final AreaUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit, e.g. an are is 100 m^2.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public AreaUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final AreaUnit referenceUnit, final double conversionFactorToReferenceUnit)
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
