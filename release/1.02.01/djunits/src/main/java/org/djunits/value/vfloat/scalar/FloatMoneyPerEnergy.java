package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerEnergy FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>FloatMoney price = new FloatMoney(100.0, MoneyUnit.EUR);</i><br>
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
public class FloatMoneyPerEnergy extends FloatScalar.Rel<MoneyPerEnergyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerEnergy scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerEnergy(final float value, final MoneyPerEnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerEnergy scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerEnergy(final double value, final MoneyPerEnergyUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerEnergy(final FloatScalar.Rel<MoneyPerEnergyUnit> value)
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
    public static FloatMoneyPerEnergy interpolate(final FloatMoneyPerEnergy zero, final FloatMoneyPerEnergy one,
        final float ratio)
    {
        return new FloatMoneyPerEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerEnergy interpolate(final FloatMoneyPerEnergy zero, final FloatMoneyPerEnergy one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy abs()
    {
        return new FloatMoneyPerEnergy(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy acos()
    {
        return new FloatMoneyPerEnergy((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy asin()
    {
        return new FloatMoneyPerEnergy((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy atan()
    {
        return new FloatMoneyPerEnergy((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy cbrt()
    {
        return new FloatMoneyPerEnergy((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy ceil()
    {
        return new FloatMoneyPerEnergy((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy cos()
    {
        return new FloatMoneyPerEnergy((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy cosh()
    {
        return new FloatMoneyPerEnergy((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy exp()
    {
        return new FloatMoneyPerEnergy((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy expm1()
    {
        return new FloatMoneyPerEnergy((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy floor()
    {
        return new FloatMoneyPerEnergy((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy log()
    {
        return new FloatMoneyPerEnergy((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy log10()
    {
        return new FloatMoneyPerEnergy((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy log1p()
    {
        return new FloatMoneyPerEnergy((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy rint()
    {
        return new FloatMoneyPerEnergy((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy round()
    {
        return new FloatMoneyPerEnergy(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy signum()
    {
        return new FloatMoneyPerEnergy(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy sin()
    {
        return new FloatMoneyPerEnergy((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy sinh()
    {
        return new FloatMoneyPerEnergy((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy sqrt()
    {
        return new FloatMoneyPerEnergy((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy tan()
    {
        return new FloatMoneyPerEnergy((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy tanh()
    {
        return new FloatMoneyPerEnergy((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy inv()
    {
        return new FloatMoneyPerEnergy(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy toDegrees()
    {
        return new FloatMoneyPerEnergy((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy toRadians()
    {
        return new FloatMoneyPerEnergy((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy pow(final double x)
    {
        return new FloatMoneyPerEnergy((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy multiplyBy(final float factor)
    {
        return new FloatMoneyPerEnergy(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneyperenergy
     */
    public final FloatMoneyPerEnergy multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy divideBy(final float divisor)
    {
        return new FloatMoneyPerEnergy(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneyperenergy
     */
    public final FloatMoneyPerEnergy divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerEnergy plus(final FloatMoneyPerEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerEnergy(getInUnit() + v.getInUnit(), getUnit())
            : new FloatMoneyPerEnergy(this.si + v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerEnergy minus(final FloatMoneyPerEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerEnergy(getInUnit() - v.getInUnit(), getUnit())
            : new FloatMoneyPerEnergy(this.si - v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerEnergy and FloatMoneyPerEnergy, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerEnergy scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerEnergy and FloatMoneyPerEnergy
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoneyPerEnergy v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerEnergy and FloatEnergy, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerEnergy scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerEnergy and FloatEnergy
     */
    public final FloatMoney multiplyBy(final FloatEnergy v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
