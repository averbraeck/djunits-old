package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;

/**
 * Easy access methods for the Pressure FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;PressureUnit&gt; value = new FloatScalar.Rel&lt;PressureUnit&gt;(100.0, PressureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatPressure value = new FloatPressure(100.0, PressureUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPressure extends TypedFloatScalarRel<PressureUnit, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPressure ZERO = new FloatPressure(0.0f, PressureUnit.SI);

    /**
     * Construct FloatPressure scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPressure(final float value, final PressureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPressure scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPressure(final FloatPressure value)
    {
        super(value);
    }

    /**
     * Construct FloatPressure scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatPressure(final double value, final PressureUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressure instantiateTypeRel(final float value, final PressureUnit unit)
    {
        return new FloatPressure(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPressure interpolate(final FloatPressure zero, final FloatPressure one, final float ratio)
    {
        return new FloatPressure(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatPressure max(final FloatPressure r1, final FloatPressure r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatPressure max(final FloatPressure r1, final FloatPressure r2, final FloatPressure... rn)
    {
        FloatPressure maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatPressure r : rn)
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
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatPressure min(final FloatPressure r1, final FloatPressure r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatPressure min(final FloatPressure r1, final FloatPressure r2, final FloatPressure... rn)
    {
        FloatPressure minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatPressure r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatPressure and FloatPressure, which results in a FloatDimensionless scalar.
     * @param v FloatPressure scalar
     * @return FloatDimensionless scalar as a division of FloatPressure and FloatPressure
     */
    public final FloatDimensionless divideBy(final FloatPressure v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatPressure and FloatArea, which results in a FloatForce scalar.
     * @param v FloatPressure scalar
     * @return FloatForce scalar as a multiplication of FloatPressure and FloatArea
     */
    public final FloatForce multiplyBy(final FloatArea v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatPressure and FloatVolume, which results in a FloatEnergy scalar.
     * @param v FloatPressure scalar
     * @return FloatEnergy scalar as a multiplication of FloatPressure and FloatVolume
     */
    public final FloatEnergy multiplyBy(final FloatVolume v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

}
