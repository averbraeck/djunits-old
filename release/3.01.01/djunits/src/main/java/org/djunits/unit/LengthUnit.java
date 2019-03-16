package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard length units. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class LengthUnit extends LinearUnit<LengthUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for length is meter. */
    public static final LengthUnit SI;

    /** am. */
    public static final LengthUnit ATTOMETER;

    /** fm. */
    public static final LengthUnit FEMTOMETER;

    /** pm. */
    public static final LengthUnit PICOMETER;

    /** nm. */
    public static final LengthUnit NANOMETER;

    /** &#181;m. */
    public static final LengthUnit MICROMETER;

    /** mm. */
    public static final LengthUnit MILLIMETER;

    /** m. */
    public static final LengthUnit METER;

    /** cm. */
    public static final LengthUnit CENTIMETER;

    /** dm. */
    public static final LengthUnit DECIMETER;

    /** dam. */
    public static final LengthUnit DEKAMETER;

    /** hm. */
    public static final LengthUnit HECTOMETER;

    /** km. */
    public static final LengthUnit KILOMETER;

    /** Mm. */
    public static final LengthUnit MEGAMETER;

    /** inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final LengthUnit INCH;

    /** foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final LengthUnit FOOT;

    /** yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final LengthUnit YARD;

    /** mile (international) = 5280 ft = 1760 yd. */
    public static final LengthUnit MILE;

    /** nautical mile (international) = 1852 m. */
    public static final LengthUnit NAUTICAL_MILE;

    /** Astronomical Unit = 149,597,870,700 m. */
    public static final LengthUnit ASTRONOMICAL_UNIT;

    /** Lightyear = 9,460,730,472,580,800 m. */
    public static final LengthUnit LIGHTYEAR;

    /** Parsec = 648,000 / PI Pc. */
    public static final LengthUnit PARSEC;

    /** Angstrom = 10^-10 m. */
    public static final LengthUnit ANGSTROM;

    static
    {
        SI = new LengthUnit("LengthUnit.m", SI_BASE);
        METER = SI;
        ATTOMETER = new LengthUnit("LengthUnit.am", SI_BASE, METER, 1.0E-18);
        FEMTOMETER = new LengthUnit("LengthUnit.fm", SI_BASE, METER, 1.0E-15);
        PICOMETER = new LengthUnit("LengthUnit.pm", SI_BASE, METER, 1.0E-12);
        NANOMETER = new LengthUnit("LengthUnit.nm", SI_BASE, METER, 1.0E-9);
        MICROMETER = new LengthUnit("LengthUnit.mum", SI_BASE, METER, 1.0E-6);
        MILLIMETER = new LengthUnit("LengthUnit.mm", SI_BASE, METER, 0.001);
        CENTIMETER = new LengthUnit("LengthUnit.cm", SI_BASE, METER, 0.01);
        DECIMETER = new LengthUnit("LengthUnit.dm", SI_BASE, METER, 0.1);
        DEKAMETER = new LengthUnit("LengthUnit.dam", SI_BASE, METER, 10.0);
        HECTOMETER = new LengthUnit("LengthUnit.hm", SI_BASE, METER, 100.0);
        KILOMETER = new LengthUnit("LengthUnit.km", SI_BASE, METER, 1000.0);
        MEGAMETER = new LengthUnit("LengthUnit.Mm", SI_BASE, METER, 1000000.0);
        FOOT = new LengthUnit("LengthUnit.ft", IMPERIAL, METER, 0.3048);
        INCH = new LengthUnit("LengthUnit.in", IMPERIAL, FOOT, 1.0 / 12.0);
        MILE = new LengthUnit("LengthUnit.mi", IMPERIAL, FOOT, 5280.0);
        YARD = new LengthUnit("LengthUnit.yd", IMPERIAL, FOOT, 3.0);
        NAUTICAL_MILE = new LengthUnit("LengthUnit.NM", IMPERIAL, METER, 1852.0);
        ASTRONOMICAL_UNIT = new LengthUnit("LengthUnit.AU", OTHER, METER, 149597870700.0);
        LIGHTYEAR = new LengthUnit("LengthUnit.ly", OTHER, METER, 9460730472580800.0);
        PARSEC = new LengthUnit("LengthUnit.pc", OTHER, LIGHTYEAR, 648000 / Math.PI);
        ANGSTROM = new LengthUnit("LengthUnit.A", OTHER, METER, 1E-10);
    }

    /**
     * Build a standard LengthUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private LengthUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a LengthUnit with a conversion factor to another LengthUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit LengthUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private LengthUnit(final String abbreviationKey, final UnitSystem unitSystem, final LengthUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /**
     * Build a user-defined LengthUnit with a conversion factor to another LengthUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit LengthUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public LengthUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final LengthUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final LengthUnit getStandardUnit()
    {
        return METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m";
    }

}
