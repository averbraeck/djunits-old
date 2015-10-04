package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Density FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;DensityUnit&gt; value = new FloatScalar.Rel&lt;DensityUnit&gt;(100.0, DensityUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatDensity value = new FloatDensity(100.0, DensityUnit.SI);</i><br>
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
public class FloatDensity extends FloatScalar.Rel<DensityUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDensity(final float value, final DensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatDensity(final double value, final DensityUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDensity(final FloatScalar.Rel<DensityUnit> value)
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
    public static FloatDensity interpolate(final FloatDensity zero, final FloatDensity one, final float ratio)
    {
        return new FloatDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDensity interpolate(final FloatDensity zero, final FloatDensity one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity abs()
    {
        return new FloatDensity(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity acos()
    {
        return new FloatDensity((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity asin()
    {
        return new FloatDensity((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity atan()
    {
        return new FloatDensity((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity cbrt()
    {
        return new FloatDensity((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity ceil()
    {
        return new FloatDensity((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity cos()
    {
        return new FloatDensity((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity cosh()
    {
        return new FloatDensity((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity exp()
    {
        return new FloatDensity((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity expm1()
    {
        return new FloatDensity((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity floor()
    {
        return new FloatDensity((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity log()
    {
        return new FloatDensity((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity log10()
    {
        return new FloatDensity((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity log1p()
    {
        return new FloatDensity((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity rint()
    {
        return new FloatDensity((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity round()
    {
        return new FloatDensity(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity signum()
    {
        return new FloatDensity(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity sin()
    {
        return new FloatDensity((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity sinh()
    {
        return new FloatDensity((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity sqrt()
    {
        return new FloatDensity((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity tan()
    {
        return new FloatDensity((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity tanh()
    {
        return new FloatDensity((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity inv()
    {
        return new FloatDensity(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity toDegrees()
    {
        return new FloatDensity((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity toRadians()
    {
        return new FloatDensity((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity pow(final double x)
    {
        return new FloatDensity((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity multiplyBy(final float factor)
    {
        return new FloatDensity(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative density
     */
    public final FloatDensity multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity divideBy(final float divisor)
    {
        return new FloatDensity(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative density
     */
    public final FloatDensity divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatDensity plus(final FloatDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatDensity(getInUnit() + v.getInUnit(), getUnit()) : new FloatDensity(this.si
            + v.si, DensityUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatDensity minus(final FloatDensity v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatDensity(getInUnit() - v.getInUnit(), getUnit()) : new FloatDensity(this.si
            - v.si, DensityUnit.SI);
    }
        /**
         * Calculate the division of FloatDensity and FloatDensity, which results in a FloatDimensionless scalar.
         * @param v FloatDensity scalar
         * @return FloatDimensionless scalar as a division of FloatDensity and FloatDensity
         */
        public final FloatDimensionless.Rel divideBy(final FloatDensity v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDensity and FloatVolume, which results in a FloatMass scalar.
         * @param v FloatDensity scalar
         * @return FloatMass scalar as a multiplication of FloatDensity and FloatVolume
         */
        public final FloatMass multiplyBy(final FloatVolume v)
        {
            return new FloatMass(this.si * v.si, MassUnit.SI);
        }


}
