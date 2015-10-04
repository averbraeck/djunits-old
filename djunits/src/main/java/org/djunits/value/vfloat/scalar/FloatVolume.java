package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Volume FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;VolumeUnit&gt; value = new FloatScalar.Rel&lt;VolumeUnit&gt;(100.0, VolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatVolume value = new FloatVolume(100.0, VolumeUnit.SI);</i><br>
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
public class FloatVolume extends FloatScalar.Rel<VolumeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatVolume(final float value, final VolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatVolume(final double value, final VolumeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatVolume(final FloatScalar.Rel<VolumeUnit> value)
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
    public static FloatVolume interpolate(final FloatVolume zero, final FloatVolume one, final float ratio)
    {
        return new FloatVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatVolume interpolate(final FloatVolume zero, final FloatVolume one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume abs()
    {
        return new FloatVolume(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume acos()
    {
        return new FloatVolume((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume asin()
    {
        return new FloatVolume((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume atan()
    {
        return new FloatVolume((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume cbrt()
    {
        return new FloatVolume((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume ceil()
    {
        return new FloatVolume((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume cos()
    {
        return new FloatVolume((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume cosh()
    {
        return new FloatVolume((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume exp()
    {
        return new FloatVolume((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume expm1()
    {
        return new FloatVolume((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume floor()
    {
        return new FloatVolume((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume log()
    {
        return new FloatVolume((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume log10()
    {
        return new FloatVolume((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume log1p()
    {
        return new FloatVolume((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume rint()
    {
        return new FloatVolume((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume round()
    {
        return new FloatVolume(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume signum()
    {
        return new FloatVolume(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume sin()
    {
        return new FloatVolume((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume sinh()
    {
        return new FloatVolume((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume sqrt()
    {
        return new FloatVolume((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume tan()
    {
        return new FloatVolume((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume tanh()
    {
        return new FloatVolume((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume inv()
    {
        return new FloatVolume(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume toDegrees()
    {
        return new FloatVolume((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume toRadians()
    {
        return new FloatVolume((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume pow(final double x)
    {
        return new FloatVolume((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume multiplyBy(final float factor)
    {
        return new FloatVolume(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative volume
     */
    public final FloatVolume multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume divideBy(final float divisor)
    {
        return new FloatVolume(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative volume
     */
    public final FloatVolume divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatVolume plus(final FloatVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatVolume(getInUnit() + v.getInUnit(), getUnit()) : new FloatVolume(this.si
            + v.si, VolumeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatVolume minus(final FloatVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatVolume(getInUnit() - v.getInUnit(), getUnit()) : new FloatVolume(this.si
            - v.si, VolumeUnit.SI);
    }
        /**
         * Calculate the division of FloatVolume and FloatVolume, which results in a FloatDimensionless scalar.
         * @param v FloatVolume scalar
         * @return FloatDimensionless scalar as a division of FloatVolume and FloatVolume
         */
        public final FloatDimensionless.Rel divideBy(final FloatVolume v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatVolume and FloatDensity, which results in a FloatMass scalar.
         * @param v FloatVolume scalar
         * @return FloatMass scalar as a multiplication of FloatVolume and FloatDensity
         */
        public final FloatMass multiplyBy(final FloatDensity v)
        {
            return new FloatMass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatVolume and FloatPressure, which results in a FloatEnergy scalar.
         * @param v FloatVolume scalar
         * @return FloatEnergy scalar as a multiplication of FloatVolume and FloatPressure
         */
        public final FloatEnergy multiplyBy(final FloatPressure v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of FloatVolume and FloatLength, which results in a FloatArea scalar.
         * @param v FloatVolume scalar
         * @return FloatArea scalar as a division of FloatVolume and FloatLength
         */
        public final FloatArea divideBy(final FloatLength.Rel v)
        {
            return new FloatArea(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of FloatVolume and FloatArea, which results in a FloatLength scalar.
         * @param v FloatVolume scalar
         * @return FloatLength scalar as a division of FloatVolume and FloatArea
         */
        public final FloatLength.Rel divideBy(final FloatArea v)
        {
            return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatVolume and FloatLinearDensity, which results in a FloatArea scalar.
         * @param v FloatVolume scalar
         * @return FloatArea scalar as a multiplication of FloatVolume and FloatLinearDensity
         */
        public final FloatArea multiplyBy(final FloatLinearDensity v)
        {
            return new FloatArea(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of FloatVolume and FloatTime, which results in a FloatFlowVolume scalar.
         * @param v FloatVolume scalar
         * @return FloatFlowVolume scalar as a division of FloatVolume and FloatTime
         */
        public final FloatFlowVolume divideBy(final FloatTime.Rel v)
        {
            return new FloatFlowVolume(this.si / v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the division of FloatVolume and FloatFlowVolume, which results in a FloatTime scalar.
         * @param v FloatVolume scalar
         * @return FloatTime scalar as a division of FloatVolume and FloatFlowVolume
         */
        public final FloatTime.Rel divideBy(final FloatFlowVolume v)
        {
            return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatVolume and FloatMoneyPerVolume, which results in a FloatMoney scalar.
         * @param v FloatVolume scalar
         * @return FloatMoney scalar as a multiplication of FloatVolume and FloatMoneyPerVolume
         */
        public final FloatMoney multiplyBy(final FloatMoneyPerVolume v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }


}
