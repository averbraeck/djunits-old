package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the LinearDensity DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class LinearDensity extends DoubleScalar.Rel<LinearDensityUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct LinearDensity scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public LinearDensity(final double value, final LinearDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct LinearDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public LinearDensity(final DoubleScalar.Rel<LinearDensityUnit> value)
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
    public static LinearDensity interpolate(final LinearDensity zero, final LinearDensity one, final double ratio)
    {
        return new LinearDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity abs()
    {
        return new LinearDensity(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity acos()
    {
        return new LinearDensity(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity asin()
    {
        return new LinearDensity(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity atan()
    {
        return new LinearDensity(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity cbrt()
    {
        return new LinearDensity(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity ceil()
    {
        return new LinearDensity(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity cos()
    {
        return new LinearDensity(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity cosh()
    {
        return new LinearDensity(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity exp()
    {
        return new LinearDensity(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity expm1()
    {
        return new LinearDensity(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity floor()
    {
        return new LinearDensity(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity log()
    {
        return new LinearDensity(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity log10()
    {
        return new LinearDensity(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity log1p()
    {
        return new LinearDensity(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity rint()
    {
        return new LinearDensity(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity round()
    {
        return new LinearDensity(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity signum()
    {
        return new LinearDensity(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity sin()
    {
        return new LinearDensity(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity sinh()
    {
        return new LinearDensity(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity sqrt()
    {
        return new LinearDensity(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity tan()
    {
        return new LinearDensity(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity tanh()
    {
        return new LinearDensity(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity inv()
    {
        return new LinearDensity(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity toDegrees()
    {
        return new LinearDensity(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity toRadians()
    {
        return new LinearDensity(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity pow(final double x)
    {
        return new LinearDensity(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity multiplyBy(final double factor)
    {
        return new LinearDensity(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity divideBy(final double divisor)
    {
        return new LinearDensity(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final LinearDensity plus(final LinearDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new LinearDensity(getInUnit() + v.getInUnit(), getUnit())
            : new LinearDensity(this.si + v.si, LinearDensityUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final LinearDensity minus(final LinearDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new LinearDensity(getInUnit() - v.getInUnit(), getUnit())
            : new LinearDensity(this.si - v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of LinearDensity and LinearDensity, which results in a Dimensionless scalar.
     * @param v LinearDensity scalar
     * @return Dimensionless scalar as a division of LinearDensity and LinearDensity
     */
    public final Dimensionless.Rel divideBy(final LinearDensity v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Area, which results in a Length scalar.
     * @param v LinearDensity scalar
     * @return Length scalar as a multiplication of LinearDensity and Area
     */
    public final Length.Rel multiplyBy(final Area v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Energy, which results in a Force scalar.
     * @param v LinearDensity scalar
     * @return Force scalar as a multiplication of LinearDensity and Energy
     */
    public final Force multiplyBy(final Energy v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Speed, which results in a Frequency scalar.
     * @param v LinearDensity scalar
     * @return Frequency scalar as a multiplication of LinearDensity and Speed
     */
    public final Frequency multiplyBy(final Speed v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Money, which results in a MoneyPerLength scalar.
     * @param v LinearDensity scalar
     * @return MoneyPerLength scalar as a multiplication of LinearDensity and Money
     */
    public final MoneyPerLength multiplyBy(final Money v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

}
