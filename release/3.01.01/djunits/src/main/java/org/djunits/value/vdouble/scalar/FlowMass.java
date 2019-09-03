package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the FlowMass DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;FlowMassUnit&gt; value = new DoubleScalar.Rel&lt;FlowMassUnit&gt;(100.0, FlowMassUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FlowMass value = new FlowMass(100.0, FlowMassUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FlowMass extends AbstractDoubleScalarRel<FlowMassUnit, FlowMass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final FlowMass ZERO = new FlowMass(0.0, FlowMassUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FlowMass NaN = new FlowMass(Double.NaN, FlowMassUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FlowMass POSITIVE_INFINITY = new FlowMass(Double.POSITIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FlowMass NEGATIVE_INFINITY = new FlowMass(Double.NEGATIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FlowMass POS_MAXVALUE = new FlowMass(Double.MAX_VALUE, FlowMassUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FlowMass NEG_MAXVALUE = new FlowMass(-Double.MAX_VALUE, FlowMassUnit.SI);

    /**
     * Construct FlowMass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public FlowMass(final double value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowMass(final FlowMass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass instantiateRel(final double value, final FlowMassUnit unit)
    {
        return new FlowMass(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final FlowMass createSI(final double value)
    {
        return new FlowMass(value, FlowMassUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final double ratio)
    {
        return new FlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FlowMass max(final FlowMass r1, final FlowMass r2)
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
    public static FlowMass max(final FlowMass r1, final FlowMass r2, final FlowMass... rn)
    {
        FlowMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (FlowMass r : rn)
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
    public static FlowMass min(final FlowMass r1, final FlowMass r2)
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
    public static FlowMass min(final FlowMass r1, final FlowMass r2, final FlowMass... rn)
    {
        FlowMass minr = (r1.lt(r2)) ? r1 : r2;
        for (FlowMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FlowMass representation of a textual representation of a value with a unit. The String representation that can
     * be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FlowMass
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FlowMass valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FlowMass -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (FlowMassUnit unit : Unit.getUnits(FlowMassUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new FlowMass(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FlowMass from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FlowMass from " + text);
    }

    /**
     * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
     * @param v FlowMass scalar
     * @return Dimensionless scalar as a division of FlowMass and FlowMass
     */
    public final Dimensionless divideBy(final FlowMass v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Duration, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a multiplication of FlowMass and Duration
     */
    public final Mass multiplyBy(final Duration v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a division of FlowMass and Frequency
     */
    public final Mass divideBy(final Frequency v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
     * @param v FlowMass scalar
     * @return Frequency scalar as a division of FlowMass and Mass
     */
    public final Frequency divideBy(final Mass v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
     * @param v FlowMass scalar
     * @return Force scalar as a multiplication of FlowMass and Speed
     */
    public final Force multiplyBy(final Speed v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}