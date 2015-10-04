package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the FlowVolume FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;FlowVolumeUnit&gt; value = new FloatScalar.Rel&lt;FlowVolumeUnit&gt;(100.0, FlowVolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatFlowVolume value = new FloatFlowVolume(100.0, FlowVolumeUnit.SI);</i><br>
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
public class FloatFlowVolume extends FloatScalar.Rel<FlowVolumeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatFlowVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFlowVolume(final float value, final FlowVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatFlowVolume(final double value, final FlowVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatFlowVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowVolume(final FloatScalar.Rel<FlowVolumeUnit> value)
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
    public static FloatFlowVolume interpolate(final FloatFlowVolume zero, final FloatFlowVolume one, final float ratio)
    {
        return new FloatFlowVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowVolume interpolate(final FloatFlowVolume zero, final FloatFlowVolume one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume abs()
    {
        return new FloatFlowVolume(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume acos()
    {
        return new FloatFlowVolume((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume asin()
    {
        return new FloatFlowVolume((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume atan()
    {
        return new FloatFlowVolume((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume cbrt()
    {
        return new FloatFlowVolume((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume ceil()
    {
        return new FloatFlowVolume((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume cos()
    {
        return new FloatFlowVolume((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume cosh()
    {
        return new FloatFlowVolume((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume exp()
    {
        return new FloatFlowVolume((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume expm1()
    {
        return new FloatFlowVolume((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume floor()
    {
        return new FloatFlowVolume((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume log()
    {
        return new FloatFlowVolume((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume log10()
    {
        return new FloatFlowVolume((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume log1p()
    {
        return new FloatFlowVolume((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume rint()
    {
        return new FloatFlowVolume((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume round()
    {
        return new FloatFlowVolume(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume signum()
    {
        return new FloatFlowVolume(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume sin()
    {
        return new FloatFlowVolume((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume sinh()
    {
        return new FloatFlowVolume((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume sqrt()
    {
        return new FloatFlowVolume((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume tan()
    {
        return new FloatFlowVolume((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume tanh()
    {
        return new FloatFlowVolume((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume inv()
    {
        return new FloatFlowVolume(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume toDegrees()
    {
        return new FloatFlowVolume((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume toRadians()
    {
        return new FloatFlowVolume((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume pow(final double x)
    {
        return new FloatFlowVolume((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume multiplyBy(final float factor)
    {
        return new FloatFlowVolume(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative flowvolume
     */
    public final FloatFlowVolume multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolume divideBy(final float divisor)
    {
        return new FloatFlowVolume(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative flowvolume
     */
    public final FloatFlowVolume divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatFlowVolume plus(final FloatFlowVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFlowVolume(getInUnit() + v.getInUnit(), getUnit()) : new FloatFlowVolume(this.si
            + v.si, FlowVolumeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatFlowVolume minus(final FloatFlowVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFlowVolume(getInUnit() - v.getInUnit(), getUnit()) : new FloatFlowVolume(this.si
            - v.si, FlowVolumeUnit.SI);
    }
        /**
         * Calculate the division of FloatFlowVolume and FloatFlowVolume, which results in a FloatDimensionless scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatDimensionless scalar as a division of FloatFlowVolume and FloatFlowVolume
         */
        public final FloatDimensionless.Rel divideBy(final FloatFlowVolume v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFlowVolume and FloatTime, which results in a FloatVolume scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatVolume scalar as a multiplication of FloatFlowVolume and FloatTime
         */
        public final FloatVolume multiplyBy(final FloatTime.Rel v)
        {
            return new FloatVolume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowVolume and FloatFrequency, which results in a FloatVolume scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatVolume scalar as a division of FloatFlowVolume and FloatFrequency
         */
        public final FloatVolume divideBy(final FloatFrequency v)
        {
            return new FloatVolume(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowVolume and FloatVolume, which results in a FloatFrequency scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatFrequency scalar as a division of FloatFlowVolume and FloatVolume
         */
        public final FloatFrequency divideBy(final FloatVolume v)
        {
            return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowVolume and FloatArea, which results in a FloatSpeed scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatSpeed scalar as a division of FloatFlowVolume and FloatArea
         */
        public final FloatSpeed divideBy(final FloatArea v)
        {
            return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowVolume and FloatSpeed, which results in a FloatArea scalar.
         * @param v FloatFlowVolume scalar
         * @return FloatArea scalar as a division of FloatFlowVolume and FloatSpeed
         */
        public final FloatArea divideBy(final FloatSpeed v)
        {
            return new FloatArea(this.si / v.si, AreaUnit.SI);
        }


}
