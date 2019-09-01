package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Absolute AbsoluteTemperature DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.

 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class AbsoluteTemperature extends AbstractDoubleScalarAbs<AbsoluteTemperatureUnit, AbsoluteTemperature, TemperatureUnit, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final AbsoluteTemperature ZERO = new AbsoluteTemperature(0.0, AbsoluteTemperatureUnit.DEFAULT);

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value double; value
     * @param unit AbsoluteTemperatureUnit; unit for the double value
     */
    public AbsoluteTemperature(final double value, final AbsoluteTemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value AbsoluteTemperature; Scalar from which to construct this instance
     */
    public AbsoluteTemperature(final AbsoluteTemperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperature instantiateAbs(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Temperature instantiateRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value double; value in SI units
     * @return AbsoluteTemperature; the new scalar with the SI value
     */
    public static final AbsoluteTemperature createSI(final double value)
    {
        return new AbsoluteTemperature(value, AbsoluteTemperatureUnit.DEFAULT);
    }

    /**
     * Interpolate between two values.
     * @param zero AbsoluteTemperature; the low value
     * @param one AbsoluteTemperature; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return AbsoluteTemperature; a Scalar at the ratio between
     */
    public static AbsoluteTemperature interpolate(final AbsoluteTemperature zero, final AbsoluteTemperature one, final double ratio)
    {
        return new AbsoluteTemperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @return AbsoluteTemperature; the maximum value of two absolute scalars
     */
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @param an AbsoluteTemperature...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2, final AbsoluteTemperature... an)
    {
        AbsoluteTemperature maxa = (a1.gt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
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
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @param an AbsoluteTemperature...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2, final AbsoluteTemperature... an)
    {
        AbsoluteTemperature mina = (a1.lt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a AbsoluteTemperature representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a AbsoluteTemperature
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static AbsoluteTemperature valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing AbsoluteTemperature -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AbsoluteTemperatureUnit unit : AbsoluteTemperatureUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new AbsoluteTemperature(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing AbsoluteTemperature from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing AbsoluteTemperature from " + text);
    }

}
