package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the AngleSolid FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AngleSolidUnit&gt; value = new FloatScalar.Rel&lt;AngleSolidUnit&gt;(100.0, AngleSolidUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatAngleSolid value = new FloatAngleSolid(100.0, AngleSolidUnit.SI);</i><br>
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
public class FloatAngleSolid extends FloatScalar.Rel<AngleSolidUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatAngleSolid scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAngleSolid(final float value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAngleSolid scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatAngleSolid(final double value, final AngleSolidUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatAngleSolid scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAngleSolid(final FloatScalar.Rel<AngleSolidUnit> value)
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
    public static FloatAngleSolid interpolate(final FloatAngleSolid zero, final FloatAngleSolid one, final float ratio)
    {
        return new FloatAngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAngleSolid
        interpolate(final FloatAngleSolid zero, final FloatAngleSolid one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid abs()
    {
        return new FloatAngleSolid(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid acos()
    {
        return new FloatAngleSolid((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid asin()
    {
        return new FloatAngleSolid((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid atan()
    {
        return new FloatAngleSolid((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid cbrt()
    {
        return new FloatAngleSolid((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid ceil()
    {
        return new FloatAngleSolid((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid cos()
    {
        return new FloatAngleSolid((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid cosh()
    {
        return new FloatAngleSolid((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid exp()
    {
        return new FloatAngleSolid((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid expm1()
    {
        return new FloatAngleSolid((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid floor()
    {
        return new FloatAngleSolid((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid log()
    {
        return new FloatAngleSolid((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid log10()
    {
        return new FloatAngleSolid((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid log1p()
    {
        return new FloatAngleSolid((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid rint()
    {
        return new FloatAngleSolid((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid round()
    {
        return new FloatAngleSolid(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid signum()
    {
        return new FloatAngleSolid(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid sin()
    {
        return new FloatAngleSolid((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid sinh()
    {
        return new FloatAngleSolid((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid sqrt()
    {
        return new FloatAngleSolid((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid tan()
    {
        return new FloatAngleSolid((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid tanh()
    {
        return new FloatAngleSolid((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid inv()
    {
        return new FloatAngleSolid(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid toDegrees()
    {
        return new FloatAngleSolid((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid toRadians()
    {
        return new FloatAngleSolid((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid pow(final double x)
    {
        return new FloatAngleSolid((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid multiplyBy(final float factor)
    {
        return new FloatAngleSolid(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative anglesolid
     */
    public final FloatAngleSolid multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid divideBy(final float divisor)
    {
        return new FloatAngleSolid(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative anglesolid
     */
    public final FloatAngleSolid divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatAngleSolid plus(final FloatAngleSolid v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatAngleSolid(getInUnit() + v.getInUnit(), getUnit())
            : new FloatAngleSolid(this.si + v.si, AngleSolidUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatAngleSolid minus(final FloatAngleSolid v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatAngleSolid(getInUnit() - v.getInUnit(), getUnit())
            : new FloatAngleSolid(this.si - v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the division of FloatAngleSolid and FloatAngleSolid, which results in a FloatDimensionless scalar.
     * @param v FloatAngleSolid scalar
     * @return FloatDimensionless scalar as a division of FloatAngleSolid and FloatAngleSolid
     */
    public final FloatDimensionless.Rel divideBy(final FloatAngleSolid v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

}
