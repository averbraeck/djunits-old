package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Frequency FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;FrequencyUnit&gt; value = new FloatScalar.Rel&lt;FrequencyUnit&gt;(100.0, FrequencyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatFrequency value = new FloatFrequency(100.0, FrequencyUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatFrequency extends TypedFloatScalarRel<FrequencyUnit, FloatFrequency>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatFrequency ZERO = new FloatFrequency(0.0f, FrequencyUnit.SI);

    /**
     * Construct FloatFrequency scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFrequency(final float value, final FrequencyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFrequency scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFrequency(final FloatFrequency value)
    {
        super(value);
    }

    /**
     * Construct FloatFrequency scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatFrequency(final double value, final FrequencyUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequency instantiateTypeRel(final float value, final FrequencyUnit unit)
    {
        return new FloatFrequency(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFrequency interpolate(final FloatFrequency zero, final FloatFrequency one, final float ratio)
    {
        return new FloatFrequency(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatFrequency max(final FloatFrequency r1, final FloatFrequency r2)
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
    public static FloatFrequency max(final FloatFrequency r1, final FloatFrequency r2, final FloatFrequency... rn)
    {
        FloatFrequency maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatFrequency r : rn)
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
    public static FloatFrequency min(final FloatFrequency r1, final FloatFrequency r2)
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
    public static FloatFrequency min(final FloatFrequency r1, final FloatFrequency r2, final FloatFrequency... rn)
    {
        FloatFrequency minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatFrequency r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatFrequency and FloatFrequency, which results in a FloatDimensionless scalar.
     * @param v FloatFrequency scalar
     * @return FloatDimensionless scalar as a division of FloatFrequency and FloatFrequency
     */
    public final FloatDimensionless divideBy(final FloatFrequency v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFrequency and FloatDuration, which results in a FloatDimensionless scalar.
     * @param v FloatFrequency scalar
     * @return FloatDimensionless scalar as a multiplication of FloatFrequency and FloatDuration
     */
    public final FloatDimensionless multiplyBy(final FloatDuration v)
    {
        return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFrequency and FloatLength, which results in a FloatSpeed scalar.
     * @param v FloatFrequency scalar
     * @return FloatSpeed scalar as a multiplication of FloatFrequency and FloatLength
     */
    public final FloatSpeed multiplyBy(final FloatLength v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFrequency and FloatSpeed, which results in a FloatAcceleration scalar.
     * @param v FloatFrequency scalar
     * @return FloatAcceleration scalar as a multiplication of FloatFrequency and FloatSpeed
     */
    public final FloatAcceleration multiplyBy(final FloatSpeed v)
    {
        return new FloatAcceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFrequency and FloatEnergy, which results in a FloatPower scalar.
     * @param v FloatFrequency scalar
     * @return FloatPower scalar as a multiplication of FloatFrequency and FloatEnergy
     */
    public final FloatPower multiplyBy(final FloatEnergy v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFrequency and FloatMoney, which results in a FloatMoneyPerTime scalar.
     * @param v FloatFrequency scalar
     * @return FloatMoneyPerTime scalar as a multiplication of FloatFrequency and FloatMoney
     */
    public final FloatMoneyPerTime multiplyBy(final FloatMoney v)
    {
        return new FloatMoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

}
