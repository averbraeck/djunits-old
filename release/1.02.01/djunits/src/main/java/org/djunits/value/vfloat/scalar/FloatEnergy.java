package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Energy FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;EnergyUnit&gt; value = new FloatScalar.Rel&lt;EnergyUnit&gt;(100.0, EnergyUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatEnergy value = new FloatEnergy(100.0, EnergyUnit.SI);</i><br>
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
public class FloatEnergy extends FloatScalar.Rel<EnergyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatEnergy scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatEnergy(final float value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatEnergy scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatEnergy(final double value, final EnergyUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatEnergy(final FloatScalar.Rel<EnergyUnit> value)
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
    public static FloatEnergy interpolate(final FloatEnergy zero, final FloatEnergy one, final float ratio)
    {
        return new FloatEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatEnergy interpolate(final FloatEnergy zero, final FloatEnergy one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy abs()
    {
        return new FloatEnergy(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy acos()
    {
        return new FloatEnergy((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy asin()
    {
        return new FloatEnergy((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy atan()
    {
        return new FloatEnergy((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy cbrt()
    {
        return new FloatEnergy((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy ceil()
    {
        return new FloatEnergy((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy cos()
    {
        return new FloatEnergy((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy cosh()
    {
        return new FloatEnergy((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy exp()
    {
        return new FloatEnergy((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy expm1()
    {
        return new FloatEnergy((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy floor()
    {
        return new FloatEnergy((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy log()
    {
        return new FloatEnergy((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy log10()
    {
        return new FloatEnergy((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy log1p()
    {
        return new FloatEnergy((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy rint()
    {
        return new FloatEnergy((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy round()
    {
        return new FloatEnergy(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy signum()
    {
        return new FloatEnergy(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy sin()
    {
        return new FloatEnergy((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy sinh()
    {
        return new FloatEnergy((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy sqrt()
    {
        return new FloatEnergy((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy tan()
    {
        return new FloatEnergy((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy tanh()
    {
        return new FloatEnergy((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy inv()
    {
        return new FloatEnergy(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy toDegrees()
    {
        return new FloatEnergy((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy toRadians()
    {
        return new FloatEnergy((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy pow(final double x)
    {
        return new FloatEnergy((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy multiplyBy(final float factor)
    {
        return new FloatEnergy(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative energy
     */
    public final FloatEnergy multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy divideBy(final float divisor)
    {
        return new FloatEnergy(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative energy
     */
    public final FloatEnergy divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatEnergy plus(final FloatEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatEnergy(getInUnit() + v.getInUnit(), getUnit())
            : new FloatEnergy(this.si + v.si, EnergyUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatEnergy minus(final FloatEnergy v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatEnergy(getInUnit() - v.getInUnit(), getUnit())
            : new FloatEnergy(this.si - v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatEnergy, which results in a FloatDimensionless scalar.
     * @param v FloatEnergy scalar
     * @return FloatDimensionless scalar as a division of FloatEnergy and FloatEnergy
     */
    public final FloatDimensionless.Rel divideBy(final FloatEnergy v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatForce, which results in a FloatLength scalar.
     * @param v FloatEnergy scalar
     * @return FloatLength scalar as a division of FloatEnergy and FloatForce
     */
    public final FloatLength.Rel divideBy(final FloatForce v)
    {
        return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatLength, which results in a FloatForce scalar.
     * @param v FloatEnergy scalar
     * @return FloatForce scalar as a division of FloatEnergy and FloatLength
     */
    public final FloatForce divideBy(final FloatLength.Rel v)
    {
        return new FloatForce(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatEnergy and FloatLinearDensity, which results in a FloatForce scalar.
     * @param v FloatEnergy scalar
     * @return FloatForce scalar as a multiplication of FloatEnergy and FloatLinearDensity
     */
    public final FloatForce multiplyBy(final FloatLinearDensity v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatTime, which results in a FloatPower scalar.
     * @param v FloatEnergy scalar
     * @return FloatPower scalar as a division of FloatEnergy and FloatTime
     */
    public final FloatPower divideBy(final FloatTime.Rel v)
    {
        return new FloatPower(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatPower, which results in a FloatTime scalar.
     * @param v FloatEnergy scalar
     * @return FloatTime scalar as a division of FloatEnergy and FloatPower
     */
    public final FloatTime.Rel divideBy(final FloatPower v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of FloatEnergy and FloatVolume, which results in a FloatPressure scalar.
     * @param v FloatEnergy scalar
     * @return FloatPressure scalar as a division of FloatEnergy and FloatVolume
     */
    public final FloatPressure divideBy(final FloatVolume v)
    {
        return new FloatPressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatEnergy and FloatFrequency, which results in a FloatPower scalar.
     * @param v FloatEnergy scalar
     * @return FloatPower scalar as a multiplication of FloatEnergy and FloatFrequency
     */
    public final FloatPower multiplyBy(final FloatFrequency v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatEnergy and FloatMoneyPerEnergy, which results in a FloatMoney scalar.
     * @param v FloatEnergy scalar
     * @return FloatMoney scalar as a multiplication of FloatEnergy and FloatMoneyPerEnergy
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerEnergy v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
