package org.djunits.value.vfloat.scalar;

import org.djunits.value.Relative;
import org.djunits.unit.*;

/**
 * Easy access methods for the %TYPE% FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;%TYPE%Unit&gt; value = new FloatScalar.Rel&lt;%TYPE%Unit&gt;(100.0, %TYPE%Unit.SI);</i><br>
 * we can now write <br>
 * <i>Float%TYPE% value = new Float%TYPE%(100.0, %TYPE%Unit.SI);</i><br>
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
public class Float%TYPE% extends FloatScalar.Rel<%TYPE%Unit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Float%TYPE% scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Float%TYPE%(final float value, final %TYPE%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%TYPE% scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public Float%TYPE%(final double value, final %TYPE%Unit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct Float%TYPE% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%TYPE%(final FloatScalar.Rel<%TYPE%Unit> value)
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
    public static Float%TYPE% interpolate(final Float%TYPE% zero, final Float%TYPE% one, final float ratio)
    {
        return new Float%TYPE%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Float%TYPE% interpolate(final Float%TYPE%.Rel zero, final Float%TYPE%.Rel one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% abs()
    {
        return new Float%TYPE%(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% acos()
    {
        return new Float%TYPE%((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% asin()
    {
        return new Float%TYPE%((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% atan()
    {
        return new Float%TYPE%((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% cbrt()
    {
        return new Float%TYPE%((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% ceil()
    {
        return new Float%TYPE%((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% cos()
    {
        return new Float%TYPE%((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% cosh()
    {
        return new Float%TYPE%((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% exp()
    {
        return new Float%TYPE%((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% expm1()
    {
        return new Float%TYPE%((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% floor()
    {
        return new Float%TYPE%((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% log()
    {
        return new Float%TYPE%((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% log10()
    {
        return new Float%TYPE%((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% log1p()
    {
        return new Float%TYPE%((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% rint()
    {
        return new Float%TYPE%((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% round()
    {
        return new Float%TYPE%(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% signum()
    {
        return new Float%TYPE%(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% sin()
    {
        return new Float%TYPE%((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% sinh()
    {
        return new Float%TYPE%((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% sqrt()
    {
        return new Float%TYPE%((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% tan()
    {
        return new Float%TYPE%((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% tanh()
    {
        return new Float%TYPE%((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% inv()
    {
        return new Float%TYPE%(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% toDegrees()
    {
        return new Float%TYPE%((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% toRadians()
    {
        return new Float%TYPE%((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% pow(final double x)
    {
        return new Float%TYPE%((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% multiplyBy(final float factor)
    {
        return new Float%TYPE%(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative %type%
     */
    public final Float%TYPE% multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TYPE% divideBy(final float divisor)
    {
        return new Float%TYPE%(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative %type%
     */
    public final Float%TYPE% divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Float%TYPE% plus(final Float%TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new Float%TYPE%(getInUnit() + v.getInUnit(), getUnit()) : new Float%TYPE%(this.si
            + v.si, %TYPE%Unit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Float%TYPE% minus(final Float%TYPE% v)
    {
        return getUnit().equals(v.getUnit()) ? new Float%TYPE%(getInUnit() - v.getInUnit(), getUnit()) : new Float%TYPE%(this.si
            - v.si, %TYPE%Unit.SI);
    }

%FORMULAS%%TYPE%.Rel%
}

