package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerLength DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
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
public class MoneyPerLength extends DoubleScalar.Rel<MoneyPerLengthUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerLength scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerLength(final double value, final MoneyPerLengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerLength scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerLength(final DoubleScalar.Rel<MoneyPerLengthUnit> value)
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
    public static MoneyPerLength interpolate(final MoneyPerLength zero, final MoneyPerLength one, final double ratio)
    {
        return new MoneyPerLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength abs()
    {
        return new MoneyPerLength(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength acos()
    {
        return new MoneyPerLength(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength asin()
    {
        return new MoneyPerLength(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength atan()
    {
        return new MoneyPerLength(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength cbrt()
    {
        return new MoneyPerLength(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength ceil()
    {
        return new MoneyPerLength(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength cos()
    {
        return new MoneyPerLength(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength cosh()
    {
        return new MoneyPerLength(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength exp()
    {
        return new MoneyPerLength(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength expm1()
    {
        return new MoneyPerLength(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength floor()
    {
        return new MoneyPerLength(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength log()
    {
        return new MoneyPerLength(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength log10()
    {
        return new MoneyPerLength(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength log1p()
    {
        return new MoneyPerLength(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength rint()
    {
        return new MoneyPerLength(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength round()
    {
        return new MoneyPerLength(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength signum()
    {
        return new MoneyPerLength(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength sin()
    {
        return new MoneyPerLength(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength sinh()
    {
        return new MoneyPerLength(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength sqrt()
    {
        return new MoneyPerLength(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength tan()
    {
        return new MoneyPerLength(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength tanh()
    {
        return new MoneyPerLength(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength inv()
    {
        return new MoneyPerLength(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength toDegrees()
    {
        return new MoneyPerLength(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength toRadians()
    {
        return new MoneyPerLength(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength pow(final double x)
    {
        return new MoneyPerLength(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength multiplyBy(final double factor)
    {
        return new MoneyPerLength(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength divideBy(final double divisor)
    {
        return new MoneyPerLength(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerLength plus(final MoneyPerLength v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerLength(getInUnit() + v.getInUnit(), getUnit())
            : new MoneyPerLength(this.si + v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerLength minus(final MoneyPerLength v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerLength(getInUnit() - v.getInUnit(), getUnit())
            : new MoneyPerLength(this.si - v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of MoneyPerLength and MoneyPerLength, which results in a Dimensionless scalar.
     * @param v MoneyPerLength scalar
     * @return Dimensionless scalar as a division of MoneyPerLength and MoneyPerLength
     */
    public final Dimensionless.Rel divideBy(final MoneyPerLength v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerLength and Length, which results in a Money scalar.
     * @param v MoneyPerLength scalar
     * @return Money scalar as a multiplication of MoneyPerLength and Length
     */
    public final Money multiplyBy(final Length.Rel v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of MoneyPerLength and LinearDensity, which results in a Money scalar.
     * @param v MoneyPerLength scalar
     * @return Money scalar as a division of MoneyPerLength and LinearDensity
     */
    public final Money divideBy(final LinearDensity v)
    {
        return new Money(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
