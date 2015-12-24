package org.djunits.value.vfloat.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.Relative;

/**
 * Absolute Relative typed scalar. <br>
 * Note: Each scalar class should implement the static interpolate(zero, one, ratio). <br>
 * Note: A scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:45:14 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 85 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative vector type
 */
public abstract class TypedFloatScalarRel<U extends Unit<U>, R extends TypedFloatScalarRel<U, R>> extends
    FloatScalar.Rel<U> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Rel scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public TypedFloatScalarRel(final float value, final U unit)
    {
        super(value, unit);
    }

    /**
     * Construct Rel scalar.
     * @param value Scalar from which to construct this instance
     */
    public TypedFloatScalarRel(final R value)
    {
        super(value);
    }

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    protected abstract R instantiateTypeRel(final float value, final U unit);

    /* Note: Each scalar class should implement the static interpolate(zero, one, ratio). */
    /* Note: A scalar class can implement the toAbs() method if it has an absolute equivalent. */

    /** {@inheritDoc} */
    @Override
    public final R abs()
    {
        return instantiateTypeRel(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R acos()
    {
        return instantiateTypeRel((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R asin()
    {
        return instantiateTypeRel((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R atan()
    {
        return instantiateTypeRel((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cbrt()
    {
        return instantiateTypeRel((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R ceil()
    {
        return instantiateTypeRel((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cos()
    {
        return instantiateTypeRel((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cosh()
    {
        return instantiateTypeRel((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R exp()
    {
        return instantiateTypeRel((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R expm1()
    {
        return instantiateTypeRel((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R floor()
    {
        return instantiateTypeRel((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log()
    {
        return instantiateTypeRel((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log10()
    {
        return instantiateTypeRel((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log1p()
    {
        return instantiateTypeRel((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R rint()
    {
        return instantiateTypeRel((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R round()
    {
        return instantiateTypeRel(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R signum()
    {
        return instantiateTypeRel(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R sin()
    {
        return instantiateTypeRel((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R sinh()
    {
        return instantiateTypeRel((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R sqrt()
    {
        return instantiateTypeRel((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R tan()
    {
        return instantiateTypeRel((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R tanh()
    {
        return instantiateTypeRel((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R inv()
    {
        return instantiateTypeRel((float) 1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R toDegrees()
    {
        return instantiateTypeRel((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R toRadians()
    {
        return instantiateTypeRel((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R pow(final double x)
    {
        return instantiateTypeRel((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R multiplyBy(final float factor)
    {
        return instantiateTypeRel(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R divideBy(final float divisor)
    {
        return instantiateTypeRel(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final R plus(final R v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeRel(getInUnit() + v.getInUnit(), getUnit())
            : instantiateTypeRel(this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final R minus(final R v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeRel(getInUnit() - v.getInUnit(), getUnit())
            : instantiateTypeRel(this.si - v.si, getUnit().getStandardUnit());
    }

}