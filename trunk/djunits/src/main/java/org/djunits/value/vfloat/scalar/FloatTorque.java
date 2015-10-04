package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Torque FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;TorqueUnit&gt; value = new FloatScalar.Rel&lt;TorqueUnit&gt;(100.0, TorqueUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatTorque value = new FloatTorque(100.0, TorqueUnit.SI);</i><br>
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
public class FloatTorque extends FloatScalar.Rel<TorqueUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatTorque scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatTorque(final float value, final TorqueUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatTorque scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatTorque(final double value, final TorqueUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatTorque scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatTorque(final FloatScalar.Rel<TorqueUnit> value)
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
    public static FloatTorque interpolate(final FloatTorque zero, final FloatTorque one, final float ratio)
    {
        return new FloatTorque(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatTorque interpolate(final FloatTorque zero, final FloatTorque one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque abs()
    {
        return new FloatTorque(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque acos()
    {
        return new FloatTorque((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque asin()
    {
        return new FloatTorque((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque atan()
    {
        return new FloatTorque((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque cbrt()
    {
        return new FloatTorque((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque ceil()
    {
        return new FloatTorque((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque cos()
    {
        return new FloatTorque((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque cosh()
    {
        return new FloatTorque((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque exp()
    {
        return new FloatTorque((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque expm1()
    {
        return new FloatTorque((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque floor()
    {
        return new FloatTorque((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque log()
    {
        return new FloatTorque((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque log10()
    {
        return new FloatTorque((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque log1p()
    {
        return new FloatTorque((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque rint()
    {
        return new FloatTorque((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque round()
    {
        return new FloatTorque(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque signum()
    {
        return new FloatTorque(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque sin()
    {
        return new FloatTorque((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque sinh()
    {
        return new FloatTorque((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque sqrt()
    {
        return new FloatTorque((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque tan()
    {
        return new FloatTorque((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque tanh()
    {
        return new FloatTorque((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque inv()
    {
        return new FloatTorque(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque toDegrees()
    {
        return new FloatTorque((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque toRadians()
    {
        return new FloatTorque((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque pow(final double x)
    {
        return new FloatTorque((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque multiplyBy(final float factor)
    {
        return new FloatTorque(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative torque
     */
    public final FloatTorque multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque divideBy(final float divisor)
    {
        return new FloatTorque(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative torque
     */
    public final FloatTorque divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatTorque plus(final FloatTorque v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatTorque(getInUnit() + v.getInUnit(), getUnit()) : new FloatTorque(this.si
            + v.si, TorqueUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatTorque minus(final FloatTorque v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatTorque(getInUnit() - v.getInUnit(), getUnit()) : new FloatTorque(this.si
            - v.si, TorqueUnit.SI);
    }
        /**
         * Calculate the division of FloatTorque and FloatTorque, which results in a FloatDimensionless scalar.
         * @param v FloatTorque scalar
         * @return FloatDimensionless scalar as a division of FloatTorque and FloatTorque
         */
        public final FloatDimensionless.Rel divideBy(final FloatTorque v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatForce, which results in a FloatLength scalar.
         * @param v FloatTorque scalar
         * @return FloatLength scalar as a division of FloatTorque and FloatForce
         */
        public final FloatLength.Rel divideBy(final FloatForce v)
        {
            return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatLength, which results in a FloatForce scalar.
         * @param v FloatTorque scalar
         * @return FloatForce scalar as a division of FloatTorque and FloatLength
         */
        public final FloatForce divideBy(final FloatLength.Rel v)
        {
            return new FloatForce(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTorque and FloatLinearDensity, which results in a FloatForce scalar.
         * @param v FloatTorque scalar
         * @return FloatForce scalar as a multiplication of FloatTorque and FloatLinearDensity
         */
        public final FloatForce multiplyBy(final FloatLinearDensity v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatTime, which results in a FloatPower scalar.
         * @param v FloatTorque scalar
         * @return FloatPower scalar as a division of FloatTorque and FloatTime
         */
        public final FloatPower divideBy(final FloatTime.Rel v)
        {
            return new FloatPower(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatPower, which results in a FloatTime scalar.
         * @param v FloatTorque scalar
         * @return FloatTime scalar as a division of FloatTorque and FloatPower
         */
        public final FloatTime.Rel divideBy(final FloatPower v)
        {
            return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTorque and FloatFrequency, which results in a FloatPower scalar.
         * @param v FloatTorque scalar
         * @return FloatPower scalar as a multiplication of FloatTorque and FloatFrequency
         */
        public final FloatPower multiplyBy(final FloatFrequency v)
        {
            return new FloatPower(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatVolume, which results in a FloatPressure scalar.
         * @param v FloatTorque scalar
         * @return FloatPressure scalar as a division of FloatTorque and FloatVolume
         */
        public final FloatPressure divideBy(final FloatVolume v)
        {
            return new FloatPressure(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the division of FloatTorque and FloatPressure, which results in a FloatVolume scalar.
         * @param v FloatTorque scalar
         * @return FloatVolume scalar as a division of FloatTorque and FloatPressure
         */
        public final FloatVolume divideBy(final FloatPressure v)
        {
            return new FloatVolume(this.si / v.si, VolumeUnit.SI);
        }


}
