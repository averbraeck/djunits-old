package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the AngleSlope DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class AngleSlope extends DoubleScalar.Rel<AngleSlopeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct AngleSlope scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AngleSlope(final double value, final AngleSlopeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AngleSlope scalar.
     * @param value Scalar from which to construct this instance
     */
    public AngleSlope(final DoubleScalar.Rel<AngleSlopeUnit> value)
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
    public static AngleSlope interpolate(final AngleSlope zero, final AngleSlope one, final double ratio)
    {
        return new AngleSlope(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope abs()
    {
        return new AngleSlope(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope acos()
    {
        return new AngleSlope(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope asin()
    {
        return new AngleSlope(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope atan()
    {
        return new AngleSlope(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cbrt()
    {
        return new AngleSlope(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope ceil()
    {
        return new AngleSlope(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cos()
    {
        return new AngleSlope(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cosh()
    {
        return new AngleSlope(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope exp()
    {
        return new AngleSlope(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope expm1()
    {
        return new AngleSlope(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope floor()
    {
        return new AngleSlope(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log()
    {
        return new AngleSlope(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log10()
    {
        return new AngleSlope(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log1p()
    {
        return new AngleSlope(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope rint()
    {
        return new AngleSlope(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope round()
    {
        return new AngleSlope(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope signum()
    {
        return new AngleSlope(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope sin()
    {
        return new AngleSlope(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope sinh()
    {
        return new AngleSlope(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope sqrt()
    {
        return new AngleSlope(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope tan()
    {
        return new AngleSlope(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope tanh()
    {
        return new AngleSlope(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope inv()
    {
        return new AngleSlope(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope toDegrees()
    {
        return new AngleSlope(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope toRadians()
    {
        return new AngleSlope(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope pow(final double x)
    {
        return new AngleSlope(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope multiplyBy(final double factor)
    {
        return new AngleSlope(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope divideBy(final double divisor)
    {
        return new AngleSlope(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final AngleSlope plus(final AngleSlope v)
    {
        return getUnit().equals(v.getUnit()) ? new AngleSlope(getInUnit() + v.getInUnit(), getUnit()) : new AngleSlope(
            this.si + v.si, AngleSlopeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final AngleSlope minus(final AngleSlope v)
    {
        return getUnit().equals(v.getUnit()) ? new AngleSlope(getInUnit() - v.getInUnit(), getUnit()) : new AngleSlope(
            this.si - v.si, AngleSlopeUnit.SI);
    }

    /**
     * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
     * @param v AngleSlope scalar
     * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
     */
    public final Dimensionless.Rel divideBy(final AngleSlope v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

}
