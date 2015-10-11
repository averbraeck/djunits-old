package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalResistance FloatScalar, which is relative by definition. An example is Speed. Instead
 * of <br>
 * <i>FloatScalar.Rel&lt;ElectricalResistanceUnit&gt; value = new FloatScalar.Rel&lt;ElectricalResistanceUnit&gt;(100.0,
 * ElectricalResistanceUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalResistance value = new FloatElectricalResistance(100.0, ElectricalResistanceUnit.SI);</i><br>
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
public class FloatElectricalResistance extends FloatScalar.Rel<ElectricalResistanceUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalResistance(final float value, final ElectricalResistanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalResistance scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatElectricalResistance(final double value, final ElectricalResistanceUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalResistance(final FloatScalar.Rel<ElectricalResistanceUnit> value)
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
    public static FloatElectricalResistance interpolate(final FloatElectricalResistance zero,
        final FloatElectricalResistance one, final float ratio)
    {
        return new FloatElectricalResistance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalResistance interpolate(final FloatElectricalResistance zero,
        final FloatElectricalResistance one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance abs()
    {
        return new FloatElectricalResistance(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance acos()
    {
        return new FloatElectricalResistance((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance asin()
    {
        return new FloatElectricalResistance((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance atan()
    {
        return new FloatElectricalResistance((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance cbrt()
    {
        return new FloatElectricalResistance((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance ceil()
    {
        return new FloatElectricalResistance((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance cos()
    {
        return new FloatElectricalResistance((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance cosh()
    {
        return new FloatElectricalResistance((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance exp()
    {
        return new FloatElectricalResistance((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance expm1()
    {
        return new FloatElectricalResistance((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance floor()
    {
        return new FloatElectricalResistance((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance log()
    {
        return new FloatElectricalResistance((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance log10()
    {
        return new FloatElectricalResistance((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance log1p()
    {
        return new FloatElectricalResistance((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance rint()
    {
        return new FloatElectricalResistance((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance round()
    {
        return new FloatElectricalResistance(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance signum()
    {
        return new FloatElectricalResistance(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance sin()
    {
        return new FloatElectricalResistance((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance sinh()
    {
        return new FloatElectricalResistance((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance sqrt()
    {
        return new FloatElectricalResistance((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance tan()
    {
        return new FloatElectricalResistance((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance tanh()
    {
        return new FloatElectricalResistance((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance inv()
    {
        return new FloatElectricalResistance(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance toDegrees()
    {
        return new FloatElectricalResistance((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance toRadians()
    {
        return new FloatElectricalResistance((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance pow(final double x)
    {
        return new FloatElectricalResistance((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance multiplyBy(final float factor)
    {
        return new FloatElectricalResistance(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative electricalresistance
     */
    public final FloatElectricalResistance multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance divideBy(final float divisor)
    {
        return new FloatElectricalResistance(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative electricalresistance
     */
    public final FloatElectricalResistance divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatElectricalResistance plus(final FloatElectricalResistance v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalResistance(getInUnit() + v.getInUnit(), getUnit())
            : new FloatElectricalResistance(this.si + v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatElectricalResistance minus(final FloatElectricalResistance v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatElectricalResistance(getInUnit() - v.getInUnit(), getUnit())
            : new FloatElectricalResistance(this.si - v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalResistance and FloatElectricalResistance, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalResistance and FloatElectricalResistance
     */
    public final FloatDimensionless.Rel divideBy(final FloatElectricalResistance v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalResistance and FloatElectricalCurrent, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatElectricalResistance and FloatElectricalCurrent
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
