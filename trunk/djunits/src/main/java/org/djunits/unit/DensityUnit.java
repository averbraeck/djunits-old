package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard density unit based on mass and length.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new DensityUnit(MassUnit.KILOGRAM, LengthUnit.METER, "DensityUnit.kg/m^3", SI_DERIVED);
        KG_PER_METER_3 = SI;
        GRAM_PER_CENTIMETER_3 = new DensityUnit(MassUnit.GRAM, LengthUnit.CENTIMETER, "DensityUnit.g/cm^3", SI_DERIVED);
    }

    /**
     * Define density unit based on mass and length. You can define units like kg/m^3 here.
     * @param massUnit MassUnit; the unit of mass for the density unit, e.g., kg
     * @param lengthUnit LengthUnit; the unit of length for the density unit, e.g., meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private DensityUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, KG_PER_METER_3,
                massUnit.getScaleFactor() / Math.pow(lengthUnit.getScaleFactor(), 3.0));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
    }

    /**
     * Define user defined density unit based on mass and length. You can define units like kg/in^3 here.
     * @param massUnit MassUnit; the unit of mass for the density unit, e.g., kg
     * @param lengthUnit LengthUnit; the unit of length for the density unit, e.g., meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public DensityUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, KG_PER_METER_3,
                massUnit.getScaleFactor() / Math.pow(lengthUnit.getScaleFactor(), 3.0));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
    }

    /**
     * Build a unit with a conversion factor to another unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit DensityUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private DensityUnit(final String abbreviationKey, final UnitSystem unitSystem, final DensityUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit DensityUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public DensityUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final DensityUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
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
