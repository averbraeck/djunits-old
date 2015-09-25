package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerMass FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
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
public class MoneyPerMass extends FloatScalar.Rel<MoneyPerMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public MoneyPerMass(final float value, final MoneyPerMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerMass scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public MoneyPerMass(final double value, final MoneyPerMassUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct MoneyPerMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerMass(final FloatScalar.Rel<MoneyPerMassUnit> value)
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
    public static MoneyPerMass interpolate(final MoneyPerMass zero, final MoneyPerMass one, final float ratio)
    {
        return new MoneyPerMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
        return interpolate(zero, one, (float) ratio);
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
        return new MoneyPerMass((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass asin()
    {
        return new MoneyPerMass((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass atan()
    {
        return new MoneyPerMass((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cbrt()
    {
        return new MoneyPerMass((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass ceil()
    {
        return new MoneyPerMass((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cos()
    {
        return new MoneyPerMass((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass cosh()
    {
        return new MoneyPerMass((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass exp()
    {
        return new MoneyPerMass((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass expm1()
    {
        return new MoneyPerMass((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass floor()
    {
        return new MoneyPerMass((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log()
    {
        return new MoneyPerMass((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log10()
    {
        return new MoneyPerMass((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass log1p()
    {
        return new MoneyPerMass((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass rint()
    {
        return new MoneyPerMass((float) Math.rint(getInUnit()), getUnit());
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
        return new MoneyPerMass((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass sinh()
    {
        return new MoneyPerMass((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass sqrt()
    {
        return new MoneyPerMass((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass tan()
    {
        return new MoneyPerMass((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass tanh()
    {
        return new MoneyPerMass((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass inv()
    {
        return new MoneyPerMass(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass toDegrees()
    {
        return new MoneyPerMass((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass toRadians()
    {
        return new MoneyPerMass((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass pow(final double x)
    {
        return new MoneyPerMass((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass multiplyBy(final float factor)
    {
        return new MoneyPerMass(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneypermass
     */
    public final MoneyPerMass multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass divideBy(final float divisor)
    {
        return new MoneyPerMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneypermass
     */
    public final MoneyPerMass divideBy(final double factor)
    {
        return divideBy((float) factor);
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
