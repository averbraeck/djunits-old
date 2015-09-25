package org.djunits.value.vdouble.scalar;

import org.djunits.value.Relative;
import org.djunits.unit.*;

/**
 * Easy access methods for the %TYPE% DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class %TYPE% extends DoubleScalar.Rel<%TYPE%Unit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct %TYPE% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %TYPE%(final double value, final %TYPE%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TYPE% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TYPE%(final DoubleScalar.Rel<%TYPE%Unit> value)
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
    public static %TYPE% interpolate(final %TYPE% zero, final %TYPE% one, final double ratio)
    {
        return new %TYPE%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% abs()
    {
        return new %TYPE%(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% acos()
    {
        return new %TYPE%(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% asin()
    {
        return new %TYPE%(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% atan()
    {
        return new %TYPE%(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cbrt()
    {
        return new %TYPE%(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% ceil()
    {
        return new %TYPE%(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cos()
    {
        return new %TYPE%(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cosh()
    {
        return new %TYPE%(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% exp()
    {
        return new %TYPE%(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% expm1()
    {
        return new %TYPE%(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% floor()
    {
        return new %TYPE%(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log()
    {
        return new %TYPE%(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log10()
    {
        return new %TYPE%(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log1p()
    {
        return new %TYPE%(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% rint()
    {
        return new %TYPE%(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% round()
    {
        return new %TYPE%(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% signum()
    {
        return new %TYPE%(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% sin()
    {
        return new %TYPE%(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% sinh()
    {
        return new %TYPE%(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% sqrt()
    {
        return new %TYPE%(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% tan()
    {
        return new %TYPE%(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% tanh()
    {
        return new %TYPE%(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% inv()
    {
        return new %TYPE%(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% toDegrees()
    {
        return new %TYPE%(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% toRadians()
    {
        return new %TYPE%(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% pow(final double x)
    {
        return new %TYPE%(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% multiplyBy(final double factor)
    {
        return new %TYPE%(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% divideBy(final double divisor)
    {
        return new %TYPE%(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final %TYPE% plus(final %TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new %TYPE%(getInUnit() + v.getInUnit(), getUnit()) : new %TYPE%(this.si
            + v.si, %TYPE%Unit.getStandard%TYPE%Unit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final %TYPE% minus(final %TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new %TYPE%(getInUnit() - v.getInUnit(), getUnit()) : new %TYPE%(this.si
            - v.si, %TYPE%Unit.getStandard%TYPE%Unit());
    }
    
%FORMULAS%%TYPE%.Rel%
}

