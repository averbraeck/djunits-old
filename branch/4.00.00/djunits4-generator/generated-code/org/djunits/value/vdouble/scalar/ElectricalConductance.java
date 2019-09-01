package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the ElectricalConductance DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;ElectricalConductanceUnit&gt; value = new DoubleScalar.Rel&lt;ElectricalConductanceUnit&gt;(100.0,
 * ElectricalConductanceUnit.SI);</pre>
 * we can now write:
 * <pre>ElectricalConductance value = new ElectricalConductance(100.0, ElectricalConductanceUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ElectricalConductance extends AbstractDoubleScalarRel<ElectricalConductanceUnit, ElectricalConductance> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalConductance ZERO = new ElectricalConductance(0.0, ElectricalConductanceUnit.SI);

    /** constant with value one. */
    public static final ElectricalConductance ONE = new ElectricalConductance(1.0, ElectricalConductanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalConductance NaN = new ElectricalConductance(Double.NaN, ElectricalConductanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalConductance POSITIVE_INFINITY = new ElectricalConductance(Double.POSITIVE_INFINITY, ElectricalConductanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalConductance NEGATIVE_INFINITY = new ElectricalConductance(Double.NEGATIVE_INFINITY, ElectricalConductanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalConductance POS_MAXVALUE = new ElectricalConductance(Double.MAX_VALUE, ElectricalConductanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalConductance NEG_MAXVALUE = new ElectricalConductance(-Double.MAX_VALUE, ElectricalConductanceUnit.SI);

    /**
     * Construct ElectricalConductance scalar.
     * @param value double; the double value
     * @param unit unit for the double value
     */
    public ElectricalConductance(final double value, final ElectricalConductanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalConductance scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalConductance(final ElectricalConductance value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalConductance instantiateRel(final double value, final ElectricalConductanceUnit unit)
    {
        return new ElectricalConductance(value, unit);
    }

    /**
     * Construct ElectricalConductance scalar.
     * @param value double; the double value in SI units
     * @return the new scalar with the SI value
     */
    public static final ElectricalConductance createSI(final double value)
    {
        return new ElectricalConductance(value, ElectricalConductanceUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalConductance interpolate(final ElectricalConductance zero, final ElectricalConductance one, final double ratio)
    {
        return new ElectricalConductance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static ElectricalConductance max(final ElectricalConductance r1, final ElectricalConductance r2)
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
    public static ElectricalConductance max(final ElectricalConductance r1, final ElectricalConductance r2, final ElectricalConductance... rn)
    {
        ElectricalConductance maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalConductance r : rn)
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
    public static ElectricalConductance min(final ElectricalConductance r1, final ElectricalConductance r2)
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
    public static ElectricalConductance min(final ElectricalConductance r1, final ElectricalConductance r2, final ElectricalConductance... rn)
    {
        ElectricalConductance minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalConductance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a ElectricalConductance representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a ElectricalConductance
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static ElectricalConductance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing ElectricalConductance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalConductanceUnit unit : ElectricalConductanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new ElectricalConductance(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing ElectricalConductance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing ElectricalConductance from " + text);
    }
    
    
}

