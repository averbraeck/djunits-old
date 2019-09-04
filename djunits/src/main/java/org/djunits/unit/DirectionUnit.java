package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard direction unit. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Note that the EAST and NORTH Directions are <b>counter</b>clockwise.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DirectionUnit extends AbsoluteLinearUnit<DirectionUnit, AngleUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The BASE unit for direction with an artificial origin. */
    public static final DirectionUnit BASE;

    /** The unit for direction with East as the origin and radians as the displacement. */
    public static final DirectionUnit EAST_RADIAN;

    /** The unit for direction with East as the origin and degrees as the displacement. */
    public static final DirectionUnit EAST_DEGREE;

    /** The unit for direction with North as the origin and radians as the displacement. */
    public static final DirectionUnit NORTH_RADIAN;

    /** The unit for direction with North as the origin and degrees as the displacement. */
    public static final DirectionUnit NORTH_DEGREE;

    static
    {
        EAST_RADIAN = new DirectionUnit("DirectionUnit.rad(East)", OTHER, 1.0, 0.0, AngleUnit.RADIAN);
        BASE = EAST_RADIAN;
        EAST_DEGREE = new DirectionUnit("DirectionUnit.deg(East)", OTHER, Math.PI / 180.0, 0.0, AngleUnit.DEGREE);
        NORTH_RADIAN = new DirectionUnit("DirectionUnit.rad(North)", OTHER, 1.0, Math.PI / 2.0, AngleUnit.RADIAN);
        NORTH_DEGREE = new DirectionUnit("DirectionUnit.deg(North)", OTHER, Math.PI / 180.0, 90.0, AngleUnit.DEGREE);
    }

    /**
     * Build a DirectionUnit with a scale factor and offset to the base DirectionUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scaleFactor double; multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset double; the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit AngleUnit; the corresponding relative unit belonging to this absolute unit
     */
    private DirectionUnit(final String abbreviationKey, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final AngleUnit relativeUnit)
    {
        super(abbreviationKey, unitSystem, scaleFactor, offset, relativeUnit);
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
        super(name, abbreviation, unitSystem, scaleFactor, offset, relativeUnit);
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
