package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Absolute Time DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * Note that when the offset of a stored absolute Time becomes large, precision of a double might not be enough for the required
 * resolution of a Time. A double has around 16 significant digits (52 bit mantissa). This means that when we need to have a
 * double Time with TimeUnit.BASE as its unit, the largest value where the ms precision is reached is 2^51 = 2.3E15, which is
 * around 71000 years. This is sufficient to store a date in the 21st Century with a BASE or an Epoch offset precise to a
 * microsecond.

 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Time extends AbstractDoubleScalarAbs<TimeUnit, Time, DurationUnit, Duration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Time ZERO = new Time(0.0, TimeUnit.DEFAULT);

    /**
     * Construct Time scalar.
     * @param value double; value
     * @param unit TimeUnit; unit for the double value
     */
    public Time(final double value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Time scalar.
     * @param value Time; Scalar from which to construct this instance
     */
    public Time(final Time value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Time instantiateAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Duration instantiateRel(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }

    /**
     * Construct Time scalar.
     * @param value double; value in SI units
     * @return Time; the new scalar with the SI value
     */
    public static final Time createSI(final double value)
    {
        return new Time(value, TimeUnit.DEFAULT);
    }

    /**
     * Interpolate between two values.
     * @param zero Time; the low value
     * @param one Time; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return Time; a Scalar at the ratio between
     */
    public static Time interpolate(final Time zero, final Time one, final double ratio)
    {
        return new Time(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 Time; the first scalar
     * @param a2 Time; the second scalar
     * @return Time; the maximum value of two absolute scalars
     */
    public static Time max(final Time a1, final Time a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 Time; the first scalar
     * @param a2 Time; the second scalar
     * @param an Time...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static Time max(final Time a1, final Time a2, final Time... an)
    {
        Time maxa = (a1.gt(a2)) ? a1 : a2;
        for (Time a : an)
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
     * @param a1 Time; the first scalar
     * @param a2 Time; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static Time min(final Time a1, final Time a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 Time; the first scalar
     * @param a2 Time; the second scalar
     * @param an Time...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static Time min(final Time a1, final Time a2, final Time... an)
    {
        Time mina = (a1.lt(a2)) ? a1 : a2;
        for (Time a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a Time representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a Time
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Time valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Time -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (TimeUnit unit : TimeUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Time(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Time from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Time from " + text);
    }

}
