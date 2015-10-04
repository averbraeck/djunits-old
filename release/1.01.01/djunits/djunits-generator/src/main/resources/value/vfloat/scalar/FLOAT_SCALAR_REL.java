package org.djunits.value.vfloat.scalar;

import org.djunits.value.Relative;
import org.djunits.unit.*;

/**
 * Easy access methods for the %TYPE% FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
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
public class %TYPE% extends FloatScalar.Rel<%TYPE%Unit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct %TYPE% scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public %TYPE%(final float value, final %TYPE%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TYPE% scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public %TYPE%(final double value, final %TYPE%Unit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct %TYPE% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TYPE%(final FloatScalar.Rel<%TYPE%Unit> value)
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
    public static %TYPE% interpolate(final %TYPE% zero, final %TYPE% one, final float ratio)
    {
        return new %TYPE%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %TYPE% interpolate(final %TYPE%.Rel zero, final %TYPE%.Rel one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
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
        return new %TYPE%((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% asin()
    {
        return new %TYPE%((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% atan()
    {
        return new %TYPE%((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cbrt()
    {
        return new %TYPE%((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% ceil()
    {
        return new %TYPE%((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cos()
    {
        return new %TYPE%((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% cosh()
    {
        return new %TYPE%((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% exp()
    {
        return new %TYPE%((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% expm1()
    {
        return new %TYPE%((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% floor()
    {
        return new %TYPE%((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log()
    {
        return new %TYPE%((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log10()
    {
        return new %TYPE%((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% log1p()
    {
        return new %TYPE%((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% rint()
    {
        return new %TYPE%((float) Math.rint(getInUnit()), getUnit());
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
        return new %TYPE%((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% sinh()
    {
        return new %TYPE%((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% sqrt()
    {
        return new %TYPE%((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% tan()
    {
        return new %TYPE%((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% tanh()
    {
        return new %TYPE%((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% inv()
    {
        return new %TYPE%(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% toDegrees()
    {
        return new %TYPE%((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% toRadians()
    {
        return new %TYPE%((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% pow(final double x)
    {
        return new %TYPE%((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% multiplyBy(final float factor)
    {
        return new %TYPE%(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative %type%
     */
    public final %TYPE% multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final %TYPE% divideBy(final float divisor)
    {
        return new %TYPE%(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative %type%
     */
    public final %TYPE% divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final %TYPE% plus(final %TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new %TYPE%(getInUnit() + v.getInUnit(), getUnit()) : new %TYPE%(this.si
            + v.si, %TYPE%Unit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final %TYPE% minus(final %TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new %TYPE%(getInUnit() - v.getInUnit(), getUnit()) : new %TYPE%(this.si
            - v.si, %TYPE%Unit.SI);
    }

%FORMULAS%%TYPE%.Rel%
}

