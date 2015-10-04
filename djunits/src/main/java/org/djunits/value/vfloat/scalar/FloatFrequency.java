package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Frequency FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;FrequencyUnit&gt; value = new FloatScalar.Rel&lt;FrequencyUnit&gt;(100.0, FrequencyUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatFrequency value = new FloatFrequency(100.0, FrequencyUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatFrequency extends FloatScalar.Rel<FrequencyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

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
     * Construct FloatFrequency scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatFrequency(final double value, final FrequencyUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatFrequency scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFrequency(final FloatScalar.Rel<FrequencyUnit> value)
    {
        super(value);
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
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFrequency interpolate(final FloatFrequency zero, final FloatFrequency one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency abs()
    {
        return new FloatFrequency(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency acos()
    {
        return new FloatFrequency((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency asin()
    {
        return new FloatFrequency((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency atan()
    {
        return new FloatFrequency((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency cbrt()
    {
        return new FloatFrequency((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency ceil()
    {
        return new FloatFrequency((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency cos()
    {
        return new FloatFrequency((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency cosh()
    {
        return new FloatFrequency((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency exp()
    {
        return new FloatFrequency((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency expm1()
    {
        return new FloatFrequency((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency floor()
    {
        return new FloatFrequency((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency log()
    {
        return new FloatFrequency((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency log10()
    {
        return new FloatFrequency((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency log1p()
    {
        return new FloatFrequency((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency rint()
    {
        return new FloatFrequency((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency round()
    {
        return new FloatFrequency(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency signum()
    {
        return new FloatFrequency(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency sin()
    {
        return new FloatFrequency((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency sinh()
    {
        return new FloatFrequency((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency sqrt()
    {
        return new FloatFrequency((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency tan()
    {
        return new FloatFrequency((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency tanh()
    {
        return new FloatFrequency((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency inv()
    {
        return new FloatFrequency(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency toDegrees()
    {
        return new FloatFrequency((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency toRadians()
    {
        return new FloatFrequency((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency pow(final double x)
    {
        return new FloatFrequency((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency multiplyBy(final float factor)
    {
        return new FloatFrequency(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative frequency
     */
    public final FloatFrequency multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency divideBy(final float divisor)
    {
        return new FloatFrequency(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative frequency
     */
    public final FloatFrequency divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatFrequency plus(final FloatFrequency v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFrequency(getInUnit() + v.getInUnit(), getUnit()) : new FloatFrequency(this.si
            + v.si, FrequencyUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatFrequency minus(final FloatFrequency v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFrequency(getInUnit() - v.getInUnit(), getUnit()) : new FloatFrequency(this.si
            - v.si, FrequencyUnit.SI);
    }
        /**
         * Calculate the division of FloatFrequency and FloatFrequency, which results in a FloatDimensionless scalar.
         * @param v FloatFrequency scalar
         * @return FloatDimensionless scalar as a division of FloatFrequency and FloatFrequency
         */
        public final FloatDimensionless.Rel divideBy(final FloatFrequency v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatTime, which results in a FloatDimensionless scalar.
         * @param v FloatFrequency scalar
         * @return FloatDimensionless scalar as a multiplication of FloatFrequency and FloatTime
         */
        public final FloatDimensionless.Rel multiplyBy(final FloatTime.Rel v)
        {
            return new FloatDimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatLength, which results in a FloatSpeed scalar.
         * @param v FloatFrequency scalar
         * @return FloatSpeed scalar as a multiplication of FloatFrequency and FloatLength
         */
        public final FloatSpeed multiplyBy(final FloatLength.Rel v)
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
