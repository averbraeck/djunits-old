package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Torque FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;TorqueUnit&gt; value = new FloatScalar.Rel&lt;TorqueUnit&gt;(100.0, TorqueUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatTorque value = new FloatTorque(100.0, TorqueUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTorque extends AbstractFloatScalarRel<TorqueUnit, FloatTorque>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatTorque ZERO = new FloatTorque(0.0f, TorqueUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatTorque NaN = new FloatTorque(Float.NaN, TorqueUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatTorque POSITIVE_INFINITY = new FloatTorque(Float.POSITIVE_INFINITY, TorqueUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatTorque NEGATIVE_INFINITY = new FloatTorque(Float.NEGATIVE_INFINITY, TorqueUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatTorque POS_MAXVALUE = new FloatTorque(Float.MAX_VALUE, TorqueUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatTorque NEG_MAXVALUE = new FloatTorque(-Float.MAX_VALUE, TorqueUnit.SI);

    /**
     * Construct FloatTorque scalar.
     * @param value float; float value
     * @param unit TorqueUnit; unit for the float value
     */
    public FloatTorque(final float value, final TorqueUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatTorque scalar.
     * @param value FloatTorque; Scalar from which to construct this instance
     */
    public FloatTorque(final FloatTorque value)
    {
        super(value);
    }

    /**
     * Construct FloatTorque scalar using a double value.
     * @param value double; double value
     * @param unit TorqueUnit; unit for the resulting float value
     */
    public FloatTorque(final double value, final TorqueUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorque instantiateRel(final float value, final TorqueUnit unit)
    {
        return new FloatTorque(value, unit);
    }

    /**
     * Construct FloatTorque scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatTorque createSI(final float value)
    {
        return new FloatTorque(value, TorqueUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatTorque; the low value
     * @param one FloatTorque; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatTorque interpolate(final FloatTorque zero, final FloatTorque one, final float ratio)
    {
        return new FloatTorque(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatTorque; the first scalar
     * @param r2 FloatTorque; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatTorque max(final FloatTorque r1, final FloatTorque r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatTorque; the first scalar
     * @param r2 FloatTorque; the second scalar
     * @param rn FloatTorque...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatTorque max(final FloatTorque r1, final FloatTorque r2, final FloatTorque... rn)
    {
        FloatTorque maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatTorque r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 FloatTorque; the first scalar
     * @param r2 FloatTorque; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatTorque min(final FloatTorque r1, final FloatTorque r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatTorque; the first scalar
     * @param r2 FloatTorque; the second scalar
     * @param rn FloatTorque...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatTorque min(final FloatTorque r1, final FloatTorque r2, final FloatTorque... rn)
    {
        FloatTorque minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatTorque r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatTorque and FloatTorque, which results in a FloatDimensionless scalar.
     * @param v FloatTorque; FloatTorque scalar
     * @return FloatDimensionless scalar as a division of FloatTorque and FloatTorque
     */
    public final FloatDimensionless divideBy(final FloatTorque v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatForce, which results in a FloatLength scalar.
     * @param v FloatForce; FloatTorque scalar
     * @return FloatLength scalar as a division of FloatTorque and FloatForce
     */
    public final FloatLength divideBy(final FloatForce v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatLength, which results in a FloatForce scalar.
     * @param v FloatLength; FloatTorque scalar
     * @return FloatForce scalar as a division of FloatTorque and FloatLength
     */
    public final FloatForce divideBy(final FloatLength v)
    {
        return new FloatForce(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatTorque and FloatLinearDensity, which results in a FloatForce scalar.
     * @param v FloatLinearDensity; FloatTorque scalar
     * @return FloatForce scalar as a multiplication of FloatTorque and FloatLinearDensity
     */
    public final FloatForce multiplyBy(final FloatLinearDensity v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatDuration, which results in a FloatPower scalar.
     * @param v FloatDuration; FloatTorque scalar
     * @return FloatPower scalar as a division of FloatTorque and FloatDuration
     */
    public final FloatPower divideBy(final FloatDuration v)
    {
        return new FloatPower(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatPower, which results in a FloatDuration scalar.
     * @param v FloatPower; FloatTorque scalar
     * @return FloatDuration scalar as a division of FloatTorque and FloatPower
     */
    public final FloatDuration divideBy(final FloatPower v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatTorque and FloatFrequency, which results in a FloatPower scalar.
     * @param v FloatFrequency; FloatTorque scalar
     * @return FloatPower scalar as a multiplication of FloatTorque and FloatFrequency
     */
    public final FloatPower multiplyBy(final FloatFrequency v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatVolume, which results in a FloatPressure scalar.
     * @param v FloatVolume; FloatTorque scalar
     * @return FloatPressure scalar as a division of FloatTorque and FloatVolume
     */
    public final FloatPressure divideBy(final FloatVolume v)
    {
        return new FloatPressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of FloatTorque and FloatPressure, which results in a FloatVolume scalar.
     * @param v FloatPressure; FloatTorque scalar
     * @return FloatVolume scalar as a division of FloatTorque and FloatPressure
     */
    public final FloatVolume divideBy(final FloatPressure v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

}
