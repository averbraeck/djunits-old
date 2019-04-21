package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the FlowVolume FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;FlowVolumeUnit&gt; value = new FloatScalar.Rel&lt;FlowVolumeUnit&gt;(100.0, FlowVolumeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatFlowVolume value = new FloatFlowVolume(100.0, FlowVolumeUnit.SI);
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
public class FloatFlowVolume extends AbstractFloatScalarRel<FlowVolumeUnit, FloatFlowVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatFlowVolume ZERO = new FloatFlowVolume(0.0f, FlowVolumeUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatFlowVolume NaN = new FloatFlowVolume(Float.NaN, FlowVolumeUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatFlowVolume POSITIVE_INFINITY = new FloatFlowVolume(Float.POSITIVE_INFINITY, FlowVolumeUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatFlowVolume NEGATIVE_INFINITY = new FloatFlowVolume(Float.NEGATIVE_INFINITY, FlowVolumeUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatFlowVolume POS_MAXVALUE = new FloatFlowVolume(Float.MAX_VALUE, FlowVolumeUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatFlowVolume NEG_MAXVALUE = new FloatFlowVolume(-Float.MAX_VALUE, FlowVolumeUnit.SI);

    /**
     * Construct FloatFlowVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFlowVolume(final float value, final FlowVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowVolume(final FloatFlowVolume value)
    {
        super(value);
    }

    /**
     * Construct FloatFlowVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatFlowVolume(final double value, final FlowVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume instantiateRel(final float value, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolume(value, unit);
    }

    /**
     * Construct FloatFlowVolume scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatFlowVolume createSI(final float value)
    {
        return new FloatFlowVolume(value, FlowVolumeUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowVolume interpolate(final FloatFlowVolume zero, final FloatFlowVolume one, final float ratio)
    {
        return new FloatFlowVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatFlowVolume max(final FloatFlowVolume r1, final FloatFlowVolume r2)
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
    public static FloatFlowVolume max(final FloatFlowVolume r1, final FloatFlowVolume r2, final FloatFlowVolume... rn)
    {
        FloatFlowVolume maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatFlowVolume r : rn)
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
    public static FloatFlowVolume min(final FloatFlowVolume r1, final FloatFlowVolume r2)
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
    public static FloatFlowVolume min(final FloatFlowVolume r1, final FloatFlowVolume r2, final FloatFlowVolume... rn)
    {
        FloatFlowVolume minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatFlowVolume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatFlowVolume representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatFlowVolume
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatFlowVolume valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatFlowVolume -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (FlowVolumeUnit unit : Unit.getUnits(FlowVolumeUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatFlowVolume(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatFlowVolume from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatFlowVolume from " + text);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatFlowVolume, which results in a FloatDimensionless scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatDimensionless scalar as a division of FloatFlowVolume and FloatFlowVolume
     */
    public final FloatDimensionless divideBy(final FloatFlowVolume v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFlowVolume and FloatDuration, which results in a FloatVolume scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatVolume scalar as a multiplication of FloatFlowVolume and FloatDuration
     */
    public final FloatVolume multiplyBy(final FloatDuration v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatFrequency, which results in a FloatVolume scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatVolume scalar as a division of FloatFlowVolume and FloatFrequency
     */
    public final FloatVolume divideBy(final FloatFrequency v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatVolume, which results in a FloatFrequency scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatFrequency scalar as a division of FloatFlowVolume and FloatVolume
     */
    public final FloatFrequency divideBy(final FloatVolume v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatArea, which results in a FloatSpeed scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatSpeed scalar as a division of FloatFlowVolume and FloatArea
     */
    public final FloatSpeed divideBy(final FloatArea v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatSpeed, which results in a FloatArea scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatArea scalar as a division of FloatFlowVolume and FloatSpeed
     */
    public final FloatArea divideBy(final FloatSpeed v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

}
