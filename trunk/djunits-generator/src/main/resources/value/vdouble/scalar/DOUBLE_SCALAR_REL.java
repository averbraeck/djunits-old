package org.djunits.value.vdouble.scalar;

import org.djunits.value.Relative;
import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% DoubleScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
 * we can now write <br>
 * <i>%Type% value = new %Type%(100.0, %Type%Unit.SI);</i><br>
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
public class %Type% extends DoubleScalar.Rel<%Type%Unit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct %Type% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %Type%(final double value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %Type%(final DoubleScalar.Rel<%Type%Unit> value)
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
    public static %Type% interpolate(final %Type% zero, final %Type% one, final double ratio)
    {
        return new %Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% abs()
    {
        return new %Type%(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% acos()
    {
        return new %Type%(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% asin()
    {
        return new %Type%(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% atan()
    {
        return new %Type%(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% cbrt()
    {
        return new %Type%(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% ceil()
    {
        return new %Type%(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% cos()
    {
        return new %Type%(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% cosh()
    {
        return new %Type%(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% exp()
    {
        return new %Type%(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% expm1()
    {
        return new %Type%(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% floor()
    {
        return new %Type%(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% log()
    {
        return new %Type%(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% log10()
    {
        return new %Type%(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% log1p()
    {
        return new %Type%(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% rint()
    {
        return new %Type%(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% round()
    {
        return new %Type%(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% signum()
    {
        return new %Type%(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% sin()
    {
        return new %Type%(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% sinh()
    {
        return new %Type%(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% sqrt()
    {
        return new %Type%(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% tan()
    {
        return new %Type%(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% tanh()
    {
        return new %Type%(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% inv()
    {
        return new %Type%(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% toDegrees()
    {
        return new %Type%(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% toRadians()
    {
        return new %Type%(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% pow(final double x)
    {
        return new %Type%(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% multiplyBy(final double factor)
    {
        return new %Type%(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% divideBy(final double divisor)
    {
        return new %Type%(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final %Type% plus(final %Type% v)
    {
        return getUnit().equals(v.getUnit()) ? new %Type%(getInUnit() + v.getInUnit(), getUnit()) : new %Type%(this.si
            + v.si, %Type%Unit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final %Type% minus(final %Type% v)
    {
        return getUnit().equals(v.getUnit()) ? new %Type%(getInUnit() - v.getInUnit(), getUnit()) : new %Type%(this.si
            - v.si, %Type%Unit.SI);
    }
    
%FORMULAS%%Type%.Rel%
}

