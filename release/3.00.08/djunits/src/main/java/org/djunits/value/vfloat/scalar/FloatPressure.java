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
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPressure extends AbstractFloatScalarRel<PressureUnit, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPressure ZERO = new FloatPressure(0.0f, PressureUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatPressure NaN = new FloatPressure(Float.NaN, PressureUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatPressure POSITIVE_INFINITY = new FloatPressure(Float.POSITIVE_INFINITY, PressureUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatPressure NEGATIVE_INFINITY = new FloatPressure(Float.NEGATIVE_INFINITY, PressureUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatPressure POS_MAXVALUE = new FloatPressure(Float.MAX_VALUE, PressureUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatPressure NEG_MAXVALUE = new FloatPressure(-Float.MAX_VALUE, PressureUnit.SI);

    /**
     * Construct FloatPressure scalar.
     * @param value float; float value
     * @param unit PressureUnit; unit for the float value
     */
    public FloatPressure(final float value, final PressureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPressure scalar.
     * @param value FloatPressure; Scalar from which to construct this instance
     */
    public FloatPressure(final FloatPressure value)
    {
        super(value);
    }

    /**
     * Construct FloatPressure scalar using a double value.
     * @param value double; double value
     * @param unit PressureUnit; unit for the resulting float value
     */
    public FloatPressure(final double value, final PressureUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure instantiateRel(final float value, final PressureUnit unit)
    {
        return new FloatPressure(value, unit);
    }

    /**
     * Construct FloatPressure scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatPressure createSI(final float value)
    {
        return new FloatPressure(value, PressureUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatPressure; the low value
     * @param one FloatPressure; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPressure interpolate(final FloatPressure zero, final FloatPressure one, final float ratio)
    {
        return new FloatPressure(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatPressure; the first scalar
     * @param r2 FloatPressure; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatPressure max(final FloatPressure r1, final FloatPressure r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatPressure; the first scalar
     * @param r2 FloatPressure; the second scalar
     * @param rn FloatPressure...; the other scalars
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
     * @param r1 FloatPressure; the first scalar
     * @param r2 FloatPressure; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatPressure min(final FloatPressure r1, final FloatPressure r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatPressure; the first scalar
     * @param r2 FloatPressure; the second scalar
     * @param rn FloatPressure...; the other scalars
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
     * @param v FloatPressure; FloatPressure scalar
     * @return FloatDimensionless scalar as a division of FloatPressure and FloatPressure
     */
    public final FloatDimensionless divideBy(final FloatPressure v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatPressure and FloatArea, which results in a FloatForce scalar.
     * @param v FloatArea; FloatPressure scalar
     * @return FloatForce scalar as a multiplication of FloatPressure and FloatArea
     */
    public final FloatForce multiplyBy(final FloatArea v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatPressure and FloatVolume, which results in a FloatEnergy scalar.
     * @param v FloatVolume; FloatPressure scalar
     * @return FloatEnergy scalar as a multiplication of FloatPressure and FloatVolume
     */
    public final FloatEnergy multiplyBy(final FloatVolume v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

}
