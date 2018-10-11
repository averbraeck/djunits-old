package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalCurrent FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;ElectricalCurrentUnit&gt; value = new FloatScalar.Rel&lt;ElectricalCurrentUnit&gt;(100.0, ElectricalCurrentUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatElectricalCurrent value = new FloatElectricalCurrent(100.0, ElectricalCurrentUnit.SI);
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
public class FloatElectricalCurrent extends AbstractFloatScalarRel<ElectricalCurrentUnit, FloatElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalCurrent ZERO = new FloatElectricalCurrent(0.0f, ElectricalCurrentUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalCurrent NaN = new FloatElectricalCurrent(Float.NaN, ElectricalCurrentUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalCurrent POSITIVE_INFINITY =
            new FloatElectricalCurrent(Float.POSITIVE_INFINITY, ElectricalCurrentUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalCurrent NEGATIVE_INFINITY =
            new FloatElectricalCurrent(Float.NEGATIVE_INFINITY, ElectricalCurrentUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalCurrent POS_MAXVALUE =
            new FloatElectricalCurrent(Float.MAX_VALUE, ElectricalCurrentUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalCurrent NEG_MAXVALUE =
            new FloatElectricalCurrent(-Float.MAX_VALUE, ElectricalCurrentUnit.SI);

    /**
     * Construct FloatElectricalCurrent scalar.
     * @param value float; float value
     * @param unit ElectricalCurrentUnit; unit for the float value
     */
    public FloatElectricalCurrent(final float value, final ElectricalCurrentUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCurrent scalar.
     * @param value FloatElectricalCurrent; Scalar from which to construct this instance
     */
    public FloatElectricalCurrent(final FloatElectricalCurrent value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalCurrent scalar using a double value.
     * @param value double; double value
     * @param unit ElectricalCurrentUnit; unit for the resulting float value
     */
    public FloatElectricalCurrent(final double value, final ElectricalCurrentUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrent instantiateRel(final float value, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrent(value, unit);
    }

    /**
     * Construct FloatElectricalCurrent scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalCurrent createSI(final float value)
    {
        return new FloatElectricalCurrent(value, ElectricalCurrentUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatElectricalCurrent; the low value
     * @param one FloatElectricalCurrent; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCurrent interpolate(final FloatElectricalCurrent zero, final FloatElectricalCurrent one,
            final float ratio)
    {
        return new FloatElectricalCurrent(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatElectricalCurrent; the first scalar
     * @param r2 FloatElectricalCurrent; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalCurrent max(final FloatElectricalCurrent r1, final FloatElectricalCurrent r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatElectricalCurrent; the first scalar
     * @param r2 FloatElectricalCurrent; the second scalar
     * @param rn FloatElectricalCurrent...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatElectricalCurrent max(final FloatElectricalCurrent r1, final FloatElectricalCurrent r2,
            final FloatElectricalCurrent... rn)
    {
        FloatElectricalCurrent maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalCurrent r : rn)
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
     * @param r1 FloatElectricalCurrent; the first scalar
     * @param r2 FloatElectricalCurrent; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatElectricalCurrent min(final FloatElectricalCurrent r1, final FloatElectricalCurrent r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatElectricalCurrent; the first scalar
     * @param r2 FloatElectricalCurrent; the second scalar
     * @param rn FloatElectricalCurrent...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatElectricalCurrent min(final FloatElectricalCurrent r1, final FloatElectricalCurrent r2,
            final FloatElectricalCurrent... rn)
    {
        FloatElectricalCurrent minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalCurrent r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatElectricalCurrent and FloatElectricalCurrent, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalCurrent; FloatElectricalCurrent scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalCurrent and FloatElectricalCurrent
     */
    public final FloatDimensionless divideBy(final FloatElectricalCurrent v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatElectricalPotential, which results in a FloatPower
     * scalar.
     * @param v FloatElectricalPotential; FloatElectricalCurrent scalar
     * @return FloatPower scalar as a multiplication of FloatElectricalCurrent and FloatElectricalPotential
     */
    public final FloatPower multiplyBy(final FloatElectricalPotential v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatDuration, which results in a FloatElectricalCharge
     * scalar.
     * @param v FloatDuration; FloatElectricalCurrent scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatElectricalCurrent and FloatDuration
     */
    public final FloatElectricalCharge multiplyBy(final FloatDuration v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalCurrent and FloatElectricalResistance, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatElectricalResistance; FloatElectricalCurrent scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatElectricalCurrent and FloatElectricalResistance
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
