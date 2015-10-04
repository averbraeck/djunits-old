package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Power FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;PowerUnit&gt; value = new FloatScalar.Rel&lt;PowerUnit&gt;(100.0, PowerUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatPower value = new FloatPower(100.0, PowerUnit.SI);</i><br>
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
public class FloatPower extends FloatScalar.Rel<PowerUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatPower scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPower(final float value, final PowerUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPower scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatPower(final double value, final PowerUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatPower scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPower(final FloatScalar.Rel<PowerUnit> value)
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
    public static FloatPower interpolate(final FloatPower zero, final FloatPower one, final float ratio)
    {
        return new FloatPower(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPower interpolate(final FloatPower zero, final FloatPower one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower abs()
    {
        return new FloatPower(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower acos()
    {
        return new FloatPower((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower asin()
    {
        return new FloatPower((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower atan()
    {
        return new FloatPower((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower cbrt()
    {
        return new FloatPower((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower ceil()
    {
        return new FloatPower((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower cos()
    {
        return new FloatPower((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower cosh()
    {
        return new FloatPower((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower exp()
    {
        return new FloatPower((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower expm1()
    {
        return new FloatPower((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower floor()
    {
        return new FloatPower((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower log()
    {
        return new FloatPower((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower log10()
    {
        return new FloatPower((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower log1p()
    {
        return new FloatPower((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower rint()
    {
        return new FloatPower((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower round()
    {
        return new FloatPower(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower signum()
    {
        return new FloatPower(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower sin()
    {
        return new FloatPower((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower sinh()
    {
        return new FloatPower((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower sqrt()
    {
        return new FloatPower((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower tan()
    {
        return new FloatPower((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower tanh()
    {
        return new FloatPower((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower inv()
    {
        return new FloatPower(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower toDegrees()
    {
        return new FloatPower((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower toRadians()
    {
        return new FloatPower((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower pow(final double x)
    {
        return new FloatPower((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower multiplyBy(final float factor)
    {
        return new FloatPower(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative power
     */
    public final FloatPower multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower divideBy(final float divisor)
    {
        return new FloatPower(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative power
     */
    public final FloatPower divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatPower plus(final FloatPower v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatPower(getInUnit() + v.getInUnit(), getUnit()) : new FloatPower(this.si
            + v.si, PowerUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatPower minus(final FloatPower v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatPower(getInUnit() - v.getInUnit(), getUnit()) : new FloatPower(this.si
            - v.si, PowerUnit.SI);
    }
        /**
         * Calculate the division of FloatPower and FloatPower, which results in a FloatDimensionless scalar.
         * @param v FloatPower scalar
         * @return FloatDimensionless scalar as a division of FloatPower and FloatPower
         */
        public final FloatDimensionless.Rel divideBy(final FloatPower v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatPower and FloatTime, which results in a FloatEnergy scalar.
         * @param v FloatPower scalar
         * @return FloatEnergy scalar as a multiplication of FloatPower and FloatTime
         */
        public final FloatEnergy multiplyBy(final FloatTime.Rel v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatFrequency, which results in a FloatEnergy scalar.
         * @param v FloatPower scalar
         * @return FloatEnergy scalar as a division of FloatPower and FloatFrequency
         */
        public final FloatEnergy divideBy(final FloatFrequency v)
        {
            return new FloatEnergy(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatEnergy, which results in a FloatFrequency scalar.
         * @param v FloatPower scalar
         * @return FloatFrequency scalar as a division of FloatPower and FloatEnergy
         */
        public final FloatFrequency divideBy(final FloatEnergy v)
        {
            return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatSpeed, which results in a FloatForce scalar.
         * @param v FloatPower scalar
         * @return FloatForce scalar as a division of FloatPower and FloatSpeed
         */
        public final FloatForce divideBy(final FloatSpeed v)
        {
            return new FloatForce(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatForce, which results in a FloatSpeed scalar.
         * @param v FloatPower scalar
         * @return FloatSpeed scalar as a division of FloatPower and FloatForce
         */
        public final FloatSpeed divideBy(final FloatForce v)
        {
            return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatElectricalPotential, which results in a FloatElectricalCurrent scalar.
         * @param v FloatPower scalar
         * @return FloatElectricalCurrent scalar as a division of FloatPower and FloatElectricalPotential
         */
        public final FloatElectricalCurrent divideBy(final FloatElectricalPotential v)
        {
            return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of FloatPower and FloatElectricalCurrent, which results in a FloatElectricalPotential scalar.
         * @param v FloatPower scalar
         * @return FloatElectricalPotential scalar as a division of FloatPower and FloatElectricalCurrent
         */
        public final FloatElectricalPotential divideBy(final FloatElectricalCurrent v)
        {
            return new FloatElectricalPotential(this.si / v.si, ElectricalPotentialUnit.SI);
        }


}
