package org.djunits.value.vdouble.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsDimensionless;

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
public abstract class TypedDoubleScalarDimensionless<U extends Unit<U>, R extends TypedDoubleScalarDimensionless<U, R>>
    extends TypedDoubleScalarRel<U, R> implements MathFunctionsDimensionless<R>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Rel scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public TypedDoubleScalarDimensionless(final double value, final U unit)
    {
        super(value, unit);
    }

    /**
     * Construct Rel scalar.
     * @param value Scalar from which to construct this instance
     */
    public TypedDoubleScalarDimensionless(final R value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final R acos()
    {
        return instantiateTypeRel(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R asin()
    {
        return instantiateTypeRel(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R atan()
    {
        return instantiateTypeRel(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cbrt()
    {
        return instantiateTypeRel(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cos()
    {
        return instantiateTypeRel(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R cosh()
    {
        return instantiateTypeRel(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R exp()
    {
        return instantiateTypeRel(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R expm1()
    {
        return instantiateTypeRel(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log()
    {
        return instantiateTypeRel(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log10()
    {
        return instantiateTypeRel(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R log1p()
    {
        return instantiateTypeRel(Math.log1p(getInUnit()), getUnit());
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
        return instantiateTypeRel(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R sinh()
    {
        return instantiateTypeRel(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R sqrt()
    {
        return instantiateTypeRel(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R tan()
    {
        return instantiateTypeRel(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R tanh()
    {
        return instantiateTypeRel(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R inv()
    {
        return instantiateTypeRel(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R pow(final double x)
    {
        return instantiateTypeRel(Math.pow(getInUnit(), x), getUnit());
    }
}
