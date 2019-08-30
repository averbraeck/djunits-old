package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Relative %TypeRel% DoubleScalar. Instead of:
 * <pre>DoubleScalar&lt;%TypeRelUnit%&gt; value = new DoubleScalar&lt;%TypeRelUnit%&gt;(100.0, %TypeRelUnit%.SI);</pre>
 * we can now write:
 * <pre>%TypeRel% value = new %TypeRel%(100.0, %TypeRelUnit%.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeRel% extends AbstractDoubleScalarRel<%TypeRelUnit%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final %TypeRel% ZERO = new %TypeRel%(0.0, %TypeRelUnit%.SI);

    /** constant with value zero. */
    public static final %TypeRel% ONE = new %TypeRel%(1.0, %TypeRelUnit%.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final %TypeRel% NaN = new %TypeRel%(Double.NaN, %TypeRelUnit%.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final %TypeRel% POSITIVE_INFINITY = new %TypeRel%(Double.POSITIVE_INFINITY, %TypeRelUnit%.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final %TypeRel% NEGATIVE_INFINITY = new %TypeRel%(Double.NEGATIVE_INFINITY, %TypeRelUnit%.SI);

    /** constant with value MAX_VALUE. */
    public static final %TypeRel% POS_MAXVALUE = new %TypeRel%(Double.MAX_VALUE, %TypeRelUnit%.SI);

    /** constant with value -MAX_VALUE. */
    public static final %TypeRel% NEG_MAXVALUE = new %TypeRel%(-Double.MAX_VALUE, %TypeRelUnit%.SI);

    /**
     * Construct %TypeRel% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %TypeRel%(final double value, final %TypeRelUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeRel% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TypeRel%(final %TypeRel% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel% instantiateRel(final double value, final %TypeRelUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final %TypeAbs% instantiateAbs(final double value, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }

    /**
     * Construct %TypeRel% scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final %TypeRel% createSI(final double value)
    {
        return new %TypeRel%(value, %TypeRelUnit%.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %TypeRel% interpolate(final %TypeRel% zero, final %TypeRel% one, final double ratio)
    {
        return new %TypeRel%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final %TypeAbs% plus(final %TypeAbs% v)
    {
        %TypeAbsUnit% targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static %TypeRel% max(final %TypeRel% r1, final %TypeRel% r2)
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
    public static %TypeRel% max(final %TypeRel% r1, final %TypeRel% r2, final %TypeRel%... rn)
    {
        %TypeRel% maxr = (r1.gt(r2)) ? r1 : r2;
        for (%TypeRel% r : rn)
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
    public static %TypeRel% min(final %TypeRel% r1, final %TypeRel% r2)
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
    public static %TypeRel% min(final %TypeRel% r1, final %TypeRel% r2, final %TypeRel%... rn)
    {
        %TypeRel% minr = (r1.lt(r2)) ? r1 : r2;
        for (%TypeRel% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }
    
    /**
     * Returns a %TypeRel% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a %TypeRel%
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static %TypeRel% valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing %TypeRel% -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (%TypeRelUnit% unit : %TypeRelUnit%.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new %TypeRel%(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing %TypeRel% from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing %TypeRel% from " + text);
    }


%FORMULAS%%TypeRel%%
    
}

