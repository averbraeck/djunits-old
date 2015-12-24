package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard density unit based on mass and length.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DensityUnit extends LinearUnit<DensityUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the actual mass unit, e.g. kg. */
    private final MassUnit massUnit;

    /** the actual length unit, e.g. meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for standard density is kg/m^3. */
    public static final DensityUnit SI;

    /** kg/m^3. */
    public static final DensityUnit KG_PER_METER_3;

    /** g/cm^3. */
    public static final DensityUnit GRAM_PER_CENTIMETER_3;

    static
    {
        SI =
            new DensityUnit(MassUnit.KILOGRAM, LengthUnit.METER, "DensityUnit.kilogram_per_cubic_meter",
                "DensityUnit.kg/m^3", SI_DERIVED, true);
        KG_PER_METER_3 = SI;
        GRAM_PER_CENTIMETER_3 =
            new DensityUnit(MassUnit.GRAM, LengthUnit.CENTIMETER, "DensityUnit.gram_per_cubic_centimeter",
                "DensityUnit.g/cm^3", SI_DERIVED, true);
    }

    /**
     * Define density unit based on mass and length. You can define units like kg/m^3 here.
     * @param massUnit the unit of mass for the density unit, e.g., kg
     * @param lengthUnit the unit of length for the density unit, e.g., meter
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private DensityUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, KG_PER_METER_3, massUnit
            .getConversionFactorToStandardUnit() / Math.pow(lengthUnit.getConversionFactorToStandardUnit(), 3.0),
            standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
    }

    /**
     * Define user defined density unit based on mass and length. You can define units like kg/in^3 here.
     * @param massUnit the unit of mass for the density unit, e.g., kg
     * @param lengthUnit the unit of length for the density unit, e.g., meter
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public DensityUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a unit with a conversion factor to another unit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private DensityUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final DensityUnit referenceUnit, final double conversionFactorToReferenceUnit,
        final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public DensityUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final DensityUnit referenceUnit, final double conversionFactorToReferenceUnit)
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

    /** {@inheritDoc} */
    @Override
    public final DensityUnit getStandardUnit()
    {
        return KG_PER_METER_3;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kg/m3";
    }

}
