package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Acceleration FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class Acceleration extends FloatScalar.Rel<AccelerationUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Acceleration scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Acceleration(final float value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Acceleration scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public Acceleration(final double value, final AccelerationUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct Acceleration scalar.
     * @param value Scalar from which to construct this instance
     */
    public Acceleration(final FloatScalar.Rel<AccelerationUnit> value)
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
    public static Acceleration interpolate(final Acceleration zero, final Acceleration one, final float ratio)
    {
        return new Acceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Acceleration interpolate(final Acceleration zero, final Acceleration one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration abs()
    {
        return new Acceleration(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration acos()
    {
        return new Acceleration((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration asin()
    {
        return new Acceleration((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration atan()
    {
        return new Acceleration((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration cbrt()
    {
        return new Acceleration((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration ceil()
    {
        return new Acceleration((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration cos()
    {
        return new Acceleration((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration cosh()
    {
        return new Acceleration((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration exp()
    {
        return new Acceleration((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration expm1()
    {
        return new Acceleration((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration floor()
    {
        return new Acceleration((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration log()
    {
        return new Acceleration((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration log10()
    {
        return new Acceleration((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration log1p()
    {
        return new Acceleration((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration rint()
    {
        return new Acceleration((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration round()
    {
        return new Acceleration(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration signum()
    {
        return new Acceleration(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration sin()
    {
        return new Acceleration((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration sinh()
    {
        return new Acceleration((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration sqrt()
    {
        return new Acceleration((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration tan()
    {
        return new Acceleration((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration tanh()
    {
        return new Acceleration((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration inv()
    {
        return new Acceleration(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration toDegrees()
    {
        return new Acceleration((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration toRadians()
    {
        return new Acceleration((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration pow(final double x)
    {
        return new Acceleration((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration multiplyBy(final float factor)
    {
        return new Acceleration(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative acceleration
     */
    public final Acceleration multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration divideBy(final float divisor)
    {
        return new Acceleration(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative acceleration
     */
    public final Acceleration divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Acceleration plus(final Acceleration v)
    {
        return getUnit().equals(v.getUnit()) ? new Acceleration(getInUnit() + v.getInUnit(), getUnit())
            : new Acceleration(this.si + v.si, AccelerationUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Acceleration minus(final Acceleration v)
    {
        return getUnit().equals(v.getUnit()) ? new Acceleration(getInUnit() - v.getInUnit(), getUnit())
            : new Acceleration(this.si - v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Acceleration and Acceleration, which results in a Dimensionless scalar.
     * @param v Acceleration scalar
     * @return Dimensionless scalar as a division of Acceleration and Acceleration
     */
    public final Dimensionless.Rel divideBy(final Acceleration v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Acceleration and Mass, which results in a Force scalar.
     * @param v Acceleration scalar
     * @return Force scalar as a multiplication of Acceleration and Mass
     */
    public final Force multiplyBy(final Mass v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Acceleration and Time, which results in a Speed scalar.
     * @param v Acceleration scalar
     * @return Speed scalar as a multiplication of Acceleration and Time
     */
    public final Speed multiplyBy(final Time.Rel v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Acceleration and Frequency, which results in a Speed scalar.
     * @param v Acceleration scalar
     * @return Speed scalar as a division of Acceleration and Frequency
     */
    public final Speed divideBy(final Frequency v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Acceleration and Speed, which results in a Frequency scalar.
     * @param v Acceleration scalar
     * @return Frequency scalar as a division of Acceleration and Speed
     */
    public final Frequency divideBy(final Speed v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

}
