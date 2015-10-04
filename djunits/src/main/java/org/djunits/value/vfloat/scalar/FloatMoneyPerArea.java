package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerArea FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FloatMoneyPerArea extends FloatScalar.Rel<MoneyPerAreaUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerArea scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerArea(final float value, final MoneyPerAreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerArea scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerArea(final double value, final MoneyPerAreaUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerArea(final FloatScalar.Rel<MoneyPerAreaUnit> value)
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
    public static FloatMoneyPerArea interpolate(final FloatMoneyPerArea zero, final FloatMoneyPerArea one,
        final float ratio)
    {
        return new FloatMoneyPerArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerArea interpolate(final FloatMoneyPerArea zero, final FloatMoneyPerArea one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea abs()
    {
        return new FloatMoneyPerArea(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea acos()
    {
        return new FloatMoneyPerArea((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea asin()
    {
        return new FloatMoneyPerArea((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea atan()
    {
        return new FloatMoneyPerArea((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea cbrt()
    {
        return new FloatMoneyPerArea((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea ceil()
    {
        return new FloatMoneyPerArea((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea cos()
    {
        return new FloatMoneyPerArea((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea cosh()
    {
        return new FloatMoneyPerArea((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea exp()
    {
        return new FloatMoneyPerArea((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea expm1()
    {
        return new FloatMoneyPerArea((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea floor()
    {
        return new FloatMoneyPerArea((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea log()
    {
        return new FloatMoneyPerArea((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea log10()
    {
        return new FloatMoneyPerArea((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea log1p()
    {
        return new FloatMoneyPerArea((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea rint()
    {
        return new FloatMoneyPerArea((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea round()
    {
        return new FloatMoneyPerArea(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea signum()
    {
        return new FloatMoneyPerArea(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea sin()
    {
        return new FloatMoneyPerArea((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea sinh()
    {
        return new FloatMoneyPerArea((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea sqrt()
    {
        return new FloatMoneyPerArea((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea tan()
    {
        return new FloatMoneyPerArea((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea tanh()
    {
        return new FloatMoneyPerArea((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea inv()
    {
        return new FloatMoneyPerArea(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea toDegrees()
    {
        return new FloatMoneyPerArea((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea toRadians()
    {
        return new FloatMoneyPerArea((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea pow(final double x)
    {
        return new FloatMoneyPerArea((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea multiplyBy(final float factor)
    {
        return new FloatMoneyPerArea(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneyperarea
     */
    public final FloatMoneyPerArea multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerArea divideBy(final float divisor)
    {
        return new FloatMoneyPerArea(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneyperarea
     */
    public final FloatMoneyPerArea divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerArea plus(final FloatMoneyPerArea v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerArea(getInUnit() + v.getInUnit(), getUnit())
            : new FloatMoneyPerArea(this.si + v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerArea minus(final FloatMoneyPerArea v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerArea(getInUnit() - v.getInUnit(), getUnit())
            : new FloatMoneyPerArea(this.si - v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerArea and FloatMoneyPerArea, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerArea scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerArea and FloatMoneyPerArea
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoneyPerArea v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerArea and FloatArea, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerArea scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerArea and FloatArea
     */
    public final FloatMoney multiplyBy(final FloatArea v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
