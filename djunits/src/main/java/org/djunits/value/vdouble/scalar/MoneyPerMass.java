package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerMass DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, MoneyUnit.EUR);</i><br>
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
public class MoneyPerMass extends DoubleScalar.Rel<MoneyPerMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerMass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerMass(final double value, final MoneyPerMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerMass(final DoubleScalar.Rel<MoneyPerMassUnit> value)
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
    public static MoneyPerMass interpolate(final MoneyPerMass zero, final MoneyPerMass one, final double ratio)
    {
        return new MoneyPerMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass abs()
    {
        return new MoneyPerMass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass acos()
    {
        return new MoneyPerMass(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass asin()
    {
        return new MoneyPerMass(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass atan()
    {
        return new MoneyPerMass(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cbrt()
    {
        return new MoneyPerMass(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass ceil()
    {
        return new MoneyPerMass(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cos()
    {
        return new MoneyPerMass(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cosh()
    {
        return new MoneyPerMass(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass exp()
    {
        return new MoneyPerMass(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass expm1()
    {
        return new MoneyPerMass(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass floor()
    {
        return new MoneyPerMass(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log()
    {
        return new MoneyPerMass(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log10()
    {
        return new MoneyPerMass(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log1p()
    {
        return new MoneyPerMass(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass rint()
    {
        return new MoneyPerMass(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass round()
    {
        return new MoneyPerMass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass signum()
    {
        return new MoneyPerMass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass sin()
    {
        return new MoneyPerMass(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass sinh()
    {
        return new MoneyPerMass(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass sqrt()
    {
        return new MoneyPerMass(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass tan()
    {
        return new MoneyPerMass(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass tanh()
    {
        return new MoneyPerMass(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass inv()
    {
        return new MoneyPerMass(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass toDegrees()
    {
        return new MoneyPerMass(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass toRadians()
    {
        return new MoneyPerMass(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass pow(final double x)
    {
        return new MoneyPerMass(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass multiplyBy(final double factor)
    {
        return new MoneyPerMass(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass divideBy(final double divisor)
    {
        return new MoneyPerMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final MoneyPerMass plus(final MoneyPerMass v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerMass(getInUnit() + v.getInUnit(), getUnit())
            : new MoneyPerMass(this.si + v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final MoneyPerMass minus(final MoneyPerMass v)
    {
        return getUnit().equals(v.getUnit()) ? new MoneyPerMass(getInUnit() - v.getInUnit(), getUnit())
            : new MoneyPerMass(this.si - v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of MoneyPerMass and MoneyPerMass, which results in a Dimensionless scalar.
     * @param v MoneyPerMass scalar
     * @return Dimensionless scalar as a division of MoneyPerMass and MoneyPerMass
     */
    public final Dimensionless.Rel divideBy(final MoneyPerMass v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerMass and Mass, which results in a Money scalar.
     * @param v MoneyPerMass scalar
     * @return Money scalar as a multiplication of MoneyPerMass and Mass
     */
    public final Money multiplyBy(final Mass v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
