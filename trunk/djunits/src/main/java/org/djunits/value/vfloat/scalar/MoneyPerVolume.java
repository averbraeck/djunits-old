package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerVolume FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
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
public class MoneyPerVolume extends FloatScalar.Rel<MoneyPerVolumeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public MoneyPerVolume(final float value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public MoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct MoneyPerVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerVolume(final FloatScalar.Rel<MoneyPerVolumeUnit> value)
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
    public static MoneyPerVolume interpolate(final MoneyPerVolume zero, final MoneyPerVolume one, final float ratio)
    {
        return new MoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerVolume interpolate(final MoneyPerVolume zero, final MoneyPerVolume one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume abs()
    {
        return new MoneyPerVolume(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume acos()
    {
        return new MoneyPerVolume((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume asin()
    {
        return new MoneyPerVolume((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume atan()
    {
        return new MoneyPerVolume((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume cbrt()
    {
        return new MoneyPerVolume((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume ceil()
    {
        return new MoneyPerVolume((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume cos()
    {
        return new MoneyPerVolume((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume cosh()
    {
        return new MoneyPerVolume((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume exp()
    {
        return new MoneyPerVolume((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume expm1()
    {
        return new MoneyPerVolume((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume floor()
    {
        return new MoneyPerVolume((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume log()
    {
        return new MoneyPerVolume((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume log10()
    {
        return new MoneyPerVolume((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume log1p()
    {
        return new MoneyPerVolume((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume rint()
    {
        return new MoneyPerVolume((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume round()
    {
        return new MoneyPerVolume(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume signum()
    {
        return new MoneyPerVolume(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume sin()
    {
        return new MoneyPerVolume((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume sinh()
    {
        return new MoneyPerVolume((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume sqrt()
    {
        return new MoneyPerVolume((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume tan()
    {
        return new MoneyPerVolume((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume tanh()
    {
        return new MoneyPerVolume((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume inv()
    {
        return new MoneyPerVolume(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume toDegrees()
    {
        return new MoneyPerVolume((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume toRadians()
    {
        return new MoneyPerVolume((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume pow(final double x)
    {
        return new MoneyPerVolume((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume multiplyBy(final float factor)
    {
        return new MoneyPerVolume(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneypervolume
     */
    public final MoneyPerVolume multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume divideBy(final float divisor)
    {
        return new MoneyPerVolume(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneypervolume
     */
    public final MoneyPerVolume divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerVolume plus(final MoneyPerVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerVolume(getInUnit() + v.getInUnit(), getUnit())
            : new MoneyPerVolume(this.si + v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerVolume minus(final MoneyPerVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerVolume(getInUnit() - v.getInUnit(), getUnit())
            : new MoneyPerVolume(this.si - v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the division of MoneyPerVolume and MoneyPerVolume, which results in a Dimensionless scalar.
     * @param v MoneyPerVolume scalar
     * @return Dimensionless scalar as a division of MoneyPerVolume and MoneyPerVolume
     */
    public final Dimensionless.Rel divideBy(final MoneyPerVolume v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerVolume and Volume, which results in a Money scalar.
     * @param v MoneyPerVolume scalar
     * @return Money scalar as a multiplication of MoneyPerVolume and Volume
     */
    public final Money multiplyBy(final Volume v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
