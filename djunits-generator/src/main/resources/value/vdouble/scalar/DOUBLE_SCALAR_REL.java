package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.*;
import org.djunits.value.vdouble.scalar.Acceleration;

/**
 * Easy access methods for the %Type% DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0,
 * %Type%Unit.SI);</pre>
 * we can now write:
 * <pre>%Type% value = new %Type%(100.0, %Type%Unit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class %Type% extends AbstractDoubleScalarRel<%Type%Unit, %Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final %Type% ZERO = new %Type%(0.0, %Type%Unit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final %Type% NaN = new %Type%(Double.NaN, %Type%Unit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final %Type% POSITIVE_INFINITY = new %Type%(Double.POSITIVE_INFINITY, %Type%Unit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final %Type% NEGATIVE_INFINITY = new %Type%(Double.NEGATIVE_INFINITY, %Type%Unit.SI);

    /** constant with value MAX_VALUE. */
    public static final %Type% POS_MAXVALUE = new %Type%(Double.MAX_VALUE, %Type%Unit.SI);

    /** constant with value -MAX_VALUE. */
    public static final %Type% NEG_MAXVALUE = new %Type%(-Double.MAX_VALUE, %Type%Unit.SI);

    /**
     * Construct %Type% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %Type%(final double value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %Type%(final %Type% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% instantiateRel(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final %Type% createSI(final double value)
    {
        return new %Type%(value, %Type%Unit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %Type% interpolate(final %Type% zero, final %Type% one, final double ratio)
    {
        return new %Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static %Type% max(final %Type% r1, final %Type% r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static %Type% max(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% maxr = (r1.gt(r2)) ? r1 : r2;
        for (%Type% r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static %Type% min(final %Type% r1, final %Type% r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static %Type% min(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% minr = (r1.lt(r2)) ? r1 : r2;
        for (%Type% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a %Type% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a %Type%
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static %Type% valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing %Type% -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (%Type%Unit unit : Unit.getUnits(%Type%Unit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new %Type%(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing %Type% from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing %Type% from " + text);
    }
    
    
%FORMULAS%%Type%%
}


