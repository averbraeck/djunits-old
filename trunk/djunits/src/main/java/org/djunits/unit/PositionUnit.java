package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard absolute position units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-04-15 02:11:44 +0200 (Sat, 15 Apr 2017) $, @version $Revision: 239 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        METER = new PositionUnit("PositionUnit.m", OTHER, 1.0, 0.0, LengthUnit.METER);
        BASE = METER;
        ATTOMETER = new PositionUnit("PositionUnit.am", OTHER, 1.0E-18, 0.0, LengthUnit.ATTOMETER);
        FEMTOMETER = new PositionUnit("PositionUnit.fm", OTHER, 1.0E-15, 0.0, LengthUnit.FEMTOMETER);
        PICOMETER = new PositionUnit("PositionUnit.pm", OTHER, 1.0E-12, 0.0, LengthUnit.PICOMETER);
        NANOMETER = new PositionUnit("PositionUnit.nm", OTHER, 1.0E-9, 0.0, LengthUnit.NANOMETER);
        MICROMETER = new PositionUnit("PositionUnit.mum", OTHER, 1.0E-6, 0.0, LengthUnit.MICROMETER);
        MILLIMETER = new PositionUnit("PositionUnit.mm", OTHER, 0.001, 0.0, LengthUnit.MILLIMETER);
        CENTIMETER = new PositionUnit("PositionUnit.cm", OTHER, 0.01, 0.0, LengthUnit.CENTIMETER);
        DECIMETER = new PositionUnit("PositionUnit.dm", OTHER, 0.1, 0.0, LengthUnit.DECIMETER);
        DEKAMETER = new PositionUnit("PositionUnit.dam", OTHER, 10.0, 0.0, LengthUnit.DEKAMETER);
        HECTOMETER = new PositionUnit("PositionUnit.hm", OTHER, 100.0, 0.0, LengthUnit.HECTOMETER);
        KILOMETER = new PositionUnit("PositionUnit.km", OTHER, 1000.0, 0.0, LengthUnit.KILOMETER);
        MEGAMETER = new PositionUnit("PositionUnit.Mm", OTHER, 1000000.0, 0.0, LengthUnit.MEGAMETER);
        FOOT = new PositionUnit("PositionUnit.ft", OTHER, 0.3048, 0.0, LengthUnit.FOOT);
        INCH = new PositionUnit("PositionUnit.in", OTHER, 0.3048 / 12.0, 0.0, LengthUnit.INCH);
        MILE = new PositionUnit("PositionUnit.mi", OTHER, 0.3048 * 5280.0, 0.0, LengthUnit.MILE);
        YARD = new PositionUnit("PositionUnit.yd", OTHER, 0.3048 * 3.0, 0.0, LengthUnit.YARD);
        NAUTICAL_MILE = new PositionUnit("PositionUnit.NM", OTHER, 1852.0, 0.0, LengthUnit.NAUTICAL_MILE);
        ASTRONOMICAL_UNIT = new PositionUnit("PositionUnit.AU", OTHER, 149597870700.0, 0.0, LengthUnit.ASTRONOMICAL_UNIT);
        LIGHTYEAR = new PositionUnit("PositionUnit.ly", OTHER, 9460730472580800.0, 0.0, LengthUnit.LIGHTYEAR);
        PARSEC = new PositionUnit("PositionUnit.pc", OTHER, 648000 / Math.PI, 0.0, LengthUnit.PARSEC);
        ANGSTROM = new PositionUnit("PositionUnit.A", OTHER, 1E-10, 0.0, LengthUnit.ANGSTROM);
    }

    /**
     * Build a PositionUnit with a scale factor and offset to the base PositionUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scaleFactor double; multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset double; the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit LengthUnit; the corresponding relative unit belonging to this absolute unit
     */
    private PositionUnit(final String abbreviationKey, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final LengthUnit relativeUnit)
    {
        super(abbreviationKey, unitSystem, scaleFactor, offset, relativeUnit);
    }

    /**
     * Build a user-defined PositionUnit with a scale factor and offset to the base PositionUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scaleFactor double; multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset double; the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit LengthUnit; the corresponding relative unit belonging to this absolute unit
     */
    public PositionUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final LengthUnit relativeUnit)
    {
        super(name, abbreviation, unitSystem, scaleFactor, offset, relativeUnit);
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
