package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalPotential FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;ElectricalPotentialUnit&gt; value = new FloatScalar.Rel&lt;ElectricalPotentialUnit&gt;(100.0,
 * ElectricalPotentialUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalPotential value = new FloatElectricalPotential(100.0, ElectricalPotentialUnit.SI);</i><br>
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
public class FloatElectricalPotential extends FloatScalar.Rel<ElectricalPotentialUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatElectricalPotential scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalPotential(final float value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalPotential scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalPotential(final FloatScalar.Rel<ElectricalPotentialUnit> value)
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
    public static FloatElectricalPotential interpolate(final FloatElectricalPotential zero,
        final FloatElectricalPotential one, final float ratio)
    {
        return new FloatElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalPotential interpolate(final FloatElectricalPotential zero,
        final FloatElectricalPotential one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential abs()
    {
        return new FloatElectricalPotential(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential acos()
    {
        return new FloatElectricalPotential((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential asin()
    {
        return new FloatElectricalPotential((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential atan()
    {
        return new FloatElectricalPotential((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential cbrt()
    {
        return new FloatElectricalPotential((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential ceil()
    {
        return new FloatElectricalPotential((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential cos()
    {
        return new FloatElectricalPotential((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential cosh()
    {
        return new FloatElectricalPotential((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential exp()
    {
        return new FloatElectricalPotential((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential expm1()
    {
        return new FloatElectricalPotential((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential floor()
    {
        return new FloatElectricalPotential((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential log()
    {
        return new FloatElectricalPotential((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential log10()
    {
        return new FloatElectricalPotential((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential log1p()
    {
        return new FloatElectricalPotential((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential rint()
    {
        return new FloatElectricalPotential((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential round()
    {
        return new FloatElectricalPotential(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential signum()
    {
        return new FloatElectricalPotential(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential sin()
    {
        return new FloatElectricalPotential((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential sinh()
    {
        return new FloatElectricalPotential((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential sqrt()
    {
        return new FloatElectricalPotential((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential tan()
    {
        return new FloatElectricalPotential((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential tanh()
    {
        return new FloatElectricalPotential((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential inv()
    {
        return new FloatElectricalPotential(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential toDegrees()
    {
        return new FloatElectricalPotential((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential toRadians()
    {
        return new FloatElectricalPotential((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential pow(final double x)
    {
        return new FloatElectricalPotential((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential multiplyBy(final float factor)
    {
        return new FloatElectricalPotential(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative electricalpotential
     */
    public final FloatElectricalPotential multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential divideBy(final float divisor)
    {
        return new FloatElectricalPotential(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative electricalpotential
     */
    public final FloatElectricalPotential divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatElectricalPotential plus(final FloatElectricalPotential v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalPotential(getInUnit() + v.getInUnit(), getUnit())
            : new FloatElectricalPotential(this.si + v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatElectricalPotential minus(final FloatElectricalPotential v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalPotential(getInUnit() - v.getInUnit(), getUnit())
            : new FloatElectricalPotential(this.si - v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalPotential, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalPotential and FloatElectricalPotential
     */
    public final FloatDimensionless.Rel divideBy(final FloatElectricalPotential v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalPotential and FloatElectricalCurrent, which results in a FloatPower
     * scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatPower scalar as a multiplication of FloatElectricalPotential and FloatElectricalCurrent
     */
    public final FloatPower multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalCurrent, which results in a
     * FloatElectricalResistance scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatElectricalResistance scalar as a division of FloatElectricalPotential and FloatElectricalCurrent
     */
    public final FloatElectricalResistance divideBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalResistance, which results in a
     * FloatElectricalCurrent scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatElectricalCurrent scalar as a division of FloatElectricalPotential and FloatElectricalResistance
     */
    public final FloatElectricalCurrent divideBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
