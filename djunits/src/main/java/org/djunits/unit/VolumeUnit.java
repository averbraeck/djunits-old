package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;
import static org.djunits.unit.unitsystem.UnitSystem.US_CUSTOMARY;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * VolumeUnit defines a number of common units for volumes.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class VolumeUnit extends LinearUnit<VolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20140604L;

    /** The unit of length for the volume unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** The SI unit for volume is m^3. */
    public static final VolumeUnit SI;

    /** am^3. */
    public static final VolumeUnit CUBIC_ATTOMETER;

    /** fm^3. */
    public static final VolumeUnit CUBIC_FEMTOMETER;

    /** pm^3. */
    public static final VolumeUnit CUBIC_PICOMETER;

    /** nm^3. */
    public static final VolumeUnit CUBIC_NANOMETER;

    /** &#181;m^3. */
    public static final VolumeUnit CUBIC_MICROMETER;

    /** mm^3. */
    public static final VolumeUnit CUBIC_MILLIMETER;

    /** cm^3. */
    public static final VolumeUnit CUBIC_CENTIMETER;

    /** dm^3. */
    public static final VolumeUnit CUBIC_DECIMETER;

    /** m^3. */
    public static final VolumeUnit CUBIC_METER;

    /** dam^3. */
    public static final VolumeUnit CUBIC_DEKAMETER;

    /** hm^3. */
    public static final VolumeUnit CUBIC_HECTOMETER;

    /** km^3. */
    public static final VolumeUnit CUBIC_KILOMETER;

    /** Mm^3. */
    public static final VolumeUnit CUBIC_MEGAMETER;

    /** liter. */
    public static final VolumeUnit LITER;

    /** mile^3. */
    public static final VolumeUnit CUBIC_MILE;

    /** ft^3. */
    public static final VolumeUnit CUBIC_FOOT;

    /** in^3. */
    public static final VolumeUnit CUBIC_INCH;

    /** yd^3. */
    public static final VolumeUnit CUBIC_YARD;

    /** gallon (US), fluids. */
    public static final VolumeUnit GALLON_US_FLUID;

    /** gallon (imperial). */
    public static final VolumeUnit GALLON_IMP;

    /** ounce (fluid US). */
    public static final VolumeUnit OUNCE_US_FLUID;

    /** ounce (fluid imperial). */
    public static final VolumeUnit OUNCE_IMP_FLUID;

    /** pint (fluid US). */
    public static final VolumeUnit PINT_US_FLUID;

    /** pint (imperial). */
    public static final VolumeUnit PINT_IMP;

    /** quart (fluid US). */
    public static final VolumeUnit QUART_US_FLUID;

    /** quart (imperial). */
    public static final VolumeUnit QUART_IMP;

    /** Cubic lightyear. */
    public static final VolumeUnit CUBIC_LIGHTYEAR;

    /** Cubic Parsec. */
    public static final VolumeUnit CUBIC_PARSEC;

    static
    {
        SI = new VolumeUnit(LengthUnit.METER, "VolumeUnit.m^3", SI_DERIVED);
        CUBIC_METER = SI;
        CUBIC_ATTOMETER = new VolumeUnit(LengthUnit.ATTOMETER, "VolumeUnit.am^3", SI_DERIVED);
        CUBIC_FEMTOMETER = new VolumeUnit(LengthUnit.FEMTOMETER, "VolumeUnit.fm^3", SI_DERIVED);
        CUBIC_PICOMETER = new VolumeUnit(LengthUnit.PICOMETER, "VolumeUnit.pm^3", SI_DERIVED);
        CUBIC_NANOMETER = new VolumeUnit(LengthUnit.NANOMETER, "VolumeUnit.nm^3", SI_DERIVED);
        CUBIC_MICROMETER = new VolumeUnit(LengthUnit.MICROMETER, "VolumeUnit.mum^3", SI_DERIVED);
        CUBIC_MILLIMETER = new VolumeUnit(LengthUnit.MILLIMETER, "VolumeUnit.mm^3", SI_DERIVED);
        CUBIC_CENTIMETER = new VolumeUnit(LengthUnit.CENTIMETER, "VolumeUnit.cm^3", SI_DERIVED);
        CUBIC_DECIMETER = new VolumeUnit(LengthUnit.DECIMETER, "VolumeUnit.dm^3", SI_DERIVED);
        CUBIC_DEKAMETER = new VolumeUnit(LengthUnit.DEKAMETER, "VolumeUnit.dam^3", SI_DERIVED);
        CUBIC_HECTOMETER = new VolumeUnit(LengthUnit.HECTOMETER, "VolumeUnit.hm^3", SI_DERIVED);
        CUBIC_KILOMETER = new VolumeUnit(LengthUnit.KILOMETER, "VolumeUnit.km^3", SI_DERIVED);
        CUBIC_MEGAMETER = new VolumeUnit(LengthUnit.MEGAMETER, "VolumeUnit.Mm^3", SI_DERIVED);
        LITER = new VolumeUnit("VolumeUnit.L", SI_ACCEPTED, CUBIC_DECIMETER, 1.0);
        CUBIC_MILE = new VolumeUnit(LengthUnit.MILE, "VolumeUnit.mi^3", IMPERIAL);
        CUBIC_FOOT = new VolumeUnit(LengthUnit.FOOT, "VolumeUnit.ft^3", IMPERIAL);
        CUBIC_INCH = new VolumeUnit(LengthUnit.INCH, "VolumeUnit.in^3", IMPERIAL);
        CUBIC_YARD = new VolumeUnit(LengthUnit.YARD, "VolumeUnit.yd^3", IMPERIAL);
        GALLON_US_FLUID = new VolumeUnit("VolumeUnit.gal(US)", US_CUSTOMARY, CUBIC_INCH, 231.0);
        GALLON_IMP = new VolumeUnit("VolumeUnit.gal(imp)", IMPERIAL, LITER, 4.5409);
        OUNCE_US_FLUID = new VolumeUnit("VolumeUnit.US_fl_oz", US_CUSTOMARY, GALLON_US_FLUID, 1.0 / 128.0);
        OUNCE_IMP_FLUID = new VolumeUnit("VolumeUnit.fl_oz_(imp)", IMPERIAL, GALLON_IMP, 1.0 / 160.0);
        PINT_US_FLUID = new VolumeUnit("VolumeUnit.pt(US_fl)", US_CUSTOMARY, GALLON_US_FLUID, 1.0 / 8.0);
        PINT_IMP = new VolumeUnit("VolumeUnit.pt_(imp)", IMPERIAL, GALLON_IMP, 1.0 / 8.0);
        QUART_US_FLUID = new VolumeUnit("VolumeUnit.qt(US_fl)", US_CUSTOMARY, GALLON_US_FLUID, 1.0 / 4.0);
        QUART_IMP = new VolumeUnit("VolumeUnit.qt_(imp)", IMPERIAL, GALLON_IMP, 1.0 / 4.0);
        CUBIC_LIGHTYEAR = new VolumeUnit(LengthUnit.LIGHTYEAR, "VolumeUnit.ly^3", SI_DERIVED);
        CUBIC_PARSEC = new VolumeUnit(LengthUnit.PARSEC, "VolumeUnit.pc^3", SI_DERIVED);
    }

    /**
     * Define volume unit based on length, e.g. a m^3 is based on meters.
     * @param lengthUnit LengthUnit; the unit of length for the speed unit, e.g., meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private VolumeUnit(final LengthUnit lengthUnit, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, CUBIC_METER, Math.pow(lengthUnit.getScaleFactor(), 3));
        this.lengthUnit = lengthUnit;
    }

    /**
     * Define a user-defined volume unit based on length, e.g. a m^3 is based on meters.
     * @param lengthUnit LengthUnit; the unit of length for the speed unit, e.g., meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public VolumeUnit(final LengthUnit lengthUnit, final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, CUBIC_METER, Math.pow(lengthUnit.getScaleFactor(), 3));
        this.lengthUnit = lengthUnit;
    }

    /**
     * This constructor constructs a uVolumeUnitnit out of another defined VolumeUnit, e.g. quart is 0.25 gallon.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit VolumeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private VolumeUnit(final String abbreviationKey, final UnitSystem unitSystem, final VolumeUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined VolumeUnit with a conversion factor to another VolumeUnit, e.g. quart is 0.25 gallon.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit VolumeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public VolumeUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final VolumeUnit referenceUnit,
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
    public final VolumeUnit getStandardUnit()
    {
        return CUBIC_METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m3";
    }

}
