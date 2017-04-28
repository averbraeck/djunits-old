package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard absolute position units.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-04-15 02:11:44 +0200 (Sat, 15 Apr 2017) $, @version $Revision: 239 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class PositionUnit extends AbsoluteLinearUnit<PositionUnit, LengthUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The BASE unit for position with an artificial zero-point. */
    public static final PositionUnit BASE;

    /** Positions scaled to am. */
    public static final PositionUnit ATTOMETER;

    /** Positions scaled to fm. */
    public static final PositionUnit FEMTOMETER;

    /** Positions scaled to pm. */
    public static final PositionUnit PICOMETER;

    /** Positions scaled to nm. */
    public static final PositionUnit NANOMETER;

    /** Positions scaled to &#181;m. */
    public static final PositionUnit MICROMETER;

    /** Positions scaled to mm. */
    public static final PositionUnit MILLIMETER;

    /** Positions scaled to m. */
    public static final PositionUnit METER;

    /** Positions scaled to cm. */
    public static final PositionUnit CENTIMETER;

    /** Positions scaled to dm. */
    public static final PositionUnit DECIMETER;

    /** Positions scaled to dam. */
    public static final PositionUnit DEKAMETER;

    /** Positions scaled to hm. */
    public static final PositionUnit HECTOMETER;

    /** Positions scaled to km. */
    public static final PositionUnit KILOMETER;

    /** Positions scaled to Mm. */
    public static final PositionUnit MEGAMETER;

    /** Positions scaled to inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final PositionUnit INCH;

    /** Positions scaled to foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final PositionUnit FOOT;

    /** Positions scaled to yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final PositionUnit YARD;

    /** Positions scaled to mile (international) = 5280 ft = 1760 yd. */
    public static final PositionUnit MILE;

    /** Positions scaled to nautical mile (international) = 1852 m. */
    public static final PositionUnit NAUTICAL_MILE;

    /** Positions scaled to Astronomical Unit = 149,597,870,700 m. */
    public static final PositionUnit ASTRONOMICAL_UNIT;

    /** Positions scaled to Lightyear = 9,460,730,472,580,800 m. */
    public static final PositionUnit LIGHTYEAR;

    /** Positions scaled to Parsec = 648,000 / PI Pc. */
    public static final PositionUnit PARSEC;

    /** Positions scaled to Angstrom = 10^-10 m. */
    public static final PositionUnit ANGSTROM;

    static
    {
        BASE = new PositionUnit("PositionUnit.base", "PositionUnit.base", OTHER, 1.0, 0.0, LengthUnit.METER);
        METER = new PositionUnit("PositionUnit.meter", "PositionUnit.m", OTHER, 1.0, 0.0, true, LengthUnit.METER);
        ATTOMETER =
                new PositionUnit("PositionUnit.attometer", "PositionUnit.am", OTHER, 1.0E-18, 0.0, true, LengthUnit.ATTOMETER);
        FEMTOMETER = new PositionUnit("PositionUnit.femtometer", "PositionUnit.fm", OTHER, 1.0E-15, 0.0, true,
                LengthUnit.FEMTOMETER);
        PICOMETER =
                new PositionUnit("PositionUnit.picometer", "PositionUnit.pm", OTHER, 1.0E-12, 0.0, true, LengthUnit.PICOMETER);
        NANOMETER =
                new PositionUnit("PositionUnit.nanometer", "PositionUnit.nm", OTHER, 1.0E-9, 0.0, true, LengthUnit.NANOMETER);
        MICROMETER = new PositionUnit("PositionUnit.micrometer", "PositionUnit.mum", OTHER, 1.0E-6, 0.0, true,
                LengthUnit.MICROMETER);
        MILLIMETER =
                new PositionUnit("PositionUnit.millimeter", "PositionUnit.mm", OTHER, 0.001, 0.0, true, LengthUnit.MILLIMETER);
        CENTIMETER =
                new PositionUnit("PositionUnit.centimeter", "PositionUnit.cm", OTHER, 0.01, 0.0, true, LengthUnit.CENTIMETER);
        DECIMETER = new PositionUnit("PositionUnit.decimeter", "PositionUnit.dm", OTHER, 0.1, 0.0, true, LengthUnit.DECIMETER);
        DEKAMETER =
                new PositionUnit("PositionUnit.dekameter", "PositionUnit.dam", OTHER, 10.0, 0.0, true, LengthUnit.DEKAMETER);
        HECTOMETER =
                new PositionUnit("PositionUnit.hectometer", "PositionUnit.hm", OTHER, 100.0, 0.0, true, LengthUnit.HECTOMETER);
        KILOMETER =
                new PositionUnit("PositionUnit.kilometer", "PositionUnit.km", OTHER, 1000.0, 0.0, true, LengthUnit.KILOMETER);
        MEGAMETER = new PositionUnit("PositionUnit.megameter", "PositionUnit.Mm", OTHER, 1000000.0, 0.0, true,
                LengthUnit.MEGAMETER);
        FOOT = new PositionUnit("PositionUnit.foot", "PositionUnit.ft", OTHER, 0.3048, 0.0, true, LengthUnit.FOOT);
        INCH = new PositionUnit("PositionUnit.inch", "PositionUnit.in", OTHER, 0.3048 / 12.0, 0.0, true, LengthUnit.INCH);
        MILE = new PositionUnit("PositionUnit.mile", "PositionUnit.mi", OTHER, 0.3048 * 5280.0, 0.0, true, LengthUnit.MILE);
        YARD = new PositionUnit("PositionUnit.yard", "PositionUnit.yd", OTHER, 0.3048 * 3.0, 0.0, true, LengthUnit.YARD);
        NAUTICAL_MILE = new PositionUnit("PositionUnit.nauticalMile", "PositionUnit.NM", OTHER, 1852.0, 0.0, true,
                LengthUnit.NAUTICAL_MILE);
        ASTRONOMICAL_UNIT = new PositionUnit("PositionUnit.astronomicalUnit", "PositionUnit.AU", OTHER, 149597870700.0, 0.0,
                true, LengthUnit.ASTRONOMICAL_UNIT);
        LIGHTYEAR = new PositionUnit("PositionUnit.lightyear", "PositionUnit.ly", OTHER, 9460730472580800.0, 0.0, true,
                LengthUnit.LIGHTYEAR);
        PARSEC = new PositionUnit("PositionUnit.parsec", "PositionUnit.pc", OTHER, 648000 / Math.PI, 0.0, true,
                LengthUnit.PARSEC);
        ANGSTROM = new PositionUnit("PositionUnit.angstrom", "PositionUnit.A", OTHER, 1E-10, 0.0, true, LengthUnit.ANGSTROM);
    }

    /**
     * Build a PositionUnit with a scale factor and offset to the base PositionUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scaleFactor multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    private PositionUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final double scaleFactor, final double offset, final boolean standardUnit, final LengthUnit relativeUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, scaleFactor, offset, standardUnit, relativeUnit);
    }

    /**
     * Build a user-defined PositionUnit with a scale factor and offset to the base PositionUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scaleFactor multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    public PositionUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final LengthUnit relativeUnit)
    {
        this(name, abbreviation, unitSystem, scaleFactor, offset, false, relativeUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final PositionUnit getStandardUnit()
    {
        return BASE;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m";
    }

}
