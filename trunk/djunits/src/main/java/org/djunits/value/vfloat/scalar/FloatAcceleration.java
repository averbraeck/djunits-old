package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Acceleration FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AccelerationUnit&gt; value = new FloatScalar.Rel&lt;AccelerationUnit&gt;(100.0,
 * AccelerationUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatAcceleration value = new FloatAcceleration(100.0, AccelerationUnit.SI);</i><br>
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
public class FloatAcceleration extends TypedFloatScalarRel<AccelerationUnit, FloatAcceleration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatAcceleration scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAcceleration(final float value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAcceleration scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAcceleration(final FloatAcceleration value)
    {
        super(value);
    }

    /**
     * Construct FloatAcceleration scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatAcceleration(final double value, final AccelerationUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAcceleration instantiateTypeRel(final float value, final AccelerationUnit unit)
    {
        return new FloatAcceleration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAcceleration interpolate(final FloatAcceleration zero, final FloatAcceleration one,
        final float ratio)
    {
        return new FloatAcceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of FloatAcceleration and FloatAcceleration, which results in a FloatDimensionless scalar.
     * @param v FloatAcceleration scalar
     * @return FloatDimensionless scalar as a division of FloatAcceleration and FloatAcceleration
     */
    public final FloatDimensionless.Rel divideBy(final FloatAcceleration v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatMass, which results in a FloatForce scalar.
     * @param v FloatAcceleration scalar
     * @return FloatForce scalar as a multiplication of FloatAcceleration and FloatMass
     */
    public final FloatForce multiplyBy(final FloatMass v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatTime, which results in a FloatSpeed scalar.
     * @param v FloatAcceleration scalar
     * @return FloatSpeed scalar as a multiplication of FloatAcceleration and FloatTime
     */
    public final FloatSpeed multiplyBy(final FloatTime.Rel v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatFrequency, which results in a FloatSpeed scalar.
     * @param v FloatAcceleration scalar
     * @return FloatSpeed scalar as a division of FloatAcceleration and FloatFrequency
     */
    public final FloatSpeed divideBy(final FloatFrequency v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatSpeed, which results in a FloatFrequency scalar.
     * @param v FloatAcceleration scalar
     * @return FloatFrequency scalar as a division of FloatAcceleration and FloatSpeed
     */
    public final FloatFrequency divideBy(final FloatSpeed v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

}
