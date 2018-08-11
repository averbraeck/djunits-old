package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;

/**
 * Easy access methods for the ElectricalCharge FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;ElectricalChargeUnit&gt; value = new FloatScalar.Rel&lt;ElectricalChargeUnit&gt;(100.0, ElectricalChargeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatElectricalCharge value = new FloatElectricalCharge(100.0, ElectricalChargeUnit.SI);
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
public class FloatElectricalCharge extends AbstractFloatScalarRel<ElectricalChargeUnit, FloatElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalCharge ZERO = new FloatElectricalCharge(0.0f, ElectricalChargeUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalCharge NaN = new FloatElectricalCharge(Float.NaN, ElectricalChargeUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalCharge POSITIVE_INFINITY =
            new FloatElectricalCharge(Float.POSITIVE_INFINITY, ElectricalChargeUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalCharge NEGATIVE_INFINITY =
            new FloatElectricalCharge(Float.NEGATIVE_INFINITY, ElectricalChargeUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalCharge POS_MAXVALUE =
            new FloatElectricalCharge(Float.MAX_VALUE, ElectricalChargeUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalCharge NEG_MAXVALUE =
            new FloatElectricalCharge(-Float.MAX_VALUE, ElectricalChargeUnit.SI);

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalCharge(final float value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalCharge(final FloatElectricalCharge value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalCharge scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCharge instantiateRel(final float value, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalCharge(value, unit);
    }

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalCharge createSI(final float value)
    {
        return new FloatElectricalCharge(value, ElectricalChargeUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCharge interpolate(final FloatElectricalCharge zero, final FloatElectricalCharge one,
            final float ratio)
    {
        return new FloatElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalCharge max(final FloatElectricalCharge r1, final FloatElectricalCharge r2)
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
    public static FloatElectricalCharge max(final FloatElectricalCharge r1, final FloatElectricalCharge r2,
            final FloatElectricalCharge... rn)
    {
        FloatElectricalCharge maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalCharge r : rn)
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
    public static FloatElectricalCharge min(final FloatElectricalCharge r1, final FloatElectricalCharge r2)
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
    public static FloatElectricalCharge min(final FloatElectricalCharge r1, final FloatElectricalCharge r2,
            final FloatElectricalCharge... rn)
    {
        FloatElectricalCharge minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalCharge r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCharge, which results in a FloatDimensionless scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalCharge and FloatElectricalCharge
     */
    public final FloatDimensionless divideBy(final FloatElectricalCharge v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatDuration, which results in a FloatElectricalCurrent scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatElectricalCurrent scalar as a division of FloatElectricalCharge and FloatDuration
     */
    public final FloatElectricalCurrent divideBy(final FloatDuration v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCurrent, which results in a FloatDuration scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatDuration scalar as a division of FloatElectricalCharge and FloatElectricalCurrent
     */
    public final FloatDuration divideBy(final FloatElectricalCurrent v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

}
