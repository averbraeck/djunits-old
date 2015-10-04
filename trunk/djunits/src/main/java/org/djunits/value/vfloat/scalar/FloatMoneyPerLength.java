package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerLength FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FloatMoneyPerLength extends FloatScalar.Rel<MoneyPerLengthUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerLength scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerLength(final float value, final MoneyPerLengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerLength scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerLength(final double value, final MoneyPerLengthUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerLength scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerLength(final FloatScalar.Rel<MoneyPerLengthUnit> value)
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
    public static FloatMoneyPerLength interpolate(final FloatMoneyPerLength zero, final FloatMoneyPerLength one, final float ratio)
    {
        return new FloatMoneyPerLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerLength interpolate(final FloatMoneyPerLength zero, final FloatMoneyPerLength one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength abs()
    {
        return new FloatMoneyPerLength(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength acos()
    {
        return new FloatMoneyPerLength((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength asin()
    {
        return new FloatMoneyPerLength((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength atan()
    {
        return new FloatMoneyPerLength((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength cbrt()
    {
        return new FloatMoneyPerLength((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength ceil()
    {
        return new FloatMoneyPerLength((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength cos()
    {
        return new FloatMoneyPerLength((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength cosh()
    {
        return new FloatMoneyPerLength((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength exp()
    {
        return new FloatMoneyPerLength((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength expm1()
    {
        return new FloatMoneyPerLength((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength floor()
    {
        return new FloatMoneyPerLength((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength log()
    {
        return new FloatMoneyPerLength((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength log10()
    {
        return new FloatMoneyPerLength((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength log1p()
    {
        return new FloatMoneyPerLength((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength rint()
    {
        return new FloatMoneyPerLength((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength round()
    {
        return new FloatMoneyPerLength(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength signum()
    {
        return new FloatMoneyPerLength(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength sin()
    {
        return new FloatMoneyPerLength((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength sinh()
    {
        return new FloatMoneyPerLength((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength sqrt()
    {
        return new FloatMoneyPerLength((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength tan()
    {
        return new FloatMoneyPerLength((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength tanh()
    {
        return new FloatMoneyPerLength((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength inv()
    {
        return new FloatMoneyPerLength(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength toDegrees()
    {
        return new FloatMoneyPerLength((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength toRadians()
    {
        return new FloatMoneyPerLength((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength pow(final double x)
    {
        return new FloatMoneyPerLength((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength multiplyBy(final float factor)
    {
        return new FloatMoneyPerLength(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneyperlength
     */
    public final FloatMoneyPerLength multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLength divideBy(final float divisor)
    {
        return new FloatMoneyPerLength(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneyperlength
     */
    public final FloatMoneyPerLength divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerLength plus(final FloatMoneyPerLength v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerLength(getInUnit() + v.getInUnit(), getUnit()) : new FloatMoneyPerLength(this.si
            + v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerLength minus(final FloatMoneyPerLength v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerLength(getInUnit() - v.getInUnit(), getUnit()) : new FloatMoneyPerLength(this.si
            - v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }
        /**
         * Calculate the division of FloatMoneyPerLength and FloatMoneyPerLength, which results in a FloatDimensionless scalar.
         * @param v FloatMoneyPerLength scalar
         * @return FloatDimensionless scalar as a division of FloatMoneyPerLength and FloatMoneyPerLength
         */
        public final FloatDimensionless.Rel divideBy(final FloatMoneyPerLength v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatMoneyPerLength and FloatLength, which results in a FloatMoney scalar.
         * @param v FloatMoneyPerLength scalar
         * @return FloatMoney scalar as a multiplication of FloatMoneyPerLength and FloatLength
         */
        public final FloatMoney multiplyBy(final FloatLength.Rel v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

        /**
         * Calculate the division of FloatMoneyPerLength and FloatLinearDensity, which results in a FloatMoney scalar.
         * @param v FloatMoneyPerLength scalar
         * @return FloatMoney scalar as a division of FloatMoneyPerLength and FloatLinearDensity
         */
        public final FloatMoney divideBy(final FloatLinearDensity v)
        {
            return new FloatMoney(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
        }


}
