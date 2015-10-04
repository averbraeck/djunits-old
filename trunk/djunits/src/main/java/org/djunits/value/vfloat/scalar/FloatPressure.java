package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Pressure FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;PressureUnit&gt; value = new FloatScalar.Rel&lt;PressureUnit&gt;(100.0, PressureUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatPressure value = new FloatPressure(100.0, PressureUnit.SI);</i><br>
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
public class FloatPressure extends FloatScalar.Rel<PressureUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatPressure scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPressure(final float value, final PressureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPressure scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatPressure(final double value, final PressureUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatPressure scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPressure(final FloatScalar.Rel<PressureUnit> value)
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
    public static FloatPressure interpolate(final FloatPressure zero, final FloatPressure one, final float ratio)
    {
        return new FloatPressure(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPressure interpolate(final FloatPressure zero, final FloatPressure one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure abs()
    {
        return new FloatPressure(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure acos()
    {
        return new FloatPressure((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure asin()
    {
        return new FloatPressure((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure atan()
    {
        return new FloatPressure((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure cbrt()
    {
        return new FloatPressure((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure ceil()
    {
        return new FloatPressure((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure cos()
    {
        return new FloatPressure((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure cosh()
    {
        return new FloatPressure((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure exp()
    {
        return new FloatPressure((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure expm1()
    {
        return new FloatPressure((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure floor()
    {
        return new FloatPressure((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure log()
    {
        return new FloatPressure((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure log10()
    {
        return new FloatPressure((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure log1p()
    {
        return new FloatPressure((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure rint()
    {
        return new FloatPressure((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure round()
    {
        return new FloatPressure(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure signum()
    {
        return new FloatPressure(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure sin()
    {
        return new FloatPressure((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure sinh()
    {
        return new FloatPressure((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure sqrt()
    {
        return new FloatPressure((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure tan()
    {
        return new FloatPressure((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure tanh()
    {
        return new FloatPressure((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure inv()
    {
        return new FloatPressure(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure toDegrees()
    {
        return new FloatPressure((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure toRadians()
    {
        return new FloatPressure((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure pow(final double x)
    {
        return new FloatPressure((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure multiplyBy(final float factor)
    {
        return new FloatPressure(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative pressure
     */
    public final FloatPressure multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure divideBy(final float divisor)
    {
        return new FloatPressure(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative pressure
     */
    public final FloatPressure divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatPressure plus(final FloatPressure v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatPressure(getInUnit() + v.getInUnit(), getUnit()) : new FloatPressure(this.si
            + v.si, PressureUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatPressure minus(final FloatPressure v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatPressure(getInUnit() - v.getInUnit(), getUnit()) : new FloatPressure(this.si
            - v.si, PressureUnit.SI);
    }
        /**
         * Calculate the division of FloatPressure and FloatPressure, which results in a FloatDimensionless scalar.
         * @param v FloatPressure scalar
         * @return FloatDimensionless scalar as a division of FloatPressure and FloatPressure
         */
        public final FloatDimensionless.Rel divideBy(final FloatPressure v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatPressure and FloatArea, which results in a FloatForce scalar.
         * @param v FloatPressure scalar
         * @return FloatForce scalar as a multiplication of FloatPressure and FloatArea
         */
        public final FloatForce multiplyBy(final FloatArea v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatPressure and FloatVolume, which results in a FloatEnergy scalar.
         * @param v FloatPressure scalar
         * @return FloatEnergy scalar as a multiplication of FloatPressure and FloatVolume
         */
        public final FloatEnergy multiplyBy(final FloatVolume v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }


}
