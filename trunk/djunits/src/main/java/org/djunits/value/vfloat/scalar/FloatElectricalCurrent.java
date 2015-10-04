package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalCurrent FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;ElectricalCurrentUnit&gt; value = new FloatScalar.Rel&lt;ElectricalCurrentUnit&gt;(100.0,
 * ElectricalCurrentUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalCurrent value = new FloatElectricalCurrent(100.0, ElectricalCurrentUnit.SI);</i><br>
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
public class FloatElectricalCurrent extends FloatScalar.Rel<ElectricalCurrentUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatElectricalCurrent scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalCurrent(final float value, final ElectricalCurrentUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCurrent scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatElectricalCurrent(final double value, final ElectricalCurrentUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatElectricalCurrent scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalCurrent(final FloatScalar.Rel<ElectricalCurrentUnit> value)
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
    public static FloatElectricalCurrent interpolate(final FloatElectricalCurrent zero,
        final FloatElectricalCurrent one, final float ratio)
    {
        return new FloatElectricalCurrent(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCurrent interpolate(final FloatElectricalCurrent zero,
        final FloatElectricalCurrent one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent abs()
    {
        return new FloatElectricalCurrent(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent acos()
    {
        return new FloatElectricalCurrent((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent asin()
    {
        return new FloatElectricalCurrent((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent atan()
    {
        return new FloatElectricalCurrent((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent cbrt()
    {
        return new FloatElectricalCurrent((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent ceil()
    {
        return new FloatElectricalCurrent((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent cos()
    {
        return new FloatElectricalCurrent((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent cosh()
    {
        return new FloatElectricalCurrent((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent exp()
    {
        return new FloatElectricalCurrent((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent expm1()
    {
        return new FloatElectricalCurrent((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent floor()
    {
        return new FloatElectricalCurrent((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent log()
    {
        return new FloatElectricalCurrent((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent log10()
    {
        return new FloatElectricalCurrent((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent log1p()
    {
        return new FloatElectricalCurrent((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent rint()
    {
        return new FloatElectricalCurrent((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent round()
    {
        return new FloatElectricalCurrent(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent signum()
    {
        return new FloatElectricalCurrent(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent sin()
    {
        return new FloatElectricalCurrent((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent sinh()
    {
        return new FloatElectricalCurrent((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent sqrt()
    {
        return new FloatElectricalCurrent((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent tan()
    {
        return new FloatElectricalCurrent((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent tanh()
    {
        return new FloatElectricalCurrent((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent inv()
    {
        return new FloatElectricalCurrent(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent toDegrees()
    {
        return new FloatElectricalCurrent((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent toRadians()
    {
        return new FloatElectricalCurrent((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent pow(final double x)
    {
        return new FloatElectricalCurrent((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent multiplyBy(final float factor)
    {
        return new FloatElectricalCurrent(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative electricalcurrent
     */
    public final FloatElectricalCurrent multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent divideBy(final float divisor)
    {
        return new FloatElectricalCurrent(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative electricalcurrent
     */
    public final FloatElectricalCurrent divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatElectricalCurrent plus(final FloatElectricalCurrent v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalCurrent(getInUnit() + v.getInUnit(), getUnit())
            : new FloatElectricalCurrent(this.si + v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatElectricalCurrent minus(final FloatElectricalCurrent v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalCurrent(getInUnit() - v.getInUnit(), getUnit())
            : new FloatElectricalCurrent(this.si - v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCurrent and FloatElectricalCurrent, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalCurrent scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalCurrent and FloatElectricalCurrent
     */
    public final FloatDimensionless.Rel divideBy(final FloatElectricalCurrent v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatElectricalPotential, which results in a FloatPower
     * scalar.
     * @param v FloatElectricalCurrent scalar
     * @return FloatPower scalar as a multiplication of FloatElectricalCurrent and FloatElectricalPotential
     */
    public final FloatPower multiplyBy(final FloatElectricalPotential v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatTime, which results in a FloatElectricalCharge scalar.
     * @param v FloatElectricalCurrent scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatElectricalCurrent and FloatTime
     */
    public final FloatElectricalCharge multiplyBy(final FloatTime.Rel v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatElectricalResistance, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatElectricalCurrent scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatElectricalCurrent and FloatElectricalResistance
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
