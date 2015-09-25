package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the AngleSlope FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class AngleSlope extends FloatScalar.Rel<AngleSlopeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct AngleSlope scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public AngleSlope(final float value, final AngleSlopeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AngleSlope scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public AngleSlope(final double value, final AngleSlopeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct AngleSlope scalar.
     * @param value Scalar from which to construct this instance
     */
    public AngleSlope(final FloatScalar.Rel<AngleSlopeUnit> value)
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
    public static AngleSlope interpolate(final AngleSlope zero, final AngleSlope one, final float ratio)
    {
        return new AngleSlope(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
        return interpolate(zero, one, (float) ratio);
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
        return new AngleSlope((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope asin()
    {
        return new AngleSlope((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope atan()
    {
        return new AngleSlope((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cbrt()
    {
        return new AngleSlope((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope ceil()
    {
        return new AngleSlope((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cos()
    {
        return new AngleSlope((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope cosh()
    {
        return new AngleSlope((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope exp()
    {
        return new AngleSlope((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope expm1()
    {
        return new AngleSlope((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope floor()
    {
        return new AngleSlope((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log()
    {
        return new AngleSlope((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log10()
    {
        return new AngleSlope((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope log1p()
    {
        return new AngleSlope((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope rint()
    {
        return new AngleSlope((float) Math.rint(getInUnit()), getUnit());
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
        return new AngleSlope((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope sinh()
    {
        return new AngleSlope((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope sqrt()
    {
        return new AngleSlope((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope tan()
    {
        return new AngleSlope((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope tanh()
    {
        return new AngleSlope((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope inv()
    {
        return new AngleSlope(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope toDegrees()
    {
        return new AngleSlope((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope toRadians()
    {
        return new AngleSlope((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope pow(final double x)
    {
        return new AngleSlope((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope multiplyBy(final float factor)
    {
        return new AngleSlope(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative angleslope
     */
    public final AngleSlope multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSlope divideBy(final float divisor)
    {
        return new AngleSlope(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative angleslope
     */
    public final AngleSlope divideBy(final double factor)
    {
        return divideBy((float) factor);
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
