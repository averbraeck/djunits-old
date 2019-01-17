package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Acceleration FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;AccelerationUnit&gt; value = new FloatScalar.Rel&lt;AccelerationUnit&gt;(100.0, AccelerationUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAcceleration value = new FloatAcceleration(100.0, AccelerationUnit.SI);
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
public class FloatAcceleration extends AbstractFloatScalarRel<AccelerationUnit, FloatAcceleration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAcceleration ZERO = new FloatAcceleration(0.0f, AccelerationUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAcceleration NaN = new FloatAcceleration(Float.NaN, AccelerationUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatAcceleration POSITIVE_INFINITY =
            new FloatAcceleration(Float.POSITIVE_INFINITY, AccelerationUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatAcceleration NEGATIVE_INFINITY =
            new FloatAcceleration(Float.NEGATIVE_INFINITY, AccelerationUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatAcceleration POS_MAXVALUE = new FloatAcceleration(Float.MAX_VALUE, AccelerationUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatAcceleration NEG_MAXVALUE = new FloatAcceleration(-Float.MAX_VALUE, AccelerationUnit.SI);

    /**
     * Construct FloatAcceleration scalar.
     * @param value float; float value
     * @param unit AccelerationUnit; unit for the float value
     */
    public FloatAcceleration(final float value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAcceleration scalar.
     * @param value FloatAcceleration; Scalar from which to construct this instance
     */
    public FloatAcceleration(final FloatAcceleration value)
    {
        super(value);
    }

    /**
     * Construct FloatAcceleration scalar using a double value.
     * @param value double; double value
     * @param unit AccelerationUnit; unit for the resulting float value
     */
    public FloatAcceleration(final double value, final AccelerationUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration instantiateRel(final float value, final AccelerationUnit unit)
    {
        return new FloatAcceleration(value, unit);
    }

    /**
     * Construct FloatAcceleration scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatAcceleration createSI(final float value)
    {
        return new FloatAcceleration(value, AccelerationUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatAcceleration; the low value
     * @param one FloatAcceleration; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAcceleration interpolate(final FloatAcceleration zero, final FloatAcceleration one, final float ratio)
    {
        return new FloatAcceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatAcceleration; the first scalar
     * @param r2 FloatAcceleration; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatAcceleration max(final FloatAcceleration r1, final FloatAcceleration r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatAcceleration; the first scalar
     * @param r2 FloatAcceleration; the second scalar
     * @param rn FloatAcceleration...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatAcceleration max(final FloatAcceleration r1, final FloatAcceleration r2, final FloatAcceleration... rn)
    {
        FloatAcceleration maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatAcceleration r : rn)
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
     * @param r1 FloatAcceleration; the first scalar
     * @param r2 FloatAcceleration; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatAcceleration min(final FloatAcceleration r1, final FloatAcceleration r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatAcceleration; the first scalar
     * @param r2 FloatAcceleration; the second scalar
     * @param rn FloatAcceleration...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatAcceleration min(final FloatAcceleration r1, final FloatAcceleration r2, final FloatAcceleration... rn)
    {
        FloatAcceleration minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatAcceleration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatAcceleration and FloatAcceleration, which results in a FloatDimensionless scalar.
     * @param v FloatAcceleration; FloatAcceleration scalar
     * @return FloatDimensionless scalar as a division of FloatAcceleration and FloatAcceleration
     */
    public final FloatDimensionless divideBy(final FloatAcceleration v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatMass, which results in a FloatForce scalar.
     * @param v FloatMass; FloatAcceleration scalar
     * @return FloatForce scalar as a multiplication of FloatAcceleration and FloatMass
     */
    public final FloatForce multiplyBy(final FloatMass v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatDuration, which results in a FloatSpeed scalar.
     * @param v FloatDuration; FloatAcceleration scalar
     * @return FloatSpeed scalar as a multiplication of FloatAcceleration and FloatDuration
     */
    public final FloatSpeed multiplyBy(final FloatDuration v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatFrequency, which results in a FloatSpeed scalar.
     * @param v FloatFrequency; FloatAcceleration scalar
     * @return FloatSpeed scalar as a division of FloatAcceleration and FloatFrequency
     */
    public final FloatSpeed divideBy(final FloatFrequency v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatSpeed, which results in a FloatFrequency scalar.
     * @param v FloatSpeed; FloatAcceleration scalar
     * @return FloatFrequency scalar as a division of FloatAcceleration and FloatSpeed
     */
    public final FloatFrequency divideBy(final FloatSpeed v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

}
