package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerEnergy DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, MoneyUnit.EUR);</i><br>
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
public class MoneyPerEnergy extends DoubleScalar.Rel<MoneyPerEnergyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerEnergy(final double value, final MoneyPerEnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerEnergy(final DoubleScalar.Rel<MoneyPerEnergyUnit> value)
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
    public static MoneyPerEnergy interpolate(final MoneyPerEnergy zero, final MoneyPerEnergy one, final double ratio)
    {
        return new MoneyPerEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy abs()
    {
        return new MoneyPerEnergy(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy acos()
    {
        return new MoneyPerEnergy(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy asin()
    {
        return new MoneyPerEnergy(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy atan()
    {
        return new MoneyPerEnergy(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy cbrt()
    {
        return new MoneyPerEnergy(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy ceil()
    {
        return new MoneyPerEnergy(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy cos()
    {
        return new MoneyPerEnergy(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy cosh()
    {
        return new MoneyPerEnergy(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy exp()
    {
        return new MoneyPerEnergy(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy expm1()
    {
        return new MoneyPerEnergy(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy floor()
    {
        return new MoneyPerEnergy(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy log()
    {
        return new MoneyPerEnergy(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy log10()
    {
        return new MoneyPerEnergy(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy log1p()
    {
        return new MoneyPerEnergy(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy rint()
    {
        return new MoneyPerEnergy(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy round()
    {
        return new MoneyPerEnergy(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy signum()
    {
        return new MoneyPerEnergy(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy sin()
    {
        return new MoneyPerEnergy(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy sinh()
    {
        return new MoneyPerEnergy(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy sqrt()
    {
        return new MoneyPerEnergy(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy tan()
    {
        return new MoneyPerEnergy(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy tanh()
    {
        return new MoneyPerEnergy(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy inv()
    {
        return new MoneyPerEnergy(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy toDegrees()
    {
        return new MoneyPerEnergy(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy toRadians()
    {
        return new MoneyPerEnergy(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy pow(final double x)
    {
        return new MoneyPerEnergy(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy multiplyBy(final double factor)
    {
        return new MoneyPerEnergy(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy divideBy(final double divisor)
    {
        return new MoneyPerEnergy(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerEnergy plus(final MoneyPerEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerEnergy(getInUnit() + v.getInUnit(), getUnit())
            : new MoneyPerEnergy(this.si + v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerEnergy minus(final MoneyPerEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerEnergy(getInUnit() - v.getInUnit(), getUnit())
            : new MoneyPerEnergy(this.si - v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of MoneyPerEnergy and MoneyPerEnergy, which results in a Dimensionless scalar.
     * @param v MoneyPerEnergy scalar
     * @return Dimensionless scalar as a division of MoneyPerEnergy and MoneyPerEnergy
     */
    public final Dimensionless.Rel divideBy(final MoneyPerEnergy v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerEnergy and Energy, which results in a Money scalar.
     * @param v MoneyPerEnergy scalar
     * @return Money scalar as a multiplication of MoneyPerEnergy and Energy
     */
    public final Money multiplyBy(final Energy v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
