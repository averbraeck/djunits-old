package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.UNITS;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerTime DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerTime extends DoubleScalar.Rel<MoneyPerTimeUnit> implements UNITS, Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerTime scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerTime(final double value, final MoneyPerTimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerTime scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerTime(final DoubleScalar.Rel<MoneyPerTimeUnit> value)
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
    public static MoneyPerTime interpolate(final MoneyPerTime zero, final MoneyPerTime one, final double ratio)
    {
        return new MoneyPerTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime abs()
    {
        return new MoneyPerTime(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime acos()
    {
        return new MoneyPerTime(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime asin()
    {
        return new MoneyPerTime(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime atan()
    {
        return new MoneyPerTime(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime cbrt()
    {
        return new MoneyPerTime(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime ceil()
    {
        return new MoneyPerTime(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime cos()
    {
        return new MoneyPerTime(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime cosh()
    {
        return new MoneyPerTime(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime exp()
    {
        return new MoneyPerTime(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime expm1()
    {
        return new MoneyPerTime(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime floor()
    {
        return new MoneyPerTime(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime log()
    {
        return new MoneyPerTime(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime log10()
    {
        return new MoneyPerTime(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime log1p()
    {
        return new MoneyPerTime(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime rint()
    {
        return new MoneyPerTime(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime round()
    {
        return new MoneyPerTime(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime signum()
    {
        return new MoneyPerTime(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime sin()
    {
        return new MoneyPerTime(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime sinh()
    {
        return new MoneyPerTime(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime sqrt()
    {
        return new MoneyPerTime(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime tan()
    {
        return new MoneyPerTime(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime tanh()
    {
        return new MoneyPerTime(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime inv()
    {
        return new MoneyPerTime(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime toDegrees()
    {
        return new MoneyPerTime(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime toRadians()
    {
        return new MoneyPerTime(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime pow(final double x)
    {
        return new MoneyPerTime(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime multiplyBy(final double factor)
    {
        return new MoneyPerTime(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime divideBy(final double divisor)
    {
        return new MoneyPerTime(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerTime plus(final MoneyPerTime v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerTime(getInUnit() + v.getInUnit(), getUnit()) : new MoneyPerTime(
                this.si + v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerTime minus(final MoneyPerTime v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerTime(getInUnit() - v.getInUnit(), getUnit()) : new MoneyPerTime(
                this.si - v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of MoneyPerTime and MoneyPerTime, which results in a Dimensionless scalar.
     * @param v MoneyPerTime scalar
     * @return Dimensionless scalar as a division of MoneyPerTime and MoneyPerTime
     */
    public final Dimensionless.Rel divideBy(final MoneyPerTime v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerTime and Time, which results in a Money scalar.
     * @param v MoneyPerTime scalar
     * @return Money scalar as a multiplication of MoneyPerTime and Time
     */
    public final Money multiplyBy(final Time.Rel v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of MoneyPerTime and Frequency, which results in a Money scalar.
     * @param v MoneyPerTime scalar
     * @return Money scalar as a division of MoneyPerTime and Frequency
     */
    public final Money divideBy(final Frequency.Rel v)
    {
        return new Money(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
