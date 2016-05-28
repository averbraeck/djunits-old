package org.djunits.value.vfloat.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.Relative;

/**
 * Absolute Relative typed scalar. <br>
 * Note: Each scalar class should implement the static interpolate(zero, one, ratio). <br>
 * Note: A scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:45:14 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 85 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative vector type
 */
public abstract class TypedFloatScalarDimensionless<U extends Unit<U>, R extends TypedFloatScalarDimensionless<U, R>> extends
        TypedFloatScalarRel<U, R> implements Relative, MathFunctionsDimensionless<R>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Rel scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public TypedFloatScalarDimensionless(final float value, final U unit)
    {
        super(value, unit);
    }

    /**
     * Construct Rel scalar.
     * @param value Scalar from which to construct this instance
     */
    public TypedFloatScalarDimensionless(final R value)
    {
        super(value);
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
    public final R pow(final double x)
    {
        return instantiateTypeRel((float) Math.pow(getInUnit(), x), getUnit());
    }
}
