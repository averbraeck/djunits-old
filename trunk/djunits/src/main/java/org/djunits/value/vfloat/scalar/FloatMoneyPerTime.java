package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerTime FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>FloatMoney price = new FloatMoney(100.0, MoneyUnit.EUR);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerTime extends FloatScalar.Rel<MoneyPerTimeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerTime scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerTime(final float value, final MoneyPerTimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerTime scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerTime(final double value, final MoneyPerTimeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerTime scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerTime(final FloatScalar.Rel<MoneyPerTimeUnit> value)
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
    public static FloatMoneyPerTime interpolate(final FloatMoneyPerTime zero, final FloatMoneyPerTime one,
        final float ratio)
    {
        return new FloatMoneyPerTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerTime interpolate(final FloatMoneyPerTime zero, final FloatMoneyPerTime one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime abs()
    {
        return new FloatMoneyPerTime(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime acos()
    {
        return new FloatMoneyPerTime((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime asin()
    {
        return new FloatMoneyPerTime((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime atan()
    {
        return new FloatMoneyPerTime((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime cbrt()
    {
        return new FloatMoneyPerTime((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime ceil()
    {
        return new FloatMoneyPerTime((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime cos()
    {
        return new FloatMoneyPerTime((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime cosh()
    {
        return new FloatMoneyPerTime((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime exp()
    {
        return new FloatMoneyPerTime((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime expm1()
    {
        return new FloatMoneyPerTime((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime floor()
    {
        return new FloatMoneyPerTime((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime log()
    {
        return new FloatMoneyPerTime((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime log10()
    {
        return new FloatMoneyPerTime((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime log1p()
    {
        return new FloatMoneyPerTime((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime rint()
    {
        return new FloatMoneyPerTime((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime round()
    {
        return new FloatMoneyPerTime(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime signum()
    {
        return new FloatMoneyPerTime(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime sin()
    {
        return new FloatMoneyPerTime((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime sinh()
    {
        return new FloatMoneyPerTime((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime sqrt()
    {
        return new FloatMoneyPerTime((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime tan()
    {
        return new FloatMoneyPerTime((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime tanh()
    {
        return new FloatMoneyPerTime((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime inv()
    {
        return new FloatMoneyPerTime(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime toDegrees()
    {
        return new FloatMoneyPerTime((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime toRadians()
    {
        return new FloatMoneyPerTime((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime pow(final double x)
    {
        return new FloatMoneyPerTime((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime multiplyBy(final float factor)
    {
        return new FloatMoneyPerTime(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneypertime
     */
    public final FloatMoneyPerTime multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime divideBy(final float divisor)
    {
        return new FloatMoneyPerTime(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneypertime
     */
    public final FloatMoneyPerTime divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerTime plus(final FloatMoneyPerTime v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerTime(getInUnit() + v.getInUnit(), getUnit())
            : new FloatMoneyPerTime(this.si + v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerTime minus(final FloatMoneyPerTime v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerTime(getInUnit() - v.getInUnit(), getUnit())
            : new FloatMoneyPerTime(this.si - v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerTime and FloatMoneyPerTime, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerTime and FloatMoneyPerTime
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoneyPerTime v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerTime and FloatTime, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerTime and FloatTime
     */
    public final FloatMoney multiplyBy(final FloatTime.Rel v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerTime and FloatFrequency, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatMoney scalar as a division of FloatMoneyPerTime and FloatFrequency
     */
    public final FloatMoney divideBy(final FloatFrequency v)
    {
        return new FloatMoney(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
