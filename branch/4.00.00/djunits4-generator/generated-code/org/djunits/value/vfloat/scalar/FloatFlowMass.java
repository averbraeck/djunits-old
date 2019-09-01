package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the FlowMass FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;FlowMassUnit&gt; value = new FloatScalar.Rel&lt;FlowMassUnit&gt;(100.0, FlowMassUnit.SI);</pre>
 * we can now write:
 * <pre>FloatFlowMass value = new FloatFlowMass(100.0, FlowMassUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatFlowMass extends AbstractFloatScalarRel<FlowMassUnit, FloatFlowMass> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatFlowMass ZERO = new FloatFlowMass(0.0f, FlowMassUnit.SI);

    /** constant with value zero. */
    public static final FloatFlowMass ONE = new FloatFlowMass(1.0f, FlowMassUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatFlowMass NaN = new FloatFlowMass(Float.NaN, FlowMassUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatFlowMass POSITIVE_INFINITY = new FloatFlowMass(Float.POSITIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatFlowMass NEGATIVE_INFINITY = new FloatFlowMass(Float.NEGATIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatFlowMass POS_MAXVALUE = new FloatFlowMass(Float.MAX_VALUE, FlowMassUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatFlowMass NEG_MAXVALUE = new FloatFlowMass(-Float.MAX_VALUE, FlowMassUnit.SI);

    /**
     * Construct FloatFlowMass scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatFlowMass(final float value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowMass(final FloatFlowMass value)
    {
        super(value);
    }

    /**
     * Construct FloatFlowMass scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatFlowMass(final double value, final FlowMassUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass instantiateRel(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

    /**
     * Construct FloatFlowMass scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatFlowMass createSI(final float value)
    {
        return new FloatFlowMass(value, FlowMassUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowMass interpolate(final FloatFlowMass zero, final FloatFlowMass one, final float ratio)
    {
        return new FloatFlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatFlowMass max(final FloatFlowMass r1, final FloatFlowMass r2)
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
    public static FloatFlowMass max(final FloatFlowMass r1, final FloatFlowMass r2, final FloatFlowMass... rn)
    {
        FloatFlowMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatFlowMass r : rn)
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
    public static FloatFlowMass min(final FloatFlowMass r1, final FloatFlowMass r2)
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
    public static FloatFlowMass min(final FloatFlowMass r1, final FloatFlowMass r2, final FloatFlowMass... rn)
    {
        FloatFlowMass minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatFlowMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatFlowMass representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatFlowMass
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatFlowMass valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatFlowMass -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (FlowMassUnit unit : FlowMassUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatFlowMass(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatFlowMass from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatFlowMass from " + text);
    }
        /**
         * Calculate the division of FloatFlowMass and FloatFlowMass, which results in a FloatDimensionless scalar.
         * @param v FloatFlowMass scalar
         * @return FloatDimensionless scalar as a division of FloatFlowMass and FloatFlowMass
         */
        public final FloatDimensionless divideBy(final FloatFlowMass v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFlowMass and FloatDuration, which results in a FloatMass scalar.
         * @param v FloatFlowMass scalar
         * @return FloatMass scalar as a multiplication of FloatFlowMass and FloatDuration
         */
        public final FloatMass multiplyBy(final FloatDuration v)
        {
            return new FloatMass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowMass and FloatFrequency, which results in a FloatMass scalar.
         * @param v FloatFlowMass scalar
         * @return FloatMass scalar as a division of FloatFlowMass and FloatFrequency
         */
        public final FloatMass divideBy(final FloatFrequency v)
        {
            return new FloatMass(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowMass and FloatMass, which results in a FloatFrequency scalar.
         * @param v FloatFlowMass scalar
         * @return FloatFrequency scalar as a division of FloatFlowMass and FloatMass
         */
        public final FloatFrequency divideBy(final FloatMass v)
        {
            return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFlowMass and FloatSpeed, which results in a FloatForce scalar.
         * @param v FloatFlowMass scalar
         * @return FloatForce scalar as a multiplication of FloatFlowMass and FloatSpeed
         */
        public final FloatForce multiplyBy(final FloatSpeed v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }


}

