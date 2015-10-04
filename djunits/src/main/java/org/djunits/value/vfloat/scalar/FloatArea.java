package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Area FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AreaUnit&gt; value = new FloatScalar.Rel&lt;AreaUnit&gt;(100.0, AreaUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatArea value = new FloatArea(100.0, AreaUnit.SI);</i><br>
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
public class FloatArea extends FloatScalar.Rel<AreaUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatArea scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatArea(final float value, final AreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatArea scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatArea(final double value, final AreaUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatArea(final FloatScalar.Rel<AreaUnit> value)
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
    public static FloatArea interpolate(final FloatArea zero, final FloatArea one, final float ratio)
    {
        return new FloatArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatArea interpolate(final FloatArea zero, final FloatArea one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea abs()
    {
        return new FloatArea(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea acos()
    {
        return new FloatArea((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea asin()
    {
        return new FloatArea((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea atan()
    {
        return new FloatArea((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea cbrt()
    {
        return new FloatArea((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea ceil()
    {
        return new FloatArea((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea cos()
    {
        return new FloatArea((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea cosh()
    {
        return new FloatArea((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea exp()
    {
        return new FloatArea((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea expm1()
    {
        return new FloatArea((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea floor()
    {
        return new FloatArea((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea log()
    {
        return new FloatArea((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea log10()
    {
        return new FloatArea((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea log1p()
    {
        return new FloatArea((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea rint()
    {
        return new FloatArea((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea round()
    {
        return new FloatArea(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea signum()
    {
        return new FloatArea(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea sin()
    {
        return new FloatArea((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea sinh()
    {
        return new FloatArea((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea sqrt()
    {
        return new FloatArea((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea tan()
    {
        return new FloatArea((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea tanh()
    {
        return new FloatArea((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea inv()
    {
        return new FloatArea(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea toDegrees()
    {
        return new FloatArea((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea toRadians()
    {
        return new FloatArea((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea pow(final double x)
    {
        return new FloatArea((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea multiplyBy(final float factor)
    {
        return new FloatArea(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative area
     */
    public final FloatArea multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea divideBy(final float divisor)
    {
        return new FloatArea(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative area
     */
    public final FloatArea divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatArea plus(final FloatArea v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatArea(getInUnit() + v.getInUnit(), getUnit()) : new FloatArea(this.si
            + v.si, AreaUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatArea minus(final FloatArea v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatArea(getInUnit() - v.getInUnit(), getUnit()) : new FloatArea(this.si
            - v.si, AreaUnit.SI);
    }
        /**
         * Calculate the division of FloatArea and FloatArea, which results in a FloatDimensionless scalar.
         * @param v FloatArea scalar
         * @return FloatDimensionless scalar as a division of FloatArea and FloatArea
         */
        public final FloatDimensionless.Rel divideBy(final FloatArea v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatArea and FloatLength, which results in a FloatVolume scalar.
         * @param v FloatArea scalar
         * @return FloatVolume scalar as a multiplication of FloatArea and FloatLength
         */
        public final FloatVolume multiplyBy(final FloatLength.Rel v)
        {
            return new FloatVolume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FloatArea and FloatLinearDensity, which results in a FloatVolume scalar.
         * @param v FloatArea scalar
         * @return FloatVolume scalar as a division of FloatArea and FloatLinearDensity
         */
        public final FloatVolume divideBy(final FloatLinearDensity v)
        {
            return new FloatVolume(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FloatArea and FloatVolume, which results in a FloatLinearDensity scalar.
         * @param v FloatArea scalar
         * @return FloatLinearDensity scalar as a division of FloatArea and FloatVolume
         */
        public final FloatLinearDensity divideBy(final FloatVolume v)
        {
            return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the division of FloatArea and FloatLength, which results in a FloatLength scalar.
         * @param v FloatArea scalar
         * @return FloatLength scalar as a division of FloatArea and FloatLength
         */
        public final FloatLength.Rel divideBy(final FloatLength.Rel v)
        {
            return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatArea and FloatLinearDensity, which results in a FloatLength scalar.
         * @param v FloatArea scalar
         * @return FloatLength scalar as a multiplication of FloatArea and FloatLinearDensity
         */
        public final FloatLength.Rel multiplyBy(final FloatLinearDensity v)
        {
            return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatArea and FloatSpeed, which results in a FloatFlowVolume scalar.
         * @param v FloatArea scalar
         * @return FloatFlowVolume scalar as a multiplication of FloatArea and FloatSpeed
         */
        public final FloatFlowVolume multiplyBy(final FloatSpeed v)
        {
            return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatArea and FloatPressure, which results in a FloatForce scalar.
         * @param v FloatArea scalar
         * @return FloatForce scalar as a multiplication of FloatArea and FloatPressure
         */
        public final FloatForce multiplyBy(final FloatPressure v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatArea and FloatMoneyPerArea, which results in a FloatMoney scalar.
         * @param v FloatArea scalar
         * @return FloatMoney scalar as a multiplication of FloatArea and FloatMoneyPerArea
         */
        public final FloatMoney multiplyBy(final FloatMoneyPerArea v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }


}
