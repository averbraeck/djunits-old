package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;

/**
 * Easy access methods for the Absolute Position DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Position extends AbstractDoubleScalarAbs<PositionUnit, Position, LengthUnit, Length>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Position ZERO = new Position(0.0, PositionUnit.DEFAULT);

    /**
     * Construct Position scalar.
     * @param value double; value
     * @param unit PositionUnit; unit for the double value
     */
    public Position(final double value, final PositionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Position scalar.
     * @param value Position; Scalar from which to construct this instance
     */
    public Position(final Position value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Position instantiateAbs(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Length instantiateRel(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

    /**
     * Construct Position scalar.
     * @param value double; value in SI units
     * @return Position; the new scalar with the SI value
     */
    public static final Position createSI(final double value)
    {
        return new Position(value, PositionUnit.DEFAULT);
    }

    /**
     * Interpolate between two values.
     * @param zero Position; the low value
     * @param one Position; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return Position; a Scalar at the ratio between
     */
    public static Position interpolate(final Position zero, final Position one, final double ratio)
    {
        return new Position(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @return Position; the maximum value of two absolute scalars
     */
    public static Position max(final Position a1, final Position a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @param an Position...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static Position max(final Position a1, final Position a2, final Position... an)
    {
        Position maxa = (a1.gt(a2)) ? a1 : a2;
        for (Position a : an)
        {
            if (a.gt(maxa))
            {
                maxa = a;
            }
        }
        return maxa;
    }

    /**
     * Return the minimum value of two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static Position min(final Position a1, final Position a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @param an Position...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static Position min(final Position a1, final Position a2, final Position... an)
    {
        Position mina = (a1.lt(a2)) ? a1 : a2;
        for (Position a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a Position representation of a textual representation of a value with a unit. The String representation that can
     * be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a Position
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Position valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Position -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (PositionUnit unit : PositionUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Position(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Position from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Position from " + text);
    }

}
