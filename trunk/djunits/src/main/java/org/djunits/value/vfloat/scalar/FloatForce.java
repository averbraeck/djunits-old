package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Force FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;ForceUnit&gt; value = new FloatScalar.Rel&lt;ForceUnit&gt;(100.0, ForceUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatForce value = new FloatForce(100.0, ForceUnit.SI);</i><br>
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
public class FloatForce extends FloatScalar.Rel<ForceUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatForce scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatForce(final float value, final ForceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatForce scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatForce(final double value, final ForceUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatForce scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatForce(final FloatScalar.Rel<ForceUnit> value)
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
    public static FloatForce interpolate(final FloatForce zero, final FloatForce one, final float ratio)
    {
        return new FloatForce(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatForce interpolate(final FloatForce zero, final FloatForce one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce abs()
    {
        return new FloatForce(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce acos()
    {
        return new FloatForce((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce asin()
    {
        return new FloatForce((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce atan()
    {
        return new FloatForce((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce cbrt()
    {
        return new FloatForce((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce ceil()
    {
        return new FloatForce((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce cos()
    {
        return new FloatForce((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce cosh()
    {
        return new FloatForce((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce exp()
    {
        return new FloatForce((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce expm1()
    {
        return new FloatForce((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce floor()
    {
        return new FloatForce((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce log()
    {
        return new FloatForce((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce log10()
    {
        return new FloatForce((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce log1p()
    {
        return new FloatForce((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce rint()
    {
        return new FloatForce((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce round()
    {
        return new FloatForce(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce signum()
    {
        return new FloatForce(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce sin()
    {
        return new FloatForce((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce sinh()
    {
        return new FloatForce((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce sqrt()
    {
        return new FloatForce((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce tan()
    {
        return new FloatForce((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce tanh()
    {
        return new FloatForce((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce inv()
    {
        return new FloatForce(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce toDegrees()
    {
        return new FloatForce((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce toRadians()
    {
        return new FloatForce((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce pow(final double x)
    {
        return new FloatForce((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce multiplyBy(final float factor)
    {
        return new FloatForce(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative force
     */
    public final FloatForce multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce divideBy(final float divisor)
    {
        return new FloatForce(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative force
     */
    public final FloatForce divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatForce plus(final FloatForce v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatForce(getInUnit() + v.getInUnit(), getUnit()) : new FloatForce(this.si
            + v.si, ForceUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatForce minus(final FloatForce v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatForce(getInUnit() - v.getInUnit(), getUnit()) : new FloatForce(this.si
            - v.si, ForceUnit.SI);
    }
        /**
         * Calculate the division of FloatForce and FloatForce, which results in a FloatDimensionless scalar.
         * @param v FloatForce scalar
         * @return FloatDimensionless scalar as a division of FloatForce and FloatForce
         */
        public final FloatDimensionless.Rel divideBy(final FloatForce v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatForce and FloatLength, which results in a FloatEnergy scalar.
         * @param v FloatForce scalar
         * @return FloatEnergy scalar as a multiplication of FloatForce and FloatLength
         */
        public final FloatEnergy multiplyBy(final FloatLength.Rel v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatLinearDensity, which results in a FloatEnergy scalar.
         * @param v FloatForce scalar
         * @return FloatEnergy scalar as a division of FloatForce and FloatLinearDensity
         */
        public final FloatEnergy divideBy(final FloatLinearDensity v)
        {
            return new FloatEnergy(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatEnergy, which results in a FloatLinearDensity scalar.
         * @param v FloatForce scalar
         * @return FloatLinearDensity scalar as a division of FloatForce and FloatEnergy
         */
        public final FloatLinearDensity divideBy(final FloatEnergy v)
        {
            return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatForce and FloatSpeed, which results in a FloatPower scalar.
         * @param v FloatForce scalar
         * @return FloatPower scalar as a multiplication of FloatForce and FloatSpeed
         */
        public final FloatPower multiplyBy(final FloatSpeed v)
        {
            return new FloatPower(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatMass, which results in a FloatAcceleration scalar.
         * @param v FloatForce scalar
         * @return FloatAcceleration scalar as a division of FloatForce and FloatMass
         */
        public final FloatAcceleration divideBy(final FloatMass v)
        {
            return new FloatAcceleration(this.si / v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatAcceleration, which results in a FloatMass scalar.
         * @param v FloatForce scalar
         * @return FloatMass scalar as a division of FloatForce and FloatAcceleration
         */
        public final FloatMass divideBy(final FloatAcceleration v)
        {
            return new FloatMass(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatArea, which results in a FloatPressure scalar.
         * @param v FloatForce scalar
         * @return FloatPressure scalar as a division of FloatForce and FloatArea
         */
        public final FloatPressure divideBy(final FloatArea v)
        {
            return new FloatPressure(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the division of FloatForce and FloatPressure, which results in a FloatArea scalar.
         * @param v FloatForce scalar
         * @return FloatArea scalar as a division of FloatForce and FloatPressure
         */
        public final FloatArea divideBy(final FloatPressure v)
        {
            return new FloatArea(this.si / v.si, AreaUnit.SI);
        }


}
