package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerDuration FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerDurationUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerDurationUnit&gt;(100.0, MoneyPerDurationUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerDuration value = new FloatMoneyPerDuration(100.0, MoneyPerDurationUnit.SI);
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
public class FloatMoneyPerDuration extends AbstractFloatScalarRel<MoneyPerDurationUnit, FloatMoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerDuration scalar.
     * @param value float; float value
     * @param unit MoneyPerDurationUnit; unit for the float value
     */
    public FloatMoneyPerDuration(final float value, final MoneyPerDurationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerDuration scalar.
     * @param value FloatMoneyPerDuration; Scalar from which to construct this instance
     */
    public FloatMoneyPerDuration(final FloatMoneyPerDuration value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerDuration scalar using a double value.
     * @param value double; double value
     * @param unit MoneyPerDurationUnit; unit for the resulting float value
     */
    public FloatMoneyPerDuration(final double value, final MoneyPerDurationUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerDuration instantiateRel(final float value, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDuration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatMoneyPerDuration; the low value
     * @param one FloatMoneyPerDuration; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerDuration interpolate(final FloatMoneyPerDuration zero, final FloatMoneyPerDuration one,
            final float ratio)
    {
        return new FloatMoneyPerDuration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 FloatMoneyPerDuration; the first scalar
     * @param r2 FloatMoneyPerDuration; the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerDuration max(final FloatMoneyPerDuration r1, final FloatMoneyPerDuration r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 FloatMoneyPerDuration; the first scalar
     * @param r2 FloatMoneyPerDuration; the second scalar
     * @param rn FloatMoneyPerDuration...; the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static FloatMoneyPerDuration max(final FloatMoneyPerDuration r1, final FloatMoneyPerDuration r2,
            final FloatMoneyPerDuration... rn)
    {
        FloatMoneyPerDuration maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerDuration r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two monetary scalars.
     * @param r1 FloatMoneyPerDuration; the first scalar
     * @param r2 FloatMoneyPerDuration; the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static FloatMoneyPerDuration min(final FloatMoneyPerDuration r1, final FloatMoneyPerDuration r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 FloatMoneyPerDuration; the first scalar
     * @param r2 FloatMoneyPerDuration; the second scalar
     * @param rn FloatMoneyPerDuration...; the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static FloatMoneyPerDuration min(final FloatMoneyPerDuration r1, final FloatMoneyPerDuration r2,
            final FloatMoneyPerDuration... rn)
    {
        FloatMoneyPerDuration minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerDuration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoneyPerDuration and FloatMoneyPerDuration, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerDuration; FloatMoneyPerDuration scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerDuration and FloatMoneyPerDuration
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerDuration v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerDuration and FloatDuration, which results in a FloatMoney scalar.
     * @param v FloatDuration; FloatMoneyPerDuration scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerDuration and FloatDuration
     */
    public final FloatMoney multiplyBy(final FloatDuration v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerDuration and FloatFrequency, which results in a FloatMoney scalar.
     * @param v FloatFrequency; FloatMoneyPerDuration scalar
     * @return FloatMoney scalar as a division of FloatMoneyPerDuration and FloatFrequency
     */
    public final FloatMoney divideBy(final FloatFrequency v)
    {
        return new FloatMoney(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
