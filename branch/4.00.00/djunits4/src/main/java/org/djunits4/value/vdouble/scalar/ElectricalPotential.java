package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalPotential DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt; value =
 *         new DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt;(100.0, ElectricalPotentialUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * ElectricalPotential value = new ElectricalPotential(100.0, ElectricalPotentialUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalPotential extends AbstractDoubleScalarRel<ElectricalPotentialUnit, ElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalPotential ZERO = new ElectricalPotential(0.0, ElectricalPotentialUnit.SI);

    /** constant with value one. */
    public static final ElectricalPotential ONE = new ElectricalPotential(1.0, ElectricalPotentialUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalPotential NaN = new ElectricalPotential(Double.NaN, ElectricalPotentialUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalPotential POSITIVE_INFINITY =
            new ElectricalPotential(Double.POSITIVE_INFINITY, ElectricalPotentialUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalPotential NEGATIVE_INFINITY =
            new ElectricalPotential(Double.NEGATIVE_INFINITY, ElectricalPotentialUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalPotential POS_MAXVALUE =
            new ElectricalPotential(Double.MAX_VALUE, ElectricalPotentialUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalPotential NEG_MAXVALUE =
            new ElectricalPotential(-Double.MAX_VALUE, ElectricalPotentialUnit.SI);

    /**
     * Construct ElectricalPotential scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalPotential(final ElectricalPotential value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential instantiateRel(final double value, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotential(value, unit);
    }

    /**
     * Construct ElectricalPotential scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final ElectricalPotential createSI(final double value)
    {
        return new ElectricalPotential(value, ElectricalPotentialUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalPotential interpolate(final ElectricalPotential zero, final ElectricalPotential one,
            final double ratio)
    {
        return new ElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static ElectricalPotential max(final ElectricalPotential r1, final ElectricalPotential r2)
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
    public static ElectricalPotential max(final ElectricalPotential r1, final ElectricalPotential r2,
            final ElectricalPotential... rn)
    {
        ElectricalPotential maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalPotential r : rn)
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
    public static ElectricalPotential min(final ElectricalPotential r1, final ElectricalPotential r2)
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
    public static ElectricalPotential min(final ElectricalPotential r1, final ElectricalPotential r2,
            final ElectricalPotential... rn)
    {
        ElectricalPotential minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalPotential r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a ElectricalPotential representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a ElectricalPotential
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static ElectricalPotential valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing ElectricalPotential -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalPotentialUnit unit : ElectricalPotentialUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new ElectricalPotential(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing ElectricalPotential from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing ElectricalPotential from " + text);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
     * @param v ElectricalPotential scalar
     * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
     */
    public final Dimensionless divideBy(final ElectricalPotential v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
     * @param v ElectricalPotential scalar
     * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
     */
    public final Power multiplyBy(final ElectricalCurrent v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
     */
    public final ElectricalResistance divideBy(final ElectricalCurrent v)
    {
        return new ElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalResistance, which results in a ElectricalCurrent scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalCurrent scalar as a division of ElectricalPotential and ElectricalResistance
     */
    public final ElectricalCurrent divideBy(final ElectricalResistance v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
