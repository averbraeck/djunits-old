package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.*;

/**
 * Easy access methods for the Absolute %TypeAbs% DoubleScalar. Instead of:
 * <pre>DoubleScalar.Abs&lt;%TypeAbsUnit%&gt; value = new DoubleScalar.Abs&lt;%TypeAbsUnit%&gt;(100.0, %TypeAbsUnit%.SI);</pre>
 * we can now write:
 * <pre>%TypeAbs% value = new %TypeAbs%(100.0, %TypeAbsUnit%.BASE);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
##TIME##
 * <p>


 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class %TypeAbs% extends AbstractDoubleScalarAbs<%TypeAbsUnit%, %TypeAbs%, %TypeRelUnit%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final %TypeAbs% ZERO = new %TypeAbs%(0.0, %TypeAbsUnit%.BASE);

    /**
     * Construct %TypeAbs% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %TypeAbs%(final double value, final %TypeAbsUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeAbs% scalar.
     * @param value Scalar from which to construct this instance
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
     * Construct %TypeAbsl% scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final %TypeAbs% createSI(final double value)
    {
        return new %TypeAbs%(value, %TypeAbsUnit%.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %TypeAbs% interpolate(final %TypeAbs% zero, final %TypeAbs% one, final double ratio)
    {
        return new %TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static %TypeAbs% max(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
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
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static %TypeAbs% min(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
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
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
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
                for (%TypeAbsUnit% unit : Unit.getUnits(%TypeAbsUnit%.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
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

