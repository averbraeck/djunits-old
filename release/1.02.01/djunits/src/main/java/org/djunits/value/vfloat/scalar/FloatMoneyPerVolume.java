package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerVolume FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FloatMoneyPerVolume extends FloatScalar.Rel<MoneyPerVolumeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerVolume(final float value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerVolume(final FloatScalar.Rel<MoneyPerVolumeUnit> value)
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
    public static FloatMoneyPerVolume interpolate(final FloatMoneyPerVolume zero, final FloatMoneyPerVolume one,
        final float ratio)
    {
        return new FloatMoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerVolume interpolate(final FloatMoneyPerVolume zero, final FloatMoneyPerVolume one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume abs()
    {
        return new FloatMoneyPerVolume(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume acos()
    {
        return new FloatMoneyPerVolume((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume asin()
    {
        return new FloatMoneyPerVolume((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume atan()
    {
        return new FloatMoneyPerVolume((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume cbrt()
    {
        return new FloatMoneyPerVolume((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume ceil()
    {
        return new FloatMoneyPerVolume((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume cos()
    {
        return new FloatMoneyPerVolume((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume cosh()
    {
        return new FloatMoneyPerVolume((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume exp()
    {
        return new FloatMoneyPerVolume((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume expm1()
    {
        return new FloatMoneyPerVolume((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume floor()
    {
        return new FloatMoneyPerVolume((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume log()
    {
        return new FloatMoneyPerVolume((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume log10()
    {
        return new FloatMoneyPerVolume((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume log1p()
    {
        return new FloatMoneyPerVolume((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume rint()
    {
        return new FloatMoneyPerVolume((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume round()
    {
        return new FloatMoneyPerVolume(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume signum()
    {
        return new FloatMoneyPerVolume(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume sin()
    {
        return new FloatMoneyPerVolume((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume sinh()
    {
        return new FloatMoneyPerVolume((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume sqrt()
    {
        return new FloatMoneyPerVolume((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume tan()
    {
        return new FloatMoneyPerVolume((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume tanh()
    {
        return new FloatMoneyPerVolume((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume inv()
    {
        return new FloatMoneyPerVolume(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume toDegrees()
    {
        return new FloatMoneyPerVolume((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume toRadians()
    {
        return new FloatMoneyPerVolume((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume pow(final double x)
    {
        return new FloatMoneyPerVolume((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume multiplyBy(final float factor)
    {
        return new FloatMoneyPerVolume(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneypervolume
     */
    public final FloatMoneyPerVolume multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume divideBy(final float divisor)
    {
        return new FloatMoneyPerVolume(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneypervolume
     */
    public final FloatMoneyPerVolume divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerVolume plus(final FloatMoneyPerVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerVolume(getInUnit() + v.getInUnit(), getUnit())
            : new FloatMoneyPerVolume(this.si + v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerVolume minus(final FloatMoneyPerVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerVolume(getInUnit() - v.getInUnit(), getUnit())
            : new FloatMoneyPerVolume(this.si - v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerVolume and FloatMoneyPerVolume, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerVolume scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerVolume and FloatMoneyPerVolume
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoneyPerVolume v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerVolume and FloatVolume, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerVolume scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerVolume and FloatVolume
     */
    public final FloatMoney multiplyBy(final FloatVolume v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
