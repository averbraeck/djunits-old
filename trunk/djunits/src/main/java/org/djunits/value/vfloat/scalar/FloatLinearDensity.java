package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the LinearDensity FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;LinearDensityUnit&gt; value = new FloatScalar.Rel&lt;LinearDensityUnit&gt;(100.0, LinearDensityUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatLinearDensity value = new FloatLinearDensity(100.0, LinearDensityUnit.SI);</i><br>
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
public class FloatLinearDensity extends FloatScalar.Rel<LinearDensityUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatLinearDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatLinearDensity(final float value, final LinearDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatLinearDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatLinearDensity(final double value, final LinearDensityUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatLinearDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatLinearDensity(final FloatScalar.Rel<LinearDensityUnit> value)
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
    public static FloatLinearDensity interpolate(final FloatLinearDensity zero, final FloatLinearDensity one, final float ratio)
    {
        return new FloatLinearDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatLinearDensity interpolate(final FloatLinearDensity zero, final FloatLinearDensity one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity abs()
    {
        return new FloatLinearDensity(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity acos()
    {
        return new FloatLinearDensity((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity asin()
    {
        return new FloatLinearDensity((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity atan()
    {
        return new FloatLinearDensity((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity cbrt()
    {
        return new FloatLinearDensity((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity ceil()
    {
        return new FloatLinearDensity((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity cos()
    {
        return new FloatLinearDensity((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity cosh()
    {
        return new FloatLinearDensity((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity exp()
    {
        return new FloatLinearDensity((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity expm1()
    {
        return new FloatLinearDensity((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity floor()
    {
        return new FloatLinearDensity((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity log()
    {
        return new FloatLinearDensity((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity log10()
    {
        return new FloatLinearDensity((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity log1p()
    {
        return new FloatLinearDensity((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity rint()
    {
        return new FloatLinearDensity((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity round()
    {
        return new FloatLinearDensity(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity signum()
    {
        return new FloatLinearDensity(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity sin()
    {
        return new FloatLinearDensity((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity sinh()
    {
        return new FloatLinearDensity((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity sqrt()
    {
        return new FloatLinearDensity((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity tan()
    {
        return new FloatLinearDensity((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity tanh()
    {
        return new FloatLinearDensity((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity inv()
    {
        return new FloatLinearDensity(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity toDegrees()
    {
        return new FloatLinearDensity((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity toRadians()
    {
        return new FloatLinearDensity((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity pow(final double x)
    {
        return new FloatLinearDensity((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity multiplyBy(final float factor)
    {
        return new FloatLinearDensity(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative lineardensity
     */
    public final FloatLinearDensity multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity divideBy(final float divisor)
    {
        return new FloatLinearDensity(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative lineardensity
     */
    public final FloatLinearDensity divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatLinearDensity plus(final FloatLinearDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatLinearDensity(getInUnit() + v.getInUnit(), getUnit()) : new FloatLinearDensity(this.si
            + v.si, LinearDensityUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatLinearDensity minus(final FloatLinearDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatLinearDensity(getInUnit() - v.getInUnit(), getUnit()) : new FloatLinearDensity(this.si
            - v.si, LinearDensityUnit.SI);
    }
        /**
         * Calculate the division of FloatLinearDensity and FloatLinearDensity, which results in a FloatDimensionless scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatDimensionless scalar as a division of FloatLinearDensity and FloatLinearDensity
         */
        public final FloatDimensionless.Rel divideBy(final FloatLinearDensity v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatArea, which results in a FloatLength scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatLength scalar as a multiplication of FloatLinearDensity and FloatArea
         */
        public final FloatLength.Rel multiplyBy(final FloatArea v)
        {
            return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatEnergy, which results in a FloatForce scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatForce scalar as a multiplication of FloatLinearDensity and FloatEnergy
         */
        public final FloatForce multiplyBy(final FloatEnergy v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatSpeed, which results in a FloatFrequency scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatFrequency scalar as a multiplication of FloatLinearDensity and FloatSpeed
         */
        public final FloatFrequency multiplyBy(final FloatSpeed v)
        {
            return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatMoney, which results in a FloatMoneyPerLength scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatMoneyPerLength scalar as a multiplication of FloatLinearDensity and FloatMoney
         */
        public final FloatMoneyPerLength multiplyBy(final FloatMoney v)
        {
            return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
        }


}
