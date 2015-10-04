package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the FlowMass FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;FlowMassUnit&gt; value = new FloatScalar.Rel&lt;FlowMassUnit&gt;(100.0, FlowMassUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatFlowMass value = new FloatFlowMass(100.0, FlowMassUnit.SI);</i><br>
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
public class FloatFlowMass extends FloatScalar.Rel<FlowMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatFlowMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFlowMass(final float value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowMass scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatFlowMass(final double value, final FlowMassUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatFlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowMass(final FloatScalar.Rel<FlowMassUnit> value)
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
    public static FloatFlowMass interpolate(final FloatFlowMass zero, final FloatFlowMass one, final float ratio)
    {
        return new FloatFlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowMass interpolate(final FloatFlowMass zero, final FloatFlowMass one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass abs()
    {
        return new FloatFlowMass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass acos()
    {
        return new FloatFlowMass((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass asin()
    {
        return new FloatFlowMass((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass atan()
    {
        return new FloatFlowMass((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass cbrt()
    {
        return new FloatFlowMass((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass ceil()
    {
        return new FloatFlowMass((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass cos()
    {
        return new FloatFlowMass((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass cosh()
    {
        return new FloatFlowMass((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass exp()
    {
        return new FloatFlowMass((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass expm1()
    {
        return new FloatFlowMass((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass floor()
    {
        return new FloatFlowMass((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass log()
    {
        return new FloatFlowMass((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass log10()
    {
        return new FloatFlowMass((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass log1p()
    {
        return new FloatFlowMass((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass rint()
    {
        return new FloatFlowMass((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass round()
    {
        return new FloatFlowMass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass signum()
    {
        return new FloatFlowMass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass sin()
    {
        return new FloatFlowMass((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass sinh()
    {
        return new FloatFlowMass((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass sqrt()
    {
        return new FloatFlowMass((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass tan()
    {
        return new FloatFlowMass((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass tanh()
    {
        return new FloatFlowMass((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass inv()
    {
        return new FloatFlowMass(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass toDegrees()
    {
        return new FloatFlowMass((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass toRadians()
    {
        return new FloatFlowMass((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass pow(final double x)
    {
        return new FloatFlowMass((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass multiplyBy(final float factor)
    {
        return new FloatFlowMass(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative flowmass
     */
    public final FloatFlowMass multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMass divideBy(final float divisor)
    {
        return new FloatFlowMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative flowmass
     */
    public final FloatFlowMass divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatFlowMass plus(final FloatFlowMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFlowMass(getInUnit() + v.getInUnit(), getUnit()) : new FloatFlowMass(this.si
            + v.si, FlowMassUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatFlowMass minus(final FloatFlowMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatFlowMass(getInUnit() - v.getInUnit(), getUnit()) : new FloatFlowMass(this.si
            - v.si, FlowMassUnit.SI);
    }
        /**
         * Calculate the division of FloatFlowMass and FloatFlowMass, which results in a FloatDimensionless scalar.
         * @param v FloatFlowMass scalar
         * @return FloatDimensionless scalar as a division of FloatFlowMass and FloatFlowMass
         */
        public final FloatDimensionless.Rel divideBy(final FloatFlowMass v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFlowMass and FloatTime, which results in a FloatMass scalar.
         * @param v FloatFlowMass scalar
         * @return FloatMass scalar as a multiplication of FloatFlowMass and FloatTime
         */
        public final FloatMass multiplyBy(final FloatTime.Rel v)
        {
            return new FloatMass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowMass and FloatFrequency, which results in a FloatMass scalar.
         * @param v FloatFlowMass scalar
         * @return FloatMass scalar as a division of FloatFlowMass and FloatFrequency
         */
        public final FloatMass divideBy(final FloatFrequency v)
        {
            return new FloatMass(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FloatFlowMass and FloatMass, which results in a FloatFrequency scalar.
         * @param v FloatFlowMass scalar
         * @return FloatFrequency scalar as a division of FloatFlowMass and FloatMass
         */
        public final FloatFrequency divideBy(final FloatMass v)
        {
            return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFlowMass and FloatSpeed, which results in a FloatForce scalar.
         * @param v FloatFlowMass scalar
         * @return FloatForce scalar as a multiplication of FloatFlowMass and FloatSpeed
         */
        public final FloatForce multiplyBy(final FloatSpeed v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }


}
