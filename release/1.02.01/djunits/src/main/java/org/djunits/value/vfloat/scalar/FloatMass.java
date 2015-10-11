package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Mass FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MassUnit&gt; value = new FloatScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMass value = new FloatMass(100.0, MassUnit.SI);</i><br>
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
public class FloatMass extends FloatScalar.Rel<MassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMass(final float value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMass scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMass(final double value, final MassUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMass(final FloatScalar.Rel<MassUnit> value)
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
    public static FloatMass interpolate(final FloatMass zero, final FloatMass one, final float ratio)
    {
        return new FloatMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMass interpolate(final FloatMass zero, final FloatMass one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass abs()
    {
        return new FloatMass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass acos()
    {
        return new FloatMass((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass asin()
    {
        return new FloatMass((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass atan()
    {
        return new FloatMass((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass cbrt()
    {
        return new FloatMass((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass ceil()
    {
        return new FloatMass((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass cos()
    {
        return new FloatMass((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass cosh()
    {
        return new FloatMass((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass exp()
    {
        return new FloatMass((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass expm1()
    {
        return new FloatMass((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass floor()
    {
        return new FloatMass((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass log()
    {
        return new FloatMass((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass log10()
    {
        return new FloatMass((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass log1p()
    {
        return new FloatMass((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass rint()
    {
        return new FloatMass((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass round()
    {
        return new FloatMass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass signum()
    {
        return new FloatMass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass sin()
    {
        return new FloatMass((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass sinh()
    {
        return new FloatMass((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass sqrt()
    {
        return new FloatMass((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass tan()
    {
        return new FloatMass((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass tanh()
    {
        return new FloatMass((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass inv()
    {
        return new FloatMass(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass toDegrees()
    {
        return new FloatMass((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass toRadians()
    {
        return new FloatMass((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass pow(final double x)
    {
        return new FloatMass((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass multiplyBy(final float factor)
    {
        return new FloatMass(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative mass
     */
    public final FloatMass multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass divideBy(final float divisor)
    {
        return new FloatMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative mass
     */
    public final FloatMass divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMass plus(final FloatMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMass(getInUnit() + v.getInUnit(), getUnit()) : new FloatMass(
            this.si + v.si, MassUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMass minus(final FloatMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMass(getInUnit() - v.getInUnit(), getUnit()) : new FloatMass(
            this.si - v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatMass, which results in a FloatDimensionless scalar.
     * @param v FloatMass scalar
     * @return FloatDimensionless scalar as a division of FloatMass and FloatMass
     */
    public final FloatDimensionless.Rel divideBy(final FloatMass v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatFlowMass, which results in a FloatTime scalar.
     * @param v FloatMass scalar
     * @return FloatTime scalar as a division of FloatMass and FloatFlowMass
     */
    public final FloatTime.Rel divideBy(final FloatFlowMass v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatTime, which results in a FloatFlowMass scalar.
     * @param v FloatMass scalar
     * @return FloatFlowMass scalar as a division of FloatMass and FloatTime
     */
    public final FloatFlowMass divideBy(final FloatTime.Rel v)
    {
        return new FloatFlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatAcceleration, which results in a FloatForce scalar.
     * @param v FloatMass scalar
     * @return FloatForce scalar as a multiplication of FloatMass and FloatAcceleration
     */
    public final FloatForce multiplyBy(final FloatAcceleration v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatFrequency, which results in a FloatFlowMass scalar.
     * @param v FloatMass scalar
     * @return FloatFlowMass scalar as a multiplication of FloatMass and FloatFrequency
     */
    public final FloatFlowMass multiplyBy(final FloatFrequency v)
    {
        return new FloatFlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatDensity, which results in a FloatVolume scalar.
     * @param v FloatMass scalar
     * @return FloatVolume scalar as a division of FloatMass and FloatDensity
     */
    public final FloatVolume divideBy(final FloatDensity v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatVolume, which results in a FloatDensity scalar.
     * @param v FloatMass scalar
     * @return FloatDensity scalar as a division of FloatMass and FloatVolume
     */
    public final FloatDensity divideBy(final FloatVolume v)
    {
        return new FloatDensity(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatMoneyPerMass, which results in a FloatMoney scalar.
     * @param v FloatMass scalar
     * @return FloatMoney scalar as a multiplication of FloatMass and FloatMoneyPerMass
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerMass v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
