package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalCharge FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;ElectricalChargeUnit&gt; value = new FloatScalar.Rel&lt;ElectricalChargeUnit&gt;(100.0,
 * ElectricalChargeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalCharge value = new FloatElectricalCharge(100.0, ElectricalChargeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatElectricalCharge extends FloatScalar.Rel<ElectricalChargeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalCharge(final float value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCharge scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalCharge(final FloatScalar.Rel<ElectricalChargeUnit> value)
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
    public static FloatElectricalCharge interpolate(final FloatElectricalCharge zero, final FloatElectricalCharge one,
        final float ratio)
    {
        return new FloatElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCharge interpolate(final FloatElectricalCharge zero, final FloatElectricalCharge one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge abs()
    {
        return new FloatElectricalCharge(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge acos()
    {
        return new FloatElectricalCharge((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge asin()
    {
        return new FloatElectricalCharge((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge atan()
    {
        return new FloatElectricalCharge((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge cbrt()
    {
        return new FloatElectricalCharge((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge ceil()
    {
        return new FloatElectricalCharge((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge cos()
    {
        return new FloatElectricalCharge((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge cosh()
    {
        return new FloatElectricalCharge((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge exp()
    {
        return new FloatElectricalCharge((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge expm1()
    {
        return new FloatElectricalCharge((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge floor()
    {
        return new FloatElectricalCharge((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge log()
    {
        return new FloatElectricalCharge((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge log10()
    {
        return new FloatElectricalCharge((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge log1p()
    {
        return new FloatElectricalCharge((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge rint()
    {
        return new FloatElectricalCharge((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge round()
    {
        return new FloatElectricalCharge(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge signum()
    {
        return new FloatElectricalCharge(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge sin()
    {
        return new FloatElectricalCharge((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge sinh()
    {
        return new FloatElectricalCharge((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge sqrt()
    {
        return new FloatElectricalCharge((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge tan()
    {
        return new FloatElectricalCharge((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge tanh()
    {
        return new FloatElectricalCharge((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge inv()
    {
        return new FloatElectricalCharge(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge toDegrees()
    {
        return new FloatElectricalCharge((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge toRadians()
    {
        return new FloatElectricalCharge((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge pow(final double x)
    {
        return new FloatElectricalCharge((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge multiplyBy(final float factor)
    {
        return new FloatElectricalCharge(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative electricalcharge
     */
    public final FloatElectricalCharge multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge divideBy(final float divisor)
    {
        return new FloatElectricalCharge(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative electricalcharge
     */
    public final FloatElectricalCharge divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatElectricalCharge plus(final FloatElectricalCharge v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalCharge(getInUnit() + v.getInUnit(), getUnit())
            : new FloatElectricalCharge(this.si + v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatElectricalCharge minus(final FloatElectricalCharge v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalCharge(getInUnit() - v.getInUnit(), getUnit())
            : new FloatElectricalCharge(this.si - v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCharge, which results in a FloatDimensionless scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalCharge and FloatElectricalCharge
     */
    public final FloatDimensionless.Rel divideBy(final FloatElectricalCharge v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatTime, which results in a FloatElectricalCurrent scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatElectricalCurrent scalar as a division of FloatElectricalCharge and FloatTime
     */
    public final FloatElectricalCurrent divideBy(final FloatTime.Rel v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCurrent, which results in a FloatTime scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatTime scalar as a division of FloatElectricalCharge and FloatElectricalCurrent
     */
    public final FloatTime.Rel divideBy(final FloatElectricalCurrent v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

}