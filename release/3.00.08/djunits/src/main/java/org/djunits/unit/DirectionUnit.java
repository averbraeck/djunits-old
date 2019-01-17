package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard direction unit. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Note that the Direction is <b>counter</b>clockwise.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-01-30 14:23:11 +0100 (Mon, 30 Jan 2017) $, @version $Revision: 234 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DirectionUnit extends AbsoluteLinearUnit<DirectionUnit, AngleUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The BASE unit for direction with an artificial origin. */
    public static final DirectionUnit BASE;

    /** The unit for direction with North as the origin and radians as the displacement. */
    public static final DirectionUnit NORTH_RADIAN;

    /** The unit for direction with North as the origin and degrees as the displacement. */
    public static final DirectionUnit NORTH_DEGREE;

    /** The unit for direction with East as the origin and radians as the displacement. */
    public static final DirectionUnit EAST_RADIAN;

    /** The unit for direction with East as the origin and degrees as the displacement. */
    public static final DirectionUnit EAST_DEGREE;

    static
    {
        BASE = new DirectionUnit("DirectionUnit.base", "DirectionUnit.base", OTHER, 1.0, 0.0, false, AngleUnit.RADIAN);
        NORTH_RADIAN = new DirectionUnit("DirectionUnit.North(rad)", "DirectionUnit.North(radians)", OTHER, 1.0, 0.0, false,
                AngleUnit.RADIAN);
        NORTH_DEGREE = new DirectionUnit("DirectionUnit.North(deg)", "DirectionUnit.North(degrees)", OTHER, Math.PI / 180.0,
                0.0, false, AngleUnit.RADIAN);
        EAST_RADIAN = new DirectionUnit("DirectionUnit.East(rad)", "DirectionUnit.East(radians)", OTHER, 1.0, -Math.PI / 2.0,
                false, AngleUnit.RADIAN);
        EAST_DEGREE = new DirectionUnit("DirectionUnit.East(deg)", "DirectionUnit.East(degrees)", OTHER, Math.PI / 180.0, -90.0,
                false, AngleUnit.RADIAN);
    }

    /**
     * Build a DirectionUnit with a scale factor and offset to the base DirectionUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scaleFactor double; multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset double; the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     * @param relativeUnit AngleUnit; the corresponding relative unit belonging to this absolute unit
     */
    private DirectionUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final double scaleFactor, final double offset, final boolean standardUnit, final AngleUnit relativeUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, scaleFactor, offset, standardUnit, relativeUnit);
    }

    /**
     * Build a user-defined DirectionUnit with a scale factor and offset to the base DirectionUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scaleFactor double; multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset double; the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit AngleUnit; the corresponding relative unit belonging to this absolute unit
     */
    public DirectionUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final AngleUnit relativeUnit)
    {
        this(name, abbreviation, unitSystem, scaleFactor, offset, false, relativeUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final DirectionUnit getStandardUnit()
    {
        return BASE;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

}
