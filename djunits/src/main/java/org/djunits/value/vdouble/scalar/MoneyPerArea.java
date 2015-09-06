package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.UNITS;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerArea DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class MoneyPerArea extends DoubleScalar.Rel<MoneyPerAreaUnit> implements UNITS, Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerArea scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerArea(final double value, final MoneyPerAreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerArea(final DoubleScalar.Rel<MoneyPerAreaUnit> value)
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
    public static MoneyPerArea interpolate(final MoneyPerArea zero, final MoneyPerArea one, final double ratio)
    {
        return new MoneyPerArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea abs()
    {
        return new MoneyPerArea(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea acos()
    {
        return new MoneyPerArea(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea asin()
    {
        return new MoneyPerArea(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea atan()
    {
        return new MoneyPerArea(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea cbrt()
    {
        return new MoneyPerArea(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea ceil()
    {
        return new MoneyPerArea(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea cos()
    {
        return new MoneyPerArea(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea cosh()
    {
        return new MoneyPerArea(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea exp()
    {
        return new MoneyPerArea(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea expm1()
    {
        return new MoneyPerArea(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea floor()
    {
        return new MoneyPerArea(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea log()
    {
        return new MoneyPerArea(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea log10()
    {
        return new MoneyPerArea(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea log1p()
    {
        return new MoneyPerArea(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea rint()
    {
        return new MoneyPerArea(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea round()
    {
        return new MoneyPerArea(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea signum()
    {
        return new MoneyPerArea(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea sin()
    {
        return new MoneyPerArea(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea sinh()
    {
        return new MoneyPerArea(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea sqrt()
    {
        return new MoneyPerArea(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea tan()
    {
        return new MoneyPerArea(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea tanh()
    {
        return new MoneyPerArea(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea inv()
    {
        return new MoneyPerArea(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea toDegrees()
    {
        return new MoneyPerArea(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea toRadians()
    {
        return new MoneyPerArea(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea pow(final double x)
    {
        return new MoneyPerArea(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea multiplyBy(final double factor)
    {
        return new MoneyPerArea(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea divideBy(final double divisor)
    {
        return new MoneyPerArea(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerArea plus(final MoneyPerArea v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerArea(getInUnit() + v.getInUnit(), getUnit()) : new MoneyPerArea(
            this.si + v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerArea minus(final MoneyPerArea v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerArea(getInUnit() - v.getInUnit(), getUnit()) : new MoneyPerArea(
            this.si - v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of MoneyPerArea and MoneyPerArea, which results in a Dimensionless scalar.
     * @param v MoneyPerArea scalar
     * @return Dimensionless scalar as a division of MoneyPerArea and MoneyPerArea
     */
    public final Dimensionless.Rel divideBy(final MoneyPerArea v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerArea and Area, which results in a Money scalar.
     * @param v MoneyPerArea scalar
     * @return Money scalar as a multiplication of MoneyPerArea and Area
     */
    public final Money multiplyBy(final Area.Rel v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
