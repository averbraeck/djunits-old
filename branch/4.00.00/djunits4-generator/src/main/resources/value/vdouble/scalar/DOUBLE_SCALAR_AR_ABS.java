package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Absolute %TypeAbs% DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
##TIME##
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeAbs% extends AbstractDoubleScalarAbs<%TypeAbsUnit%, %TypeAbs%, %TypeRelUnit%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final %TypeAbs% ZERO = new %TypeAbs%(0.0, %TypeAbsUnit%.DEFAULT);

    /**
     * Construct %TypeAbs% scalar.
     * @param value double; value
     * @param unit %TypeAbsUnit%; unit for the double value
     */
    public %TypeAbs%(final double value, final %TypeAbsUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeAbs% scalar.
     * @param value %TypeAbs%; Scalar from which to construct this instance
     */
    public %TypeAbs%(final %TypeAbs% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs% instantiateAbs(final double value, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel% instantiateRel(final double value, final %TypeRelUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }

    /**
     * Construct %TypeAbs% scalar.
     * @param value double; value in SI units
     * @return %TypeAbs%; the new scalar with the SI value
     */
    public static final %TypeAbs% createSI(final double value)
    {
        return new %TypeAbs%(value, %TypeAbsUnit%.DEFAULT);
    }

    /**
     * Interpolate between two values.
     * @param zero %TypeAbs%; the low value
     * @param one %TypeAbs%; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return %TypeAbs%; a Scalar at the ratio between
     */
    public static %TypeAbs% interpolate(final %TypeAbs% zero, final %TypeAbs% one, final double ratio)
    {
        return new %TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 %TypeAbs%; the first scalar
     * @param a2 %TypeAbs%; the second scalar
     * @return %TypeAbs%; the maximum value of two absolute scalars
     */
    public static %TypeAbs% max(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 %TypeAbs%; the first scalar
     * @param a2 %TypeAbs%; the second scalar
     * @param an %TypeAbs%...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static %TypeAbs% max(final %TypeAbs% a1, final %TypeAbs% a2, final %TypeAbs%... an)
    {
        %TypeAbs% maxa = (a1.gt(a2)) ? a1 : a2;
        for (%TypeAbs% a : an)
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
     * @param a1 %TypeAbs%; the first scalar
     * @param a2 %TypeAbs%; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static %TypeAbs% min(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 %TypeAbs%; the first scalar
     * @param a2 %TypeAbs%; the second scalar
     * @param an %TypeAbs%...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static %TypeAbs% min(final %TypeAbs% a1, final %TypeAbs% a2, final %TypeAbs%... an)
    {
        %TypeAbs% mina = (a1.lt(a2)) ? a1 : a2;
        for (%TypeAbs% a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a %TypeAbs% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a %TypeAbs%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static %TypeAbs% valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing %TypeAbs% -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (%TypeAbsUnit% unit : %TypeAbsUnit%.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new %TypeAbs%(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing %TypeAbs% from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing %TypeAbs% from " + text);
    }

%FORMULAS%%TypeAbs%%
}

